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
package setools.gradle.meetings.tasks;

import org.gradle.api.Action;
import org.gradle.api.Task;

import setools.gradle.meetings.tasks.internal.CreateMeetingTasksCallback;

/**
 * TODO:
 */
public class DefaultCreateMeetingTasksCallback extends CreateMeetingTasksCallback {

	@Override
	protected Action<Task> getConfigurePublishMinutes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<? extends Task> getPublishMinutesType() {
		return PublishDocument.class;
	}

	@Override
	protected Action<Task> getConfigurePublishPresentation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<? extends Task> getPublishPresentationType() {
		return PublishDocument.class;
	}

	@Override
	protected Action<Task> getConfigurePublishAgenda() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<? extends Task> getPublishAgendaType() {
		return PublishDocument.class;
	}

	@Override
	protected Action<Task> getConfigureAssemblePresentation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<? extends Task> getAssemblePresentationType() {
		return AssemblePresentation.class;
	}

	@Override
	protected Action<Task> getConfigureDraftTopicSlide() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<? extends Task> getDraftTopicSlideType() {
		return GenerateDocument.class; //TODO:does this work with PPTX templates or do we need something special???
	}

	@Override
	protected Action<Task> getConfigureDraftAgendaSlide() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<? extends Task> getDraftAgendaSlideType() {
		return GenerateDocument.class; //TODO:does this work with PPTX templates or do we need something special???
	}

	@Override
	protected Action<Task> getConfigureDraftTitleSlide() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<? extends Task> getDraftTitleSlideType() {
		return GenerateDocument.class; //TODO:does this work with PPTX templates or do we need something special???
	}

	@Override
	protected Action<Task> getConfigureDraftMinutes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<? extends Task> getDraftMinutesType() {
		return GenerateDocument.class;
	}

	@Override
	protected Action<Task> getConfigureDraftAgenda() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<? extends Task> getDraftAgendaType() {
		return GenerateDocument.class;
	}

}
