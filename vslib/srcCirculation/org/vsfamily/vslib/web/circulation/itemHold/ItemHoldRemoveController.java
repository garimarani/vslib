package org.vsfamily.vslib.web.circulation.itemHold;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.ItemHold;
import org.vsfamily.vslib.common.domain.Patron;
import org.vsfamily.vslib.web.circulation.CirculationBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/circulation/itemHold/delete")
public class ItemHoldRemoveController extends CirculationBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String deleteItemHold(@PathVariable Long id, Model model, RedirectAttributes reat, Principal principal){
		
		ItemHold itemHold = this.vslibService.getItemHold(id);
		
		if (itemHold == null){
			reat.addFlashAttribute("message", "Item Hold - No such a record.");
			return "redirect:/circulation/search";
		}
		
		Patron patron = itemHold.getPatron();
		
		if (this.vslibService.deleteItemHold(itemHold)){
			reat.addFlashAttribute("message", "Hold on Item is removed.");
		} else {
			reat.addFlashAttribute("message", "Hold on Item not removed.");
		}
		return "redirect:/circulation/patron/view/" + patron.getId().toString();
	}
}
