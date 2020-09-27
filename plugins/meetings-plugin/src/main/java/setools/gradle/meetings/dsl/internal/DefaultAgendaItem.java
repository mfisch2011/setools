/**
 * TODO:license...
 */
package setools.gradle.meetings.dsl.internal;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meetings.dsl.AgendaHandler;
import setools.gradle.meetings.dsl.AgendaItem;
import setools.gradle.meetings.service.agenda.ProxyAgendaHandler;

/**
 * TODO:documentation...
 */
public class DefaultAgendaItem implements AgendaItem {

	public DefaultAgendaItem() {
		this.subTopics = new DefaultAgendaHandler(); //TODO:implement proxy
	}
	
	protected Set<Object> dependencies = new HashSet<Object>();

	@Override
	public void dependsOn(Object... objects) {
		for(Object object : objects)
			dependencies.add(object);
	}

	@Override
	public Collection<Object> getDependencies() {
		return dependencies;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected final AgendaHandler subTopics;

	@Override
	public AgendaHandler subTopics() {
		return subTopics;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public AgendaHandler subTopics(Closure closure) {
		ConfigureUtil.configure(closure, subTopics);
		return subTopics;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected String formatter = null;

	@Override
	public String getFormatter() {
		return formatter;
	}

	@Override
	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected String title = null;

	@Override
	public String getTitle() {
		return (title==null) ? name : title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected String name = null;

	@Override
	public String getName() {
		return (name==null) ? title : name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
