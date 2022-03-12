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

import org.gradle.internal.service.ServiceRegistry;

/**
 * TODO:
 */
public class TestCustomWithExtensions extends AbstractSourceSetPlugin {

	/**
	 * Create a test {@link AbstractSourceSetPlugin} that creates a 
	 * {@link DefaultSourceSet} named 'defaultTest' with two extensions 
	 * named 'test1' and 'test2' with types String and Integer respectively.
	 * @param services - {@link ServiceRegistry} for config
	 */
	@Inject
	public TestCustomWithExtensions(ServiceRegistry services) {
		super(null,"defaultTest", services);
		extensions.put("test1", TestExtension1.class);
		extensions.put("test2",TestExtension2.class);
	}
}
