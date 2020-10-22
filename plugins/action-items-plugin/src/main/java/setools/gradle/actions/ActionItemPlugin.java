/**
 * TODO:license...
 */
package setools.gradle.actions;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.JavaBasePlugin;

import setools.gradle.actions.internal.DefaultActionItemsExtension;

/**
 * TODO:documentation...
 */
public class ActionItemPlugin implements Plugin<Project> {

	/**
	 * TODO:documentation...
	 */
	public static final String PLUGIN_EXT = "actionItems";

	@Override
	public void apply(Project project) {
		applyPlugins(project);
		createExtension(project);
		createTasks(project);
	}
	
	/**
	 * TODO:documentation...
	 * @param project
	 */
	protected void createTasks(Project project) {
		//TODO:
	}
	
	/**
	 * TODO:documentation...
	 * @param project
	 */
	protected void createExtension(Project project) {
		project.getExtensions().create(PLUGIN_EXT,
				DefaultActionItemsExtension.class, project);
	}
	
	/**
	 * TODO:documentation...
	 * @param project
	 */
	protected void applyPlugins(Project project) {
		//needed for sourceSets (thanks gradle dev team!)
		project.getPluginManager().apply(JavaBasePlugin.class);
	}
}
