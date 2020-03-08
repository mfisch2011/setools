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
package setools.gradle.plugins;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.Test;

import com.github.mfisch2011.gradle.test.utils.GradleFunctionalTest;

import static setools.docs.xwpf.XWLFUtilities.*;

/**
 * @author matt
 *
 */
public class OOXMLMeetingsPluginFunctionalTest extends GradleFunctionalTest {

	/**
	 * Test method for {@link setools.gradle.plugins.AbstractMeetingsPlugin#apply(org.gradle.api.Project)}.
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	@Test
	public void testApply() throws URISyntaxException, IOException {
		copyProjectResources("test-ooxml-meetings-plugin-default");
		BuildResult result = GradleRunner.create()
				.withProjectDir(testProjectDir.getRoot())
				.withPluginClasspath()
				.withArguments("tasks","--all")
				.build();
		assertNotNull(result);
		String output = result.getOutput();
		assertNotNull(output);
		System.out.println(output);
		assertTrue("Missing 'Meeting Tasks' group.",output.contains("Meeting Tasks"));
		assertTrue("Missing 'draftAgenda' task.",output.contains("draftAgenda"));
		assertTrue("Missing 'draftMinutes' task.",output.contains("draftMinutes"));
		assertTrue("Missing 'draftPresentation' task.",output.contains("draftPresentation"));
		assertTrue("Missing 'assemblePresentation' task.",output.contains("assemblePresentation"));
		assertTrue("Missing 'publishPresentation' task.",output.contains("publishPresentation"));
		assertTrue("Missing 'publishMinutes' task.",output.contains("publishMinutes"));
	}
	
	/**
	 * Test method for {@link setools.gradle.plugins.AbstractMeetingsPlugin#apply(org.gradle.api.Project)}.
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	@Test
	public void testDefaultBuild() throws URISyntaxException, IOException {
		copyProjectResources("test-ooxml-meetings-plugin-default");
		BuildResult result = GradleRunner.create()
				.withProjectDir(testProjectDir.getRoot())
				.withPluginClasspath()
				.withArguments("publishMinutes")
				.build();
		assertNotNull(result);
		String output = result.getOutput();
		assertNotNull(output);
		System.out.println(output);
		validateEmptyAgenda();
		validateEmptyMinutes();
		validateEmptyTitleSlide();
		validateEmptyAgendaSlide();
		validateBackupsSlide();
		validateEmptyPresentation();
	}

	protected void validateBackupsSlide() throws IOException {
		File file = new File(testProjectDir.getRoot(),"backups.pptx");
		assertNotNull("Missing backups",file);
		InputStream iStream = new FileInputStream(file);
		XMLSlideShow presentation = new XMLSlideShow(iStream);
		iStream.close();
		XSLFSlide slide = presentation.getSlides().get(0);
		assertNotNull("Malformed backups slide",slide);
		assertText("Title",slide,"Title","Backups");
		presentation.close();
	}

	protected void validateEmptyPresentation() throws IOException {
		File file = new File(testProjectDir.getRoot(),"presentation.pptx");
		assertNotNull("Missing presentation",file);
		InputStream iStream = new FileInputStream(file);
		XMLSlideShow presentation = new XMLSlideShow(iStream);
		iStream.close();
		XSLFSlide slide = presentation.getSlides().get(0);
		assertNotNull("Malformed title slide",slide);
		assertText("Title",slide,"Title","Enter Meeting Name");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String date = formatter.format(new Date());
		assertText("Date",slide,"Subtitle",date);
		slide = presentation.getSlides().get(1);
		assertNotNull("Malformed agenda slide",slide);
		assertText("Title",slide,"Title","Agenda");
		assertText("Agenda",slide,"Content","");
		presentation.close();
	}

	protected void validateEmptyAgendaSlide() throws IOException {
		File file = new File(testProjectDir.getRoot(),"agenda.pptx");
		assertNotNull("Missing agenda",file);
		InputStream iStream = new FileInputStream(file);
		XMLSlideShow presentation = new XMLSlideShow(iStream);
		iStream.close();
		XSLFSlide slide = presentation.getSlides().get(0);
		assertNotNull("Malformed agenda slide",slide);
		assertText("Title",slide,"Title","Agenda");
		assertText("Agenda",slide,"Content","");
		presentation.close();
	}

	protected void validateEmptyTitleSlide() throws IOException {
		File file = new File(testProjectDir.getRoot(),"title.pptx");
		assertNotNull("Missing title",file);
		InputStream iStream = new FileInputStream(file);
		XMLSlideShow presentation = new XMLSlideShow(iStream);
		iStream.close();
		XSLFSlide slide = presentation.getSlides().get(0);
		assertNotNull("Malformed title slide",slide);
		assertText("Title",slide,"Title","Enter Meeting Name");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String date = formatter.format(new Date());
		assertText("Date",slide,"Subtitle",date);
		presentation.close();
	}

	protected void assertText(String msg, XSLFSlide slide, String id, String text) {
		XSLFShape shape = getShape(slide,id);
		assertNotNull(msg + " missing shape '" + id + "'",shape);
		XSLFTextShape textShape = (XSLFTextShape)shape;
		assertEquals(msg + "!" + id + " does not match",textShape.getText());
	}

	protected void validateEmptyMinutes() throws IOException {
		File minutes = new File(testProjectDir.getRoot(),"minutes.docx");
		assertTrue("Missing minutes file.",minutes.exists());
		InputStream iStream = new FileInputStream(minutes);
		XWPFDocument document = new XWPFDocument(iStream);
		iStream.close();
		assertEquals("Incorrect number of minutes paragraphs",6,document.getParagraphs().size());
		assertParagraph("Title Paragraph",document,0,"Title","");
		assertParagraph("Title Paragraph",document,1,"Subtitle","Minutes of Meeting");
		Date timestamp = new Date();
		String date = new SimpleDateFormat("MM/dd/yyyy").format(timestamp);
		String time = new SimpleDateFormat("HH:mm").format(timestamp);
		String tst = String.format("A meeting was held on %s at %s.",date,time);
		assertParagraph("Title Paragraph",document,2,"TextBody",tst);
		assertParagraph("Title Paragraph",document,3,"Subtitle","Present");
		assertParagraph("Title Paragraph",document,4,"TextBody","");
		assertParagraph("Title Paragraph",document,5,"Subtitle","Notes");
		document.close();
	}

	protected void validateEmptyAgenda() throws IOException {
		File agenda = new File(testProjectDir.getRoot(),"agenda.docx");
		assertTrue("Missing agenda file.",agenda.exists());
		InputStream iStream = new FileInputStream(agenda);
		XWPFDocument document = new XWPFDocument(iStream);
		iStream.close();
		XWPFTable table = document.getTables().get(0);
		assertEquals("Malformed metadata table.",3,table.getRows().size());
		assertTableCell("Malformed metadata table.",table,0,0,"Date and Time");
		assertTableCell("Malformed metadata table.",table,1,0,"Location");
		assertTableCell("Malformed metadata table.",table,2,0,"Attendees");
		table = document.getTables().get(1);
		assertEquals("Malformed agenda table.",2,table.getRows().size());
		assertTableCell("Malformed metadata table.",table,0,0,"Item");
		assertTableCell("Malformed metadata table.",table,0,1,"Topic for Discussion");
		assertTableCell("Malformed metadata table.",table,0,2,"Presenter");
		assertTableCell("Malformed metadata table.",table,0,3,"Duration");
		document.close();
	}

	protected void assertParagraph(String msg, XWPFDocument document, int index, String style, String text) {
		XWPFParagraph para = document.getParagraphs().get(index);
		assertNotNull("Missing " + msg,para);
		assertEquals(msg + " has the wrong style",style,para.getStyle());
		assertEquals(msg + " incorrect text",text,para.getText());
	}

	protected void assertTableCell(String msg, XWPFTable table, int row, int col, String text) {
		XWPFTableCell tableCell = table.getRow(row).getCell(col);
		String tst = tableCell.getText();
		assertEquals(msg,text,tst);
	}
	
}
