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

import setools.gradle.dsl.agenda.internal.DefaultTitleSlide;
import setools.gradle.dsl.meeting.Meeting;

/**
 * TODO:documentation...
 */
public class GenerateTitleSlide extends GenerateTitleOnlySlide {

	/**
	 * TODO:documentation...
	 * @param meeting
	 * @param topic
	 */
	@Inject
	public GenerateTitleSlide(Meeting meeting, DefaultTitleSlide topic) {
		super(meeting, topic);
		setSubtitle(topic.getSubtitle());
	}

	@Override
	protected void createSlide(XSLFSlide slide) {
		super.createSlide(slide);
		XSLFTextShape shape = (XSLFTextShape)findShape(slide,"Subtitle");
		shape.setText(getSubtitle());
	}

	@Override
	protected XSLFSlideLayout getLayout(XMLSlideShow presentation) {
		return findLayout(presentation,"Title Slide");
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
