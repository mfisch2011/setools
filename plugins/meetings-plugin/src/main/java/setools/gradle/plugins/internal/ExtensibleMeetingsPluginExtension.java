/**
 * 
 */
package setools.gradle.plugins.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.function.Function;

import javax.inject.Inject;

import org.gradle.api.Project;
import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meeting.api.Meeting;
import setools.gradle.meeting.api.internal.ExtensibleMeetingsHandler;
import setools.gradle.plugins.MeetingsPluginExtension;

/**
 * TODO:documentation...
 */
public class ExtensibleMeetingsPluginExtension implements MeetingsPluginExtension {
	
	/**
	 * TODO:documentation...
	 */
	protected final Project project;

	/**
	 * TODO:documentation...
	 */
	public final ExtensibleMeetingsHandler meetings; //TODO:fix this!!!
	
	@Inject
	public ExtensibleMeetingsPluginExtension(Project project) {
		this.project = project;
		this.meetings = new ExtensibleMeetingsHandler(project);
	}
	
	/**
	 * TODO:documentation...
	 * @param function
	 */
	@SuppressWarnings("rawtypes")
	public void register(String name,Function<Closure,Meeting> function) {
		meetings.register(name,function);
	}

	@Override
	public Collection<Meeting> getMeetings() {
		return Collections.unmodifiableCollection(meetings.getMeetings());
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void meetings(Closure closure) {
		ConfigureUtil.configure(closure, meetings);
	}
}
