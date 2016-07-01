package org.vsfamily.vslib.web.circulation.itemCheckIn;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.ItemCheckIn;
import org.vsfamily.vslib.web.circulation.CirculationBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/circulation/itemCheckIn/view")
public class ItemCheckInViewController extends CirculationBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String viewItemCheckIn(@PathVariable Long id, Model model, RedirectAttributes reat, Principal principal){
		
		ItemCheckIn itemCheckIn = this.vslibService.getItemCheckIn(id);
		
		if (itemCheckIn == null){
			reat.addFlashAttribute("message", "No such check in record.");
			return "redirect:/circulation/checkIn";
		}
		
		model.addAttribute("itemCheckIn", itemCheckIn);
		
		return "circulation/itemCheckIn/itemCheckInView";
	}
}
