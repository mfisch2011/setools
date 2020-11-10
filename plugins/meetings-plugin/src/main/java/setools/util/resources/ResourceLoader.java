/**
 * TODO:license...
 */
package setools.util.resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * TODO:documentation...
 */
public class ResourceLoader {
	
	/**
	 * TODO:documentation...
	 */
	private static Properties properties = initialize();
	
	/**
	 * TODO:documentation...
	 */
	private synchronized static Properties properties() {
		if(properties==null) {
			properties = new Properties();
		}
		return properties;
	}
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	private static Properties initialize() {
		properties().setProperty("resource.loader", "absolute.file,classpath");
		properties().setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		properties().setProperty("absolute.file.resource.loader.class",FileResourceLoader.class.getName());
		properties().setProperty("absolute.file.resource.loader.path", "");
		return properties();
	}
	
	/**
	 * TODO:documentation...
	 * @param properties
	 */
	public synchronized static void configure(Properties properties) {
		ResourceLoader.properties.clear();
		ResourceLoader.properties.putAll(properties);
	}
	
	/**
	 * singleton
	 */
	private ResourceLoader() {
		//singleton
	}

	/**
	 * TODO:documentation...
	 * @param resource
	 * @return
	 * @throws IOException
	 */
	public static InputStream getResource(String resource) throws IOException {
		String resource_loaders = properties().getProperty("resource.loader");
		String[] loaders = resource_loaders.split(",");
		for(String loader : loaders) {
			String type = properties().getProperty(loader + ".resource.loader.class");
			if(type!=null) {
				//TODO:change this to support custom loaders...
				//TODO:change this to be more efficient (i.e. loaders not created every call...)
				if(type.equals(FileResourceLoader.class.getName())) {
					String root = properties().getProperty(loader + ".resource.loader.path");
					System.out.printf("SEARCHING: %s%n",root);
					FileResourceLoader actualLoader = (root==null) ? 
							new FileResourceLoader() : new FileResourceLoader(new File(root));
					InputStream result = actualLoader.getResource(resource);
					if(result!=null)
						return result;
				} else if(type.equals(ClasspathResourceLoader.class.getName())) {
					ClasspathResourceLoader actualLoader = new ClasspathResourceLoader();
					System.out.printf("SEARCHING CLASSPATH%n");
					InputStream result = actualLoader.getResource(resource);
					if(result!=null)
						return result;
				} else if(type.equals(UrlResourceLoader.class.getName())) {
					String root = properties().getProperty(loader + ".resource.loader.url");
					UrlResourceLoader actualLoader = (root==null) ? 
							new UrlResourceLoader() : new UrlResourceLoader(new URL(root));
					InputStream result = actualLoader.getResource(resource);
					if(result!=null)
						return result;
				}
			}
		}
		String msg = String.format("Resource %s not found.", resource);
		throw new FileNotFoundException(msg);
	}
}
