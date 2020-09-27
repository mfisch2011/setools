/**
 * TODO:license...
 */
package setools.gradle.meetings.task.pptx;

import javax.inject.Inject;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.gradle.api.tasks.Internal;

import setools.gradle.meetings.dsl.AgendaItem;
import setools.gradle.meetings.dsl.Meeting;
import setools.gradle.meetings.service.agenda.providers.TitleSlideProvider.TitleSlide;

/**
 * TODO:documentation...
 */
public class PPTXTitleSlide extends AbstractGenerateSlideTask {

	/**
	 * TODO:documentation...
	 * @param meeting
	 * @param topic
	 */
	@Inject
	public PPTXTitleSlide(Meeting meeting, AgendaItem topic) {
		super(meeting, topic);
	}

	@Override
	protected void createSlide(XSLFSlide slide) {
		//title
		if(getTitle()!=null && !getTitle().isBlank()) {
			XSLFTextShape shape = (XSLFTextShape) findShape(slide,"Title");
			shape.setText(getTitle());
		}
		
		//subtitle
		if(getSubTitle()!=null && !getSubTitle().isBlank()) {
			XSLFTextShape shape = (XSLFTextShape) findShape(slide,"Subtitle");
			shape.setText(getSubTitle());
		}
	}

	@Override
	protected XSLFSlideLayout getLayout(XMLSlideShow presentation) {
		return findLayout(presentation,"Title Slide");
	}

	/**
	 * TODO:documentation...
	 * @return
	 */
	@Internal
	protected String getTitle() {
		return topic.getTitle();
	}
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	@Internal
	protected String getSubTitle() {
		if(topic instanceof TitleSlide) {
			return ((TitleSlide)topic).getSubTitle();
		}
		return null;
	}
}
