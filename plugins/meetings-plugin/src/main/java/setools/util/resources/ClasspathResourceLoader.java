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
		return getClass().getResourceAsStream(path);
	}

}
