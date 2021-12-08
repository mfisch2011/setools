/**
 * Copyright 2021 M. Fischer <mfisch2011@gmail.com>
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
package setools.gradle.meetings.dsl.internal;

import javax.inject.Inject;

import org.gradle.api.Project;
import org.gradle.internal.metaobject.MethodAccess;
import org.gradle.internal.metaobject.MethodMixIn;

import setools.gradle.meetings.dsl.Meeting;
import setools.gradle.meetings.dsl.MeetingsHandler;
import setools.gradle.meetings.plugins.MeetingsFactoryServicePlugin;
import setools.gradle.util.AbstractHandler;

/**
 * TODO:
 */
public class DefaultMeetingsHandler extends AbstractHandler<Meeting> implements MeetingsHandler,MethodMixIn {
	
	/**
	 * TODO:
	 */
	protected final MethodAccess methodAccess;

	/**
	 * TODO: add documentation...
	 * @param project - {@link Project} that owns the handler
	 */
	@Inject
	public DefaultMeetingsHandler(Project project) {
		MeetingsFactoryServicePlugin factories = project.getPlugins().getAt(MeetingsFactoryServicePlugin.class);
		this.methodAccess = new WrappedFactoryMethodAccess<Meeting>(factories,this);
	}

	@Override
	public MethodAccess getAdditionalMethods() {
		return methodAccess;
	}
}
