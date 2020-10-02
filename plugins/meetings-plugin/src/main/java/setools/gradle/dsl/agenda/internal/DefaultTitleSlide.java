/**
 * TODO:license...
 */
package setools.gradle.dsl.agenda.internal;

import setools.gradle.dsl.agenda.AgendaItem;

/**
 * TODO:documentation...
 */
public class DefaultTitleSlide extends DefaultTitleOnly implements AgendaItem {

	/**
	 * TODO:documentation...
	 */
	private String subtitle;
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getSubtitle() {
		return subtitle;
	}
	
	/**
	 * TODO:documentation...
	 * @param subtitle
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
}
