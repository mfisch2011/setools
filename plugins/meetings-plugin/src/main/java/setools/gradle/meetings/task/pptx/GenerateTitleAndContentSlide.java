/**
 * TODO:license...
 */
package setools.gradle.meetings.task.pptx;

import java.util.ArrayList;

import javax.inject.Inject;

import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.Optional;

import setools.gradle.dsl.agenda.AgendaItem;
import setools.gradle.dsl.agenda.internal.DefaultBullet;
import setools.gradle.dsl.agenda.internal.DefaultTitleAndContent;
import setools.gradle.dsl.meeting.Meeting;

/**
 * TODO:documentation...
 */
public class GenerateTitleAndContentSlide extends GenerateTitleOnlySlide {

	/**
	 * TODO:documentation...
	 * @param meeting
	 * @param topic
	 */
	@Inject
	public GenerateTitleAndContentSlide(Meeting meeting, DefaultTitleAndContent topic) {
		super(meeting, topic);
		if(topic.content().getText()!=null && !topic.content().getText().isEmpty())
			setContentText(topic.content().getText());
		else if(!topic.content().bullets().isEmpty()) {
			//TODO:how to handle sub-bullets?
			for(AgendaItem object : topic.content().bullets()) {
				if(object instanceof DefaultBullet) {
					DefaultBullet bullet = (DefaultBullet)object;
					getBullets().add(bullet.getText());
				} else {
					getBullets().add(object.getName());
				}
			}
		} //TODO:else handle picture content...
	}
	
	/**
	 * TODO:documentation...
	 * @param text
	 */
	public void setContentText(String text) {
		contentText = text;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected String contentText = null;
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	@Input
	@Optional
	public String getContentText() {
		return contentText;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected ArrayList<String> bullets = new ArrayList<String>();
	
	@Input
	@Optional
	public ArrayList<String> getBullets() {
		return bullets;
	}
}
