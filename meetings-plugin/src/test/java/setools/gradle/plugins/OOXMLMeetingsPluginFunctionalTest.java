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

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.Test;

import com.github.mfisch2011.gradle.test.utils.GradleFunctionalTest;

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
		
		File publishDir = testProjectDir.getRoot(); //default publishes to the project dir
		
		//validate generated agenda
		File agenda = new File(publishDir,"agenda.docx");
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
		
		//validate generated minutes
		File minutes = new File(publishDir,"minutes.docx");
		assertTrue("Missing minutes file.",minutes.exists());
		iStream = new FileInputStream(minutes);
		document = new XWPFDocument(iStream);
		iStream.close();
		assertParagraph("Title Paragraph",document,0,"Title","");
		assertParagraph("Title Paragraph",document,1,"Subtitle","Minutes of Meeting");
		assertParagraph("Title Paragraph",document,2,"Text Body","");
		assertParagraph("Title Paragraph",document,3,"Subtitle","Present");
		assertParagraph("Title Paragraph",document,4,"Text Body","");
		assertParagraph("Title Paragraph",document,5,"Subtitle","Notes");
		document.close();
		
		//TODO:validate generated slides
		
		//TODO:validate assembled presentation
		File presentation = new File(publishDir,"presentation.docx");
		assertTrue("Missing presentation file.",presentation.exists());
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
