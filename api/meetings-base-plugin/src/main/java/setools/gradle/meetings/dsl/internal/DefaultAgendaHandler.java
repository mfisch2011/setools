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
import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meetings.dsl.AgendaHandler;
import setools.gradle.meetings.dsl.Topic;

/**
 * TODO:documentation...
 */
public class DefaultAgendaHandler extends AbstractHandler<Topic> implements
AgendaHandler {

	@Override
	public Topic topic() {
		Topic topic = new DefaultTopic();
		add(topic);
		return topic;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Topic topic(Closure closure) {
		Topic topic = new DefaultTopic();
		ConfigureUtil.configure(closure, topic);
		add(topic);
		return topic;
	}

	@Override
	public Topic topic(Action<? super Topic> action) {
		Topic topic = new DefaultTopic();
		action.execute(topic);
		add(topic);
		return topic;
	}

}
