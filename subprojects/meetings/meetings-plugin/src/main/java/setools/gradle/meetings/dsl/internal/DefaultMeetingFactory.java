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
package setools.gradle.meetings.dsl.internal;

import org.gradle.api.Action;
import org.gradle.api.Project;
import setools.gradle.meetings.dsl.Meeting;
import setools.gradle.util.Factory;

/**
 * TODO:
 */
public class DefaultMeetingFactory implements Factory<Meeting> {

	/**
	 * TODO:
	 */
	protected final Project project;
	
	/**
	 * TODO:
	 * @param project
	 */
	public DefaultMeetingFactory(Project project) {
		this.project = project;
	}
	
	@Override
	public Meeting build() {
		return project.getObjects().newInstance(DefaultMeeting.class,project);
	}

	@Override
	public Meeting build(Action<Meeting> action) {
		Meeting result = build();
		action.execute(result);
		return result;
	}

}
