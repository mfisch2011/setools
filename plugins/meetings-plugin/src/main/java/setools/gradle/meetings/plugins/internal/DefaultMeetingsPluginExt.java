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
package setools.gradle.meetings.plugins.internal;

import java.util.TreeSet;

import javax.inject.Inject;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.internal.metaobject.MethodAccess;

import setools.gradle.meetings.api.Meeting;
import setools.gradle.meetings.api.MeetingsFactory;
import setools.gradle.meetings.plugins.MeetingsPluginExt;

/**
 * TODO:
 */
@SuppressWarnings("serial") //TODO:WHERE THE FUCK IS THIS COMING FROM ???
public class DefaultMeetingsPluginExt extends TreeSet<Meeting> implements MeetingsPluginExt {

	/**
	 * TODO:
	 */
	protected final Project project;

	/**
	 * TODO:
	 * @param project - {@link Project} to resolve configuration
	 */
	@Inject
	public DefaultMeetingsPluginExt(Project project) {
		this.project = project;
	}


	@Override
	public MethodAccess getAdditionalMethods() {
		return getMeetingsFactory();
	}
	
	/**
	 * TODO:
	 */
	private MeetingsFactory meetingsFactory = null;
	
	/**
	 * TODO:
	 * @return
	 */
	protected MeetingsFactory getMeetingsFactory() {
		if(meetingsFactory==null) {
			project.getLogger().debug("Searching for MeetingsFactory.");
			for(Plugin<?> plugin : project.getPlugins()) {
				if(plugin instanceof MeetingsFactory) {
					meetingsFactory = (MeetingsFactory)plugin;
					project.getLogger().debug("Found {}.",meetingsFactory);
				}
			}
		}
		return meetingsFactory;
	}
}
