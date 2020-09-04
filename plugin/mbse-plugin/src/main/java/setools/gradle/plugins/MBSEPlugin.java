/**
 * TODO:license...
 */
package setools.gradle.plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * TODO:documentation...
 */
public class MBSEPlugin implements Plugin<Project> {

	@Override
	public void apply(Project project) {
		applyConventions(project);
		configureExtension(project);
		configureTasks(project);
	}
	
	/**
	 * TODO:documentation...
	 * @param project
	 */
	protected void applyConventions(Project project) {
		//TODO:stub...
	}
	
	/**
	 * TODO:documentation...
	 * @param project
	 */
	protected void configureExtension(Project project) {
		//TODO:stub...
	}

	/**
	 * TODO:documentation...
	 * @param project
	 */
	protected void configureTasks(Project project) {
		//TODO:stub...
	}
}
