/**
   Copyright 2019 Matt Fischer <mfish2011@gmail.com>

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package setools.gradle.meeting.api.internal;

import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

import org.gradle.api.Project;
import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meeting.api.Meeting;
import setools.gradle.meeting.api.MeetingsHandler;

/** TODO:
 * @author matt
 *
 */
public class DefaultMeetingHandler implements MeetingsHandler {
	
	protected final Project project;
	
	protected final Set<Meeting> meetings;

	@Inject
	public DefaultMeetingHandler(Project project) {
		this.project = project;
		meetings = new HashSet<Meeting>(); //TODO:how to implement ordering???
	}

	@Override
	public Meeting add(Meeting meeting) {
		meetings.add(meeting);
		return meeting;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Meeting add(Closure closure) throws URISyntaxException {
		Meeting meeting = new DefaultMeeting(project);
		ConfigureUtil.configure(closure, meeting);
		meetings.add(meeting);
		return meeting;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Meeting create(Closure closure) throws URISyntaxException {
		Meeting meeting = new DefaultMeeting(project);
		ConfigureUtil.configure(closure, meeting);
		meetings.add(meeting);
		return meeting;
	}

	@Override
	public Set<Meeting> getMeetings() {
		return meetings;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Meeting meeting(Closure closure) throws URISyntaxException {
		Meeting meeting = new DefaultMeeting(project);
		ConfigureUtil.configure(closure, meeting);
		meetings.add(meeting);
		return meeting;
	}
	
	@SuppressWarnings("rawtypes")
	public static Meeting meeting(Project project,Closure closure) throws URISyntaxException {
		Meeting meeting = new DefaultMeeting(project);
		ConfigureUtil.configure(closure, meeting);
		return meeting;
	}

}
