/**
 * TODO:license...
 */
package setools.gradle.meetings.dsl.internal;

import java.io.File;

import javax.inject.Inject;

import org.gradle.api.Project;
import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meetings.dsl.AgendaHandler;
import setools.gradle.meetings.dsl.AttendeeHandler;
import setools.gradle.meetings.dsl.Meeting;
import setools.gradle.meetings.dsl.MeetingsHandler;
import setools.gradle.meetings.service.agenda.ProxyAgendaHandler;

/**
 * TODO:documentation...
 */
public class DefaultMeeting implements Meeting {

	/**
	 * TODO:documentation...
	 */
	protected String name = null;
	
	/**
	 * TODO:documentation...
	 */
	protected final AgendaHandler agenda;
	
	/**
	 * TODO:documentation...
	 */
	protected final Project project;
	
	/**
	 * TODO:documentation...
	 * @param project
	 */
	@Inject
	public DefaultMeeting(Project project) {
		this.project = project;
		this.agenda = new DefaultAgendaHandler(); //TODO:implement proxy
		this.backups = new DefaultAgendaHandler(); //TODO:implement proxy
		this.attendeeHandler = new DefaultAttendeeHandler();
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected String description = null;

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected String location = null;

	@Override
	public String getLocation() {
		return location;
	}

	@Override
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected String time = null;

	@Override
	public String getTime() {
		return time;
	}

	@Override
	public void setTime(String time) {
		//TODO:validate time
		this.time = time;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected String date = null;

	@Override
	public String getDate() {
		return date;
	}

	@Override
	public void setDate(String date) {
		//TODO:validate date
		this.date = date;
	}

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
	
	/**
	 * TODO:documentation...
	 */
	protected final AgendaHandler backups;

	@Override
	public AgendaHandler backups() {
		return backups;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public AgendaHandler backups(Closure closure) {
		ConfigureUtil.configure(closure, backups);
		return backups;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected String agendaTemplate = null;

	@Override
	public String getAgendaTemplate() {
		return (agendaTemplate!=null) ? agendaTemplate :
			meetingsExtension().getAgendaTemplate();
	}
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	protected MeetingsHandler meetingsExtension() {
		return (MeetingsHandler)project.getExtensions()
				.getByName("meetings");
	}

	@Override
	public void setAgendaTemplate(String template) {
		//TODO:validate template?
		agendaTemplate = template;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected String minutesTemplate = null;

	@Override
	public String getMinutesTemplate() {
		return (minutesTemplate!=null) ? minutesTemplate :
			meetingsExtension().getMinutesTemplate();
	}

	@Override
	public void setMinutesTemplate(String template) {
		//TODO:validate template
		minutesTemplate = template;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected String presentationTemplate = null;

	@Override
	public String getPresentationTemplate() {
		return (presentationTemplate!=null) ? presentationTemplate :
			meetingsExtension().getPresentationTemplate();
	}

	@Override
	public void setPresentationTemplate(String template) {
		//TODO:validate template
		presentationTemplate = template;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected final AttendeeHandler attendeeHandler;

	@Override
	public AttendeeHandler attendees() {
		return attendeeHandler;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public AttendeeHandler attendees(Closure closure) {
		ConfigureUtil.configure(closure, attendeeHandler);
		return attendeeHandler;
	}
	
	@Override
	public void setAttendees(String... names) {
		attendeeHandler.attendee(names);
	}
	
	/**
	 * TODO:documentation...
	 */
	protected File meetingDir = null;

	@Override
	public File getMeetingDir() {
		if(meetingDir==null) {
			//TODO:get this usings the meetings Source Set...
			return project.file("src/meetings/" + getName());
		} else
			return meetingDir;
	}

	@Override
	public void setMeetingDir(Object object) {
		meetingDir = project.file(object);
	}

}
