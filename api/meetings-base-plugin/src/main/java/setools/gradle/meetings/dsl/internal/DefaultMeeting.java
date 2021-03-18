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

import java.io.File;
import java.nio.file.Path;

import org.gradle.api.Action;
import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meetings.dsl.AgendaHandler;
import setools.gradle.meetings.dsl.AttendeesHandler;
import setools.gradle.meetings.dsl.Meeting;

/**
 * TODO:documentation...
 */
public class DefaultMeeting implements Meeting {

	/**
	 * TODO:documentation...
	 */
	private String agendaTemplate = null;
	
	@Override
	public String getAgendaTemplate() {
		return agendaTemplate;
	}

	@Override
	public void setAgendaTemplate(Object object) {
		//TODO:better way? look at project.file(object)
		if(object instanceof String)
			agendaTemplate = (String)object;
		else if(object instanceof Path)
			agendaTemplate = ((Path)object).toString();
		else if(object instanceof File)
			agendaTemplate = ((File)object).getAbsolutePath();
		//TODO:what else?
	}
	
	/**
	 * TODO:documentation...
	 */
	private String minutesTemplate = null;

	@Override
	public String getMinutesTemplate() {
		return minutesTemplate;
	}

	@Override
	public void setMinutesTemplate(Object object) {
		//TODO:better way? look at project.file(object)
		if(object instanceof String)
			minutesTemplate = (String)object;
		else if(object instanceof Path)
			minutesTemplate = ((Path)object).toString();
		else if(object instanceof File)
			minutesTemplate = ((File)object).getAbsolutePath();
		//TODO:what else?
	}
	
	/**
	 * TODO:documentation...
	 */
	private String presentationTemplate = null;

	@Override
	public String getPresentationTemplate() {
		return presentationTemplate;
	}

	@Override
	public void setPresentationTemplate(Object object) {
		//TODO:better way? look at project.file(object)
		if(object instanceof String)
			presentationTemplate = (String)object;
		else if(object instanceof Path)
			presentationTemplate = ((Path)object).toString();
		else if(object instanceof File)
			presentationTemplate = ((File)object).getAbsolutePath();
		//TODO:what else?
	}
	
	/**
	 * TODO:documentation...
	 */
	private AgendaHandler agenda = new DefaultAgendaHandler();

	@Override
	public AgendaHandler agenda() {
		return agenda;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public AgendaHandler agenda(Closure closure) {
		ConfigureUtil.configure(closure, agenda);
		return agenda;
	}

	@Override
	public AgendaHandler agenda(Action<? super AgendaHandler> action) {
		action.execute(agenda);
		return agenda;
	}
	
	/**
	 * TODO:documentation...
	 */
	private AttendeesHandler attendees = new DefaultAttendeesHandler();

	@Override
	public AttendeesHandler attendees() {
		return attendees;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public AttendeesHandler attendees(Closure closure) {
		ConfigureUtil.configure(closure, attendees);
		return attendees;
	}

	@Override
	public AttendeesHandler attendees(Action<? super AttendeesHandler> action) {
		action.execute(attendees);
		return attendees;
	}

}
