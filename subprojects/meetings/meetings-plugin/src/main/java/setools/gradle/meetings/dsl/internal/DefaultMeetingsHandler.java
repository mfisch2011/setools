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
package setools.gradle.meetings.dsl.internal;

import java.util.function.Function;

import javax.inject.Inject;

import org.gradle.api.Project;
import org.gradle.internal.metaobject.MethodAccess;
import org.gradle.internal.metaobject.MethodMixIn;

import setools.gradle.meetings.dsl.Meeting;
import setools.gradle.meetings.dsl.MeetingsHandler;
import setools.gradle.meetings.plugins.MeetingsFactoryServicePlugin;
import setools.gradle.util.AbstractHandler;

/**
 * TODO:
 */
public class DefaultMeetingsHandler extends AbstractHandler<Meeting> implements MeetingsHandler,MethodMixIn {
	
	/**
	 * TODO:
	 */
	protected final MethodAccess methodAccess;
	
	/**
	 * TODO:
	 */
	protected final Project project;

	/**
	 * TODO: add documentation...
	 * @param project - {@link Project} that owns the handler
	 */
	@Inject
	public DefaultMeetingsHandler(Project project) {
		this.project = project;
		MeetingsFactoryServicePlugin factories = project.getPlugins().getAt(MeetingsFactoryServicePlugin.class);
		this.methodAccess = new WrappedFactoryMethodAccess<Meeting>(factories,this);
		
		//configure default agenda template and naming
		setDefaultAgendaTemplate(getClass().getResource("agenda-template.docx"));
		setDefaultAgendaFilenameTransform(meeting -> {
			return meeting.getDate() + "-" + meeting.getName() + "-agenda.docx";
		});
		
		//configure default minutes template and naming
		setDefaultMinutesTemplate(getClass().getResource("minutes-template.docx"));
		setDefaultMinutesFilenameTransform(meeting -> {
			return meeting.getDate() + "-" + meeting.getName() + "-minutes.docx";
		});
		
		//configure default presentation template and naming
		setDefaultPresentationTemplate(getClass().getResource("presentation-template.pptx"));
		setDefaultPresentationFilenameTransform(meeting -> {
			return meeting.getDate() + "-" + meeting.getName() + ".pptx";
		});
	}

	@Override
	public MethodAccess getAdditionalMethods() {
		return methodAccess;
	}
	
	/**
	 * TODO:
	 */
	protected Object defaultAgendaTemplate = null;

	/**
	 * TODO:
	 */
	protected Function<Meeting, String> agendaFilenameTransform;

	@Override
	public Object getDefaultAgendaTemplate() {
		return defaultAgendaTemplate;
	}

	@Override
	public void setDefaultAgendaTemplate(Object object) {
		defaultAgendaTemplate = project.uri(object);
		//TODO:catch exception and try project.file ???
	}

	@Override
	public String getDefaultAgendaFilename(Meeting meeting) {
		return agendaFilenameTransform.apply(meeting);
	}

	@Override
	public void setDefaultAgendaFilenameTransform(Function<Meeting,String> transform) {
		//TODO:validate transform ???
		agendaFilenameTransform = transform;
	}
	
	/**
	 * TODO:
	 */
	protected Object defaultPresentationTemplate = null;

	/**
	 * TODO:
	 */
	protected Function<Meeting, String> presentationFilenameTransform;

	@Override
	public Object getDefaultPresentationTemplate() {
		return defaultPresentationTemplate;
	}

	@Override
	public void setDefaultPresentationTemplate(Object object) {
		defaultPresentationTemplate = project.uri(object);
		//TODO:catch exception and try project.file ???
	}

	@Override
	public String getDefaultPresentationFilename(Meeting meeting) {
		return presentationFilenameTransform.apply(meeting);
	}

	@Override
	public void setDefaultPresentationFilenameTransform(Function<Meeting,String> transform) {
		//TODO:validate transform ???
		presentationFilenameTransform = transform;
	}
	
	/**
	 * TODO:
	 */
	protected Object defaultMinutesTemplate = null;

	/**
	 * TODO:
	 */
	protected Function<Meeting, String> minutesFilenameTransform;

	@Override
	public Object getDefaultMinutesTemplate() {
		return defaultMinutesTemplate;
	}

	@Override
	public void setDefaultMinutesTemplate(Object object) {
		defaultMinutesTemplate = project.uri(object);
		//TODO:catch exception and try project.file ???
	}

	@Override
	public String getDefaultMinutesFilename(Meeting meeting) {
		return minutesFilenameTransform.apply(meeting);
	}

	@Override
	public void setDefaultMinutesFilenameTransform(Function<Meeting,String> transform) {
		//TODO:validate transform ???
		minutesFilenameTransform = transform;
	}
}
