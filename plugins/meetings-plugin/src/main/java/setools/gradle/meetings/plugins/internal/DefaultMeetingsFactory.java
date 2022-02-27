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
import org.gradle.api.logging.Logger;
import org.gradle.internal.metaobject.DynamicInvokeResult;

import setools.gradle.meetings.api.MeetingsFactory;

/**
 * TODO:
 */
public class DefaultMeetingsFactory implements MeetingsFactory {

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
	private Logger logger;
	
	
	/**
	 * TODO:
	 */
	public DefaultMeetingsFactory() {
		this.handlers = new ConcurrentHashMap<String,Object>();
	}
	
	@Override
	public void apply(Project project) {
		this.project = project;
		this.logger = project.getLogger();
		//TODO anything to do here ???
	}

	@Override
	public boolean hasMethod(String name, Object...args) {
		logger.debug("Searching for method '{}' with arguments {}.",name,args);
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DynamicInvokeResult tryInvokeMethod(String name, Object...args) {
		logger.debug("Invoking method '{}' with arguments {}.",name,args);
		// TODO Auto-generated method stub
		return null;
	}

}
