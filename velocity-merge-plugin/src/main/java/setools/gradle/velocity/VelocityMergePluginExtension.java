/**
 * 
 */
package setools.gradle.velocity;

import java.util.Properties;

import org.apache.velocity.VelocityContext;
import org.gradle.api.tasks.Input;

/**
 * @author matt
 *
 */
public interface VelocityMergePluginExtension {

	/** TODO:
	 * @return
	 */
	@Input
	public Properties getEngineProperties();

	//TODO:how to handle the setting??
	
	/** TODO:
	 * @return
	 */
	@Input
	public VelocityContext getContext();
	
	//TODO:how to handle setting???
}
