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
package setools.gradle.meetings.dsl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * TODO:documentation...
 */
public abstract class AttendeeTest {
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	protected abstract Attendee newInstance();

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.Attendee#getName()}
	 * and {@link setools.gradle.meetings.dsl.Attendee#setName(java.lang.String)}.
	 */
	@Test
	void testGetSetName() {
		Attendee tst = newInstance();
		assertNotNull(tst);
		assertNull(tst.getName());
		tst.setName("Test Name");
		assertEquals("Test Name",tst.getName());
		//TODO:other name testing?
	}

	//TODO:fuzz test setName...
	
	/**
	 * Test method for {@link setools.gradle.meetings.dsl.Attendee#getRole()}
	 * and {@link setools.gradle.meetings.dsl.Attendee#setRole(java.lang.String)}.
	 */
	@Test
	void testGetSetRole() {
		Attendee tst = newInstance();
		assertNotNull(tst);
		assertNull(tst.getRole());
		tst.setRole("Test Role");
		assertEquals("Test Role",tst.getRole());
		//TODO:other role testing?
	}

	//TODO:fuzz test setRole...
	
}
