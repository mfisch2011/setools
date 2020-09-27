/**
 * TODO:license...
 */
package setools.gradle.meetings.dsl;

import java.awt.image.BufferedImage;

import groovy.lang.Closure;

/**
 * TODO:documentation...
 */
public interface TitleAndContentSlide extends TitledSlide {

	public String getContentText();
	
	public void setContentText(String text);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public AgendaHandler bullets();
	
	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public AgendaHandler bullets(Closure closure);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public BufferedImage getContentImage();
	
	/**
	 * TODO:documentation...
	 * @param object
	 */
	public void setContentImage(Object object);
}
