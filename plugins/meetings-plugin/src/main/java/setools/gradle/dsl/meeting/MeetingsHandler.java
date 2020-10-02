/**
 * TODO:license...
 */
package setools.gradle.dsl.meeting;

import java.util.Collection;

import groovy.lang.Closure;

/**
 * TODO:documentation...
 */
public interface MeetingsHandler extends Collection<Meeting> {

	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getAgendaTemplate();
	
	/**
	 * TODO:documentation...
	 * @param template
	 */
	public void setAgendaTemplate(String template);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getMinutesTemplate();
	
	/**
	 * TODO:documentation...
	 * @param template
	 */
	public void setMinutesTemplate(String template);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getPresentationTemplate();
	
	/**
	 * TODO:documentation...
	 * @param template
	 */
	public void setPresentationTemplate(String tempate);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public Meeting meeting();
	
	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Meeting meeting(Closure closure);
	
}
