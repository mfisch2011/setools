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
import org.gradle.api.internal.project.ProjectInternal;

/**
 * @author matt
 *
 */
public abstract class AbstractPlugin implements Plugin<ProjectInternal> {

	public static final String PLUGIN_EXT = null;
	
	protected static final Class<?> EXTENSION_TYPE = null;

	@Override
	public void apply(ProjectInternal project) {
		applyBasePlugins(project);
		configureConvention(project);
		configureExtension(project);
		configureTasks(project);
	}

	protected abstract void configureTasks(ProjectInternal project);

	protected void configureExtension(ProjectInternal project) {
		if(EXTENSION_TYPE!=null)
			project.getExtensions().create(PLUGIN_EXT,EXTENSION_TYPE,project);
	}

	protected void configureConvention(ProjectInternal project) {
		//stub for children
	}

	protected void applyBasePlugins(ProjectInternal project) {
		//stub for children
	}

}
