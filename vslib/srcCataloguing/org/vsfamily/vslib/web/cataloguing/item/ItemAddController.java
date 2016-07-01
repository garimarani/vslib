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
import org.vsfamily.vslib.common.domain.Document;
import org.vsfamily.vslib.common.domain.Item;
import org.vsfamily.vslib.common.domain.ItemType;
import org.vsfamily.vslib.common.domain.Language;
import org.vsfamily.vslib.common.domain.LibraryBranch;
import org.vsfamily.vslib.common.domain.Subject;
import org.vsfamily.vslib.web.cataloguing.CataloguingBaseController;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.validators.add.ItemAddValidator;

@Controller
@RequestMapping("/cataloguing/item/addNew")
public class ItemAddController extends CataloguingBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	ItemAddValidator itemAddValidator;
	
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
	public String addItem(@PathVariable Long id, Model model, RedirectAttributes reat, Principal principal){
		
		Document document = this.vslibService.getDocument(id);
		
		if (document == null){
			reat.addFlashAttribute("message", "No such record.");
			return "redirect:/cataloguing/document/addNew";
		}
		
		Item item = new Item();
		item.setDocument(document);
		
		model.addAttribute("item", item);
		
		return "cataloguing/item/item";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.POST)
	public String addItem(@ModelAttribute Item item, BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		this.itemAddValidator.validate(item, result);
		
		if (result.hasErrors()){
			return "cataloguing/item/item";
		}
		
		item.setAddDefaults(principal.getName());
		
		if (this.vslibService.addItem(item)){
			reat.addFlashAttribute("message", "Record added successfully.");
		} else {
			reat.addFlashAttribute("message", "Record not added.");
		}
		
		return "redirect:/cataloguing/document/view/" + item.getDocument().getId().toString();
	}
}
