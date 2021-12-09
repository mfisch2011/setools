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

import setools.gradle.meetings.tasks.AbstractCreateMeetingTasksCallback;
import setools.gradle.meetings.tasks.AssemblePresentation;
import setools.gradle.meetings.tasks.GenerateDocument;
import setools.gradle.meetings.tasks.GenerateSlide;
import setools.gradle.meetings.tasks.PublishDocument;

/**
 * TODO:
 */
public class DefaultCreateMeetingTasksCallback extends AbstractCreateMeetingTasksCallback {

	@Override
	protected Class<? extends PublishDocument> getPublishMinutesType() {
		return DefaultPublishDocument.class;
	}

	@Override
	protected Class<? extends PublishDocument> getPublishPresentationType() {
		return DefaultPublishDocument.class;
	}

	@Override
	protected Class<? extends PublishDocument> getPublishAgendaType() {
		return DefaultPublishDocument.class;
	}

	@Override
	protected Class<? extends AssemblePresentation> getAssemblePresentationType() {
		return DefaultAssemblePresentation.class;
	}

	@Override
	protected Class<? extends GenerateSlide> getDraftTopicSlideType() {
		return DefaultGenerateSlide.class;
	}

	@Override
	protected Class<? extends GenerateSlide> getDraftAgendaSlideType() {
		return DefaultGenerateSlide.class;
	}

	@Override
	protected Class<? extends GenerateSlide> getDraftTitleSlideType() {
		return DefaultGenerateSlide.class;
	}

	@Override
	protected Class<? extends GenerateDocument> getDraftMinutesType() {
		return DefaultGenerateDocument.class;
	}
	
	@Override
	protected Class<? extends GenerateDocument> getDraftAgendaType() {
		return DefaultGenerateDocument.class;
	}

}
