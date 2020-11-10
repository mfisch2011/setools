/**
 * TODO:license...
 */
package setools.gradle.risk.tasks.pptx;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.inject.Inject;

import java.awt.geom.Rectangle2D;
import java.io.File;

import org.apache.poi.sl.usermodel.AutoNumberingScheme;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFAutoShape;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.Internal;
import org.gradle.api.tasks.Optional;

import setools.gradle.dsl.meeting.Meeting;
import setools.gradle.meetings.task.pptx.GenerateSectionSlide;
import setools.gradle.meetings.util.SlideGenerator;
import setools.gradle.risk.dsl.internal.DefaultRisksSection;
import setools.risk.Mitigation;
import setools.risk.Risk;
import setools.risk.util.RiskResourcesUtil;

/**
 * TODO:documentation...
 */
public class GenerateRiskSection extends GenerateSectionSlide implements SlideGenerator {
	
	/**
	 * TODO:documentation...
	 */
	private ResourceSet resourceSet = null;

	@Inject
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
	@Optional
	public Collection<Risk> getRisks() {
		Set<Risk> risks = new HashSet<Risk>();
		for(EObject object : getObjects()) {
			if(object instanceof Risk)
				risks.add((Risk)object);
		}
		return risks;
	}
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	@Internal
	public Collection<EObject> getObjects() {
		Set<EObject> results = new HashSet<EObject>();
		for(Resource resource : getResources()) {
			Iterator<EObject> iter = resource.getAllContents();
			while(iter.hasNext())
				results.add(iter.next());
		}
		return results;
	}
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	@Internal
	public Collection<Resource> getResources() {
		if(resourceSet==null) {
			resourceSet = new ResourceSetImpl();
			RiskResourcesUtil.init(resourceSet);
			for(File file : getSource()) {
				URI uri = URI.createFileURI(file.getAbsolutePath());
				resourceSet.getResource(uri, true);
			}
		}
		return resourceSet.getResources();
	}
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	@Internal
	public Collection<File> getSource() {
		Set<File> results = new HashSet<File>();
		//TODO:replace with SourceTask!!!!
		return results;
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
