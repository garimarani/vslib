package org.vsfamily.vslib.forms;

/**
 * EmailMessageForm class used for generating email messages.
 */
public class EmailMessageForm {

	private String			fromEmail;
	private String			toEmail;
	private String			subject;
	private String			message;
	
	/**
	 * Gets the email id of the sender.
	 * @return the email id of the sender
	 */
	public String getFromEmail() {
		return fromEmail;
	}
	
	/**
	 * Sets the email id of the sender.
	 * @param fromEmail - the email id of the sender
	 */
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	
	/**
	 * Gets the email id of the recipient.
	 * @return the email id of the recipient
	 */
	public String getToEmail() {
		return toEmail;
	}
	
	/**
	 * Sets the email id of the recipient.
	 * @param toEmail - the email id of the recipient
	 */
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	
	/**
	 * Gets the subject of the email message.
	 * @return the subject of the email message
	 */
	public String getSubject() {
		return subject;
	}
	
	/**
	 * Sets the subject of the email message.
	 * @param subject - the subject of the email message 
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	 * Gets the email message.
	 * @return the email message
	 */
	public String getMessage() {
		return message;
	}
	
	/** 
	 * Sets the email message.
	 * @param message - the email message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
