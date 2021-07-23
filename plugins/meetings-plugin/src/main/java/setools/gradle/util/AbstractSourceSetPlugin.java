/**
 * TODO: add NSWC Crane's license...
 */
package setools.gradle.util;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.JvmEcosystemPlugin;
import org.gradle.api.tasks.SourceSetContainer;

/**
 * TODO:add documentation...
 *
 */
public abstract class AbstractSourceSetPlugin implements Plugin<Project> {

	
	@Override
	public void apply(Project project) {
		/*
		 * necessary for sourceSets and to prevent collision if we 
		 * were to manually create a SourceSetContainer...
		 */
		project.getPluginManager().apply(JvmEcosystemPlugin.class);
		SourceSetContainer sourceSets = project.getExtensions()
				.getByType(SourceSetContainer.class);
		addSourceSets(project,sourceSets);
	}

	/**
	 * TODO:add documentation...
	 * @param sourceSets
	 */
	protected abstract void addSourceSets(Project project,SourceSetContainer sourceSets);

}
