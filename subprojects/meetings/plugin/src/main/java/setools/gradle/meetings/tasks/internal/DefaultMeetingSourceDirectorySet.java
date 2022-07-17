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
package setools.gradle.meetings.tasks.internal;

import org.gradle.api.internal.file.DefaultSourceDirectorySet;
import org.gradle.api.model.ObjectFactory;
import setools.gradle.meetings.tasks.MeetingSourceDirectorySet;

/**
 * TODO:
 */
public class DefaultMeetingSourceDirectorySet extends DefaultSourceDirectorySet implements MeetingSourceDirectorySet {

	/**
	 * TODO:
	 * @param name - name of {@link MeetingSourceDirectorySet}
	 * @param objectFactory - {@link ObjectFactory} for creating objects
	 */
	public DefaultMeetingSourceDirectorySet(String name,ObjectFactory objectFactory) {
		super(objectFactory.sourceDirectorySet(name, name + " source files."));
		//TODO: other configuration..
	}

}
