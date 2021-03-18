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
 * TODO:documentation...
 */
public interface Meeting {

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
	public AgendaHandler agenda();
	
	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public AgendaHandler agenda(Closure closure);
	
	/**
	 * TODO:documentation...
	 * @param action
	 * @return
	 */
	public AgendaHandler agenda(Action<? super AgendaHandler> action);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public AttendeesHandler attendees();
	
	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public AttendeesHandler attendees(Closure closure);
	
	/**
	 * TODO:documentation...
	 * @param action
	 * @return
	 */
	public AttendeesHandler attendees(Action<? super AttendeesHandler> action);
	
}
