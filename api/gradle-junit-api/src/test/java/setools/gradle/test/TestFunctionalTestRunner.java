/**
 * TODO:
 */
package setools.gradle.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

import org.gradle.testkit.runner.BuildResult;
import org.junit.Ignore;
import static org.gradle.testkit.runner.TaskOutcome.*;

/**
 * TODO:
 */
public class TestFunctionalTestRunner {

	/** TODO:
	 * @param dir
	 * @param result
	 */
	@FunctionalTest(
		build="This should fail!!!!"
	)
	@Ignore
	public void testIgnoreHonored(File dir,BuildResult result) {
		fail("FunctionalTestRunner did not honor @Ignore.");
	}

	/** TODO:
	 * @param dir
	 * @param result
	 * @throws IOException 
	 */
	@FunctionalTest(build =
		"tasks.register('hello') {\r\n"
		+ "    doLast {\r\n"
		+ "        println 'Hello world!'\r\n"
		+ "    }\r\n"
		+ "}",
		arguments = "hello"
	)
	public void testBuild(File dir,BuildResult result) throws IOException {
		//validate build.gradle
		assertNotNull(dir);
		File buildGradle = new File(dir,"build.gradle");
		assertTrue(buildGradle.exists());
		byte[] bytes = Files.readAllBytes(buildGradle.toPath());
		String text = new String(bytes,Charset.defaultCharset());
		assertEquals(
				"tasks.register('hello') {\r\n"
				+ "    doLast {\r\n"
				+ "        println 'Hello world!'\r\n"
				+ "    }\r\n"
				+ "}",text);
		
		//validate success
		assertNotNull(result);
		assertNotNull(result.task("hello"));
		assertEquals(SUCCESS,result.task("hello").getOutcome());
	}
	
	/** TODO:
	 * @param dir
	 * @param result
	 * @throws IOException 
	 */
	@FunctionalTest(build = 
		"tasks.register('hello') {\r\n"
		+ "    doLast {\r\n"
		+ "        println 'Hello ' & project.name & '!'\r\n"
		+ "    }\r\n"
		+ "}",
		settings =
		"rootProject.name = 'Testing 123'"
	)
	public void testSettings(File dir,BuildResult result) throws IOException {
		//validate build.gradle
		assertNotNull(dir);
		File buildGradle = new File(dir,"build.gradle");
		assertTrue(buildGradle.exists());
		byte[] bytes = Files.readAllBytes(buildGradle.toPath());
		String text = new String(bytes,Charset.defaultCharset());
		assertEquals(
				"tasks.register('hello') {\r\n"
				+ "    doLast {\r\n"
				+ "        println 'Hello ' & project.name & '!'\\r\\n"
				+ "    }\r\n"
				+ "}",text);
		
		//TODO:validate settings.gradle
		File settingsGradle = new File(dir,"settings.gradle");
		assertTrue(settingsGradle.exists());
		bytes = Files.readAllBytes(settingsGradle.toPath());
		text = new String(bytes,Charset.defaultCharset());
		assertEquals("rootProject.name = 'Testing 123'",text);
		
		//validate success
		assertNotNull(result);
		assertNotNull(result.task("hello"));
		assertEquals(SUCCESS,result.task("hello").getOutcome());
		assertTrue(result.getOutput().contains("Hello Testing 123!"));
	}
	
	/** TODO:
	 * @param dir
	 * @param result
	 * @throws IOException 
	 */
	@FunctionalTest(build =
		"tasks.register('hello') {\r\n"
		+ "    doLast {\r\n"
		+ "        println 'Hello ' & project.name & '!'\r\n"
		+ "    }\r\n"
		+ "}",
		properties =
		"testProperty=Test 123"
	)
	public void testProperties(File dir,BuildResult result) throws IOException {
		//validate build.gradle
		assertNotNull(dir);
		File buildGradle = new File(dir,"build.gradle");
		assertTrue(buildGradle.exists());
		byte[] bytes = Files.readAllBytes(buildGradle.toPath());
		String text = new String(bytes,Charset.defaultCharset());
		assertEquals(
				"tasks.register('hello') {\r\n"
				+ "    doLast {\r\n"
				+ "        println 'Hello ' & testProperty & '!'\\r\\n"
				+ "    }\r\n"
				+ "}",text);
		
		//TODO:validate settings.gradle
		File settingsGradle = new File(dir,"gradle.properties");
		assertTrue(settingsGradle.exists());
		bytes = Files.readAllBytes(settingsGradle.toPath());
		text = new String(bytes,Charset.defaultCharset());
		assertEquals("testProperty=Test 123",text);
		
		//validate success
		assertNotNull(result);
		assertNotNull(result.task("hello"));
		assertEquals(SUCCESS,result.task("hello").getOutcome());
		assertTrue(result.getOutput().contains("Hello Testing 123!"));
	}
	
	/** TODO:
	 * @param dir
	 * @param result
	 */
	@FunctionalTest(build =
		"",
		resources =
		""
	)
	@Ignore //TODO: not ready to test this yet...
	public void testResources(File dir,BuildResult result) {
		//TODO:validate build.gradle
		//TODO:validate success
	}
}
