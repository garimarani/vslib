package org.vsfamily.vslib.web.circulation.item;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Item;
import org.vsfamily.vslib.web.circulation.CirculationBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/circulation/item/view")
public class ItemViewController extends CirculationBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String viewItem(Model model){
		
		Item item = new Item();
		
		model.addAttribute("item", item);
		return "circulation/item/item";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String viewItem(@PathVariable Long id, Model model, RedirectAttributes reat, Principal principal){
		
		Item item = this.vslibService.getItem(id);
		
		if (item == null){
			reat.addFlashAttribute("message", "No such Item record.");
			return "redirect:/circulation/item/view";
		}
		
		model.addAttribute("item", item);
		return "circulation/item/itemView";
	}
	
	@RequestMapping(value="/barcodeNumber/{barcodeNumber}", method=RequestMethod.GET)
	public String viewItem(@PathVariable String barcodeNumber, Model model, RedirectAttributes reat, Principal principal){
		
		Item item = this.vslibService.getItemByNumber(barcodeNumber);
		
		if (item == null){
			reat.addFlashAttribute("message", "No such Item record.");
			return "redirect:/circulation/item/view";
		}
		
		model.addAttribute("item", item);
		return "circulation/item/itemView";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String viewItem(@ModelAttribute Item item, Model model, RedirectAttributes reat, Principal principal){

		Item obj = this.vslibService.getItemByNumber(item.getBarcodeNumber());
		
		if (obj == null){
			reat.addFlashAttribute("message", "No such Item record.");
			return "redirect:/circulation/item/view";
		}
		
		model.addAttribute("item", obj);
		return "circulation/item/itemView";
	}
}
