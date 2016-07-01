package org.vsfamily.vslib.web.manager.vslibGroup;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.manager.domain.VslibGroup;
import org.vsfamily.vslib.web.manager.ManagerBaseController;
import org.vsfamily.vslib.web.manager.service.ManagerService;
import org.vsfamily.vslib.web.manager.validators.VslibGroupAddValidator;

@Controller
@RequestMapping("/manager/group/addNew")
public class VslibGroupAddController extends ManagerBaseController {

	@Autowired
	ManagerService managerService;
	
	@Autowired
	private VslibGroupAddValidator vslibGroupAddValidator;
	
	@RequestMapping(method=RequestMethod.GET)
	public String addNew(Model model){
		model.addAttribute("vslibGroup", new VslibGroup());
		return "manager/vslibGroup/vslibGroup";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addNew(@ModelAttribute VslibGroup vslibGroup, 
			BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		
		this.vslibGroupAddValidator.validate(vslibGroup, result);
		if (result.hasErrors()){
			return "manager/vslibGroup/vslibGroup";
		}
		
		vslibGroup.setAddDefaults(principal.getName());
		
		if (this.managerService.addVslibGroup(vslibGroup)){
			reat.addFlashAttribute("message","Record saved (" + vslibGroup.getId() + ")");
			return "redirect:/manager/group/view/" + vslibGroup.getId().toString();
		} else {
			reat.addFlashAttribute("message","Record not added! Try again later.");
			return "redirect:/manager/vslibGroup/addNew";
		}
	}
}	