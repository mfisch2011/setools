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

import setools.gradle.dsl.agenda.internal.DefaultTitleOnly;
import setools.gradle.dsl.meeting.Meeting;

/**
 * TODO:documentation...
 */
public class GenerateTitleOnlySlide extends AbstractGenerateSlideTask {

	/**
	 * TODO:documentation...
	 * @param meeting
	 * @param topic
	 */
	@Inject
	public GenerateTitleOnlySlide(Meeting meeting,DefaultTitleOnly topic) {
		super(meeting, topic);
		setTitle(topic.getTitle());
	}

	@Override
	protected void createSlide(XSLFSlide slide) {
		XSLFTextShape shape = (XSLFTextShape)findShape(slide,"Title");
		shape.setText(getTitle());
	}

	@Override
	protected XSLFSlideLayout getLayout(XMLSlideShow presentation) {
		return findLayout(presentation,"Title Only");
	}

	/**
	 * TODO:documentation...
	 */
	protected String slideTitle = null;
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	@Input
	@Optional
	public String getTitle() {
		return slideTitle;
	}
	
	/**
	 * TODO:documentation...
	 * @param title
	 */
	public void setTitle(String title) {
		slideTitle = title;
	}
}
