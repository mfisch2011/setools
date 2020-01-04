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
package setools.uml.util;

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.junit.Before;
import org.junit.Test;

import setools.uml.ResourceSetInitializerService;

/**
 * @author matt
 *
 */
public class UMLUtilitiesTest {

	protected XMIResource resource = null;
	
	//TODO:is there a way to perform this only once and do we really need to do this before every test???
	@Before
	public void setup() {
		ResourceSet resourceSet = new ResourceSetImpl();
		ResourceSetInitializerService.initialize(resourceSet);
		//TODO:how to get this from a general uri that is compatible with jarred resources???
		resource = (XMIResource) resourceSet.getResource(URI.createFileURI("src/test/resources/uml-utilities-test.uml"),true);
	}
	
	/**
	 * Test method for {@link setools.uml.util.UMLUtilities#getSteps(org.eclipse.emf.ecore.EObject)}.
	 */
	@Test
	public void testGetStepsEObject() {
		System.out.println("String testGetStepsEObject");
		EObject object = resource.getEObject("_C_uIICTREeqH_rjszRWaSw");
		assertNotNull("Missing Test Activity 1",object);
		assertTrue("Test Activity 1 is not an Activity",object instanceof Activity);
		DepthAwareTreeIterator<EObject> tst = UMLUtilities.getSteps(object);
		assertNotNull("Returned null iterator",tst);
		assertTrue("Empty iterator",tst.hasNext());
		assertActivityNode("Initial node",tst.next(),"_LSUQcCTREeqH_rjszRWaSw");
		assertTrue("Empty iterator",tst.hasNext());
		assertActivityNode("Action 1",tst.next(),"_M4wp0CTREeqH_rjszRWaSw");
		assertTrue("Empty iterator",tst.hasNext());
		assertActivityNode("Action 2",tst.next(),"_N-TVkCTREeqH_rjszRWaSw");
		assertTrue("Empty iterator",tst.hasNext());
		assertActivityNode("Action 3",tst.next(),"_OsAwICTREeqH_rjszRWaSw");
		assertTrue("Empty iterator",tst.hasNext());
		assertActivityNode("Final node",tst.next(),"_L8a9YCTREeqH_rjszRWaSw");
		System.out.println("End testGetStepsEObject");
	}
	
	/**
	 * Test method for {@link setools.uml.util.UMLUtilities#getSteps(org.eclipse.emf.ecore.EObject)}.
	 */
	@Test
	public void testDepthAwareTreeIterator() {
		System.out.println("Start testDepthAwareTreeItertator");
		EObject object = resource.getEObject("_YDA0YCTUEeqH_rjszRWaSw");
		assertNotNull("Missing Test Activity 2",object);
		assertTrue("Test Activity 2 is not an Activity",object instanceof Activity);
		DepthAwareTreeIterator<EObject> tst = UMLUtilities.getSteps((Activity)object);
		assertNotNull("Returned null iterator",tst);
		assertTrue("Empty iterator",tst.hasNext());
		assertActivityNode("Initial node",tst.next(),"_bnpYwCTUEeqH_rjszRWaSw");
		assertEquals("Incorrect depth",1,tst.getDepth());
		assertTrue("Empty iterator",tst.hasNext());
		assertActivityNode("Action A",tst.next(),"_g3SGYCTUEeqH_rjszRWaSw");
		assertEquals("Incorrect depth",1,tst.getDepth());
		assertTrue("Empty iterator",tst.hasNext());
		assertActivityNode("Action B",tst.next(),"_n1DJwCTUEeqH_rjszRWaSw");
		assertEquals("Incorrect depth",1,tst.getDepth());
		
		assertTrue("Empty iterator",tst.hasNext());
		assertActivityNode("Initial node 2",tst.next(),"_LSUQcCTREeqH_rjszRWaSw");
		assertEquals("Incorrect depth",2,tst.getDepth());
		assertTrue("Empty iterator",tst.hasNext());
		assertActivityNode("Action 1",tst.next(),"_M4wp0CTREeqH_rjszRWaSw");
		assertEquals("Incorrect depth",2,tst.getDepth());
		assertTrue("Empty iterator",tst.hasNext());
		assertActivityNode("Action 2",tst.next(),"_N-TVkCTREeqH_rjszRWaSw");
		assertEquals("Incorrect depth",2,tst.getDepth());
		assertTrue("Empty iterator",tst.hasNext());
		assertActivityNode("Action 3",tst.next(),"_OsAwICTREeqH_rjszRWaSw");
		assertEquals("Incorrect depth",2,tst.getDepth());
		assertTrue("Empty iterator",tst.hasNext());
		assertActivityNode("Final node 2",tst.next(),"_L8a9YCTREeqH_rjszRWaSw");
		assertEquals("Incorrect depth",2,tst.getDepth());
		
		
		assertTrue("Empty iterator",tst.hasNext());
		assertActivityNode("Action C",tst.next(),"_jPFEMCTUEeqH_rjszRWaSw");
		assertEquals("Incorrect depth",1,tst.getDepth());
		assertTrue("Empty iterator",tst.hasNext());
		assertActivityNode("Final node",tst.next(),"_dy2FACTUEeqH_rjszRWaSw");
		assertEquals("Incorrect depth",1,tst.getDepth());
		System.out.println("End testDepthAwareTreeIterator");
	}

	public void assertActivityNode(String msgPrefix,EObject object,String fragment) {
		assertNotNull(msgPrefix + " is missing",object);
		assertTrue(msgPrefix + " is not an instanceof ActivityNode",object instanceof ActivityNode);
		assertEquals(msgPrefix + " does not have the correct id",fragment,resource.getID(object));
	}

}
