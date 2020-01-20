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
package setools.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Task;
import org.gradle.api.internal.project.ProjectInternal;

import setools.gradle.internal.DefaultMeetingsPluginExtension;
import setools.gradle.task.InitMeeting;

/**
 * @author matt
 *
 */
public class MeetingsPlugin implements Plugin<ProjectInternal> {

	public static final String PLUGIN_EXT = "meetings";
	
	@Override
	public void apply(ProjectInternal project) {
		applyBasePlugins(project);
		configureExtension(project);
		configureTasks(project);
	}
	
	protected void configureExtension(ProjectInternal project) {
		project.getExtensions().create(PLUGIN_EXT,DefaultMeetingsPluginExtension.class,project);
	}

	protected void applyBasePlugins(ProjectInternal project) {
		project.getPluginManager().apply(MeetingsLifecyclePlugin.class);
	}

	protected void configureTasks(ProjectInternal project) {
		configureInitMeetingTask(project);
		configureGeneratePresentationTask(project);
		configureCompilePresentationTask(project);
		configurePublishMinutesTask(project);
	}
	
	protected void configurePublishMinutesTask(ProjectInternal project) {
		// TODO Auto-generated method stub
		
	}

	protected void configureCompilePresentationTask(ProjectInternal project) {
		// TODO Auto-generated method stub
		
	}

	protected void configureGeneratePresentationTask(ProjectInternal project) {
		// TODO Auto-generated method stub
		
	}

	protected void configureInitMeetingTask(ProjectInternal project) {
		InitMeeting task = InitMeeting.configure(project);
	}

	protected Task findTaskByName(ProjectInternal project,String name) {
		return project.getTasks().findByName(name);
	}
	
	protected Task getAgendaTask(ProjectInternal project) {
		return findTaskByName(project,MeetingsLifecyclePlugin.AGENDA_TASK);
	}
	
	protected Task getPresentationTask(ProjectInternal project) {
		return findTaskByName(project,MeetingsLifecyclePlugin.PRESENTATION_TASK);
	}
	
	protected Task getMinutesTask(ProjectInternal project) {
		return findTaskByName(project,MeetingsLifecyclePlugin.MINUTES_TASK);
	}
	
}
