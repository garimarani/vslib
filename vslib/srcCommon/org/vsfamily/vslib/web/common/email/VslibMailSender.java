package org.vsfamily.vslib.web.common.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.vsfamily.vslib.common.domain.VslibParams;
import org.vsfamily.vslib.web.service.VslibService;

@Component
public class VslibMailSender extends JavaMailSenderImpl {

	@Autowired
	VslibService vslibService;

	public void setParameters() {
		VslibParams vslibParams = this.vslibService.getVslibParams();
		
		if (vslibParams != null){
			this.setHost(vslibParams.getHost());
			this.setPort(new Long(vslibParams.getPort()).intValue());
			this.setUsername(vslibParams.getUsername());
			this.setPassword(vslibParams.getPassword());
			this.getJavaMailProperties().put("mail.smtp.auth", true);
			if (vslibParams.getSslOrTls().equals("TLS")) this.getJavaMailProperties().put("mail.smtp.starttls.enable", true);
		}
	}
}
