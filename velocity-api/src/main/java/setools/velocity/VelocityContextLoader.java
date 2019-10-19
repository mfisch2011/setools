/**
 * 
 */
package setools.velocity;

import org.apache.velocity.VelocityContext;

/**
 * @author matt
 *
 */
public interface VelocityContextLoader {

	/** TODO:
	 * @param context
	 * @param input
	 * @return
	 */
	public boolean load(VelocityContext context,String input);
}
