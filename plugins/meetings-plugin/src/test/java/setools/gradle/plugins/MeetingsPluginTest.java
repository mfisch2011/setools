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
public class MeetingsPluginTest extends GradleFunctionalTest {

	/**
	 * Test method for {@link setools.gradle.plugins.MeetingsPlugin#apply(org.gradle.api.Project)}.
	 * @throws IOException 
	 */
	@Test
	public void testRegisterMeetingTasks() throws IOException {
		copyProjectResources("test-basic-meeting");
		//TODO:how to abstract this out since this pattern will be the same for all tests...
		BuildResult results = GradleRunner.create()
				.withProjectDir(dir)
				.withPluginClasspath()
				.withArguments("tasks","--all")
				.build();
		assertNotNull(results);
		String output = results.getOutput();
		assertNotNull(output);
		assertTrue("Missing draftAgenda task",output.contains("draftTestMeetingAgenda"));
		assertTrue("Missing draftAgenda task",output.contains("draftTestMeetingMinutes"));
		assertTrue("Missing draftAgenda task",output.contains("draftTestMeetingSlides"));
		assertTrue("Missing draftAgenda task",output.contains("draftTestMeetingTitleSlide"));
		assertTrue("Missing draftAgenda task",output.contains("draftTestMeetingAgendaSlide"));
		assertTrue("Missing draftAgenda task",output.contains("draftTestMeetingBackupsSlide"));
		assertTrue("Missing draftAgenda task",output.contains("assembleTestMeetingPresentation"));
		assertTrue("Missing draftAgenda task",output.contains("publishTestMeetingPresentation"));
		assertTrue("Missing draftAgenda task",output.contains("publishTestMeetingMinutes"));
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
		copyProjectResources("test-basic-meeting");
		//TODO:how to abstract this out since this pattern will be the same for all tests...
		BuildResult results = GradleRunner.create()
				.withProjectDir(dir)
				.withPluginClasspath()
				.withArguments("draftTestMeetingAgenda")
				.build();
		assertNotNull(results);
		String output = results.getOutput();
		assertNotNull(output);
		System.out.println(output);
		File buildDir = new File(dir,"src/meetings/Test Meeting");//TODO:should the output be in the default build location?
		assertTrue("Missing " + buildDir.toString(),buildDir.exists());
		File agenda = new File(buildDir,"testMeetingAgenda.tex");
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
		copyProjectResources("test-basic-meeting");
		//TODO:how to abstract this out since this pattern will be the same for all tests...
		BuildResult results = GradleRunner.create()
				.withProjectDir(dir)
				.withPluginClasspath()
				.withArguments("draftTestMeetingMinutes")
				.build();
		assertNotNull(results);
		String output = results.getOutput();
		assertNotNull(output);
		System.out.println(output);
		File buildDir = new File(dir,"src/meetings/Test Meeting");//TODO:should the output be in the default build location?
		assertTrue("Missing " + buildDir.toString(),buildDir.exists());
		File minutes = new File(buildDir,"testMeetingMinutes.tex");
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
		copyProjectResources("test-basic-meeting");
		//TODO:how to abstract this out since this pattern will be the same for all tests...
		BuildResult results = GradleRunner.create()
				.withProjectDir(dir)
				.withPluginClasspath()
				.withArguments("draftTestMeetingSlides")
				.build();
		assertNotNull(results);
		String output = results.getOutput();
		assertNotNull(output);
		System.out.println(output);
		File buildDir = new File(dir,"src/meetings/Test Meeting");//TODO:should the output be in the default build location?
		assertTrue("Missing " + buildDir.toString(),buildDir.exists());
		File title = new File(buildDir,"testMeetingTitleSlide.pptx");
		assertTrue("Missing " + title.toString(),title.exists());
		//TODO:validate contents of title....
		File agenda = new File(buildDir,"testMeetingAgendaSlide.pptx");
		assertTrue("Missing " + agenda.toString(),agenda.exists());
		//TODO:validate contents of agenda....
		File backups = new File(buildDir,"testMeetingBackupsSlide.pptx");
		assertTrue("Missing " + backups.toString(),backups.exists());
		//TODO:validate contents of backups....
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
		copyProjectResources("test-basic-meeting");
		//TODO:how to abstract this out since this pattern will be the same for all tests...
		BuildResult results = GradleRunner.create()
				.withProjectDir(dir)
				.withPluginClasspath()
				.withArguments("assembleTestMeetingPresentation")
				.build();
		assertNotNull(results);
		String output = results.getOutput();
		assertNotNull(output);
		System.out.println(output);
		File buildDir = new File(dir,"src/meetings/Test Meeting");//TODO:should the output be in the default build location?
		assertTrue("Missing " + buildDir.toString(),buildDir.exists());
		File presentation = new File(buildDir,"testMeetingPresentation.pptx");
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
		copyProjectResources("test-basic-meeting");
		//TODO:how to abstract this out since this pattern will be the same for all tests...
		BuildResult results = GradleRunner.create()
				.withProjectDir(dir)
				.withPluginClasspath()
				.withArguments("publishTestMeetingMinutes")
				.build();
		assertNotNull(results);
		String output = results.getOutput();
		assertNotNull(output);
		System.out.println(output);
		File buildDir = new File(dir,"src/meetings/Test Meeting");//TODO:should the output be in the default build location?
		assertTrue("Missing " + buildDir.toString(),buildDir.exists());
		File presentation = new File(buildDir,"testMeetingPresentation.pptx");
		assertTrue("Missing " + presentation.toString(),presentation.exists());
		//TODO:validate contents of presentation....
	}
}
