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

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;

import com.github.mfisch2011.velocity.VelocityMergeThread;

import setools.gradle.internal.task.DefaultInitMeetingExtension;

/**
 * @author matt
 *
 */
public class InitMeeting extends DefaultTask {

	public static final String TASK_NAME = "initMeeting";
	
	public static InitMeeting configure(Project project) {
		//project.getExtensions().create(TASK_NAME,DefaultInitMeetingExtension.class,project);
		return project.getTasks().create(TASK_NAME,InitMeeting.class);
	}

	@TaskAction
	public void initMeeting() {
		createSkeletonAgenda();
	}

	protected void createSkeletonAgenda() {
		VelocityMergeThread thread = new VelocityMergeThread(
				getTemplate(),getOutput().getAbsolutePath(),
				getMergedContext(),getMergedEngine());
		thread.call();
	}
	
	protected String template = "templates/latex/agenda.vm";
	
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
	
	protected File output = null;
	
	@OutputFile
	public File getOutput() {
		if(output==null) {
			return null;
		}
		return output;
	}
}
