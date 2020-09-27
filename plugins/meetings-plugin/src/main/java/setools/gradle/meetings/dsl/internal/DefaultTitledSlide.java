/**
 * TODO:license...
 */
package setools.gradle.meetings.dsl.internal;

import setools.gradle.meetings.dsl.TitledSlide;

/**
 * TODO:documentation...
 */
public class DefaultTitledSlide extends DefaultAgendaItem implements TitledSlide {

	/**
	 * TODO:documentation...
	 */
	protected String title = null;
	
	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

}
