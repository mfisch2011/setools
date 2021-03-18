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
package setools.gradle.meetings.dsl;

import groovy.lang.Closure;

/**
 * TODO:documentation...
 */
public interface Topic {
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getName();
	
	/**
	 * TODO:documentation...
	 * @param name
	 */
	public void setName(String name);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getNotes();
	
	/**
	 * TODO:documentation...
	 * @param text
	 */
	public void setNotes(String text);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getPresenter();
	
	/**
	 * TODO:documentation...
	 * @param name
	 */
	public void setPresenter(String name);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public AgendaHandler subTopics();
	
	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public AgendaHandler subTopics(Closure closure);
	
}
