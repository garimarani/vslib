package org.vsfamily.vslib.web.setup.libraryBranch;

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
import org.vsfamily.vslib.common.domain.LibraryBranch;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;
import org.vsfamily.vslib.web.validators.edit.LibraryBranchEditValidator;

@Controller
@RequestMapping("/setup/libraryBranch/edit")
public class LibraryBranchEditController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	private LibraryBranchEditValidator libraryBranchEditValidator;
	
	@ModelAttribute("listLibrary")
	public List<Library> getListLibrary(){
		return this.vslibService.listLibrary();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editLibraryBranch(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		LibraryBranch libraryBranch = (LibraryBranch) this.vslibService.getLibraryBranch(id);
		
		if (libraryBranch==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/libraryBranch/listAll";
		}
		
		model.addAttribute("libraryBranch", libraryBranch);
		return "setup/libraryBranch/libraryBranchEdit";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.POST)
	public String editLibraryBranch(@ModelAttribute LibraryBranch libraryBranch, BindingResult result, Model model,RedirectAttributes reat, Principal principal){
		LibraryBranch obj = (LibraryBranch) this.vslibService.getLibraryBranch(libraryBranch.getId());
		
		if (obj==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/libraryBranch/listAll";
		}
		
		this.libraryBranchEditValidator.validate(libraryBranch, result);
		
		if (result.hasErrors()){
			return "setup/libraryBranch/libraryBranchEdit";
		}
		
		obj.setCode(libraryBranch.getCode());
		obj.setName(libraryBranch.getName());
		obj.getAddress().setAddressValues(libraryBranch.getAddress());
		obj.setLibrary(libraryBranch.getLibrary());
		obj.setContactPersonName(libraryBranch.getContactPersonName());
		obj.setEmail(libraryBranch.getEmail());
		
		obj.setUpdateDefaults(principal.getName());
		
		if (this.vslibService.updateLibraryBranch(obj)){
			reat.addFlashAttribute("message","Record updated successfully.");
			return "redirect:/setup/libraryBranch/listAll";
		} else {
			reat.addFlashAttribute("message","Record not updated.");
			return "redirect:/setup/libraryBranch/listAll/current";
		}
	}
}