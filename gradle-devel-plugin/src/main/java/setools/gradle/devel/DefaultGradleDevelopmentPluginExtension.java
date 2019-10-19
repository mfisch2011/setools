/**
 * 
 */
package setools.gradle.devel;

import javax.inject.Inject;

import org.gradle.api.internal.project.ProjectInternal;
import org.gradle.api.model.ObjectFactory;

/**
 * @author matt
 *
 */
public class DefaultGradleDevelopmentPluginExtension implements GradleDevelopmentPluginExtension {

	/** TODO:
	 */
	protected final ProjectInternal project;
	
	/** TODO:
	 */
	protected final ObjectFactory objectFactory;
	
	@Inject
	public DefaultGradleDevelopmentPluginExtension(ProjectInternal project,ObjectFactory objectFactory) {
		this.project = project;
		this.objectFactory = objectFactory;
	}
}
