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

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.UnknownDomainObjectException;
import org.gradle.api.internal.plugins.DslObject;
import org.gradle.api.internal.tasks.DefaultSourceSet;
import org.gradle.api.plugins.JavaPlugin;
import org.gradle.api.plugins.JavaPluginConvention;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.SourceSetContainer;

import setools.gradle.internal.task.DefaultUmlSourceSet;

/**
 * @author matt
 *
 */
public class MBSEBasePlugin implements Plugin<Project> {

	@Override
	public void apply(Project project) {
		//TODO: how to not need this for sourceSets (thanks gradle team)
		project.getPluginManager().apply(JavaPlugin.class);
		configureUmlSourceSetExtension(project);
	}

	protected void configureUmlSourceSetExtension(Project project) {
		SourceSetContainer sourceSets = getSourceSets(project);
		sourceSets.all(new Action<SourceSet>() {

			@Override
			public void execute(SourceSet sourceSet) {
				String displayName = ((DefaultSourceSet)sourceSet).getDisplayName();
				DefaultUmlSourceSet umlSourceSet = new DefaultUmlSourceSet(
						"uml",displayName,project.getObjects());
				new DslObject(sourceSet).getConvention().getPlugins().put("uml", umlSourceSet);
			}
			
		});
	}

	protected SourceSetContainer getSourceSets(Project project) {
		try {
			return project.getConvention().getByType(
					SourceSetContainer.class);
		} catch(UnknownDomainObjectException e) {
			return project.getConvention().getByType(
					JavaPluginConvention.class).getSourceSets();
		}
	}

}
