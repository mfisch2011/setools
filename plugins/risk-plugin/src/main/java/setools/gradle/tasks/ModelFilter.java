/**
 * TODO:license...
 */
package setools.gradle.tasks;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.gradle.api.specs.Spec;

/**
 * TODO:documentation...
 */
public interface ModelFilter extends Collection<EObject> {

	/**
	 * TODO:documentation...
	 * @param spec
	 * @return
	 */
	public ModelFilter filter(Spec<EObject> spec);
	
	//TODO:add each method?
}
