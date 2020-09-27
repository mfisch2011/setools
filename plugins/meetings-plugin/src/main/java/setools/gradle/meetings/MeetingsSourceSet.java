/**
 * TODO:license...
 */
package setools.gradle.meetings;

import org.gradle.api.tasks.SourceSet;

/**
 * TODO:documentation...
 */
public interface MeetingsSourceSet extends SourceSet {

	/**
	 * TODO:documentation...
	 * @param name
	 * @return
	 */
	public MeetingSource getMeeting(String name);
	
}
