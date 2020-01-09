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
package setools.sysml;

import org.eclipse.emf.ecore.resource.ResourceSet;

import setools.uml.ResourceSetInitializer;

/**
 * @author matt
 *
 */
public class SysML14ResourceSetInitializer implements ResourceSetInitializer {

	@Override
	public void initialize(ResourceSet resourceSet) {
		SysML14ResourcesUtil.init(resourceSet); //defer to maintain compatibility
	}

}
