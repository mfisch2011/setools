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
package setools.gradle.meeting.api;

import java.util.Collection;

import groovy.lang.Closure;
import setools.gradle.meeting.api.AgendaItem;
import setools.gradle.meeting.api.Meeting;

/**
 * @author matt
 *
 */
public interface RiskReview extends Meeting {

	/** TODO:
	 * @return
	 */
	public Collection<AgendaItem> getNewRisks();
	
	/** TODO:
	 * @param closure
	 */
	@SuppressWarnings("rawtypes")
	public void newRisks(Closure closure);
	
	/** TODO:
	 * @return
	 */
	public Collection<AgendaItem> getMonitoredRisks();
	
	/** TODO:
	 * @param closure
	 */
	@SuppressWarnings("rawtypes")
	public void monitoredRisks(Closure closure);
	
	/** TODO:
	 * @return
	 */
	public Collection<AgendaItem> getRiskClosures();
	
	/** TODO:
	 * @param closure
	 */
	@SuppressWarnings("rawtypes")
	public void riskClosures(Closure closure);

	/** TODO:
	 * @return
	 */
	Collection<AgendaItem> getClosingComments();

	/** TODO:
	 * @param closure
	 */
	@SuppressWarnings("rawtypes")
	void closingComments(Closure closure);
	
}
