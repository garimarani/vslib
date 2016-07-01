package org.vsfamily.vslib.web.circulation.itemCheckIn;

import java.security.Principal;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Item;
import org.vsfamily.vslib.common.domain.ItemCheckIn;
import org.vsfamily.vslib.common.domain.ItemCheckOut;
import org.vsfamily.vslib.forms.CheckInForm;
import org.vsfamily.vslib.web.circulation.CirculationBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/circulation/checkIn")
public class ItemCheckInController extends CirculationBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String circulationCheckInItem(Model model, RedirectAttributes reat, Principal principal){
		
		CheckInForm checkInForm = new CheckInForm();
		
		model.addAttribute("checkInForm", checkInForm);
		
		return "circulation/itemCheckIn/itemCheckIn";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String circulationCheckInItem(@ModelAttribute CheckInForm checkInForm, BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		Item item = this.vslibService.getItemByNumber(checkInForm.getBarcodeNumber());
		
		if (item == null){
			reat.addFlashAttribute("No such Item record.");
			model.addAttribute("checkInForm", checkInForm);
			return "redirect:/circulation/checkIn";
		}
		
		ItemCheckOut itemCheckOut = this.vslibService.getItemCheckOutByItem(item);
		
		if (itemCheckOut == null){
			reat.addFlashAttribute("message", "Item is available on shelf.");
			model.addAttribute("item", item);
			return "redirect:/circulation/item/view/" + item.getId();
		}
		
		ItemCheckIn itemCheckIn = new ItemCheckIn();
		
		itemCheckIn.setCheckInDate(Calendar.getInstance());
		itemCheckIn.setCheckOutDate(itemCheckOut.getCheckOutDate());
		itemCheckIn.setDueDate(itemCheckOut.getDueDate());
		itemCheckIn.setFineAmount(itemCheckOut.getFine(Calendar.getInstance()));
		itemCheckIn.setItem(itemCheckOut.getItem());
		itemCheckIn.setPatron(itemCheckOut.getPatron());
		
		itemCheckIn.setAddDefaults(principal.getName());
		
		if (this.vslibService.deleteItemCheckOut(itemCheckOut)){
			reat.addFlashAttribute("message", "Item checked in successfully.");
			
			this.vslibService.addItemCheckIn(itemCheckIn);
			this.getCirculationEmailMessages().sendCheckInMessage(itemCheckIn);
			return "redirect:/circulation/itemCheckIn/view/" + itemCheckIn.getId();
		} else {
			reat.addFlashAttribute("message", "Item could not be checked in.");
			return "redirect:/circulation/checkIn";
		}
	}
}
