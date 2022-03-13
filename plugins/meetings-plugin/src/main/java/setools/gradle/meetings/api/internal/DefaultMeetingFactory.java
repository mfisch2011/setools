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

import javax.inject.Inject;

import org.gradle.api.Action;
import org.gradle.api.Project;
import org.gradle.util.internal.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meetings.api.Meeting;

/**
 * TODO:
 */
public class DefaultMeetingFactory {
	
	/**
	 * TODO:
	 */
	protected final Project project;

	/**
	 * TODO:
	 * @param project
	 */
	@Inject
	public DefaultMeetingFactory(Project project) {
		this.project = project;
	}

	/**
	 * Create a new {@link DefaultMeeting} instance.
	 * 
	 * @return - new {@link Meeting} instance
	 */
	public Meeting meeting() {
		return newInstance();
	}
	
	/**
	 * Create a new {@link DefaultMeeting} instance and configure it by 
	 * executing action.
	 * 
	 * @param action - {@link Action} to execute
	 * @return - new {@link Meeting} instance
	 */
	public Meeting meeting(Action<? super Meeting> action) {
		Meeting result = newInstance();
		action.execute(result);
		return result;
	}
	
	/**
	 * Create a new {@link DefaultMeeting} instance and configure 
	 * it with closure.
	 * 
	 * @param closure - {@link Closure} for configuration
	 * @return - new {@link Meeting} instance
	 */
	@SuppressWarnings("rawtypes")
	public Meeting meeting(Closure closure) {
		Meeting result = newInstance();
		ConfigureUtil.configure(closure, result);
		return result;
	}
	
	/**
	 * TODO:
	 * @return
	 */
	protected Meeting newInstance() {
		return project.getObjects().newInstance(DefaultMeeting.class);
	}
}
