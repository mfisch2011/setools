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

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;

/**
 * TODO:
 */
public class UMLUtils {

	public static final Map<?,?> NULL_MAP = new HashMap<Object,Object>();
	
	/**
	 * TODO:
	 * @param <T>
	 * @param resource
	 * @param id
	 * @param type
	 * @return
	 */
	public static <T> T getObject(Resource resource,String id,Class<T> type) {
		Object object = resource.getEObject(id);
		if(type.isInstance(object))
			return type.cast(object);
		else
			return null;
	}
	
	/**
	 * TODO:
	 * @param <T>
	 * @param resource
	 * @param type
	 * @return
	 */
	public static <T> Collection<T> getAllObjects(Resource resource,Class<T> type) {
		Set<T> results = new HashSet<T>();
		TreeIterator<EObject> iter = resource.getAllContents();
		while(iter.hasNext()) {
			EObject object = iter.next();
			if(type.isInstance(object))
				results.add(type.cast(object));
		}
		return results;
	}

	public static Collection<Comment> getAppliedComments(Element element) {
		Set<Comment> comments = new HashSet<Comment>();
		for(Comment comment : getAllObjects(element.eResource(),Comment.class)) {
			if(comment.getAnnotatedElements().contains(element)) {
				comments.add(comment);
			}
		}
		return comments;
	}

	public static <T extends EObject> T getStereotypeApplication(Element element, Class<T> type) {
		return org.eclipse.uml2.uml.util.UMLUtil.getStereotypeApplication(element, type); 
	}
}
