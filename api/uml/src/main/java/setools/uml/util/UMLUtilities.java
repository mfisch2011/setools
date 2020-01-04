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


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;

/**
 * @author matt
 *
 */
public class UMLUtilities {

	public static DepthAwareTreeIterator<EObject> getSteps(EObject object) {
		if(object instanceof Activity) {
			return new BehaviorDepthAwareTreeIterator(object);
		}
		else
			return null;	
	}
	
	
	protected static class BehaviorDepthAwareTreeIterator extends
		AbstractDepthAwareTreeIterator<EObject> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 7595271075839290342L;

		public BehaviorDepthAwareTreeIterator(EObject object) {
			super(object);
		}
		
		public BehaviorDepthAwareTreeIterator(EObject object,boolean includeRoot) {
			super(object,includeRoot);
		}

		@Override
		protected Iterator<? extends EObject> getChildren(Object object) {
			if(object instanceof Activity) {
				List<EObject> result = new ArrayList<EObject>();
				addActionsToList(result,getInitialNode((Activity)object));
				return result.iterator();
			} else if(object instanceof CallBehaviorAction) {
				List<EObject> result = new ArrayList<EObject>();
				CallBehaviorAction action = (CallBehaviorAction)object;
				Behavior behavior = action.getBehavior();
				if(behavior instanceof Activity)
					addActionsToList(result,getInitialNode((Activity)behavior));
				else if(behavior instanceof StateMachine)
					addActionsToList(result,getInitialNode((StateMachine)behavior));
				return result.iterator();
			} else {
				List<EObject> nullList = new ArrayList<EObject>();
				return nullList.iterator();
			}
		}
	}
	
	public static void addActionsToList(List<EObject> result,ActivityNode node) {
		if(!result.contains(node)) {
			result.add(node);
			for(ActivityEdge edge : node.getOutgoings()) {
				addActionsToList(result,edge.getTarget());
			}
		}
	}
	
	public static void addActionsToList(List<EObject> result,Vertex state) {
		if(!result.contains(state)) {
			result.add(state);
			for(Transition transition : state.getOutgoings()) {
				addActionsToList(result,transition.getTarget());
			}
		}
	}
	
	//TODO:is there an InitialState???
	public static State getInitialNode(StateMachine object) {
		//TODO:
		for(Region region : object.getRegions()) {
			System.out.println(region);
			System.out.println(region.getState());
		}
		return null;
	}
	
	public static InitialNode getInitialNode(Activity object) {
		for(ActivityNode node : object.getNodes())
			if(node instanceof InitialNode)
				return (InitialNode)node;
		return null;
	}
}
