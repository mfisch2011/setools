/**
 * TODO:license...
 */
package setools.gradle.actions.dsl;

import java.util.Collection;

/**
 * TODO:documentation...
 */
public interface ActionItem {

	public String getId();
	
	public String getTitle();
		
	public Collection<StatusUpdate> getStatus();
	
}
