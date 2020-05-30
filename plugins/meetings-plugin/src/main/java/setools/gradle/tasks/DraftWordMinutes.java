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
package setools.gradle.tasks;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.inject.Inject;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.runtime.resource.loader.FileResourceLoader;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

import setools.gradle.meeting.api.Meeting;

/** 
 * TODO:
 */
public class DraftWordMinutes extends GenerateTask {

	public static final String TASK_NAME = "draftWordMinutes";
	
	/**
	 * TODO:
	 */
	protected final Meeting meeting;

	@Inject
	public DraftWordMinutes(Meeting meeting) {
		this.meeting = meeting;
		String filename = meeting.getName() + " Minutes " + meeting.getDate();
		filename = filename.toLowerCase().replace(' ', '-');
		setDestination(filename);
	}
	
	@TaskAction
	public void draftMinutes() throws IOException {
		//TODO:make velocity thread api???
		VelocityEngine engine = configureEngine();
		Template template = engine.getTemplate(getTemplate());
		Writer writer = new FileWriter(getDestination());
		template.merge(configureContext(), writer);
		writer.close();
	}
	
	/**
	 * TODO:
	 * @return
	 */
	protected VelocityContext configureContext() {
		VelocityContext context = new VelocityContext();
		context.put("meeting",meeting);
		//TODO:other configuration....
		return context;
	}

	/**
	 * TODO:
	 * @return
	 */
	protected VelocityEngine configureEngine() {
		VelocityEngine engine = new VelocityEngine();
		engine.setProperty("resource.loader", "relative.file,absolute.file,classpath");
		engine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		engine.setProperty("absolute.file.resource.loader.class", FileResourceLoader.class.getName());
		engine.setProperty("relative.file.resource.loader.class", FileResourceLoader.class.getName());
		engine.setProperty("absolute.file.resource.loader.path","");
		engine.setProperty("relative.file.resource.loader.path",getProject().getProjectDir().getAbsolutePath());
		return engine;
	}

	/**
	 * TODO:
	 */
	protected String template = "templates/velocity/minutes.tex.vm";

	/**
	 * TODO:
	 * @return
	 */
	@Input
	public String getTemplate() {
		return template;
	}
	
	/**
	 * TODO:
	 * @param path
	 */
	public void setTemplate(String path) {
		template = path;
	}
	
}
