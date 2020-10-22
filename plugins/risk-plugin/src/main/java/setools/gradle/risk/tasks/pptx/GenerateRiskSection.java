/**
 * TODO:license...
 */
package setools.gradle.risk.tasks.pptx;

import java.util.Collection;
import java.awt.geom.Rectangle2D;

import org.apache.poi.sl.usermodel.AutoNumberingScheme;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFAutoShape;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFTextBox;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.gradle.api.tasks.Input;

import setools.gradle.dsl.meeting.Meeting;
import setools.gradle.meetings.task.pptx.GenerateSectionSlide;
import setools.gradle.meetings.util.SlideGenerator;
import setools.gradle.risk.dsl.internal.DefaultRisksSection;
import setools.risk.Consequence;
import setools.risk.Likelihood;
import setools.risk.Mitigation;
import setools.risk.Risk;

/**
 * TODO:documentation...
 */
public class GenerateRiskSection extends GenerateSectionSlide implements SlideGenerator {

	public GenerateRiskSection(Meeting meeting, DefaultRisksSection topic) {
		super(meeting, topic);
	}

	@Override
	protected void createSlides(XMLSlideShow presentation) throws Exception {
		createSectionTitleSlide(presentation);
		createRiskSlides(presentation);
	}
	
	/**
	 * TODO:documentation...
	 * @param presentation
	 */
	protected void createRiskSlides(XMLSlideShow presentation) {
		for(Risk risk : getRisks()) {
			createRiskSlide(presentation,risk);
		}
	}
	
	protected void createRiskSlide(XMLSlideShow presentation,Risk risk) {
		XSLFSlideLayout layout = findLayout(presentation,"Risk Slide");
		XSLFSlide slide = (layout!=null) ? presentation.createSlide(layout) :
			presentation.createSlide();
		setTitle(slide,risk.getName()); //TODO:add risk id to the front...
		setRiskStatement(slide,risk.getStatement());
		int likelihood = risk.getLikelihood().getValue();
		int consequence = risk.getConsequence().getValue();
		setCurrentRisk(slide,likelihood,consequence);
		//TODO:setInitialRisk(slide,likelihood,consequence);
		//TODO:setFinalRisk(slide,likelihood,consequence);
		listMitigations(slide,risk.getMitigations());
		createWaterfall(slide,risk);
	}
	
	protected void createWaterfall(XSLFSlide slide,Risk risk) {
		//TODO:
	}
	
	/**
	 * TODO:documentation...
	 * @param slide
	 * @param likelihood
	 * @param consequence
	 */
	protected void setCurrentRisk(XSLFSlide slide,int likelihood,int consequence) {
		createRiskIndicator(slide,likelihood,consequence,"X");
	}
	
	/**
	 * TODO:documentation...
	 * @param slide
	 * @param likelihood
	 * @param consequence
	 * @param text
	 * @return
	 */
	protected XSLFAutoShape createRiskIndicator(XSLFSlide slide,int likelihood,int consequence,String text) {
		XSLFShape shape = findShape(slide,"Risk Cube");
		XSLFAutoShape textbox = slide.createAutoShape();
		textbox.setAnchor(calculateAnchor(shape.getAnchor(),likelihood,consequence));
		textbox.setText("X");
		return textbox;
	}
	
	protected Rectangle2D calculateAnchor(Rectangle2D outline,int likelihood,int consequence) {
		//TODO:
		return null;
	}
	
	/**
	 * TODO:documentation...
	 * @param slide
	 * @param mitigations
	 */
	protected void listMitigations(XSLFSlide slide,Collection<Mitigation> mitigations) {
		XSLFAutoShape textbox = (XSLFAutoShape)findShape(slide,"Risk Mitigations");
		textbox.clearText();
		for(Mitigation mitigation : mitigations) {
			XSLFTextParagraph para = textbox.addNewTextParagraph();
			para.setBulletAutoNumber(AutoNumberingScheme.arabicPeriod,1);
			para.addNewTextRun().setText(mitigation.getName());
		}
	}
	
	/**
	 * TODO:documentation...
	 * @param slide
	 * @param text
	 */
	protected void setRiskStatement(XSLFSlide slide,String text) {
		XSLFAutoShape statement = (XSLFAutoShape)findShape(slide,"Risk Statement");
		statement.setText(text);
	}
	
	/**
	 * TODO:documentation...
	 * @param slide
	 * @param title
	 */
	protected void setTitle(XSLFSlide slide,String text) {
		XSLFAutoShape title = (XSLFAutoShape)findShape(slide,"Title");
		title.setText(text);
	}
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Input
	public Collection<Risk> getRisks() {
		return ((DefaultRisksSection)topic).filter();
	}
	
	/**
	 * TODO:documentation...
	 * @param presentation
	 */
	protected void createSectionTitleSlide(XMLSlideShow presentation) {
		XSLFSlideLayout layout = super.getLayout(presentation);
		XSLFSlide slide = (layout!=null) ? presentation.createSlide(layout) :
				presentation.createSlide();
		super.createSlide(slide);
	}
}
