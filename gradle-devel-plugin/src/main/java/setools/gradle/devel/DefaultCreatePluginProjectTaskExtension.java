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
public class DefaultCreatePluginProjectTaskExtension implements CreatePluginProjectTaskExtension {

	/** TODO:
	 */
	protected final ProjectInternal project;
	
	/** TODO:
	 */
	protected final ObjectFactory objectFactory;
	
	/** TODO:
	 */
	protected final GradleDevelopmentPluginExtension pluginExtension;

	@Inject
	public DefaultCreatePluginProjectTaskExtension(ProjectInternal project,ObjectFactory objectFactory,GradleDevelopmentPluginExtension pluginExtension) {
		this.project = project;
		this.objectFactory = objectFactory;
		this.pluginExtension = pluginExtension;
	}
}
