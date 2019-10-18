/**
 * 
 */
package setools.gradle.mbse;

import javax.inject.Inject;

import org.gradle.api.internal.project.ProjectInternal;
import org.gradle.api.model.ObjectFactory;

/**
 * @author matt
 *
 */
public class MBSEPluginExtension {

	protected final ProjectInternal project;
	
	protected final ObjectFactory objectFactory;

	@Inject
	public MBSEPluginExtension(ProjectInternal project,ObjectFactory objectFactory) {
		this.project = project;
		this.objectFactory = objectFactory;
	}
}
