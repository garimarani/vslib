package org.vsfamily.vslib.common.domain;

import java.util.Calendar;

import org.vsfamily.vslib.common.VslibBaseClass;

/**
 * ErrorMessages class is for storing errors/messages generated in some
 * special operations.
 */
@SuppressWarnings("serial")
public class ErrorMessages extends VslibBaseClass {

	private Calendar 			messageDate;
	private String				messageText;
	
	/**
	 * Gets the message date.
	 * @return the message date
	 */
	public Calendar getMessageDate() {
		return messageDate;
	}
	
	/**
	 * Sets the message date.
	 * @param messageDate - the message date
	 */
	public void setMessageDate(Calendar messageDate) {
		this.messageDate = messageDate;
	}
	
	/**
	 * Gets the message text.
	 * @return the message text
	 */
	public String getMessageText() {
		return messageText;
	}
	
	/**
	 * Sets the message text.
	 * @param messageText - the message text
	 */
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	
	/**
	 * Gets the first 50 characters of the message text
	 * @return the first 50 characters of the message text
	 */
	public String getShortMessage(){
		if (this.getMessageText()!=null){
			if (this.getMessageText().length()>50){
				return this.getMessageText().substring(0, 50).replaceAll("<br/>", ". ");
			} else {
				return this.getMessageText().replaceAll("<br/>", ". ");
			}
		} else {
			return "";
		}
	}
	
}
