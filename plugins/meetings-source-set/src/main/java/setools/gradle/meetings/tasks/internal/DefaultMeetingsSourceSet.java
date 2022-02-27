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

import java.util.Collection;
import org.gradle.api.internal.tasks.DefaultSourceSet;
import org.gradle.api.model.ObjectFactory;
import setools.gradle.meetings.tasks.MeetingSourceDirectorySet;
import setools.gradle.meetings.tasks.MeetingsSourceSet;

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
	 * @param name
	 * @param objectFactory
	 */
	public DefaultMeetingsSourceSet(ObjectFactory objectFactory) {
		super(MeetingsSourceSet.MEETINGS_SOURCE_SET_NAME,objectFactory);
		this.objectFactory = objectFactory;
	}

	@Override
	public MeetingSourceDirectorySet getMeeting(String name) {
		Object extension = getExtensions().getByName(name);
		if(extension instanceof MeetingSourceDirectorySet) {
			return (MeetingSourceDirectorySet)extension;
		}
		throw new RuntimeException(); //TODO:what type of exception to throw ???
	}

	@Override
	public MeetingSourceDirectorySet findMeeting(String name) {
		Object extension = getExtensions().findByName(name);
		if(extension instanceof MeetingSourceDirectorySet) {
			return (MeetingSourceDirectorySet)extension;
		}
		return null;
	}

	@Override
	public MeetingSourceDirectorySet createMeeting(String name) {
		MeetingSourceDirectorySet meeting = findMeeting(name);
		if(meeting==null) {
			meeting = new DefaultMeetingSourceDirectorySet(name,objectFactory);
			getExtensions().add(name, meeting);
		}
		return meeting;
	}

	@Override
	public Collection<MeetingSourceDirectorySet> getAllMeetings() {
		// TODO Auto-generated method stub
		return null;
	}

}
