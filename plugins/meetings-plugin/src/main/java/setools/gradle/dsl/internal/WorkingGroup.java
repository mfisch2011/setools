/**
 * 
 */
package setools.gradle.dsl.internal;

import java.net.URISyntaxException;
import java.util.function.Function;

import org.gradle.api.Project;
import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meeting.api.Meeting;
import setools.gradle.meeting.api.MeetingsHandler;
import setools.gradle.meeting.api.internal.DefaultMeeting;

/**
 * TODO:documentation...
 */
@SuppressWarnings("rawtypes")
public class WorkingGroup implements Function<Closure, Meeting> {

	/**
	 * TODO:documentation...
	 */
	protected final MeetingsHandler handler;
	protected final Project project;

	/**
	 * TODO:docuemntation...
	 * @param handler
	 */
	public WorkingGroup(Project project,MeetingsHandler handler) {
		this.project = project;
		this.handler = handler;
	}

	@Override
	public Meeting apply(Closure closure) {
		try {
			DefaultMeeting meeting = new DefaultMeeting(project);
			ConfigureUtil.configure(closure,meeting);
			handler.add(meeting);
			return meeting;
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

}
