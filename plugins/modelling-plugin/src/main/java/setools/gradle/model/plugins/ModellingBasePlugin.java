/**
 * Copyright 2022 M. Fischer <mfisch2011@gmail.com>
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
package setools.gradle.model.plugins;

import javax.inject.Inject;

import org.gradle.api.model.ObjectFactory;
import org.gradle.api.tasks.SourceSet;
import org.gradle.internal.reflect.Instantiator;

import setools.gradle.model.tasks.ModelSourceDirectorySet;
import setools.gradle.model.tasks.internal.DefaultModelSourceDirectorySet;

/**
 * TODO:
 */
public class ModellingBasePlugin extends AbstractSourceSetPlugin {

	/**
	 * TODO:
	 * @param type
	 * @param name
	 * @param instantiator
	 * @param objectFactory
	 */
	@Inject
	public ModellingBasePlugin(Class<? super SourceSet> type,
			String name, 
			Instantiator instantiator,
			ObjectFactory objectFactory) {
		super(type, name, instantiator, objectFactory);
		extensions.put("uml",DefaultModelSourceDirectorySet.class);
	}
	
}
