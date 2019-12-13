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
package setools.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import setools.gradle.internal.DefaultMBSEPluginExtension;

/**
 * @author matt
 *
 */
public class MBSEPlugin implements Plugin<Project> {

	public static final String PLUGIN_EXT = "mbse";

	@Override
	public void apply(Project project) {
		//TODO:apply base plugin???
		configurePluginExtension(project);
		configureSourceSets(project);
		configureTasks(project);
	}

	protected void configureTasks(Project project) {
		// TODO Auto-generated method stub
		
	}

	protected void configureSourceSets(Project project) {
		// TODO Auto-generated method stub
		
	}

	protected MBSEPluginExtension configurePluginExtension(Project project) {
		return project.getExtensions().create(PLUGIN_EXT, 
				DefaultMBSEPluginExtension.class, project);
	}

}
