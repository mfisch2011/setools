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

import java.io.File;

import org.eclipse.jgit.api.Git

import org.gradle.api.tasks.testing.Test;
import org.gradle.api.tasks.testing.TestDescriptor;
import org.gradle.api.tasks.testing.TestResult;

import groovy.lang.Closure;

/**
 * TODO:
 */
public class TestCommitRevertClosure extends Closure {
	
	@Override
	public Object call(TestDescriptor description,TestResult result) {
		if(descriptor.getParent() == null) return null;
		if(result.getFailedTestCount() > 0)
			revert();
		else
			commit();
		return null;
	}
	
	/**
	 * TODO:
	 */
	protected void commit() {
		File gitDir = new File(getProject().getRootDir(),".git");
		Git git = Git.open(gitDir);
		// Stage all files in the repo including new files, excluding deleted files
		git.add().addFilepattern(".").call();
		// Stage all changed files, including deleted files, excluding new files
		git.add().addFilepattern(".").setUpdate(true).call();
		// and then commit the changes.
		git.commit().setMessage("TCR").call();
	}
	
	/**
	 * TODO:
	 */
	protected void revert() {
		File gitDir = new File(getProject().getRootDir(),".git");
		Git git = Git.open(gitDir);
		head = git.getRepository().resolve(Constants.HEAD);
		RevWalk walker = new RevWalk(git.getRepository(),100);
		RevCommit headCommit = walker.parseCommit(head);
		git.revert().include(headCommit).call();
	}
	
	/**
	 * TODO:
	 */
	protected Project getProject() {
		return (Project)getOwner();
	}
	
	/**
	 * TODO:
	 */
	protected Test getTest() {
		return (Test)getThis();
	}
}