/**
 * TODO:license...
 */
package setools.gradle.meetings.service.agenda;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ServiceLoader;
import java.util.Set;

import groovy.lang.Closure;
import setools.gradle.meetings.dsl.AgendaHandler;
import setools.gradle.meetings.dsl.AgendaItem;
import setools.gradle.meetings.service.Provided;
import setools.gradle.meetings.service.ProvidedInterface;
import setools.gradle.meetings.service.Provider;

/**
 * TODO:documentation...
 */
public class ProxyAgendaHandler implements Collection<AgendaItem> /*TODO:change to AgendaHandler*/
,InvocationHandler {
	
	/**
	 * TODO:documentation...
	 */
	private static ServiceLoader<AgendaProvider> serviceLoader =
			ServiceLoader.load(AgendaProvider.class);
	
	/**
	 * TODO:documentation...
	 */
	protected static final Set<Class<?>> interfaces = new HashSet<Class<?>>();
	
	protected static synchronized Set<Class<?>> interfaces() {
		return interfaces;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected static final Map<Method,Object> providers = new HashMap<Method,Object>();
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	protected static synchronized Map<Method, Object> providers() {
		return providers;
	}
	
	//TODO:how to make this one time initialization
	private static void initialize() {
		Iterator<AgendaProvider> iter = serviceLoader.iterator();
		while(iter.hasNext()) {
			AgendaProvider provider = iter.next();
			Class<?> clazz = provider.getClass();
			//find providers and provided interfaces
			for(Class<?> nested : clazz.getNestMembers()) {
				//test for interface
				if(nested.getAnnotation(ProvidedInterface.class)!=null) {
					interfaces.add(nested);
				} else if(nested.getAnnotation(Provider.class)!=null) {
					try {
						Constructor<?> constructor = nested.getConstructor();
						Object object = constructor.newInstance();
						for(Method method : nested.getMethods()) {
							if(method.getAnnotation(Provided.class)!=null)
								providers.put(method, object);
						}
					} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}
	}
	
	/**
	 * must be created using newInstance factory method
	 */
	protected ProxyAgendaHandler() {
		initialize();
	}
	
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public static AgendaHandler newInstance() {
		Set<Class<?>> interfaces = new HashSet<Class<?>>();
		interfaces.add(AgendaHandler.class);
		interfaces.addAll(interfaces());
		AgendaHandler handler = (AgendaHandler) Proxy.newProxyInstance(
				  ProxyAgendaHandler.class.getClassLoader(), 
				  interfaces.toArray(new Class[] {}), 
				  new ProxyAgendaHandler());
		return handler;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected ArrayList<AgendaItem> agenda = new ArrayList<AgendaItem>();
	
	@Override
	public Object invoke(Object instance, Method method, Object[] arguments) throws Throwable {
		String name = method.getName();
		switch(name) {
		case "toString":
			return toString();
		default:
			System.out.println("Warning unhandled method '" + name + "'.");
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	protected static void printMap(Map<Method,Object> map) {
		for(Entry<Method, Object> entry : map.entrySet()) {
			System.out.printf("KEY: %s, VALUE: %s%n", entry.getKey(),entry.getValue());
		}
	}

	@Override
	public boolean add(AgendaItem topic) {
		return agenda.add(topic);
	}


	@Override
	public boolean addAll(Collection<? extends AgendaItem> topics) {
		return agenda.addAll(topics);
	}


	@Override
	public void clear() {
		agenda.clear();
	}


	@Override
	public boolean contains(Object topic) {
		return agenda.contains(topic);
	}


	@Override
	public boolean containsAll(Collection<?> topics) {
		return agenda.containsAll(topics);
	}


	@Override
	public boolean isEmpty() {
		return agenda.isEmpty();
	}


	@Override
	public Iterator<AgendaItem> iterator() {
		return agenda.iterator();
	}


	@Override
	public boolean remove(Object topic) {
		return agenda.remove(topic);
	}


	@Override
	public boolean removeAll(Collection<?> topics) {
		return agenda.removeAll(topics);
	}


	@Override
	public boolean retainAll(Collection<?> topics) {
		return agenda.retainAll(topics);
	}


	@Override
	public int size() {
		return agenda.size();
	}


	@Override
	public Object[] toArray() {
		return agenda.toArray();
	}


	@Override
	public <T> T[] toArray(T[] arg0) {
		return agenda.toArray(arg0);
	}

}
