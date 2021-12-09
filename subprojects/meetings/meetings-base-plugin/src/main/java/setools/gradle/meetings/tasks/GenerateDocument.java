/**
 * Copyright 2021 M. Fischer <mfisch2011@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package setools.gradle.meetings.tasks;

import java.io.File;
import java.util.Properties;

import org.gradle.api.Action;
import org.gradle.api.Task;
import org.gradle.api.tasks.InputFile;
import org.gradle.api.tasks.OutputFile;

/**
 * TODO:
 */
public interface GenerateDocument extends Task {

	/**
	 * TODO:
	 * @param object
	 */
	public void setTemplate(Object object);

	/**
	 * TODO:
	 * @return
	 */
	@InputFile //TODO:what about URLs...
	public Object getTemplate();

	/**
	 * TODO:
	 * @param object
	 */
	public void setOutput(Object object);
	
	/**
	 * TODO:
	 * @return
	 */
	@OutputFile
	public File getOutput();

	/**
	 * TODO:
	 * @return
	 */
	public Properties getContextProperties();
		
	/**
	 * TODO:
	 * @param action
	 * @return
	 */
	public Properties context(Action<Properties> action);
	
}
