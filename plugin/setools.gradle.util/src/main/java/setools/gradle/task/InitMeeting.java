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
package setools.gradle.task;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Properties;

import javax.inject.Inject;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.runtime.resource.loader.FileResourceLoader;
import org.gradle.api.DefaultTask;
import org.gradle.api.internal.project.ProjectInternal;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.options.Option;
import com.github.mfisch2011.velocity.VelocityMergeThread;

import setools.gradle.MeetingsPlugin;
import setools.gradle.MeetingsPluginExtension;

/**
 * @author matt
 *
 */
public class InitMeeting extends DefaultTask {

	public static final String TASK_NAME = "initMeeting";
	
	public static InitMeeting configure(ProjectInternal project) {
		//project.getExtensions().create(TASK_NAME,DefaultInitMeetingExtension.class,project);
		return project.getTasks().create(TASK_NAME,InitMeeting.class,project);
	}

	protected final ProjectInternal project;
	
	@Inject
	public InitMeeting(ProjectInternal project) {
		this.project = project;
	}

	@TaskAction
	public void initMeeting() throws IOException {
		createSkeletonAgenda();
	}

	protected void createSkeletonAgenda() throws IOException {
		//TODO:query user for missing input(s)
		VelocityMergeThread thread = new VelocityMergeThread(
				getTemplate(),getOutput().getAbsolutePath(),
				getMergedContext(),getMergedEngine());
		thread.call();
	}
	
	protected VelocityEngine getMergedEngine() {
		Properties properties = new Properties();
		addClasspathResourceLoader(properties);
		addFileResourceLoader(properties,"absolute","");
		//TODO:add templates directory...
		//TODO:add engine properties
		return new VelocityEngine(properties);
	}
	
	protected void addClasspathResourceLoader(Properties properties) {
		String resourceLoader = properties.getProperty("resource.loader");
		if(resourceLoader==null || resourceLoader.isEmpty()) {
			resourceLoader = "classpath";
		} else {
			resourceLoader = "classpath," + resourceLoader;
		}
		properties.put("resource.loader", resourceLoader);
		properties.put("classpath.resource.loader.class",ClasspathResourceLoader.class.getName());
	}

	protected void addFileResourceLoader(Properties properties,String name,String path) {
		String resourceLoader = properties.getProperty("resource.loader");
		if(resourceLoader==null || resourceLoader.isEmpty()) {
			resourceLoader = name + ".file";
		} else {
			resourceLoader = name + ".file," + resourceLoader;
		}
		properties.put("resource.loader", resourceLoader);
		properties.put(name + ".file.resource.loader.class",FileResourceLoader.class.getName());
		properties.put(name + ".file.resource.loader.path",path);
	}
	
	protected VelocityContext getMergedContext() {
		Properties properties = new Properties();
		properties.put("meeting_group",false);
		Object value = getMeetingName();
		if(value!=null) properties.put("name",value);
		value = getMeetingDate();
		if(value!=null) properties.put("date",value);
		return new VelocityContext(properties);
	}

	protected String template = "templates/latex/meeting.build.gradle.vm"; //TODO:make relative to templates directory...
	
	public String getTemplate() {
		return template;
	}
	
	public void setTemplate(String pathname) {
		//TODO:validate pathname
		template = pathname;
	}
	
	public void template(String pathname) {
		setTemplate(pathname);
	}
	
	@OutputFile
	public File getOutput() {
		if(outputDirectory!=null) {
			return project.getFileResolver().newResolver(outputDirectory).
					resolve("build.gradle");
		}
		else
			return null;
	}
	
	protected File outputDirectory = null;
	
	//TODO:what annotation?
	public File getOutputDirectory() {
		return outputDirectory;
	}
	
	@Option(option="directory",description="Project directory")
	public void setOutputDirectory(Object object) {
		outputDirectory = project.file(object);
	}
	
	protected Date meetingDate = null;
	
	@Input
	public String getMeetingDate() {
		Date date = (meetingDate==null) ? new Date() : meetingDate;
		String dateFormat = getPluginExtension().getDateFormat();
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		return format.format(date);
	}
	
	@Option(option="meeting-date",description="Date the meeting will occur")
	public void setMeetingDate(Object object) throws ParseException {
		if(object instanceof Date)
			meetingDate = (Date)object;
		else if(object instanceof String){
			String value = (String)object;
			DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
			LocalDate date = LocalDate.parse(value,formatter);
			meetingDate = java.sql.Date.valueOf(date);
		}
	}
	
	protected String meetingName = null;
	
	@Input
	public String getMeetingName() {
		return (meetingName==null) ? getOutputDirectory().getName() :
			meetingName;
	}
	
	@Option(option="meeting-name",description="Name of the meeting")
	public void setMeetingName(String name) {
		meetingName = name;
	}
	
	protected MeetingsPluginExtension getPluginExtension() {
		return (MeetingsPluginExtension)project.getExtensions().
				getByName(MeetingsPlugin.PLUGIN_EXT);
	}
}
