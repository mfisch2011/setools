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
package setools.gradle.meetings.api.internal;

import java.util.Date;

import javax.inject.Inject;

import org.gradle.api.Action;
import org.gradle.api.Project;
import org.gradle.util.internal.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meetings.api.AgendaHandler;
import setools.gradle.meetings.api.Meeting;

/**
 * Default implementation of {@link Meeting} for specifying meeting 
 * information in Gradle build files.
 */
public class DefaultMeeting implements Meeting {
	
	/**
	 * {@link String} to store the meeting name in
	 */
	protected String name = null;
	
	/**
	 * {@link AgendaHandler} for storing the meeting agenda.
	 */
	protected final AgendaHandler agenda;

	/**
	 * {@link Project} for resolving project information.
	 */
	protected final Project project;
	
	/**
	 * Default constructor for {@link DefaultMeeting}.
	 * @param project - {@link Project} for resolving project information
	 */
	@Inject
	public DefaultMeeting(Project project) {
		this.project = project;
		this.agenda = new DefaultAgendaHandler(project);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		//TODO: validate name ???
		this.name = name;
	}
	
	/**
	 * {@link String} to store the meeting location in.
	 */
	protected String location = null;

	@Override
	public String getLocation() {
		return location;
	}

	@Override
	public void setLocation(String location) {
		//TODO:validate location ???
		this.location = location;
	}
	
	/**
	 * {@link Date} to store the meeting date and time in.
	 */
	protected Date time;

	@Override
	public Date getTime() {
		return (Date)time.clone();
	}

	@Override
	public void setTime(Object object) {
		//TODO: how to really handle this ???
		if(object instanceof Date) {
			time = (Date)((Date)object).clone();
		}
		//TODO: how to robustly handle string parsing ???
	}

	@Override
	public AgendaHandler agenda() {
		return agenda;
	}

	@Override
	public AgendaHandler agenda(Closure<?> closure) {
		ConfigureUtil.configure(closure, agenda);
		return agenda;
	}

	@Override
	public AgendaHandler agenda(Action<? super AgendaHandler> action) {
		action.execute(agenda);
		return agenda;
	}

}
