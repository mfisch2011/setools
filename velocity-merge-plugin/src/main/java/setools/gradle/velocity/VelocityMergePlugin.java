/**
 * 
 */
package setools.gradle.velocity;

import javax.inject.Inject;

import org.gradle.api.Plugin;
import org.gradle.api.internal.project.ProjectInternal;
import org.gradle.api.model.ObjectFactory;

/**
 * @author matt
 *
 */
public class VelocityMergePlugin implements Plugin<ProjectInternal> {

	/** TODO:
	 */
	public static final String PLUGIN_EXT_NAME = "velocity";

	/** TODO:
	 */
	protected final ObjectFactory objectFactory;
	
	/** TODO:
	 */
	protected VelocityMergePluginExtension pluginExtension = null;

	/** TODO: 
	 */
	protected VelocityMergeTask taskVelocityMerge = null;

	/** TODO:
	 * @param objectFactory
	 */
	@Inject
	public VelocityMergePlugin(ObjectFactory objectFactory) {
		this.objectFactory = objectFactory;
	}
	
	@Override
	public void apply(ProjectInternal project) {
		configureExtension(project);
		taskVelocityMerge  = VelocityMergeTask.configureTask(project,null,objectFactory,pluginExtension);
	}

	protected void configureExtension(ProjectInternal project) {
		pluginExtension = project.getExtensions().create(PLUGIN_EXT_NAME, DefaultVelocityMergePluginExtension.class, project,objectFactory);
	}

}
