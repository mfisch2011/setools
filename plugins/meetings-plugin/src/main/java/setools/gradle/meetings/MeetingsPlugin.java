/**
 * TODO:license...
 */
package setools.gradle.meetings;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

import setools.gradle.meetings.dsl.Meeting;
import setools.gradle.meetings.dsl.MeetingsHandler;
import setools.gradle.meetings.dsl.internal.DefaultMeetingsHandler;
import setools.gradle.meetings.util.InitializeMeetingTasks;

/**
 * TODO:documentation...
 */
public class MeetingsPlugin implements Plugin<Project> {

	protected static final String PLUGIN_EXT = "meetings";
	
	@Override
	public void apply(Project project) {
		applyPlugins(project);
		applyExtension(project);
		registerCallback(project);
	}
	
	/**
	 * TODO:documentation...
	 * @param project
	 */
	protected void registerCallback(Project project) {
		project.afterEvaluate(new Action<Project>() {

			@Override
			public void execute(Project project) {
				MeetingsHandler extension = (MeetingsHandler)
						project.getExtensions().getByName("meetings");
				for(Meeting meeting : extension) {
					InitializeMeetingTasks initializer = 
						new InitializeMeetingTasks(project,meeting);
					initializer.initializeTasks();
				}
			}
		});
	}
	
	/**
	 * TODO:documentation...
	 * @param project
	 */
	protected void applyExtension(Project project) {
		project.getExtensions().create(PLUGIN_EXT,
				DefaultMeetingsHandler.class, project);
	}
	
	/**
	 * TODO:documentation...
	 * @param project
	 */
	protected void applyPlugins(Project project) {
		project.getPluginManager().apply(MeetingsBasePlugin.class);
	}

}
