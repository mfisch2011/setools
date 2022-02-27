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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.gradle.api.Project;

import setools.gradle.meetings.api.Meeting;
import setools.gradle.meetings.api.MeetingsFactory;
import setools.gradle.meetings.plugins.MeetingsPluginExt;
import setools.gradle.util.ReflectiveMethodAccess;

/**
 * TODO:
 */
public class DefaultMeetingsFactory extends ReflectiveMethodAccess implements MeetingsFactory {

	/**
	 * TODO:
	 */
	protected final Map<String,Object> handlers;
	
	/**
	 * TODO:
	 */
	private Project project = null;
	
	/**
	 * TODO:
	 */
	public DefaultMeetingsFactory() {
		this.handlers = new ConcurrentHashMap<String,Object>();
	}
	
	@Override
	public void apply(Project project) {
		this.project = project;
		//TODO anything to do here ???
	}

	@Override
	protected Object getHandler(String name) {
		return handlers.get(name);
	}

	@Override
	protected void onSuccess(Object result) throws IllegalArgumentException {
		//TODO: there must be a better way ???
		if(project!=null) {
			if(result instanceof Meeting) {
				MeetingsPluginExt meetings = project.getExtensions()
						.getByType(MeetingsPluginExt.class);
				meetings.add((Meeting)result);
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			throw new IllegalStateException();
		}
	}

	@Override
	public Object registerHandler(String name, Object factory) {
		return handlers.put(name, factory);
	}

}
