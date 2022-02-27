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
package setools.gradle.meetings.tasks.internal;

import org.gradle.api.file.SourceDirectorySet;
import org.gradle.api.model.ObjectFactory;
import setools.gradle.meetings.tasks.MeetingSourceDirectorySet;

/**
 * TODO:
 */
public class DefaultMeetingSourceDirectorySet implements MeetingSourceDirectorySet {
	
	private SourceDirectorySet agenda;
	private SourceDirectorySet minutes;
	private SourceDirectorySet presentation;
	private SourceDirectorySet allSource;

	public DefaultMeetingSourceDirectorySet(String name,ObjectFactory objectFactory) {
		//configure the base meeting sources
		this.allSource = objectFactory.sourceDirectorySet(name, name + " source files");
		
		//configure the agenda sources
		this.agenda = objectFactory.sourceDirectorySet(name, name + " agenda files");
		agenda.source(allSource);
		agenda.getFilter().include("**/*.docx");
		//TODO:what other agenda file formats to include ???
		
		//configure the minutes sources
		this.minutes = objectFactory.sourceDirectorySet(name, name + " minutes files");
		minutes.getFilter().include("**/*.docx");
		//TODO:what other minute file formats to include ???
		
		//configure the presentation sources
		this.presentation = objectFactory.sourceDirectorySet(name, name + " presentation files");
		presentation.getFilter().include("**/*.pptx");
		//TODO:what other presentation file formats to include ???
	}

	@Override
	public SourceDirectorySet getAgenda() {
		return agenda;
	}

	@Override
	public SourceDirectorySet getMinutes() {
		return minutes;
	}

	@Override
	public SourceDirectorySet getPresentation() {
		return presentation;
	}

	@Override
	public SourceDirectorySet getAllSources() {
		return allSource;
	}

}
