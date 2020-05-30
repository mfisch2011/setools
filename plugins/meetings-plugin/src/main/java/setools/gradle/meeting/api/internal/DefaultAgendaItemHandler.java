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
package setools.gradle.meeting.api.internal;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meeting.api.AgendaItem;
import setools.gradle.meeting.api.AgendaItemHandler;

/**
 * @author matt
 *
 */
public class DefaultAgendaItemHandler implements AgendaItemHandler {
	
	protected final ArrayList<AgendaItem> agendaItems;

	public DefaultAgendaItemHandler() {
		agendaItems = new ArrayList<AgendaItem>();
	}

	@Override
	public AgendaItem add(AgendaItem topic) {
		agendaItems.add(topic);
		return topic;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public AgendaItem add(Closure closure) throws URISyntaxException {
		AgendaItem topic = new DefaultAgendaItem();
		ConfigureUtil.configure(closure, topic);
		agendaItems.add(topic);
		return topic;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public AgendaItem create(Closure closure) throws URISyntaxException {
		AgendaItem topic = new DefaultAgendaItem();
		ConfigureUtil.configure(closure, topic);
		agendaItems.add(topic);
		return topic;
	}

	@Override
	public Collection<AgendaItem> getAgendaItems() {
		return agendaItems;
	}
	
	@SuppressWarnings("rawtypes")
	public static AgendaItem agendaItem(Closure closure) {
		AgendaItem topic = new DefaultAgendaItem();
		ConfigureUtil.configure(closure, topic);
		return topic;
	}
	
}
