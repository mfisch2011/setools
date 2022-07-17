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
package com.github.mfisch2011.setools.gradle.meetings.plugin;

import javax.inject.Inject;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.internal.file.FileCollectionFactory;
import org.gradle.api.internal.file.FileResolver;
import org.gradle.api.internal.project.ProjectInternal;
import org.gradle.api.internal.tasks.DefaultSourceSetOutput;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.plugins.JavaBasePlugin;
import org.gradle.api.tasks.SourceSetContainer;
import org.gradle.internal.reflect.Instantiator;

import com.github.mfisch2011.setools.gradle.meetings.tasks.internal.DefaultMeetingsSourceSet;

/**
 * TODO:
 */
public class MeetingsBasePlugin implements Plugin<ProjectInternal> {
	
	/**
	 * TODO:
	 */
	private Instantiator instantiator;
	
	/**
	 * TODO:
	 */
	private FileResolver fileResolver;

	/**
	 * TODO:
	 */
	private FileCollectionFactory fileCollectionFactory;

	private ObjectFactory objectFactory;

	/**
	 * TODO:
	 * @param instantiator - TODO:
	 * @param objectFactory - TODO:
	 * @param fileResolver - TODO:
	 * @param fileCollectionFactory - TODO:
	 */
	@Inject
	public MeetingsBasePlugin(Instantiator instantiator,ObjectFactory objectFactory,FileResolver fileResolver,FileCollectionFactory fileCollectionFactory) {
		this.instantiator = instantiator;
		this.fileResolver = fileResolver;
		this.fileCollectionFactory = fileCollectionFactory;
		this.objectFactory = objectFactory;
	}

	@Override
	public void apply(ProjectInternal project) {
		project.getPluginManager().apply(JavaBasePlugin.class);
		SourceSetContainer sourceSets = getSourceSets(project);
		DefaultMeetingsSourceSet meetingsSource = instantiator.newInstance(DefaultMeetingsSourceSet.class,"meetings",objectFactory);
		meetingsSource.setClasses(instantiator.newInstance(DefaultSourceSetOutput.class, meetingsSource.getDisplayName(), fileResolver, fileCollectionFactory));
		sourceSets.add(meetingsSource);
	}

	/**
	 * TODO: move to utility library...
	 * @param project - TODO:
	 * @return SourceSetContainer
	 */
	public static SourceSetContainer getSourceSets(Project project) {
		Object object = project.getExtensions().getByName("sourceSets");
		return (SourceSetContainer)object;
	}

}
