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

import javax.inject.Inject;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.SourceSetContainer;
import org.gradle.internal.reflect.Instantiator;

import setools.gradle.meetings.tasks.MeetingsSourceSet;
import setools.gradle.meetings.tasks.internal.DefaultMeetingsSourceSet;

/**
 * TODO:
 */
public class MeetingsSourceSetPlugin implements Plugin<Project> {
	
	/**
	 * TODO:
	 */
	protected final Instantiator instantiator;

	/**
	 * TODO:
	 */
	protected final ObjectFactory objectFactory;

	/**
	 * TODO:
	 * @param sourceSets
	 */
	@Inject
	public MeetingsSourceSetPlugin(Instantiator instantiator,ObjectFactory objectFactory) {
		this.instantiator = instantiator;
		this.objectFactory = objectFactory;
	}

	@Override
	public void apply(Project project) {
		sourceSets.add(doCreate(MeetingsSourceSet.MEETINGS_SOURCE_SET_NAME));
	}
	
	/**
	 * TODO:
	 * @param name
	 * @return
	 */
	protected SourceSet doCreate(String name) {
		return instantiator.newInstance(DefaultMeetingsSourceSet.class, name, objectFactory);
	}
}
