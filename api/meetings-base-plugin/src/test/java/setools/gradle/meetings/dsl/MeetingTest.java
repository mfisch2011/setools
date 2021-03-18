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

/**
 * TODO:documentation...
 */
public abstract class MeetingTest {
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	protected abstract Meeting newInstance();

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.Meeting#getAgendaTemplate()}
	 * and {@link setools.gradle.meetings.dsl.Meeting#setAgendaTemplate(java.lang.Object)}.
	 */
	@Test
	void testGetSetAgendaTemplate() {
		Meeting meeting = newInstance();
		assertNotNull(meeting);
		assertNull(meeting.getAgendaTemplate());
		meeting.setAgendaTemplate("test.tex");
		assertEquals("test.tex",meeting.getAgendaTemplate());
		//TODO:other templates?
	}
	
	//TODO:fuzz test agendaTemplate

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.Meeting#getMinutesTemplate()}
	 * and {@link setools.gradle.meetings.dsl.Meeting#setMinutesTemplate(java.lang.Object)}.
	 */
	@Test
	void testGetSetMinutesTemplate() {
		Meeting meeting = newInstance();
		assertNotNull(meeting);
		assertNull(meeting.getMinutesTemplate());
		meeting.setMinutesTemplate("test.tex");
		assertEquals("test.tex",meeting.getMinutesTemplate());
		//TODO:other templates?
	}
	
	//TODO:fuzz test minutesTemplate

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.Meeting#getPresentationTemplate()}
	 * and {@link setools.gradle.meetings.dsl.Meeting#setPresentationTemplate(java.lang.Object)}.
	 */
	@Test
	void testGetSetPresentationTemplate() {
		Meeting meeting = newInstance();
		assertNotNull(meeting);
		assertNull(meeting.getPresentationTemplate());
		meeting.setPresentationTemplate("test.tex");
		assertEquals("test.tex",meeting.getPresentationTemplate());
		//TODO:other templates?
	}
	
	//TODO:fuzz test presentationTemplate

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.Meeting#agenda()}.
	 */
	@Test
	void testAgenda() {
		Meeting meeting = newInstance();
		assertNotNull(meeting);
		assertNotNull(meeting.agenda());
		//TODO:other testing
	}

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.Meeting#agenda(groovy.lang.Closure)}.
	 */
	@Disabled
	@Test
	void testAgendaClosure() {
		Meeting meeting = newInstance();
		assertNotNull(meeting);
		assertNotNull(meeting.agenda());
		//TODO:set configuring with a closure
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.Meeting#agenda(org.gradle.api.Action)}.
	 */
	@Test
	void testAgendaActionOfQextendsAgendaHandler() {
		Meeting meeting = newInstance();
		assertNotNull(meeting);
		assertNotNull(meeting.agenda());
		meeting.agenda(new Action<AgendaHandler>() {

			@Override
			public void execute(AgendaHandler handler) {
				handler.topic().setName("Test Topic 1");
				handler.topic().setName("Test Topic 2");
				handler.topic().setName("Test Topic 3");
			}
		});
		assertEquals(3,meeting.agenda().size());
	}

}
