/**
 * TODO:license...
 */
package setools.gradle.actions.internal;

import javax.inject.Inject;

import org.gradle.api.Project;

import setools.gradle.actions.ActionItemsExtension;

/**
 * TODO:documentation...
 */
public class DefaultActionItemsExtension implements ActionItemsExtension {
	
	/**
	 * TODO:documentation...
	 */
	protected final Project project;

	/**
	 * TODO:documentation...
	 * @param project
	 */
	@Inject
	public DefaultActionItemsExtension(Project project) {
		this.project = project;
	}
}
