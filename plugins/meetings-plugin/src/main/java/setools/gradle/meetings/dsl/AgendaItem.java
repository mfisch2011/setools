/**
 * TODO:license...
 */
package setools.gradle.meetings.dsl;

import java.util.Collection;

import groovy.lang.Closure;

/**
 * TODO:documentation...
 */
public interface AgendaItem {
	
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
	public String getTitle();
	
	/**
	 * TODO:documentation...
	 * @param title
	 */
	public void setTitle(String title); 
	
	/**
	 * TODO:documentation...
	 * @param objects
	 */
	public void dependsOn(Object...objects);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public Collection<Object> getDependencies();
	
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
	public String getFormatter();
	
	/**
	 * TODO:documentation...
	 * @param formatter
	 */
	public void setFormatter(String formatter);
	
}
