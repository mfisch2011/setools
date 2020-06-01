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
public class RiskManagementPluginTest extends GradleFunctionalTest {

	/**
	 * Test method for {@link setools.gradle.plugins.MeetingsPlugin#apply(org.gradle.api.Project)}.
	 * @throws IOException 
	 */
	@Test
	public void testRegisterMeetingTasks() throws IOException {
		copyProjectResources("test-basic-risk-review");
		//TODO:how to abstract this out since this pattern will be the same for all tests...
		BuildResult results = GradleRunner.create()
				.withProjectDir(dir)
				.withPluginClasspath()
				.withArguments("tasks","--all")
				.build();
		assertNotNull(results);
		String output = results.getOutput();
		assertNotNull(output);
		System.out.println(output); //TODO:debugging...
		assertTrue("Missing draftRiskReviewAgenda task",output.contains("draftRiskReviewAgenda"));
		assertTrue("Missing draftRiskReviewMinutes task",output.contains("draftRiskReviewMinutes"));
		assertTrue("Missing draftRiskReviewSlides task",output.contains("draftRiskReviewSlides"));
		assertTrue("Missing draftRiskReviewTitleSlide task",output.contains("draftRiskReviewTitleSlide"));
		assertTrue("Missing draftRiskReviewAgendaSlide task",output.contains("draftRiskReviewAgendaSlide"));
		assertTrue("Missing draftRiskReviewBackupsSlide task",output.contains("draftRiskReviewBackupsSlide"));
		//TODO:test risk review unique slides...
		assertTrue("Missing assembleRiskReviewPresentation task",output.contains("assembleRiskReviewPresentation"));
		assertTrue("Missing publishRiskReviewPresentation task",output.contains("publishRiskReviewPresentation"));
		assertTrue("Missing publishRiskReviewMinutes task",output.contains("publishRiskReviewMinutes"));
	}
	
	/**
	 * Test method for {@link setools.gradle.plugins.MeetingsPlugin#apply(org.gradle.api.Project)}.
	 * 
	 * TODO:is this better tested with an integration test using org.gradle.testfixtures.ProjectBuilder?
	 * 
	 * @throws IOException 
	 */
	@Test
	public void testDraftTestMeetingAgenda() throws IOException {
		copyProjectResources("test-basic-risk-review");
		//TODO:how to abstract this out since this pattern will be the same for all tests...
		BuildResult results = GradleRunner.create()
				.withProjectDir(dir)
				.withPluginClasspath()
				.withArguments("draftRiskReviewAgenda")
				.build();
		assertNotNull(results);
		String output = results.getOutput();
		assertNotNull(output);
		System.out.println(output);
		File buildDir = new File(dir,"src/meetings/Risk Review");//TODO:should the output be in the default build location?
		assertTrue("Missing " + buildDir.toString(),buildDir.exists());
		File agenda = new File(buildDir,"riskReviewAgenda.tex");
		assertTrue("Missing " + agenda.toString(),agenda.exists());
		byte[] bytes = Files.readAllBytes(agenda.toPath());
		//TODO:how to validate the LaTex file?  Simple string comparison?
	}
	
	/**
	 * Test method for {@link setools.gradle.plugins.MeetingsPlugin#apply(org.gradle.api.Project)}.
	 * 
	 * TODO:is this better tested with an integration test using org.gradle.testfixtures.ProjectBuilder?
	 * 
	 * @throws IOException 
	 */
	@Test
	public void testDraftTestMeetingMinutes() throws IOException {
		copyProjectResources("test-basic-risk-review");
		//TODO:how to abstract this out since this pattern will be the same for all tests...
		BuildResult results = GradleRunner.create()
				.withProjectDir(dir)
				.withPluginClasspath()
				.withArguments("draftRiskReviewMinutes")
				.build();
		assertNotNull(results);
		String output = results.getOutput();
		assertNotNull(output);
		System.out.println(output);
		File buildDir = new File(dir,"src/meetings/Risk Review");//TODO:should the output be in the default build location?
		assertTrue("Missing " + buildDir.toString(),buildDir.exists());
		File minutes = new File(buildDir,"riskReviewMinutes.tex");
		assertTrue("Missing " + minutes.toString(),minutes.exists());
		byte[] bytes = Files.readAllBytes(minutes.toPath());
		//TODO:how to validate the LaTex file?  Simple string comparison?
	}
	
	/**
	 * Test method for {@link setools.gradle.plugins.MeetingsPlugin#apply(org.gradle.api.Project)}.
	 * 
	 * TODO:is this better tested with an integration test using org.gradle.testfixtures.ProjectBuilder?
	 * 
	 * @throws IOException 
	 */
	@Test
	public void testDraftTestMeetingSlides() throws IOException {
		copyProjectResources("test-basic-risk-review");
		//TODO:how to abstract this out since this pattern will be the same for all tests...
		BuildResult results = GradleRunner.create()
				.withProjectDir(dir)
				.withPluginClasspath()
				.withArguments("draftRiskReviewSlides")
				.build();
		assertNotNull(results);
		String output = results.getOutput();
		assertNotNull(output);
		System.out.println(output);
		File buildDir = new File(dir,"src/meetings/Risk Review");//TODO:should the output be in the default build location?
		assertTrue("Missing " + buildDir.toString(),buildDir.exists());
		File title = new File(buildDir,"riskReviewTitleSlide.pptx");
		assertTrue("Missing " + title.toString(),title.exists());
		//TODO:validate contents of title....
		File agenda = new File(buildDir,"riskReviewAgendaSlide.pptx");
		assertTrue("Missing " + agenda.toString(),agenda.exists());
		//TODO:validate contents of agenda....
		File actionItems = new File(buildDir,"riskReviewActionItemReviewSlides.pptx");
		assertTrue("Missing " + actionItems.toString(),actionItems.exists());
		//TODO:validate contents of actionItems....
		File newRisks = new File(buildDir,"riskReviewNewRisksSlides.pptx");
		assertTrue("Missing " + newRisks.toString(),newRisks.exists());
		//TODO:validate contents of newRisks....
		File monitored = new File(buildDir,"riskReviewMonitoredRisksSlides.pptx");
		assertTrue("Missing " + monitored.toString(),monitored.exists());
		//TODO:validate contents of monitored....
		File riskClosure = new File(buildDir,"riskReviewRiskClosuresSlides.pptx");
		assertTrue("Missing " + riskClosure.toString(),riskClosure.exists());
		//TODO:validate contents of riskClosure...
		File comments = new File(buildDir,"riskReviewClosingCommentsSlides.pptx");
		assertTrue("Missing " + comments.toString(),comments.exists());
		//TODO:validate contents of comments....
		File backups = new File(buildDir,"riskReviewBackupsSlide.pptx");
		assertTrue("Missing " + backups.toString(),backups.exists());
		//TODO:validate contents of backups....
	}

	private void printDirectory(File buildDir) {
		if(buildDir!=null) {
			System.out.println(buildDir);
			for(File file : buildDir.listFiles()) {
				if(file.isDirectory())
					printDirectory(file);
				else
					System.out.println(file);
			}
		}
	}

	/**
	 * Test method for {@link setools.gradle.plugins.MeetingsPlugin#apply(org.gradle.api.Project)}.
	 * 
	 * TODO:is this better tested with an integration test using org.gradle.testfixtures.ProjectBuilder?
	 * 
	 * @throws IOException 
	 */
	@Test
	public void testAssembleTestMeetingPresentation() throws IOException {
		copyProjectResources("test-basic-risk-review");
		//TODO:how to abstract this out since this pattern will be the same for all tests...
		BuildResult results = GradleRunner.create()
				.withProjectDir(dir)
				.withPluginClasspath()
				.withArguments("assembleRiskReviewPresentation")
				.build();
		assertNotNull(results);
		String output = results.getOutput();
		assertNotNull(output);
		System.out.println(output);
		File buildDir = new File(dir,"src/meetings/Risk Review");//TODO:should the output be in the default build location?
		assertTrue("Missing " + buildDir.toString(),buildDir.exists());
		File presentation = new File(buildDir,"riskReviewPresentation.pptx");
		assertTrue("Missing " + presentation.toString(),presentation.exists());
		//TODO:validate contents of presentation....
	}
	
	/**
	 * Test method for {@link setools.gradle.plugins.MeetingsPlugin#apply(org.gradle.api.Project)}.
	 * 
	 * TODO:is this better tested with an integration test using org.gradle.testfixtures.ProjectBuilder?
	 * 
	 * @throws IOException 
	 */
	@Test
	public void testPublishTestMeetingMinutes() throws IOException {
		copyProjectResources("test-basic-risk-review");
		//TODO:how to abstract this out since this pattern will be the same for all tests...
		BuildResult results = GradleRunner.create()
				.withProjectDir(dir)
				.withPluginClasspath()
				.withArguments("publishRiskReviewMinutes")
				.build();
		assertNotNull(results);
		String output = results.getOutput();
		assertNotNull(output);
		System.out.println(output);
		File buildDir = new File(dir,"src/meetings/Risk Review");//TODO:should the output be in the default build location?
		assertTrue("Missing " + buildDir.toString(),buildDir.exists());
		File presentation = new File(buildDir,"riskReviewPresentation.pptx");
		assertTrue("Missing " + presentation.toString(),presentation.exists());
		//TODO:validate contents of presentation....
	}
}
