/**
 * Copyright 2021 M. Fischer <mfisch2011@gmail.com>
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
package setools.gradle.meetings.dsl;

import java.util.Collection;

import org.gradle.api.Action;

import groovy.lang.Closure;

/**
 * TODO:documentation...
 */
public interface AttendeesHandler extends Collection<Attendee> {

	/**
	 * TODO:documentation...
	 * @return
	 */
	public Attendee attendee();
	
	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Attendee attendee(Closure closure);
	
	/**
	 * TODO:documentation...
	 * @param action
	 * @return
	 */
	public Attendee attendee(Action<? extends Attendee> action);
	
}
