package org.vsfamily.vslib.web.circulation.patron;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Patron;
import org.vsfamily.vslib.forms.CheckOutForm;
import org.vsfamily.vslib.forms.HoldForm;
import org.vsfamily.vslib.forms.ReserveForm;
import org.vsfamily.vslib.web.circulation.CirculationBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/circulation/patron/view")
public class PatronViewController extends CirculationBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String viewPatron(@PathVariable Long id, Model model, RedirectAttributes reat, Principal principal){
		
		Patron patron = this.vslibService.getPatron(id);
		
		if (patron==null){
			reat.addFlashAttribute("message", "No such record.");
			return "redirect:/circulation/patron/addNew";
		}
		
		model.addAttribute("patron", patron);
		
		CheckOutForm checkOutForm = new CheckOutForm();
		checkOutForm.setPatron(patron);
		
		HoldForm holdForm = new HoldForm();
		holdForm.setPatron(patron);
		
		ReserveForm reserveForm = new ReserveForm();
		reserveForm.setPatron(patron);
		
		model.addAttribute("checkOutForm", checkOutForm);
		model.addAttribute("holdForm", holdForm);
		model.addAttribute("reserveForm", reserveForm);
		
		return "circulation/patron/patronView";
	}
	
	@RequestMapping(value="/itemCheckOut", method=RequestMethod.POST)
	public String doItemCheckOut(@ModelAttribute CheckOutForm checkOutForm, Model model, RedirectAttributes reat, Principal principal){
		
		checkOutForm.setUser(principal.getName());
		checkOutForm = this.vslibService.doCheckOut(checkOutForm);
		
		if (checkOutForm.isResult()){
			this.getCirculationEmailMessages().sendCheckOutMessage(checkOutForm.getItemCheckOut());
		}
		
		if (checkOutForm.getPatron()==null){
			reat.addFlashAttribute("message", "No such record.");
			return "redirect:/circulation/patron/addNew";
		} else {
			reat.addFlashAttribute("message", checkOutForm.getMessage());
			return "redirect:/circulation/patron/view/" + checkOutForm.getPatron().getId().toString();
		}
	}
	
	@RequestMapping(value="/itemHold", method=RequestMethod.POST)
	public String doItemHold(@ModelAttribute HoldForm holdForm, Model model, RedirectAttributes reat, Principal principal){
		
		holdForm.setUser(principal.getName());
		holdForm = this.vslibService.doHold(holdForm);
		
		if (holdForm.isResult()){
			this.getCirculationEmailMessages().sendHoldMessage(holdForm.getItemHold());
		}
		
		if (holdForm.getPatron()==null){
			reat.addFlashAttribute("message", "No such record.");
			return "redirect:/circulation/patron/addNew";
		} else {
			reat.addFlashAttribute("message", holdForm.getMessage());
			return "redirect:/circulation/patron/view/" + holdForm.getPatron().getId().toString();
		}
	}
	
	@RequestMapping(value="/itemReserve", method=RequestMethod.POST)
	public String doItemReserve(@ModelAttribute ReserveForm reserveForm, Model model, RedirectAttributes reat, Principal principal){
		
		reserveForm.setUser(principal.getName());
		reserveForm = this.vslibService.doReserve(reserveForm);
		
		if (reserveForm.isResult()){
			this.getCirculationEmailMessages().sendReserveMessage(reserveForm.getItemReserve());
		}
		if (reserveForm.getPatron()==null){
			reat.addFlashAttribute("message", "No such record.");
			return "redirect:/circulation/patron/addNew";
		} else {
			reat.addFlashAttribute("message", reserveForm.getMessage());
			return "redirect:/circulation/patron/view/" + reserveForm.getPatron().getId().toString();
		}
	}
}
