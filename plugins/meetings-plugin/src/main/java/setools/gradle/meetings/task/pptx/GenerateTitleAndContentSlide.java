/**
 * TODO:license...
 */
package setools.gradle.meetings.task.pptx;

import java.util.ArrayList;

import javax.inject.Inject;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
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
	
	@Override
	protected void createSlide(XSLFSlide slide) {
		super.createSlide(slide);
		XSLFShape content = findShape(slide,"Content");
		String text = getContentText();
		if(text!=null && !text.isEmpty()) {
			XSLFTextShape textShape = (XSLFTextShape)content;
			textShape.setText(text);
		} else if(!getBullets().isEmpty()) {
			//TODO:sub-bullets...
			XSLFTextShape textShape = (XSLFTextShape)content;
			textShape.clearText();
			for(String bullet : getBullets()) {
				XSLFTextParagraph para = textShape.addNewTextParagraph();
				para.setBullet(true);
				//TODO:bullet format...
				para.addNewTextRun().setText(bullet);
			}
		}
	}

	@Override
	protected XSLFSlideLayout getLayout(XMLSlideShow presentation) {
		return findLayout(presentation,"Title and Content");
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
