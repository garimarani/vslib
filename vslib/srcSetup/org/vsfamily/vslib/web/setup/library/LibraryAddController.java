package org.vsfamily.vslib.web.setup.library;

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
import org.vsfamily.vslib.common.domain.LibraryType;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;
import org.vsfamily.vslib.web.validators.add.LibraryAddValidator;

@Controller
@RequestMapping("/setup/library/addNew")
public class LibraryAddController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	private LibraryAddValidator libraryAddValidator;
	
	@ModelAttribute("listLibraryType")
	public List<LibraryType> getListLibraryType(){
		return this.vslibService.listLibraryType();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String addNew(Model model){
		model.addAttribute("library", new Library());
		return "setup/library/library" ;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addNew(@ModelAttribute Library library, 
			BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		
		this.libraryAddValidator.validate(library, result);
		if (result.hasErrors()){
			return "setup/library/library";
		}
		 
		library.setAddDefaults(principal.getName());
		
		if (this.vslibService.addLibrary(library)){
			reat.addFlashAttribute("message","Record saved (" + library.getId() + ")");
			return "redirect:/setup/library/addNew";
		} else {
			reat.addFlashAttribute("message","Record not added! Try again later.");
			return "redirect:/setup/library/addNew";
		}
	}
}
