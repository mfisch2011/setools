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
package com.github.mfisch2011.setools.gradle.meetings.tasks.internal;

import javax.inject.Inject;

import org.gradle.api.internal.tasks.DefaultSourceSet;
import org.gradle.api.model.ObjectFactory;
import com.github.mfisch2011.setools.gradle.meetings.tasks.MeetingDirectorySet;
import com.github.mfisch2011.setools.gradle.meetings.tasks.MeetingsSourceSet;

/**
 * TODO:
 */
public abstract class DefaultMeetingsSourceSet extends DefaultSourceSet implements MeetingsSourceSet {
	
	/**
	 * TODO:
	 */
	protected final ObjectFactory objectFactory;

	/**
	 * TODO:
	 * @param name - TODO:
	 * @param objectFactory - TODO:
	 */
	@Inject
	public DefaultMeetingsSourceSet(String name,ObjectFactory objectFactory) {
		super(name,objectFactory);
		this.objectFactory = objectFactory;
	}

	@Override
	public MeetingDirectorySet addMeeting(String name) {
		DefaultMeetingDirectorySet meetingSource = objectFactory.newInstance(DefaultMeetingDirectorySet.class,name,name + " source files.");
		getExtensions().add(name, meetingSource);
		return meetingSource;
	}

	@Override
	public MeetingDirectorySet getMeeting(String name) {
		return (MeetingDirectorySet) getExtensions().getByName(name);
	}

}
