package org.vsfamily.vslib.web.profile.patron;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.ItemCheckIn;
import org.vsfamily.vslib.common.domain.Patron;
import org.vsfamily.vslib.web.profile.ProfileBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/profile/checkOutHistory")
public class CheckOutHistoryController extends ProfileBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String checkOutHistory(Model model, RedirectAttributes reat, Principal principal){
		
		Patron patron = this.vslibService.getPatronByLoginId(principal.getName());
		
		if (patron == null){
			reat.addFlashAttribute("message", "No such patron record.");
			return "redirect:/profile";
		}
		
		List<ItemCheckIn> listItemCheckIn = this.vslibService.listItemCheckIn(patron);
		
		model.addAttribute("listItemCheckIn", listItemCheckIn);
		model.addAttribute("patron", patron);
		
		return "profile/patron/checkOutHistory";
	}
}
