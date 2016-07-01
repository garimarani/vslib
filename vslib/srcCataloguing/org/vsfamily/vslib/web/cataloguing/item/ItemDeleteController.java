package org.vsfamily.vslib.web.cataloguing.item;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Item;
import org.vsfamily.vslib.web.cataloguing.CataloguingBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/cataloguing/item/delete")
public class ItemDeleteController extends CataloguingBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String deleteItem(@PathVariable Long id, Model model, RedirectAttributes reat, Principal principal){
		
		Item item = this.vslibService.getItem(id);
		
		if (item == null){
			reat.addFlashAttribute("message", "No such record.");
			return "redirect:/cataloguing/document/addNew";
		}
		
		String documentId = item.getDocument().getId().toString();
		
		if (this.vslibService.deleteItem(item)){
			reat.addFlashAttribute("message", "Record deleted successfully.");
			return "redirect:/cataloguing/document/view/" + documentId;
		} else {
			reat.addFlashAttribute("message", "Record not deleted.");
			return "redirect:/cataloguing/document/view/" + documentId;
		}
	}
}
