/**
 * TODO:license...
 */
package setools.gradle.dsl.attendee.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.dsl.attendee.Attendee;
import setools.gradle.dsl.attendee.AttendeeHandler;

/**
 * TODO:documentation...
 */
public class DefaultAttendeeHandler implements AttendeeHandler {

	protected final Collection<Attendee> attendees;
	
	public DefaultAttendeeHandler() {
		attendees = new TreeSet<Attendee>();
	}
	
	@Override
	public Attendee attendee() {
		DefaultAttendee attendee = new DefaultAttendee();
		attendees.add(attendee);
		return attendee;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Attendee attendee(Closure closure) {
		DefaultAttendee attendee = new DefaultAttendee();
		ConfigureUtil.configure(closure, attendee);
		attendees.add(attendee);
		return attendee;
	}

	@Override
	public void attendee(String... names) {
		for(String name : names) {
			DefaultAttendee attendee = new DefaultAttendee();
			attendee.setName(name);
			attendees.add(attendee);
		}
	}

	@Override
	public boolean add(Attendee attendee) {
		return attendees.add(attendee);
	}

	@Override
	public boolean addAll(Collection<? extends Attendee> attendees) {
		return this.attendees.addAll(attendees);
	}

	@Override
	public void clear() {
		this.attendees.clear();
	}

	@Override
	public boolean contains(Object attendee) {
		return this.attendees.contains(attendee);
	}

	@Override
	public boolean containsAll(Collection<?> attendees) {
		return this.attendees.containsAll(attendees);
	}

	@Override
	public boolean isEmpty() {
		return this.attendees.isEmpty();
	}

	@Override
	public Iterator<Attendee> iterator() {
		return this.attendees.iterator();
	}

	@Override
	public boolean remove(Object attendee) {
		return this.attendees.remove(attendee);
	}

	@Override
	public boolean removeAll(Collection<?> attendees) {
		return this.attendees.removeAll(attendees);
	}

	@Override
	public boolean retainAll(Collection<?> attendees) {
		return this.attendees.retainAll(attendees);
	}

	@Override
	public int size() {
		return this.attendees.size();
	}

	@Override
	public Object[] toArray() {
		return this.attendees.toArray();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		return this.attendees.toArray(arg0);
	}

}
