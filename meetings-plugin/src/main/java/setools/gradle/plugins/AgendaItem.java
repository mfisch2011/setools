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

import java.util.Collection;

import javax.inject.Inject;

import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.model.ObjectFactory;

import groovy.lang.Closure;

/**
 * @author matt
 *
 */
public class AgendaItem {

	protected final String name;
	
	protected ObjectFactory objectFactory;
	
	protected String text = null;
	
	protected String description = null;
	
	protected String presenter = null;
	
	protected String duration = null;
	
	protected NamedDomainObjectContainer<AgendaItem> subItems = null;
	
	@Inject
	public AgendaItem(ObjectFactory objectFactory,String name) {
		this.objectFactory = objectFactory;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPresenter() {
		return presenter;
	}
	
	public void setPresenter(String presenter) {
		this.presenter = presenter;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public Collection<AgendaItem> getSubItems() {
		return subItems;
	}
	
	@SuppressWarnings("rawtypes")
	public void subItems(Closure closure) {
		if(subItems==null) {
			subItems = objectFactory.domainObjectContainer(AgendaItem.class);
		}
		subItems.configure(closure);
	}
}
