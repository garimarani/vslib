package org.vsfamily.vslib.common.domain;

import org.vsfamily.vslib.common.VslibBaseClass;

/**
 * Parameters used by the system for its proper functioning.
 * 
 */
@SuppressWarnings("serial")
public class VslibParams extends VslibBaseClass {

	private boolean			enableEmail = false;
	private String			host;
	private String 			port;
	private String			username;
	private String			password;
	private boolean			smtpAuthEnable = false;
	private String			sslOrTls;
	private String			fromEmail;
	
	private String			photosFolder;
	private String			edocsFolder;
	private String			worksFolder;
	
	private String			organizationName;
	private String			organizationAddress;
	private String			contactName;
	private String 			contactAddress;
	private String 			contactEmail;
	private String			siteUrl;
	
	/**
	 * Gets whether the email communication is enabled or not.
	 * @return true if enabled, false otherwise
	 */
	public boolean isEnableEmail() {
		return enableEmail;
	}
	
	/**
	 * Sets whether the email communication is to enabled or not.
	 * @param enableEmail - true if yes, false otherwise
	 */
	public void setEnableEmail(boolean enableEmail) {
		this.enableEmail = enableEmail;
	}
	
	/**
	 * Gets the email host.
	 * @return - the email host
	 */
	public String getHost() {
		return host;
	}
	
	/**
	 * Sets the email host.
	 * @param host - the email host
	 */
	public void setHost(String host) {
		this.host = host;
	}
	
	/**
	 * Gets the port number.
	 * @return the port number
	 */
	public String getPort() {
		return port;
	}
	
	/**
	 * Sets the port number.
	 * @param port - the port number
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Gets the username used for authenticating SMTP server.
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/** 
	 * Sets the username used for authenticating SMTP server.
	 * @param username - the username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Gets the password.
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Set the password.
	 * @param password - the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets whether the SMTP Authentication is required or not.
	 * @return true if yes, false otherwise
	 */
	public boolean isSmtpAuthEnable() {
		return smtpAuthEnable;
	}
	
	/**
	 * Sets whether the SMTP Authentication is required or not.
	 * @param smtpAuthEnable - set to true if SMTP authentication is required, false otherwise
	 */
	public void setSmtpAuthEnable(boolean smtpAuthEnable) {
		this.smtpAuthEnable = smtpAuthEnable;
	}
	
	/**
	 * Gets whether to use SSL or TLS.
	 * @return ssl or tls
	 */
	public String getSslOrTls() {
		return sslOrTls;
	}
	
	/**
	 * Sets whether to use SSL or TLS.
	 * @param sslOrTls - ssl or tls
	 */
	public void setSslOrTls(String sslOrTls) {
		this.sslOrTls = sslOrTls;
	}
	
	/**
	 * Gets the from email.
	 * @return the from email
	 */
	public String getFromEmail() {
		return fromEmail;
	}
	
	/** 
	 * Sets the from email.
	 * @param fromEmail - the from email
	 */
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	/**
	 * Gets the path for storing photos.
	 * @return the path for storing photos
	 */
	public String getPhotosFolder() {
		return photosFolder;
	}

	/**
	 * Sets the path for storing photos
	 * @param photosFolder - the path for storing photos
	 */
	public void setPhotosFolder(String photosFolder) {
		this.photosFolder = photosFolder;
	}

	/**
	 * Gets the path for storing electronic documents.
	 * @return the path for storing electronic documents
	 */
	public String getEdocsFolder() {
		return edocsFolder;
	}

	/**
	 * Sets the path for storing electronic documents
	 * @param edocsFolder
	 */
	public void setEdocsFolder(String edocsFolder) {
		this.edocsFolder = edocsFolder;
	}

	/**
	 * Gets the path for temporary storage
	 * @return the path for temporary storage
	 */
	public String getWorksFolder() {
		return worksFolder;
	}

	/**
	 * Ste the path for temporary storage
	 * @param worksFolder - the path for temporary storage
	 */
	public void setWorksFolder(String worksFolder) {
		this.worksFolder = worksFolder;
	}

	/**
	 * Gets the organization name.
	 * @return the organization name
	 */
	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * Sets the organization name.
	 * @param organizationName - the organization name
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * Gets the organization address.
	 * @return the organization address
	 */
	public String getOrganizationAddress() {
		return organizationAddress;
	}

	/**
	 * Sets the organization address.
	 * @param organizationAddress - the organization address
	 */
	public void setOrganizationAddress(String organizationAddress) {
		this.organizationAddress = organizationAddress;
	}

	/**
	 * Gets the contact person name.
	 * @return the contact person name
	 */
	public String getContactName() {
		return contactName;
	}

	/**
	 * Sets the contact person name.
	 * @param contactName - the contact person name
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	/**
	 * Gets the contact person's address.
	 * @return the contact person's address
	 */
	public String getContactAddress() {
		return contactAddress;
	}

	/**
	 * Sets the contact person's address.
	 * @param contactAddress - the contact person's address
	 */
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	/**
	 * Gets the contact person's email.
	 * @return the contact person's email
	 */
	public String getContactEmail() {
		return contactEmail;
	}

	/**
	 * Sets the contact person's email.
	 * @param contactEmail - the contact person's email
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	/**
	 * Gets the site URL.
	 * @return the site URL
	 */
	public String getSiteUrl() {
		return siteUrl;
	}

	/**
	 * Sets the site URL.
	 * @param siteUrl - the site URL
	 */
	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}
	
}
