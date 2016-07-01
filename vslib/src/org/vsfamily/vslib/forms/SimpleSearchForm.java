package org.vsfamily.vslib.forms;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SimpleSearchForm implements Serializable{

	private String 		searchString;

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
}
