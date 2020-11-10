/**
 * TODO:license...
 */
package setools.gradle.actions.dsl;

import java.util.Date;

/**
 * TODO:documentation...
 */
public interface StatusUpdate {
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getId();
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getAction();

	/**
	 * TODO:documentation...
	 * @return
	 */
	public Date getDate();
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getNotes();
	
}
