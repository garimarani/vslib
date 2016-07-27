package org.vsfamily.vslib.common.domain;

import org.vsfamily.vslib.common.VslibBaseClass;

/**
 * Article class.
 */
@SuppressWarnings("serial")
public class Article extends VslibBaseClass {

	private String 			title;
	private String			articleContent;
	private ArticleCategory	category;
	private boolean			published = true;
	private boolean			homePage = false;
	
	/**
	 * Gets the title of the article
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title of the article
	 * @param title - the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Gets the articleContent of the article
	 * @return the articleContent
	 */
	public String getArticleContent() {
		return articleContent;
	}
	
	/**
	 * Sets the articleContent of the article.
	 * @param articleContent - the articleContent
	 */
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	
	/**
	 * Gets the article category.
	 * @return the article category
	 */
	public ArticleCategory getCategory() {
		return category;
	}
	
	/**
	 * Sets the article category.
	 * @param category - the article category
	 */
	public void setCategory(ArticleCategory category) {
		this.category = category;
	}
	
	/**
	 * Gets whether the article is published.
	 * @return true if yes, false otherwise
	 */
	public boolean isPublished() {
		return published;
	}
	
	/**
	 * Sets whether the articled is published or not.
	 * @param published - set to true if yes, false otherwise
	 */
	public void setPublished(boolean published) {
		this.published = published;
	}

	/**
	 * Gets whether the article is to be published on the home page.
	 * @return true if yes, false otherwise
	 */
	public boolean isHomePage() {
		return homePage;
	}

	/**
	 * Sets whether the article is to be published on the home page.
	 * @param homePage - true if yes, false otherwise
	 */
	public void setHomePage(boolean homePage) {
		this.homePage = homePage;
	}

	@Override
	public void setAddDefaults(String user) {
		this.published = true;
		this.homePage = false;
		super.setAddDefaults(user);
	}
}
