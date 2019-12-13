/**
   Copyright 2019 Matt Fischer <mfish2011@gmail.com>

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package setools.gradle.task;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gradle.api.tasks.SourceTask;
import setools.uml.ResourceSetInitializerService;

/**
 * @author matt
 *
 */
public abstract class ModelTask extends SourceTask {

	protected final ResourceSet resourceSet;
	
	public ModelTask() {
		resourceSet = new ResourceSetImpl();
		ResourceSetInitializerService.initialize(resourceSet);
	}
	
	protected List<Resource> getResources() {
		//load any missing resources
		for(File file : getSource()) {
			URI uri = URI.createFileURI(file.getAbsolutePath());
			resourceSet.getResource(uri, true);
		}
		return resourceSet.getResources();
	}
	
	protected <T extends EObject> List<T> getElements(Class<T> type) {
		List<T> results = new ArrayList<T>();
		for(Resource resource : getResources()) {
			TreeIterator<EObject> iter = resource.getAllContents();
			while(iter.hasNext()) {
				EObject eObject = iter.next();
				if(type.isInstance(eObject))
					results.add(type.cast(eObject));
			}
		}
		return results;
	}
	
	protected EObject getElement(URI uri) {
		URI modelUri = uri.trimFragment();
		Resource resource = getResource(modelUri);
		if(resource!=null) {
			return getElement(resource,uri.fragment());
		}
		return null;
	}

	protected EObject getElement(Resource resource, String fragment) {
		return resource.getEObject(fragment);
	}

	protected Resource getResource(URI modelUri) {
		for(Resource resource : getResources()) {
			if(resource.getURI().equals(modelUri))
				return resource;
		}
		return null;
	}
}
