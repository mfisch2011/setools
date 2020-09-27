/**
 * TODO:license...
 */
package setools.gradle.meetings;

import java.io.File;

import org.gradle.api.file.SourceDirectorySet;

/**
 * TODO:documentation...
 */
public interface MeetingSource extends SourceDirectorySet {

	/**
	 * TODO:documentation...
	 * @return
	 */
	public File getMeetingDir();
	
	/**
	 * TODO:documentation...
	 * @param object
	 */
	public void setMeetingDir(Object object);
	
}
