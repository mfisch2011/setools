/**
 * 
 */
package setools.velocity;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.apache.velocity.VelocityContext;

/**
 * @author matt
 *
 */
public class VelocityContextLoaderService {

	private static ServiceLoader<VelocityContextLoader> serviceLoader =
			ServiceLoader.load(VelocityContextLoader.class);
	
	//using singleton pattern
	private VelocityContextLoaderService() { }
	
	public static boolean load(VelocityContext context,String input) {
		Iterator<VelocityContextLoader> iter = serviceLoader.iterator();
		boolean found = false;
		if(iter.hasNext() && !found) {
			VelocityContextLoader loader = iter.next();
			found = loader.load(context,input);
		}
		return found;
	}
}
