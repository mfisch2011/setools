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

import org.apache.commons.text.CaseUtils;
import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;

import setools.gradle.meeting.api.RiskReview;
import setools.gradle.tasks.ImportJsonRisks;

/**
 * @author matt
 *
 */
public class RiskManagementPlugin implements Plugin<Project> {

	@Override
	public void apply(Project project) {
		project.getPluginManager().apply(UmlPlugin.class);
		//TODO:what was included here??? project.getPluginManager().apply(RiskBasePlugin.class);
		project.getPluginManager().apply(RiskManagementLifecyclePlugin.class);
		project.getPluginManager().apply(RiskReviewPlugin.class);
		
		project.getTasks().create("importJsonRisks",ImportJsonRisks.class);
		
		Task identify = project.getTasks().findByName("riskIdentification");
		identify.dependsOn("importJsonRisks");
		
		project.afterEvaluate(new Action<Project>() {

			@Override
			public void execute(Project project) {
				RiskReview riskReview = (RiskReview) project.
						getExtensions().findByName("riskReview");
				if(riskReview!=null) {
					String taskName = CaseUtils.toCamelCase("Publish " + 
							riskReview.getName() + " Minutes", false, null);
					Task monitor = project.getTasks().getByName(
							RiskManagementLifecyclePlugin.
							RISK_MONITORING_TASK_NAME);
					monitor.dependsOn(taskName);
				}
			}
			
		});
	}

	protected void configureRiskReview(Project project) {
		Task task = project.getTasks().getByName(RiskManagementLifecyclePlugin.RISK_MONITORING_TASK_NAME);
		task.dependsOn("publishRiskReviewMinutes");
	}

}
