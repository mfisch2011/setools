/**
 * TODO:license...
 */
package setools.gradle.meetings.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.Task;

import setools.gradle.meetings.dsl.AgendaItem;
import setools.gradle.meetings.dsl.Attendee;
import setools.gradle.meetings.dsl.Bullet;
import setools.gradle.meetings.dsl.Meeting;
import setools.gradle.meetings.service.agenda.providers.TitleAndContentProvider.DefaultTitleAndContent;
import setools.gradle.meetings.service.agenda.providers.TitleAndContentProvider.TitleAndContent;
import setools.gradle.meetings.service.agenda.providers.TitleSlideProvider.DefaultTitleSlide;
import setools.gradle.meetings.service.agenda.providers.TitleSlideProvider.TitleSlide;
import setools.gradle.meetings.task.pptx.*;

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
			//create virtual agenda item to initialize task
			DefaultTitleAndContent slide = new DefaultTitleAndContent();
			slide.setTitle("Roll Call");
			slide.setName(meeting.getName() + " Roll Call Slide");
			//TODO:allow adding sub-bullets...
			for(Attendee attendee : meeting.attendees()) {
				AgendaItem bullet = slide.subTopics().topic();
				String text = "";
				if(attendee.getName()!=null && !attendee.getName().isEmpty())
					text += attendee.getName();
				if(attendee.getRole()!=null && !attendee.getRole().isEmpty())
					text += " / " + attendee.getRole();
				bullet.setTitle(text);
			}
			Class<? extends DefaultTask> type = lookupType(slide);
			Task task = (type!=null) ?
					project.getTasks().create(name,type,meeting,slide) :
					project.getTasks().create(name);
			task.setGroup(meeting.getName());
			task.setDescription("Draft the agenda slide(s) for the " + meeting.getName() + ".");
			draftSlides.dependsOn(task);
		}
	}
	
	/**
	 * TODO:documentation...
	 */
	protected void createDraftBackupsSlideTask() {
		String name = getTaskName("draft","Backups Slide");
		Task task = project.getTasks().create(name);//TODO:add class
		task.setGroup(meeting.getName());
		task.setDescription("Draft the agenda slide(s) for the " + meeting.getName() + ".");
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
		DefaultTitleAndContent agendaSlide = new DefaultTitleAndContent();
		agendaSlide.setTitle("Agenda");
		agendaSlide.setName(meeting.getName() + " Agenda Slide");
		//TODO:allow adding sub-bullets...
		for(AgendaItem topic : meeting.agenda()) {
			agendaSlide.content().bullets().add(topic);
		}
		Class<? extends DefaultTask> type = lookupType(agendaSlide);
		Task task = (type!=null) ?
				project.getTasks().create(name,type,meeting,agendaSlide) :
				project.getTasks().create(name);
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
		DefaultTitleSlide titleSlide = new DefaultTitleSlide();
		titleSlide.setTitle(meeting.getName());
		titleSlide.setName(meeting.getName() + " Title Slide");
		Class<? extends DefaultTask> type = lookupType(titleSlide);
		Task task = (type!=null) ?
				project.getTasks().create(name,type,meeting,titleSlide) :
				project.getTasks().create(name);
		task.setGroup(meeting.getName());
		task.setDescription("Draft the title slide for the " + meeting.getName() + ".");
		draftSlides.dependsOn(task);
	}
	
	/**
	 * TODO:documentation...
	 * @param topic
	 */
	protected void createDraftSlideTask(AgendaItem topic) {
		String name = getTaskName("draft",topic.getTitle() + " Slide");
		Class<? extends DefaultTask> type = lookupType(topic);
		Task task = (type!=null) ? project.getTasks().create(name,type,meeting,topic) :
				project.getTasks().create(name) ;
		task.setGroup(meeting.getName());
		task.setDescription("Draft the " + topic.getTitle() 
			+ " slide for the " + meeting.getName() + " presentation.");
		if(!topic.getDependencies().isEmpty())
			task.dependsOn(topic.getDependencies());
		draftSlides.dependsOn(task);
		
		for(AgendaItem subTopic : topic.subTopics())
			if(!(subTopic instanceof Bullet))
				createDraftSlideTask(subTopic);
	}
	
	/**
	 * TODO:documentation...
	 * @param topic
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Class<? extends DefaultTask> lookupType(AgendaItem topic) {
		String formatter = topic.getFormatter();
		if(formatter!=null) {
			try {
				return (Class<? extends DefaultTask>)Class.forName(formatter);
			} catch (ClassNotFoundException e) {
				project.getLogger().warn("Formatter {} not found.",formatter);
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				e.printStackTrace(pw);
				project.getLogger().trace(sw.toString());
			}
		} else {
			String ext = templateType();
			return lookupType(ext,topic.getClass());
		}
		return null; //TODO:why is this necessary? i think there is a missing bracket...
	}
	
	protected Class<? extends DefaultTask> lookupType(String format,Class<?> type) {
		switch(format) {
		case ".pptx":
			//get list of implemented interfaces
			List<Class<?>> interfaces = new ArrayList<Class<?>>();
			for(Class<?> iface : type.getInterfaces())
				interfaces.add(iface);
			
			//TODO:how to make this extensible???
			if(interfaces.contains(TitleAndContent.class))
				return PPTXTitleAndContentSlide.class;
			else if(interfaces.contains(TitleSlide.class))
				return PPTXTitleSlide.class;
			else if(interfaces.contains(AgendaItem.class))
				return PPTXTitledSlide.class;
			else
				project.getLogger().warn(
				"Unhanded slide format '{}'.",type.getName());
			break;
		default:
			project.getLogger().warn(
			"Unhanded presentation format '{}'.",format);
			break;
		}
		return null;
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
