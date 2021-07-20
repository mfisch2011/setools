/**
 * TODO: add NSWC Crane's license...
 */
package setools.gradle.test;


import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.gradle.testkit.runner.BuildResult;
import org.junit.Ignore;
import org.junit.runner.RunWith;

/**
 * TODO:add documentation...
 *
 */
@RunWith(FunctionalTestRunner.class)
public class FunctionalTestRunnerTest {

	@FunctionalTest(build =
	"plugins {" +
	"  id 'java'" +
	"}"
	)
	@Ignore //TODO:how to test w/o a plugin-under-test-metadata.properties file???
	public void testBuild(BuildResult result,File dir) {
		System.out.println("WTF!!!!");
		assertNotNull(result);
		assertNotNull(dir);
		System.out.println(result.getOutput());
	}

}
