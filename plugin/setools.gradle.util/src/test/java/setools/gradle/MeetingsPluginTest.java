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
package setools.gradle;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.Test;

import com.github.mfisch.gradle.test.utils.GradleFunctionalTest;

/**
 * @author matt
 *
 */
public class MeetingsPluginTest extends GradleFunctionalTest {

	@Test
	public void testApply() throws URISyntaxException, IOException {
		copyProjectResources("test-init-meeting-default");
		BuildResult result = GradleRunner.create()
				.withProjectDir(testProjectDir.getRoot())
				.withPluginClasspath()
				.withArguments("task","--all")
				.build();
		assertNotNull(result);
		String output = result.getOutput();
		assertNotNull(output);
		System.out.println(output);
		assertTrue("Missing agenda task",output.contains("agenda"));
		assertTrue("Missing presentation task",output.contains("presentation"));
		assertTrue("Missing minutes task",output.contains("minutes"));
		assertTrue("Missing initMeeting task",output.contains("initMeeting"));
	}
	
	@Test
	public void testInitMeeting() throws URISyntaxException, IOException {
		copyProjectResources("test-init-meeting-default");
		BuildResult result = GradleRunner.create()
				.withProjectDir(testProjectDir.getRoot())
				.withPluginClasspath()
				.withArguments("initMeeting","--directory","test-meeting")
				.build();
		assertNotNull(result);
		String output = result.getOutput();
		assertNotNull(output);
		System.out.println(output);
		File root = testProjectDir.getRoot();
		File dir = new File(root,"test-meeting");
		assertTrue("Missing meeting directory",dir.exists());
		File build = new File(dir,"build.gradle");
		assertTrue("Missing meeting build.gradle",build.exists());
		byte[] bytes = Files.readAllBytes(build.toPath());
		output = new String(bytes);
		System.out.println(output);
		String tst = "apply plugin: \"setools.gradle.MeetingsPlugin\"\n" +
				"\n" +
				"meeting {\n" + 
				"	date = %s\n" + 
				"	name = %s\n" + 
				"	attendees = []\n" + 
				"}";
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
		String strDate = format.format(new Date());
		tst = String.format(tst, strDate,"test-meeting");
		assertEquals(tst,output);
	}
	
	@Test
	public void testInitMeetingName() throws URISyntaxException, IOException {
		copyProjectResources("test-init-meeting-default");
		BuildResult result = GradleRunner.create()
				.withProjectDir(testProjectDir.getRoot())
				.withPluginClasspath()
				.withArguments("initMeeting","--directory","test-meeting","--meeting-name","Test Meeting","--meeting-date","2019-12-01")
				.build();
		assertNotNull(result);
		String output = result.getOutput();
		assertNotNull(output);
		System.out.println(output);
		File root = testProjectDir.getRoot();
		File dir = new File(root,"test-meeting");
		assertTrue("Missing meeting directory",dir.exists());
		File build = new File(dir,"build.gradle");
		assertTrue("Missing meeting build.gradle",build.exists());
		byte[] bytes = Files.readAllBytes(build.toPath());
		output = new String(bytes);
		System.out.println(output);
		String tst = "apply plugin: \"setools.gradle.MeetingsPlugin\"\n" +
				"\n" +
				"meeting {\n" + 
				"	date = %s\n" + 
				"	name = %s\n" + 
				"	attendees = []\n" + 
				"}";
		tst = String.format(tst, "2019-12-01","Test Meeting");
		assertEquals(tst,output);
	}

}
