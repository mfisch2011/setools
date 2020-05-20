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
package setools.gradle.plugins.internal;

import javax.inject.Inject;

import org.gradle.api.Action;
import org.gradle.api.Project;
import org.gradle.api.file.SourceDirectorySet;
import org.gradle.api.internal.plugins.DslObject;
import org.gradle.api.internal.tasks.DefaultSourceSet;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.plugins.JavaPluginConvention;
import org.gradle.api.reflect.HasPublicType;
import org.gradle.api.reflect.TypeOf;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.SourceSetContainer;
import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.plugins.UmlSourceSetExtension;

/**
 * TODO:
 */
public class DefaultUmlSourceSetExtension implements UmlSourceSetExtension,HasPublicType {

	/**
	 * TODO:
	 */
	protected final SourceDirectorySet umlSource;
	
	/**
	 * TODO:
	 */
	protected final SourceDirectorySet allUml;

	/** TODO:
	 * @param displayName
	 * @param objectFactory
	 */
	@Inject
	public DefaultUmlSourceSetExtension(String displayName,ObjectFactory objectFactory) {
		umlSource = objectFactory.sourceDirectorySet(UmlSourceSetExtension.SOURCE_NAME, displayName + " UML Source");
		umlSource.getFilter().include("**/*.uml","**/*.UML","**/*.xmi","**/*.XMI");
		allUml = objectFactory.sourceDirectorySet("all" + UmlSourceSetExtension.SOURCE_NAME, displayName + " UML source");
		allUml.source(umlSource);
		umlSource.getFilter().include("**/*.uml","**/*.UML","**/*.xmi","**/*.XMI");
	}

	/** TODO:
	 * @param project
	 */
	public static void register(Project project) {
		getSourceSets(project).all(new Action<SourceSet>() {

			@Override
			public void execute(SourceSet sourceSet) {
				String displayName = ((DefaultSourceSet)sourceSet).getDisplayName();
				DefaultUmlSourceSetExtension umlSource = new DefaultUmlSourceSetExtension(displayName,project.getObjects());
				new DslObject(sourceSet).getConvention().getPlugins().put(UmlSourceSetExtension.SOURCE_NAME, umlSource);
			}
			
		});
	}
	
	@Override
    public SourceDirectorySet getUml() {
        return umlSource;
    }

    @SuppressWarnings("rawtypes")
	@Override
    public UmlSourceSetExtension uml(Closure closure) {
        ConfigureUtil.configure(closure, getUml());
        return this;
    }

    @Override
    public UmlSourceSetExtension uml(Action<? super SourceDirectorySet> action) {
        action.execute(getUml());
        return this;
    }

    @Override
    public SourceDirectorySet getAllUml() {
        return allUml;
    }

    @Override
    public TypeOf<?> getPublicType() {
        return TypeOf.typeOf(UmlSourceSetExtension.class);
    }

	/** TODO:
	 * @return
	 */
	protected static SourceSetContainer getSourceSets(Project project) {
		return project.getConvention().getPlugin(
			JavaPluginConvention.class).getSourceSets();
	}
}
