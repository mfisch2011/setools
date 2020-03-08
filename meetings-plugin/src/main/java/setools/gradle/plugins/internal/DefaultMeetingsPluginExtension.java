/**
   Copyright 2019 Matt Fischer <mfish2011@gmail.com>

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
package setools.gradle.plugins.internal;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.inject.Inject;

import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Project;

import groovy.lang.Closure;
import setools.gradle.plugins.AgendaItem;
import setools.gradle.plugins.MeetingsPluginExtension;

/**
 * @author matt
 *
 */
public class DefaultMeetingsPluginExtension implements MeetingsPluginExtension {

	protected final Project project;

	protected String meetingName = null;
	
	protected String meetingDescription = null;
	
	protected Date meetingDate = new Date();
	
	protected String meetingLocation = null;
	
	protected NamedDomainObjectContainer<AgendaItem> meetingAgenda;
	
	protected String dateFormat = "dd/mm/yyyy";
	
	protected String timeFormat = "HH:mm";
	
	protected Collection<String> attendees;
	
	protected URI agendaTemplate = null;
	
	protected URI minutesTemplate = null;
	
	@Inject
	public DefaultMeetingsPluginExtension(Project project) {
		this.project = project;
		attendees = new HashSet<String>();
		meetingAgenda = project.container(AgendaItem.class);
	}

	@Override
	public String getName() {
		return meetingName;
	}

	@Override
	public void setName(String name) {
		meetingName = name;
	}

	@Override
	public String getDescription() {
		return meetingDescription;
	}

	@Override
	public void setDescription(String description) {
		meetingDescription = description;
	}

	@Override
	public String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat(getDateFormat());
		return formatter.format(meetingDate);
	}

	@Override
	public void setDate(Object object) throws ParseException {
		if(object instanceof String) {
			SimpleDateFormat formatter = new SimpleDateFormat(getDateFormat());
			meetingDate = formatter.parse((String)object); //TODO:how to not over write time?
		} else if(object instanceof Date) {
			meetingDate = (Date)object;
		}//TODO:what other types???
	}

	@Override
	public String getTime() {
		SimpleDateFormat formatter = new SimpleDateFormat(getTimeFormat());
		return formatter.format(meetingDate);
	}

	@Override
	public void setTime(Object object) throws ParseException {
		if(object instanceof String) {
			SimpleDateFormat formatter = new SimpleDateFormat(getDateFormat());
			meetingDate = formatter.parse((String)object); //TODO:how to not over write date?
		} else if(object instanceof Date) {
			meetingDate = (Date)object;
		}//TODO:what other types???
	}

	@Override
	public String getLocation() {
		return meetingLocation;
	}

	@Override
	public void setLocation(String location) {
		meetingLocation = location;
	}

	@Override
	public Collection<String> getAttendees() {
		return attendees;
	}

	@Override
	public void setAttendees(String... attendees) {
		this.attendees = new HashSet<String>();
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
		return meetingAgenda;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void agenda(Closure closure) {
		meetingAgenda.configure(closure);
	}

	@Override
	public String getDateFormat() {
		return dateFormat;
	}

	@Override
	public void setDateFormat(String format) {
		//TODO:validate format
		dateFormat = format;
	}

	@Override
	public String getTimeFormat() {
		return timeFormat;
	}

	@Override
	public void setTimeFormat(String format) {
		//TODO:validate format
		timeFormat = format;
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
}
