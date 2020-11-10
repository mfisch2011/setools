/**
 * TODO:license...
 */
package setools.gradle.actions;

import java.util.Collection;
import setools.gradle.actions.dsl.ActionItem;

/**
 * TODO:documentation...
 */
public interface ActionItemDatabase {

	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getUrl();
	
	/**
	 * TODO:documentation...
	 * @param url
	 */
	public void setUrl(String url);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public Collection<ActionItem> getActionItems();
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public ActionItem addActionItem();
	
}
