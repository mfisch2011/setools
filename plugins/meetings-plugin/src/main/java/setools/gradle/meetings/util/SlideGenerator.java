/**
 * TODO:license...
 */
package setools.gradle.meetings.util;

import java.io.File;

import org.gradle.api.Task;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.OutputFile;

/**
 * TODO:documentation...
 */
public interface SlideGenerator extends Task {

	/**
	 * TODO:documentation...
	 * @return
	 */
	@Input
	public String getFormat();
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	@OutputFile
	public File getOutput();
	
	/**
	 * TODO:documentation...
	 * @param object
	 */
	public void setOutput(Object object);
}
