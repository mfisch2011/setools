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

import setools.gradle.meeting.api.RiskReview;
import setools.gradle.meeting.api.internal.DefaultRiskReview;
import setools.gradle.meeting.util.RegisterRiskReview;

/**
 * @author matt
 *
 */
public class RiskReviewPlugin implements Plugin<Project> {

	public static final String PLUGIN_EXT = "riskReview";

	/**
	 * TODO:
	 */
	@Override
	public void apply(Project project) {
		applyPlugins(project);
		RiskReview meeting = configureExtension(project);
		registerCallbacks(project,meeting);
	}

	protected void registerCallbacks(Project project,RiskReview meeting) {
		//register callback to create tasks for meetings
		project.afterEvaluate(new RegisterRiskReview(meeting));
	}

	protected RiskReview configureExtension(Project project) {
		return project.getExtensions().create(PLUGIN_EXT,
				DefaultRiskReview.class, project);
			
	}

	protected void applyPlugins(Project project) {
		project.getPluginManager().apply(RiskManagementLifecyclePlugin.class);
	}

}
