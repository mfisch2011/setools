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
package setools.gradle.meetings.dsl.internal;

import org.gradle.api.Action;
import setools.gradle.meetings.dsl.AgendaHandler;
import setools.gradle.meetings.dsl.Topic;

/**
 * TODO:
 */
public class DefaultTopic implements Topic {
	
	/**
	 * TODO:
	 */
	protected final DefaultAgendaHandler subtopics;
	
	/**
	 * TODO:
	 */
	private String name = null;

	/**
	 * TODO:
	 */
	public DefaultTopic() {
		this.subtopics = new DefaultAgendaHandler();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String value) {
		this.name = value;
	}

	@Override
	public AgendaHandler subtopics() {
		return subtopics;
	}

	@Override
	public AgendaHandler subtopics(Action<? super AgendaHandler> action) {
		action.execute(subtopics);
		return subtopics;
	}

}
