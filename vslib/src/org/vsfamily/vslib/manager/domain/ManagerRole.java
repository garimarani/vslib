package org.vsfamily.vslib.manager.domain;

import org.vsfamily.vslib.common.VslibBaseClass;

@SuppressWarnings("serial")
public class ManagerRole extends VslibBaseClass {

	private Manager			manager;
	private VslibRole		role;
	
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public VslibRole getRole() {
		return role;
	}
	public void setRole(VslibRole role) {
		this.role = role;
	}
}
