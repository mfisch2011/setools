/**
 * TODO:license...
 */
package setools.gradle.risk;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.plugins.JavaBasePlugin;

/**
 * TODO:documentation...
 */
public class RiskManagementBasePlugin implements Plugin<Project> {
	
	/**
	 * Group name for Risk Management tasks.
	 */
	public static final String RISK_MANAGEMENT = "Risk Management";
	
	/**
	 * Task name for the Risk Identification step.
	 */
	public static final String RISK_ID = "riskIdentification";
	
	/**
	 * Task name for the Risk Analysis step.
	 */
	public static final String RISK_ANALYSIS = "riskAnalysis";
	
	/**
	 * Task name for the Risk Mitigation step.
	 */
	public static final String RISK_MITIGATION = "riskMitigation";
	
	/**
	 * Task name for the Risk Monitoring step.
	 */
	public static final String RISK_MONITORING = "riskMonitoring";

	@Override
	public void apply(Project project) {
		applyPlugins(project);
		configureTasks(project);
	}

	/**
	 * Apply the plugins required to make this plugin work properly.
	 * 
	 * @param project
	 */
	protected void applyPlugins(Project project) {
		project.getPluginManager().apply(RiskBasePlugin.class);
	}
	
	/** 
	 * Create and configure the lifecycle tasks for the steps of the Risk 
	 * Management process.  These tasks are intended to only be milestones 
	 * to which other tasks can be "attached" to synchronize work.
	 * 
	 * @param project
	 */
	protected void configureTasks(Project project) {
		
		//TODO:should we add a task for the risk planning step?
		
		//risk identification
		Task task = project.getTasks().create(RISK_ID);
		task.setGroup(RISK_MANAGEMENT);
		task.setDescription("Identify and import risk into project model space.");
		
		//risk analysis
		task = project.getTasks().create(RISK_ANALYSIS);
		task.setGroup(RISK_MANAGEMENT);
		task.setDescription("Analyze and assess risk in the project model space.");
		
		//risk mitigation
		task = project.getTasks().create(RISK_MITIGATION);
		task.setGroup(RISK_MANAGEMENT);
		task.setDescription("Plan and implement risk mitigations and corrective actions.");
		
		//risk monitoring
		task = project.getTasks().create(RISK_MONITORING);
		task.setGroup(RISK_MANAGEMENT);
		task.setDescription("Monitor and report risk information.");
		
	}
}
