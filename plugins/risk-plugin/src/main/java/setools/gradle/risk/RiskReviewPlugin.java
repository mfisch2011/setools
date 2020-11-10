/**
 * TODO:license...
 */
package setools.gradle.risk;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

import setools.gradle.risk.internal.DefaultRiskReviewExtension;
import setools.gradle.risk.util.InitializeRiskReviewTasks;

/**
 * TODO:documentation...
 */
public class RiskReviewPlugin implements Plugin<Project> {

	/**
	 * Name for the Risk Management plugin and plugin extension.
	 */
	public static final String PLUGIN_EXT = "riskReview";

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
		project.afterEvaluate(new Action<Project>() {

			@Override
			public void execute(Project project) {
				RiskReviewExtension extension = (RiskReviewExtension)
						project.getExtensions().getByName(PLUGIN_EXT);
				InitializeRiskReviewTasks initializer = 
				new InitializeRiskReviewTasks(project,extension);
				initializer.initializeTasks();
			}
		});
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
		project.getPluginManager().apply(RiskBasePlugin.class); //required for sourceSets (THANKS !$#? GRADLE DEV TEAM!!!!) 
	}
	
	/**
	 * Create the plugin extension to allow customizing plugin settings.
	 * 
	 * @param project
	 */
	protected void configureExtension(Project project) {
		project.getExtensions().create(PLUGIN_EXT, DefaultRiskReviewExtension.class,project);
	}

}
