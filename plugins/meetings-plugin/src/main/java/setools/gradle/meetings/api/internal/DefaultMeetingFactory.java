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

import org.gradle.api.Action;
import org.gradle.util.internal.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meetings.api.Meeting;

/**
 * TODO:
 */
public class DefaultMeetingFactory {

	/**
	 * TODO:
	 * @return
	 */
	public Meeting meeting() {
		return new DefaultMeeting();
	}
	
	/**
	 * TODO:
	 * @param action
	 * @return
	 */
	public Meeting meeting(Action<? super Meeting> action) {
		Meeting result = new DefaultMeeting();
		action.execute(result);
		return result;
	}
	
	/**
	 * TODO:
	 * @param closure
	 * @return
	 */
	public Meeting meeting(Closure<?> closure) {
		Meeting result = new DefaultMeeting();
		ConfigureUtil.configure(closure, result);
		return result;
	}
}
