package org.vsfamily.vslib.web.circulation.itemReserve;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.ItemReserve;
import org.vsfamily.vslib.common.domain.Patron;
import org.vsfamily.vslib.web.circulation.CirculationBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/circulation/itemReserve/delete")
public class ItemReserveRemoveController extends CirculationBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String deleteItemReserve(@PathVariable Long id, Model model, RedirectAttributes reat, Principal principal){
		
		ItemReserve itemReserve = this.vslibService.getItemReserve(id);
		
		if (itemReserve == null){
			reat.addFlashAttribute("message", "Item Hold - No such a record.");
			return "redirect:/circulation/search";
		}
		
		Patron patron = itemReserve.getPatron();
		
		if (this.vslibService.deleteItemReserve(itemReserve)){
			reat.addFlashAttribute("message", "Reservation on Item is removed.");
		} else {
			reat.addFlashAttribute("message", "Reservation on Item not removed.");
		}
		return "redirect:/circulation/patron/view/" + patron.getId().toString();
	}
}
