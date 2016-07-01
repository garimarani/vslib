package org.vsfamily.vslib.web.common.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vsfamily.vslib.common.domain.ItemCheckIn;
import org.vsfamily.vslib.common.domain.ItemCheckOut;
import org.vsfamily.vslib.common.domain.ItemHold;
import org.vsfamily.vslib.common.domain.ItemReserve;
import org.vsfamily.vslib.common.domain.VslibParams;
import org.vsfamily.vslib.forms.EmailMessageForm;
import org.vsfamily.vslib.web.service.VslibService;

@Component
public class CirculationEmailMessages {

	@Autowired
	MailMail mailMail;
	
	@Autowired
	VslibService vslibService;
	
	private VslibParams vslibParams;
	
	private void setVslibParams(){
		this.vslibParams = this.vslibService.getVslibParams();
	}

	public void sendCheckInMessage(ItemCheckIn itemCheckIn){
	
		this.setVslibParams();
		if (this.vslibParams == null) return;
		if (!this.vslibParams.isEnableEmail()) return;
		
		EmailMessageForm emf = new EmailMessageForm();
		
		emf.setToEmail(itemCheckIn.getPatron().getEmail());
		emf.setFromEmail(this.vslibParams.getFromEmail());
		emf.setSubject("Item Check In");
		emf.setMessage("Document Title / Author: " + itemCheckIn.getItem().getDocument().getUniformTitle()
				+ " / " + itemCheckIn.getItem().getDocument().getPrimaryAuthor()
				+ "\nBarcode Number: " + itemCheckIn.getItem().getBarcodeNumber()
				+ "\nCheck-Out Date: " + itemCheckIn.getCheckOutDate().getTime().toString()
				+ "\nDue Date: " + itemCheckIn.getDueDate().getTime().toString()
				+ "\nCheck-In Date : " + itemCheckIn.getCheckInDate().getTime().toString()
				+ "\nFine : " + itemCheckIn.getFineAmount().toString()
				);
		
		this.mailMail.sendSimpleMail(emf);
	}
	
	public void sendCheckOutMessage(ItemCheckOut itemCheckOut){
		
		this.setVslibParams();
		if (this.vslibParams == null) return;
		if (!this.vslibParams.isEnableEmail()) return;
		
		EmailMessageForm emf = new EmailMessageForm();
		
		emf.setToEmail(itemCheckOut.getPatron().getEmail());
		emf.setFromEmail(this.vslibParams.getFromEmail());
		emf.setSubject("Item Check Out");
		emf.setMessage("Document Title / Author: " + itemCheckOut.getItem().getDocument().getUniformTitle()
				+ " / " + itemCheckOut.getItem().getDocument().getPrimaryAuthor()
				+ "\nBarcode Number: " + itemCheckOut.getItem().getBarcodeNumber()
				+ "\nCheck-Out Date: " + itemCheckOut.getCheckOutDate().getTime().toString()
				+ "\nDue Date: " + itemCheckOut.getDueDate().getTime().toString()
				);
		
		this.mailMail.sendSimpleMail(emf);
	}
	
	public void sendHoldMessage(ItemHold itemHold){
		
		this.setVslibParams();
		if (this.vslibParams == null) return;
		if (!this.vslibParams.isEnableEmail()) return;
		
		EmailMessageForm emf = new EmailMessageForm();
		
		emf.setToEmail(itemHold.getPatron().getEmail());
		emf.setFromEmail(this.vslibParams.getFromEmail());
		emf.setSubject("Item Hold");
		emf.setMessage("Document Title / Author: " + itemHold.getItem().getDocument().getUniformTitle()
				+ " / " + itemHold.getItem().getDocument().getPrimaryAuthor()
				+ "\nBarcode Number: " + itemHold.getItem().getBarcodeNumber()
				+ "\nHold Date: " + itemHold.getHoldDate().getTime().toString()
				+ "\nHold Release Date: " + itemHold.getHoldReleaseDate().getTime().toString()
				);
		
		this.mailMail.sendSimpleMail(emf);
	}
	
	public void sendReserveMessage(ItemReserve itemReserve){
		
		this.setVslibParams();
		if (this.vslibParams == null) return;
		if (!this.vslibParams.isEnableEmail()) return;
		
		EmailMessageForm emf = new EmailMessageForm();
		
		emf.setToEmail(itemReserve.getPatron().getEmail());
		emf.setFromEmail(this.vslibParams.getFromEmail());
		emf.setSubject("Item Hold");
		emf.setMessage("Document Title / Author: " + itemReserve.getItem().getDocument().getUniformTitle()
				+ " / " + itemReserve.getItem().getDocument().getPrimaryAuthor()
				+ "\nBarcode Number: " + itemReserve.getItem().getBarcodeNumber()
				+ "\nReserve Date: " + itemReserve.getReserveDate().getTime().toString()
				+ "\nReserve Release Date: " + itemReserve.getReserveReleaseDate().getTime().toString()
				);
		
		this.mailMail.sendSimpleMail(emf);
	}
}
