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
import org.gradle.testkit.runner.BuildResult;
import setools.gradle.test.GradleTest;

/**
 * TODO:
 */
//TODO: WTFF is this broken?! @RunWith(GradleTestRunner.class)
public class MeetingsPluginTest {

	/**
	 * Test method for {@link setools.gradle.plugins.MeetingsPlugin#apply(org.gradle.api.Project)}.
	 * @throws IOException 
	 */
	@GradleTest(args={"tasks"},build=
	"plugins {\r\n"
	+ "	id \"setools.gradle.plugins.MeetingsPlugin\"\r\n"
	+ "}\r\n"
	+ "\r\n"
	+ "meetingsPlugin {\r\n"
	+ "	meetings {\r\n"
	+ "		meeting {\r\n"
	+ "			name = \"Test Meeting\"\r\n"
	+ "			description = \"Create a fake meeting to test basic settings.\"\r\n"
	+ "			date = \"1/1/2020\"\r\n"
	+ "			time = \"14:00\"\r\n"
	+ "			attendees = [\"Billy Joe Bob\",\"Pinky\",\"Brain\"]\r\n"
	+ "			location = \"Super Secret Conference Room\"\r\n"
	+ "		}\r\n"
	+ "	}\r\n"
	+ "}")
	public void testRegisterMeetingTasks(BuildResult result,File dir) {
		assertNotNull(result);
		String output = result.getOutput();
		assertNotNull(output);
		assertTrue("Missing draftAgenda task",output.contains("draftTestMeetingAgenda"));
		assertTrue("Missing draftMinutes task",output.contains("draftTestMeetingMinutes"));
		assertTrue("Missing draftSlides task",output.contains("draftTestMeetingSlides"));
		assertTrue("Missing draftTitleSlide task",output.contains("draftTestMeetingTitleSlide"));
		assertTrue("Missing draftAgendaSlide task",output.contains("draftTestMeetingAgendaSlide"));
		assertTrue("Missing draftBackupsSlide task",output.contains("draftTestMeetingBackupsSlide"));
		assertTrue("Missing assemblePresentation task",output.contains("assembleTestMeetingPresentation"));
		assertTrue("Missing publishPresentation task",output.contains("publishTestMeetingPresentation"));
		assertTrue("Missing publishMinutes task",output.contains("publishTestMeetingMinutes"));
	}
	
	/**
	 * Test method for {@link setools.gradle.plugins.MeetingsPlugin#apply(org.gradle.api.Project)}.
	 * 
	 * TODO:is this better tested with an integration test using org.gradle.testfixtures.ProjectBuilder?
	 * 
	 * @throws IOException 
	 */
	@GradleTest(args= {"draftTestMeetingAgenda"},build=
	"plugins {\r\n"
	+ "	id \"setools.gradle.plugins.MeetingsPlugin\"\r\n"
	+ "}\r\n"
	+ "\r\n"
	+ "meetingsPlugin {\r\n"
	+ "	meetings {\r\n"
	+ "		meeting {\r\n"
	+ "			name = \"Test Meeting\"\r\n"
	+ "			description = \"Create a fake meeting to test basic settings.\"\r\n"
	+ "			date = \"1/1/2020\"\r\n"
	+ "			time = \"14:00\"\r\n"
	+ "			attendees = [\"Billy Joe Bob\",\"Pinky\",\"Brain\"]\r\n"
	+ "			location = \"Super Secret Conference Room\"\r\n"
	+ "		}\r\n"
	+ "	}\r\n"
	+ "}")
	public void testDraftTestMeetingAgenda(BuildResult result,File dir) {
		assertNotNull(result);
		String output = result.getOutput();
		assertNotNull(output);
		System.out.println(output);
		File buildDir = new File(dir,"src/meetings/Test Meeting");
		assertTrue("Missing " + buildDir.toString(),buildDir.exists());
		File agenda = new File(buildDir,"testMeetingAgenda.docx");
		assertTrue("Missing " + agenda.toString(),agenda.exists());
		//TOOD:validate contents...
	}
	
	/**
	 * Test method for {@link setools.gradle.plugins.MeetingsPlugin#apply(org.gradle.api.Project)}.
	 * 
	 * TODO:is this better tested with an integration test using org.gradle.testfixtures.ProjectBuilder?
	 * 
	 * @throws IOException 
	 */
	@GradleTest(args= {"draftTestMeetingMinutes"}, build=
	"plugins {\r\n"
	+ "	id \"setools.gradle.plugins.MeetingsPlugin\"\r\n"
	+ "}\r\n"
	+ "\r\n"
	+ "meetingsPlugin {\r\n"
	+ "	meetings {\r\n"
	+ "		meeting {\r\n"
	+ "			name = \"Test Meeting\"\r\n"
	+ "			description = \"Create a fake meeting to test basic settings.\"\r\n"
	+ "			date = \"1/1/2020\"\r\n"
	+ "			time = \"14:00\"\r\n"
	+ "			attendees = [\"Billy Joe Bob\",\"Pinky\",\"Brain\"]\r\n"
	+ "			location = \"Super Secret Conference Room\"\r\n"
	+ "		}\r\n"
	+ "	}\r\n"
	+ "}")
	public void testDraftTestMeetingMinutes(BuildResult result,File dir) {
		assertNotNull(result);
		String output = result.getOutput();
		assertNotNull(output);
		System.out.println(output);
		File buildDir = new File(dir,"src/meetings/Test Meeting");
		assertTrue("Missing " + buildDir.toString(),buildDir.exists());
		File minutes = new File(buildDir,"testMeetingMinutes.docx");
		assertTrue("Missing " + minutes.toString(),minutes.exists());
		//TODO:validate contents...
	}
	
	/**
	 * Test method for {@link setools.gradle.plugins.MeetingsPlugin#apply(org.gradle.api.Project)}.
	 * 
	 * TODO:is this better tested with an integration test using org.gradle.testfixtures.ProjectBuilder?
	 * 
	 * @throws IOException 
	 */
	@GradleTest(args= {"draftTestMeetingSlides"}, build=
	"plugins {\r\n"
	+ "	id \"setools.gradle.plugins.MeetingsPlugin\"\r\n"
	+ "}\r\n"
	+ "\r\n"
	+ "meetingsPlugin {\r\n"
	+ "	meetings {\r\n"
	+ "		meeting {\r\n"
	+ "			name = \"Test Meeting\"\r\n"
	+ "			description = \"Create a fake meeting to test basic settings.\"\r\n"
	+ "			date = \"1/1/2020\"\r\n"
	+ "			time = \"14:00\"\r\n"
	+ "			attendees = [\"Billy Joe Bob\",\"Pinky\",\"Brain\"]\r\n"
	+ "			location = \"Super Secret Conference Room\"\r\n"
	+ "		}\r\n"
	+ "	}\r\n"
	+ "}")
	public void testDraftTestMeetingSlides(BuildResult result,File dir) {
		assertNotNull(result);
		String output = result.getOutput();
		assertNotNull(output);
		System.out.println(output);
		File buildDir = new File(dir,"src/meetings/Test Meeting");
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
	@GradleTest(args= {"assembleTestMeetingPresentation"}, build=
	"plugins {\r\n"
	+ "	id \"setools.gradle.plugins.MeetingsPlugin\"\r\n"
	+ "}\r\n"
	+ "\r\n"
	+ "meetingsPlugin {\r\n"
	+ "	meetings {\r\n"
	+ "		meeting {\r\n"
	+ "			name = \"Test Meeting\"\r\n"
	+ "			description = \"Create a fake meeting to test basic settings.\"\r\n"
	+ "			date = \"1/1/2020\"\r\n"
	+ "			time = \"14:00\"\r\n"
	+ "			attendees = [\"Billy Joe Bob\",\"Pinky\",\"Brain\"]\r\n"
	+ "			location = \"Super Secret Conference Room\"\r\n"
	+ "		}\r\n"
	+ "	}\r\n"
	+ "}")
	public void testAssembleTestMeetingPresentation(BuildResult result,File dir) {
		assertNotNull(result);
		String output = result.getOutput();
		assertNotNull(output);
		System.out.println(output);
		File buildDir = new File(dir,"src/meetings/Test Meeting");
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
	@GradleTest(args= {"publishTestMeetingMinutes"}, build=
	"plugins {\r\n"
	+ "	id \"setools.gradle.plugins.MeetingsPlugin\"\r\n"
	+ "}\r\n"
	+ "\r\n"
	+ "meetingsPlugin {\r\n"
	+ "	meetings {\r\n"
	+ "		meeting {\r\n"
	+ "			name = \"Test Meeting\"\r\n"
	+ "			description = \"Create a fake meeting to test basic settings.\"\r\n"
	+ "			date = \"1/1/2020\"\r\n"
	+ "			time = \"14:00\"\r\n"
	+ "			attendees = [\"Billy Joe Bob\",\"Pinky\",\"Brain\"]\r\n"
	+ "			location = \"Super Secret Conference Room\"\r\n"
	+ "		}\r\n"
	+ "	}\r\n"
	+ "}")
	public void testPublishTestMeetingMinutes(BuildResult result,File dir) {
		assertNotNull(result);
		String output = result.getOutput();
		assertNotNull(output);
		System.out.println(output);
		File publishDir = new File(dir,"docs/Test Meeting");
		assertTrue("Missing " + publishDir.toString(),publishDir.exists());
		File minutes = new File(publishDir,"testMeetingMinutes.docx");
		assertTrue("Missing " + minutes.toString(),minutes.exists());
		//TODO:validate contents of presentation....
	}
}
