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

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;

import setools.gradle.plugins.internal.DefaultMeetingsPluginExtension;
import setools.gradle.tasks.AbstractAssemblePresentation;
import setools.gradle.tasks.AbstractDraftAgenda;
import setools.gradle.tasks.AbstractDraftMinutes;
import setools.gradle.tasks.AbstractDraftPresentation;
import setools.gradle.tasks.AbstractPublishMinutes;
import setools.gradle.tasks.AbstractPublishPresentation;

/**
 * @author matt
 *
 */
public class AbstractMeetingsPlugin implements Plugin<Project> {
	
	public static final String PLUGIN_EXT = "meeting";
	
	public static final String GROUP_NAME = "Meeting Tasks";
	
	public static final String DRAFT_AGENDA = "draftAgenda";
	
	public static final String DRAFT_MINUTES = "draftMinutes";
	
	public static final String DRAFT_PRESENTATION = "draftPresentation";
	
	public static final String ASSEMBLE_PRESENTATION = "assemblePresentation";
	
	public static final String PUBLISH_PRESENTATION = "publishPresentation";
	
	public static final String PUBLISH_MINUTES = "publishMinutes";
	
	protected final Class<? extends AbstractDraftAgenda> draftAgendaType;
	
	protected final Class<? extends AbstractDraftMinutes> draftMinutesType;
	
	protected final Class<? extends AbstractDraftPresentation> draftPresentationType;
	
	protected final Class<? extends AbstractAssemblePresentation> assemblePresentationType;
	
	protected final Class<? extends AbstractPublishPresentation> publishPresentationType;
	
	protected final Class<? extends AbstractPublishMinutes> publishMinutesType;

	protected Task draftAgenda = null;
	
	protected Task draftMinutes = null;
	
	protected Task draftPresentation = null;
	
	protected Task assemblePresentation = null;
	
	protected Task publishPresentation = null;
	
	protected Task publishMinutes = null;
	
	protected MeetingsPluginExtension extension = null;

	public AbstractMeetingsPlugin(
			Class<? extends AbstractDraftAgenda> draftAgenda,
			Class<? extends AbstractDraftMinutes> draftMinutes,
			Class<? extends AbstractDraftPresentation> draftPresentation,
			Class<? extends AbstractAssemblePresentation> assemblePresentation,
			Class<? extends AbstractPublishPresentation> publishPresentation,
			Class<? extends AbstractPublishMinutes> publishMinutes) {
		this.draftAgendaType = draftAgenda;
		this.draftMinutesType = draftMinutes;
		this.draftPresentationType = draftPresentation;
		this.assemblePresentationType = assemblePresentation;
		this.publishPresentationType = publishPresentation;
		this.publishMinutesType = publishMinutes;
	}

	@Override
	public void apply(Project project) {
		configureSettings(project);
		applyPlugins(project);
		extension = configureExtension(project);
		configureTasks(project);
	}

	protected void configureSettings(Project project) {
		project.setBuildDir(project.getProjectDir());
	}

	protected void configureTasks(Project project) {
		draftAgenda = configureDraftAgenda(project);
		draftAgenda.setGroup(GROUP_NAME);
		draftMinutes = configureDraftMinutes(project);
		draftMinutes.setGroup(GROUP_NAME);
		draftMinutes.getDependsOn().add(draftAgenda);
		draftPresentation = configureDraftPresentation(project);
		draftPresentation.setGroup(GROUP_NAME);
		draftPresentation.getDependsOn().add(draftAgenda);
		assemblePresentation = configureAssemblePresentation(project);
		assemblePresentation.setGroup(GROUP_NAME);
		assemblePresentation.getDependsOn().add(draftPresentation);
		publishPresentation = configurePublishPresentation(project);
		publishPresentation.setGroup(GROUP_NAME);
		publishPresentation.getDependsOn().add(assemblePresentation);
		publishMinutes = configurePublishMinutes(project);
		publishMinutes.setGroup(GROUP_NAME);
		publishMinutes.getDependsOn().add(publishPresentation);
	}

	protected Task configurePublishMinutes(Project project) {
		Task result = (publishMinutesType!=null) ?
				project.getTasks().create(PUBLISH_MINUTES,publishMinutesType) :
				project.getTasks().create(PUBLISH_MINUTES);
		result.setDescription("Generic meeting publishMinutes lifecycle phase.");
		return result;
	}

	protected Task configurePublishPresentation(Project project) {
		Task result = (publishPresentationType!=null) ?
				project.getTasks().create(PUBLISH_PRESENTATION,publishPresentationType) :
				project.getTasks().create(PUBLISH_PRESENTATION);
		result.setDescription("Generic meeting publishPresentation lifecycle phase.");
		return result;
	}

	protected Task configureAssemblePresentation(Project project) {
		Task result = (assemblePresentationType!=null) ?
				project.getTasks().create(ASSEMBLE_PRESENTATION,assemblePresentationType) :
				project.getTasks().create(ASSEMBLE_PRESENTATION);
		result.setDescription("Generic meeting assemblePresentation lifecycle phase.");
		return result;
	}

	protected Task configureDraftPresentation(Project project) {
		Task result = (draftPresentationType!=null) ?
				project.getTasks().create(DRAFT_PRESENTATION,draftPresentationType) :
				project.getTasks().create(DRAFT_PRESENTATION);
		result.setDescription("Generic meeting draftPresentation lifecycle phase.");
		return result;
	}

	protected Task configureDraftMinutes(Project project) {
		Task result = (draftMinutesType!=null) ?
				project.getTasks().create(DRAFT_MINUTES,draftMinutesType) :
				project.getTasks().create(DRAFT_MINUTES);
		result.setDescription("Generic meeting draftMinutes lifecycle phase.");
		return result;
	}

	protected Task configureDraftAgenda(Project project) {
		Task result = (draftAgendaType!=null) ?
				project.getTasks().create(DRAFT_AGENDA,draftAgendaType) :
				project.getTasks().create(DRAFT_AGENDA);
		result.setDescription("Generic meeting draftAgenda lifecycle phase.");
		return result;
	}

	protected MeetingsPluginExtension configureExtension(Project project) {
		return project.getExtensions().create(PLUGIN_EXT, DefaultMeetingsPluginExtension.class,project);
	}

	protected void applyPlugins(Project project) {
		//stub for children...
	}

}
