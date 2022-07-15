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
import java.io.IOException;

import org.gradle.api.Project;
import org.gradle.api.tasks.testing.Test;
import org.gradle.api.tasks.testing.TestDescriptor;
import org.gradle.api.tasks.testing.TestResult;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;

import groovy.lang.Closure;

public class TestCommitRevertClosure extends Closure<Object> {
	
	/**
	 * TODO:
	 */
	public TestCommitRevertClosure(Project project,Test test) {
		super(project,test);
	}
	
	public void doCall(TestDescriptor descriptor,TestResult results) {
		//only the top-level summary has a null parent
		if(descriptor.getParent() != null) return;
		
		try {
			if(results.getFailedTestCount() > 0)
				revert();
			else
				commit();
			return;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * TODO:
	 */
	protected void revert() throws IOException, GitAPIException {
		File dir = new File(getProject().getRootDir(),".git");
		Git git = Git.open(dir);
		//TODO: why does this revert two commits ???
		Repository repo = git.getRepository();
		RevWalk walker = new RevWalk(repo);
		RevCommit head = walker.parseCommit(repo.resolve(Constants.HEAD));
		git.revert().include(head).call();
		getProject().getLogger().lifecycle("Reverted changes to {}.",head);
	}
	
	/**
	 * TODO:
	 */
	public Project getProject() {
		return (Project)getOwner();
	}
	
	/**
	 * TODO:
	 */
	protected void commit() throws IOException, GitAPIException {
		File dir = new File(getProject().getRootDir(),".git");
		Git git = Git.open(dir);
		
		// Stage all files in the repo including new files, excluding deleted files
		git.add().addFilepattern(".").call();
		// Stage all changed files, including deleted files, excluding new files
		git.add().addFilepattern(".").setUpdate(true).call();
		
		// and then commit the changes.
		RevCommit commit = git.commit().setMessage(commit_message()).call();
		getProject().getLogger().lifecycle("Commited changes.  New commit {}.",commit);
	}
	
	/**
	 * TODO:
	 */
	protected String commit_message() {
		return "TCR"; //TODO:allow config and/or user input...
	}
}