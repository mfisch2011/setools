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
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

import setools.gradle.plugins.AgendaItem;
import setools.gradle.plugins.MeetingsPluginExtension;
import setools.util.URLStreamHandler;

/**
 * @author matt
 *
 */
public class OOXMLDraftMinutes extends AbstractDraftMinutes {

	protected URI template = null;
	
	protected File output = new File("minutes.docx");
	
	//TODO:how to abstract this???
	@TaskAction
	public void draftMinutes() throws IOException {
		XWPFDocument document = initDocument();
		trimParagraphs(document);
		insertTitle(document);
		insertDateTimeAndLocation(document);
		insertAttendees(document);
		insertAgendaItems(document);
		File output = getOutput();
		OutputStream oStream = new FileOutputStream(output);
		document.write(oStream);
		oStream.close();
	}
	
	protected void trimParagraphs(XWPFDocument document) {
		while(document.getParagraphs().size()>6) {
			document.removeBodyElement(6);
		}
	}

	protected void insertTitle(XWPFDocument document) {
		String name = getMeetingsExtension().getName();
		if(name!=null)
			document.getParagraphs().get(0).createRun().
			setText(getMeetingsExtension().getName());
	}

	protected void insertDateTimeAndLocation(XWPFDocument document) {
		String text = "A meeting ";
		String name = getMeetingsExtension().getName();
		if(name!=null && !name.isEmpty())
			text += "of the " + name + " was held ";
		else
			text += "was held ";
		String location = getMeetingsExtension().getLocation();
		if(location!=null && !location.isEmpty())
			text += "in " + location + " ";
		
		String date = getMeetingsExtension().getDate();
		if(date!=null && !date.isEmpty())
			text += "on " + date + " ";
		
		String time = getMeetingsExtension().getTime();
		if(time!=null && !time.isEmpty())
			text += "at " + time;
		text += ".";
		document.getParagraphs().get(2).createRun().setText(text);
	}

	protected void insertAttendees(XWPFDocument document) {
		String text = "";
		for(String attendee : getMeetingsExtension().getAttendees())
			text += ", " + attendee;
		if(!text.isEmpty())
			text = text.substring(2);
		document.getParagraphs().get(4).createRun().setText(text);
	}
	
	protected void insertAgendaItems(XWPFDocument document) {
		for(AgendaItem agendaItem : getMeetingsExtension().getAgenda())
			insertAgendaItem(document,0,agendaItem);
	}

	@Input //TODO:how to support files on classpath???
	public URI getTemplate() {
		if(template!=null)
			return template;
		else
			return getMeetingsExtension().getMinutesTemplate();
	}
	
	@OutputFile
	public File getOutput() {
		if(output.isAbsolute())
			return output;
		else {
			File dir = getProject().getBuildDir();
			return new File(dir,output.getName());
		}
	}
	
	public void setOutput(Object object) {
		output = getProject().file(object);
	}
	
	protected MeetingsPluginExtension getMeetingsExtension() {
		return (MeetingsPluginExtension)getProject().
				getExtensions().findByName("meeting");
	}

	public void setTemplate(Object object) {
		template = getProject().uri(object);
	}
	
	protected XWPFDocument initDocument() throws IOException {
		URL urlTemplate = new URL(null,getTemplate().toString(), 
			new URLStreamHandler(getClass().getClassLoader()));
		InputStream iStream = urlTemplate.openStream();
		XWPFDocument result = new XWPFDocument(iStream);
		iStream.close();
		return result;
	}

	protected void insertAgendaItem(XWPFDocument document,int level,AgendaItem agendaItem) {
		XWPFParagraph para = document.createParagraph();
		para.setStyle(String.format("Heading %d",level+1));
		para.setNumILvl(BigInteger.valueOf(level));
		String text = agendaItem.getText();
		para.createRun().setText(text);
		para = document.createParagraph();
		para.setStyle("Text Body");
		if(agendaItem.getSubItems()!=null) {
			for(AgendaItem subItem : agendaItem.getSubItems())
				insertAgendaItem(document,level+1,subItem);
		}
	}
}
