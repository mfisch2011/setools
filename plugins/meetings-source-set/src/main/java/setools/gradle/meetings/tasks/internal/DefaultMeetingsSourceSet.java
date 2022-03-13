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
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.gradle.api.internal.file.FileCollectionFactory;
import org.gradle.api.internal.file.FileResolver;
import org.gradle.api.internal.tasks.DefaultSourceSet;
import org.gradle.api.internal.tasks.DefaultSourceSetOutput;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.tasks.SourceSetOutput;
import org.gradle.internal.reflect.Instantiator;

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
	 */
	protected final Map<String, MeetingSourceDirectorySet> meetings;

	/**
	 * TODO:
	 */
	protected final SourceSetOutput output;

	/**
	 * TODO:
	 * @param name
	 * @param objectFactory
	 */
	public DefaultMeetingsSourceSet(Instantiator instantiator,
			FileResolver fileResolver,
			FileCollectionFactory fileCollectionFactory,
			ObjectFactory objectFactory) {
		super(MeetingsSourceSet.MEETINGS_SOURCE_SET_NAME,objectFactory);
		output = instantiator.newInstance(DefaultSourceSetOutput.class, getDisplayName(),fileResolver, fileCollectionFactory);
		setClasses((DefaultSourceSetOutput)output);
		this.objectFactory = objectFactory;
		this.meetings = new ConcurrentHashMap<String,MeetingSourceDirectorySet>();
	}
	
	@Override
	public SourceSetOutput getOutput() {
		return output;
	}

	@Override
	public MeetingSourceDirectorySet getMeeting(String name) {
		if(meetings.containsKey(name)) {
			return meetings.get(name);
		}
		throw new RuntimeException(); //TODO:what type of exception to throw ???
	}

	@Override
	public MeetingSourceDirectorySet findMeeting(String name) {
		if(meetings.containsKey(name)) {
			return meetings.get(name);
		}
		return null;
	}

	@Override
	public MeetingSourceDirectorySet createMeeting(String name) {
		MeetingSourceDirectorySet meeting = findMeeting(name);
		if(meeting==null) {
			meeting = new DefaultMeetingSourceDirectorySet(name,objectFactory);
			meetings.put(name, meeting);
		}
		return meeting;
	}

	@Override
	public Collection<MeetingSourceDirectorySet> getAllMeetings() {
		return Collections.unmodifiableCollection(meetings.values());
	}

}
