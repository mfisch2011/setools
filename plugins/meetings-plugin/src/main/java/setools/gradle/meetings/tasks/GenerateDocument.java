/**
 * TODO: add NSWC Crane's license...
 */
package setools.gradle.meetings.tasks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Files;
import java.util.Map.Entry;
import java.util.Properties;

import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.Internal;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;
import org.gradle.util.ConfigureUtil;
import org.jodconverter.core.document.DefaultDocumentFormatRegistry;
import org.jodconverter.core.document.DocumentFormat;
import org.jodconverter.core.office.OfficeException;
import org.jodconverter.local.JodConverter;

import groovy.lang.Closure;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

/**
 * TODO:add documentation...
 *
 */
public class GenerateDocument extends DefaultTask {

	/**
	 * TODO:add documentation...
	 * @throws IOException 
	 * @throws XDocReportException 
	 * @throws OfficeException 
	 */
	@TaskAction
	public void generate() throws IOException, XDocReportException, OfficeException {
		File tmpFile = null;
		InputStream template = null;
		OutputStream temp = null;
		try {
			//load the template and initialize the engine
			template = getTemplate().toURL().openStream();
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
			if(template!=null) template.close();
			if(tmpFile!=null) {
				if(!tmpFile.delete()) {
					getLogger().warn("Unable to delete {}",tmpFile);
				}
			}
			if(temp!=null) temp.close();
		}
	}
	
	/**
	 * TODO:add documentation...
	 * @return
	 */
	@Internal
	protected DocumentFormat getOutputFormat() {
		String ext = getExtension(getOutput().getName());
		return DefaultDocumentFormatRegistry.getFormatByExtension(ext);
	}

	/**
	 * TODO:add documentation...
	 * @return
	 */
	@Internal
	protected DocumentFormat getTemplateFormat() {
		String ext = getExtension(getTemplate().getPath());
		return DefaultDocumentFormatRegistry.getFormatByExtension(ext);
	}

	/**
	 * TODO:add documentation...
	 * @param pathname
	 * @return
	 */
	protected String getExtension(String pathname) {
		int index = pathname.lastIndexOf('.');
		return (index>=0) ? pathname.substring(index) : "";
	}
	
	/**
	 * TODO:add documentation...
	 * @param context
	 */
	protected void loadContext(IContext context) {
		for(Entry<Object, Object> property : getContextProperties().entrySet()) {
			context.put(property.getKey().toString(),property.getValue());
		}
	}

	/**
	 * TODO:add documentation...
	 * @param metadata
	 */
	protected void loadMetadata(FieldsMetadata metadata) {
		//nothing to do, available for children to use...
	}
	
	/**
	 * TODO:add documentation...
	 */
	protected TemplateEngineKind templateEngineKind = TemplateEngineKind.Velocity;
	
	/**
	 * TODO:add documentation...
	 * @return
	 */
	@Input
	public TemplateEngineKind getTemplateEngineKind() {
		return templateEngineKind;
	}
	
	/**
	 * TODO:add documentation...
	 * @param value
	 */
	public void setTemplateEngineKind(TemplateEngineKind value) {
		templateEngineKind = value;
	}
	
	/**
	 * TODO:add documentation...
	 */
	protected URI template = null;
	
	/**
	 * TODO:add documentation...
	 * @return
	 */
	@Input //TODO:how to @InputFile ???
	public URI getTemplate() {
		return template;
	}
	
	/**
	 * TODO:add documentation...
	 * @param object
	 */
	public void setTemplate(Object object) {
		template = getProject().uri(object);
	}
	
	/**
	 * TODO:add documentation...
	 */
	protected File output = null;
	
	/**
	 * TODO:add documentation...
	 * @return
	 */
	@OutputFile
	public File getOutput() {
		return output;
	}
	
	/**
	 * TODO:add documentation...
	 * @param object
	 */
	public void setOutput(Object object) {
		output = getProject().file(object); 
	}
	
	/**
	 * TODO:add documentation...
	 */
	protected Properties contextProperties = new Properties();
	
	/**
	 * TODO:add documentation...
	 * @return
	 */
	@Input
	public Properties getContextProperties() {
		return contextProperties;
	}
	
	/**
	 * TODO:add documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Properties contextProperties(Closure closure) {
		ConfigureUtil.configure(closure, contextProperties);
		return contextProperties;
	}
	
	/**
	 * TODO:add documentation...
	 * @param action
	 * @return
	 */
	public Properties contextProperties(Action<Properties> action) {
		action.execute(contextProperties);
		return contextProperties;
	}
	
	/**
	 * TODO:add documentation...
	 */
	protected Properties engineProperties = new Properties();
	
	/**
	 * TODO:add documentation...
	 * @return
	 */
	@Input
	public Properties getEngineProperties() {
		return engineProperties;
	}
	
	/**
	 * TODO:add documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Properties engineProperties(Closure closure) {
		ConfigureUtil.configure(closure, engineProperties);
		return engineProperties;
	}
	
	/**
	 * TODO:add documentation...
	 * @param action
	 * @return
	 */
	public Properties engineProperties(Action<Properties> action) {
		action.execute(engineProperties);
		return engineProperties;
	}
}
