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

import setools.gradle.meetings.dsl.internal.DefaultMeetingFactory;
import setools.gradle.meetings.dsl.internal.DefaultWorkingGroupFactory;

/**
 * TODO:
 */
public class BasicMeetingFactoriesPlugin implements Plugin<Project> {

	@Override
	public void apply(Project project) {
		MeetingsFactoryServicePlugin service = project.getPlugins()
				.findPlugin(MeetingsFactoryServicePlugin.class);
		if(service==null) {
			project.getPluginManager().apply(MeetingsFactoryServicePlugin.class);
			service = project.getPlugins().getPlugin(MeetingsFactoryServicePlugin.class);
		}
		service.register("meeting",new DefaultMeetingFactory(project));
		service.register("workingGroup",new DefaultWorkingGroupFactory(project));
	}

}
