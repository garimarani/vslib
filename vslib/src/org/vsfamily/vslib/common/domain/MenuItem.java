package org.vsfamily.vslib.common.domain;

import org.vsfamily.vslib.common.VslibBaseClass;

/**
 * Menu Item class for implementing additional links in the left menu under the Home page link.
 */
@SuppressWarnings("serial")
public class MenuItem extends VslibBaseClass {

	private String				menuType;
	private String				externalUrl;
	private String 				targetWindow;
	private Article				article;
	private ArticleCategory		articleCategory;
	private boolean				published = true;
	
	/**
	 * Gets the menu type
	 * @return externalUrl / fixedArticle / categoryBlog
	 */
	public String getMenuType() {
		return menuType;
	}
	
	/**
	 * Sets the menu type
	 * @param menuType - externalUrl / fixedArticle / categoryBlog
	 */
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	
	/**
	 * Gets the external URL
	 * @return the external URL
	 */
	public String getExternalUrl() {
		return externalUrl;
	}
	
	/**
	 * Sets the externl URL
	 * @param externalUrl - the external URL
	 */
	public void setExternalUrl(String externalUrl) {
		this.externalUrl = externalUrl;
	}
	
	/**
	 * Gets the target window for opening the external URL
	 * @return the target window
	 */
	public String getTargetWindow() {
		return targetWindow;
	}
	
	/**
	 * Sets the target window for opening external URL
	 * @param targetWindow - the target windows
	 */
	public void setTargetWindow(String targetWindow) {
		this.targetWindow = targetWindow;
	}
	
	/**
	 * Gets the article to display
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}
	
	/**
	 * Sets the article for fixed article display.
	 * @param article - the article
	 */
	public void setArticle(Article article) {
		this.article = article;
	}
	
	/**
	 * Gets the article category for blog layout
	 * @return the article category
	 */
	public ArticleCategory getArticleCategory() {
		return articleCategory;
	}
	
	/**
	 * Sets the article category for blog layout.
	 * @param articleCategory - the article category
	 */
	public void setArticleCategory(ArticleCategory articleCategory) {
		this.articleCategory = articleCategory;
	}
	
	/**
	 * Gets whether the menu item is published or not.
	 * @return true if yes, false otherwise
	 */
	public boolean isPublished() {
		return published;
	}
	
	/**
	 * Sets whether the menu item is published or not.
	 * @param published - true if yes, false otherwise
	 */
	public void setPublished(boolean published) {
		this.published = published;
	}

	@Override
	public void setAddDefaults(String user) {
		this.published = true;
		super.setAddDefaults(user);
	}
}
