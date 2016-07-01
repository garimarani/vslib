package org.vsfamily.vslib.web.cataloguing.item;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Item;
import org.vsfamily.vslib.common.domain.ItemType;
import org.vsfamily.vslib.common.domain.Language;
import org.vsfamily.vslib.common.domain.LibraryBranch;
import org.vsfamily.vslib.common.domain.Subject;
import org.vsfamily.vslib.web.cataloguing.CataloguingBaseController;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.validators.edit.ItemEditValidator;

@Controller
@RequestMapping("/cataloguing/item/edit")
public class ItemEditController extends CataloguingBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	ItemEditValidator itemEditValidator;
	
	@ModelAttribute("listItemType")
	public List<ItemType> getListItemType(){
		return this.vslibService.listItemType();
	}
	
	@ModelAttribute("listLibraryBranch")
	public List<LibraryBranch> getListLibraryBranch(){
		return this.vslibService.listLibraryBranch();
	}
	
	@ModelAttribute("listSubject")
	public List<Subject> getListSubject(){
		return this.vslibService.listSubject();
	}
	
	@ModelAttribute("listLanguage")
	public List<Language> getListLanguage(){
		return this.vslibService.listLanguage();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editItem(@PathVariable Long id, Model model, RedirectAttributes reat, Principal principal){
		
		Item item = this.vslibService.getItem(id);
		
		if (item == null){
			reat.addFlashAttribute("message", "No such record.");
			return "redirect:/cataloguing/document/addNew";
		}
		
		model.addAttribute("item", item);
		
		return "cataloguing/item/itemEdit";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.POST)
	public String editItem(@ModelAttribute Item item, BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		Item obj = this.vslibService.getItem(item.getId());
		
		if (obj == null){
			reat.addFlashAttribute("message", "No such record.");
			return "redirect:/cataloguing/document/addNew";
		}
		
		this.itemEditValidator.validate(item, result);
		
		if (result.hasErrors()){
			return "cataloguing/item/itemEdit";
		}
		
		obj.setBarcodeNumber(item.getBarcodeNumber());
		obj.setClassNumber(item.getClassNumber());
		obj.setItemType(item.getItemType());
		obj.setLibraryBranch(item.getLibraryBranch());
		obj.setSubject(item.getSubject());
		obj.setLanguage(item.getLanguage());
		
		obj.setUpdateDefaults(principal.getName());
		
		if (this.vslibService.updateItem(obj)){
			reat.addFlashAttribute("message", "Record updated successfully.");
			return "redirect:/cataloguing/document/view/" + item.getDocument().getId().toString();
		} else {
			reat.addFlashAttribute("message", "Record no updated.");
			return "redirect:/cataloguing/document/view/" + item.getDocument().getId().toString();
		}
	}
}
