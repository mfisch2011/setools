/**
 * 
 */
package setools.gradle.devel;

import javax.inject.Inject;

import org.gradle.api.Plugin;
import org.gradle.api.internal.project.ProjectInternal;
import org.gradle.api.model.ObjectFactory;

/**
 * @author matt
 *
 */
public class GradleDevelopmentPlugin implements Plugin<ProjectInternal> {

	/** TODO:
	 */
	public static final String PLUGIN_EXT_NAME = "gradleDevel";

	/** TODO:
	 */
	protected final ObjectFactory objectFactory;
	
	/** TODO:
	 */
	protected GradleDevelopmentPluginExtension pluginExtension = null;

	/** TODO:
	 * @param objectFactory
	 */
	@Inject
	public GradleDevelopmentPlugin(ObjectFactory objectFactory) {
		this.objectFactory = objectFactory;
	}
	
	@Override
	public void apply(ProjectInternal project) {
		configureExtension(project);
		taskCreatePluginProject = CreatePluginProjectTask.configureTask(project,null,objectFactory,pluginExtension);
		taskCreateTaskProject = CreateTaskProjectTask.configureTask(project,null,objectFactory,pluginExtension);
	}

	protected void configureExtension(ProjectInternal project) {
		pluginExtension = project.getExtensions().create(PLUGIN_EXT_NAME, DefaultGradleDevelopmentPluginExtension.class, project,objectFactory);
	}

}
