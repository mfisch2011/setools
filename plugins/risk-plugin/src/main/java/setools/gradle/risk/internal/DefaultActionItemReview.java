/**
 * TODO:license...
 */
package setools.gradle.risk.internal;

import setools.gradle.actions.ActionItemDatabase;
import setools.gradle.dsl.agenda.internal.DefaultSectionSlide;
import setools.gradle.risk.ActionItemReview;

/**
 * TODO:documentation...
 */
public class DefaultActionItemReview extends DefaultSectionSlide implements ActionItemReview {

	public DefaultActionItemReview() {
		super();
		setTitle("Action Item Review");
	}
	
	/**
	 * TODO:documentation...
	 */
	protected String url = null;
	
	/**
	 * TODO:documentation...
	 */
	private ActionItemDatabase database = null;
	
	@Override
	public String getDatabase() {
		return url;
	}

	@Override
	public void setDatabase(String url) {
		//TODO:validate url
		this.url = url;
	}
	
}
