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

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.JavaBasePlugin;
import setools.gradle.meeting.api.Meeting;
import setools.gradle.meeting.util.RegisterMeetingLifecycle;
import setools.gradle.plugins.internal.DefaultMeetingsPluginExtension;

/** TODO:
 * @author matt
 *
 */
public class MeetingsPlugin implements Plugin<Project> {

	public static final String PLUGIN_EXT = "meetingsPlugin";

	protected MeetingsPluginExtension extension;
	
	/**
	 * TODO:
	 */
	@Override
	public void apply(Project project) {
		applyPlugins(project);
		extension = configureMeetingsExtension(project);
		configureDefaults(project);
		configureSourceSet(project);
		configureTasks(project);
	}

	protected void configureSourceSet(Project project) {
		//TODO:
		//TODO:do we need any SourceDirectorySets???
	}

	protected void configureTasks(Project project) {
		//register callback to create tasks for meetings
		project.afterEvaluate(new Action<Project>() {

			@Override
			public void execute(Project project) {
				for(Meeting meeting : extension.getMeetings()) {
					//TODO:how to register these individual up front????
					RegisterMeetingLifecycle callback = new RegisterMeetingLifecycle(meeting);
					callback.execute(project); //force execution after the fact????
				}
			}
			
		});
	}

	protected void configureDefaults(Project project) {
		// TODO Auto-generated method stub
		
	}

	protected void applyPlugins(Project project) {
		/*
		 * really do not want to have to do this, but right now it is 
		 * the only way to get sourceSets...
		 */
		project.getPluginManager().apply(JavaBasePlugin.class);
	}

	protected MeetingsPluginExtension configureMeetingsExtension(Project project) {
		return project.getExtensions().create(PLUGIN_EXT,
				DefaultMeetingsPluginExtension.class, project);
	}
}
