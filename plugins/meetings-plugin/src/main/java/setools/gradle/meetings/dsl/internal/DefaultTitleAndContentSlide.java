/**
 * TODO:license...
 */
package setools.gradle.meetings.dsl.internal;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import java.awt.image.BufferedImage;
import java.io.IOException;

import groovy.lang.Closure;
import setools.gradle.meetings.dsl.AgendaHandler;
import setools.gradle.meetings.dsl.TitleAndContentSlide;

/**
 * TODO:documentation...
 */
public class DefaultTitleAndContentSlide extends DefaultTitledSlide implements TitleAndContentSlide {

	protected String contentText = null;
	
	@Override
	public String getContentText() {
		return contentText;
	}

	@Override
	public void setContentText(String text) {
		contentText = text;
	}

	@Override
	public AgendaHandler bullets() {
		return subTopics();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public AgendaHandler bullets(Closure closure) {
		return subTopics(closure);
	}
	
	protected BufferedImage contentImage = null;

	@Override
	public BufferedImage getContentImage() {
		return contentImage;
	}

	@Override
	public void setContentImage(Object object) {
		try {
			ImageInputStream stream = ImageIO.createImageInputStream(object);
			contentImage = ImageIO.read(stream);
		} catch(IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

}
