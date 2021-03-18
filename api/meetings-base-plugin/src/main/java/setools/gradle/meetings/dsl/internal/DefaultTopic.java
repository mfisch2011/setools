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

import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meetings.dsl.AgendaHandler;
import setools.gradle.meetings.dsl.Topic;

/**
 * TODO:documentation...
 */
public class DefaultTopic implements Topic {

	/**
	 * TODO:documentation...
	 */
	private String name = null;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		//TODO:validate name
		this.name = name;
	}
	
	/**
	 * TODO:documentation...
	 */
	private String notes = null;

	@Override
	public String getNotes() {
		return notes;
	}

	@Override
	public void setNotes(String text) {
		//TODO:validate text
		this.notes = text;
	}
	
	/**
	 * TODO:documentation...
	 */
	private String presenter = null;

	@Override
	public String getPresenter() {
		return presenter;
	}

	@Override
	public void setPresenter(String name) {
		//TODO:validate name
		this.presenter = name;
	}
	
	/**
	 * TODO:documentation...
	 */
	private AgendaHandler subTopics = new DefaultAgendaHandler();

	@Override
	public AgendaHandler subTopics() {
		return subTopics;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public AgendaHandler subTopics(Closure closure) {
		ConfigureUtil.configure(closure, subTopics);
		return subTopics;
	}

}
