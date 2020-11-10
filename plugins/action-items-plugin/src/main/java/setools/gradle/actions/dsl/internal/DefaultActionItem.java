/**
 * TODO:license...
 */
package setools.gradle.actions.dsl.internal;

import java.util.Collection;

import setools.gradle.actions.dsl.ActionItem;
import setools.gradle.actions.dsl.StatusUpdate;

/**
 * TODO:documentation...
 */
public class DefaultActionItem implements ActionItem {

	/**
	 * TODO:documentation...
	 */
	protected final String id;
	
	protected final Collection<StatusUpdate> status;
	
	/**
	 * TODO:documentation...
	 * @param id
	 */
	public DefaultActionItem(String id,String title,Collection<StatusUpdate> status) {
		this.id = id;
		this.title = title;
		this.status = status;
	}
	
	@Override
	public String getId() {
		return id;
	}
	
	protected String title = null;

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public Collection<StatusUpdate> getStatus() {
		return status;
	}

}
