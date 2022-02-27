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
package setools.gradle.meetings.api;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.internal.metaobject.MethodAccess;

/**
 * TODO:
 */
public interface MeetingsFactory extends MethodAccess,Plugin<Project> {

	/**
	 * Register factory as a factory handler with name.
	 * 
	 * @param name - {@link String} containing the name to register
	 * @param factory - {@link Object} to register as a factory handler
	 * @return - {@link Object} that was the previously registered handler
	 */
	public Object registerHandler(String name,Object factory);

}
