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
package setools.mbpe.util.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.FlowFinalNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.StructuredActivityNode;

import setools.util.AbstractDepthAwareTreeIterator;

/**
 * @author matt
 *
 */
public class ActivityNodesDepthAwareTreeIterator extends AbstractDepthAwareTreeIterator<EObject> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2929341142233192742L;
	/**  Indicates if getChildren should recurse into called methods/behaviors.
	 */
	
	protected boolean followCalls;

	public ActivityNodesDepthAwareTreeIterator(Activity object) {
		super(object,false);
		this.followCalls = true;
	}
	
	public ActivityNodesDepthAwareTreeIterator(Activity object,boolean followCalls) {
		super(object,false);
		this.followCalls = followCalls;
	}

	@Override
	protected Iterator<? extends EObject> getChildren(Object object) {
		List<EObject> results = new ArrayList<EObject>();
		if(object instanceof Activity) {
			getActivityNodes(results,(Activity)object);
		} else if(object instanceof StructuredActivityNode) {
			StructuredActivityNode node = (StructuredActivityNode)object;
			getActivityNodes(results,getInitialNode(node));
		} else if((object instanceof CallBehaviorAction) && followCalls){
			CallBehaviorAction call = (CallBehaviorAction)object;
			Behavior behavior = call.getBehavior();
			//TODO: should we allow ALL types of behaviors?
			if(behavior instanceof Activity) {
				getActivityNodes(results,(Activity)behavior);
			}
		}
		return results.iterator();
	}

	protected void getActivityNodes(List<EObject> results, Activity object) {
		getActivityNodes(results,getInitialNode(object));
	}

	protected void getActivityNodes(List<EObject> results, ActivityNode node) {
		if((node!=null) && (!results.contains(node))) {
			results.add(node);
			if((node instanceof ActivityFinalNode) || (node instanceof FlowFinalNode))
				return; //TODO:do these need to be treated separately?
			for(ActivityEdge edge : node.getOutgoings()) {
				getActivityNodes(results,edge.getTarget());
			}
		}
	}

	protected InitialNode getInitialNode(Activity object) {
		for(ActivityNode node : object.getNodes())
			if(node instanceof InitialNode)
				return (InitialNode)node;
		return null;
	}

	protected InitialNode getInitialNode(StructuredActivityNode object) {
		for(ActivityNode node : object.getContainedNodes())
			if(node instanceof InitialNode)
				return (InitialNode)node;
		return null;
	}
}
