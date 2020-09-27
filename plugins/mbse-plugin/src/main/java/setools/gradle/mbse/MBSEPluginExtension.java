/**
 * TODO:license...
 */
package setools.gradle.mbse;

import groovy.lang.Closure;
import setools.gradle.mbse.setr.TechnicalReviewHandler;

/**
 * TODO:documentation...
 */
public interface MBSEPluginExtension {

	/**
	 * TODO:documentation...
	 * @return
	 */
	public TechnicalReviewHandler technicalReviews();
	
	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public TechnicalReviewHandler technicalReviews(Closure closure);
	
}
