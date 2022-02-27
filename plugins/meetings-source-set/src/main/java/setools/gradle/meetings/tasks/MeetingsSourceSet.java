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
package setools.gradle.meetings.tasks;

import java.util.Collection;

import org.gradle.api.tasks.SourceSet;

/**
 * TODO:
 */
public interface MeetingsSourceSet extends SourceSet {
	
	/**
	 * TODO:
	 */
	public static final String MEETINGS_SOURCE_SET_NAME = "meetings";

	/**
	 * TODO:
	 * @param name
	 * @return
	 */
	public MeetingSourceDirectorySet getMeeting(String name);
	
	/**
	 * TODO:
	 * @param name
	 * @return
	 */
	public MeetingSourceDirectorySet findMeeting(String name);
	
	/**
	 * TODO:
	 * @param name
	 * @return
	 */
	public MeetingSourceDirectorySet createMeeting(String name);
	
	/**
	 * TODO:
	 * @return
	 */
	public Collection<MeetingSourceDirectorySet> getAllMeetings();
	
}
