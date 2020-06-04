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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.runtime.resource.loader.FileResourceLoader;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;
import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;

/**
 * TODO:
 */
public class VelocityTask extends DefaultTask {

	/**
	 * TODO:
	 */
	protected String template;
	
	/**
	 * TODO:
	 */
	protected File output;
	
	/**
	 * TODO:
	 */
	protected Properties contextProperties = new Properties();
	
	/**
	 * TODO:
	 */
	protected Properties engineProperties = new Properties();
	
	public VelocityTask() {
		engineProperties.put("resource.loader","relative.file,absolute.file,classpath");
		engineProperties.put("classpath.resource.loader.class",ClasspathResourceLoader.class.getName());
		engineProperties.put("absoluted.file.resource.loader.class",FileResourceLoader.class.getName());
		engineProperties.put("relative.file.resource.loader.class",FileResourceLoader.class.getName());
		engineProperties.put("absoluted.file.resource.loader.path","");
		engineProperties.put("relative.file.resource.loader.path",getProject().getProjectDir().getAbsolutePath());
	}

	/**
	 * TODO:
	 * @throws IOException 
	 */
	@TaskAction
	public void merge() throws IOException {
		VelocityEngine engine = configureEngine();
		VelocityContext context = configureContext();
		Template template = engine.getTemplate(getTemplate());
		Writer writer = new FileWriter(getOutput());
		template.merge(context,writer);
		writer.close();
	}

	@OutputFile
	public File getOutput() {
		return output;
	}
	
	public void setOutput(Object object) {
		this.output = getProject().file(object);
	}

	@Input
	public String getTemplate() {
		return template;
	}
	
	public void setTemplate(String template) {
		//TODO:validate template
		this.template = template;
	}

	/** TODO:
	 * @return
	 */
	protected VelocityContext configureContext() {
		return new VelocityContext(getContextProperties());
	}

	/**
	 * TODO:
	 * @return
	 */
	@Input
	public Properties getContextProperties() {
		return contextProperties;
	}
	
	/**
	 * TODO:
	 * @param closure
	 */
	@SuppressWarnings("rawtypes")
	public void contextProperties(Closure closure) {
		ConfigureUtil.configure(closure, contextProperties);
	}

	/**
	 * TODO:
	 * @return
	 */
	protected VelocityEngine configureEngine() {
		return new VelocityEngine(getEngineProperties());
	}

	/**
	 * TODO:
	 * @return
	 */
	@Input
	public Properties getEngineProperties() {
		return engineProperties;
	}
	
	/**
	 * TODO:
	 * @param closure
	 */
	@SuppressWarnings("rawtypes")
	public void engineProperties(Closure closure) {
		ConfigureUtil.configure(closure, engineProperties);
	}
}
