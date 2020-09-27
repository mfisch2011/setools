/**
 * TODO:license...
 */
package setools.gradle.meetings.dsl.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.inject.Inject;

import org.gradle.api.Project;
import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meetings.dsl.Meeting;
import setools.gradle.meetings.dsl.MeetingsHandler;

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
	protected final Collection<Meeting> meetings;
	
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
		return meetings.size();
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
	
	/**
	 * TODO:documentation...
	 */
	protected String agendaTemplate = "templates/meeting-agena.docx"; //TODO:make templates a source set...

	@Override
	public String getAgendaTemplate() {
		return agendaTemplate;
	}

	@Override
	public void setAgendaTemplate(String template) {
		//TODO:validate template
		agendaTemplate = template;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected String minutesTemplate = "templates/meeting-minutes.docx"; //TODO:make templates a source set...

	@Override
	public String getMinutesTemplate() {
		return minutesTemplate;
	}

	@Override
	public void setMinutesTemplate(String template) {
		//TODO:validate template
		minutesTemplate = template;
	}
	
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
}
