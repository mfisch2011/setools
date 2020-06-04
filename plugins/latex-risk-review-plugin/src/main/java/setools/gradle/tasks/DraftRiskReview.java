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
import java.util.Collection;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.runtime.resource.loader.FileResourceLoader;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.UMLPlugin;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.Internal;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.SourceTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.plugins.UmlPlugin;
import setools.gradle.tasks.util.LatexUtilities;
import setools.risk.Risk;
import setools.risk.util.RiskResourcesUtil;
import setools.uml.util.ResourceSetInitializerService;

/**
 * TODO:
 */
public class DraftRiskReview extends SourceTask {

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
	
	/**
	 * TODO:
	 */
	protected final ResourceSet resourceSet;
	
	public DraftRiskReview() {
		//configure resourceSet
		resourceSet = new ResourceSetImpl();
		UmlPlugin umlPlugin = getProject().getPlugins().getPlugin(UmlPlugin.class);
		umlPlugin.initialize(resourceSet); //TODO:WTFF IS THIS NOT WORKING!!!!!!
		
		//configure velocity engine
		engineProperties.put("resource.loader","relative.file,absolute.file,classpath");
		engineProperties.put("classpath.resource.loader.class",ClasspathResourceLoader.class.getName());
		engineProperties.put("absoluted.file.resource.loader.class",FileResourceLoader.class.getName());
		engineProperties.put("relative.file.resource.loader.class",FileResourceLoader.class.getName());
		engineProperties.put("absoluted.file.resource.loader.path","");
		engineProperties.put("relative.file.resource.loader.path",getProject().getProjectDir().getAbsolutePath());
		
		//configure source
		setSource("src/project/risk"); //TODO:more gradle way using sourceSets...
		include("**/*.uml","**/*.UML","**/*.xmi","**/*.XMI");
		
		template = "templates/velocity/risk-review.tex.vm";
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
	@Internal //TODO:make this @Input once we solve the serialization/storage problem with UML objects....
	public Properties getContextProperties() {
		Properties results = new Properties();
		for(Entry<Object, Object> entry : contextProperties.entrySet()) {
			results.put(entry.getKey(), entry.getValue());
		}
		
		//utilities
		results.put("LatexUtils",new LatexUtilities());
		//action items
		results.put("action_items",getActionItems());
		
		//new risks
		results.put("new_risks", getNewRisks());
		
		//new monitored risks
		results.put("monitored_risks",getMonitoredRisks());
		
		//risk closures
		results.put("risk_closures",getRiskClosures());
		
		return results;
	}
	
	@Internal //TODO:convert to input and make this serializable somehow...
	protected Set<Risk> getRiskClosures() {
		Set<Risk> results = new HashSet<Risk>(); //TODO:change to TreeSet when we have Comparator
		for(Risk risk : getRisks()) {
			//TODO:filter
			results.add(risk);
		}
		return results;
	}
	
	@Internal
	protected Collection<Risk> getRisks() {
		//TODO:is there a way to cache this to improve performance?
		Set<Risk> results = new HashSet<Risk>(); //TODO:change this to TreeSet when we have a comparator...
		for(Resource resource : getResources()) {
			//assumes all stereotype applications are at root level, which they seem to be...
			for(EObject object : resource.getContents()) {
				if(object instanceof Risk) {
					results.add((Risk)object);
				}
			}
		}
		return results;
	}

	@Internal //TODO:convert to input and make this serializable somehow...???
	protected Collection<Resource> getResources() {
		for(File file : getSource()) {
			URI uri = URI.createFileURI(file.getAbsolutePath());
			resourceSet.getResource(uri, true); //TODO:how to prevent reloading if already loaded?
		}
		return resourceSet.getResources();
	}

	@Internal //TODO:convert to input and make this serializable somehow...
	protected Set<Risk> getMonitoredRisks() {
		Set<Risk> results = new HashSet<Risk>(); //TODO:change to TreeSet when we have comparator
		for(Risk risk : getRisks()) {
			//TODO:filter
			results.add(risk);
		}
		return results;
	}
	
	@Internal //TODO:convert to input and make this serializable somehow...
	protected Set<Risk> getNewRisks() {
		Set<Risk> results = new HashSet<Risk>(); //TODO:change to TreeSet when we have comparator
		for(Risk risk : getRisks()) {
			//TODO:filter
			results.add(risk);
		}
		return results;
	}

	@Internal //TODO:convert to input and make this serializable somehow...
	protected Set<Object> getActionItems() {
		Set<Object> results = new HashSet<Object>(); //TODO:change to TreeSet when we have comparator...
		//TODO:get action items... (and change type)
		return results;
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
