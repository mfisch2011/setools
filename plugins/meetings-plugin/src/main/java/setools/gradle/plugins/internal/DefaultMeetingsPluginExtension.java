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
package setools.gradle.plugins.internal;

import java.util.Collection;
import java.util.Collections;
import javax.inject.Inject;

import org.gradle.api.Project;
import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meeting.api.Meeting;
import setools.gradle.meeting.api.MeetingsHandler;
import setools.gradle.meeting.api.internal.DefaultMeetingHandler;
import setools.gradle.plugins.MeetingsPluginExtension;

/**
 * @author matt
 *
 */
public class DefaultMeetingsPluginExtension implements MeetingsPluginExtension {

	protected final Project project;
	
	protected MeetingsHandler meetings;

	@Inject
	public DefaultMeetingsPluginExtension(Project project) {
		this.project = project;
		this.meetings = new DefaultMeetingHandler(project);
	}
	
	@Override
	public Collection<Meeting> getMeetings() {
		return Collections.unmodifiableCollection(meetings.getMeetings());
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void meetings(Closure closure) {
		ConfigureUtil.configure(closure, meetings);
	}

}
