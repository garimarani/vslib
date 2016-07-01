package org.vsfamily.vslib.web.setup.itemType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.ItemType;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/itemType/delete")
public class ItemTypeDeleteController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String deleteItemType(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		ItemType itemType = (ItemType) this.vslibService.getItemType(id);
		
		if (itemType==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/itemType/addNew";
		}
		
		if (this.vslibService.deleteItemType(itemType)){
			reat.addFlashAttribute("message","Recored deleted successfully.");
			return "redirect:/setup/itemType/addNew";
		} else {
			reat.addFlashAttribute("message","Record not deleted.");
			return "redirect:/setup/itemType/listAll/current";
		}
	}
}