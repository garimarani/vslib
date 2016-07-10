package org.vsfamily.vslib.manager.domain;

import org.vsfamily.vslib.common.VslibBaseClass;

/**
 * ManagerRole class for specifying the relationship between managers and roles.
 */
@SuppressWarnings("serial")
public class ManagerRole extends VslibBaseClass {

	private Manager			manager;
	private VslibRole		role;
	
	/**
	 * Gets the Manager.
	 * @return the Manager
	 */
	public Manager getManager() {
		return manager;
	}
	
	/**
	 * Sets the Manager.
	 * @param manager - the Manager
	 */
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	/**
	 * Gets the Role
	 * @return the Role
	 */
	public VslibRole getRole() {
		return role;
	}
	
	/**
	 * Sets the Role.
	 * @param role - the role
	 */
	public void setRole(VslibRole role) {
		this.role = role;
	}
}
