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

import java.util.Collection;

import org.gradle.api.Action;

import groovy.lang.Closure;

/**
 * TODO:documentation...
 */
public interface MeetingsHandler extends Collection<Meeting> {

	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getAgendaTemplate();
	
	/**
	 * TODO:documentation...
	 * @param object
	 */
	public void setAgendaTemplate(Object object);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getMinutesTemplate();
	
	/**
	 * TODO:documentation...
	 * @param object
	 */
	public void setMinutesTemplate(Object object);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getPresentationTemplate();
	
	/**
	 * TODO:documentation...
	 * @param object
	 */
	public void setPresentationTemplate(Object object);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getActionItemDatabase();
	
	/**
	 * TODO:documentation...
	 * @param connection
	 */
	public void setActionItemDatabase(String connection);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public Meeting meeting();
	
	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Meeting meeting(Closure closure);
	
	/**
	 * TODO:documentation...
	 * @param action
	 */
	public Meeting meeting(Action<? super Meeting> action);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public WorkingGroup workingGroup();
	
	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public WorkingGroup workingGroup(Closure closure);
	
	/**
	 * TODO:documentation...
	 * @param action
	 * @return
	 */
	public WorkingGroup workingGroup(Action<? super WorkingGroup> action);
	
}
