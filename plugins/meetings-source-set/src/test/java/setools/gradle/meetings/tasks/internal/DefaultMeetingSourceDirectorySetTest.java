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
package setools.gradle.meetings.tasks.internal;

import static org.junit.Assert.*;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Ignore;
import org.junit.Test;

/**
 * TODO:
 */
public class DefaultMeetingSourceDirectorySetTest {

	/**
	 * Test method for {@link setools.gradle.meetings.tasks.internal.DefaultMeetingSourceDirectorySet#DefaultMeetingSourceDirectorySet(java.lang.String, org.gradle.api.model.ObjectFactory)}.
	 */
	@Test
	public void testDefaultMeetingSourceDirectorySet() {
		Project project = ProjectBuilder.builder()
			//TODO:configure builder...
			.build();
		DefaultMeetingSourceDirectorySet tst = new DefaultMeetingSourceDirectorySet("testing",project.getObjects());
		assertNotNull(tst);
		assertNotNull(tst.getAgenda());
		assertNotNull(tst.getMinutes());
		assertNotNull(tst.getPresentation());
		assertNotNull(tst.getAllSources());
	}

	/**
	 * Test method for {@link setools.gradle.meetings.tasks.internal.DefaultMeetingSourceDirectorySet#getAgenda()}.
	 */
	@Test
	@Ignore
	public void testGetAgenda() {
		//TODO: hot to test agenda functionality ???
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link setools.gradle.meetings.tasks.internal.DefaultMeetingSourceDirectorySet#getMinutes()}.
	 */
	@Test
	@Ignore
	public void testGetMinutes() {
		//TODO: hot to test minutes functionality ???
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link setools.gradle.meetings.tasks.internal.DefaultMeetingSourceDirectorySet#getPresentation()}.
	 */
	@Test
	@Ignore
	public void testGetPresentation() {
		//TODO: hot to test presentation functionality ???
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link setools.gradle.meetings.tasks.internal.DefaultMeetingSourceDirectorySet#getAllSources()}.
	 */
	@Test
	@Ignore
	public void testGetAllSources() {
		//TODO: hot to test allSource functionality ???
		fail("Not yet implemented");
	}

}
