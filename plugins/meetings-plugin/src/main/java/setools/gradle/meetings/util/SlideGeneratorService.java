/**
 * TODO:license...
 */
package setools.gradle.meetings.util;

import java.util.Set;

import org.gradle.api.DefaultTask;

/**
 * TODO:documentation...
 */
public interface SlideGeneratorService {

	/**
	 * TODO:documentation...
	 * @return
	 */
	public Set<String> getSupportedFormats();
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public Set<Class<? extends DefaultTask>> getGenerators();
	
	/**
	 * TODO:documentation...
	 * @param format
	 * @return
	 */
	public Set<Class<? extends DefaultTask>> getGenerators(String format,Class<?>...types);

}
