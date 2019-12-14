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

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.ValueSpecification;

import setools.mbpe.util.internal.ActivityNodesDepthAwareTreeIterator;
import setools.util.DepthAwareTreeIterator;

/**
 * @author matt
 *
 */
public class ProcedureUtils {
	
	public static DepthAwareTreeIterator<EObject> getProcedureSteps(EObject object) {
		if(object instanceof Activity)
			return new ActivityNodesDepthAwareTreeIterator((Activity)object);
		else {
			System.out.printf("Warning unhandled %s object.%n", object);
			return null;
		}
	}
	
	public static String getActionText(EObject object) {
		if(object instanceof OpaqueAction)
			return getActionText((OpaqueAction)object);
		else if(object instanceof DecisionNode)
			return getActionText((DecisionNode)object);
		else if(object instanceof LoopNode)
			return getActionText((LoopNode)object);
		else
			return null;
	}
	
	protected static String getActionText(LoopNode object) {
		String results = "";
		//TODO:test for while/for loop...
		results = "While ";
		//append test(s)...
		return results;
	}
	
	protected static String getActionText(DecisionNode object) {
		String results = "";
		for(ActivityEdge edge : object.getOutgoings()) {
			results += "If " + toText(edge.getGuard()) + ", then goto " + 
					edge.getTarget().getName() + ".  ";
		}
		return results.strip();
	}

	protected static String getActionText(OpaqueAction object) {
		Iterator<String> iter1 = object.getLanguages().iterator();
		Iterator<String> iter2 = object.getBodies().iterator();
		while(iter1.hasNext() && iter2.hasNext()) {
			String language = iter1.next();
			String body = iter2.next();
			if(language.equals("Natural language"))
				return body;
			else if(language.equals("Velocity"))
				return velocityMerge(object,body);
		}
		return null;
	}
	
	protected static String toText(ValueSpecification guard) {
		return guard.stringValue();
	}
	
	protected static String velocityMerge(ActivityNode node,String text) {
		//TODO:velocity merge node with text
		return text;
	}
}
