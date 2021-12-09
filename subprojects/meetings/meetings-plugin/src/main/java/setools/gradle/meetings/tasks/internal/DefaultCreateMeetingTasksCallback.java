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
package setools.gradle.meetings.tasks.internal;

import org.gradle.api.Action;
import org.gradle.api.Task;

import setools.gradle.meetings.tasks.AbstractCreateMeetingTasksCallback;

/**
 * TODO:
 */
public class DefaultCreateMeetingTasksCallback extends AbstractCreateMeetingTasksCallback {

	@Override
	protected Class<? extends Task> getPublishMinutesType() {
		return DefaultPublishDocument.class;
	}

	@Override
	protected Class<? extends Task> getPublishPresentationType() {
		return DefaultPublishDocument.class;
	}

	@Override
	protected Class<? extends Task> getPublishAgendaType() {
		return DefaultPublishDocument.class;
	}

	@Override
	protected Class<? extends Task> getAssemblePresentationType() {
		return DefaultAssemblePresentation.class;
	}

	@Override
	protected Class<? extends Task> getDraftTopicSlideType() {
		return DefaultGenerateDocument.class; //TODO:does this work with PPTX templates or do we need something special???
	}

	@Override
	protected Class<? extends Task> getDraftAgendaSlideType() {
		return DefaultGenerateDocument.class; //TODO:does this work with PPTX templates or do we need something special???
	}

	@Override
	protected Class<? extends Task> getDraftTitleSlideType() {
		return DefaultGenerateDocument.class; //TODO:does this work with PPTX templates or do we need something special???
	}

	@Override
	protected Class<? extends Task> getDraftMinutesType() {
		return DefaultGenerateDocument.class;
	}
	
	@Override
	protected Class<? extends Task> getDraftAgendaType() {
		return DefaultGenerateDocument.class;
	}

}
