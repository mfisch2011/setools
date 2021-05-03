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
package setools.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import org.apache.commons.io.FileUtils;

/**
 * TODO:
 */
public class ClasspathUtils {

	@SuppressWarnings("rawtypes")
	public static void copyResources(Class resource, String pathname,final File dir) throws IOException {
		URL url = resource.getProtectionDomain().getCodeSource().getLocation();
		switch(getFileExtension(url)) {
		case "jar":
			String rootPath = url.getPath();
			JarFile jarFile = new JarFile(rootPath);
			Enumeration<JarEntry> enumOfJar = jarFile.entries();
			Path basePath = Paths.get(dir.getAbsolutePath());
			while (enumOfJar.hasMoreElements()) {
				JarEntry jarEntry = enumOfJar.nextElement();
				String name = jarEntry.getName();
				if(name.startsWith(pathname)) {
					ZipEntry zipEntry = jarFile.getEntry(name);
					InputStream stream = jarFile.getInputStream(zipEntry);
					Path destPath = basePath.resolve(name);
					File parent = destPath.toFile().getParentFile();
					if(!parent.exists())
						Files.createDirectories(parent.toPath());
					Files.copy(stream, destPath);
					stream.close();
				}
			}
			break;
		default:
			File srcDir = new File(url.getPath());
			FileUtils.copyDirectory(srcDir,dir);
			break;
		}	
	}

	private static String getFileExtension(URL url) {
		String filename = url.getPath();
		int index = filename.lastIndexOf('/');
		filename = filename.substring(index);
		index = filename.lastIndexOf('.');
		if(index>0)
			return filename.substring(index+1);
		else
			return "";
	}

}
