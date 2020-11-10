/**
 * TODO:license...
 */
package setools.gradle.dsl.agenda.internal;

import setools.gradle.dsl.agenda.Section;

/**
 * TODO:documentation...
 */
public class DefaultSectionSlide extends DefaultTitleOnly implements Section {

	/**
	 * TODO:documentation...
	 */
	private String subtitle = null;
	
	@Override
	public String getSubtitle() {
		return subtitle;
	}
	
	@Override
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
}
