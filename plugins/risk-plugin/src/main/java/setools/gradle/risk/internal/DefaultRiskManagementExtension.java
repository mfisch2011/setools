/**
 * TODO:license...
 */
package setools.gradle.risk.internal;

import javax.inject.Inject;

import org.gradle.api.Project;

import setools.gradle.risk.RiskManagementExtension;

/**
 * TODO:documentation...
 */
public class DefaultRiskManagementExtension implements RiskManagementExtension {
	
	/**
	 * TODO:documentation...
	 * @param project
	 */
	protected final Project project;

	@Inject
	public DefaultRiskManagementExtension(Project project) {
		this.project = project;
	}
}
