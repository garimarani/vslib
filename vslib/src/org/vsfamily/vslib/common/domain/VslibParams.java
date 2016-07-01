package org.vsfamily.vslib.common.domain;

import org.vsfamily.vslib.common.VslibBaseClass;


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
	
	public boolean isEnableEmail() {
		return enableEmail;
	}
	public void setEnableEmail(boolean enableEmail) {
		this.enableEmail = enableEmail;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isSmtpAuthEnable() {
		return smtpAuthEnable;
	}
	public void setSmtpAuthEnable(boolean smtpAuthEnable) {
		this.smtpAuthEnable = smtpAuthEnable;
	}
	public String getSslOrTls() {
		return sslOrTls;
	}
	public void setSslOrTls(String sslOrTls) {
		this.sslOrTls = sslOrTls;
	}
	public String getFromEmail() {
		return fromEmail;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	
}
