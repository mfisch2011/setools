/**
 * 
 */
package setools.project.util;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * TODO:documentation...
 */
public class ProjectMonteCarloTest {
	
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	
	protected Path basePath = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		basePath = folder.getRoot().toPath();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		folder.delete();
	}

	/**
	 * Test method for {@link setools.project.util.ProjectMonteCarlo#main(java.lang.String[])}.
	 * @throws IOException 
	 */
	@Test
	public void testMain() throws IOException {
		copyResources(basePath,"Project1.pod");
		String start = "2020-11-10"; //TODO:how to support parsing other date formats...
		String end = "2020-11-29"; //TODO:how to support parsing other date formats...
		String step = String.valueOf(Calendar.DATE);
		String project1 = basePath.resolve("Project1.pod").toString();
		Path output = basePath.resolve("output.csv");
		String[] arguments = {"--start",start,"--end",end,"--step",step,"--output",output.toString(),project1};
		ProjectMonteCarlo.main(arguments);
		assertTrue(output.toFile().exists());
		BufferedReader reader = new BufferedReader(new FileReader(output.toFile()));
		//validate Huey
		assertEquals("Statistics for Huey",reader.readLine());
		assertEquals("start, 10/11/20, 11/11/20, 12/11/20, 13/11/20, 14/11/20, 15/11/20, 16/11/20, 17/11/20, 18/11/20, 19/11/20, 20/11/20, 21/11/20, 22/11/20, 23/11/20, 24/11/20, 25/11/20, 26/11/20, 27/11/20, 28/11/20, 29/11/20",reader.readLine());
		assertEquals("end, 11/11/20, 12/11/20, 13/11/20, 14/11/20, 15/11/20, 16/11/20, 17/11/20, 18/11/20, 19/11/20, 20/11/20, 21/11/20, 22/11/20, 23/11/20, 24/11/20, 25/11/20, 26/11/20, 27/11/20, 28/11/20, 29/11/20, 30/11/20",reader.readLine());
		reader.readLine(); //TODO:how to validate random mean
		reader.readLine(); //TODO:how to validate random stdev
		reader.readLine(); //TODO:how to validate random max
		assertEquals("",reader.readLine()); //blank line separator
		
		//validate Duey
		assertEquals("Statistics for Duey",reader.readLine());
		assertEquals("start, 10/11/20, 11/11/20, 12/11/20, 13/11/20, 14/11/20, 15/11/20, 16/11/20, 17/11/20, 18/11/20, 19/11/20, 20/11/20, 21/11/20, 22/11/20, 23/11/20, 24/11/20, 25/11/20, 26/11/20, 27/11/20, 28/11/20, 29/11/20",reader.readLine());
		assertEquals("end, 11/11/20, 12/11/20, 13/11/20, 14/11/20, 15/11/20, 16/11/20, 17/11/20, 18/11/20, 19/11/20, 20/11/20, 21/11/20, 22/11/20, 23/11/20, 24/11/20, 25/11/20, 26/11/20, 27/11/20, 28/11/20, 29/11/20, 30/11/20",reader.readLine());
		reader.readLine(); //TODO:how to validate random mean
		reader.readLine(); //TODO:how to validate random stdev
		reader.readLine(); //TODO:how to validate random max
		assertEquals("",reader.readLine()); //blank line separator
		
		//validate Unassigned (why is there an unassigned resource...)
		assertEquals("Statistics for Unassigned",reader.readLine());
		assertEquals("start, 10/11/20, 11/11/20, 12/11/20, 13/11/20, 14/11/20, 15/11/20, 16/11/20, 17/11/20, 18/11/20, 19/11/20, 20/11/20, 21/11/20, 22/11/20, 23/11/20, 24/11/20, 25/11/20, 26/11/20, 27/11/20, 28/11/20, 29/11/20",reader.readLine());
		assertEquals("end, 11/11/20, 12/11/20, 13/11/20, 14/11/20, 15/11/20, 16/11/20, 17/11/20, 18/11/20, 19/11/20, 20/11/20, 21/11/20, 22/11/20, 23/11/20, 24/11/20, 25/11/20, 26/11/20, 27/11/20, 28/11/20, 29/11/20, 30/11/20",reader.readLine());
		reader.readLine(); //TODO:how to validate random mean
		reader.readLine(); //TODO:how to validate random stdev
		reader.readLine(); //TODO:how to validate random max
		assertEquals("",reader.readLine()); //blank line separator
		
		//validate Luey
		assertEquals("Statistics for Luey",reader.readLine());
		assertEquals("start, 10/11/20, 11/11/20, 12/11/20, 13/11/20, 14/11/20, 15/11/20, 16/11/20, 17/11/20, 18/11/20, 19/11/20, 20/11/20, 21/11/20, 22/11/20, 23/11/20, 24/11/20, 25/11/20, 26/11/20, 27/11/20, 28/11/20, 29/11/20",reader.readLine());
		assertEquals("end, 11/11/20, 12/11/20, 13/11/20, 14/11/20, 15/11/20, 16/11/20, 17/11/20, 18/11/20, 19/11/20, 20/11/20, 21/11/20, 22/11/20, 23/11/20, 24/11/20, 25/11/20, 26/11/20, 27/11/20, 28/11/20, 29/11/20, 30/11/20",reader.readLine());
		reader.readLine(); //TODO:how to validate random mean
		reader.readLine(); //TODO:how to validate random stdev
		reader.readLine(); //TODO:how to validate random max
		assertEquals("",reader.readLine()); //blank line separator
		
		reader.close();
	}

	public void copyResources(Path dir,String...resources) throws IOException {
		for(String resource : resources) {
			InputStream stream = getClass().getResourceAsStream(resource);
			Path pathname = dir.resolve(resource);
			Path parent = pathname.getParent();
			if(!parent.toFile().exists())
				Files.createDirectories(parent);
			Files.copy(stream,pathname);
			stream.close();
		}
	}
}
