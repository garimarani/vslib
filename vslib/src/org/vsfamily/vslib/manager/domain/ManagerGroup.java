package org.vsfamily.vslib.manager.domain;

import org.vsfamily.vslib.common.VslibBaseClass;

@SuppressWarnings("serial")
public class ManagerGroup extends VslibBaseClass {

	private Manager			manager;
	private VslibGroup		group;
	
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public VslibGroup getGroup() {
		return group;
	}
	public void setGroup(VslibGroup group) {
		this.group = group;
	}
	
}
