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
package setools.gradle.meetings.api;

import java.util.Date;

/**
 * TODO:
 */
public interface Meeting {

	/**
	 * Get the name of the meeting.
	 * 
	 * @return - {@link String} containing the name
	 */
	public String getName();
	
	/**
	 * Set the name of the meeting.
	 * 
	 * @param name - {@link String} containing the name
	 */
	public void setName(String name);
	
	/**
	 * Get the location of the meeting.
	 * 
	 * @return - {@link String} containing the location
	 */
	public String getLocation();
	
	/**
	 * Set the location of the meeting.
	 * 
	 * @param location - {@link String} containing the location
	 */
	public void setLocation(String location);
	
	/**
	 * Get the date and time of the meeting.
	 * 
	 * @return - {@link Date} containing the date and time
	 */
	public Date getTime();
	
	/**
	 * Set the date and time of the meeting.
	 * 
	 * @param object - {@link Object} containing the date and time
	 */
	public void setTime(Object object);
	
	//TODO:add agenda methods...
	
	//TODO:add attendee methods...
}
