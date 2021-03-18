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

import org.gradle.api.Action;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import setools.gradle.meetings.dsl.internal.AbstractHandlerTest;

/**
 * TODO:documentation...
 */
public abstract class AttendeesHandlerTest extends AbstractHandlerTest<Attendee> {

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.AttendeesHandler#attendee()}.
	 */
	@Test
	void testAttendee() {
		AttendeesHandler handler = (AttendeesHandler) newHandlerInstance();
		Attendee attendee = handler.attendee();
		assertNotNull(attendee);
		assertNull(attendee.getName());
		assertNull(attendee.getRole());
		//TODO:further testing?
	}

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.AttendeesHandler#attendee(groovy.lang.Closure)}.
	 */
	@Disabled
	@Test
	void testAttendeeClosure() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.AttendeesHandler#attendee(org.gradle.api.Action)}.
	 */
	@Test
	void testAttendeeActionOfQextendsAttendee() {
		AttendeesHandler handler = (AttendeesHandler) newHandlerInstance();
		Attendee attendee = handler.attendee(new Action<Attendee>() {

			@Override
			public void execute(Attendee attendee) {
				attendee.setName("Test Name");
				attendee.setRole("Test Role");
			}
			
		});
		assertNotNull(attendee);
		assertEquals("TestName",attendee.getName());
		assertEquals("Test Role",attendee.getRole());
		//TODO:further testing?
	}
}
