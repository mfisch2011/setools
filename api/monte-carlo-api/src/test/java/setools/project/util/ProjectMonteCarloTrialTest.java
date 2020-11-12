/**
 * 
 */
package setools.project.util;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * @author matt
 *
 */
public class ProjectMonteCarloTrialTest {
	
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	
	protected Path basePath = null;
	
	@Before
	public void setup() {
		basePath = folder.getRoot().toPath();
	}
	
	@After
	public void cleanup() {
		folder.delete();
	}

	/**
	 * Test method for {@link setools.project.util.ProjectMonteCarloTrial#call()}.
	 * @throws Exception 
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testTrial() throws Exception {
		copyResources(basePath,"Project1.pod");
		Date start = new Date(2020-1900,10,10);
		Date end = new Date(2020-1900,10,30);
		int step = Calendar.DATE;
		Set<File> inputs = new HashSet<File>();
		inputs.add(new File(basePath.toFile(),"Project1.pod"));
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		ProjectMonteCarloTrial trial = new ProjectMonteCarloTrial(0,inputs,start,end,step);
		File output = trial.call();
		assertNotNull(output);
		BufferedReader reader = new BufferedReader(new FileReader(output));
		assertEquals("       start, 10/11/20, 11/11/20, 12/11/20, 13/11/20, 14/11/20, 15/11/20, 16/11/20, 17/11/20, 18/11/20, 19/11/20, 20/11/20, 21/11/20, 22/11/20, 23/11/20, 24/11/20, 25/11/20, 26/11/20, 27/11/20, 28/11/20, 29/11/20",reader.readLine());
		assertEquals("         end, 11/11/20, 12/11/20, 13/11/20, 14/11/20, 15/11/20, 16/11/20, 17/11/20, 18/11/20, 19/11/20, 20/11/20, 21/11/20, 22/11/20, 23/11/20, 24/11/20, 25/11/20, 26/11/20, 27/11/20, 28/11/20, 29/11/20, 30/11/20",reader.readLine());
		
		//TODO:how to validate random trial output...
		reader.close();
	}

	/**
	 * TODO:documentation...
	 * @param dir
	 * @param resources
	 * @throws IOException
	 * 
	 * TODO:move to utility library...
	 */
	protected void copyResources(Path dir,String...resources) throws IOException {
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
