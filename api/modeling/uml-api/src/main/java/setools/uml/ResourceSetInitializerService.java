/**
   Copyright 2020 Matt Fischer <mfish2011@gmail.com>

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
package setools.uml;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * TODO:
 */
public class ResourceSetInitializerService {

	/**
	 * TODO:
	 */
	private static ServiceLoader<ResourceSetInitializer> serviceLoader = 
			ServiceLoader.load(ResourceSetInitializer.class);
	
	/**
	 * Implementing class as static singleton.
	 */
	private ResourceSetInitializerService() { };
	
	/** TODO:
	 * @param resourceSet
	 */
	public synchronized static void initialize(ResourceSet resourceSet) {
		Iterator<ResourceSetInitializer> iter = serviceLoader.iterator();
		while(iter.hasNext()) {
			ResourceSetInitializer initializer = iter.next();
			initializer.initialize(resourceSet);
		}
	}
	
	/** TODO:
	 * @param loader
	 */
	public synchronized static void reload(ClassLoader loader) {
		serviceLoader = ServiceLoader.load(ResourceSetInitializer.class,loader);
	}
}
