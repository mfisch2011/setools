/**
 * TODO:license...
 */
package setools.gradle.dsl.agenda.internal;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.dsl.agenda.AgendaHandler;
import setools.gradle.dsl.agenda.AgendaItem;

/**
 * TODO:documentation...
 */
public class DefaultAgendaHandler implements AgendaHandler {

	protected final ArrayList<AgendaItem> agenda = new ArrayList<AgendaItem>();
	
	@Override
	public AgendaItem topic() {
		DefaultAgendaItem topic = new DefaultAgendaItem();
		agenda.add(topic);
		return topic;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public AgendaItem topic(Closure closure) {
		DefaultAgendaItem topic = new DefaultAgendaItem();
		ConfigureUtil.configure(closure, topic);
		agenda.add(topic);
		return topic;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public AgendaItem topic(String format,Closure closure) throws Exception {
		Class<?> classType = null;
		switch(format) {
		case "Title and Content":
			classType = DefaultTitleAndContent.class;
			break;
		case "Title Only":
			classType = DefaultTitleOnly.class;
			break;
		//TODO:add other standard types...
		default:
			classType = Class.forName(format);
			break;
		}
		Constructor<?> constructor = classType.getConstructor();
		AgendaItem topic = (AgendaItem)constructor.newInstance();
		ConfigureUtil.configure(closure, topic);
		agenda.add(topic);
		return topic;
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
