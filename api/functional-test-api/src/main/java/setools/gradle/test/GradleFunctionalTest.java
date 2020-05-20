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
package setools.gradle.test;

import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.junit.After;
import org.junit.Before;

/**
 * TODO:
 */
public class GradleFunctionalTest {

	/**
	 * TODO:
	 */
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	
	/**
	 * TODO:
	 */
	protected File dir = folder.getRoot();
	
	/**
	 * TODO:
	 */
	@Before
	public void setup() {
		//TODO:
	}
	
	/**
	 * TODO:
	 */
	@After
	public void cleanup() {
		dir.delete();
	}
	
	/** TODO:
	 * @param pathname
	 * @throws IOException
	 */
	protected void copyProjectResources(String pathname) throws IOException {
		try {
			URL url = getClass().getProtectionDomain().getCodeSource().getLocation();
			JarFile jarFile = new JarFile(url.getPath());
			Enumeration<JarEntry> enumOfJar = jarFile.entries();   
			while (enumOfJar.hasMoreElements()) {
				System.out.println(enumOfJar.nextElement().getName());   
			} 
		} catch(IOException ioe) {
			System.out.println("IOException: " + ioe);
		}
	}
}
