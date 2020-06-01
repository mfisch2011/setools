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
package setools.gradle.meeting.util;

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.specs.Spec;

import setools.gradle.meeting.api.AgendaItem;
import setools.gradle.meeting.api.RiskReview;
import setools.gradle.plugins.RiskManagementLifecyclePlugin;
import setools.gradle.tasks.GenerateTask;

/**
 * @author matt
 *
 */
public class RegisterRiskReview extends RegisterMeetingLifecycle {

	public RegisterRiskReview(RiskReview meeting) {
		super(meeting);
	}

	@Override
	protected Task configureMilestone(Project project) {
		Task result = super.configureMilestone(project);
		//TODO:would rather do this in the plugin, but how to handle it before the meeting is available???
		Task monitoring = project.getTasks().getByName(RiskManagementLifecyclePlugin.RISK_MONITORING_TASK_NAME);
		monitoring.dependsOn(result);
		return result;
	}

	@Override
	protected void addTopicSlideTasks(Project project,AgendaItem topic) throws ClassNotFoundException {
		//add task to draft slide for topic
		String formatter = topic.getFormatter();
		if(formatter!=null) {
			String name = getTaskName("Draft",meeting.getName(),topic.getText() + " Slide");
			@SuppressWarnings("unchecked")
			Class<? extends DefaultTask> type = (Class<? extends DefaultTask>) Class.forName(formatter);
			GenerateTask task = (GenerateTask)project.getTasks().create(name,type,meeting,topic);
			task.dependsOn(RiskManagementLifecyclePlugin.RISK_MITIGATION_TASK_NAME);
			task.setGroup(meeting.getName());
			task.setDescription("Draft the " + topic.getText() + " slides for the " + meeting.getName());
			task.setDestination(getOutput(meeting.getName(),topic.getText() + " Slides.pptx"));
			getDraftSlides(project).dependsOn(name);
			//TODO: topics with section title slides really need to be split into two tasks, so that title slide is generated even if there is no source for section content...
		}
		
		//add tasks to draft slides for sub-topics
		for(AgendaItem subTopic : topic.getSubItems()) {
			addTopicSlideTasks(project,subTopic);
		}
	}
	
}
