/**
   Copyright 2020 Matt Fischer <mfish2011@gmail.com>

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package setools.gradle.meeting.api;

import java.net.URI;
import java.util.Collection;
import java.util.Set;

import groovy.lang.Closure;

/** 
 * TODO:
 */
public interface Meeting {

	/** TODO:
	 * @return
	 */
	public String getName();
	
	/** TODO:
	 * @param name
	 */
	public void setName(String name);
	
	/** TODO:
	 * @return
	 */
	public String getDescription();
	
	/** TODO:
	 * @param description
	 */
	public void setDescription(String description);
		
	/** TODO:
	 * @return
	 */
	public String getDate();
	
	/** TODO:
	 * @param date
	 */
	public void setDate(String date);
	
	/** TODO:
	 * @return
	 */
	public String getTime();
	
	/** TODO:
	 * @param time
	 */
	public void setTime(String time);
	
	/** TODO:
	 * @return
	 */
	public Set<String> getAttendees();
	
	//TODO:should we add an attendee DSL?
	/** TODO:
	 * @param attendees
	 */
	public void setAttendees(String...attendees);
	
	//TODO:should we add an attendee DSL?
	/** TODO:
	 * @param attendees
	 */
	public void attendees(String...attendees);
	
	/** TODO:
	 * @return
	 */
	public Collection<AgendaItem> getAgenda();
	
	/** TODO:
	 * @param closure
	 */
	@SuppressWarnings("rawtypes")
	public void agenda(Closure closure);

	/** TODO:
	 * @return
	 */
	public URI getPresentationTemplate();
	
	/** TODO:
	 * @param object
	 */
	public void setPresentationTemplate(Object object);
	
	/** TODO:
	 * @return
	 */
	public String getLocation();
	
	/** TODO:
	 * @param location
	 */
	public void setLocation(String location);
	
}
