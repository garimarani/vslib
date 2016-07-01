package org.vsfamily.vslib.web.setup.itemType;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.ItemType;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;
import org.vsfamily.vslib.web.validators.add.ItemTypeAddValidator;

@Controller
@RequestMapping("/setup/itemType/addNew")
public class ItemTypeAddController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	private ItemTypeAddValidator itemTypeAddValidator;
	
	@RequestMapping(method=RequestMethod.GET)
	public String addNew(Model model){
		model.addAttribute("itemType", new ItemType());
		return "setup/itemType/itemType";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addNew(@ModelAttribute ItemType itemType, 
			BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		
		this.itemTypeAddValidator.validate(itemType, result);
		if (result.hasErrors()){
			return "setup/itemType/itemType";
		}
		
		itemType.setAddDefaults(principal.getName());
		
		if (this.vslibService.addItemType(itemType)){
			reat.addFlashAttribute("message","Record saved (" + itemType.getId() + ")");
			return "redirect:/setup/itemType/addNew";
		} else {
			reat.addFlashAttribute("message","Record not added! Try again later.");
			return "redirect:/setup/itemType/addNew";
		}
	}
}