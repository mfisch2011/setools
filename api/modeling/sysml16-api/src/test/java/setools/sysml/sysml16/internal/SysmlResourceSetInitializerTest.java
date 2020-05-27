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
package setools.sysml.sysml16.internal;

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.sysml16.requirements.DeriveReqt;
import org.eclipse.papyrus.sysml16.requirements.Refine;
import org.eclipse.papyrus.sysml16.requirements.Requirement;
import org.eclipse.papyrus.sysml16.requirements.TestCase;
import org.eclipse.papyrus.sysml16.requirements.Verify;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.Test;

import setools.uml.util.ResourceSetInitializerService;

/**
 * TODO:
 */
public class SysmlResourceSetInitializerTest {

	/**
	 * Test method for {@link setools.sysml.sysml14.internal.SysmlResourceSetInitializer#initialize(org.eclipse.emf.ecore.resource.ResourceSet)}.
	 */
	@Test
	public void testInitialize() {
		ResourceSet resourceSet = new ResourceSetImpl();
		ResourceSetInitializerService.initialize(resourceSet);
		URI uri = URI.createFileURI("src/test/resources/test-sysml16.uml"); //TODO:classloader getResource()...
		Resource resource = resourceSet.getResource(uri, true);
		assertNotNull(resource);
		
		//Test Requirement13
		EObject eObject = resource.getEObject("_LCnSIKBEEeq_dMA2i4Hq1A");
		assertNotNull(eObject);
		assertTrue(eObject instanceof Class);
		Class reqt13 = (Class)eObject;
		assertEquals("Requirement13",reqt13.getName());
		Stereotype stereo = reqt13.getAppliedStereotype("SysML::Requirements::Requirement");
		assertNotNull(stereo);
		eObject = reqt13.getStereotypeApplication(stereo);
		assertNotNull(eObject);
		assertTrue(eObject instanceof Requirement);
		Requirement reqt = (Requirement)eObject;
		assertEquals(reqt.getBase_Class(),reqt13);
		
		//Test Requirement14
		eObject = resource.getEObject("_LpaMYKBEEeq_dMA2i4Hq1A");
		assertNotNull(eObject);
		assertTrue(eObject instanceof Class);
		Class reqt14 = (Class)eObject;
		assertEquals("Requirement14",reqt14.getName());
		stereo = reqt14.getAppliedStereotype("SysML::Requirements::Requirement");
		assertNotNull(stereo);
		eObject = reqt14.getStereotypeApplication(stereo);
		assertNotNull(eObject);
		assertTrue(eObject instanceof Requirement);
		reqt = (Requirement)eObject;
		assertEquals(reqt.getBase_Class(),reqt14);
		
		//Test Requirement15
		eObject = resource.getEObject("_MMiHkKBEEeq_dMA2i4Hq1A");
		assertNotNull(eObject);
		assertTrue(eObject instanceof Class);
		Class reqt15 = (Class)eObject;
		assertEquals("Requirement15",reqt15.getName());
		stereo = reqt15.getAppliedStereotype("SysML::Requirements::Requirement");
		assertNotNull(stereo);
		eObject = reqt15.getStereotypeApplication(stereo);
		assertNotNull(eObject);
		assertTrue(eObject instanceof Requirement);
		reqt = (Requirement)eObject;
		assertEquals(reqt.getBase_Class(),reqt15);
		
		//Test Activity16
		eObject = resource.getEObject("_Mu_7cKBEEeq_dMA2i4Hq1A");
		assertNotNull(eObject);
		assertTrue(eObject instanceof Activity);
		Activity activity16 = (Activity)eObject;
		assertEquals("Activity16",activity16.getName());
		stereo = activity16.getAppliedStereotype("SysML::Requirements::TestCase");
		assertNotNull(stereo);
		eObject = activity16.getStereotypeApplication(stereo);
		assertNotNull(eObject);
		assertTrue(eObject instanceof TestCase);
		TestCase testCase = (TestCase)eObject;
		assertEquals(testCase.getBase_Behavior(),activity16);
		
		//Test Refine19
		eObject = resource.getEObject("_fUvHgKBEEeq_dMA2i4Hq1A");
		assertNotNull(eObject);
		assertTrue(eObject instanceof Abstraction);
		Abstraction refine19 = (Abstraction)eObject;
		assertEquals("Refine19",refine19.getName());
		assertEquals(1,refine19.getClients().size());
		assertEquals(reqt14,refine19.getClients().get(0));
		assertEquals(1,refine19.getSuppliers().size());
		assertEquals(reqt13,refine19.getSuppliers().get(0));
		stereo = refine19.getApplicableStereotype("SysML::Requirements::Refine");
		assertNotNull(stereo);
		eObject = refine19.getStereotypeApplication(stereo);
		assertNotNull(eObject);
		assertTrue(eObject instanceof Refine);
		Refine refine = (Refine)eObject;
		assertEquals(refine.getBase_Abstraction(),refine19);
		
		//Test DeriveReqt18
		eObject = resource.getEObject("_Z45w8KBEEeq_dMA2i4Hq1A");
		assertNotNull(eObject);
		assertTrue(eObject instanceof Abstraction);
		Abstraction derived18 = (Abstraction)eObject;
		assertEquals("DeriveReqt18",derived18.getName());
		assertEquals(1,derived18.getClients().size());
		assertEquals(reqt15,derived18.getClients().get(0));
		assertEquals(1,derived18.getSuppliers().size());
		assertEquals(reqt14,derived18.getSuppliers().get(0));
		stereo = derived18.getAppliedStereotype("SysML::Requirements::DeriveReqt");
		assertNotNull(stereo);
		eObject = derived18.getStereotypeApplication(stereo);
		assertNotNull(eObject);
		assertTrue(eObject instanceof DeriveReqt);
		DeriveReqt derived = (DeriveReqt)eObject;
		assertEquals(derived.getBase_Abstraction(),derived18);
		
		//Test Verify17
		eObject = resource.getEObject("_NjnPQKBEEeq_dMA2i4Hq1A");
		assertNotNull(eObject);
		assertTrue(eObject instanceof Abstraction);
		Abstraction verify17 = (Abstraction)eObject;
		assertEquals("Verify17",verify17.getName());
		assertEquals(1,verify17.getClients().size());
		assertEquals(activity16,verify17.getClients().get(0));
		assertEquals(1,verify17.getSuppliers().size());
		assertEquals(reqt15,verify17.getSuppliers().get(0));
		stereo = verify17.getAppliedStereotype("SysML::Requirements::Verify");
		assertNotNull(stereo);
		eObject = verify17.getStereotypeApplication(stereo);
		assertNotNull(eObject);
		assertTrue(eObject instanceof Verify);
		Verify verify = (Verify)eObject;
		assertEquals(verify.getBase_Abstraction(),verify17);
	}

}
