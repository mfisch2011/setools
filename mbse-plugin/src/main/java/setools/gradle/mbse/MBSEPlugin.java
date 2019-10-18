/**
 * 
 */
package setools.gradle.mbse;

import javax.inject.Inject;

import org.gradle.api.Plugin;
import org.gradle.api.Task;
import org.gradle.api.internal.project.ProjectInternal;
import org.gradle.api.model.ObjectFactory;

/**
 * @author matt
 *
 */
public class MBSEPlugin implements Plugin<ProjectInternal> {

	protected final ObjectFactory objectFactory;
	
	@Inject
	public MBSEPlugin(ObjectFactory objectFactory) {
		this.objectFactory = objectFactory;
	}
	
	@Override
	public void apply(ProjectInternal project) {
		MBSEPluginExtension extension = project.getExtensions().create("mbse", MBSEPluginExtension.class, project,objectFactory);
		configureModel(project,extension);
		configureSimulation(project,extension);
		configureReport(project,extension);
		configureDocument(project,extension);
	}

	protected void configureDocument(ProjectInternal project, MBSEPluginExtension extension) {
		Task document = project.getTasks().create("document");
		//TODO:create other document tasks...
	}

	protected void configureReport(ProjectInternal project, MBSEPluginExtension extension) {
		Task report = project.getTasks().create("report");
		//TODO:create other report tasks
	}

	protected void configureSimulation(ProjectInternal project, MBSEPluginExtension extension) {
		Task simulate = project.getTasks().create("simulate");
		//TODO:create other simulate tasks
	}

	protected void configureModel(ProjectInternal project, MBSEPluginExtension extension) {
		Task model = project.getTasks().findByName("model");
		//TODO:how to handle a null model event
	}

}
