/**
 * Copyright 2022 M. Fischer <mfisch2011@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package setools.gradle.meetings.plugins;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static org.gradle.testkit.runner.TaskOutcome.SUCCESS;

/**
 * TODO:
 */
public class MeetingsPluginTest {
	
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	
	/**
	 * TODO:
	 */
	private File settingsFile;
	
	/**
	 * TODO:
	 */
	private File buildFile;

    @Before
    public void setup() throws IOException {
    	settingsFile = folder.newFile( "settings.gradle");
    	buildFile = folder.newFile("build.gradle");
    }
    
    @After
    public void cleanup() {
    	folder.delete();
    }

	/**
	 * Test method for {@link setools.gradle.meetings.plugins.MeetingsPlugin#apply(org.gradle.api.Project)}.
	 * @throws IOException 
	 */
	@Test
	public void testApply() throws IOException {
		writeFile(settingsFile, "rootProject.name = 'test-project'");
		String text = getPluginConfig();
		writeFile(buildFile,text);
		BuildResult result = GradleRunner.create()
				.withPluginClasspath()
				.withProjectDir(folder.getRoot())
				.withArguments("tasks")
				.build();
		assertNotNull(result);
		System.out.println(result.getOutput());
		assertEquals(SUCCESS,result.task(":tasks").getOutcome());
	}
	
	/**
	 * TODO:
	 * @throws IOException
	 */
	@Test
	public void testEmptyDefaultMeeting() throws IOException {
		writeFile(settingsFile, "rootProject.name = 'test-project'");
		String text = getPluginConfig();
		text += "meetings {" + System.lineSeparator()
			+ "  meeting()" + System.lineSeparator()
			+ "}";
		writeFile(buildFile,text);
		BuildResult result = GradleRunner.create()
				.withPluginClasspath()
				.withProjectDir(folder.getRoot())
				.withArguments("tasks")
				.build();
		assertNotNull(result);
		assertEquals(SUCCESS,result.task(":tasks").getOutcome());
	}
	
	/**
	 * TODO:
	 * @throws IOException
	 */
	@Test
	@Ignore
	public void testBasicDefaultMeeting() throws IOException {
		writeFile(settingsFile, "rootProject.name = 'test-project'");
		String text = getPluginConfig();
		writeFile(buildFile,text);
		BuildResult result = GradleRunner.create()
				.withPluginClasspath()
				.withProjectDir(folder.getRoot())
				.withArguments("tasks")
				.build();
		assertNotNull(result);
		System.out.println(result.getOutput());
		assertEquals(SUCCESS,result.task(":tasks").getOutcome());
	}
	
	/**
	 * TODO:
	 * @throws IOException
	 */
	@Test
	@Ignore
	public void testDefaultMeetingWithAction() throws IOException {
		writeFile(settingsFile, "rootProject.name = 'test-project'");
		String text = getPluginConfig();
		writeFile(buildFile,text);
		BuildResult result = GradleRunner.create()
				.withPluginClasspath()
				.withProjectDir(folder.getRoot())
				.withArguments("tasks")
				.build();
		assertNotNull(result);
		System.out.println(result.getOutput());
		assertEquals(SUCCESS,result.task(":tasks").getOutcome());
	}
	
	/**
	 * TODO:
	 * @throws IOException
	 */
	@Test
	@Ignore
	public void testEmptyModelBasedMeeting() throws IOException {
		writeFile(settingsFile, "rootProject.name = 'test-project'");
		String text = getPluginConfig();
		writeFile(buildFile,text);
		BuildResult result = GradleRunner.create()
				.withPluginClasspath()
				.withProjectDir(folder.getRoot())
				.withArguments("tasks")
				.build();
		assertNotNull(result);
		System.out.println(result.getOutput());
		assertEquals(SUCCESS,result.task(":tasks").getOutcome());
	}
	
	/**
	 * TODO:
	 * @throws IOException
	 */
	@Test
	@Ignore
	public void testBasicModelBasedMeeting() throws IOException {
		writeFile(settingsFile, "rootProject.name = 'test-project'");
		String text = getPluginConfig();
		writeFile(buildFile,text);
		BuildResult result = GradleRunner.create()
				.withPluginClasspath()
				.withProjectDir(folder.getRoot())
				.withArguments("tasks")
				.build();
		assertNotNull(result);
		System.out.println(result.getOutput());
		assertEquals(SUCCESS,result.task(":tasks").getOutcome());
	}
	
	/**
	 * TODO:
	 * @throws IOException
	 */
	@Test
	@Ignore
	public void testModelBasedWithAction() throws IOException {
		writeFile(settingsFile, "rootProject.name = 'test-project'");
		String text = getPluginConfig();
		writeFile(buildFile,text);
		BuildResult result = GradleRunner.create()
				.withPluginClasspath()
				.withProjectDir(folder.getRoot())
				.withArguments("tasks")
				.build();
		assertNotNull(result);
		System.out.println(result.getOutput());
		assertEquals(SUCCESS,result.task(":tasks").getOutcome());
	}

	/**
	 * TODO:
	 * @return
	 */
	protected String getPluginConfig() {
		return "plugins { " + System.lineSeparator()
		+ "  id 'setools.meetings-plugin' " + System.lineSeparator()
		+ "}" + System.lineSeparator() + System.lineSeparator();
	}

	/**
	 * TODO:
	 * @param settingsFile2
	 * @param string
	 * @throws IOException 
	 */
	protected void writeFile(File file, String text) throws IOException {
		BufferedWriter output = null;
		OutputStreamWriter writer = null;
		try {
			writer = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
			output = new BufferedWriter(writer);
			output.write(text);
		} finally {
			if(output!=null) output.close();
			if(writer!=null) writer.close();
		}
	}

}
