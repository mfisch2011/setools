/**
 * TODO:license...
 */
package setools.gradle.dsl.attendee;

/**
 * TODO:documentation...
 */
public interface Attendee extends Comparable<Attendee> {

	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getName();
	
	/**
	 * TODO:documentation...
	 * @param name
	 */
	public void setName(String name);
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	public String getRole();
	
	/**
	 * TODO:documentation...
	 * @param role
	 */
	public void setRole(String role);
	
}
