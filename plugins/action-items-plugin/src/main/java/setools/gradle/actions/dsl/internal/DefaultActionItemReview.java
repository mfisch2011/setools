/**
 * TODO:license...
 */
package setools.gradle.actions.dsl.internal;

import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.actions.dsl.ActionItemDatabase;
import setools.gradle.actions.dsl.ActionItemReview;
import setools.gradle.dsl.agenda.internal.DefaultTitleAndContent;

/**
 * TODO:documentation...
 */
public class DefaultActionItemReview extends DefaultTitleAndContent implements ActionItemReview {
	
	public DefaultActionItemReview() {
		this.actionItems = new DefaultActionItemDatabase();
		setTitle("Action Item Review");
	}

	/**
	 * TODO:documentation...
	 */
	protected final ActionItemDatabase actionItems;
	
	@Override
	public ActionItemDatabase actionItems() {
		return actionItems;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ActionItemDatabase actionItems(Closure closure) {
		ConfigureUtil.configure(closure, actionItems);
		return actionItems;
	}

}
