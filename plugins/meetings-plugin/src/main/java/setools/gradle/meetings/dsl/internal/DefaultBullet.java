/**
 * TODO:license...
 */
package setools.gradle.meetings.dsl.internal;

import setools.gradle.meetings.dsl.Bullet;

/**
 * TODO:documentation...
 */
public class DefaultBullet extends DefaultAgendaItem implements Bullet {
	
	/**
	 * TODO:documentation...
	 */
	protected String text = null;
	
	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected String bulletFormat = "*";

	@Override
	public String getBulletFormt() {
		return bulletFormat;
	}

	@Override
	public void setBulletFormat(String format) {
		//TODO:validate format
		bulletFormat = format;
	}

}
