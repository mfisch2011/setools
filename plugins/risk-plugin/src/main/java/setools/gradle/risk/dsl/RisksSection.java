/**
 * TODO:license...
 */
package setools.gradle.risk.dsl;

import groovy.lang.Closure;
import setools.gradle.dsl.agenda.AgendaItem;

/**
 * TODO:documentation...
 */
public interface RisksSection extends AgendaItem {

	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getTitle();
	
	/**
	 * TODO:documentation...
	 * @param title
	 */
	public void setTitle(String title);

	/**
	 * TODO:documentation...
	 * @return
	 */
	public boolean hasOverviewSlide();
	
	/**
	 * TODO:documentation...
	 * @param b
	 */
	public void setOverviewSlide(boolean set);
	
	//TODO:allow configuration of filter(s)...
	
}
