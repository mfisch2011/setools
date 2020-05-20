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

/**
 * TODO:
 */
public class ClasspathUtils {

	@SuppressWarnings("rawtypes")
	public static void copyResources(Class resource, String pathname,File dir) throws IOException {
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
					Files.copy(stream, destPath);
					stream.close();
				}
			}
			break;
		default:
			Path path = Paths.get(url.getPath());
			path = Paths.get(path.toString().replace("classes/java","resources")); //TODO:how to handle where Gradle puts resources...
			File source = path.resolve(pathname).toFile();
			if(source.isDirectory()) {
				copyRecursive(source,dir);
			} else {
				Path srcPath = source.toPath();
				Path destPath = Paths.get(dir.getAbsolutePath())
						.resolve(srcPath);
				Files.copy(srcPath,destPath);
			}
		}
		
	}

	private static void copyRecursive(File source, File dir) throws IOException {
		for(File file : dir.listFiles()) {
			if(file.isFile() ) {
				Path srcPath = file.toPath();
				Path destPath = Paths.get(dir.getAbsolutePath())
						.resolve(srcPath);
				System.out.printf("Copying %s to %s%n", srcPath,destPath);
				Files.copy(srcPath,destPath);
			} else if(file.isDirectory())
				copyRecursive(file,dir);
		}
	}

	private static String getFileExtension(URL url) {
		Path path = Paths.get(url.getPath());
		String filename = path.getFileName().toString();
		int index = filename.lastIndexOf('.');
		if(index>0)
			return filename.substring(index+1);
		else
			return "";
	}

}
