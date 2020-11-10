/**
 * 
 */
package setools.gradle.project;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import setools.gradle.project.tasks.ProjectMonteCarloTask;

/**
 * TODO:documentation...
 */
public class MonteCarloPlugin implements Plugin<Project> {

	@Override
	public void apply(Project project) {
		applyPlugins(project);
		configureExtensions(project);
		configureTasks(project);
	}
	
	protected void configureTasks(Project project) {
		ProjectMonteCarloTask.configure(project);
	}
	
	protected void configureExtensions(Project project) {
		//TODO:
	}

	protected void applyPlugins(Project project) {
		//TODO:
	}
}
