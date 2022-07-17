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
package setools.gradle.meetings.plugin;

import static org.junit.Assert.*;

import org.gradle.api.Project;
import org.gradle.api.plugins.JavaBasePlugin;
import org.gradle.api.tasks.SourceSetContainer;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Test;

/**
 * TODO:
 */
public class MeetingsPluginTest {

	/**
	 * Test method for {@link setools.gradle.meetings.plugin.MeetingsPlugin#apply(org.gradle.api.Project)}.
	 */
	@Test
	public void testApply() {
		Project project = ProjectBuilder.builder()
				//TODO:configure builder
				.build();
		project.getPluginManager().apply(MeetingsPlugin.class);
		assertNotNull(project.getPlugins().findPlugin(MeetingsPlugin.class));
		assertNotNull(project.getPlugins().findPlugin(MeetingsBasePlugin.class));
		assertNotNull(project.getPlugins().findPlugin(JavaBasePlugin.class)); //for sourceSets...
		assertNotNull((SourceSetContainer)project.getExtensions().findByName("sourceSets"));
		
		//TODO:other validation...
	}

}
