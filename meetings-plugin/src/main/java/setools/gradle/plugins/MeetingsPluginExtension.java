/**
   Copyright 2019 Matt Fischer <mfish2011@gmail.com>

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
package setools.gradle.plugins;

import java.net.URI;
import java.text.ParseException;
import java.util.Collection;

import org.gradle.api.Project;

import groovy.lang.Closure;

/**
 * @author matt
 *
 */
public interface MeetingsPluginExtension {

	public String getName();
	
	public void setName(String name);
	
	public String getDescription();
	
	public void setDescription(String description);
	
	public String getDate();
	
	public void setDate(Object object) throws ParseException;
	
	public String getDateFormat();
	
	public void setDateFormat(String format);
	
	public String getTime();
	
	public void setTime(Object object) throws ParseException;
	
	public String getTimeFormat();
	
	public void setTimeFormat(String format);
	
	public String getLocation();
	
	public void setLocation(String location);
	
	public Collection<String> getAttendees();
	
	public void setAttendees(String...attendees);
	
	public void attendees(String...attendees);
	
	public Collection<AgendaItem> getAgenda();
	
	@SuppressWarnings("rawtypes")
	public void agenda(Closure closure);

	public URI getAgendaTemplate();
	
	public void setAgendaTemplate(Object object);
	
	public URI getMinutesTemplate();
	
	public void setMinutesTemplate(Object object);
	
}
