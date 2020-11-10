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
import org.gradle.api.tasks.Optional;

import setools.gradle.dsl.agenda.Section;
import setools.gradle.dsl.agenda.internal.DefaultSectionSlide;
import setools.gradle.dsl.meeting.Meeting;

/**
 * TODO:documentation...
 */
public class GenerateSectionSlide extends GenerateTitleOnlySlide {

	/**
	 * TODO:documentation...
	 * @param meeting
	 * @param topic
	 */
	@Inject
	public GenerateSectionSlide(Meeting meeting, Section topic) {
		super(meeting, topic);
		setSubtitle(topic.getSubtitle());
	}
	
	@Override
	protected void createSlides(XMLSlideShow presentation) throws Exception {
		XSLFSlideLayout layout = getLayout(presentation);
		XSLFSlide slide = (layout!=null) ? presentation.createSlide(layout) :
				presentation.createSlide();
		createSlide(slide); //for the section title slide...
		createSectionSlides(presentation);
	}
	
	/**
	 * TODO:documentation...
	 * @param presentation
	 */
	protected void createSectionSlides(XMLSlideShow presentation) {
		//to be overriden by children....
	}
	
	@Override
	protected void createSlide(XSLFSlide slide) {
		super.createSlide(slide);
		XSLFTextShape shape = (XSLFTextShape)findShape(slide,"Text");
		shape.setText(getSubtitle());
	}

	@Override
	protected XSLFSlideLayout getLayout(XMLSlideShow presentation) {
		return findLayout(presentation,"Section Header");
	}
	
	/**
	 * TODO:documentation...
	 */
	protected String slideSubtitle = null;

	/**
	 * TODO:documentation...
	 * @return
	 */
	@Input
	@Optional
	public String getSubtitle() {
		return slideSubtitle;
	}
	
	/**
	 * TODO:documentation...
	 * @param subtitle
	 */
	public void setSubtitle(String subtitle) {
		slideSubtitle = subtitle;
	}
}
