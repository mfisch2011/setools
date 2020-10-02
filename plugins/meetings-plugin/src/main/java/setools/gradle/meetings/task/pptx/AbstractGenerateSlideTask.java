/**
 * TODO:license...
 */
package setools.gradle.meetings.task.pptx;

import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.inject.Inject;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Internal;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

import setools.gradle.meetings.MeetingsSourceSet;
import setools.gradle.meetings.util.SlideGenerator;
import setools.gradle.dsl.agenda.AgendaItem;
import setools.gradle.dsl.meeting.Meeting;
import setools.util.resources.ResourceLoader;

/**
 * TODO:documentation...
 */
public abstract class AbstractGenerateSlideTask extends DefaultTask implements SlideGenerator {

	/**
	 * TODO:documentation...
	 */
	protected final Meeting meeting;
	
	/**
	 * TODO:documentation...
	 */
	protected final AgendaItem topic;

	/**
	 * TODO:documentation...
	 * @param meeting
	 * @param topic
	 */
	@Inject
	public AbstractGenerateSlideTask(Meeting meeting,AgendaItem topic) {
		this.meeting = meeting;
		this.topic = topic;
		String slideName = topic.getName() + " Slide";
		slideName = slideName.toLowerCase().replace(" ", "-") + ".pptx";
		//TODO:use meeting source set...
		setOutput("src/meetings/" + meeting.getName() + "/" + slideName);
	}
	
	/**
	 * TODO:documentation...
	 * @throws Exception 
	 */
	@TaskAction
	public void generate() throws Exception {
		InputStream input = getTemplate();
		XMLSlideShow presentation = new XMLSlideShow(input);
		input.close();
		createSlides(presentation);
		OutputStream output = new FileOutputStream(getOutput());
		presentation.write(output);
		output.close();
	}
	
	/**
	 * TODO:documentation...
	 * @param presetnation
	 * @throws Exception
	 */
	protected void createSlides(XMLSlideShow presentation) throws Exception {
		XSLFSlideLayout layout = getLayout(presentation);
		XSLFSlide slide = (layout!=null) ? presentation.createSlide(layout) :
				presentation.createSlide();
		createSlide(slide);
	}
	
	/**
	 * TODO:documentation...
	 * @param slide
	 */
	protected abstract void createSlide(XSLFSlide slide);

	/**
	 * TODO:documentation...
	 * @param presentation
	 * @return
	 */
	protected abstract XSLFSlideLayout getLayout(XMLSlideShow presentation);

	/**
	 * TODO:documentation...
	 */
	protected File output  = null;
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	@OutputFile
	public File getOutput() {
		if(output==null) {
			//TODO:how to get this using the meetings source set...
			File dir = meeting.getMeetingDir();
			String filename = topic.getName().toLowerCase().replace(' ','-') + ".pptx";
			return new File(dir,filename);
		} else
			return output;
	}
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	protected MeetingsSourceSet meetingsSourceSet() {
		//TODO:
		return null;
	}
	
	/**
	 * TODO:documentation...
	 * @param object
	 */
	public void setOutput(Object object) {
		output = getProject().file(object);
	}
	
	/**
	 * TODO:documentation...
	 * @return
	 * @throws FileNotFoundException 
	 */
	@Internal
	protected InputStream getTemplate() throws IOException {
		//TODO:use ResourceLoader to get template InputStream...
		String resource = meeting.getPresentationTemplate();
		return ResourceLoader.getResource(resource);
	}
	
	/**
	 * TODO:documentation...
	 * @param presentation
	 * @param name
	 * @return
	 */
	protected static XSLFSlideLayout findLayout(XMLSlideShow presentation,String name) {
		//TODO:should we implement a fully qualified name to handle multiple masters?
		for(XSLFSlideMaster master : presentation.getSlideMasters()) {
			for(XSLFSlideLayout layout : master.getSlideLayouts()) {
				if(layout.getName().equals(name))
					return layout;
			}
		}
		return null;
	}
	
	/**
	 * TODO:documentation...
	 * @param slide
	 * @param name
	 * @return
	 */
	protected static XSLFShape findShape(XSLFSlide slide,String name) {
		//try shapes first
		for(XSLFShape shape : slide.getShapes()) {
			if(shape.getShapeName().equals(name))
				return shape;
		}
		
		//next try placeholders
		//TODO:there must be a more robust method
		for(XSLFShape placeholder : slide.getPlaceholders()) {
			if(placeholder.getShapeName().equals(name)) {
				Rectangle2D anchor = placeholder.getAnchor();
				for(XSLFShape shape : slide.getShapes()) {
					if(shape.getAnchor().equals(anchor))
						return shape;
				}
			}
		}
		return null;
	}
	
	protected void printLayouts(XMLSlideShow presentation) {
		for(XSLFSlideMaster master : presentation.getSlideMasters()) {
			System.out.printf("Master: %s%n", master);
			for(XSLFSlideLayout layout : master.getSlideLayouts()) {
				System.out.printf("Layout: %s%n", layout.getName());
			}
		}
	}
	
	protected void printShapes(XSLFSlide slide) {
		//actual shapes first
		System.out.println("Slide Shapes:");
		for(XSLFShape shape : slide.getShapes()) {
			System.out.printf("%s => %s%n",shape.getShapeName(),shape.getClass());
		}
		
		//next placeholders
		System.out.println("Slide Placeholders:");
		for(XSLFShape shape : slide.getPlaceholders()) {
			System.out.printf("%s => %s%n",shape.getShapeName(),shape.getClass());
		}
	}

	@Override
	public String getFormat() {
		return ".pptx";
	}
}
