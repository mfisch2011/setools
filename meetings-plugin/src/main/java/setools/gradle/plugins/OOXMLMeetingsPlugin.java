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
package setools.gradle.plugins;

import org.gradle.api.Project;
import org.gradle.api.Task;

import setools.gradle.tasks.OOXMLAssemblePresentation;
import setools.gradle.tasks.OOXMLDraftAgenda;
import setools.gradle.tasks.OOXMLDraftMinutes;
import setools.gradle.tasks.OOXMLDraftPresentation;

/**
 * @author matt
 *
 */
public class OOXMLMeetingsPlugin extends AbstractMeetingsPlugin {

	public OOXMLMeetingsPlugin() {
		super(OOXMLDraftAgenda.class,OOXMLDraftMinutes.class,OOXMLDraftPresentation.class, OOXMLAssemblePresentation.class,null,null);
	}

	@Override
	protected Task configureAssemblePresentation(Project project) {
		Task task = super.configureAssemblePresentation(project);
		task.setDescription("Assembles slides into the final pptx presentation.");
		return task;
	}

	@Override
	protected Task configureDraftPresentation(Project project) {
		Task task = super.configureDraftPresentation(project);
		task.setDescription("Generates draft pptx slides from the meeting agenda.");
		return task;
	}

	@Override
	protected Task configureDraftMinutes(Project project) {
		Task task = super.configureDraftMinutes(project);
		task.setDescription("Generates draft docx minutes from the meeting agenda.");
		return task;
	}

	@Override
	protected Task configureDraftAgenda(Project project) {
		Task task = super.configureDraftAgenda(project);
		task.setDescription("Generates draft docx agenda from the meeting agenda.");
		return task;
	}
}
