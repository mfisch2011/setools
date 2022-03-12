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

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.gradle.api.Plugin;
import org.gradle.api.internal.project.ProjectInternal;
import org.gradle.api.internal.tasks.DefaultSourceSet;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.plugins.JavaBasePlugin;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.SourceSetContainer;
import org.gradle.internal.reflect.Instantiator;
import org.gradle.internal.service.ServiceRegistry;

import setools.gradle.tasks.SourceSetExtensionConfigAction;

/**
 * TODO:
 */
public class AbstractSourceSetPlugin implements Plugin<ProjectInternal> {
	
	/**
	 * {@link Class} with type of source set to create.
	 */
	protected final Class<? extends SourceSet> sourceSetType;
	
	/**
	 * Extensions to create for source set(s).
	 */
	protected final Map<String,Class<?>> extensions =
		new HashMap<String,Class<?>>();

	/**
	 * Name of new {@link SourceSet} to create.
	 */
	protected final String sourceSetName;

	/**
	 * Newly created {@link SourceSet}.
	 */
	private SourceSet sourceSet = null;

	/**
	 * {@link Instantiator} used to create new {@link SourceSet}s and 
	 * inject parameters at construction.
	 */
	protected final Instantiator instantiator;

	/**
	 * TODO:
	 */
	protected final ServiceRegistry services;
	
	/**
	 * Get the newly created SourceSet.
	 * @return - {@link SourceSet} created
	 */
	protected SourceSet getSourceSet() {
		return sourceSet;
	}

	/**
	 * Constructor for an AbstractSourceSetPlugin.
	 * 
	 * @param type - {@link Class} of {@link SourceSet} to create.  null 
	 * will create {@link DefaultSourceSet}.
	 * 
	 * @param name - {@link String} with name of the new {@link SourceSet}
	 * @param services - {@link ServiceRegistry} services for configuration
	 */
	@Inject
	public AbstractSourceSetPlugin(Class<? extends SourceSet> type,String name,ServiceRegistry services) {
		this.sourceSetType = type;
		this.sourceSetName = name;
		this.instantiator = services.get(Instantiator.class);
		this.services = services;
	}
	
	/**
	 * TODO:
	 * @param sourceSets - {@link SourceSetContainer} to add {@link SourceSet} to
	 * @param type - {@link Class} of {@link SourceSet} to create
	 * @param name - {@link String} with name of new {@link SourceSet}
	 * @return {@link SourceSet} created
	 */
	protected SourceSet addSourceSet(SourceSetContainer sourceSets,
			ObjectFactory objectFactory,
			Class<? extends SourceSet> type,
			String name,
			ServiceRegistry services) {
		if(type==null) {
			return sourceSets.create(name);
		} else {
			SourceSet sourceSet = (SourceSet) instantiator.newInstance(type, name,objectFactory);
			sourceSets.add(sourceSet);
			//TODO:configure classes or leave that to the SourceSet ????
	        return sourceSet;
		}
	}

	@Override
	public void apply(ProjectInternal project) {
		project.getPluginManager().apply(JavaBasePlugin.class);
		SourceSetContainer sourceSets = project.getExtensions()
				.getByType(JavaPluginExtension.class).getSourceSets();
		if(sourceSetName!=null) {
			sourceSet = addSourceSet(sourceSets,project.getObjects(),sourceSetType,sourceSetName,project.getServices());
		}
		//TODO:how to register callbacks to add SourceDirectorySet(s) after all SourceSets are registered ???
		if(sourceSet==null) {
			//add SourceDirectorySet(s) to all SourceSets
			addSourceDirectorySets(sourceSets,project.getServices());
		} else {
			//add SourceDirectorySet(s) to only new sourceSet
			addSourceDirectorySets(sourceSet,project.getServices());
		}
	}

	/**
	 * TODO:
	 * @param sourceSet - {@link SourceSet} to add extensions to
	 * @param services - {@link ServiceRegistry} for configuration 
	 */
	protected void addSourceDirectorySets(SourceSet sourceSet, ServiceRegistry services) {
		for(Entry<String, Class<?>> entry : extensions.entrySet()) {
			String name = entry.getKey();
			Class<?> extension = entry.getValue();
			//TODO:do we want to use instantiator to create Action to enable injection ???
			SourceSetExtensionConfigAction action = new SourceSetExtensionConfigAction(name,extension,services);
			action.execute(sourceSet);
		}
	}

	/**
	 * TODO:
	 * @param sourceSets - {@link SourceSetContainer} with 
	 * {@link SourceSet}(s) to add extensions to
	 * @param services - {@link ServiceRegistry} for configuration 
	 */
	protected void addSourceDirectorySets(SourceSetContainer sourceSets, ServiceRegistry services) {
		for(Entry<String, Class<?>> entry : extensions.entrySet()) {
			String name = entry.getKey();
			Class<?> extension = entry.getValue();
			//TODO:do we want to use instantiator to create Action to enable injection ???
			sourceSets.all(new SourceSetExtensionConfigAction(name,extension,services));
		}
	}

}
