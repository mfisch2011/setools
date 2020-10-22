/**
 * TODO:license...
 */
package setools.gradle.actions.dsl;

import groovy.lang.Closure;
import setools.gradle.dsl.agenda.TitleAndContent;

/**
 * TODO:documentation...
 */
public interface ActionItemReview extends TitleAndContent {

	/**
	 * TODO:documentation...
	 * @return
	 */
	public ActionItemDatabase actionItems();
	
	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	public ActionItemDatabase actionItems(Closure closure);
}
