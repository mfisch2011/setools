/**
 * TODO:license...
 */
package setools.util.resources;

import java.io.InputStream;

/**
 * TODO:documentation...
 */
public class ClasspathResourceLoader implements IResourceLoader {

	@Override
	public InputStream getResource(String resource) {
		String path = "/" + resource;
		System.out.printf("SEARCHING FOR: '%s'%n",path);
		return getClass().getResourceAsStream(path);
	}

}
