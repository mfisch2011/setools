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

import org.gradle.api.Action;
import org.gradle.api.Project;
import org.gradle.api.Task;
import setools.gradle.meetings.tasks.internal.DefaultGenerateSlide;
import setools.gradle.util.Factory;

import setools.gradle.meetings.tasks.GenerateSlide;

/**
 * TODO:
 */
public class DefaultTopicSlideFactory implements Factory<Task> {
	
	/**
	 * TODO:
	 */
	protected final Project project;
	
	/**
	 * TODO:
	 * @param project
	 */
	@Inject
	public DefaultTopicSlideFactory(Project project) {
		this.project = project;
	}

	@Override
	public Task build() {
		GenerateSlide task = project.getObjects().newInstance(DefaultGenerateSlide.class);
		return task;
	}

	@Override
	public Task build(Action<Task> action) {
		GenerateSlide task = project.getObjects().newInstance(DefaultGenerateSlide.class);
		action.execute(task);
		return task;
	}

}
