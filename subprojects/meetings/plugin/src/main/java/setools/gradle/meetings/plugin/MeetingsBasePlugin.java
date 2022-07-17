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
package setools.gradle.meetings.plugin;

import javax.inject.Inject;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.internal.file.FileCollectionFactory;
import org.gradle.api.internal.file.FileResolver;
import org.gradle.api.internal.tasks.DefaultSourceSet;
import org.gradle.api.internal.tasks.DefaultSourceSetOutput;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.plugins.JavaBasePlugin;
import org.gradle.api.tasks.SourceSetContainer;
import org.gradle.internal.reflect.Instantiator;

import setools.gradle.meetings.tasks.MeetingsSourceSet;
import setools.gradle.meetings.tasks.internal.DefaultMeetingsSourceSet;

/**
 * TODO:
 */
public class MeetingsBasePlugin implements Plugin<Project> {
	
	private FileResolver fileResolver;
	private FileCollectionFactory fileCollectionFactory;
	private Instantiator instantiator;
	private ObjectFactory objectFactory;

	@Inject
	public MeetingsBasePlugin(FileResolver fileResolver, FileCollectionFactory fileCollectionFactory, Instantiator instantiator, ObjectFactory objectFactory) {
		this.fileResolver = fileResolver;
		this.fileCollectionFactory = fileCollectionFactory;
		this.instantiator = instantiator;
		this.objectFactory = objectFactory;
	}

	@Override
	public void apply(Project project) {
		project.getPluginManager().apply(JavaBasePlugin.class);
		DefaultMeetingsSourceSet sourceSet = instantiator.newInstance(DefaultMeetingsSourceSet.class,"meetings",objectFactory);
		sourceSet.setClasses(instantiator.newInstance(DefaultSourceSetOutput.class,sourceSet.getDisplayName(), fileResolver, fileCollectionFactory));
		project.getExtensions().getByType(SourceSetContainer.class).add(sourceSet);
		// TODO Auto-generated method stub
		
	}

}
