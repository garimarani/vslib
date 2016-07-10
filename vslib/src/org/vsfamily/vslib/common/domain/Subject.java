package org.vsfamily.vslib.common.domain;

import java.util.Set;

import org.vsfamily.vslib.common.VslibBaseClass;

/**
 * Subject class used for grouping items.
 *  
 */
@SuppressWarnings("serial")
public class Subject extends VslibBaseClass {

	private Subject			parentSubject;
	private Set<Subject>	children;
	
	/**
	 * Gets the parent subject.
	 * @return the parent subject
	 */
	public Subject getParentSubject() {
		return parentSubject;
	}
	
	/**
	 * Sets the parent subject.
	 * @param parentSubject - the parent subject
	 */
	public void setParentSubject(Subject parentSubject) {
		this.parentSubject = parentSubject;
	}
	
	/**
	 * Gets the children subjects.
	 * @return the children subjects
	 */
	public Set<Subject> getChildren() {
		return children;
	}
	
	/**
	 * Sets the children subjects.
	 * @param children - the children subject
	 */
	public void setChildren(Set<Subject> children) {
		this.children = children;
	}
	
}
