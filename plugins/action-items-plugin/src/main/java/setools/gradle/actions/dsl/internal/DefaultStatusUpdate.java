/**
 * TODO:license...
 */
package setools.gradle.actions.dsl.internal;

import java.util.Date;

import setools.gradle.actions.dsl.StatusUpdate;

/**
 * TODO:documentation...
 */
public class DefaultStatusUpdate implements StatusUpdate {
	
	public DefaultStatusUpdate(String id,String action,Date date,String notes) {
		this.id = id;
		this.action = action;
		this.date = date;
		this.notes = notes;
	}
	
	protected Date date = null;

	@Override
	public Date getDate() {
		return date;
	}
	
	protected final String id;

	@Override
	public String getId() {
		return id;
	}
	
	protected String action = null;

	@Override
	public String getAction() {
		return action;
	}
	
	protected String notes = null;

	@Override
	public String getNotes() {
		return notes;
	}

}
