/**
 * TODO:license...
 */
package setools.gradle.dsl.agenda;

import groovy.lang.Closure;

/**
 * TODO:documentation...
 */
public interface TitleAndContent extends TitleOnly {

	/**
	 * TODO:documentation...
	 * @return
	 */
	public Content content();
	
	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Content content(Closure closure);
	
}
