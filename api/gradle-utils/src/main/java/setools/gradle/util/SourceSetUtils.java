/**
 * 
 */
package setools.gradle.util;

import org.gradle.api.Project;
import org.gradle.api.plugins.JavaPluginConvention;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.SourceSetContainer;

/**
 * TODO:
 */
public class SourceSetUtils {

	/**
	 * Get the SourceSet with name from project.
	 * 
	 * @param project - {@link org.gradle.api.Project} to search
	 * @param name - of {@link org.gradle.api.tasks.SourceSet} to retreive
	 * @return {@link org.gradle.api.tasks.SourceSet}
	 */
	public static SourceSet getSourceSet(Project project, String name) {
		return getSourceSets(project).getByName(name);
	}

	/**
	 * Get the SourceSetContainer for project.
	 * 
	 * @param project - {@link org.gradle.api.Project} to search
	 * @return {@link org.gradle.api.tasks.SourceSetContainer}
	 */
	public static SourceSetContainer getSourceSets(Project project) {
		return project.getConvention().getPlugin(JavaPluginConvention.class).getSourceSets();
	}

}
