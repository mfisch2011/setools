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
package setools.risk.internal;

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.Test;

import junit.framework.TestCase;
import setools.risk.Risk;
import setools.risk.RiskMitigation;
import setools.risk.util.RiskResourcesUtil;
import setools.uml.util.ResourceSetInitializerService;

/**
 * TODO:
 */
public class RiskResourceSetInitializerTests {

	/**
	 * Test method for {@link setools.risk.internal.RiskResourceSetInitializer#initialize(org.eclipse.emf.ecore.resource.ResourceSet)}.
	 */
	@Test
	public void testInitialize() {
		ResourceSet resourceSet = new ResourceSetImpl();
		ResourceSetInitializerService.initialize(resourceSet);
		RiskResourcesUtil.init(resourceSet);
		URI uri = URI.createFileURI("src/test/resources/test-riskml.uml"); //TODO:classloader getResource()...
		Resource resource = resourceSet.getResource(uri, true);
		assertNotNull(resource);
		for(EObject object : resource.getContents())
			System.out.println(object);
		
		//Test Risk1
		EObject eObject = resource.getEObject("_GSrwkKBKEeq_dMA2i4Hq1A");
		assertNotNull(eObject);
		assertTrue(eObject instanceof Class);
		Class risk1 = (Class)eObject;
		assertEquals("Risk1",risk1.getName());
		Stereotype stereo = risk1.getAppliedStereotype("risk::Risk");
		assertNotNull(stereo);
		eObject = risk1.getStereotypeApplication(stereo);
		assertNotNull(eObject);
		assertTrue(eObject instanceof Risk);
		Risk risk = (Risk)eObject;
		assertEquals(risk.getBase_Class(),risk1);
		assertEquals(2,risk.getMitigations().size());
		
		//Test Mitigation1
		eObject = resource.getEObject("_IABcIKBKEeq_dMA2i4Hq1A");
		assertNotNull(eObject);
		assertTrue(eObject instanceof Class);
		Class mitigation1 = (Class)eObject;
		assertEquals("Mitigation1",mitigation1.getName());
		stereo = mitigation1.getAppliedStereotype("risk::Risk Mitigation");
		assertNotNull(stereo);
		eObject = mitigation1.getStereotypeApplication(stereo);
		assertNotNull(eObject);
		assertTrue(eObject instanceof RiskMitigation);
		RiskMitigation mitigation = (RiskMitigation)eObject;
		assertEquals(mitigation.getBase_Class(),mitigation1);
		assertTrue(risk.getMitigations().contains(mitigation));
		
		//Test Mitigation1
		eObject = resource.getEObject("_JLuaQKBKEeq_dMA2i4Hq1A");
		assertNotNull(eObject);
		assertTrue(eObject instanceof Class);
		Class mitigation2 = (Class)eObject;
		assertEquals("Mitigation2",mitigation2.getName());
		stereo = mitigation2.getAppliedStereotype("risk::Risk Mitigation");
		assertNotNull(stereo);
		eObject = mitigation2.getStereotypeApplication(stereo);
		assertNotNull(eObject);
		assertTrue(eObject instanceof RiskMitigation);
		mitigation = (RiskMitigation)eObject;
		assertEquals(mitigation.getBase_Class(),mitigation2);
		assertTrue(risk.getMitigations().contains(mitigation));
		fail("I need the link");
	}

}
