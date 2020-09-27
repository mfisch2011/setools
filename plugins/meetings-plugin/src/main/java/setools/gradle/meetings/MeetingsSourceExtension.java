/**
 * TODO:license...
 */
package setools.gradle.meetings;

import org.gradle.api.file.SourceDirectorySet;

/**
 * TODO:documentation...
 */
public interface MeetingsSourceExtension {

	/**
	 * TODO:documentation...
	 * @param name
	 * @return
	 */
	public SourceDirectorySet getMeeting(String name);
	
}
