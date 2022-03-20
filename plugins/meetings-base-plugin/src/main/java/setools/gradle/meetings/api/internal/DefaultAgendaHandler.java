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
package setools.gradle.meetings.api.internal;

import javax.inject.Inject;

import org.gradle.api.Project;

import setools.gradle.meetings.api.AgendaHandler;

/**
 * Default implementation of {@link AgendaHandler} for specifying 
 * meeting agendas.
 */
public class DefaultAgendaHandler implements AgendaHandler {

	/**
	 * The {@link Project} for the parent meeting.
	 */
	protected final Project project;

	/**
	 * Default constructor for {@link DefaultAgendaHandler}.
	 * @param project - {@link Project} for resolving information
	 */
	@Inject
	public DefaultAgendaHandler(Project project) {
		this.project = project;
	}

}
