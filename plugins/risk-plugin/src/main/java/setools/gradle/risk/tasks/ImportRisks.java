/**
 * TODO:license...
 */
package setools.gradle.risk.tasks;

import org.eclipse.emf.ecore.resource.ResourceSet;
import setools.gradle.tasks.ImportModel;
import setools.risk.util.RiskResourcesUtil;

/**
 * TODO:documentation...
 */
public abstract class ImportRisks extends ImportModel {

	@Override
	protected ResourceSet initialize() {
		ResourceSet resourceSet = super.initialize();
		RiskResourcesUtil.init(resourceSet);
		return resourceSet;
	}
	
}
