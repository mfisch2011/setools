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

/**
 * TODO:documentation...
 */
public class PPTXSectionHeaderSlide extends AbstractGenerateSlideTask {

	@Inject
	public PPTXSectionHeaderSlide(Meeting meeting,AgendaItem topic) {
		super(meeting,topic);
	}

	@Override
	protected XSLFSlideLayout getLayout(XMLSlideShow presentation) {
		XSLFSlideLayout layout = findLayout(presentation,"Section Header");
		//TODO:how to handle null layout?
		return layout;
	}

	@Override
	protected void createSlide(XSLFSlide slide) {
		XSLFTextShape shape = (XSLFTextShape) findShape(slide,"Title");
		shape.setText(getSectionTitle());
	}
	
	/**
	 * TODO:documentation...
	 */
	protected String sectionTitle = null;
	
	@Input
	public String getSectionTitle() {
		return (sectionTitle!=null) ? sectionTitle : topic.getTitle();
	}
	
	/**
	 * TODO:documentation...
	 * @param title
	 */
	public void setSectionTitle(String title) {
		sectionTitle = title;
	}
}
