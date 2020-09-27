/**
 * TODO:license...
 */
package setools.gradle.meetings.task.pptx;

import javax.inject.Inject;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.Optional;

import setools.gradle.meetings.dsl.AgendaItem;
import setools.gradle.meetings.dsl.Meeting;
import setools.gradle.meetings.service.agenda.providers.TitleAndContentProvider.TitleAndContent;

/**
 * TODO:documentation...
 */
public class PPTXTitleAndContentSlide extends PPTXTitledSlide {

	/**
	 * TODO:documentation...
	 */
	protected String title = null;
	
	@Inject
	public PPTXTitleAndContentSlide(Meeting meeting, AgendaItem topic) {
		super(meeting, topic);
	}
	
	@Override
	protected XSLFSlideLayout getLayout(XMLSlideShow presentation) {
		XSLFSlideLayout layout = findLayout(presentation,"Title and Content");
		//TODO:how to handle null layout?
		return layout;
	}

	@Override
	protected void createSlide(XSLFSlide slide) {
		super.createSlide(slide);
		XSLFShape shape = findShape(slide,"Content");
		if(getContentText()!=null) {
			//TODO:test if we need to swap out shapes...
			XSLFTextShape text = (XSLFTextShape)shape;
			text.setText(getContentText());
		} else if(!topic().content().bullets().isEmpty()) {
			//TODO:test if we need to swap out shapes...
			XSLFTextShape text = (XSLFTextShape)shape;
			text.clearText();
			for(AgendaItem bullet : topic().content().bullets())
				createBullet(text,bullet,0);
		}/* TODO: implement image content... 
		else if(topic().getContentImage()!=null) {
			//TODO:test if we need to swap out shapes...
			//TODO:add image to presentation
		}*/
	}
	
	/**
	 * TODO:documentation...
	 * @param shape
	 * @param bullet
	 * @param level
	 */
	protected void createBullet(XSLFTextShape shape, AgendaItem topic, int level) {
		XSLFTextParagraph para = shape.addNewTextParagraph();
		para.setBullet(true);
		//TODO:set bullet formatting
		para.setIndentLevel(level);
		XSLFTextRun text = para.addNewTextRun();
		text.setText(topic.getTitle());
	}

	/**
	 * TODO:documentation...
	 */
	protected String contentText = null;
	
	@Input
	@Optional
	public String getContentText() {
		return (contentText!=null) ? contentText :
			topic().content().getContentText();
	}
	
	/**
	 * TODO:documentation...
	 * @param text
	 */
	public void setContentText(String text) {
		this.contentText = text;
	}
	
	protected TitleAndContent topic() {
		return (TitleAndContent)topic;
	}
	
	//TODO:how to make image and bullets optional inputs?
	
}
