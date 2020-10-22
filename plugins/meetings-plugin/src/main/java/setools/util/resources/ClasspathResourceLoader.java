/**
 * TODO:license...
 */
package setools.util.resources;

import java.io.InputStream;

import setools.util.ClassUtils;

/**
 * TODO:documentation...
 */
public class ClasspathResourceLoader implements IResourceLoader {

	@Override
	public InputStream getResource(String resource) {
		String path = "/" + resource;
		return ClassUtils.getResourceAsStream(getClass(), path);
	}

}
