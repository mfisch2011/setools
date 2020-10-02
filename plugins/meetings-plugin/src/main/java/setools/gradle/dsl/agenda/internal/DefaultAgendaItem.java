/**
 * TODO:license...
 */
package setools.gradle.dsl.agenda.internal;

import java.util.Collection;
import java.util.HashSet;

import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.dsl.agenda.AgendaHandler;
import setools.gradle.dsl.agenda.AgendaItem;

/**
 * TODO:documentation...
 */
public class DefaultAgendaItem implements AgendaItem {
	
	/**
	 * TODO:documentation...
	 */
	private String name = null;
	
	/**
	 * TODO:documentation...
	 */
	protected final AgendaHandler subTopics;
	
	/**
	 * TODO:documentation...
	 */
	protected final Collection<Object> dependencies;
	
	public DefaultAgendaItem() {
		this.subTopics = new DefaultAgendaHandler();
		this.dependencies = new HashSet<Object>();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

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

	@Override
	public Collection<Object> getDependencies() {
		return dependencies;
	}

	@Override
	public void dependsOn(Object... objects) {
		for(Object object : objects)
			dependencies.add(object);
	}
}
