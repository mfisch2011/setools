/**
   Copyright 2020 Matt Fischer <mfish2011@gmail.com>

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
package setools.gradle.meeting.util;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;

import org.apache.commons.text.CaseUtils;
import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.tasks.SourceSet;

import setools.gradle.meeting.api.AgendaItem;
import setools.gradle.meeting.api.Meeting;
import setools.gradle.meeting.api.internal.DefaultAgendaItem;
import setools.gradle.tasks.AssemblePowerPointPresentation;
import setools.gradle.tasks.AssembleTask;
import setools.gradle.tasks.DraftAgendaSlide;
import setools.gradle.tasks.DraftSectionSlide;
import setools.gradle.tasks.DraftTitleSlide;
import setools.gradle.tasks.DraftWordAgenda;
import setools.gradle.tasks.DraftWordMinutes;
import setools.gradle.tasks.GenerateTask;

/**
 * @author matt
 *
 */
public class RegisterMeetingLifecycle implements Action<Project> {

	protected final Meeting meeting;
	
	@Inject
	public RegisterMeetingLifecycle(Meeting meeting) {
		this.meeting = meeting;
	}
	
	/**
	 * TODO:
	 */
	@Override
	public void execute(Project project) {
		try {
			addDraftAgendaTask(project);
			addDraftMinutesTask(project);
			addDraftSlidesTask(project);
			addAssemblePresentationTask(project);
			addPublishPresentationTask(project);
			addPublishMinutesTask(project);
			addSlideTasks(project);
			configureMilestone(project);
		} catch(Throwable t) {
			t.printStackTrace();
		}
	}

	protected void addSlideTasks(Project project) throws
	ClassNotFoundException, InstantiationException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException {
		//add task to draft title slide
		String name = getTaskName("Draft",meeting.getName(),"Title Slide");
		AgendaItem titleItem = new DefaultAgendaItem();
		titleItem.setText(meeting.getName());
		GenerateTask task = project.getTasks().create(name,DraftTitleSlide.class,meeting,titleItem);
		task.setGroup(meeting.getName());
		task.setDescription("Draft the title slide for the " + meeting.getName());
		task.setDestination(getOutput(meeting.getName(),"Title Slide.pptx"));
		getDraftSlides(project).dependsOn(task);
		
		//add task to draft agenda slide
		name = getTaskName("Draft",meeting.getName(),"Agenda Slide");
		task = project.getTasks().create(name,DraftAgendaSlide.class,meeting,1); //TODO:how to make the depth configurable?
		task.setGroup(meeting.getName());
		task.setDescription("Draft the agenda slide for the " + meeting.getName());
		task.setDestination(getOutput(meeting.getName(),"Agenda Slide.pptx"));
		getDraftSlides(project).dependsOn(task);
		
		//add tasks to draft slides for agenda items
		for(AgendaItem topic : meeting.getAgenda()) {
			addTopicSlideTasks(project,topic);
		}
		
		//add task to draft backups slide
		name = getTaskName("Draft",meeting.getName(),"Backups Slide");
		AgendaItem backupsItem = new DefaultAgendaItem();
		backupsItem.setText("Backups");
		task = project.getTasks().create(name,DraftSectionSlide.class,meeting,backupsItem);
		task.setGroup(meeting.getName());
		task.setDescription("Draft the backups slide for the " + meeting.getName());
		task.setDestination(getOutput(meeting.getName(),"Backups Slide.pptx"));
		getDraftSlides(project).dependsOn(task);
	}

	protected File getOutput(String meeting, String artifact) {
		//TODO: make use of source sets so this is configurable...
		//SourceSet sourceSet = getMeetingsSourceSet();
		//File dir = sourceSet.getOutput().getSingleFile();
		File dir = new File("src/meetings/" + meeting);
		String filename = meeting + " " + artifact;
		filename = CaseUtils.toCamelCase(filename, false, null);
		return new File(dir,filename);
	}

	protected SourceSet getMeetingsSourceSet() {
		// TODO Auto-generated method stub
		return null;
	}

	protected Task getDraftSlides(Project project) {
		return project.getTasks().getByName(getDraftSlidesName());
	}

	protected void addTopicSlideTasks(Project project,AgendaItem topic) throws ClassNotFoundException {
		//add task to draft slide for topic
		String formatter = topic.getFormatter();
		if(formatter!=null) {
			String name = getTaskName("Draft",meeting.getName(),topic.getText() + " Slide");
			@SuppressWarnings("unchecked")
			Class<? extends DefaultTask> type = (Class<? extends DefaultTask>) Class.forName(formatter);
			GenerateTask task = (GenerateTask)project.getTasks().create(name,type,meeting,topic);
			task.setGroup(meeting.getName());
			task.setDescription("Draft the " + topic.getText() + " slides for the " + meeting.getName());
			task.setDestination(getOutput(meeting.getName(),topic.getText() + " Slide.pptx"));
			getDraftSlides(project).dependsOn(task);
		}
		
		//add tasks to draft slides for sub-topics
		for(AgendaItem subTopic : topic.getSubItems()) {
			addTopicSlideTasks(project,subTopic);
		}
	}

	protected Task configureMilestone(Project project) {
		String name = getMilestoneName();
		Class<? extends DefaultTask> type = getMilestoneType();
		Task task = (type!=null) ? project.getTasks().create(name,type, meeting) :
					project.getTasks().create(name);
		task.setGroup(meeting.getName());
		task.setDescription("The milestone or culminating task for the " + meeting.getName());
		task.dependsOn(getPublishMinutesName());
		return task;
	}

	protected Class<? extends DefaultTask> getMilestoneType() {
		return null; //leave to children that need an implementation...
	}

	protected String getMilestoneName() {
		return CaseUtils.toCamelCase(meeting.getName(), false, null);
	}

	protected Task addPublishMinutesTask(Project project) {
		String name = getPublishMinutesName();
		Class<? extends DefaultTask> type = getPublishMinutesType();
		Task task = (type!=null) ? project.getTasks().create(name,type, meeting) :
					project.getTasks().create(name);
		task.setGroup(meeting.getName());
		task.setDescription("Publish the minutes for the " + meeting.getName());
		task.dependsOn(getPublishPresentationName());
		return task;
	}

	protected Class<? extends DefaultTask> getPublishMinutesType() {
		return null; //leave to children that need an implementation...
	}

	protected String getPublishMinutesName() {
		return getTaskName("Publish",meeting.getName(),"Minutes");
	}

	protected Task addPublishPresentationTask(Project project) {
		String name = getPublishPresentationName();
		Class<? extends DefaultTask> type = getPublishPresentationType();
		Task task = (type!=null) ? project.getTasks().create(name,type, meeting) :
					project.getTasks().create(name);
		task.setGroup(meeting.getName());
		task.setDescription("Publish the presentation for the " + meeting.getName());
		task.dependsOn(getAssemblePresentationName(),
			getDraftMinutesName(),getDraftAgendaName());
		return task;
	}

	protected Class<? extends DefaultTask> getPublishPresentationType() {
		return null; //leave to children that need an implementation...
	}

	protected String getPublishPresentationName() {
		return getTaskName("Publish",meeting.getName(),"Presentation");
	}

	protected Task addAssemblePresentationTask(Project project) {
		String name = getAssemblePresentationName();
		Class<? extends DefaultTask> type = getAssemblePresentationType();
		AssembleTask task = (type!=null) ? (AssembleTask)project.getTasks().create(name,type, meeting) :
					(AssembleTask)project.getTasks().create(name);
		task.setGroup(meeting.getName());
		task.setDescription("Assemble the presentation for the " + meeting.getName());
		task.setDestination(getOutput(meeting.getName(),"Presentation.pptx"));
		
		//TODO:replace this with source set so that it is configurable...
		String filename = "src/meetings/"+meeting.getName();
		task.setSource(project.file(filename));
		task.dependsOn(getDraftSlidesName());
		return task;
	}

	protected Class<? extends DefaultTask> getAssemblePresentationType() {
		return AssemblePowerPointPresentation.class;
	}

	protected String getAssemblePresentationName() {
		return getTaskName("Assemble",meeting.getName(),"Presentation");
	}

	protected Task addDraftSlidesTask(Project project) {
		String name = getDraftSlidesName();
		Class<? extends DefaultTask> type = getDraftSlidesType();
		Task task = (type!=null) ? project.getTasks().create(name,type, meeting) :
					project.getTasks().create(name);
		task.setGroup(meeting.getName());
		task.setDescription("Draft the slides for the " + meeting.getName());
		task.dependsOn(getDraftAgendaName());
		return task;
	}

	protected Class<? extends DefaultTask> getDraftSlidesType() {
		return null; //leave to children that need an implementation...
	}

	protected String getDraftSlidesName() {
		return getTaskName("Draft",meeting.getName(),"Slides");
	}

	protected Task addDraftMinutesTask(Project project) {
		String name = getDraftMinutesName();
		Class<? extends GenerateTask> type = getDraftMinutesType();
		if(type!=null) {
			GenerateTask task = project.getTasks().create(name, type, meeting);
			task.setGroup(meeting.getName());
			task.setDescription("Draft the minutes for the " + meeting.getName());
			String filename = meeting.getMinutesTemplate().getPath();
			int index = filename.lastIndexOf('.');
			String ext = filename.substring(index);
			task.setDestination(getOutput(meeting.getName(),"Minutes" + ext));
			task.dependsOn(getDraftAgendaName());
			return task;
		} else {
			Task task = project.getTasks().create(name);
			task.setGroup(meeting.getName());
			task.setDescription("Draft the minutes for the " + meeting.getName());
			task.dependsOn(getDraftAgendaName());
			return task;
		}
	}

	protected Class<? extends GenerateTask> getDraftMinutesType() {
		return DraftWordMinutes.class;
	}

	protected String getDraftMinutesName() {
		return getTaskName("Draft",meeting.getName(),"Minutes");
	}

	protected String getTaskName(String verb, String meeting, String artifact) {
		String result = String.format("%s %s %s", verb,meeting,artifact);
		result = removeSpecialCharacters(result);
		return CaseUtils.toCamelCase(result, false, null);
	}

	protected Task addDraftAgendaTask(Project project) {
		String name = getDraftAgendaName();
		Class<? extends GenerateTask> type = getDraftAgendaType();
		if(type!=null) {
			GenerateTask task = project.getTasks().create(name, type, meeting);
			task.setGroup(meeting.getName());
			task.setDescription("Draft the agenda for the " + meeting.getName());
			String filename = meeting.getMinutesTemplate().getPath();
			int index = filename.lastIndexOf('.');
			String ext = filename.substring(index);
			task.setDestination(getOutput(meeting.getName(),"Agenda" + ext));
			return task;
		} else {
			Task task = project.getTasks().create(name);
			task.setGroup(meeting.getName());
			task.setDescription("Draft the agenda for the " + meeting.getName());
			return task;
		}
	}

	protected Class<? extends GenerateTask> getDraftAgendaType() {
		return DraftWordAgenda.class;
	}

	protected String getDraftAgendaName() {
		return getTaskName("Draft",meeting.getName(),"Agenda");
	}

	protected String removeSpecialCharacters(String taskName) {
		String result = taskName.replace("/","");
		result = result.replace("\\", "");
		result = result.replace(":", "");
		result = result.replace("<", "");
		result = result.replace(">", "");
		result = result.replace("\"", "");
		result = result.replace("?", "");
		result = result.replace("*", "");
		result = result.replace("|", "");
		result = result.replace(",", "");
		return result;
	}
}
