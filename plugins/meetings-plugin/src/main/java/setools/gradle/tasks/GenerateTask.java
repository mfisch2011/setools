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

import javax.inject.Inject;

import org.gradle.api.DefaultTask;
import org.gradle.api.internal.file.FileResolver;
import org.gradle.api.tasks.OutputFile;

/**
 * @author matt
 *
 */
public class GenerateTask extends DefaultTask {

	private File destination;

	@Inject
	protected FileResolver getFileResolver() {
		throw new UnsupportedOperationException();
	}

	@OutputFile
	public File getDestination() {
		return (destination==null) ? null : getFileResolver().
				newResolver(getProject().getBuildDir()).
				resolve(destination);
	}

	public void setDestination(Object object) {
		destination = getProject().file(object);
	}
	
}
