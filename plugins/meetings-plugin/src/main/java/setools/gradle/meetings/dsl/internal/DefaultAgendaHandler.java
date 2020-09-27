/**
 * TODO:license...
 */
package setools.gradle.meetings.dsl.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meetings.dsl.AgendaHandler;
import setools.gradle.meetings.dsl.AgendaItem;


/**
 * TODO:documentation...
 */
public class DefaultAgendaHandler implements AgendaHandler {
	
	/**
	 * TODO:documentation...
	 */
	protected final Collection<AgendaItem> agenda;
	
	/**
	 * TODO:documentation...
	 */
	public DefaultAgendaHandler() {
		agenda = new ArrayList<AgendaItem>();
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

/****************************************************************************
 * REMOVE THESE WHEN WE HAVE A PROXY HANDLER
 ***************************************************************************/
	

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
	
}
