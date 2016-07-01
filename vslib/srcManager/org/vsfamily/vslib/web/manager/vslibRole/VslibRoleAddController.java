package org.vsfamily.vslib.web.manager.vslibRole;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.manager.domain.VslibRole;
import org.vsfamily.vslib.web.manager.ManagerBaseController;
import org.vsfamily.vslib.web.manager.service.ManagerService;
import org.vsfamily.vslib.web.manager.validators.VslibRoleAddValidator;

@Controller
@RequestMapping("/manager/role/addNew")
public class VslibRoleAddController extends ManagerBaseController {

	@Autowired
	ManagerService managerService;
	
	@Autowired
	private VslibRoleAddValidator vslibRoleAddValidator;
	
	@RequestMapping(method=RequestMethod.GET)
	public String addNew(Model model){
		model.addAttribute("vslibRole", new VslibRole());
		return "manager/vslibRole/vslibRole";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addNew(@ModelAttribute VslibRole vslibRole, 
			BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		
		this.vslibRoleAddValidator.validate(vslibRole, result);
		if (result.hasErrors()){
			return "manager/vslibRole/vslibRole";
		}
		
		vslibRole.setAddDefaults(principal.getName());
		
		if (this.managerService.addVslibRole(vslibRole)){
			reat.addFlashAttribute("message","Record saved (" + vslibRole.getId() + ")");
			return "redirect:/manager/role/addNew";
		} else {
			reat.addFlashAttribute("message","Record not added! Try again later.");
			return "redirect:/manager/role/addNew";
		}
	}
}	