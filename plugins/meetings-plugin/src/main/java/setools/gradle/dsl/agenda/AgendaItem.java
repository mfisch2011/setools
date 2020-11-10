/**
 * TODO:license...
 */
package setools.gradle.dsl.agenda;

import java.io.Serializable;
import java.util.Collection;

import groovy.lang.Closure;

/**
 * TODO:documentation...
 */
public interface AgendaItem extends Serializable {

	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getName();
	
	/**
	 * TODO:documentation...
	 * @param name
	 */
	public void setName(String name);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public AgendaHandler subTopics();
	
	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public AgendaHandler subTopics(Closure closure);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public Collection<Object> getDependencies();
	
	/**
	 * TODO:documentation...
	 * @param object
	 */
	public void dependsOn(Object...object);
}
