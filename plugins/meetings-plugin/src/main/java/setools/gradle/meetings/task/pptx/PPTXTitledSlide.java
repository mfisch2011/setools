/**
 * TODO:license...
 */
package setools.gradle.meetings.task.pptx;

import javax.inject.Inject;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.gradle.api.tasks.Input;

import setools.gradle.meetings.dsl.AgendaItem;
import setools.gradle.meetings.dsl.Meeting;
import setools.gradle.meetings.dsl.TitledSlide;

/**
 * TODO:documentation...
 */
public class PPTXTitledSlide extends AbstractGenerateSlideTask {
	
	/**
	 * TODO:documentation...
	 */
	protected String slideTitle = null;

	@Inject
	public PPTXTitledSlide(Meeting meeting, AgendaItem topic) {
		super(meeting, topic);
	}
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	@Input
	public String getSlideTitle() {
		return (slideTitle==null) ? topic.getTitle() :
			slideTitle;
	}
	
	/**
	 * TODO:documentation...
	 * @param title
	 */
	public void setSlideTitle(String title) {
		slideTitle = title;
	}

	@Override
	protected void createSlide(XSLFSlide slide) {
		XSLFTextShape shape = (XSLFTextShape) findShape(slide,"Title");
		shape.setText(getSlideTitle());
	}

	@Override
	protected XSLFSlideLayout getLayout(XMLSlideShow presentation) {
		XSLFSlideLayout layout = findLayout(presentation,"Title Slide");
		//TODO:how to handle null layout?
		return layout;
	}

}
