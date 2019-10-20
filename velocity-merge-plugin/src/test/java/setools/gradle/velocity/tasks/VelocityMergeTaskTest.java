/**
 * 
 */
package setools.gradle.velocity.tasks;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.Test;

import setools.gradle.test.utils.GradleFunctionalTest;

import static org.gradle.testkit.runner.TaskOutcome.*;

/**
 * @author matt
 *
 */
public class VelocityMergeTaskTest extends GradleFunctionalTest {

	/**
	 * Test method for {@link setools.gradle.velocity.VelocityMergeTask#VelocityMergeTask(org.gradle.api.internal.project.ProjectInternal, org.gradle.api.model.ObjectFactory, setools.gradle.velocity.VelocityMergePluginExtension, setools.gradle.velocity.VelocityMergeTaskExtension)}.
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	@Test
	public void test1() throws URISyntaxException, IOException { //TODO:more descriptive name...
		copyProjectResources("test-basic-settings");
		BuildResult result = GradleRunner.create()
				.withProjectDir(testProjectDir.getRoot())
				.withPluginClasspath()
				.withArguments("velocityMerge")
				.build();
		assertNotNull(result);
		assertEquals(SUCCESS,result.task(":velocityMerge").getOutcome());
	}

}
