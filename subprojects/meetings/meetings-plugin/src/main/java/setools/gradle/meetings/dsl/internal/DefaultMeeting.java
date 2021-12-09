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
import org.gradle.api.Project;
import setools.gradle.meetings.dsl.AgendaHandler;
import setools.gradle.meetings.dsl.Meeting;

/**
 * TODO:
 */
public class DefaultMeeting implements Meeting {
	
	/**
	 * TODO:
	 */
	public DefaultMeeting(Project project) {
		this.agendaHandler = new DefaultAgendaHandler();
		this.project = project;
	}
	
	/**
	 * TODO:
	 */
	protected final Project project;
	
	/**
	 * TODO:
	 */
	private String name = null;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String value) {
		this.name = value;
	}
	
	/**
	 * TODO:
	 */
	private String location = null;

	@Override
	public String getLocation() {
		return location;
	}

	@Override
	public void setLocation(String value) {
		this.location = value;
	}
	
	/**
	 * TODO:
	 */
	private String time = null;

	@Override
	public String getTime() {
		return time;
	}

	@Override
	public void setTime(Object object) {
		if(object instanceof String) {
			time = (String)object;
		}
		//TODO:handle other object types...
	}
	
	/**
	 * TODO:
	 */
	protected final AgendaHandler agendaHandler;

	@Override
	public AgendaHandler agenda() {
		return agendaHandler;
	}

	@Override
	public AgendaHandler agenda(Action<AgendaHandler> action) {
		action.execute(agendaHandler);
		return agendaHandler;
	}
	
	/**
	 * TODO:
	 */
	protected Object agendaTemplate;

	@Override
	public Object getAgendaTemplate() {
		return agendaTemplate;
	}

	@Override
	public void setAgendaTemplate(Object object) {
		agendaTemplate = project.uri(object);
		//TODO:catch exception and try file ???
	}
	
	/**
	 * TODO:
	 */
	protected String agendaFilename = null;

	@Override
	public String getAgendaFilename() {
		return agendaFilename;
	}

	@Override
	public void setAgendaFilename(String filename) {
		//TODO:validate filename...
		agendaFilename = filename;
	}
	
	/**
	 * TODO:
	 */
	protected String date = null;

	@Override
	public String getDate() {
		return date;
	}

	@Override
	public void setDate(String value) {
		//TODO:validate value
		date = value;
	}

}
