/**
 * TODO: add NSWC Crane's license...
 */
package setools.gradle.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/**
 * A generic {@link FactoryService} implementation using reflection.
 */
public class AbstractFactoryService<T> implements FactoryService<T> {

	/**
	 * TODO:add documentation...
	 */
	protected Set<Object> registry = new HashSet<Object>();
	
	@Override
	public void register(Object factory) {
		System.out.printf("Registered factory: %s.%n",factory);
		registry.add(factory);
	}

	@Override
	public void unregister(Object factory) {
		System.out.printf("Unregistered factory: %s.%n",factory);
		registry.remove(factory);
	}
	
	/**
	 * TODO:add documentation...
	 * @param text
	 * @return
	 */
	protected static boolean isNullOrEmpty(String text) {
		return text==null || text.isEmpty();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T create(String name, Object... arguments) throws FactoryNotFoundException {
		System.out.printf("Create: %s,%s.%n",name,arguments);
		for(Object factory : registry) {
			System.out.printf("Factory: %s%n",factory);
			Class<?> clazz = null;
			Constructor<?> constructor = null;
			Object instance = null;
			try {
				clazz = (factory instanceof Class) ? (Class<?>)factory : factory.getClass();
				System.out.printf("Class: %s%n", clazz);
				for(Method method : clazz.getMethods()) {
					System.out.printf("Method: %s%n", method);
					Factory annotation = method.getAnnotation(Factory.class);
					System.out.printf("Annotation: %s%n",annotation);
					if(annotation!=null) {
						if(factory instanceof Class) {
							//TODO:enable non-empty constructors ????
							constructor = clazz.getConstructor();
						}
						if(Modifier.isStatic(method.getModifiers()) && constructor!=null) {
							//TODO:enable non-empty constructors ???
							instance = constructor.newInstance();
						}
						
						if(!isNullOrEmpty(annotation.name()) && annotation.name().equals(name)) {
							System.out.printf("Invoke: %s, %s%n",instance,arguments);
							return (T) method.invoke(instance, arguments);
						} else if(method.getName().equals(name)) {
							System.out.printf("Invoke: %s, %s%n",instance,arguments);
							return (T) method.invoke(instance, arguments);
						} else {
							System.out.printf("Skipping: %s%n",method);
						}
					}
				}
			} catch (NoSuchMethodException | SecurityException | InstantiationException |
					IllegalAccessException | IllegalArgumentException |
					InvocationTargetException e) {
				e.printStackTrace(); //TODO: how to logging SLF4J or inject Project ???
			}
		}
		throw new FactoryNotFoundException();
	}

}
