package setools.gradle.mbse;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.Test;

import setools.gradle.test.utils.GradleFunctionalTest;

public class MBSEPluginTest extends GradleFunctionalTest {

	@Test
	public void testApplyDefault() throws URISyntaxException, IOException {
		copyProjectResources("default-settings-test");
		BuildResult result = GradleRunner.create()
			.withProjectDir(testProjectDir.getRoot())
			.withPluginClasspath()
			.withArguments("task","--all")
			.build();
		assertNotNull(result);
		String output = result.getOutput();
		System.out.println(output);
		assertTrue(output.contains("model"));
		assertTrue(output.contains("simulate"));
		assertTrue(output.contains("report"));
		assertTrue(output.contains("document"));
		
	}

}
