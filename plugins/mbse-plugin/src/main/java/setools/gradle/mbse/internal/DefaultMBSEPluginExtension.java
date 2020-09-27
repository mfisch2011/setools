/**
 * TODO:license...
 */
package setools.gradle.mbse.internal;

import javax.inject.Inject;

import org.gradle.api.Project;
import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.mbse.MBSEPluginExtension;
import setools.gradle.mbse.setr.TechnicalReviewHandler;
import setools.gradle.mbse.setr.internal.DefaultTechnicalReviewHandler;

/**
 * TODO:documentation...
 */
public class DefaultMBSEPluginExtension implements MBSEPluginExtension {

	/**
	 * TODO:documentation...
	 */
	protected final Project project;
	
	protected final TechnicalReviewHandler technicalReviews;
	
	/**
	 * TODO:documentation...
	 * @param project
	 */
	@Inject
	public DefaultMBSEPluginExtension(Project project) {
		this.project = project;
		this.technicalReviews = new DefaultTechnicalReviewHandler();
	}

	@Override
	public TechnicalReviewHandler technicalReviews() {
		return technicalReviews;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public TechnicalReviewHandler technicalReviews(Closure closure) {
		ConfigureUtil.configure(closure, technicalReviews);
		return technicalReviews;
	}
}
