package org.vsfamily.vslib.web.setup.patronGroup;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.PatronGroup;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;
import org.vsfamily.vslib.web.validators.add.PatronGroupAddValidator;

@Controller
@RequestMapping("/setup/patronGroup/addNew")
public class PatronGroupAddController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	private PatronGroupAddValidator patronGroupAddValidator;
	
	@RequestMapping(method=RequestMethod.GET)
	public String addNew(Model model){
		model.addAttribute("patronGroup", new PatronGroup());
		return "setup/patronGroup/patronGroup";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addNew(@ModelAttribute PatronGroup patronGroup, 
			BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		
		this.patronGroupAddValidator.validate(patronGroup, result);
		if (result.hasErrors()){
			return "setup/patronGroup/patronGroup";
		}
		
		patronGroup.setAddDefaults(principal.getName());
		
		if (this.vslibService.addPatronGroup(patronGroup)){
			reat.addFlashAttribute("message","Record saved (" + patronGroup.getId() + ")");
			return "redirect:/setup/patronGroup/addNew";
		} else {
			reat.addFlashAttribute("message","Record not added! Try again later.");
			return "redirect:/setup/patronGroup/addNew";
		}
	}
}
