package org.vsfamily.vslib.web.setup.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Library;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/library/delete")
public class LibraryDeleteController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String deleteLibrary(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		Library library = (Library) this.vslibService.getLibrary(id);
		
		if (library==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/library/addNew";
		}
		
		if (this.vslibService.deleteLibrary(library)){
			reat.addFlashAttribute("message","Recored deleted successfully.");
			return "redirect:/setup/library/addNew";
		} else {
			reat.addFlashAttribute("message","Record not deleted.");
			return "redirect:/setup/library/listAll/current";
		}
	}
}