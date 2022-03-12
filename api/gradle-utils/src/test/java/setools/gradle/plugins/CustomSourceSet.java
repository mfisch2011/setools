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
package setools.gradle.plugins;

import javax.inject.Inject;

import org.gradle.api.internal.file.FileCollectionFactory;
import org.gradle.api.internal.file.FileResolver;
import org.gradle.api.internal.tasks.DefaultSourceSet;
import org.gradle.api.internal.tasks.DefaultSourceSetOutput;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.tasks.SourceSet;

/**
 * TODO:
 */
public abstract class CustomSourceSet extends DefaultSourceSet implements SourceSet {

	/**
	 * Custom {@link SourceSet} class to test creating custom SourceSets.
	 * 
	 * @param name - name of source set
	 * @param objectFactory - {@link ObjectFactory} for creating objects
	 * @param fileResolver - {@link FileResolver} for resolving files
	 * @param fileCollectionFactory - {@link FileCollectionFactory} for creating {@link FileCollection}s
	 */
	@Inject
	public CustomSourceSet(String name, ObjectFactory objectFactory,FileResolver fileResolver, FileCollectionFactory fileCollectionFactory) {
		super(name, objectFactory);
		DefaultSourceSetOutput output = new DefaultSourceSetOutput(name,fileResolver,fileCollectionFactory);
		setClasses(output);
	}

}
