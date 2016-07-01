package org.vsfamily.vslib.web.setup.itemType;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.ItemType;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;
import org.vsfamily.vslib.web.validators.edit.ItemTypeEditValidator;

@Controller
@RequestMapping("/setup/itemType/edit")
public class ItemTypeEditController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	private ItemTypeEditValidator itemTypeEditValidator;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editItemType(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		ItemType itemType = (ItemType) this.vslibService.getItemType(id);
		
		if (itemType==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/itemType/addNew";
		}
		
		model.addAttribute("itemType", itemType);
		return "setup/itemType/itemTypeEdit";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.POST)
	public String editItemType(@ModelAttribute ItemType itemType, BindingResult result, Model model,RedirectAttributes reat, Principal principal){
		ItemType obj = (ItemType) this.vslibService.getItemType(itemType.getId());
		
		if (obj==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/itemType/listAll";
		}
		
		this.itemTypeEditValidator.validate(itemType, result);
		
		if (result.hasErrors()){
			return "setup/itemType/itemTypeEdit";
		}
		
		obj.setCode(itemType.getCode());
		obj.setName(itemType.getName());
		obj.setMaximumCheckOutPeriod(itemType.getMaximumCheckOutPeriod());
		obj.setMaximumHoldPeriod(itemType.getMaximumHoldPeriod());
		obj.setMaximumReservePeriod(itemType.getMaximumReservePeriod());
		
		obj.setUpdateDefaults(principal.getName());
		
		if (this.vslibService.updateItemType(obj)){
			reat.addFlashAttribute("message","Record updated successfully.");
			return "redirect:/setup/itemType/listAll";
		} else {
			reat.addFlashAttribute("message","Record not updated.");
			return "redirect:/setup/itemType/listAll/current";
		}
	}
}