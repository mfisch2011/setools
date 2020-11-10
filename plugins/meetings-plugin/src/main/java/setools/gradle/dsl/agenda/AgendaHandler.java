/**
 * TODO:license...
 */
package setools.gradle.dsl.agenda;

import java.util.Collection;

import groovy.lang.Closure;
import java.io.Serializable;

/**
 * TODO:documentation...
 */
public interface AgendaHandler extends Collection<AgendaItem> {

	/**
	 * TODO:documentation...
	 * @return
	 */
	public AgendaItem topic();

	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public AgendaItem topic(Closure closure);

	/** TODO:modify this once we figure out how to pull type from closure...
	 * TODO:documentation...
	 * @param type
	 * @param closure
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("rawtypes")
	public AgendaItem topic(String format, Closure closure) throws Exception;
	
}
