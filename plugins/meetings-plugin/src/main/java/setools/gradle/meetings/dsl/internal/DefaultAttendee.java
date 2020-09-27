/**
 * TODO:license...
 */
package setools.gradle.meetings.dsl.internal;

import setools.gradle.meetings.dsl.Attendee;

/**
 * TODO:documentation...
 */
public class DefaultAttendee implements Attendee {

	@Override
	public int compareTo(Attendee attendee) {
		if(getRole()!=null && attendee.getRole()==null)
			return -1;
		else if(getRole()!=null && attendee.getRole()!=null) {
			return getName().compareTo(attendee.getName());
		}
		else if(getRole()==null && attendee.getRole()==null) {
			return getName().compareTo(attendee.getName());
		} else {
			return 1;
		}
	}
	
	/**
	 * TODO:documentation...
	 */
	protected String name = null;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected String role = null;

	@Override
	public String getRole() {
		return role;
	}

	@Override
	public void setRole(String role) {
		//TODO:validate role?
		this.role = role;
	}

}
