/**
 * TODO:license...
 */
package setools.gradle.dsl.agenda.internal;

import setools.gradle.dsl.agenda.TitleOnly;

/**
 * TODO:documentation...
 */
public class DefaultTitleOnly extends DefaultAgendaItem implements TitleOnly {
	
	/**
	 * TODO:documentation...
	 */
	protected String title = null;

	@Override
	public String getName() {
		String name = super.getName();
		return (name!=null) ? name : title;
	}
	
	@Override
	public String getTitle() {
		return title;
	}
	
	@Override
	public void setTitle(String title) {
		this.title = title;
	}
}
