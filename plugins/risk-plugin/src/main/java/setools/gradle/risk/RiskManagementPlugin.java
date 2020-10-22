/**
 * TODO:license...
 */
package setools.gradle.risk;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.JavaBasePlugin;

import setools.gradle.dsl.meeting.Meeting;
import setools.gradle.dsl.meeting.MeetingsHandler;
import setools.gradle.meetings.util.InitializeMeetingTasks;
import setools.gradle.risk.internal.DefaultRiskManagementExtension;

/**
 * TODO:documentation...
 */
public class RiskManagementPlugin implements Plugin<Project> {
	
	/**
	 * Name for the Risk Management plugin and plugin extension.
	 */
	public static final String PLUGIN_EXT = "riskManagement";

	@Override
	public void apply(Project project) {
		applyPlugins(project);
		configureExtension(project);
		configureTasks(project);
		configureCallbacks(project);
	}
	
	/**
	 * Register callbacks to perform configuration that must be performed 
	 * after project buildscript evaluation.
	 * @param project
	 */
	protected void configureCallbacks(Project project) {
		//TODO:
	}
	
	/**
	 * Create or register tasks for this plugin.
	 * 
	 * @param project
	 */
	protected void configureTasks(Project project) {
		//TODO:
	}

	/**
	 * Apply the plugins required to make this plugin work properly.
	 * @param project
	 */
	protected void applyPlugins(Project project) {
		project.getPluginManager().apply(RiskManagementBasePlugin.class);
		//TODO:include RiskReviewPlugin by default or not???
	}
	
	/**
	 * Create the plugin extension to allow customizing plugin settings.
	 * 
	 * @param project
	 */
	protected void configureExtension(Project project) {
		project.getExtensions().create(PLUGIN_EXT, DefaultRiskManagementExtension.class,project);
	}
}
