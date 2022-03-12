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
package setools.gradle.plugins;

import static org.junit.Assert.*;

import org.gradle.api.Project;
import org.gradle.api.internal.tasks.DefaultSourceSet;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.api.tasks.SourceSet;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

/**
 * TODO:
 */
public class AbstractSourceSetPluginTest {

	/**
	 * Test method for {@link setools.gradle.plugins.AbstractSourceSetPlugin#apply(org.gradle.api.Project)}.
	 */
	@Test
	public void testApplyDefaultSourceSet() {
		Project project = ProjectBuilder.builder()
				//TODO:configure project
				.build();
		project.getPluginManager().apply(TestDefaultSourceSet.class);
		SourceSet sourceSet = project.getExtensions().getByType(
				JavaPluginExtension.class)
				.getSourceSets()
				.findByName("defaultTest");
		assertNotNull(sourceSet);
		
		assertThat(sourceSet,instanceOf(DefaultSourceSet.class));
	}

	/**
	 * Test method for {@link setools.gradle.plugins.AbstractSourceSetPlugin#apply(org.gradle.api.Project)}.
	 */
	@Test
	@Ignore
	public void testApplyCustomSourceSet() {
		Project project = ProjectBuilder.builder()
				//TODO:configure project
				.build();
		project.getPluginManager().apply(TestCustomSourceSet.class);
		//TODO:validate plugin application...
	}
	
	/**
	 * Test method for {@link setools.gradle.plugins.AbstractSourceSetPlugin#apply(org.gradle.api.Project)}.
	 */
	@Test
	@Ignore
	public void testApplyExtensions() {
		Project project = ProjectBuilder.builder()
				//TODO:configure project
				.build();
		project.getPluginManager().apply(TestCustomWithExtensions.class);
		fail("Not yet implemented");
	}
}
