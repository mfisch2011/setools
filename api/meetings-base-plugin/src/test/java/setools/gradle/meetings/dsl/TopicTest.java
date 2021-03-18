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

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * TODO:documentation...
 */
public abstract class TopicTest {
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	protected abstract Topic newInstance();

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.Topic#getName()}
	 * and {@link setools.gradle.meetings.dsl.Topic#setName(java.lang.String)}.
	 */
	@Test
	void testGetName() {
		Topic topic = newInstance();
		assertNotNull(topic);
		assertNull(topic.getName());
		topic.setName("Test topic");
		assertEquals("Test topic",topic.getName());
		//TODO:other name testing?
	}
	
	//TODO:fuzz test name?

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.Topic#getNotes()}
	 * and {@link setools.gradle.meetings.dsl.Topic#setNotes(java.lang.String)}.
	 */
	@Test
	void testGetSetNotes() {
		Topic topic = newInstance();
		assertNotNull(topic);
		assertNull(topic.getNotes());
		topic.setNotes("Test notes");
		assertEquals("Test notes",topic.getNotes());
		//TODO:other notes test?
	}
	
	//TODO:fuzz test notes?

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.Topic#getPresenter()}
	 * and {@link setools.gradle.meetings.dsl.Topic#setPresenter(java.lang.String)}.
	 */
	@Test
	void testGetSetPresenter() {
		Topic topic = newInstance();
		assertNotNull(topic);
		assertNull(topic.getPresenter());
		topic.setPresenter("Test presenter");
		//TODO:other presenter testing?
	}
	
	//TODO:fuzz test presenter?

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.Topic#subTopics()}.
	 */
	@Test
	void testSubTopics() {
		Topic topic = newInstance();
		assertNotNull(topic);
		assertNotNull(topic.subTopics());
		//TODO:other testing???
	}
	
	//TODO:fuzz test subTopics?

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.Topic#subTopics(groovy.lang.Closure)}.
	 */
	@Disabled
	@Test
	void testSubTopicsClosure() {
		Topic topic = newInstance();
		assertNotNull(topic);
		assertNotNull(topic.subTopics());
		fail("Not yet implemented");
	}

}
