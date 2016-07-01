package org.vsfamily.vslib.web.setup.patronGroup;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.PatronGroup;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;
import org.vsfamily.vslib.web.validators.edit.PatronGroupEditValidator;

@Controller
@RequestMapping("/setup/patronGroup/edit")
public class PatronGroupEditController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	private PatronGroupEditValidator patronGroupEditValidator;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editPatronGroup(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		PatronGroup patronGroup = (PatronGroup) this.vslibService.getPatronGroup(id);
		
		if (patronGroup==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/patronGroup/addNew";
		}
		
		model.addAttribute("patronGroup", patronGroup);
		return "setup/patronGroup/patronGroupEdit";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.POST)
	public String editPatronGroup(@ModelAttribute PatronGroup patronGroup, BindingResult result, Model model,RedirectAttributes reat, Principal principal){
		PatronGroup obj = (PatronGroup) this.vslibService.getPatronGroup(patronGroup.getId());
		
		if (obj==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/patronGroup/listAll";
		}
		
		this.patronGroupEditValidator.validate(patronGroup, result);
		
		if (result.hasErrors()){
			return "setup/patronGroup/patronGroupEdit";
		}
		
		obj.setCode(patronGroup.getCode());
		obj.setName(patronGroup.getName());
		
		obj.setUpdateDefaults(principal.getName());
		
		if (this.vslibService.updatePatronGroup(obj)){
			reat.addFlashAttribute("message","Record updated successfully.");
			return "redirect:/setup/patronGroup/listAll";
		} else {
			reat.addFlashAttribute("message","Record not updated.");
			return "redirect:/setup/patronGroup/listAll/current";
		}
	}
}