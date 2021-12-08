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
import org.gradle.api.Project;
import org.gradle.api.Task;

import setools.gradle.meetings.dsl.Meeting;
import setools.gradle.meetings.dsl.MeetingsHandler;
import setools.gradle.meetings.dsl.Topic;

import org.apache.commons.text.CaseUtils;

/**
 * TODO:
 */
public abstract class CreateMeetingTasksCallback implements Action<Project> {

	@Override
	public void execute(Project project) {
		MeetingsHandler meetings = getMeetings(project);
		for(Meeting meeting : meetings) {
			createTasksFor(project,meetings,meeting);
		}
	}

	/**
	 * TODO:
	 * @param project - {@link Project} to add task to
	 * @param meetings - {@link MeetingsHandler} with default settings
	 * @param meeting - {@link Meeting} to create task for
	 */
	protected void createTasksFor(Project project, MeetingsHandler meetings, Meeting meeting) {
		Task draftAgenda = createDraftAgendaTask(project,meetings,meeting);
		Task draftMinutes = createDraftMinutesTask(project,meetings,meeting,draftAgenda);
		Task draftSlides = createDraftSlideTasks(project,meetings,meeting,draftAgenda);
		Task assembleSlides = createAssembleSlidesTask(project,meetings,meeting,draftSlides);
		Task publishAgenda = createPublishAgendaTask(project,meetings,meeting,assembleSlides);
		Task publishPresentation = createPublishPresentationTask(project,meetings,meeting,assembleSlides);
		Task publishMinutes = createPublishMinutesTask(project,meetings,meeting,draftMinutes,publishPresentation);
		createMilestoneTask(project,meetings,meeting,publishAgenda,publishPresentation,publishMinutes);
	}

	/**
	 * TODO: add documentation...
	 * @param project - {@link Project} to add task to
	 * @param meetings - {@link MeetingsHandler} with default settings
	 * @param meeting - {@link Meeting} to create task for
	 * @param dependencies - {@link Object} task depends on
	 * @return - {@link Task} added
	 */
	protected Task createPublishMinutesTask(Project project, MeetingsHandler meetings, Meeting meeting,Object...dependencies) {
		//create task
		String name = CaseUtils.toCamelCase("Publish " + meeting.getName() + " Minutes",false);
		String description = "Publish the minutes for the %s.";
		Class<? extends Task> type = getPublishMinutesType();
		Task task = (type==null) ? createTask(project,meeting,name,description,dependencies) :
			createTask(project,type,meeting,name,description,dependencies);
		
		//configure task
		Action<Task> action = getConfigurePublishMinutes();
		if(action!=null) { //TODO:test parameter type against type...
			action.execute(task);
		}
		return task;
	}

	
	/**
	 * TODO:
	 * @return - {@link Action} to configure slide generation task or 
	 * null if no special configuration
	 */
	protected abstract Action<Task> getConfigurePublishMinutes();

	/**
	 * TODO:
	 * @return - {@link Class} with the type of the presentation assembly task or null if a simple placeholder/milestone
	 */
	protected abstract Class<? extends Task> getPublishMinutesType();

	/**
	 * TODO: add documentation...
	 * @param project - {@link Project} to add task to
	 * @param meetings - {@link MeetingsHandler} with default settings
	 * @param meeting - {@link Meeting} to create task for
	 * @param dependencies - {@link Object} task depends on
	 * @return - {@link Task} added
	 */
	protected Task createPublishPresentationTask(Project project, MeetingsHandler meetings, Meeting meeting,Object...dependencies) {
		//create task
		String name = CaseUtils.toCamelCase("Publish " + meeting.getName() + " Presentation",false);
		String description = "Publish the presentation for the %s.";
		Class<? extends Task> type = getPublishPresentationType();
		Task task = (type==null) ? createTask(project,meeting,name,description,dependencies) :
			createTask(project,type,meeting,name,description,dependencies);
		
		//configure task
		Action<Task> action = getConfigurePublishPresentation();
		if(action!=null) { //TODO:test parameter type against type...
			action.execute(task);
		}
		return task;
	}
	
	/**
	 * TODO:
	 * @return - {@link Action} to configure slide generation task or 
	 * null if no special configuration
	 */
	protected abstract Action<Task> getConfigurePublishPresentation();

	/**
	 * TODO:
	 * @return - {@link Class} with the type of the presentation assembly task or null if a simple placeholder/milestone
	 */
	protected abstract Class<? extends Task> getPublishPresentationType();

	/**
	 * TODO: add documentation...
	 * @param project - {@link Project} to add task to
	 * @param meetings - {@link MeetingsHandler} with default settings
	 * @param meeting - {@link Meeting} to create task for
	 * @param dependencies - {@link Object} task depends on
	 * @return - {@link Task} added
	 */
	protected Task createPublishAgendaTask(Project project, MeetingsHandler meetings, Meeting meeting,Object...dependencies) {
		//create task
		String name = CaseUtils.toCamelCase("Publish " + meeting.getName() + " Agenda",false);
		String description = "Publish the agenda for the %s.";
		Class<? extends Task> type = getPublishAgendaType();
		Task task = (type==null) ? createTask(project,meeting,name,description,dependencies) :
			createTask(project,type,meeting,name,description,dependencies);
		
		//configure task
		Action<Task> action = getConfigurePublishAgenda();
		if(action!=null) { //TODO:test parameter type against type...
			action.execute(task);
		}
		return task;
	}

	/**
	 * TODO:
	 * @return - {@link Action} to configure slide generation task or 
	 * null if no special configuration
	 */
	protected abstract Action<Task> getConfigurePublishAgenda();

	/**
	 * TODO:
	 * @return - {@link Class} with the type of the presentation assembly task or null if a simple placeholder/milestone
	 */
	protected abstract Class<? extends Task> getPublishAgendaType();

	/**
	 * TODO: add documentation...
	 * @param project - {@link Project} to add task to
	 * @param meetings - {@link MeetingsHandler} with default settings
	 * @param meeting - {@link Meeting} to create task for
	 * @param dependencies - {@link Object} task depends on
	 * @return - {@link Task} added
	 */
	protected Task createAssembleSlidesTask(Project project, MeetingsHandler meetings, Meeting meeting,Object...dependencies) {
		//create task
		String name = CaseUtils.toCamelCase("Assemble " + meeting.getName() + " Presentation",false);
		String description = "Assemble the presentation for the %s.";
		Class<? extends Task> type = getAssemblePresentationType();
		Task task = (type==null) ? createTask(project,meeting,name,description,dependencies) :
			createTask(project,type,meeting,name,description,dependencies);
		
		//configure task
		Action<Task> action = getConfigureAssemblePresentation();
		if(action!=null) { //TODO:test parameter type against type...
			action.execute(task);
		}
		return task;
	}

	
	/**
	 * TODO:
	 * @return - {@link Action} to configure slide generation task or 
	 * null if no special configuration
	 */
	protected abstract Action<Task> getConfigureAssemblePresentation();

	/**
	 * TODO:
	 * @return - {@link Class} with the type of the presentation assembly task or null if a simple placeholder/milestone
	 */
	protected abstract Class<? extends Task> getAssemblePresentationType();

	/**
	 * TODO: add documentation...
	 * @param project - {@link Project} to add task to
	 * @param meetings - {@link MeetingsHandler} with default settings
	 * @param meeting - {@link Meeting} to create task for
	 * @param dependencies - {@link Object} task depends on
	 * @return - {@link Task} added
	 */
	protected Task createDraftSlideTasks(Project project, MeetingsHandler meetings, Meeting meeting,Object...dependencies) {
		//create task
		String name = CaseUtils.toCamelCase("Draft " + meeting.getName() + " Slides",false);
		String description = "Draft the slides for the %s.";
		Task task = createTask(project,meeting,name,description,dependencies);
		createDraftTitleSlideTask(project,meetings,meeting,task); //TODO:how to pass dependencies with task...
		createDraftAgendaSlideTask(project,meetings,meeting,task); //TODO:how to pass dependencies with task...
		for(Topic topic : meeting.agenda()) {
			createDraftTopicSlideTask(project,meetings,meeting,topic,task); //TODO:how to pass dependencies with task...
		}
		return task;
	}

	
	/**
	 * TODO: add documentation...
	 * @param project - {@link Project} to add task to
	 * @param meetings - {@link MeetingsHandler} with default settings
	 * @param meeting - {@link Meeting} to create task for
	 * @param topic - {@link Topic} to create a slides for
	 * @param dependencies - {@link Object} task depends on
	 * @return - {@link Task} added
	 */
	private Task createDraftTopicSlideTask(Project project, MeetingsHandler meetings, Meeting meeting, Topic topic,
			Object...dependencies) {
		//create task
		String name = CaseUtils.toCamelCase("Draft " + meeting.getName() + " " + topic.getName() + " Slide",false);
		String description = "Draft the " + topic.getName() + " slide for the %s.";
		Class<? extends Task> type = getDraftTopicSlideType();
		Task task = (type==null) ? createTask(project,meeting,name,description,dependencies) :
			createTask(project,type,meeting,name,description,dependencies);
		
		//configure task
		Action<Task> action = getConfigureDraftTopicSlide();
		if(action!=null) { //TODO:test parameter type against type...
			action.execute(task);
		}
		
		//recurse to create slides for subtopics...
		for(Topic subtopic : topic.subtopics()) {
			createDraftTopicSlideTask(project,meetings,meeting,subtopic,task); //TODO:how to pass dependencies with task...
		}
		
		return task;
	}

	/**
	 * TODO:
	 * @return - {@link Action} to configure slide generation task or 
	 * null if no special configuration
	 */
	protected abstract Action<Task> getConfigureDraftTopicSlide();

	/**
	 * TODO:
	 * @return - {@link Class} with the type of the presentation assembly task or null if a simple placeholder/milestone
	 */
	protected abstract Class<? extends Task> getDraftTopicSlideType();

	/**
	 * TODO: add documentation...
	 * @param project - {@link Project} to add task to
	 * @param meetings - {@link MeetingsHandler} with default settings
	 * @param meeting - {@link Meeting} to create task for
	 * @param dependencies - {@link Object} task depends on
	 * @return - {@link Task} added
	 */
	protected Task createDraftAgendaSlideTask(Project project, MeetingsHandler meetings, Meeting meeting,Object...dependencies) {
		//create task
		String name = CaseUtils.toCamelCase("Draft " + meeting.getName() + " Agenda Slide",false);
		String description = "Draft the agenda slide for the %s.";
		Class<? extends Task> type = getDraftAgendaSlideType();
		Task task = (type==null) ? createTask(project,meeting,name,description,dependencies) :
			createTask(project,type,meeting,name,description,dependencies);
		
		//configure task
		Action<Task> action = getConfigureDraftAgendaSlide();
		if(action!=null) { //TODO:test parameter type against type...
			action.execute(task);
		}
		return task;
	}

	/**
	 * TODO:
	 * @return - {@link Action} to configure slide generation task or 
	 * null if no special configuration
	 */
	protected abstract Action<Task> getConfigureDraftAgendaSlide();

	/**
	 * TODO:
	 * @return - {@link Class} with the type of the presentation assembly task or null if a simple placeholder/milestone
	 */
	protected abstract Class<? extends Task> getDraftAgendaSlideType();

	/**
	 * TODO: add documentation...
	 * @param project - {@link Project} to add task to
	 * @param meetings - {@link MeetingsHandler} with default settings
	 * @param meeting - {@link Meeting} to create task for
	 * @param dependencies - {@link Object} task depends on
	 * @return - {@link Task} added
	 */
	protected Task createDraftTitleSlideTask(Project project, MeetingsHandler meetings, Meeting meeting,Object...dependencies)  {
		//create task
		String name = CaseUtils.toCamelCase("Draft " + meeting.getName() + " Title Slide",false);
		String description = "Draft the title slide for the %s.";
		Class<? extends Task> type = getDraftTitleSlideType();
		Task task = (type==null) ? createTask(project,meeting,name,description,dependencies) :
			createTask(project,type,meeting,name,description,dependencies);
		
		//configure task
		Action<Task> action = getConfigureDraftTitleSlide();
		if(action!=null) { //TODO:test parameter type against type...
			action.execute(task);
		}
		return task;
	}

	/**
	 * TODO:
	 * @return - {@link Action} to configure slide generation task or 
	 * null if no special configuration
	 */
	protected abstract Action<Task> getConfigureDraftTitleSlide();

	/**
	 * TODO:
	 * @return - {@link Class} with the type of the presentation assembly task or null if a simple placeholder/milestone
	 */
	protected abstract Class<? extends Task> getDraftTitleSlideType();

	/**
	 * TODO: add documentation...
	 * @param project - {@link Project} to add task to
	 * @param meetings - {@link MeetingsHandler} with default settings
	 * @param meeting - {@link Meeting} to create task for
	 * @param dependencies - {@link Object} task depends on
	 * @return - {@link Task} added
	 */
	protected Task createDraftMinutesTask(Project project, MeetingsHandler meetings, Meeting meeting,Object...dependencies) {
		//create task
		String name = CaseUtils.toCamelCase("Draft " + meeting.getName() + " Minutes",false);
		String description = "Draft the minutes for the %s.";
		Class<? extends Task> type = getDraftMinutesType();
		Task task = (type==null) ? createTask(project,meeting,name,description,dependencies) :
			createTask(project,type,meeting,name,description,dependencies);
		
		//configure task
		Action<Task> action = getConfigureDraftMinutes();
		if(action!=null) { //TODO:test parameter type against type...
			action.execute(task);
		}
		return task;
	}

	
	/**
	 * TODO:
	 * @return - {@link Action} to configure slide generation task or 
	 * null if no special configuration
	 */
	protected abstract Action<Task> getConfigureDraftMinutes();

	/**
	 * TODO:
	 * @return - {@link Class} with the type of the presentation assembly task or null if a simple placeholder/milestone
	 */
	protected abstract Class<? extends Task> getDraftMinutesType();

	/**
	 * TODO: add documentation...
	 * @param project - {@link Project} to add task to
	 * @param meetings - {@link MeetingsHandler} with default settings
	 * @param meeting - {@link Meeting} to create task for
	 * @param dependencies - {@link Object} task depends on
	 * @return - {@link Task} added
	 */
	protected Task createDraftAgendaTask(Project project, MeetingsHandler meetings, Meeting meeting,Object...dependencies) {
		//create task
		String name = CaseUtils.toCamelCase("Draft " + meeting.getName() + " Agenda",false);
		String description = "Draft the agenda for the %s.";
		Class<? extends Task> type = getDraftAgendaType();
		Task task = (type==null) ? createTask(project,meeting,name,description,dependencies) :
			createTask(project,type,meeting,name,description,dependencies);
		
		//configure task
		Action<Task> action = getConfigureDraftAgenda();
		if(action!=null) { //TODO:test parameter type against type...
			action.execute(task);
		}
		return task;
	}

	/**
	 * TODO:
	 * @return - {@link Action} to configure slide generation task or 
	 * null if no special configuration
	 */
	protected abstract Action<Task> getConfigureDraftAgenda();

	/**
	 * TODO:
	 * @return - {@link Class} with the type of the presentation assembly task or null if a simple placeholder/milestone
	 */
	protected abstract Class<? extends Task> getDraftAgendaType();

	/**
	 * TODO: add documentation...
	 * @param project - {@link Project} to add task to
	 * @param meetings - {@link MeetingsHandler} with default settings
	 * @param meeting - {@link Meeting} to create task for
	 * @param dependencies - {@link Object} task depends on
	 * @return - {@link Task} added
	 */
	protected Task createMilestoneTask(Project project,MeetingsHandler meetings,Meeting meeting,Object...dependencies) {
		String name = CaseUtils.toCamelCase(meeting.getName(),false);
		return createTask(project,meeting,name,"Milestone task for %s.");
	}
	
	/**
	 * TODO: add documentation...
	 * @param project - {@link Project} to add task to
	 * @param meeting - {@link Meeting} to create task for
	 * @param name - {@link String} with the name of the new task
	 * @param description - {@link String} with the description of the new task
	 * @param dependencies - {@link Object} task depends on
	 * @return - {@link Task} added
	 */
	protected Task createTask(Project project, Meeting meeting, String name, String description,Object...dependencies) {
		Task task = project.getTasks().create(name);
		task.setGroup(meeting.getName());
		String text = String.format(description,meeting.getName());
		task.setDescription(text);
		task.dependsOn(dependencies);
		return task;
	}

	/**
	 * TODO: add documentation...
	 * @param project - {@link Project} to add task to
	 * @param type - {@link Class} for the new task to create
	 * @param meeting - {@link Meeting} to create task for
	 * @param name - {@link String} with the name of the new task
	 * @param description - {@link String} with the description of the new task
	 * @param dependencies - {@link Object} task depends on
	 * @return - {@link Task} added
	 */
	protected <T extends Task> T createTask(Project project,Class<T> type, Meeting meeting, String name, String description,Object...dependencies) {
		T task = project.getTasks().create(name,type);
		task.setGroup(meeting.getName());
		String text = String.format(description,meeting.getName());
		task.setDescription(text);
		task.dependsOn(dependencies);
		return task;
	}

	/**
	 * TODO:
	 * @param project - {@link Project} to get the meetings for
	 * @return {@link MeetingsHandler} with the project's meetings
	 */
	protected MeetingsHandler getMeetings(Project project) {
		return project.getExtensions().getByType(MeetingsHandler.class);
	}

}
