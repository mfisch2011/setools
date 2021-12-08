/**
 * Copyright 2021 M. Fischer <mfisch2011@gmail.com>
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
import org.gradle.api.plugins.JavaBasePlugin;
import org.gradle.api.tasks.SourceSetContainer;

/**
 * TODO:
 */
public class MeetingsBasePlugin implements Plugin<Project> {

	/**
	 * TODO:
	 */
	public static final String MEETINGS_SOURCE_SET_NAME = "meetings";		

	@Override
	public void apply(Project project) {
		createMeetingsSourceSet(project);
		createMeetingsFactoryService(project);
		createTopicFactoryService(project);
		createSlideFactoryService(project);
	}

	/**
	 * TODO:
	 * @param project
	 */
	protected void createSlideFactoryService(Project project) {
		project.getPluginManager().apply(SlideFactoryServicePlugin.class);
	}

	/**
	 * TODO:
	 * @param project
	 */
	protected void createTopicFactoryService(Project project) {
		project.getPluginManager().apply(TopicFactoryServicePlugin.class);
	}

	/**
	 * TODO:
	 * @param project
	 */
	protected void createMeetingsFactoryService(Project project) {
		project.getPluginManager().apply(MeetingsFactoryServicePlugin.class);
	}

	/**
	 * TODO:
	 * @param project
	 */
	protected void createMeetingsSourceSet(Project project) {
		project.getPluginManager().apply(JavaBasePlugin.class); //required for sourceSets...
		SourceSetContainer sourceSets = project.getExtensions().getByType(SourceSetContainer.class);
		sourceSets.create(MEETINGS_SOURCE_SET_NAME);
	}

}
