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

import java.io.IOException;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.Test;

import setools.gradle.test.GradleFunctionalTest;

/**
 * TODO:
 */
public class UmlPluginTest extends GradleFunctionalTest {

	/**
	 * Test method for {@link setools.gradle.plugins.UmlPlugin#apply(org.gradle.api.internal.project.ProjectInternal)}.
	 * @throws IOException 
	 */
	@Test
	public void testApplyDefaults() throws IOException {
		this.copyProjectResources("test-defaults");
		BuildResult results = GradleRunner.create()
				.withProjectDir(dir)
				.withPluginClasspath()
				.withArguments("tasks","--all")
				.build();
		assertNotNull(results);
		String output = results.getOutput();
		assertNotNull(output);
		System.out.println(output); //TODO:testing only...
		//TODO:add tests to verify tasks are applied...
	}

}
