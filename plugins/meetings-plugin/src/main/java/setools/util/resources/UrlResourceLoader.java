/**
 * TODO:license...
 */
package setools.util.resources;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * TODO:documentation...
 */
public class UrlResourceLoader implements IResourceLoader {
	
	/**
	 * TODO:documentation...
	 */
	protected final URL root;
	
	/**
	 * TODO:documentation...
	 */
	public UrlResourceLoader() {
		root = null;
	}
	
	/**
	 * TODO:documentation...
	 * @param root
	 */
	public UrlResourceLoader(URL root) {
		this.root = root;
	}

	@Override
	public InputStream getResource(String resource) {
		try {
			URL url = (root==null) ? new URL(resource) : 
				new URL(root,resource);
			return url.openStream();
		} catch(IOException e) {
			//quitely ignore...
		}
		return null;
	}

}
