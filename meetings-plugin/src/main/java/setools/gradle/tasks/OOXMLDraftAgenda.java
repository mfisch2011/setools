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
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlCursor;
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
public class OOXMLDraftAgenda extends AbstractDraftAgenda {
	
	protected URI template = null;
	
	protected File output = new File("agenda.docx");
	
	//TODO:how to abstract this???
	@TaskAction
	public void draftAgenda() throws IOException {
		XWPFDocument document = initDocument();
		insertDateAndTime(document);
		insertLocation(document);
		insertAttendees(document);
		insertAgendaItems(document);
		File output = getOutput();
		OutputStream oStream = new FileOutputStream(output);
		document.write(oStream);
		oStream.close();
	}
	
	protected void insertDateAndTime(XWPFDocument document) {
		System.out.println("ENTER insertDateAndTime");
		XWPFTable table = document.getTableArray(0);
		XWPFTableRow row = table.getRow(2);
		XWPFTableCell cell = row.getCell(1);
		XWPFParagraph para = cell.getParagraphs().get(0);
		//para.getRuns().clear();
		String text = getMeetingsExtension().getDate();
		if(getMeetingsExtension().getTime()!=null)
			text += " at " + getMeetingsExtension().getTime();
		para.createRun().setText(text);
		System.out.println("EXIT insertDateAndTime");
	}

	protected void insertLocation(XWPFDocument document) {
		System.out.println("ENTER insertLocation");
		XWPFTable table = document.getTableArray(0);
		XWPFTableRow row = table.getRow(2);
		XWPFTableCell cell = row.getCell(1);
		XWPFParagraph para = cell.getParagraphs().get(0);
		//para.getRuns().clear();
		para.createRun().setText(getMeetingsExtension().getLocation());
		System.out.println("EXIT insertLocation");
	}

	protected void insertAttendees(XWPFDocument document) {
		System.out.println("ENTER insertAttendees");
		XWPFTable table = document.getTableArray(0);
		XWPFTableRow row = table.getRow(2);
		XWPFTableCell cell = row.getCell(1);
		XWPFParagraph para = cell.getParagraphs().get(0);
		String text = "";
		for(String attendee : getMeetingsExtension().getAttendees())
			text += ", " + attendee;
		if(!text.isEmpty())
			text = text.substring(2);
		//para.getRuns().clear();
		para.createRun().setText(text);	
		System.out.println("EXIT insertAttendees");
	}
	
	protected void insertAgendaItems(XWPFDocument document) {
		XmlCursor cursor = getInsertAgendaCursor();
		for(AgendaItem agendaItem : getMeetingsExtension().getAgenda())
			insertAgendaItem(document,0,cursor,agendaItem);
	}

	protected XmlCursor getInsertAgendaCursor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Input //TODO:how to support files on classpath???
	public URI getTemplate() {
		if(template!=null)
			return template;
		else
			return getMeetingsExtension().getAgendaTemplate();
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

	protected void insertAgendaItem(XWPFDocument document,int level,XmlCursor cursor,AgendaItem agendaItem) {
		XWPFParagraph para = document.insertNewParagraph(cursor);
		String text = agendaItem.getText();
		//TODO:add other information to heading
		para.createRun().setText(text);
		para.setNumILvl(BigInteger.valueOf(level));
		if(agendaItem.getSubItems()!=null) {
			for(AgendaItem subItem : agendaItem.getSubItems())
				insertAgendaItem(document,level+1,cursor,subItem);
		}
	}
}
