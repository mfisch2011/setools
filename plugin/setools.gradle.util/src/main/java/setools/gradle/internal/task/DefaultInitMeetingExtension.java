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
package setools.gradle.internal.task;

import javax.inject.Inject;

import org.gradle.api.Project;

import setools.gradle.task.InitMeetingExtension;

/**
 * @author matt
 *
 */
public class DefaultInitMeetingExtension implements InitMeetingExtension {

	protected final Project project;

	@Inject
	public DefaultInitMeetingExtension(Project project) {
		this.project = project;
	}
}
