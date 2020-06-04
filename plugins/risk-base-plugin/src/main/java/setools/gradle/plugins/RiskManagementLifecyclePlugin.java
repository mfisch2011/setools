/**
   Copyright 2019 Matt Fischer <mfish2011@gmail.com>

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package setools.gradle.plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;

/**
 * @author matt
 *
 */
public class RiskManagementLifecyclePlugin implements Plugin<Project> {

	/**
	 * TODO:
	 */
	public static final String RISK_MANAGEMENT_TASK_GROUP = "Risk Management";
	
	/**
	 * TODO:
	 */
	public static final String RISK_PLANNING_TASK_NAME = "riskPlanning";
	
	/**
	 * TODO:
	 */
	public static final String RISK_IDENTIFICATION_TASK_NAME = "riskIdentification";
	
	/**
	 * TODO:
	 */
	public static final String RISK_ANALYSIS_TASK_NAME = "riskAnalysis";
	
	/**
	 * TODO:
	 */
	public static final String RISK_MITIGATION_TASK_NAME = "riskMitigation";
	
	/**
	 * TODO:
	 */
	public static final String RISK_MONITORING_TASK_NAME = "riskMonitoring";
	
	/**
	 * TODO:
	 */
	@Override
	public void apply(Project project) {
		addRiskPlanning(project);
		addRiskIdentification(project);
		addRiskAnalysis(project);
		addRiskMitigation(project);
		addRiskMonitoring(project);
	}

	/** TODO:
	 * @param project
	 */
	protected void addRiskMonitoring(Project project) {
		//TODO:should we register a callback like LifecycleBasePlugin instead?
		Task task = project.getTasks().create(RISK_MONITORING_TASK_NAME);
		task.dependsOn(RISK_MITIGATION_TASK_NAME);
		task.setDescription("Risk Management risk monitoring lifecycle phase.");
		task.setGroup(RISK_MANAGEMENT_TASK_GROUP);
	}

	/** TODO:
	 * @param project
	 */
	protected void addRiskMitigation(Project project) {
		//TODO:should we register a callback like LifecycleBasePlugin instead?
		Task task = project.getTasks().create(RISK_MITIGATION_TASK_NAME);
		task.dependsOn(RISK_ANALYSIS_TASK_NAME);
		task.setDescription("Risk Management risk mitigation lifecycle phase.");
		task.setGroup(RISK_MANAGEMENT_TASK_GROUP);
	}

	/** TODO:
	 * @param project
	 */
	protected void addRiskAnalysis(Project project) {
		//TODO:should we register a callback like LifecycleBasePlugin instead?
		Task task = project.getTasks().create(RISK_ANALYSIS_TASK_NAME);
		task.dependsOn(RISK_IDENTIFICATION_TASK_NAME);
		task.setDescription("Risk Management risk analysis lifecycle phase.");
		task.setGroup(RISK_MANAGEMENT_TASK_GROUP);
	}

	/** TODO:
	 * @param project
	 */
	protected void addRiskIdentification(Project project) {
		//TODO:should we register a callback like LifecycleBasePlugin instead?
		Task task = project.getTasks().create(RISK_IDENTIFICATION_TASK_NAME);
		task.dependsOn(RISK_PLANNING_TASK_NAME);
		task.setDescription("Risk Management risk identification lifecycle phase.");
		task.setGroup(RISK_MANAGEMENT_TASK_GROUP);
	}

	/** TODO:
	 * @param project
	 */
	protected void addRiskPlanning(Project project) {
		//TODO:should we register a callback like LifecycleBasePlugin instead?
		Task task = project.getTasks().create(RISK_PLANNING_TASK_NAME);
		task.setDescription("Risk Management planning lifecycle phase.");
		task.setGroup(RISK_MANAGEMENT_TASK_GROUP);
	}

}
