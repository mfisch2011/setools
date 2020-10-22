/**
 * TODO:license...
 */
package setools.gradle.dsl.agenda.internal;

import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.dsl.agenda.Content;
import setools.gradle.dsl.agenda.TitleAndContent;

/**
 * TODO:documentation...
 */
public class DefaultTitleAndContent extends DefaultTitleOnly implements TitleAndContent {

	/**
	 * TODO:documentation...
	 */
	protected final Content content;
	
	/**
	 * TODO:documentation...
	 */
	public DefaultTitleAndContent() {
		this.content = new DefaultContent();
	}
	
	@Override
	public Content content() {
		return content;
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public Content content(Closure closure) {
		ConfigureUtil.configure(closure, content);
		return content;
	}
}
