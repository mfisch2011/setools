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
public abstract class AgendaHandlerTest extends AbstractHandlerTest<Topic> {

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.AgendaHandler#topic()}.
	 */
	@Test
	void testTopic() {
		AgendaHandler handler = (AgendaHandler)newHandlerInstance();
		assertNotNull(handler);
		Topic topic = handler.topic();
		assertNotNull(topic);
		assertTrue(handler.contains(topic));
		handler.remove(topic);
		assertFalse(handler.contains(topic));
	}

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.AgendaHandler#topic(groovy.lang.Closure)}.
	 */
	@Disabled
	@Test
	void testTopicClosure() {
		AgendaHandler handler = (AgendaHandler)newHandlerInstance();
		assertNotNull(handler);
		//TODO:create with closure...
		Topic topic = handler.topic();
		assertNotNull(topic);
		assertTrue(handler.contains(topic));
		handler.remove(topic);
		assertFalse(handler.contains(topic));
	}

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.AgendaHandler#topic(org.gradle.api.Action)}.
	 */
	@Disabled
	@Test
	void testTopicActionOfQextendsTopic() {
		AgendaHandler handler = (AgendaHandler)newHandlerInstance();
		assertNotNull(handler);
		Topic topic = handler.topic(new Action<Topic>() {

			@Override
			public void execute(Topic topic) {
				topic.setName("Test topic");
				topic.setNotes("Test notes");
				topic.setPresenter("Test presenter");
				//TODO:subTopics?
			}
			
		});
		assertNotNull(topic);
		assertEquals("Test topic",topic.getName());
		assertEquals("Test notes",topic.getNotes());
		assertEquals("Test presenter",topic.getPresenter());
	}

}
