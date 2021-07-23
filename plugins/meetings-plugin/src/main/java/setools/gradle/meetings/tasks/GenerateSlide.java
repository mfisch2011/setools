/**
 * TODO: add NSWC Crane's license...
 */
package setools.gradle.meetings.tasks;

import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.gradle.api.tasks.Input;
import org.gradle.util.ConfigureUtil;
import org.jodconverter.core.office.OfficeException;
import org.jodconverter.local.JodConverter;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import groovy.lang.Closure;

/**
 * TODO:add documentation...
 *
 */
public class GenerateSlide extends GenerateDocument {
	
	/**
	 * TODO:add documentation...
	 */
	protected String layout = null;
	
	@Input
	public String getLayout() {
		return layout;
	}
	
	/**
	 * TODO:add documentation...
	 * @param layout
	 */
	public void setLayout(String layout) {
		//TODO: validate layout
		this.layout = layout;
	}

	@Override
	public void generate() throws IOException, XDocReportException, OfficeException {
		File templateFile = null;
		File tmpFile = null;
		InputStream template = null;
		OutputStream temp = null;
		try {
			//initialize template from URL, layout, and ?properties...
			templateFile = Files.createTempFile("tmp",".pptx").toFile(); //TODO:make this configurable ???
			template = new FileInputStream(templateFile);
			XMLSlideShow  presentation = new XMLSlideShow(template);
			template.close();
			XSLFSlideLayout layout = getLayout(presentation,getLayout());
			XSLFSlide slide = (layout!=null) ? presentation.createSlide(layout) : presentation.createSlide();
			updateSlideTemplate(slide);
			temp = new FileOutputStream(templateFile);
			presentation.write(temp);
			temp.close();
			
			//load the template and initialize the engine
			template = new FileInputStream(templateFile);
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport(template,getTemplateEngineKind());
			template.close();
			
			//load any metadata for the document
			FieldsMetadata metadata = report.createFieldsMetadata();
			loadMetadata(metadata);
			
			//load the context properties to merge into the template
			IContext context = report.createContext();
			loadContext(context);
			
			//write the temporary output in the template's format
			tmpFile = Files.createTempFile("tmp",getExtension(
					getTemplate().toString())).toFile();
			temp = new FileOutputStream(tmpFile);
			report.process(context,temp);
			temp.close();
			
			//write the final output in the output file's format.
			JodConverter.convert(tmpFile)
				.as(getTemplateFormat())
				.to(getOutput())
				.as(getOutputFormat())
				.execute();
		} finally {
			if(templateFile!=null) {
				if(!templateFile.delete()) {
					getLogger().warn("Unable to remove {}.",templateFile);
				}
			}
			if(template!=null) template.close();
			if(tmpFile!=null)  {
				if(!tmpFile.delete()) {
					getLogger().warn("Unable to remove {}.",tmpFile);
				}
			}
			if(temp!=null) temp.close();
		}
	}
	
	/**
	 * TODO:add documentation...
	 */
	protected Properties templateScriptletts = new Properties();
	
	/**
	 * TODO:add documentation...
	 * @return
	 */
	@Input
	public Properties getTemplateScriptletts() {
		return templateScriptletts;
	}
	
	/**
	 * TODO:add documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Properties templateScriptletss(Closure closure) {
		ConfigureUtil.configure(closure, templateScriptletts);
		return templateScriptletts;
	}
	
	/**
	 * TODO:add documentation...
	 * @param slide
	 */
	protected void updateSlideTemplate(XSLFSlide slide) {
		for(Entry<Object, Object> property : getTemplateScriptletts().entrySet()) {
			String id = (String)property.getKey();
			String script = (String)property.getValue();
			XSLFShape shape = getShape(slide,id);
			if(shape!=null && (shape instanceof XSLFTextShape)) {
				XSLFTextShape textShape = (XSLFTextShape)shape;
				//TODO:how to handle/maintain bullet formatting???
				//TODO:test if shape has script text first????
				textShape.setText(script);
			}
			//TODO:warn/log if id not found???
		}
	}
	
	protected XSLFShape getShape(XSLFSlide slide,String id) {
		//search shapes first
		//almost always this will not work, because MS PPT munges the damn id's
		for(XSLFShape shape : slide.getShapes()) {
			if(shape.getShapeName().equals(id))
				return shape;
		}
		
		//search placeholders next and match by anchor...
		for(XSLFShape placeholder : slide.getPlaceholders()) {
			if(placeholder.getShapeName().equals(id)) {
				Rectangle2D anchor = placeholder.getAnchor();
				for(XSLFShape shape : slide.getShapes()) {
					if(shape.getAnchor().equals(anchor)) {
						return shape;
					}
				}
			}
		}
		return null; //nothing found
	}

	/**
	 * TODO:add documentation...
	 * @param presentation
	 * @param layout
	 * @return
	 */
	protected XSLFSlideLayout getLayout(XMLSlideShow presentation, String layout) {
		for(XSLFSlideMaster master : presentation.getSlideMasters()) {
			for(XSLFSlideLayout slideLayout : master.getSlideLayouts()) {
				if(slideLayout.getName().equals(layout))
					return slideLayout;
			}
		}
		return null;
	}

}
