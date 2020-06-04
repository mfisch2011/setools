/**
   Copyright 2020 Matt Fischer <mfish2011@gmail.com>

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package setools.gradle.plugins;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.Test;

import setools.gradle.test.GradleFunctionalTest;

/**
 * TODO:
 */
public class LaTeXRiskReviewPluginTest extends GradleFunctionalTest {

	/**
	 * Test method for {@link setools.gradle.plugins.LaTeXRiskReviewPlugin#apply(org.gradle.api.Project)}.
	 * @throws IOException 
	 */
	@Test
	public void testCreateTasks() throws IOException {
		copyProjectResources("test-basic-risk-review");
		BuildResult results = GradleRunner.create()
				.withProjectDir(dir)
				.withPluginClasspath()
				.withArguments("tasks","--all")
				.build();
		assertNotNull(results);
		String output = results.getOutput();
		assertNotNull(output);
		assertTrue("Missing draftRiskReviewAgenda task",output.contains("draftRiskReviewAgenda"));
		assertTrue("Missing draftRiskReviewMinutes task",output.contains("draftRiskReviewMinutes"));
		assertTrue("Missing draftRiskReviewSlides task",output.contains("draftRiskReviewSlides"));
		assertTrue("Missing assembleRiskReviewPresentation task",output.contains("assembleRiskReviewPresentation"));
		assertTrue("Missing publishRiskReviewPresentation task",output.contains("publishRiskReviewPresentation"));
		assertTrue("Missing publishRiskReviewMinutes task",output.contains("publishRiskReviewMinutes"));
	}

	@Test
	public void testPublishMinutes() throws IOException {
		copyProjectResources("test-basic-risk-review");
		BuildResult results = GradleRunner.create()
				.withProjectDir(dir)
				.withPluginClasspath()
				.withArguments("publishRiskReviewMinutes")
				.build();
		assertNotNull(results);
		String output = results.getOutput();
		assertNotNull(output);
		//TODO:validate products generated...
		fail("Not implemented yet");
	}
	
	@Test
	public void testDraftSlides() throws IOException {
		copyProjectResources("test-basic-risk-review");
		BuildResult results = GradleRunner.create()
				.withProjectDir(dir)
				.withPluginClasspath()
				.withArguments("draftRiskReviewSlides")
				.build();
		assertNotNull(results);
		String output = results.getOutput();
		assertNotNull(output);
		System.out.println(output); //TODO:for debugging...
		//TODO:validate products generated...
		File buildDir = new File(dir,"src/project/meetings/Risk Review");
		assertTrue("Missing src/meetings/Risk Review/",buildDir.exists());
		File presentation = new File(buildDir,"presentation.tex");
		assertTrue("Missing presentation.tex",presentation.exists());
		byte[] bytes = Files.readAllBytes(presentation.toPath());
		String text = new String(bytes);
		System.out.println(text); //TODO:debugging...
		fail("Not implemented yet");
	}
}
