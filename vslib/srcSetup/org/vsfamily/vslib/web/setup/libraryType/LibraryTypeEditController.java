package org.vsfamily.vslib.web.setup.libraryType;

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
import org.vsfamily.vslib.common.domain.LibraryType;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;
import org.vsfamily.vslib.web.validators.edit.LibraryTypeEditValidator;

@Controller
@RequestMapping("/setup/libraryType/edit")
public class LibraryTypeEditController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	private LibraryTypeEditValidator libraryTypeEditValidator;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editLibraryType(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		LibraryType libraryType = (LibraryType) this.vslibService.getLibraryType(id);
		
		if (libraryType==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/libraryType/addNew";
		}
		
		model.addAttribute("libraryType", libraryType);
		return "setup/libraryType/libraryTypeEdit";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.POST)
	public String editLibraryType(@ModelAttribute LibraryType libraryType, BindingResult result, Model model,RedirectAttributes reat, Principal principal){
		LibraryType obj = (LibraryType) this.vslibService.getLibraryType(libraryType.getId());
		
		if (obj==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/libraryType/listAll";
		}
		
		this.libraryTypeEditValidator.validate(libraryType, result);
		
		if (result.hasErrors()){
			return "setup/libraryType/libraryTypeEdit";
		}
		
		obj.setCode(libraryType.getCode());
		obj.setName(libraryType.getName());
		
		obj.setUpdateDefaults(principal.getName());
		
		if (this.vslibService.updateLibraryType(obj)){
			reat.addFlashAttribute("message","Record updated successfully.");
			return "redirect:/setup/libraryType/listAll";
		} else {
			reat.addFlashAttribute("message","Record not updated.");
			return "redirect:/setup/libraryType/listAll/current";
		}
	}
}