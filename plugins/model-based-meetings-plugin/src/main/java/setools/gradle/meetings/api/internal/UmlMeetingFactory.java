/**
 * Copyright 2022 M. Fischer <mfisch2011@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package setools.gradle.meetings.api.internal;

import java.io.File;
import java.net.URI;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gradle.api.Action;
import org.gradle.util.internal.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meetings.api.Meeting;

/**
 * TODO:
 */
public class UmlMeetingFactory {
	
	/**
	 * Create a new {@link DefaultMeeting} instance from a model element.
	 * 
	 * @param file - {@link File} for the model element
	 * @param id - {@link String} with element id
	 * @return - new {@link Meeting} instance
	 */
	public Meeting meeting(File file,String id) {
		ResourceSet resourceSet = new ResourceSetImpl();
		org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util
				.URI.createFileURI(file.getAbsolutePath());
		Resource resource = resourceSet.getResource(uri,true);
		EObject eObject = resource.getEObject(id);
		if(eObject instanceof Meeting) {
			return (Meeting)eObject;
		}
		throw new IllegalArgumentException();
	}
	
	/**
	 * Create a new {@link DefaultMeeting} instance from a model element 
	 * and execute a configuration action.
	 * 
	 * @param file - {@link File} for the model element
	 * @param id - {@link String} with element id
	 * @param action - {@link Action} for configuration
	 * @return - new {@link Meeting} instance
	 */
	public Meeting meeting(File file,String id,Action<? super Meeting> action) {
		Meeting result = meeting(file,id);
		action.execute(result);
		return result;
	}
	
	/**
	 * Create a new {@link DefaultMeeting} instance from a model element 
	 * and Closure for configuration.
	 * 
	 * @param file - {@link File} for the model element
	 * @param id - {@link String} with element id
	 * @param closure - {@link Closure} for configuration
	 * @return - new {@link Meeting} instance
	 */
	@SuppressWarnings("rawtypes")
	public Meeting meeting(File file,String id,Closure closure) {
		Meeting result = meeting(file,id);
		ConfigureUtil.configure(closure, result);
		return result;
	}

	/**
	 * Create a new {@link DefaultMeeting} instance from a model element.
	 * 
	 * @param uri - {@link URI} for the model element
	 * @return - new {@link Meeting} instance
	 */
	public Meeting meeting(URI uri) {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(toUri(uri.toASCIIString()),true);
		String id = uri.getFragment();
		if(!isNullOrEmpty(id)) {
			EObject eObject = resource.getEObject(id);
			if(eObject instanceof Meeting) {
				return (Meeting)eObject;
			}
		}
		throw new IllegalArgumentException();
	}
	
	/**
	 * Create a new {@link DefaultMeeting} instance from a model element and 
	 * execute a configuration action.
	 * 
	 * @param uri - {@link URI} for the model element
	 * @param action - {@link Action} for configuration
	 * @return - new {@link Meeting} instance
	 */
	public Meeting meeting(URI uri,Action<? super Meeting> action) {
		Meeting result = meeting(uri);
		action.execute(result);
		return result;
	}
	
	/**
	 * Create a new {@link DefaultMeeting} instance from a model element and 
	 * configure it using closure.
	 * 
	 * @param uri - {@link URI} for the model element
	 * @param closure - {@link Closure} for configuration
	 * @return - new {@link Meeting} instance
	 */
	@SuppressWarnings("rawtypes")
	public Meeting meeting(URI uri,Closure closure) {
		Meeting result = meeting(uri);
		ConfigureUtil.configure(closure, result);
		return result;
	}
	
	/**
	 * Test if text is null or empty.
	 * 
	 * @param text - {@link String} to test
	 * @return - true if null or empty
	 */
	protected static boolean isNullOrEmpty(String text) {
		return text==null || text.isEmpty();
	}
	
	/**
	 * TODO:
	 * @param asciiString
	 * @return
	 */
	protected org.eclipse.emf.common.util.URI toUri(String uri) {
		return org.eclipse.emf.common.util.URI.createURI(uri);
	}
	
}
