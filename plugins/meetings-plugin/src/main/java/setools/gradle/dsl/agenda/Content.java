/**
 * TODO:license...
 */
package setools.gradle.dsl.agenda;

import groovy.lang.Closure;

/**
 * TODO:documentation...
 */
public interface Content {

	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getText();

	/**
	 * TODO:documentation...
	 * @param text
	 */
	public void setText(String text);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public AgendaHandler bullets();

	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public AgendaHandler bullets(Closure closure);
	
	//TODO:add methods for interfacing with image content.
	
}
