/**
 * TODO:license...
 */
package setools.gradle.dsl.agenda.internal;

/**
 * TODO:documentation...
 */
public class DefaultTitleOnly extends DefaultAgendaItem {
	
	/**
	 * TODO:documentation...
	 */
	protected String title = null;

	@Override
	public String getName() {
		String name = super.getName();
		return (name!=null) ? name : title;
	}
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * TODO:documentation...
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}
