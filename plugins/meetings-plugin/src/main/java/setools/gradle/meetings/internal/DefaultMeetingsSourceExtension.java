/**
 * TODO:license...
 */
package setools.gradle.meetings.internal;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.gradle.api.file.SourceDirectorySet;
import org.gradle.api.model.ObjectFactory;

import setools.gradle.meetings.MeetingsSourceExtension;
import setools.gradle.meetings.dsl.Meeting;

/**
 * TODO:documentation...
 */
public class DefaultMeetingsSourceExtension implements 
MeetingsSourceExtension {
	
	/**
	 * TODO:documentation...
	 */
	protected final Map<String,SourceDirectorySet> meetings;

	/**
	 * TODO:documentation...
	 * @param name
	 * @param displayName
	 * @param objectFactory
	 */
	public DefaultMeetingsSourceExtension(String name,
			ObjectFactory objectFactory,Collection<Meeting> meetings) {
		this.meetings = new HashMap<String,SourceDirectorySet>();
		for(Meeting meeting : meetings) {
			String meetingName = meeting.getName();
			SourceDirectorySet dir = objectFactory.sourceDirectorySet(
					meetingName,"Source for " + meetingName);
			dir.srcDir("src/" + name + "/" + meetingName);
			this.meetings.put(meetingName,dir);
		}
	}

	@Override
	public SourceDirectorySet getMeeting(String name) {
		return meetings.get(name);
	}
	
}
