/**
   Copyright 2020 Matt Fischer <mfish2011@gmail.com>

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
import org.gradle.api.tasks.Exec;

import setools.gradle.meeting.api.RiskReview;
import setools.gradle.meeting.api.internal.DefaultRiskReview;
import setools.gradle.tasks.DraftRiskReview;
import setools.gradle.tasks.VelocityTask;

/**
 * TODO:
 */
public class LaTeXRiskReviewPlugin implements Plugin<Project> {

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

	protected void applyPlugins(Project project) {
		project.getPluginManager().apply(RiskPlugin.class);
	}

	protected void registerCallbacks(Project project,RiskReview meeting) {
		//register callback to create tasks for meetings
		project.afterEvaluate(new Action<Project>() {

			@Override
			public void execute(Project project) {
				RiskReview riskReview = project.getExtensions().
						getByType(RiskReview.class);
				String name = riskReview.getName();
				//draft agenda
				String taskName = "draft " + name + " agenda";
				taskName = CaseUtils.toCamelCase(taskName, false, null);
				VelocityTask draftAgenda = project.getTasks().create(taskName,VelocityTask.class);
				draftAgenda.setGroup(name);
				draftAgenda.setDescription("Draft the agenda for the " + name);
				draftAgenda.setTemplate("templates/velocity/agenda.tex.vm");
				draftAgenda.getContextProperties().put("attendees",riskReview.getAttendees());
				//TODO:other context variables...
				draftAgenda.setOutput("src/project/meetings/" + name + "/agenda.tex");
				
				//draftMinutes
				taskName = "draft " + name + " minutes";
				taskName = CaseUtils.toCamelCase(taskName, false, null);
				VelocityTask draftMinutes = project.getTasks().create(taskName,VelocityTask.class);
				draftMinutes.setGroup(name);
				draftMinutes.setDescription("Draft the minutes for the " + name);
				draftMinutes.setTemplate("templates/velocity/minutes.tex.vm");
				draftMinutes.getContextProperties().put("attendees",riskReview.getAttendees());
				//TODO:other context variables...
				draftMinutes.setOutput("src/project/meetings/" + name + "/minutes.tex");
				draftMinutes.getDependsOn().add(draftAgenda);
				
				//draftSlides
				taskName = "draft " + name + " slides";
				taskName = CaseUtils.toCamelCase(taskName, false, null);
				DraftRiskReview draftPresentation = project.getTasks().create(taskName,DraftRiskReview.class);
				draftPresentation.setGroup(name);
				draftPresentation.setDescription("Draft the presentation for the " + name);
				//TODO:other context variables...
				draftPresentation.setOutput("src/project/meetings/" + name + "/presentation.tex");
				draftPresentation.getDependsOn().add(draftAgenda);
				
				//assemblePresentation
				taskName = "assemble " + name + " presentation";
				taskName = CaseUtils.toCamelCase(taskName, false, null);
				//TODO:replace with a LatexTask
				Exec assemblePresentation = project.getTasks().create(taskName,Exec.class);
				assemblePresentation.setGroup(name);
				assemblePresentation.setDescription("Assembles the presentation for the " + name);
				assemblePresentation.commandLine("pdflatex","src/project/meetings/" + name + "/presentation.tex");
				assemblePresentation.getDependsOn().add(draftPresentation);
				
				//publishPresentation
				taskName = "publish " + name + " presentation";
				taskName = CaseUtils.toCamelCase(taskName, false, null);
				Task publishPresentation = project.getTasks().create(taskName);
				publishPresentation.setGroup(name);
				publishPresentation.setDescription("Publish the presentation for the " + name);
				publishPresentation.getDependsOn().add(assemblePresentation);
				publishPresentation.getDependsOn().add(draftMinutes);
				
				//publishMinutes
				taskName = "publish " + name + " minutes";
				taskName = CaseUtils.toCamelCase(taskName, false, null);
				Task publishMinutes = project.getTasks().create(taskName);
				publishMinutes.setGroup(name);
				publishMinutes.setDescription("Publish the minutes for the " + name);
				publishMinutes.getDependsOn().add(publishPresentation);
			}
			
		});
	}

	protected RiskReview configureExtension(Project project) {
		return project.getExtensions().create(PLUGIN_EXT,
				DefaultRiskReview.class, project);
			
	}
}
