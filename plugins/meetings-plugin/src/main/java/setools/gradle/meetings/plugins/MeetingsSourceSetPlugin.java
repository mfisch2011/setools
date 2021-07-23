/**
 * TODO: add NSWC Crane's license...
 */
package setools.gradle.meetings.plugins;

import org.gradle.api.Project;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.SourceSetContainer;

import setools.gradle.util.AbstractSourceSetPlugin;

/**
 * TODO:add documentation...
 *
 */
public class MeetingsSourceSetPlugin extends AbstractSourceSetPlugin {

	/**
	 * TODO:add documentation...
	 */
	public static final String MEETINGS_SOURCE_SET_NAME = "meetings";
	
	@Override
	protected void addSourceSets(Project project,SourceSetContainer sourceSets) {
		//TODO: replace the DefaultSourceSet with an actual MeetingsSourceSet...
		@SuppressWarnings("unused")
		SourceSet sourceSet = sourceSets.create(MEETINGS_SOURCE_SET_NAME);
		//TODO: other source set configuration...
	}

}
