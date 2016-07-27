package org.vsfamily.vslib.common.domain;

import org.vsfamily.vslib.common.VslibBaseClass;

/**
 * Article Category class.
 */
@SuppressWarnings("serial")
public class ArticleCategory extends VslibBaseClass {

	private String 			description;

	/**
	 * Gets the article category description.
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the article category description.
	 * @param description - the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
