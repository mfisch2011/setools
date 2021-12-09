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
package setools.gradle.meetings.tasks.internal;

import java.io.File;
import java.util.Properties;

import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import setools.gradle.meetings.tasks.GenerateDocument;

/**
 * TODO:
 */
public class DefaultGenerateDocument extends DefaultTask implements GenerateDocument {

	/**
	 * TODO:
	 */
	@TaskAction
	public void generate() {
		//TODO:
	}
	
	/**
	 * TODO:
	 */
	protected Object template = null;

	@Override
	public void setTemplate(Object object) {
		template = getProject().uri(object);
		//TODO:catch exception and try getProject().file ???
	}

	@Override
	public Object getTemplate() {
		return template;
	}

	@Override
	public void setOutput(Object object) {
		output = getProject().file(object);
	}
	
	/**
	 * TODO:
	 */
	protected File output = null;

	@Override
	public File getOutput() {
		return output;
	}
	
	/**
	 * TODO:
	 */
	protected final Properties contextProperties = new Properties();

	@Override
	public Properties getContextProperties() {
		return contextProperties;
	}

	@Override
	public Properties context(Action<Properties> action) {
		// TODO Auto-generated method stub
		return null;
	}
}
