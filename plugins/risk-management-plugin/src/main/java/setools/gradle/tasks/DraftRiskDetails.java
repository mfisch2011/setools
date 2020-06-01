/**
   Copyright 2020 Matt Fischer <mfish2011@gmail.com>

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package setools.gradle.tasks;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.apache.poi.sl.usermodel.Insets2D;
import org.apache.poi.sl.usermodel.StrokeStyle.LineDash;
import org.apache.poi.sl.usermodel.VerticalAlignment;
import org.apache.poi.sl.usermodel.TextParagraph.TextAlign;
import org.apache.poi.sl.usermodel.TextShape.TextAutofit;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFConnectorShape;
import org.apache.poi.xslf.usermodel.XSLFNotes;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFTextBox;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.file.FileTree;
import org.gradle.api.file.FileTreeElement;
import org.gradle.api.specs.Spec;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.Internal;
import org.gradle.api.tasks.Optional;
import org.gradle.api.tasks.PathSensitive;
import org.gradle.api.tasks.PathSensitivity;
import org.gradle.api.tasks.SkipWhenEmpty;
import org.gradle.api.tasks.util.PatternFilterable;
import org.gradle.api.tasks.util.PatternSet;
import org.gradle.internal.Factory;

import groovy.lang.Closure;
import setools.doc.util.OOXMLException;
import setools.doc.util.OOXMLUtils;
import setools.gradle.meeting.api.AgendaItem;
import setools.gradle.meeting.api.Meeting;
import setools.risk.Consequence;
import setools.risk.Likelihood;
import setools.risk.Risk;
import setools.risk.RiskLevel;
import setools.risk.RiskMitigation;
import setools.uml.util.ResourceSetInitializerService;

/** TODO:
 * @author matt
 *
 */
public class DraftRiskDetails extends DraftTitledSlide implements PatternFilterable {
	
	protected ConfigurableFileCollection sourceFiles = getProject().getObjects().fileCollection();

	protected final PatternSet patternSet;
	
	protected Meeting meeting;

	protected boolean overview = false;
	
	@Inject
	public Factory<PatternSet> getPatternSetFactory() {
		throw new UnsupportedOperationException();
	}

	@Inject
	public DraftRiskDetails(Meeting meeting,AgendaItem topic) {
		super(meeting,topic);
		patternSet = getPatternSetFactory().create();
		source("src/main/uml","src/project/uml","build/uml");
		include("**/*.uml","**/*.UML","**/*.xmi","**/*.XMI");
	}

	@Override
	protected ArrayList<XSLFSlide> buildSlides(XMLSlideShow presentation) throws OOXMLException {
		ArrayList<XSLFSlide> slides = new ArrayList<XSLFSlide>();
		slides.add(addSlide(presentation,"Section Header",getTitle()));
		if(getHasOverview()) 
			addOverviewSlide(presentation);
		for(Risk risk : getRisks()) {
			try {
				addRiskDetailsSlide(presentation,risk);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return slides;
	}
	
	protected XSLFSlide addOverviewSlide(XMLSlideShow presentation) throws OOXMLException {
		XSLFSlideLayout slideLayout = OOXMLUtils.getSlideLayout(presentation, "Risk Overview");
		XSLFSlide slide = (slideLayout!=null) ? presentation.createSlide(slideLayout) :
			presentation.createSlide();
		OOXMLUtils.setShapeText(slide,"Title","Risk Overview");
		XSLFTextShape index = (XSLFTextShape)OOXMLUtils.getShape(slide, "Content");
		XSLFShape cube = OOXMLUtils.getShape(slide, "Risk Cube");
		addRiskOverview(slide,cube,index);
		addRiskOverviewNotes(presentation,slide);
		return slide;
	}

	protected void addRiskOverviewNotes(XMLSlideShow presentation, XSLFSlide slide) {
		// TODO Auto-generated method stub
		
	}

	protected void addRiskOverview(XSLFSlide slide,XSLFShape cube,XSLFTextShape index) {
		//create individual text boxes within cube
		Rectangle2D cubeAnchor = cube.getAnchor();
		XSLFTextShape[][] textBoxes = new XSLFTextShape[5][5];
		for(int likelihood=0;likelihood<5;likelihood++) {
			for(int consequence=0;consequence<5;consequence++) {
				Rectangle2D anchor = getCubeBoxAnchor(cubeAnchor,likelihood,consequence);
				textBoxes[likelihood][consequence] = slide.createTextBox();
				textBoxes[likelihood][consequence].setAnchor(anchor);
				
				//set text box formatting
				textBoxes[likelihood][consequence].setTextAutofit(TextAutofit.SHAPE);
				Insets2D insets = new Insets2D(0.0,0.0,0.0,0.0);
				textBoxes[likelihood][consequence].setInsets(insets);
				textBoxes[likelihood][consequence].clearText();
				XSLFTextParagraph paragraph = textBoxes[likelihood][consequence].addNewTextParagraph();
				paragraph.setTextAlign(TextAlign.CENTER);
				paragraph.addNewTextRun().setBold(true);
			}
		}
		
		int cnt = 1;
		index.clearText();
		for(Risk risk : getRisks()) {
			if(risk!=null) {
				index.appendText(risk.getId(),true);
				Likelihood likelihood = risk.getLikelihood();
				Consequence consequence = risk.getConsequence();
				if(likelihood!=null && consequence!=null) {
					int x = consequence.getValue();
					int y = likelihood.getValue();
					String text = textBoxes[y][x].getText();
					if(text.equals("null") || text.isEmpty())
						textBoxes[y][x].appendText(String.valueOf(cnt++),false);
					else
						textBoxes[y][x].appendText("," + String.valueOf(cnt++),false);
				}
			}
		}
	}

	@Input
	public boolean getHasOverview() {
		return overview;
	}
	
	public void setHasOverview(boolean set) {
		overview  = set;
	}

	//@Input   TODO: how to make this work and fix the damn serializable issue
	@Internal
	public Collection<Risk> getRisks() {
		Set<Risk> results = new HashSet<Risk>();
		ResourceSet resourceSet = new ResourceSetImpl();
		ResourceSetInitializerService.initialize(resourceSet);
		for(File file : getSource()) {
			URI uri = URI.createFileURI(file.getAbsolutePath());
			Resource resource = resourceSet.getResource(uri, true);
			for(EObject eObject : resource.getContents()) {
				if(eObject instanceof Risk)
					results.add((Risk)eObject);
			}
		}
		return results;
	}
	
	

	/** TODO:
	 * @param presentation
	 * @param risk
	 * @throws OOXMLException 
	 * @throws ParseException 
	 */
	protected XSLFSlide addRiskDetailsSlide(XMLSlideShow presentation, Risk risk) throws OOXMLException, ParseException {
		XSLFSlideLayout slideLayout = OOXMLUtils.getSlideLayout(presentation, "Risk Handling");
		
		XSLFSlide slide = (slideLayout!=null) ? presentation.createSlide(slideLayout) :
			presentation.createSlide();
		OOXMLUtils.setShapeText(slide,"Title",risk.getId());
		OOXMLUtils.setShapeText(slide,"Risk Description Text",risk.getStatement());
		XSLFShape cube = OOXMLUtils.getShape(slide, "Risk Cube");
		addRiskCube(slide,cube,risk);
		XSLFShape green = OOXMLUtils.getShape(slide,"Green Band");
		XSLFShape yellow = OOXMLUtils.getShape(slide, "Yellow Band");
		XSLFShape red = OOXMLUtils.getShape(slide, "Red Band");
		XSLFTextShape index = (XSLFTextShape) OOXMLUtils.getShape(slide, "Mitigation Measures Text");
		index.clearText(); //TODO:WHY IS THIS NOT REMOVING THE DAMN PLACEHOLDER TEXT!!!
		addRiskBurnDown(slide,risk,index,green,yellow,red);
		addRiskDetailsNotes(presentation,slide,risk);
		return slide;
	}

	protected void addRiskDetailsNotes(XMLSlideShow presentation, XSLFSlide slide,Risk risk) {
		XSLFNotes notes = presentation.getNotesSlide(slide);
		for(XSLFShape shape : notes.getShapes()) {
			if(shape.getShapeName().startsWith("Notes Placeholder")) {
				XSLFTextShape textShape = (XSLFTextShape)shape;
				textShape.clearText();
				textShape.setTextAutofit(TextAutofit.NORMAL);
				addRiskDetailsNotes(textShape,risk);
			}
		}
	}

	protected void addRiskDetailsNotes(XSLFTextShape shape,Risk risk) {
		//add full risk statement
		String riskStatement = getFullRiskStatement(risk);
		if(riskStatement!=null) {
			shape.appendText(String.format("Risk Statement: %s", riskStatement), true);
		}
		
		//add full risk background
		String riskBackground = getFullRiskBackground(risk);
		if(riskBackground!=null) {
			shape.appendText(String.format("Background: %s", riskBackground), true);
		}
		
		//add full risk status
		String riskStatus = getFullRiskStatus(risk);
		if(riskStatus!=null) {
			shape.appendText(String.format("Status: %s", riskStatus), true);
		}
		
		//add full risk mitigations
		String riskMitigations = getFullRiskMitigations(risk);
		if(riskMitigations!=null) {
			shape.appendText(String.format("Mitigations: %s", riskMitigations), true);
		}
	}

	protected String getFullRiskMitigations(Risk risk) {
		String results = "";
		for(RiskMitigation mitigation : risk.getMitigations()) {
			results += mitigation.toString() + "\n";
		}
		return results;
	}

	protected String getFullRiskStatus(Risk risk) {
		// TODO Auto-generated method stub
		return null;
	}

	protected String getFullRiskBackground(Risk risk) {
		// TODO Auto-generated method stub
		return null;
	}

	protected String getFullRiskStatement(Risk risk) {
		return risk.getStatement();
	}

	protected void addRiskBurnDown(XSLFSlide slide, Risk risk, XSLFTextShape index, XSLFShape green,
			XSLFShape yellow, XSLFShape red) throws ParseException {
		List<RiskMitigation> mitigations = risk.getMitigations();
		Date startDate = getStartDate(risk);
		Date endDate = getEndDate(risk);
		addDateScale(slide,green,startDate,endDate);
		addCurrentDateLine(slide,red,yellow,green,startDate,endDate);
		long duration = endDate.getTime() - startDate.getTime();
		int cnt = 1;
		for(RiskMitigation mitigation : mitigations) {
			//TODO:HOW TO CLEAN THIS CRAP UP???
			index.appendText(mitigation.getId(), true); //add to index
			RiskLevel residual = mitigation.getRisk();
			Date date = mitigation.getPlanned();
			if(date!=null) {
				long pos = date.getTime() - startDate.getTime();
				double percent = (double)pos /(double)duration;
				XSLFTextShape textBox = slide.createTextBox();
				textBox.setVerticalAlignment(VerticalAlignment.MIDDLE);
				textBox.setInsets(new Insets2D(0,0,0,0));
				textBox.clearText();
				textBox.setText(String.valueOf(cnt++));
				Rectangle2D band = null;
				if(residual.equals(RiskLevel.HIGH))
					band = red.getAnchor();
				else if(residual.equals(RiskLevel.MEDIUM))
					band = yellow.getAnchor();
				else if(residual.equals(RiskLevel.LOW))
					band = green.getAnchor();
				centerOnPercent(textBox,band,percent);
				//TODO: add connectors?
			}
		}
	}

	private XSLFShape[] addCurrentDateLine(XSLFSlide slide, XSLFShape red, XSLFShape yellow, XSLFShape green, Date start,
			Date end) {
		long duration = end.getTime() - start.getTime();
		long pos = new Date().getTime() - start.getTime();
		double percent = (double)pos /(double)duration;
		XSLFConnectorShape line = slide.createConnector();
		double x = red.getAnchor().getWidth() * percent;
		double top = red.getAnchor().getMinY();
		double height = green.getAnchor().getMaxY() - top;
		line.setAnchor(new Rectangle2D.Double(x,top,0,height));
		line.setLineColor(Color.BLACK);
		line.setLineWidth(2.0);
		line.setLineDash(LineDash.DASH);
		SimpleDateFormat formatter = new SimpleDateFormat("M/yy");
		Rectangle2D anchor = line.getAnchor();
		XSLFTextBox current = slide.createTextBox();
		double width = 50.0;
		current.setAnchor(new Rectangle2D.Double(anchor.getMinX()-width/2.0,anchor.getMaxY(),width,green.getAnchor().getHeight()));
		current.setText(formatter.format(new Date()));
		current.setTextAutofit(TextAutofit.NORMAL);
		return new XSLFShape[] {line,current};
	}

	private void addDateScale(XSLFSlide slide, XSLFShape green, Date startDate, Date endDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("M/yy");
		Rectangle2D anchor = green.getAnchor();
		XSLFTextBox start = slide.createTextBox();
		double width = 50.0;
		start.setAnchor(new Rectangle2D.Double(anchor.getMinX()-width/2.0,anchor.getMaxY(),width,anchor.getHeight()));
		start.setText(formatter.format(startDate));
		start.setTextAutofit(TextAutofit.NORMAL);
		XSLFTextBox end = slide.createTextBox();
		end.setAnchor(new Rectangle2D.Double(anchor.getMaxX()-width/2.0,anchor.getMaxY(),width,anchor.getHeight()));
		end.setText(formatter.format(endDate));
		end.setTextAutofit(TextAutofit.NORMAL);
	}

	//TODO:replace with real method
	private Date getEndDate(Risk risk) throws ParseException {
		Date result = new Date();
		for(RiskMitigation mitigation : risk.getMitigations()) {
			Date date = mitigation.getPlanned();
			if(date!=null && date.after(result))
				result = mitigation.getPlanned();
		}
		//add a month
		double time = result.getTime() + 2.628e+9;
		return new Date((long)time);
	}

	//TODO:replace with real method
	private Date getStartDate(Risk risk) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("m/d/y");
		return formatter.parse("10/1/19");
	}

	protected void centerOnPercent(XSLFTextShape textBox, Rectangle2D band, double percent) {
		Rectangle2D anchor = textBox.getAnchor();
		double x_center = band.getWidth() * percent + band.getX();
		double width = anchor.getWidth();
		double height = band.getHeight();
		double text_x = x_center + width/2.0;
		double text_y = band.getMinY();
		anchor = new Rectangle2D.Double(text_x,text_y,width,height);
		textBox.setAnchor(anchor);
	}

	protected void addRiskCube(XSLFSlide slide, XSLFShape cube, Risk risk) {
		//create individual text boxes within cube
		Rectangle2D cubeAnchor = cube.getAnchor();
		XSLFTextShape[][] textBoxes = new XSLFTextShape[5][5];
		for(int likelihood=0;likelihood<5;likelihood++) {
			for(int consequence=0;consequence<5;consequence++) {
				Rectangle2D anchor = getCubeBoxAnchor(cubeAnchor,likelihood,consequence);
				textBoxes[likelihood][consequence] = slide.createTextBox();
				textBoxes[likelihood][consequence].setAnchor(anchor);
				
				//set text box formatting
				textBoxes[likelihood][consequence].setTextAutofit(TextAutofit.SHAPE);
				Insets2D insets = new Insets2D(0.0,0.0,0.0,0.0);
				textBoxes[likelihood][consequence].setInsets(insets);
				textBoxes[likelihood][consequence].clearText();
				XSLFTextParagraph paragraph = textBoxes[likelihood][consequence].addNewTextParagraph();
				paragraph.setTextAlign(TextAlign.CENTER);
				paragraph.addNewTextRun().setBold(true);
			}
		}
		
		//TODO: add original risk level
		
		//add current risk level
		Likelihood likelihood = risk.getLikelihood();
		Consequence consequence = risk.getConsequence();
		if(likelihood!=null & consequence!=null) {
			RiskLevel level = risk.getRisk();
			if(level!=null) {
				int x = consequence.getValue();
				int y = likelihood.getValue();
				if(level.equals(RiskLevel.HIGH)) {
					textBoxes[y][x].appendText("X",false).setFontColor(Color.WHITE);
				} else {
					textBoxes[y][x].appendText("X",false).setFontColor(Color.BLACK);
				}
			}
		}
	}

	protected Rectangle2D getCubeBoxAnchor(Rectangle2D cubeAnchor, int likelihood, int consequence) {
		//TODO: the size and offsets still are not correct, but they will do for now...
		double x_offset = 40.0;
		double y_offset = 52.0;
		double width = (cubeAnchor.getWidth() - x_offset) / 5.0 + 0.2;
		double height = (cubeAnchor.getHeight() - y_offset) /5.0 - 1.0;
		double x = cubeAnchor.getX() + x_offset + consequence * width;
		double y = cubeAnchor.getY() + 2.0 + (4 - likelihood) * height;
		Rectangle2D.Double result = new Rectangle2D.Double(x,y,width,height);
		return result;
	}

	protected XSLFSlide addSlide(XMLSlideShow presentation,String layout,String title) throws OOXMLException {
		XSLFSlideLayout slideLayout = (layout!=null) ? 
				OOXMLUtils.getSlideLayout(presentation,layout) : null;
		XSLFSlide slide = (slideLayout!=null) ? presentation.createSlide(slideLayout) :
			presentation.createSlide();
		OOXMLUtils.setShapeText(slide,"Title",title);
		return slide;
	}
	
	@InputFiles
	@SkipWhenEmpty
	@PathSensitive(PathSensitivity.ABSOLUTE)
	public FileTree getSource() {
		return sourceFiles.getAsFileTree().matching(patternSet);
	}
	
	public void setSource(FileTree source) {
		setSource((Object)source);
	}
	
	public void setSource(Object source) {
		sourceFiles = getProject().getObjects().fileCollection().from(source);
	}
	
	public void source(Object...sources) {
		sourceFiles.from(sources);
	}

	@Override
	public PatternFilterable exclude(String... excludes) {
		patternSet.exclude(excludes);
		return this;
	}

	@Override
	public PatternFilterable exclude(Iterable<String> excludes) {
		patternSet.exclude(excludes);
		return this;
	}

	@Override
	public PatternFilterable exclude(Spec<FileTreeElement> excludes) {
		patternSet.exclude(excludes);
		return this;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PatternFilterable exclude(Closure excludes) {
		patternSet.exclude(excludes);
		return this;
	}

	@Input
	@Override
	public Set<String> getExcludes() {
		return patternSet.getExcludes();
	}

	@Input
	@Override
	public Set<String> getIncludes() {
		return patternSet.getIncludes();
	}

	@Override
	public PatternFilterable include(String... includes) {
		patternSet.include(includes);
		return this;
	}

	@Override
	public PatternFilterable include(Iterable<String> includes) {
		patternSet.include(includes);
		return this;
	}

	@Override
	public PatternFilterable include(Spec<FileTreeElement> includes) {
		patternSet.include(includes);
		return this;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PatternFilterable include(Closure includes) {
		patternSet.include(includes);
		return this;
	}

	@Override
	public PatternFilterable setExcludes(Iterable<String> excludes) {
		patternSet.setExcludes(excludes);
		return this;
	}

	@Override
	public PatternFilterable setIncludes(Iterable<String> includes) {
		patternSet.setIncludes(includes);
		return this;
	}
}
