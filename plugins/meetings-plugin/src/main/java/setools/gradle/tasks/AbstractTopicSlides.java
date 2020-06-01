/**
   Copyright 2019 Matt Fischer <mfish2011@gmail.com>

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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.inject.Inject;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.Internal;
import org.gradle.api.tasks.Optional;
import org.gradle.api.tasks.TaskAction;

import setools.doc.util.OOXMLException;
import setools.gradle.meeting.api.AgendaItem;
import setools.util.URLStreamHandler;

/**
 * @author matt
 *
 */
public abstract class AbstractTopicSlides extends GenerateTask {

	/**
	 * TODO:
	 */
	protected File output = null;
	
	/**
	 * TODO:
	 */
	protected URI template = null;

	protected final AgendaItem topic;

	@Inject
	public AbstractTopicSlides(AgendaItem topic) {
		this.topic = topic;
		setDestination("slides.pptx");
	}
	
	/** TODO:
	 * @throws IOException
	 * @throws OOXMLException 
	 */
	@TaskAction
	public void draftSlides() throws IOException, OOXMLException {
		XMLSlideShow presentation = initPresentation();
		buildSlides(presentation);
		File file = getDestination();
		if(!file.getParentFile().exists())
			Files.createDirectories(file.getParentFile().toPath());
		OutputStream stream = new FileOutputStream(file);
		presentation.write(stream);
		stream.close();
	}

	/** TODO:
	 * @param presentation
	 * @return 
	 * @throws OOXMLException 
	 */
	protected abstract void buildSlides(XMLSlideShow presentation) throws OOXMLException;
	
	/** TODO:
	 * @param object
	 */
	public void setOutput(Object object) {
		//TODO:modify to support build dir
		output  = getProject().file(object);
	}

	/** TODO:
	 * @return
	 * @throws IOException 
	 */
	protected XMLSlideShow initPresentation() throws IOException {
		URI uriTemplate = getTemplate();
		if(uriTemplate==null) {
			return new XMLSlideShow();
		} else {
			URL url = new URL(null,uriTemplate.toString(),new URLStreamHandler());
			InputStream stream = url.openStream();
			XMLSlideShow result = new XMLSlideShow(stream);
			stream.close();
			return result;
		}
	}

	/** TODO:
	 * @return
	 */
	@Input //TODO:how to support classpath and InputFile????
	@Optional
	public URI getTemplate() {
		return template;
	}
	
	/** TODO:
	 * @param object
	 */
	public void setTemplate(Object object) {
		template = getProject().uri(object);
	}
	
	/** TODO:
	 * @return
	 */
	@Internal
	public AgendaItem getTopic() {
		return topic;
	}
}
