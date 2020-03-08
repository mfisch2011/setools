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
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.OutputFiles;
import org.gradle.api.tasks.TaskAction;

import setools.gradle.plugins.AgendaItem;
import setools.gradle.plugins.MeetingsPluginExtension;
import setools.util.URLStreamHandler;

import static setools.docs.xwpf.XWLFUtilities.*;

/**
 * @author matt
 *
 */
public class OOXMLDraftPresentation extends AbstractDraftPresentation {

	protected URI template = null;
	
	@TaskAction
	public void draftSlides() throws IOException {
		draftTitleSlide();
		draftAgendaSlide();
		for(AgendaItem agendaItem : getMeetingsExtension().getAgenda()) {
			draftSlide(agendaItem);
		}
		draftBackupsSlide();
	}
	
	protected void draftBackupsSlide() throws IOException {
		XMLSlideShow presentation = initPresentation();
		XSLFSlideLayout layout = getSlideLayout(presentation,"Section");
		XSLFSlide slide = presentation.createSlide(layout);
		setShapeText(slide,"Title","Backups");
		String filename = "backups.pptx";
		File output = new File(getProject().getBuildDir(),filename);
		OutputStream oStream = new FileOutputStream(output);
		presentation.write(oStream);
		oStream.close();
	}

	protected void draftAgendaSlide() throws IOException {
		XMLSlideShow presentation = initPresentation();
		XSLFSlideLayout layout = getSlideLayout(presentation,"Title and Content");
		XSLFSlide slide = presentation.createSlide(layout);
		XSLFTextShape content = (XSLFTextShape) getShape(slide,"Content");
		for(AgendaItem agendaItem : getMeetingsExtension().getAgenda()) {
			content.addNewTextParagraph().addNewTextRun().setText(agendaItem.getText());
		}
		String filename = "agenda.pptx";
		File output = new File(getProject().getBuildDir(),filename);
		OutputStream oStream = new FileOutputStream(output);
		presentation.write(oStream);
		oStream.close();
	}

	protected void draftSlide(AgendaItem agendaItem) throws IOException {
		XMLSlideShow presentation = initPresentation();
		switch(agendaItem.getLayout()) {
		default:
			draftContentSlide(presentation,agendaItem);
		}
		String filename = agendaItem.getName() + ".pptx";
		File output = new File(getProject().getBuildDir(),filename);
		OutputStream oStream = new FileOutputStream(output);
		presentation.write(oStream);
		oStream.close();
	}

	protected void draftTitleSlide() throws IOException {
		XMLSlideShow presentation = initPresentation();
		XSLFSlideLayout layout = getSlideLayout(presentation,"Title");
		XSLFSlide slide = presentation.createSlide(layout);
		String title = getMeetingsExtension().getName();
		setShapeText(slide,"Title",title);
		String subtitle = getMeetingsExtension().getDate();
		setShapeText(slide,"Subtitle",subtitle);
		String filename = "title.pptx";
		File output = new File(getProject().getBuildDir(),filename);
		OutputStream oStream = new FileOutputStream(output);
		presentation.write(oStream);
		oStream.close();
	}

	protected void draftContentSlide(XMLSlideShow presentation, AgendaItem agendaItem) {
		XSLFSlideLayout layout = getSlideLayout(presentation,"Content and Title");
		XSLFSlide slide = presentation.createSlide(layout);
		setShapeText(slide,"Title",agendaItem.getText());
		if(agendaItem.getSubItems()!=null) {
			XSLFTextShape content = (XSLFTextShape) getShape(slide,"Content");
			for(AgendaItem subItem : agendaItem.getSubItems()) {
				content.addNewTextParagraph().addNewTextRun().
					setText(subItem.getText());
			}
		}
	}

	@Input //TODO:how to support files on classpath???
	public URI getTemplate() {
		if(template!=null)
			return template;
		else
			return getMeetingsExtension().getAgendaTemplate();
	}
	
	@OutputFiles
	public Collection<File> getOutputFiles() {
		Set<File> results = new HashSet<File>();
		File dir = getProject().getBuildDir();
		for(AgendaItem agendaItem : getMeetingsExtension().getAgenda()) {
			File file = new File(dir,agendaItem.getName() + ".pptx");
			results.add(file);
		}
		return results;
	}
	
	protected MeetingsPluginExtension getMeetingsExtension() {
		return (MeetingsPluginExtension)getProject().
				getExtensions().findByName("meeting");
	}

	public void setTemplate(Object object) {
		template = getProject().uri(object);
	}
	
	protected XMLSlideShow initPresentation() throws IOException {
		URL urlTemplate = new URL(null,getTemplate().toString(), 
			new URLStreamHandler(getClass().getClassLoader()));
		InputStream iStream = urlTemplate.openStream();
		XMLSlideShow result = new XMLSlideShow(iStream);
		iStream.close();
		return result;
	}
}
