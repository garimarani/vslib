package org.vsfamily.vslib.web.setup.patronGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.PatronGroup;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/patronGroup/delete")
public class PatronGroupDeleteController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String deletePatronGroup(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		PatronGroup patronGroup = (PatronGroup) this.vslibService.getPatronGroup(id);
		
		if (patronGroup==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/patronGroup/addNew";
		}
		
		if (this.vslibService.deletePatronGroup(patronGroup)){
			reat.addFlashAttribute("message","Recored deleted successfully.");
			return "redirect:/setup/patronGroup/addNew";
		} else {
			reat.addFlashAttribute("message","Record not deleted.");
			return "redirect:/setup/patronGroup/current";
		}
	}
}