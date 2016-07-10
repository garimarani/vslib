package org.vsfamily.vslib.manager.domain;

import org.vsfamily.vslib.common.VslibBaseClass;

/**
 * ManagerGroup class for specifying the relationship between the managers and groups.
 */
@SuppressWarnings("serial")
public class ManagerGroup extends VslibBaseClass {

	private Manager			manager;
	private VslibGroup		group;
	
	/**
	 * Gets the manager.
	 * @return the manager
	 */
	public Manager getManager() {
		return manager;
	}
	
	/**
	 * Sets the manager.
	 * @param manager - the manager
	 */
	public void setManager(Manager manager) {
		this.manager = manager;
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
