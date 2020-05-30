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

import java.net.URISyntaxException;
import java.util.Set;

import groovy.lang.Closure;

/**
 * @author matt
 *
 */
public interface MeetingsHandler {

	/** TODO:
	 * @param review
	 * @return
	 */
	public Meeting add(Meeting review);
	
	/** TODO:
	 * @param closure
	 * @return
	 * @throws URISyntaxException
	 */
	@SuppressWarnings("rawtypes")
	public Meeting add(Closure closure) throws URISyntaxException;
	
	/** TODO:
	 * @param closure
	 * @return
	 * @throws URISyntaxException
	 */
	@SuppressWarnings("rawtypes")
	public Meeting create(Closure closure) throws URISyntaxException;
	
	/** TODO:
	 * @return
	 */
	public Set<Meeting> getMeetings();

	/** TODO:
	 * @param closure
	 * @return
	 * @throws URISyntaxException
	 */
	@SuppressWarnings("rawtypes")
	Meeting meeting(Closure closure) throws URISyntaxException;
	
}
