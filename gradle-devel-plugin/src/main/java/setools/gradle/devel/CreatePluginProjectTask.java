/**
 * 
 */
package setools.gradle.devel;

import javax.inject.Inject;

import org.gradle.api.DefaultTask;
import org.gradle.api.Task;
import org.gradle.api.internal.project.ProjectInternal;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.tasks.TaskAction;

/**
 * @author matt
 *
 */
public class CreatePluginProjectTask extends DefaultTask {

	public static final String TASK_NAME = "createPluginProject";

	protected final ProjectInternal project;
	
	protected final ObjectFactory objectFactory;
	
	protected final GradleDevelopmentPluginExtension pluginExtension;
	
	protected final CreatePluginProjectTaskExtension taskExtension;
	
	@Inject
	public CreatePluginProjectTask(ProjectInternal project,ObjectFactory objectFactory,GradleDevelopmentPluginExtension pluginExtension,CreatePluginProjectTaskExtension taskExtension) {
		this.project = project;
		this.objectFactory = objectFactory;
		this.pluginExtension = pluginExtension;
		this.taskExtension = taskExtension;
	}
	
	public static CreatePluginProjectTask configureTask(ProjectInternal project,Task parent,ObjectFactory objectFactory,GradleDevelopmentPluginExtension pluginExtension) {
		CreatePluginProjectTaskExtension taskExtension = project.getExtensions().create(TASK_NAME, DefaultCreatePluginProjectTaskExtension.class,project,objectFactory,pluginExtension);
		CreatePluginProjectTask task = project.getTasks().create(TASK_NAME,CreatePluginProjectTask.class,project,objectFactory,pluginExtension,taskExtension);
		if(parent!=null) {
			parent.getDependsOn().add(task);
		}
		return task;
	}
	
}
