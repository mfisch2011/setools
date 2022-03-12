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
package setools.gradle.tasks;

import org.gradle.api.Action;
import org.gradle.api.internal.tasks.DefaultSourceSet;
import org.gradle.api.tasks.SourceSet;
import org.gradle.internal.service.ServiceRegistry;

/**
 * TODO:
 */
public class SourceSetExtensionConfigAction implements Action<SourceSet> {

	/**
	 * The name of the new extension to create and configure.
	 */
	protected final String name;
	
	/**
	 * {@link Class} type of the new extension to create and configure.
	 */
	protected final Class<?> type;

	/**
	 * {@link ServiceRegistry} for configuration.
	 */
	protected final ServiceRegistry services;

	/**
	 * Create and configure a new extension with name and type.
	 * 
	 * @param name - name for the extension
	 * @param type - {@link Class} of extension to create
	 * @param services 
	 */
	public SourceSetExtensionConfigAction(String name, Class<?> type, ServiceRegistry services) {
		this.name = name;
		this.type = type;
		this.services = services;
	}

	@Override
	public void execute(SourceSet sourceSet) {
		String displayName = ((DefaultSourceSet) sourceSet).getDisplayName();
		sourceSet.getExtensions().create(name, type,displayName);
		//TODO:other configuration ???
	}

}
