/**
 * 
 */
package setools.gradle.test.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.HashSet;

import org.gradle.internal.impldep.org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

/**
 * @author matt.fischer
 *
 */
public class GradleFunctionalTest {

	@Rule
	public TemporaryFolder testProjectDir = new TemporaryFolder();
	
	@Before
	public void setup() {
		//TODO:stub...
	}
	
	@After
	public void cleanup() {
		testProjectDir.delete();
	}
	
	protected void copyProjectResources(String path) throws
	URISyntaxException, IOException 
	{
		ClassLoader classloader = getClass().getClassLoader();
		String basePath = getClass().getPackage().getName().replace(".", "/") + "/" + path;
		URL baseUrl = classloader.getResource(basePath + "/build.gradle");
		baseUrl = getParent(baseUrl);
		for(URL resource : getResourcesRecursively(baseUrl)) {
			copyResourceWithPath(baseUrl,resource,testProjectDir.getRoot());
		}
	}
	
	protected static URL getParent(URL url) throws MalformedURLException, URISyntaxException {
		URI uri = url.toURI();
		URI parent = (uri.getPath().endsWith("/")) ? uri.resolve("..") : uri.resolve(".");
		return parent.toURL();
	}

	protected void copyResourceWithPath(URL root,URL resource, File dir) throws
	URISyntaxException, IOException 
	{
		Path resourcePath = relativize(root,resource);
		Path targetPath = dir.toPath().resolve(resourcePath);
		if(targetPath.getParent()==null && !targetPath.getParent().toFile().exists()) {
			Files.createDirectories(targetPath.getParent());
		}
		InputStream stream = resource.openStream();
		FileUtils.copyInputStreamToFile(stream,targetPath.toFile());
		stream.close();
	}

	protected Path relativize(URL root,URL path) throws
	URISyntaxException 
	{
		Path basePath = Paths.get(root.toURI());
		return basePath.relativize(Paths.get(path.toURI()));
	}

	protected Set<URL> getResourcesRecursively(URL baseUrl) throws MalformedURLException, UnsupportedEncodingException {
		Set<URL> results = new HashSet<URL>();
		if(baseUrl!=null) {
			String protocol = baseUrl.getProtocol();
			if(protocol.startsWith("jar:")) {
				//handle resources inside jar files
			} else if(protocol.startsWith("file")) {
				String decoded = URLDecoder.decode(baseUrl.getPath(),"UTF-8");
				File dir = new File(decoded).getParentFile();
				results.addAll(search(dir));
			}
		}
		return results;
	}
	
	public static Set<URL> search(File root) throws MalformedURLException {
		Set<URL> results = new HashSet<URL>();
		for(File file : root.listFiles()) {
			if(file.isDirectory())
				results.addAll(search(file));
			else {
				URL url = file.toURI().toURL();
				results.add(url);
			}
		}
		return results;
	}
}
