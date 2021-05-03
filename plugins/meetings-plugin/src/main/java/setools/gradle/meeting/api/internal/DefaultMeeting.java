/**
   Copyright 2020 Matt Fischer <mfish2011@gmail.com>

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package setools.gradle.meeting.api.internal;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import javax.inject.Inject;

import org.gradle.api.Project;
import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meeting.api.AgendaItem;
import setools.gradle.meeting.api.AgendaItemHandler;
import setools.gradle.meeting.api.Meeting;

/** 
 * TODO:
 */
public class DefaultMeeting implements Meeting {

	/**
	 * TODO:
	 */
	protected final Project project;
	
	/**
	 * TODO:
	 */
	protected String name = null;
	
	/**
	 * TODO:
	 */
	protected String description = null;
	
	/**
	 * TODO:
	 */
	protected String date = null;
	
	/**
	 * TODO:
	 */
	protected String time = null;
	
	/**
	 * TODO:
	 */
	protected TreeSet<String> attendees = null; //TODO:make this final if we can find a way to clear rather than destroy...
	
	/**
	 * TODO:
	 */
	protected final AgendaItemHandler agenda;

	/**
	 *  TODO:
	 */
	protected URI presentationTemplate = null;
	
	/**
	 *  TODO:
	 */
	protected URI agendaTemplate = null;
	
	/**
	 *  TODO:
	 */
	protected URI minutesTemplate = null;

	/**
	 * TODO:
	 */
	protected String location = null;

	/** TODO:
	 * @param project
	 * @throws URISyntaxException 
	 */
	@Inject
	public DefaultMeeting(Project project) throws URISyntaxException {
		this.project = project;
		this.attendees = new TreeSet<String>();
		this.agenda = new DefaultAgendaItemHandler();
		this.presentationTemplate = new URI("classpath:///resources/ooxml-presentation-template.pptx");
		this.agendaTemplate = new URI("classpath:///resources/agenda-template.odt");
		this.minutesTemplate = new URI("classpath:///resources/minutes-template.odt");
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getDate() {
		return date;
	}

	@Override
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String getTime() {
		return time;
	}

	@Override
	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public Set<String> getAttendees() {
		return attendees;
	}

	@Override
	public void setAttendees(String... attendees) {
		this.attendees = new TreeSet<String>();
		for(String attendee : attendees)
			this.attendees.add(attendee);
	}

	@Override
	public void attendees(String... attendees) {
		for(String attendee : attendees)
			this.attendees.add(attendee);
	}

	@Override
	public Collection<AgendaItem> getAgenda() {
		return agenda.getAgendaItems();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void agenda(Closure closure) {
		ConfigureUtil.configure(closure, agenda);
	}

	@Override
	public URI getPresentationTemplate() {
		return presentationTemplate;
	}

	@Override
	public void setPresentationTemplate(Object object) {
		presentationTemplate = project.uri(object);
	}
	
	@Override
	public URI getAgendaTemplate() {
		return agendaTemplate;
	}

	@Override
	public void setAgendaTemplate(Object object) {
		agendaTemplate = project.uri(object);
	}
	
	@Override
	public URI getMinutesTemplate() {
		return minutesTemplate;
	}

	@Override
	public void setMinutesTemplate(Object object) {
		minutesTemplate = project.uri(object);
	}

	@Override
	public String getLocation() {
		return location;
	}

	@Override
	public void setLocation(String location) {
		this.location  = location;
	}
	
}
