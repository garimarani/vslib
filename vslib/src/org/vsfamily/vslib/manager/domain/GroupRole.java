package org.vsfamily.vslib.manager.domain;

import org.vsfamily.vslib.common.VslibBaseClass;

/**
 * GroupRole class for specifying relationship between the groups and roles.
 */
@SuppressWarnings("serial")
public class GroupRole extends VslibBaseClass {

	private VslibRole		role;
	private VslibGroup		group;
	
	/**
	 * Gets the role.
	 * @return the role
	 */
	public VslibRole getRole() {
		return role;
	}
	
	/**
	 * Sets the role.
	 * @param role - the role
	 */
	public void setRole(VslibRole role) {
		this.role = role;
	}
	
	/**
	 * Gets the group.
	 * @return the group
	 */
	public VslibGroup getGroup() {
		return group;
	}
	
	/**
	 * Sets the group.
	 * @param group - the group
	 */
	public void setGroup(VslibGroup group) {
		this.group = group;
	}
	
}
