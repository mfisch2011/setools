/**
 * Copyright 2022 M. Fischer <mfisch2011@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package setools.gradle.meetings.plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import setools.gradle.meetings.api.MeetingsFactory;
import setools.gradle.meetings.api.internal.DefaultMeetingFactory;
import setools.gradle.meetings.plugins.internal.DefaultMeetingsFactory;
import setools.gradle.meetings.plugins.internal.DefaultMeetingsPluginExt;

/**
 * TODO:
 */
public class MeetingsPlugin implements Plugin<Project> {

	/**
	 * {@link Project} the plugin is applied to.
	 */
	private Project project;

	@Override
	public void apply(Project project) {
		this.project = project;

		//apply other plugins that we will use
		project.getLogger().lifecycle("Applying {}.",MeetingsSourceSetPlugin.class);
		project.getPluginManager().apply(MeetingsSourceSetPlugin.class);
		project.getLogger().lifecycle("Applying {}.",DefaultMeetingsFactory.class);
		project.getPluginManager().apply(DefaultMeetingsFactory.class);
		
		//create plugin extensions
		project.getLogger().lifecycle("Createing {} as '{}'.",DefaultMeetingsPluginExt.class,MeetingsPluginExt.MEETINGS_EXT_NAME);
		project.getExtensions().create(MeetingsPluginExt.MEETINGS_EXT_NAME,
				DefaultMeetingsPluginExt.class,project);
		
		//register factory services
		project.getLogger().lifecycle("Registering {} as {} in {}.",
				DefaultMeetingFactory.class,"meeting",meetingsFactory());
		meetingsFactory().registerHandler("meeting",new DefaultMeetingFactory());
		
		//TODO: register callback to create tasks for the configured meetings
	}
	
	/**
	 * {@link MeetingsFactory} registered as a plugin for project.
	 */
	private MeetingsFactory meetingsFactory = null;
	
	/**
	 * TODO:
	 * @return
	 */
	protected MeetingsFactory meetingsFactory() {
		if(meetingsFactory==null) {
			for(Plugin<?> plugin : project.getPlugins()) {
				if(MeetingsFactory.class.isInstance(plugin)) {
					meetingsFactory = (MeetingsFactory)plugin;
					break;
				}
			}
		}
		return meetingsFactory;
	}

}
