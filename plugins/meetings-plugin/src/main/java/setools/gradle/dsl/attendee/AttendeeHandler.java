/**
 * TODO:license...
 */
package setools.gradle.dsl.attendee;

import java.util.Collection;

import groovy.lang.Closure;

/**
 * TODO:documentation...
 */
public interface AttendeeHandler extends Collection<Attendee> {

	/**
	 * TODO:documentation...
	 * @return
	 */
	public Attendee attendee();
	
	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Attendee attendee(Closure closure);
	
	/**
	 * TODO:documentation...
	 * @param name
	 * @return
	 */
	public void attendee(String...name);
	
}
