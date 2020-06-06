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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.junit.Test;

import setools.risk.Risk;
import setools.risk.RiskMitigation;
import setools.risk.StatusUpdate;
import setools.uml.util.ResourceSetInitializerService;

import static setools.uml.util.UMLUtils.getObject;
import static setools.util.BaseUtils.toDate;

/**
 * TODO:
 */
public class RiskResourceSetInitializerTest {

	/**
	 * Test method for {@link setools.risk.internal.RiskResourceSetInitializer#initialize(org.eclipse.emf.ecore.resource.ResourceSet)}.
	 */
	@Test
	public void testInitialize() {
		ResourceSet resourceSet = new ResourceSetImpl();
		ResourceSetInitializerService.initialize(resourceSet);
		URI uri = URI.createFileURI("src/test/resources/test-riskml.uml"); //TODO:classloader getResource()...
		Resource resource = resourceSet.getResource(uri, true);
		assertNotNull(resource);
		
		//collection objects
		Risk risk1 = getObject(resource,"_HYaCgKBKEeq_dMA2i4Hq1A",Risk.class);
		assertNotNull(risk1);
		RiskMitigation mitigation1 = getObject(resource,"_OwoNQKBKEeq_dMA2i4Hq1A",RiskMitigation.class);
		assertNotNull(mitigation1);
		RiskMitigation mitigation2 = getObject(resource,"_PhPx4KBKEeq_dMA2i4Hq1A",RiskMitigation.class);
		assertNotNull(mitigation2);
		StatusUpdate update1 = getObject(resource,"_O76N0KdpEeq85JCXTYHCoQ",StatusUpdate.class);
		assertNotNull(update1);
		StatusUpdate update2 = getObject(resource,"_RsZYcKdpEeq85JCXTYHCoQ",StatusUpdate.class);
		assertNotNull(update2);
		StatusUpdate update3 = getObject(resource,"_WEezAKdpEeq85JCXTYHCoQ",StatusUpdate.class);
		assertNotNull(update3);
		StatusUpdate update4 = getObject(resource,"_W0_C4KdpEeq85JCXTYHCoQ",StatusUpdate.class);
		assertNotNull(update4);
		
		//test Update 1
		assertEquals(toDate("2019-01-01"),update1.getDate());
		
		//test Update 2
		assertEquals(toDate("2019-02-01"),update2.getDate());
		
		//test Update 3
		assertEquals(toDate("2019-03-01"),update3.getDate());
		
		//test Update 4
		assertEquals(toDate("2019-04-01"),update4.getDate());
		
		//test Risk 1
		Class risk1Class = risk1.getBase_Class();
		assertNotNull(risk1Class);
		assertEquals("Risk1",risk1Class.getName());
		assertEquals(risk1,org.eclipse.uml2.uml.util.UMLUtil.
				getStereotypeApplication(risk1Class, Risk.class));
		//TODO: assertEquals("",risk1.getId());
		//TODO: assertEquals("",risk1.getStatement());
		//TODO: assertEquals(,risk1.getLikelihood());
		//TODO: assertEquals(,risk1.getConsequence());
		//TODO: assertEquals(,risk1.getRisk());
		List<RiskMitigation> mitigations = new ArrayList<RiskMitigation>();
		
		for(RiskMitigation mitigation : risk1.getMitigations())
			System.out.println(mitigation);
		System.out.printf("TEST FOR %s%n",mitigation1);
		assertTrue(risk1.getMitigations().contains(mitigation1));
		System.out.printf("TEST FOR %s%n",mitigation2);
		assertTrue(risk1.getMitigations().contains(mitigation2));
		Iterator<StatusUpdate> iter = risk1.getStatusUpdates().iterator();
		assertEquals(update1,iter.next());
		assertEquals(update2,iter.next());
		assertEquals(update3,iter.next());
		assertEquals(update4,iter.next());
		
		//test Mitigation1
		Class mitigation1Class = mitigation1.getBase_Class();
		assertNotNull(mitigation1Class);
		assertEquals("Mitigation1",mitigation1Class.getName());
		assertEquals(mitigation1,org.eclipse.uml2.uml.util.UMLUtil.
				getStereotypeApplication(mitigation1Class, RiskMitigation.class));
		//TODO: assertEquals("",mitigation1.getId());
		//TODO: assertEquals("",mitigation1.getStatement());
		//TODO: assertEquals(,mitigation1.getLikelihood());
		//TODO: assertEquals(,mitigation1.getConsequence());
		//TODO: assertEquals(,mitigation1.getRisk());
		//TODO: assertEquals(toDate(""),mitigation1.getPlanned());
		
		//test Mitigation2
		Class mitigation2Class = mitigation2.getBase_Class();
		assertNotNull(mitigation2Class);
		assertEquals("Mitigation2",mitigation2Class.getName());
		assertEquals(mitigation2,org.eclipse.uml2.uml.util.UMLUtil.
				getStereotypeApplication(mitigation2Class, RiskMitigation.class));
		//TODO: assertEquals("",mitigation2.getId());
		//TODO: assertEquals("",mitigation2.getStatement());
		//TODO: assertEquals(,mitigation2.getLikelihood());
		//TODO: assertEquals(,mitigation2.getConsequence());
		//TODO: assertEquals(,mitigation2.getRisk());
		//TODO: assertEquals(toDate(""),mitigation2.getPlanned());
		
	}
}
