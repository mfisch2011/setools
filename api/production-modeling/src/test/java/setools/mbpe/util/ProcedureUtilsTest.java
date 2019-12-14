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
package setools.mbpe.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.uml2.uml.Activity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import setools.uml.ResourceSetInitializerService;
import setools.util.DepthAwareTreeIterator;

/**
 * @author matt
 *
 */
public class ProcedureUtilsTest {

	protected ResourceSet resourceSet = null;
	protected XMIResource resource = null;
	
	@Before
	public void setup() {
		resourceSet = new ResourceSetImpl();
		ResourceSetInitializerService.initialize(resourceSet);
		URI uri = URI.createFileURI("src/test/resources/setools/mbpe/util/test-mbpe-utils.uml");
		resource = (XMIResource)resourceSet.getResource(uri, true);
	}
	
	@After
	public void cleanup() {
		resourceSet = null;
	}
	
	@Test
	public void testSimpleActivityModel() {
		Activity activity = (Activity)resource.getEObject("_Tb9BcB54EeqDIN6nE1xWqg");
		DepthAwareTreeIterator<EObject> iter = ProcedureUtils.getProcedureSteps(activity);
		assertNotNull(iter);
		EObject object = iter.next();
		assertNotNull(object);
		assertEquals("_Zo-kYB54EeqDIN6nE1xWqg",resource.getID(object));
		assertEquals(1,iter.getDepth());
		assertEquals(null,ProcedureUtils.getActionText(object));
		object = iter.next();
		assertNotNull(object);
		assertEquals("_cvm-IB54EeqDIN6nE1xWqg",resource.getID(object));
		assertEquals(1,iter.getDepth());
		assertEquals("Simple test activity step 1.",ProcedureUtils.getActionText(object));
		object = iter.next();
		assertNotNull(object);
		assertEquals("_dr1V0B54EeqDIN6nE1xWqg",resource.getID(object));
		assertEquals(1,iter.getDepth());
		assertEquals("Simple test activity step 2.",ProcedureUtils.getActionText(object));
		object = iter.next();
		assertNotNull(object);
		assertEquals("_eX2HQB54EeqDIN6nE1xWqg",resource.getID(object));
		assertEquals(1,iter.getDepth());
		assertEquals("Simple test activity step 3.",ProcedureUtils.getActionText(object));
		object = iter.next();
		assertNotNull(object);
		assertEquals("_aTT60B54EeqDIN6nE1xWqg",resource.getID(object));
		assertEquals(1,iter.getDepth());
		assertEquals(null,ProcedureUtils.getActionText(object));
	}
	
	@Test
	public void testDecisionActivityModel() {
		Activity activity = (Activity)resource.getEObject("_BsNP8B59EeqDIN6nE1xWqg");
		DepthAwareTreeIterator<EObject> iter = ProcedureUtils.getProcedureSteps(activity);
		assertNotNull(iter);
		EObject object = iter.next();
		assertNotNull(object);
		assertEquals("_GQsu0B59EeqDIN6nE1xWqg",resource.getID(object));
		assertEquals(1,iter.getDepth());
		assertEquals(null,ProcedureUtils.getActionText(object));
		object = iter.next();
		assertNotNull(object);
		assertEquals("_Ha4qAB59EeqDIN6nE1xWqg",resource.getID(object));
		assertEquals(1,iter.getDepth());
		assertEquals("Decision test activity $step.name.",ProcedureUtils.getActionText(object));
		object = iter.next();
		assertNotNull(object);
		assertEquals("_KMbkkB59EeqDIN6nE1xWqg",resource.getID(object));
		assertEquals(1,iter.getDepth());
		assertEquals("If done looping, then goto Step 3.  If not done looping, then goto Step 4.",ProcedureUtils.getActionText(object));
		object = iter.next();
		assertNotNull(object);
		//TODO:how to handle this since edge ordering is not guarenteed?
		assertEquals("_I_78QB59EeqDIN6nE1xWqg",resource.getID(object));
		assertEquals(1,iter.getDepth());
		assertEquals("Decision test activity $step.name.",ProcedureUtils.getActionText(object));
		object = iter.next();
		assertNotNull(object);
		assertEquals("_Gw7HAB59EeqDIN6nE1xWqg",resource.getID(object));
		assertEquals(1,iter.getDepth());
		assertEquals(null,ProcedureUtils.getActionText(object));
		object = iter.next();
		assertNotNull(object);
		//TODO:how to handle this since edge ordering is not guarenteed?
		assertEquals("_T0_aQB59EeqDIN6nE1xWqg",resource.getID(object));
		assertEquals(1,iter.getDepth());
		assertEquals("Decision test activity $step.name.",ProcedureUtils.getActionText(object));
	}
	
	@Test
	public void testLoopActivityModel() {
		Activity activity = (Activity)resource.getEObject("_vDyIAB6XEeqeifCYBsjUOA");
		DepthAwareTreeIterator<EObject> iter = ProcedureUtils.getProcedureSteps(activity);
		assertNotNull(iter);
		EObject object = iter.next();
		assertNotNull(object);
		assertEquals("_1N450B6XEeqeifCYBsjUOA",resource.getID(object));
		assertEquals(1,iter.getDepth());
		assertEquals(null,ProcedureUtils.getActionText(object));
		object = iter.next();
		assertNotNull(object);
		assertEquals("_5HQ_IB6XEeqeifCYBsjUOA",resource.getID(object));
		assertEquals(1,iter.getDepth());
		assertEquals("Step 1.",ProcedureUtils.getActionText(object));
		object = iter.next();
		assertNotNull(object);
		assertEquals("_7sCB8B6XEeqeifCYBsjUOA",resource.getID(object));
		assertEquals(1,iter.getDepth());
		assertEquals("",ProcedureUtils.getActionText(object));
		object = iter.next();
		assertNotNull(object);
		assertEquals("_D6cN0B6YEeqeifCYBsjUOA",resource.getID(object));
		assertEquals(2,iter.getDepth());
		assertEquals(null,ProcedureUtils.getActionText(object));
		object = iter.next();
		assertNotNull(object);
		assertEquals("__zlGIB6XEeqeifCYBsjUOA",resource.getID(object));
		assertEquals(2,iter.getDepth());
		assertEquals("Step 2A.",ProcedureUtils.getActionText(object));
		object = iter.next();
		assertNotNull(object);
		assertEquals("_BC28sB6YEeqeifCYBsjUOA",resource.getID(object));
		assertEquals(2,iter.getDepth());
		assertEquals("Step 2B.",ProcedureUtils.getActionText(object));
		object = iter.next();
		assertNotNull(object);
		assertEquals("_FNFhcB6YEeqeifCYBsjUOA",resource.getID(object));
		assertEquals(2,iter.getDepth());
		assertEquals(null,ProcedureUtils.getActionText(object));
		object = iter.next();
		assertNotNull(object);
		assertEquals("_5wb38B6XEeqeifCYBsjUOA",resource.getID(object));
		assertEquals(1,iter.getDepth());
		assertEquals("Step 3.",ProcedureUtils.getActionText(object));
		object = iter.next();
		assertNotNull(object);
		assertEquals("_15HoIB6XEeqeifCYBsjUOA",resource.getID(object));
		assertEquals(1,iter.getDepth());
		assertEquals(null,ProcedureUtils.getActionText(object));
	}
	
	@Test
	public void testCallBehaviorActivityModel() {
		Activity activity = (Activity)resource.getEObject("_QNDuoB6bEeqeifCYBsjUOA");
		DepthAwareTreeIterator<EObject> iter = ProcedureUtils.getProcedureSteps(activity);
		assertNotNull(iter);
		EObject object = iter.next();
		assertNotNull(object);
		assertEquals("_T9ghcB6bEeqeifCYBsjUOA",resource.getID(object));
		assertEquals(1,iter.getDepth());
		object = iter.next();
		assertNotNull(object);
		assertEquals("_V6LpgB6bEeqeifCYBsjUOA",resource.getID(object));
		assertEquals(1,iter.getDepth());
		object = iter.next();
		assertNotNull(object);
		assertEquals("_ap0ocB6bEeqeifCYBsjUOA",resource.getID(object));
		assertEquals(1,iter.getDepth());
		object = iter.next();
		assertNotNull(object);
		assertEquals("_rXanIB6bEeqeifCYBsjUOA",resource.getID(object));
		assertEquals(2,iter.getDepth());
		object = iter.next();
		assertNotNull(object);
		assertEquals("_tlUCEB6bEeqeifCYBsjUOA",resource.getID(object));
		assertEquals(2,iter.getDepth());
		object = iter.next();
		assertNotNull(object);
		assertEquals("_uLqQYB6bEeqeifCYBsjUOA",resource.getID(object));
		assertEquals(2,iter.getDepth());
		object = iter.next();
		assertNotNull(object);
		assertEquals("_r8BwEB6bEeqeifCYBsjUOA",resource.getID(object));
		assertEquals(2,iter.getDepth());
		object = iter.next();
		assertNotNull(object);
		assertEquals("_WqUF8B6bEeqeifCYBsjUOA",resource.getID(object));
		assertEquals(1,iter.getDepth());
		object = iter.next();
		assertNotNull(object);
		assertEquals("_U5MGkB6bEeqeifCYBsjUOA",resource.getID(object));
		assertEquals(1,iter.getDepth());
	}
	
}
