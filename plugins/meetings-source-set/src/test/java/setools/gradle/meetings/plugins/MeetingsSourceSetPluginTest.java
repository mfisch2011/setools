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

import static org.junit.Assert.*;

import org.gradle.api.Project;
import org.gradle.api.tasks.SourceSetContainer;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Test;

/**
 * TODO:
 */
public class MeetingsSourceSetPluginTest {

	/**
	 * Test method for {@link setools.gradle.meetings.plugins.MeetingsSourceSetPlugin#apply(org.gradle.api.Project)}.
	 */
	@Test
	public void testApply() {
		Project project = ProjectBuilder.builder()
			//TODO:configure builder...
			.build();
		project.getPluginManager().apply(MeetingsSourceSetPlugin.class);
		MeetingsSourceSetPlugin plugin = project.getPlugins().findPlugin(MeetingsSourceSetPlugin.class);
		assertNotNull(plugin);
		SourceSetContainer sourceSets = project.getExtensions().getByType(SourceSetContainer.class);
		assertNotNull(sourceSets);
		
		//TODO:test that meetings source set exists...
		//TODO:test that no meeting source directory sets exist...
		//TODO:test adding a meeting source directory set...
	}

}
