/**
 * TODO:license...
 */
package setools.gradle.risk.tasks;

import org.eclipse.emf.ecore.EObject;
import org.gradle.api.specs.Spec;
import org.gradle.api.tasks.Internal;

import setools.gradle.tasks.DefaultModelFilter;
import setools.gradle.tasks.ModelFilter;
import setools.gradle.tasks.ModelTask;
import setools.risk.Mitigation;
import setools.risk.Risk;

/**
 * TODO:documentation...
 */
public class RiskManagementTask extends ModelTask {

	/**
	 * TODO:documentation...
	 * @return
	 */
	@Internal //TODO:make input once ModelFilter is compatible/serializable...
	public ModelFilter getRisks() {
		return new DefaultModelFilter(getElements()).filter(new RiskFilter());
	}
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	@Internal //TODO:make input once ModelFilter is compatible/serializable...
	public ModelFilter getMitigations() {
		return new DefaultModelFilter(getElements()).filter(new MitigationFilter());
	}
	
	/**
	 * TODO:documentation...
	 */
	public static class RiskFilter implements Spec<EObject> {

		@Override
		public boolean isSatisfiedBy(EObject object) {
			return (object instanceof Risk);
		}
		
	}
	
	/**
	 * TODO:documentation...
	 */
	public static class MitigationFilter implements Spec<EObject> {

		@Override
		public boolean isSatisfiedBy(EObject object) {
			return (object instanceof Mitigation);
		}
		
	}
}
