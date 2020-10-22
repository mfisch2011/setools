/**
 * TODO:license...
 */
package setools.gradle.tasks;

import java.io.File;
import java.util.Collection;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.gradle.api.specs.Spec;
import org.gradle.api.tasks.Internal;
import org.gradle.api.tasks.SourceTask;

/**
 * TODO:documentation...
 */
public class ModelTask extends SourceTask {
	
	/**
	 * TODO:documentation...
	 */
	private ResourceSet resourceSet = null;

	/**
	 * TODO:documentation...
	 * @return
	 */
	@Internal //TODO:make input once ModelFilter is compatible/serializable...
	public Collection<Resource> getResources() {
		for(File file : getSource()) {
			URI uri = URI.createFileURI(file.getAbsolutePath());
			resourceSet().getResource(uri,true);
		}
		return resourceSet().getResources();
	}
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	@Internal //TODO:make input once ModelFilter is compatible/serializable...
	public ModelFilter getElements() {
		Resource[] resources = getResources().toArray(new Resource[] {});
		return new DefaultModelFilter(resources);
	}
	
	/**
	 * TODO:documentation...
	 * @param spec
	 * @return
	 */
	public ModelFilter filter(Spec<EObject> spec) {
		DefaultModelFilter filter = new DefaultModelFilter(getElements());
		return filter.filter(spec);
	}
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	protected ResourceSet resourceSet() {
		if(resourceSet==null)
			initialize();
		return resourceSet;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected ResourceSet initialize() {
		resourceSet = new ResourceSetImpl();
		UMLResourcesUtil.init(resourceSet);
		return resourceSet;
	}
}
