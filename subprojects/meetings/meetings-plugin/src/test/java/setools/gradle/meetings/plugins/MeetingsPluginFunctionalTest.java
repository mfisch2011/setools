/**
 * Copyright 2021 M. Fischer <mfisch2011@gmail.com>
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

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.Test;

/**
 * TODO:
 */
public class MeetingsPluginFunctionalTest {

	/**
	 * Test method for {@link setools.gradle.meetings.plugins.MeetingsPlugin#apply(org.gradle.api.Project)}.
	 * @throws IOException 
	 */
	@Test
	public void testBasicConfig() throws IOException {
		File dir = Files.createTempDirectory("tmp").toFile();
		dir.deleteOnExit(); //in case we get interrupted
		Files.writeString(dir.toPath().resolve("settings.gradle"),getBasicSettings());
		Files.writeString(dir.toPath().resolve("build.gradle"),getBasicBuild());
		String[] arguments = {"tasks"};
		BuildResult result = GradleRunner.create()
				.withPluginClasspath()
				.withProjectDir(dir)
				.withArguments(arguments)
				.build();
		assertNotNull(result);
		String output = result.getOutput();
		assertNotNull(output);
		System.out.println(output);
		//TODO:validate results...
	}
	
	/**
	 * TODO:
	 * @return
	 */
	protected String getBasicBuild() {
		return getPluginsBlock() +
				"meetings { " + System.lineSeparator() +
				"  meeting { " + System.lineSeparator() +
				"    name = 'Test Meeting' " + System.lineSeparator() +
				"  }" + System.lineSeparator() +
				"}" + System.lineSeparator();
	}

	/**
	 * TODO:
	 * @return
	 */
	protected String getPluginsBlock() {
		return "plugins { " + System.lineSeparator() +
		"  id 'setools.meetings-plugin'" + System.lineSeparator() +
		"}" + System.lineSeparator();
	}

	/**
	 * TODO:
	 * @return
	 */
	protected String getBasicSettings() {
		return "rootProject.name = 'test-project'";
	}
}
