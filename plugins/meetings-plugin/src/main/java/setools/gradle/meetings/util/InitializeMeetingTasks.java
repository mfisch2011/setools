/**
 * TODO:license...
 */
package setools.gradle.meetings.util;

import javax.inject.Inject;

import org.gradle.api.Project;
import org.gradle.api.Task;

import setools.gradle.dsl.agenda.AgendaItem;
import setools.gradle.dsl.agenda.internal.DefaultBullet;
import setools.gradle.dsl.agenda.internal.DefaultSectionSlide;
import setools.gradle.dsl.agenda.internal.DefaultTitleAndContent;
import setools.gradle.dsl.agenda.internal.DefaultTitleSlide;
import setools.gradle.dsl.attendee.Attendee;
import setools.gradle.dsl.meeting.Meeting;
import org.apache.commons.text.CaseUtils;

/**
 * TODO:documentation...
 */
public class InitializeMeetingTasks {

	/**
	 * TODO:documentation...
	 */
	protected final Project project;
	
	/**
	 * TODO:documentation...
	 */
	protected final Meeting meeting;
	
	/**
	 * TODO:documentation...
	 */
	protected Task draftAgenda;
	
	/**
	 * TODO:documentation...
	 */
	protected Task draftMinutes;
	
	/**
	 * TODO:documentation...
	 */
	protected Task draftSlides;
	
	/**
	 * TODO:documentation...
	 */
	protected Task assemblePresentation;
	
	/**
	 * TODO:documentation...
	 */
	protected Task publishPresentation;
	
	/**
	 * TODO:documentation...
	 */
	protected Task publishMinutes;
	
	/**
	 * TODO:documentation...
	 */
	protected Task milestone = null;
	
	@Inject
	public InitializeMeetingTasks(Project project,Meeting meeting) {
		this.project = project;
		this.meeting = meeting;
	}

	/**
	 * TODO:documentation...
	 */
	public void initializeTasks() {
		createDraftAgendaTask();
		createDraftMinutesTask();
		createDraftSlideTasks();
		createAssemblePresentationTask();
		createPublishPresentationTask();
		createPublishMinutesTask();
		createMilestoneTask();
	}
	
	/**
	 * TODO:documentation...
	 */
	protected void createPublishMinutesTask() {
		publishMinutes = project.getTasks().create(getTaskName("publish","minutes")); //TODO:add class
		publishMinutes.setGroup(meeting.getName());
		publishMinutes.setDescription("Publish the minutes for the " + meeting.getName() + ".");
		publishMinutes.dependsOn(publishPresentation,draftMinutes);
	}
	
	/**
	 * TODO:documentation...
	 */
	protected void createPublishPresentationTask() {
		publishPresentation = project.getTasks().create(getTaskName("publish","presentation")); //TODO:add class
		publishPresentation.setGroup(meeting.getName());
		publishPresentation.setDescription("Publish the presentation for the " + meeting.getName() + ".");
		publishPresentation.dependsOn(assemblePresentation);
	}
	
	/**
	 * TODO:documentation...
	 */
	protected void createAssemblePresentationTask() {
		assemblePresentation = project.getTasks().create(getTaskName("assemble","presentation")); //TODO:add class
		assemblePresentation.setGroup(meeting.getName());
		assemblePresentation.setDescription("Assemble the presentation for the " + meeting.getName() + ".");
		assemblePresentation.dependsOn(draftSlides);
	}
	
	/**
	 * TODO:documentation...
	 */
	protected void createDraftSlideTasks() {
		draftSlides = project.getTasks().create(getTaskName("draft","slides")); //no class, virtual task...
		draftSlides.setGroup(meeting.getName());
		draftSlides.setDescription("Draft the presentation slides for the " + meeting.getName() + ".");
		//dependencies added in child task creation
		
		createDraftTitleSlideTask();
		createRollCallSlideTask();
		createDraftAgendaSlideTask();
		createDraftBackupsSlideTask();
		
		for(AgendaItem topic : meeting.agenda()) {
			createDraftSlideTask(topic);
		}
	}
	
	protected void createRollCallSlideTask() {
		if(!meeting.attendees().isEmpty()) {
			String name = getTaskName("draft","Roll Call Slide");
			DefaultTitleAndContent topic = new DefaultTitleAndContent();
			topic.setTitle("Roll Call");
			topic.setName("Roll Call Slide");
			for(Attendee attendee : meeting.attendees()) {
				String text = "";
				if(attendee.getName()!=null) {
					text = attendee.getName();
				}
				if(attendee.getRole()!=null) {
					if(!text.isEmpty())
						text += " / ";
					text += attendee.getRole();
				}
				DefaultBullet bullet = new DefaultBullet();
				bullet.setText(text);
				topic.content().bullets().add(bullet);
			}
			Class<? extends SlideGenerator> type = SlideGeneratorService.getTaskType(getPresentationFormat(),topic);
			Task task = (type!=null) ? 
				project.getTasks().create(name,type,meeting,topic) :	
				project.getTasks().create(name); //TODO:add class
			task.setGroup(meeting.getName());
			task.setDescription("Draft the agenda slide(s) for the " + meeting.getName() + ".");
			draftSlides.dependsOn(task);
		}
	}
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	protected String getPresentationFormat() {
		String filename = meeting.getPresentationTemplate();
		int index = filename.lastIndexOf('.');
		String ext = (index>0) ? filename.substring(index) : "";
		return ext;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected void createDraftBackupsSlideTask() {
		String name = getTaskName("draft","Backups Slide");
		//create virtual agenda item to initialize task
		DefaultSectionSlide topic = new DefaultSectionSlide();
		topic.setTitle("Backups");
		Class<? extends SlideGenerator> type = SlideGeneratorService.getTaskType(getPresentationFormat(),topic);
		Task task = (type==null) ? project.getTasks().create(name) :
			project.getTasks().create(name,type,meeting,topic);
		task.setGroup(meeting.getName());
		task.setDescription("Draft the backup slide(s) for the " + meeting.getName() + ".");
		draftSlides.dependsOn(task);
		
		for(AgendaItem backup : meeting.backups()) {
			createDraftSlideTask(backup);
		}
	}
	
	/**
	 * TODO:documentation...
	 */
	protected void createDraftAgendaSlideTask() {
		String name = getTaskName("draft","Agenda Slide");
		//create virtual agenda item to initialize task
		DefaultTitleAndContent topic = new DefaultTitleAndContent();
		topic.setTitle("Agenda");
		for(AgendaItem bullet : meeting.agenda()) {
			topic.content().bullets().add(bullet);
		}
		Class<? extends SlideGenerator> type = SlideGeneratorService.getTaskType(getPresentationFormat(),topic);
		Task task = (type==null) ? project.getTasks().create(name) :
			project.getTasks().create(name,type,meeting,topic);
		task.setGroup(meeting.getName());
		task.setDescription("Draft the agenda slide(s) for the " + meeting.getName() + ".");
		draftSlides.dependsOn(task);
	}
	
	/**
	 * TODO:documentation...
	 */
	protected void createDraftTitleSlideTask() {
		String name = getTaskName("draft","Title Slide");
		//create virtual agenda item to initialize task
		DefaultTitleSlide topic = new DefaultTitleSlide();
		topic.setName("title");
		topic.setTitle(meeting.getName());
		topic.setSubtitle(meeting.getDate());
		Class<? extends SlideGenerator> type = SlideGeneratorService.getTaskType(getPresentationFormat(),topic);
		Task task = (type==null) ? project.getTasks().create(name) :
			project.getTasks().create(name,type,meeting,topic);
		task.setGroup(meeting.getName());
		task.setDescription("Draft the title slide for the " + meeting.getName() + ".");
		draftSlides.dependsOn(task);
	}
	
	/**
	 * TODO:documentation...
	 * @param topic
	 */
	protected void createDraftSlideTask(AgendaItem topic) {
		String name = getTaskName("draft",topic.getName() + " Slide");
		String format = this.getPresentationFormat();
		Class<? extends Task> type = SlideGeneratorService.getTaskType(format, topic);
		Task task = (type==null) ? project.getTasks().create(name) :
			project.getTasks().create(name,type,meeting,topic); //TODO:add class
		task.setGroup(meeting.getName());
		task.setDescription("Draft the " + topic.getName() 
			+ " slide for the " + meeting.getName() + " presentation.");
		if(!topic.getDependencies().isEmpty())
			task.dependsOn(topic.getDependencies());
		draftSlides.dependsOn(task);
		for(AgendaItem subtopic : topic.subTopics()) {
			createDraftSlideTask(subtopic);
		}
	}
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	protected String templateType() {
		String template = meeting.getPresentationTemplate();
		System.out.printf("PRESENTATION TEMPLATE: %s%n", template);
		int index = template.lastIndexOf('.');
		return (index>0) ? template.substring(index) : "";
	}

	/**
	 * TODO:documentation...
	 */
	protected void createDraftAgendaTask() {
		draftAgenda = project.getTasks().create(getTaskName("draft","agenda")); //TODO:add task class.
		draftAgenda.setGroup(meeting.getName());
		draftAgenda.setDescription("Draft the agenda for the " + meeting.getName() + ".");
	}
	
	/**
	 * TODO:documentation...
	 */
	protected void createDraftMinutesTask() {
		draftMinutes = project.getTasks().create(getTaskName("draft","minutes")); //TODO:add task class.
		draftMinutes.setGroup(meeting.getName());
		draftMinutes.setDescription("Draft the minutes for the " + meeting.getName() + ".");
		draftMinutes.dependsOn(draftAgenda);
	}
	
	/**
	 * TODO:documentation...
	 * @param verb
	 * @param noun
	 * @return
	 */
	protected String getTaskName(String verb,String noun) {
		return CaseUtils.toCamelCase(verb + " " 
			+ meeting.getName() + " " + noun, false);
	}
	
	/**
	 * TODO:documentation...
	 */
	protected void createMilestoneTask() {
		milestone = project.getTasks().create(CaseUtils.toCamelCase(
				meeting.getName(), false));
		milestone.setGroup(meeting.getName());
		milestone.setDescription("Milestone task for the " + 
				meeting.getName() + " meeting.");
		milestone.dependsOn(publishMinutes);
	}
	
	
	
}
