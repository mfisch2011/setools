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
import org.gradle.api.Project;
import org.gradle.api.Task;

import setools.gradle.meetings.dsl.Meeting;
import setools.gradle.meetings.dsl.MeetingsHandler;
import setools.gradle.meetings.dsl.Topic;

import org.apache.commons.text.CaseUtils;

/**
 * TODO:
 */
public abstract class AbstractCreateMeetingTasksCallback implements Action<Project> {

	@Override
	public void execute(Project project) {
		MeetingsHandler meetings = getMeetings(project);
		for(Meeting meeting : meetings) {
			createTasksFor(project,meetings,meeting);
		}
	}

	/**
	 * Create the tasks for meeting using the default settings in meetings.
	 * 
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
	 * Create the task to publish the minutes for meeting using the default settings in meetings.
	 * 
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
		Class<? extends PublishDocument> type = getPublishMinutesType();
		if(type==null) {
			return createTask(project,meeting,name,description,dependencies);
		} else {
			PublishDocument task = createTask(project,type,meeting,name,description,dependencies);
			//TODO: configure task
			return task;
		}
	}

	/**
	 * Get the type of the task to use for publishing the meeting's minutes.
	 * 
	 * @return - {@link Class} with the type of the presentation assembly task or null if a simple placeholder/milestone
	 */
	protected abstract Class<? extends PublishDocument> getPublishMinutesType();

	/**
	 * Create the task to publish the presentation for meeting using the default settings in meetings.
	 * 
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
		Class<? extends PublishDocument> type = getPublishPresentationType();
		if(type==null) {
			return createTask(project,meeting,name,description,dependencies);
		} else {
			PublishDocument task = createTask(project,type,meeting,name,description,dependencies);
			//TODO: configure task
			return task;			
		}			
	}

	/**
	 * Get the type of the task to use for publishing the meeting's presentation.
	 * 
	 * @return - {@link Class} with the type of the presentation assembly task or null if a simple placeholder/milestone
	 */
	protected abstract Class<? extends PublishDocument> getPublishPresentationType();

	/**
	 * Create the task to publish the agenda for meeting using the default settings in meetings.
	 * 
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
		Class<? extends PublishDocument> type = getPublishAgendaType();
		if(type==null) {
			return createTask(project,meeting,name,description,dependencies);
		} else {
			PublishDocument task = createTask(project,type,meeting,name,description,dependencies);
			//TODO: configure task
			return task;			
		}
	}

	/**
	 * Get the type of the task to use for publishing the meeting's agenda.
	 * 
	 * @return - {@link Class} with the type of the presentation assembly task or null if a simple placeholder/milestone
	 */
	protected abstract Class<? extends PublishDocument> getPublishAgendaType();

	/**
	 * Create the task to assemble the presentation for meeting using the default settings in meetings.
	 * 
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
		Class<? extends AssemblePresentation> type = getAssemblePresentationType();
		if(type==null) {
			return createTask(project,meeting,name,description,dependencies);
		} else {
			AssemblePresentation task = createTask(project,type,meeting,name,description,dependencies);
			//TODO: configure task
			return task;
		}
	}

	/**
	 * Get the type of the task to use to assemble the meeting's presentation.
	 * 
	 * @return - {@link Class} with the type of the presentation assembly task or null if a simple placeholder/milestone
	 */
	protected abstract Class<? extends AssemblePresentation> getAssemblePresentationType();

	/**
	 * Create a tasks to draft the slides for meeting using the default settings in meetings.
	 * 
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
	 * Create a task to draft a slide for topic using the settings in meeting and meetings.
	 * 
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
		Class<? extends GenerateSlide> type = getDraftTopicSlideType();
		Task task = null;
		if(type==null) {
			task = createTask(project,meeting,name,description,dependencies);
		} else {
			GenerateSlide generate = createTask(project,type,meeting,name,description,dependencies);
			task = generate;
			//TODO: configure task
		}

		//recurse to create slides for subtopics...
		for(Topic subtopic : topic.subtopics()) {
			createDraftTopicSlideTask(project,meetings,meeting,subtopic,task); //TODO:how to pass dependencies with task...
		}
		return task;
	}

	/**
	 * Get the type of the task to use to generate topic slides.
	 * 
	 * @return - {@link Class} with the type of the presentation assembly task or null if a simple placeholder/milestone
	 */
	protected abstract Class<? extends GenerateSlide> getDraftTopicSlideType();

	/**
	 * Create a task to draft the agenda slide for meeting using the default settings in meetings.
	 * 
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
		Class<? extends GenerateSlide> type = getDraftAgendaSlideType();
		if(type==null) {
			return createTask(project,meeting,name,description,dependencies);
		} else {
			GenerateSlide task = createTask(project,type,meeting,name,description,dependencies);
			//TODO: configure task
			return task;			
		}
	}

	/**
	 * Get the type of the task to use to generate the agenda slides.
	 * 
	 * @return - {@link Class} with the type of the presentation assembly task or null if a simple placeholder/milestone
	 */
	protected abstract Class<? extends GenerateSlide> getDraftAgendaSlideType();

	/**
	 * Create a task to draft the title slide for meeting using the default settings in meetings.
	 * 
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
		Class<? extends GenerateSlide> type = getDraftTitleSlideType();
		if(type==null) {
			return createTask(project,meeting,name,description,dependencies);
		} else {
			GenerateSlide task = createTask(project,type,meeting,name,description,dependencies);
			//TODO: configure task
			return task;
		}
	}

	/**
	 * Get the type of the task to use to generate the title slide.
	 * 
	 * @return - {@link Class} with the type of the presentation assembly task or null if a simple placeholder/milestone
	 */
	protected abstract Class<? extends GenerateSlide> getDraftTitleSlideType();

	/**
	 * Create a task to draft the minutes for meeting using the default settings in meetings.
	 * 
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
		Class<? extends GenerateDocument> type = getDraftMinutesType();
		if(type==null) {
			return createTask(project,meeting,name,description,dependencies);
		} else {
			GenerateDocument task = createTask(project,type,meeting,name,description,dependencies);
			//TODO: configure task
			return task;
		}
	}

	/**
	 * Get the type of the task to use to generate the draft meeting minutes.
	 * 
	 * @return - {@link Class} with the type of the presentation assembly task or null if a simple placeholder/milestone
	 */
	protected abstract Class<? extends GenerateDocument> getDraftMinutesType();

	/**
	 * Create a task to draft the agenda for meeting using the default settings in meetings.
	 * 
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
		Class<? extends GenerateDocument> type = getDraftAgendaType();
		if(type==null) {
			return createTask(project,meeting,name,description,dependencies);
		} else {
			GenerateDocument task = createTask(project,type,meeting,name,description,dependencies);
			//TODO:how to abstract and re-use this???
			//set template
			Object template = meeting.getAgendaTemplate();
			if(template==null) {
				template = meetings.getDefaultAgendaTemplate();
			}
			task.setTemplate(template);
			
			//set output
			String agenda_name = meeting.getAgendaFilename();
			if(isNullOrEmpty(agenda_name)) {
				agenda_name = meetings.getDefaultAgendaFilename(meeting);
			}
			task.setOutput(agenda_name);
			
			//configure properties
			task.getContextProperties().put("meeting",meeting);
			
			//TODO: configure task
			return task;			
		}
	}
	
	/**
	 * TODO:
	 * @param text
	 * @return
	 */
	protected static boolean isNullOrEmpty(String text) {
		return text==null || text.isEmpty();
	}

	/**
	 * Get the type of the task to use to generate the draft meeting agenda.
	 * 
	 * @return - {@link Class} with the type of the presentation assembly task or null if a simple placeholder/milestone
	 */
	protected abstract Class<? extends GenerateDocument> getDraftAgendaType();

	/**
	 * Create the milestone task for meeting.
	 * 
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
	 * Create a new default task for meeting with name and description.
	 * 
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
	 * Create a new task for meeting with type, name, and description.
	 * 
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
	 * Get the MeetingHandler from project.
	 * 
	 * @param project - {@link Project} to get the meetings for
	 * @return {@link MeetingsHandler} with the project's meetings
	 */
	protected MeetingsHandler getMeetings(Project project) {
		return project.getExtensions().getByType(MeetingsHandler.class);
	}

}
