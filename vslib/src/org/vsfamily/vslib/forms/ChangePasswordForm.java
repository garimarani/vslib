package org.vsfamily.vslib.forms;

/**
 * ChangePasswordForm class used while generating form for changing password.
 */
public class ChangePasswordForm {
	
	private String			password;
	private String 			changePassword;
	private String			retypePassword;
	
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

	/**
	 * Gets the retyped password.
	 * @return the retyped password
	 */
	public String getRetypePassword() {
		return retypePassword;
	}

	/**
	 * Sets the retyped password
	 * @param retypePassword - the retyped password
	 */
	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}
	
}
