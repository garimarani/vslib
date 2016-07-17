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
	
}
