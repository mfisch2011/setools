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
package setools.gradle.plugins;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.gradle.api.Plugin;
import org.gradle.api.internal.project.ProjectInternal;

import setools.uml.internal.UmlResourceSetInitializer;
import setools.uml.util.ResourceSetInitializer;
import setools.uml.util.ResourceSetInitializerService;

/**
 * TODO:
 */
public class UmlPlugin implements Plugin<ProjectInternal> {

	/**
	 * TODO:
	 */
	protected Set<ResourceSetInitializer> initializers = new HashSet<ResourceSetInitializer>();
	
	public UmlPlugin() {
		register(new UmlResourceSetInitializer());
	}
	
	@Override
	public void apply(ProjectInternal project) {
		project.getPluginManager().apply(UmlBasePlugin.class); //TODO:do we want this in this plugin?
	}

	/**
	 * TODO:
	 * @param initializer
	 */
	public synchronized void register(ResourceSetInitializer initializer) {
		System.out.printf("REGISTER: %s%n", initializer);
		initializers.add(initializer);
	}
	
	/**
	 * TODO:
	 * @param resourceSet
	 */
	public synchronized void initialize(ResourceSet resourceSet) {
		for(ResourceSetInitializer initializer : initializers) {
			System.out.printf("INITIALIZING: %s%n", initializer);
			initializer.initialize(resourceSet);
		}
	}
}
