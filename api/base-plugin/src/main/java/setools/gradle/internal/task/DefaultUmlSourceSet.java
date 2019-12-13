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
package setools.gradle.internal.task;

import javax.inject.Inject;

import org.gradle.api.Action;
import org.gradle.api.file.SourceDirectorySet;
import org.gradle.api.model.ObjectFactory;
import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.task.UmlSourceSet;

/**
 * @author matt
 *
 */
public class DefaultUmlSourceSet implements UmlSourceSet {

	private final SourceDirectorySet source;
	private final SourceDirectorySet allSource;

	@Inject
	public DefaultUmlSourceSet(String name,String displayName,ObjectFactory objectFactory) {
		source = objectFactory.sourceDirectorySet(name, displayName + " UML source models");
		source.getFilter().include("**/*.uml","**/*.UML","**/*.xmi","**/*.XMI");
		allSource = objectFactory.sourceDirectorySet("all"+name, displayName + " UML source models");
		allSource.source(source);
		allSource.getFilter().include("**/*.uml","**/*.UML","**/*.xmi","**/*.XMI");
	}
	
	@Override
	public SourceDirectorySet uml() {
		return source;
	}

	@Override
	public SourceDirectorySet allUml() {
		return allSource;
	}

	@Override
	public UmlSourceSet uml(@SuppressWarnings("rawtypes") Closure closure) {
		ConfigureUtil.configure(closure, source);
		return this;
	}

	@Override
	public UmlSourceSet uml(Action<SourceDirectorySet> action) {
		action.execute(source);
		return this;
	}

}
