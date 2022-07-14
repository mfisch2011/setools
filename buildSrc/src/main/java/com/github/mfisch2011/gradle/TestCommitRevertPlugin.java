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
package com.github.mfisch2011.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.testing.Test;

import groovy.lang.Closure;

/**
 * TODO:
 */
public class TestCommitRevertPlugin implements Plugin<Project> {
	
	@Override
	public void apply(Project project) {
		project.getExtensions().create("testCommitRevert", TestCommitRevertExtension.class);
		project.getTasks().withType(Test.class,configTest());
	}
	
	/**
	 * TODO:
	 */
	protected Action<Test> configTest() {
		return new Action<Test>() {
			@Override
			public void execute(Test task) {
				task.afterSuite(new TestCommitRevertClosure(task));
			}
		}
	}
}