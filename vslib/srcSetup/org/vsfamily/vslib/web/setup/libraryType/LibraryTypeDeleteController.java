package org.vsfamily.vslib.web.setup.libraryType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.LibraryType;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/libraryType/delete")
public class LibraryTypeDeleteController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String deleteLibraryType(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		LibraryType libraryType = (LibraryType) this.vslibService.getLibraryType(id);
		
		if (libraryType==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/libraryType/addNew";
		}
		
		if (this.vslibService.deleteLibraryType(libraryType)){
			reat.addFlashAttribute("message","Recored deleted successfully.");
			return "redirect:/setup/libraryType/addNew";
		} else {
			reat.addFlashAttribute("message","Record not deleted.");
			return "redirect:/setup/libraryType/listAll/current";
		}
	}
}