/**
   Copyright 2019 Matt Fischer <mfish2011@gmail.com>

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
import java.net.URISyntaxException;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.Test;

import com.github.mfisch2011.gradle.test.utils.GradleFunctionalTest;

/**
 * @author matt
 *
 */
public class OOXMLMeetingsPluginFunctionalTest extends GradleFunctionalTest {

	/**
	 * Test method for {@link setools.gradle.plugins.AbstractMeetingsPlugin#apply(org.gradle.api.Project)}.
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	@Test
	public void testApply() throws URISyntaxException, IOException {
		copyProjectResources("test-ooxml-meetings-plugin-default");
		BuildResult result = GradleRunner.create()
				.withProjectDir(testProjectDir.getRoot())
				.withPluginClasspath()
				.withArguments("tasks","--all")
				.build();
		assertNotNull(result);
		String output = result.getOutput();
		assertNotNull(output);
		System.out.println(output);
		assertTrue("Missing 'Meeting Tasks' group.",output.contains("Meeting Tasks"));
		
		assertTrue("Missing 'draftAgenda' task.",output.contains("draftAgenda"));
		assertTrue("Missing 'draftMinutes' task.",output.contains("draftMinutes"));
		assertTrue("Missing 'draftPresentation' task.",output.contains("draftPresentation"));
		assertTrue("Missing 'assemblePresentation' task.",output.contains("assemblePresentation"));
		assertTrue("Missing 'publishPresentation' task.",output.contains("publishPresentation"));
		assertTrue("Missing 'publishMinutes' task.",output.contains("publishMinutes"));
	}
	
	/**
	 * Test method for {@link setools.gradle.plugins.AbstractMeetingsPlugin#apply(org.gradle.api.Project)}.
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	@Test
	public void testBuild() throws URISyntaxException, IOException {
		copyProjectResources("test-ooxml-meetings-plugin-default");
		BuildResult result = GradleRunner.create()
				.withProjectDir(testProjectDir.getRoot())
				.withPluginClasspath()
				.withArguments("publishMinutes")
				.build();
		assertNotNull(result);
		String output = result.getOutput();
		assertNotNull(output);
		System.out.println(output);
		
		//validate generated files
		File publishDir = testProjectDir.getRoot(); //default publishes to the project dir
		File agenda = new File(publishDir,"agenda.docx");
		assertTrue("Missing agenda file.",agenda.exists());
		File minutes = new File(publishDir,"minutes.docx");
		assertTrue("Missing minutes file.",minutes.exists());
		//TODO:validate slides
		File presentation = new File(publishDir,"presentation.docx");
		assertTrue("Missing presentation file.",presentation.exists());
	}
	
}
