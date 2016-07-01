package org.vsfamily.vslib.manager.domain;

import org.vsfamily.vslib.common.VslibBaseClass;

@SuppressWarnings("serial")
public class GroupRole extends VslibBaseClass {

	private VslibRole		role;
	private VslibGroup		group;
	
	public VslibRole getRole() {
		return role;
	}
	public void setRole(VslibRole role) {
		this.role = role;
	}
	public VslibGroup getGroup() {
		return group;
	}
	public void setGroup(VslibGroup group) {
		this.group = group;
	}
	
}
