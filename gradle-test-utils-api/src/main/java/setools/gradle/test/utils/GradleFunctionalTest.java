/**
 * 
 */
package setools.gradle.test.utils;

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
	
	protected void copyResourcesRecursively(String path) {
		//TODO:stub...
	}
}
