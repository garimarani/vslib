package org.vsfamily.vslib.web.common.email;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.vsfamily.vslib.forms.EmailMessageForm;

@Component
public class MailMail {

	@Autowired
	VslibMailSender vslibMailSender;
	
	protected final Logger logger = Logger.getLogger(this.getClass());
	
	public boolean sendSimpleMail(EmailMessageForm emf) {

		vslibMailSender.setParameters();
		
		try {
	        SimpleMailMessage message = new SimpleMailMessage();
	
	        message.setFrom(emf.getFromEmail());
	        message.setTo(emf.getToEmail());
	        message.setSubject(emf.getSubject());
	        message.setText(emf.getMessage());
	        vslibMailSender.send(message);
	        return true;
		} catch (Exception e){
			logger.info(e);
			return false;
		}
    }
}
