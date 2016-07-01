package org.vsfamily.vslib.web.setup.library;

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
import org.vsfamily.vslib.common.domain.Library;
import org.vsfamily.vslib.common.domain.LibraryType;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;
import org.vsfamily.vslib.web.validators.edit.LibraryEditValidator;

@Controller
@RequestMapping("/setup/library/edit")
public class LibraryEditController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	private LibraryEditValidator libraryEditValidator;
	
	@ModelAttribute("listLibraryType")
	public List<LibraryType> getListLibraryType(){
		return this.vslibService.listLibraryType();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editLibrary(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		Library library = (Library) this.vslibService.getLibrary(id);
		
		if (library==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/library/addNew";
		}
		
		model.addAttribute("library", library);
		return "setup/library/libraryEdit";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.POST)
	public String editLibrary(@ModelAttribute Library library, BindingResult result, Model model,RedirectAttributes reat, Principal principal){
		Library obj = (Library) this.vslibService.getLibrary(library.getId());
		
		if (obj==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/library/listAll";
		}
		
		this.libraryEditValidator.validate(library, result);
		
		if (result.hasErrors()){
			return "vslib/library/libraryEdit";
		}
		
		obj.setCode(library.getCode());
		obj.setName(library.getName());
		obj.getAddress().setAddressValues(library.getAddress());
		obj.setLibraryType(library.getLibraryType());
		obj.setAbout(library.getAbout());
		
		obj.setUpdateDefaults(principal.getName());
		
		if (this.vslibService.updateLibrary(obj)){
			reat.addFlashAttribute("message","Record updated successfully.");
			return "redirect:/setup/library/listAll";
		} else {
			reat.addFlashAttribute("message","Record not updated.");
			return "redirect:/setup/library/listAll/current";
		}
	}
}