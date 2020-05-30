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

/**
 * @author matt
 *
 */
public interface AgendaItem {
	
	/** TODO:
	 * @return
	 */
	public String getText();
	
	/** TODO:
	 * @param text
	 */
	public void setText(String text);
	
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
	public String getPresenter();
	
	/** TODO:
	 * @param presenter
	 */
	public void setPresenter(String presenter);
	
	/** TODO:
	 * @return
	 */
	public String getFormatter();
	
	//TODO:should we make this accept a generic object? (i.e. string,class,action,closure...)???
	/** TODO:
	 * @param formatter
	 */
	public void setFormatter(String formatter);
	
	public Collection<AgendaItem> getSubItems();
	
	@SuppressWarnings("rawtypes")
	public void subItems(Closure closure);

}
