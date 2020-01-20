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
package setools.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.internal.project.ProjectInternal;

/**
 * @author matt
 *
 */
public class MeetingsLifecyclePlugin implements Plugin<ProjectInternal>  {
	
	public static final String AGENDA_TASK = "agenda";
	
	public static final String PRESENTATION_TASK = "presentation";

	public static final String MINUTES_TASK = "minutes";

	@Override
	public void apply(ProjectInternal project) {
		project.getTasks().create(AGENDA_TASK);
		project.getTasks().create(PRESENTATION_TASK);
		project.getTasks().create(MINUTES_TASK);
		//TODO:how to handle publish???
	}
	
}
