package org.vsfamily.vslib.common.domain;

import java.util.Set;

import org.vsfamily.vslib.common.VslibBaseClass;

@SuppressWarnings("serial")
public class Subject extends VslibBaseClass {

	private Subject			parentSubject;
	private Set<Subject>	children;
	
	public Subject getParentSubject() {
		return parentSubject;
	}
	public void setParentSubject(Subject parentSubject) {
		this.parentSubject = parentSubject;
	}
	public Set<Subject> getChildren() {
		return children;
	}
	public void setChildren(Set<Subject> children) {
		this.children = children;
	}
	
}
