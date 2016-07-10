package org.vsfamily.vslib.forms;

import java.io.Serializable;

/**
 * SimpleSearchForm used for generating forms for simple searches.
 */
@SuppressWarnings("serial")
public class SimpleSearchForm implements Serializable{

	private String 		searchString;

	/**
	 * Gets the search string.
	 * @return the search string
	 */
	public String getSearchString() {
		return searchString;
	}

	/**
	 * Sets the search string.
	 * @param searchString - the search string.
	 */
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
}
