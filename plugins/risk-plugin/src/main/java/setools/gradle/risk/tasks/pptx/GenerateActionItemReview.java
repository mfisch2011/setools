/**
 * TODO:license...
 */
package setools.gradle.risk.tasks.pptx;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.Internal;
import setools.gradle.actions.ActionItemDatabase;
import setools.gradle.actions.JDBCActionItemPlugin.JDBCActionItemDatabase;
import setools.gradle.actions.dsl.ActionItem;
import setools.gradle.dsl.meeting.Meeting;
import setools.gradle.meetings.task.pptx.GenerateSectionSlide;
import setools.gradle.meetings.util.SlideGenerator;
import setools.gradle.risk.ActionItemReview;

/**
 * TODO:documentation...
 */
public class GenerateActionItemReview extends GenerateSectionSlide implements SlideGenerator {

	@Inject
	public GenerateActionItemReview(Meeting meeting,ActionItemReview topic) {
		super(meeting, topic);
		setDatabase(topic.getDatabase());
	}
	
	@Override
	protected void createSectionSlides(XMLSlideShow presentation) {
		XSLFSlide slide = createActionItemSlide(presentation,false);
		for(ActionItem action : getActionItems()) {
			try {
				addActionItem(slide,action);
			} catch(XSLFShapeBoundsException e) {
				slide = createActionItemSlide(presentation,true);
				try {
					addActionItem(slide,action);
				} catch (XSLFShapeBoundsException e1) {
					getLogger().warn("Unable to add action item {}",action.getTitle());
					getLogger().trace("Error adding action item.",e1);
				}
			}
		}
	}
	
	/**
	 * TODO:documentation...
	 * @param slide
	 * @param action
	 */
	protected void addActionItem(XSLFSlide slide,ActionItem action) throws XSLFShapeBoundsException {
		XSLFTextShape shape = (XSLFTextShape) findShape(slide,"Content");
		XSLFTextParagraph para = shape.addNewTextParagraph();
		para.setBullet(true);
		para.addNewTextRun().setText(action.getTitle());
		//TODO:test if we exceeded the anchor for shape.
	}
	
	/**
	 * TODO:documentation...
	 * @param presentation
	 * @param continued
	 * @return
	 */
	protected XSLFSlide createActionItemSlide(XMLSlideShow presentation,boolean continued) {
		XSLFSlideLayout layout = findLayout(presentation,"Title and Content");
		XSLFSlide slide = presentation.createSlide(layout);
		String title = "Action Items";
		if(continued) title += " (continued)";
		XSLFTextShape shape = (XSLFTextShape)findShape(slide,"Title");
		shape.setText(title);
		return slide;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected String url = null;
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	@Internal
	public String getDatabase() {
		return url;
	}
	
	/**
	 * TODO:documentation...
	 * @param url
	 */
	public void setDatabase(String url) {
		//TODO:validate url
		this.url = url;
	}
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	@Input
	public Collection<ActionItem> getActionItems() {
		String url = getDatabase();
		if(!isNullOrEmpty(url)) {
			JDBCActionItemDatabase database = new JDBCActionItemDatabase();
			database.setUrl(url);
			return database.getActionItems(); //TODOfilter for open...
		} else {
			ActionItemDatabase database = getProject().getExtensions()
					.findByType(ActionItemDatabase.class);
			return (database!=null) ? database.getActionItems() : //TODO:filter for open...
				new ArrayList<ActionItem>(); //return empty set
		}
	}

	protected static boolean isNullOrEmpty(String text) {
		return (text==null || text.isEmpty());
	}
}
