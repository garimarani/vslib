package org.vsfamily.vslib.forms;

/**
 * ChangePasswordForm class used while generating form for changing password.
 */
public class ChangePasswordForm {
	
	private String			password;
	private String 			changePassword;
	
	/**
	 * Gets the password.
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 * @param password - the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the change password.
	 * @return the change password
	 */
	public String getChangePassword() {
		return changePassword;
	}
	
	/**
	 * Sets the change password
	 * @param changePassword - the change password
	 */
	public void setChangePassword(String changePassword) {
		this.changePassword = changePassword;
	}
	
}
