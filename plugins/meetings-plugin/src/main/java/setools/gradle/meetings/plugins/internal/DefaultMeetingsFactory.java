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
package setools.gradle.meetings.plugins.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.internal.metaobject.DynamicInvokeResult;

import setools.gradle.meetings.api.Meeting;
import setools.gradle.meetings.api.MeetingsFactory;
import setools.gradle.meetings.plugins.MeetingsPluginExt;

/**
 * TODO:
 */
public class DefaultMeetingsFactory implements MeetingsFactory,Plugin<Project> {
	
	/**
	 * TODO:
	 */
	protected final ArrayList<Object> handlers =
			new ArrayList<Object>();
	
	/**
	 * TODO:
	 */
	private Project project = null;
	
	@Override
	public void apply(Project project) {
		this.project = project;
		//TODO anything to do here ???
	}

	@Override
	public boolean hasMethod(String name, Object...args) {
		Class<?>[] params = new Class<?>[args.length];
		for(int x=0;x<args.length;x++) {
			params[x] = args[x].getClass();
		}
		
		for(Object handler : handlers) {
			Method method;
			try {
				method = handler.getClass().getMethod(name, params);
				if(Meeting.class.isAssignableFrom(method.getReturnType()))
					return true;
			} catch (NoSuchMethodException | SecurityException e) {
				//ignore expected
			}
		}
		return false;
	}

	@Override
	public DynamicInvokeResult tryInvokeMethod(String name, Object...args) {
		Class<?>[] params = new Class<?>[args.length];
		for(int x=0;x<args.length;x++) {
			params[x] = args[x].getClass();
		}
		
		for(Object handler : handlers) {
			Method method;
			try {
				project.getLogger().lifecycle("Searching {} for method '{}' with {}.",handler,name,params);
				method = handler.getClass().getMethod(name, params);
				project.getLogger().lifecycle("Found {}.",method);
				Object result = method.invoke(handler, args);
				project.getLogger().lifecycle("Result: {}.",result);
				if(result instanceof Meeting) {
					onSuccess((Meeting)result);
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				//ignore expected
				project.getLogger().warn("Error {} while searching for '{}'.",e,name);
			}
		}
		return DynamicInvokeResult.notFound();
	}

	/**
	 * TODO:
	 * @param cast
	 */
	protected void onSuccess(Meeting meeting) {
		getMeetings().add(meeting);
	}

	/**
	 * TODO:
	 * @return
	 */
	protected MeetingsPluginExt getMeetings() {
		return (MeetingsPluginExt)project.getExtensions()
			.getByName(DefaultMeetingsPluginExt.MEETINGS_EXT_NAME);
	}

	@Override
	public void register(Class<?> type) {
		synchronized(handlers) {
			//TODO:better way to detect name space clashes...
			for(Object handler : handlers) {
				if(type.isInstance(handler))
					return; //TODO:throw exception ???
			}
		}
		try {
			Constructor<?> constructor = type.getConstructor();
			Object object = constructor.newInstance();
			handlers.add(object);
		} catch (NoSuchMethodException | SecurityException | InstantiationException |
				IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new IllegalArgumentException(e);
		}
		
	}
}
