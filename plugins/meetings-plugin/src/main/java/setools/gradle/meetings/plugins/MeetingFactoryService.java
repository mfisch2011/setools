/**
 * TODO: add NSWC Crane's license...
 */
package setools.gradle.meetings.plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import setools.gradle.meetings.dsl.Meeting;
import setools.gradle.util.AbstractFactoryService;

/**
 * TODO:add documentation...
 *
 */
public class MeetingFactoryService extends AbstractFactoryService<Meeting> 
implements Plugin<Project> {
		
	@Override
	public void apply(Project project) {
		System.out.println("Applied setools.gradle.meetings.plugins.MeetingsFactoryService.");
		//shouldn't need to do any configuration here...
	}

}
