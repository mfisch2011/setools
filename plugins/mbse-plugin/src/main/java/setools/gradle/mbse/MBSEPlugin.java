/**
 * TODO:license...
 */
package setools.gradle.mbse;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.JavaBasePlugin;

import setools.gradle.mbse.internal.DefaultMBSEPluginExtension;
import setools.gradle.meetings.MeetingsPlugin;
import setools.gradle.risk.RiskManagementPlugin;
import setools.gradle.risk.RiskReviewPlugin;

/**
 * TODO:documentation...
 */
public class MBSEPlugin implements Plugin<Project> {
	
	public static final String PLUGIN_EXT = "mbse";

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
				DefaultMBSEPluginExtension.class, project);
	}
	
	/**
	 * TODO:documentation...
	 * @param project
	 */
	protected void applyPlugins(Project project) {
		//needed for sourceSets (thanks gradle dev team!)
		//project.getPluginManager().apply(JavaBasePlugin.class);
		
		//apply other plugins that are part of SE Tools (for conviencence)
		project.getPluginManager().apply(MeetingsPlugin.class);
		project.getPluginManager().apply(RiskReviewPlugin.class);
		project.getPluginManager().apply(RiskManagementPlugin.class);
	}

}
