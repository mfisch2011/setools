/**
 * TODO:license...
 */
package setools.gradle.dsl.agenda.internal;

import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.dsl.agenda.Content;

/**
 * TODO:documentation...
 */
public class DefaultTitleAndContent extends DefaultTitleOnly {

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
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public Content content() {
		return content;
	}
	
	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Content content(Closure closure) {
		ConfigureUtil.configure(closure, content);
		return content;
	}
}
