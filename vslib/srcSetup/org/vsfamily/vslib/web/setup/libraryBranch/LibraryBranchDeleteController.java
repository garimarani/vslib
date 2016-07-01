package org.vsfamily.vslib.web.setup.libraryBranch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.LibraryBranch;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/libraryBranch/delete")
public class LibraryBranchDeleteController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String deleteLibraryBranch(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		LibraryBranch libraryBranch = (LibraryBranch) this.vslibService.getLibraryBranch(id);
		
		if (libraryBranch==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/libraryBranch/listAll";
		}
		
		if (this.vslibService.deleteLibraryBranch(libraryBranch)){
			reat.addFlashAttribute("message","Recored deleted successfully.");
			return "redirect:/setup/libraryBranch/addNew";
		} else {
			reat.addFlashAttribute("message","Record not deleted.");
			return "redirect:/setup/libraryBranch/listAll/current";
		}
	}
}