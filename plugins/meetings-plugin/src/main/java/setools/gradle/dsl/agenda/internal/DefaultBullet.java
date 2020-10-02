/**
 * TODO:license...
 */
package setools.gradle.dsl.agenda.internal;

/**
 * TODO:documentation...
 */
public class DefaultBullet extends DefaultAgendaItem {
	
	/**
	 * TODO:documentation...
	 */
	protected String text = null;

	@Override
	public String getName() {
		String name = super.getName();
		return (name!=null) ? name : text;
	}
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * TODO:documentation...
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}
}
