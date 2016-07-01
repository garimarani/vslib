package org.vsfamily.vslib.web.setup.libraryBranch;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Library;
import org.vsfamily.vslib.common.domain.LibraryBranch;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;
import org.vsfamily.vslib.web.validators.add.LibraryBranchAddValidator;

@Controller
@RequestMapping("/setup/libraryBranch/addNew")
public class LibraryBranchAddController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	private LibraryBranchAddValidator libraryBranchAddValidator;
	
	@ModelAttribute("listLibrary")
	public List<Library> getListLibrary(){
		return this.vslibService.listLibrary();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String addNew(Model model){
		model.addAttribute("libraryBranch", new LibraryBranch());
		return "setup/libraryBranch/libraryBranch";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addNew(@ModelAttribute LibraryBranch libraryBranch, 
			BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		
		this.libraryBranchAddValidator.validate(libraryBranch, result);
		if (result.hasErrors()){
			return "setup/libraryBranch/libraryBranch";
		}
		
		libraryBranch.setAddDefaults(principal.getName());
		
		if (this.vslibService.addLibraryBranch(libraryBranch)){
			reat.addFlashAttribute("message","Record saved (" + libraryBranch.getId() + ")");
			return "redirect:/setup/libraryBranch/addNew";
		} else {
			reat.addFlashAttribute("message","Record not added! Try again later.");
			return "redirect:/setup/libraryBranch/addNew";
		}
	}
}
