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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.apache.commons.text.CaseUtils;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.Internal;
import org.gradle.api.tasks.Optional;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.util.PatternFilterable;
import org.gradle.api.tasks.util.PatternSet;

import setools.doc.util.OOXMLException;
import setools.doc.util.OOXMLUtils;
import setools.gradle.meeting.api.AgendaItem;
import setools.gradle.meeting.api.Meeting;
import setools.util.URLStreamHandler;

/** TODO:
 * @author matt
 *
 */
public class AssemblePowerPointPresentation extends AssembleTask {

	public static final String TASK_NAME = "assemblePowerPointPresentation";
	
	/**
	 * TODO:
	 */
	protected final Meeting meeting;

	/**
	 * TODO:
	 */
	protected File output = null;

	/**
	 * TODO:
	 */
	private URI template = null;
	
	/** TODO:
	 * @param meeting
	 */
	@Inject
	public AssemblePowerPointPresentation(Meeting meeting) {
		super();
		this.meeting = meeting;
		String filename = meeting.getName() + " Presentation " + meeting.getDate();
		filename = filename.toLowerCase().replace(' ', '-');
		setDestination(filename);
		File source = getProject().getProjectDir();
		this.setSource(source);
		this.include("**/*.pptx");
		this.exclude(getDestination().toString());
	}

	/**
	 * TODO:
	 * @throws IOException 
	 * @throws OOXMLException 
	 */
	@TaskAction
	public void assemblePresentation() throws IOException, OOXMLException {
		File output = getDestination();
		XMLSlideShow presentation = initPresentation();
		for(File file : getSourceFiles()) {
			InputStream iStream = new FileInputStream(file);
			XMLSlideShow tmp = new XMLSlideShow(iStream);
			iStream.close();
			OOXMLUtils.append(presentation,tmp);
			tmp.close();
		}
		if(!output.getParentFile().exists())
			Files.createDirectories(output.getParentFile().toPath());
		OutputStream oStream = new FileOutputStream(output);
		presentation.write(oStream);
		oStream.close();
	}
	
	/** TODO:
	 * @return
	 */
	@Internal
	protected Collection<File> getSourceFiles() {
		//TODO: THIS IS VERY BRITTLE!!! THERE MUST BE A BETTER WAY!!!!
		ArrayList<File> results = new ArrayList<File>();
		String baseName = meeting.getName();
		String pattern = CaseUtils.toCamelCase(baseName + " Title*.pptx",false,null);
		addFiles(results,pattern);
		pattern = CaseUtils.toCamelCase(baseName + " Agenda*.pptx",false,null);
		addFiles(results,pattern);
		for(AgendaItem topic : meeting.getAgenda()) {
			pattern=CaseUtils.toCamelCase(baseName + " " + topic.getText() +"*.pptx",false,null);
			addFiles(results,pattern);
		}
		pattern = CaseUtils.toCamelCase(baseName + " Backups*.pptx",false,null);
		addFiles(results,pattern);
		return results;
	}
	
	protected void addFiles(ArrayList<File> results, AgendaItem topic) {
		String pattern = meeting.getName();
		pattern += "-" + topic.getText();
		pattern += "*.pptx";
		pattern = pattern.toLowerCase();
		pattern = pattern.replace(" ","-");
		addFiles(results,pattern);
		for(AgendaItem subItem : topic.getSubItems())
			addFiles(results,subItem);
	}

	protected void addFiles(ArrayList<File> results, String pattern) {
		PatternFilterable patternSet = new PatternSet();
		patternSet.include(pattern);
		for(File file : getSource().matching(patternSet))
			results.add(file);
	}

	/** TODOL
	 * @return
	 * @throws IOException 
	 */
	protected XMLSlideShow initPresentation() throws IOException {
		URI uri = getTemplate();
		if(uri==null) {
			return new XMLSlideShow();
		} else {
			URL url = new URL(null,uri.toString(),new URLStreamHandler());
			InputStream stream = url.openStream();
			XMLSlideShow result = new XMLSlideShow(stream);
			stream.close();
			return result;
		}
	}

	@Input
	@Optional
	public URI getTemplate() {
		return (template==null) ? meeting.getPresentationTemplate() : template ;
	}
	
	public void setTemplate(Object object) {
		template = getProject().uri(object);
	}
	
}
