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
package setools.uml.internal;

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.profile.standard.ImplementationClass;
import org.eclipse.uml2.uml.profile.standard.Realization;
import org.eclipse.uml2.uml.profile.standard.Utility;

import setools.uml.util.ResourceSetInitializerService;

/**
 * TODO:
 */
public class UmlResourceSetInitializerTest {

	/**
	 * Test method for {@link setools.uml.internal.UmlResourceSetInitializer#initialize(org.eclipse.emf.ecore.resource.ResourceSet)}.
	 */
	@Test
	public void testInitialize() {
		ResourceSet resourceSet = new ResourceSetImpl();
		ResourceSetInitializerService.initialize(resourceSet);
		URI uri = URI.createFileURI("src/test/resources/test-uml.uml"); //TODO:classloader getResource()...
		Resource resource = resourceSet.getResource(uri, true);
		assertNotNull(resource);
		
		//Test Class3
		EObject eObject = resource.getEObject("_SjwD8KAmEeq_dMA2i4Hq1A");
		assertNotNull(eObject);
		assertTrue(eObject instanceof Class);
		Class class3 = (Class)eObject;
		assertEquals("Class3",class3.getName());
		Stereotype stereo = class3.getAppliedStereotype("StandardProfile::Utility");
		assertNotNull(stereo);
		eObject = class3.getStereotypeApplication(stereo);
		assertNotNull(eObject);
		assertTrue(eObject instanceof Utility);
		Utility utility = (Utility)eObject;
		assertEquals(utility.getBase_Class(),class3);
		
		
		//Test Class5
		eObject = resource.getEObject("_fxCkoKAmEeq_dMA2i4Hq1A");
		assertNotNull(eObject);
		assertTrue(eObject instanceof Class);
		Class class5 = (Class)eObject;
		assertEquals("Class5",class5.getName());
		stereo = class5.getAppliedStereotype("StandardProfile::ImplementationClass");
		assertNotNull(stereo);
		eObject = class5.getStereotypeApplication(stereo);
		assertNotNull(eObject);
		assertTrue(eObject instanceof ImplementationClass);
		ImplementationClass implementation = (ImplementationClass)eObject;
		assertEquals(implementation.getBase_Class(),class5);
		
		//Test association...
		eObject = resource.getEObject("_kkK8cKAmEeq_dMA2i4Hq1A");
		assertNotNull(eObject);
		assertTrue(eObject instanceof Association);
		Association assoc = (Association)eObject;
		assertNull(assoc.getName());
		//TODO:how to test start and end off assoc???
		assertTrue(class3.getAssociations().contains(assoc));
		assertTrue(class5.getAssociations().contains(assoc));
		stereo = assoc.getAppliedStereotype("StandardProfile::Realization");
		assertNotNull(stereo);
		eObject = assoc.getStereotypeApplication(stereo);
		assertNotNull(eObject);
		assertTrue(eObject instanceof Realization);
		Realization realization = (Realization)eObject;
		assertEquals(realization.getBase_Classifier(),assoc);
	}

}
