/**
 * 
 */
package setools.gradle.test.utils;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.Collection;
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
	
	protected void copyProjectResources(String path) throws MalformedURLException {
		System.out.println("WTF1");
		for(URL resource : getResourcesRecursively(path)) {
			System.out.println("WTF2");
			copyResourceWithPath(path,resource,testProjectDir.getRoot());
			System.out.println("WTF3");
		}
	}

	protected void copyResourceWithPath(String path,URL resource, File root) {
		Path resourcePath = relativize(path,resource.getPath());
		//TODO:create all parent directories...
		//Path targetPath = root.toPath().resolve(resourcePath);
		//InputStream stream = resource.openStream();
		//FileUtils.copyInputStreamToFile(stream,targetPath.toFile());
		//stream.close();
	}

	protected Path relativize(String root,String path) {
		// TODO Auto-generated method stub
		System.out.printf("RELITIVIZE PATH: %s with %s%n", path,root);
		return null;
	}

	protected Set<URL> getResourcesRecursively(String path) throws MalformedURLException {
		System.out.println("WTF A");
		Set<URL> results = new HashSet<URL>();
		ClassLoader classloader = getClass().getClassLoader();
		String basePath = getClass().getPackage().getName().replace(".", "/") + "/" + path;
		System.out.printf("BASE: %s%n",basePath);
		URL baseRoot = classloader.getResource(basePath + "/build.gradle");
		System.out.printf("BASE URL: %s%n",baseRoot);
		if(baseRoot!=null) {
			String protocol = baseRoot.getProtocol();
			System.out.printf("PROTOCOL: %s%n",protocol);
			if(protocol.startsWith("jar:")) {
				//handle resources inside jar files
			} else if(protocol.startsWith("file")) {
				File dir = new File(baseRoot.getPath()).getParentFile();
				results.addAll(convertFilesToUrl(baseRoot,search(dir)));
			}
		}
		return results;
	}
	
	protected static Set<URL> convertFilesToUrl(URL baseRoot, Set<File> files) throws MalformedURLException {
		Set<URL> results = new HashSet<URL>();
		for(File file : files) {
			URL url = new URL(baseRoot,file.getPath());
			System.out.printf("Convert %s to %s", file,url);
			results.add(url);
		}
		return results;
	}

	public static Set<File> search(File root) {
		System.out.printf("SEARCH: %s%n", root);
		Set<File> results = new HashSet<File>();
		for(File file : root.listFiles()) {
			if(file.isDirectory())
				results.addAll(search(file));
			else
				results.add(file);
		}
		return results;
	}
}
