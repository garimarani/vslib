package org.vsfamily.vslib.web.setup.libraryType;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.LibraryType;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;
import org.vsfamily.vslib.web.validators.add.LibraryTypeAddValidator;

@Controller
@RequestMapping("/setup/libraryType/addNew")
public class LibraryTypeAddController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	private LibraryTypeAddValidator libraryTypeAddValidator;
	
	@RequestMapping(method=RequestMethod.GET)
	public String addNew(Model model){
		model.addAttribute("libraryType", new LibraryType());
		return "setup/libraryType/libraryType";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addNew(@ModelAttribute LibraryType libraryType, 
			BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		
		this.libraryTypeAddValidator.validate(libraryType, result);
		if (result.hasErrors()){
			return "setup/libraryType/libraryType";
		}
		
		libraryType.setAddDefaults(principal.getName());
		
		if (this.vslibService.addLibraryType(libraryType)){
			reat.addFlashAttribute("message","Record saved (" + libraryType.getId() + ")");
			return "redirect:/setup/libraryType/addNew";
		} else {
			reat.addFlashAttribute("message","Record not added! Try again later.");
			return "redirect:/setup/libraryType/addNew";
		}
	}
}
