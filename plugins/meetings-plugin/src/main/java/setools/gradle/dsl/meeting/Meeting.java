/**
 * TODO:license...
 */
package setools.gradle.dsl.meeting;

import java.io.File;

import groovy.lang.Closure;
import setools.gradle.dsl.agenda.AgendaHandler;
import setools.gradle.dsl.attendee.AttendeeHandler;

/**
 * TODO:documentation...
 */
public interface Meeting {
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getAgendaTemplate();
	
	/**
	 * TODO:documentation...
	 * @param template
	 */
	public void setAgendaTemplate(String template);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getMinutesTemplate();
	
	/**
	 * TODO:documentation...
	 * @param template
	 */
	public void setMinutesTemplate(String template);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getPresentationTemplate();
	
	/**
	 * TODO:documentation...
	 * @param template
	 */
	public void setPresentationTemplate(String template);

	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getName();

	/**
	 * TODO:documentation...
	 * @param name
	 */
	public void setName(String name);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getDescription();
	
	/**
	 * TODO:documentation...
	 * @param description
	 */
	public void setDescription(String description);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getLocation();
	
	/**
	 * TODO:documentation...
	 * @param location
	 */
	public void setLocation(String location);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getTime();
	
	/**
	 * TODO:documentation...
	 * @param time
	 */
	public void setTime(String time);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getDate();
	
	/**
	 * TODO:documentation...
	 * @param date
	 */
	public void setDate(String date);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public AgendaHandler agenda();
	
	/**
	 * TODO:documentation...
	 * @param closure
	 */
	@SuppressWarnings("rawtypes")
	public AgendaHandler agenda(Closure closure);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public AgendaHandler backups();
	
	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public AgendaHandler backups(Closure closure);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public AttendeeHandler attendees();
	
	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public AttendeeHandler attendees(Closure closure);
	
	/**
	 * TODO:documentation...
	 * @param names
	 */
	public void setAttendees(String...names); 
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public File getMeetingDir();
	
	/**
	 * TODO:documentation...
	 * @param object
	 */
	public void setMeetingDir(Object object);
}
