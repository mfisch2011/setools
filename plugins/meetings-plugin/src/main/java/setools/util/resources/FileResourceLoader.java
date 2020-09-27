/**
 * TODO:license...
 */
package setools.util.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * TODO:documentation...
 */
public class FileResourceLoader implements IResourceLoader {

	/**
	 * TODO:documentation...
	 */
	protected final File root;
	
	/**
	 * TODO:documentation...
	 */
	public FileResourceLoader() {
		this(null);
	}
	
	/**
	 * TODO:documentation...
	 * @param root
	 */
	public FileResourceLoader(File root) {
		this.root = root;
	}
	
	@Override
	public InputStream getResource(String resource) {
		File file = (root==null) ? new File(resource) : 
			new File(root,resource);
		if(file.exists())
			try {
				return new FileInputStream(file);
			} catch (FileNotFoundException e) {
				//quietly ignore...
			}
		return null;
	}
}
