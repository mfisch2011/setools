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

import org.gradle.api.Action;

import groovy.lang.Closure;

/**
 * TODO:
 */
public interface Meeting {

	/**
	 * TODO:
	 * @return
	 */
	public String getName();
	
	/**
	 * TODO:
	 * @param value
	 */
	public void setName(String value);
	
	/**
	 * TODO:
	 * @return
	 */
	public String getLocation();
	
	/**
	 * TODO:
	 * @param value
	 */
	public void setLocation(String value);
	
	/**
	 * TODO:
	 * @return
	 */
	public String getTime();
	
	/**
	 * TODO:
	 * @param object
	 */
	public void setTime(Object object);
	
	/**
	 * TODO:
	 * @return
	 */
	public AgendaHandler agenda();
		
	/**
	 * TODO:
	 * @param action
	 * @return
	 */
	public AgendaHandler agenda(Action<AgendaHandler> action);

	/**
	 * TODO:
	 * @return
	 */
	public Object getAgendaTemplate();
	
	/**
	 * TODO:
	 * @param object
	 */
	public void setAgendaTemplate(Object object);

	/**
	 * The preference, and default, is to use the name transformation in 
	 * the MeetingHandler, but getAgendaFilename is provided to retrieve 
	 * an output agenda filename explicitly set by setAgendaFilename.
	 * 
	 * @return
	 */
	public String getAgendaFilename();
	
	/**
	 * The preference, and default, is to use the name transformation in 
	 * the MeetingHandler, but setAgendaFilename is provided to allow 
	 * explicit setting of the output agenda filename.
	 * 
	 * @param filename
	 */
	public void setAgendaFilename(String filename);

	/**
	 * TODO:
	 * @return
	 */
	public String getDate();
	
	/**
	 * TODO:
	 * @param value
	 */
	public void setDate(String value);
	
}
