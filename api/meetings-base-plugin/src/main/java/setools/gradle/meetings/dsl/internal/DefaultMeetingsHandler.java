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

import java.io.File;
import java.nio.file.Path;

import org.gradle.api.Action;
import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meetings.dsl.Meeting;
import setools.gradle.meetings.dsl.MeetingsHandler;
import setools.gradle.meetings.dsl.WorkingGroup;

/**
 * TODO:documentation...
 */
public class DefaultMeetingsHandler extends AbstractHandler<Meeting> implements
MeetingsHandler {

	/**
	 * TODO:documentation...
	 */
	private String agendaTemplate = null;
	
	@Override
	public String getAgendaTemplate() {
		return agendaTemplate;
	}

	@Override
	public void setAgendaTemplate(Object object) {
		//TODO:better way? look at project.file(object)
		if(object instanceof String)
			agendaTemplate = (String)object;
		else if(object instanceof Path)
			agendaTemplate = ((Path)object).toString();
		else if(object instanceof File)
			agendaTemplate = ((File)object).getAbsolutePath();
		//TODO:what else?
	}
	
	/**
	 * TODO:documentation...
	 */
	private String minutesTemplate = null;

	@Override
	public String getMinutesTemplate() {
		return minutesTemplate;
	}

	@Override
	public void setMinutesTemplate(Object object) {
		//TODO:better way? look at project.file(object)
		if(object instanceof String)
			minutesTemplate = (String)object;
		else if(object instanceof Path)
			minutesTemplate = ((Path)object).toString();
		else if(object instanceof File)
			minutesTemplate = ((File)object).getAbsolutePath();
		//TODO:what else?
	}
	
	/**
	 * TODO:documentation...
	 */
	private String presentationTemplate = null;

	@Override
	public String getPresentationTemplate() {
		return presentationTemplate;
	}

	@Override
	public void setPresentationTemplate(Object object) {
		//TODO:better way? look at project.file(object)
		if(object instanceof String)
			presentationTemplate = (String)object;
		else if(object instanceof Path)
			presentationTemplate = ((Path)object).toString();
		else if(object instanceof File)
			presentationTemplate = ((File)object).getAbsolutePath();
		//TODO:what else?
	}
	
	/**
	 * TODO:documentation...
	 */
	private String actionItemDatabase = null;

	@Override
	public String getActionItemDatabase() {
		return actionItemDatabase;
	}

	@Override
	public void setActionItemDatabase(String connection) {
		//TODO:validate connection?
		actionItemDatabase = connection;
	}

	@Override
	public Meeting meeting() {
		Meeting meeting = new DefaultMeeting();
		add(meeting);
		return meeting;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Meeting meeting(Closure closure) {
		Meeting meeting = new DefaultMeeting();
		ConfigureUtil.configure(closure, meeting);
		add(meeting);
		return meeting;
	}

	@Override
	public Meeting meeting(Action<? super Meeting> action) {
		Meeting meeting = new DefaultMeeting();
		action.execute(meeting);
		add(meeting);
		return meeting;
	}

	@Override
	public WorkingGroup workingGroup() {
		WorkingGroup meeting = new DefaultWorkingGroup();
		add(meeting);
		return meeting;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public WorkingGroup workingGroup(Closure closure) {
		WorkingGroup meeting = new DefaultWorkingGroup();
		ConfigureUtil.configure(closure, meeting);
		add(meeting);
		return meeting;
	}

	@Override
	public WorkingGroup workingGroup(Action<? super WorkingGroup> action) {
		WorkingGroup meeting = new DefaultWorkingGroup();
		action.execute(meeting);
		add(meeting);
		return meeting;
	}

}
