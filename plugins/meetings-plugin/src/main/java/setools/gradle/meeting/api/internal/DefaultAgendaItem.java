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

import java.util.Collection;

import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meeting.api.AgendaItem;
import setools.gradle.meeting.api.AgendaItemHandler;

/**
 * TODO:
 */
public class DefaultAgendaItem implements AgendaItem {

	private AgendaItemHandler subItems = null;

	private String text = null;

	private String description = null;

	private String presenter = null;

	private String formatter = null;
	
	public DefaultAgendaItem() {
		formatter = "setools.gradle.tasks.DraftContentSlide";
	}

	public DefaultAgendaItem(String text, String description,String formatter) {
		this.text = text;
		this.description = description;
		this.formatter = formatter;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String text) {
		this.text  = text;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description  = description;
	}

	@Override
	public String getPresenter() {
		return presenter;
	}

	@Override
	public void setPresenter(String presenter) {
		this.presenter = presenter;
	}

	@Override
	public String getFormatter() {
		return formatter;
	}

	@Override
	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}

	@Override
	public Collection<AgendaItem> getSubItems() {
		if(subItems==null)
			subItems = new DefaultAgendaItemHandler();
		return subItems.getAgendaItems();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void subItems(Closure closure) {
		if(subItems==null)
			subItems = new DefaultAgendaItemHandler();
		ConfigureUtil.configure(closure, subItems);
	}

}
