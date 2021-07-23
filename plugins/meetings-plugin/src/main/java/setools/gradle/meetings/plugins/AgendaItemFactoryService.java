/**
 * TODO: add NSWC Crane's license...
 */
package setools.gradle.meetings.plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import setools.gradle.meetings.dsl.AgendaItem;
import setools.gradle.util.AbstractFactoryService;

/**
 * TODO:add documentation...
 *
 */
public class AgendaItemFactoryService extends AbstractFactoryService<AgendaItem> 
implements Plugin<Project> {

	@Override
	public void apply(Project project) {
		//shouldn't need to perform any configuration...
	}

}
