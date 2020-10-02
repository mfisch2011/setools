/**
 * TODO:license...
 */
package setools.gradle.dsl.agenda.internal;

import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.dsl.agenda.AgendaHandler;
import setools.gradle.dsl.agenda.Content;

/**
 * TODO:documentation...
 */
public class DefaultContent implements Content {

	/**
	 * TODO:documentation...
	 */
	protected String contentText = null;
	
	/**
	 * TODO:documentation...
	 */
	protected final AgendaHandler bullets;
	
	/**
	 * TODO:documentation...
	 */
	public DefaultContent() {
		bullets = new DefaultAgendaHandler();
	}
	
	@Override
	public String getText() {
		return contentText;
	}
	
	@Override
	public void setText(String text) {
		contentText = text;
	}
	
	@Override
	public AgendaHandler bullets() {
		return bullets;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public AgendaHandler bullets(Closure closure) {
		ConfigureUtil.configure(closure, bullets);
		return bullets;
	}
	
}
