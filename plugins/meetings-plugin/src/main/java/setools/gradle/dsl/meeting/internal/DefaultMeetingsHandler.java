/**
 * TODO:license...
 */
package setools.gradle.dsl.meeting.internal;

import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.lang.IllegalArgumentException;

import java.util.Collection;
import java.util.Iterator;

import javax.inject.Inject;

import org.gradle.api.Project;
import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.dsl.meeting.Meeting;
import setools.gradle.dsl.meeting.MeetingsHandler;

import setools.util.resources.ResourceLoader;

/**
 * TODO:documentation...
 */
public class DefaultMeetingsHandler implements MeetingsHandler {

	/**
	 * TODO:documentation...
	 */
	protected final Project project;
	
	/**
	 * TODO:documentation...
	 */
	protected final Collection<Meeting> meetings; // TODO Auto-generated method stub
	
	/**
	 * TODO:documentation...
	 * @param project
	 */
	@Inject
	public DefaultMeetingsHandler(Project project) {
		this.project = project;
		this.meetings = new ArrayList<Meeting>();
	}

	@Override
	public boolean add(Meeting meeting) {
		return meetings.add(meeting);
	}

	@Override
	public boolean addAll(Collection<? extends Meeting> meetings) {
		return this.meetings.addAll(meetings);
	}

	@Override
	public void clear() {
		meetings.clear();
	}

	@Override
	public boolean contains(Object meeting) {
		return meetings.contains(meeting);
	}

	@Override
	public boolean containsAll(Collection<?> meetings) {
		return this.meetings.containsAll(meetings);
	}

	@Override
	public boolean isEmpty() {
		return meetings.isEmpty();
	}

	@Override
	public Iterator<Meeting> iterator() {
		return meetings.iterator();
	}

	@Override
	public boolean remove(Object meeting) {
		return meetings.remove(meeting);
	}

	@Override
	public boolean removeAll(Collection<?> meetings) {
		return this.meetings.removeAll(meetings);
	}

	@Override
	public boolean retainAll(Collection<?> meetings) {
		return this.meetings.retainAll(meetings);
	}

	@Override
	public int size() {
		return meetings.size();// TODO Auto-generated method stub
		
	}

	@Override
	public Object[] toArray() {
		return meetings.toArray();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		return meetings.toArray(arg0);
	}

	@Override
	public Meeting meeting() {
		Meeting meeting = new DefaultMeeting(project);
		meetings.add(meeting);
		return meeting;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Meeting meeting(Closure closure) {
		Meeting meeting = new DefaultMeeting(project);
		ConfigureUtil.configure(closure, meeting);
		meetings.add(meeting);
		return meeting;
	}
	
	//TODO:allow configuring the agenda and minutes by templates...
	
	/**
	 * TODO:documentation...
	 */
	protected String presentationTemplate = "templates/meeting-presentation-template.pptx"; //TODO:make templates a source set...

	@Override
	public String getPresentationTemplate() {
		return presentationTemplate;
	}

	@Override
	public void setPresentationTemplate(String template) {
		//TODO:validate template
		presentationTemplate = template;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected String agendaTemplate = "templates/meeting-agenda-template.odt";

	@Override
	public String getAgendaTemplate() {
		return agendaTemplate;
	}

	@Override
	public void setAgendaTemplate(String template) {
		try {
			InputStream stream = ResourceLoader.getResource(template);
			stream.close();
			agendaTemplate = template;
		} catch(IOException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	/**
	 * TODO:documentation...
	 */
	protected String minutesTemplate = "templates/meeting-minutes-template.docx";

	@Override
	public String getMinutesTemplate() {
		return minutesTemplate;
	}

	@Override
	public void setMinutesTemplate(String template) {
		try {
			InputStream stream = ResourceLoader.getResource(template);
			stream.close();
			agendaTemplate = template;
		} catch(IOException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
