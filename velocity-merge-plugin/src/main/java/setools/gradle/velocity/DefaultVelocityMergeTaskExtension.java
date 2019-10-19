/**
 * 
 */
package setools.gradle.velocity;

import javax.inject.Inject;

import org.gradle.api.internal.project.ProjectInternal;
import org.gradle.api.model.ObjectFactory;

/**
 * @author matt
 *
 */
public class DefaultVelocityMergeTaskExtension implements VelocityMergeTaskExtension {

	/** TODO:
	 */
	protected final ProjectInternal project;
	
	/** TODO:
	 */
	protected final ObjectFactory objectFactory;
	
	/** TODO:
	 */
	protected final VelocityMergePluginExtension pluginExtension;

	/** TODO:
	 * @param project
	 * @param objectFactory
	 * @param pluginExtension
	 */
	@Inject
	public DefaultVelocityMergeTaskExtension(ProjectInternal project,ObjectFactory objectFactory,VelocityMergePluginExtension pluginExtension) {
		this.project = project;
		this.objectFactory = objectFactory;
		this.pluginExtension = pluginExtension;
	}
}
