/**
 * 
 */
package setools.gradle.velocity;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.Test;

import setools.gradle.test.utils.GradleFunctionalTest;

/**
 * @author matt
 *
 */
public class VelocityMergePluginTest extends GradleFunctionalTest {

	/**
	 * Test method for {@link setools.gradle.velocity.VelocityMergePlugin#apply(org.gradle.api.internal.project.ProjectInternal)}.
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	@Test
	public void testApply() throws URISyntaxException, IOException {
		copyProjectResources("test-default-settings");
		BuildResult result = GradleRunner.create()
				.withProjectDir(testProjectDir.getRoot())
				.withPluginClasspath()
				.withArguments("task","--all")
				.build();
		assertNotNull(result);
		System.out.println(result.getOutput()); //TODO:temp remove
		String output = result.getOutput();
		assertTrue(output.contains("velocityMerge"));
		//TODO:test default extension settings
	}

}
