package org.vsfamily.vslib.web.manager.vslibRole;

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
import org.vsfamily.vslib.manager.domain.VslibRole;
import org.vsfamily.vslib.web.manager.ManagerBaseController;
import org.vsfamily.vslib.web.manager.service.ManagerService;
import org.vsfamily.vslib.web.manager.validators.VslibRoleEditValidator;

@Controller
@RequestMapping("/manager/role/edit")
public class VslibRoleEditController extends ManagerBaseController {

	@Autowired
	ManagerService managerService;
	
	@Autowired
	private VslibRoleEditValidator vslibRoleEditValidator;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editVslibRole(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		VslibRole vslibRole = (VslibRole) this.managerService.getVslibRole(id);
		
		if (vslibRole==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/manager/role/addNew";
		}
		
		model.addAttribute("vslibRole", vslibRole);
		return "manager/vslibRole/vslibRoleEdit";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.POST)
	public String editVslibRole(@ModelAttribute VslibRole vslibRole, BindingResult result, Model model,RedirectAttributes reat, Principal principal){
		
		VslibRole obj = (VslibRole) this.managerService.getVslibRole(vslibRole.getId());
		
		if (obj==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/manager/role/addNew";
		}
		
		this.vslibRoleEditValidator.validate(vslibRole, result);
		
		if (result.hasErrors()){
			return "manager/vslibRole/vslibRoleEdit";
		}
		
		obj.setCode(vslibRole.getCode());
		obj.setName(vslibRole.getName());
		
		obj.setUpdateDefaults(principal.getName());
		
		if (this.managerService.updateVslibRole(obj)){
			reat.addFlashAttribute("message","Record updated successfully.");
			return "redirect:/manager/role/listAll";
		} else {
			reat.addFlashAttribute("message","Record not updated.");
		}
		return "redirect:/manager/role/listAll/current";
	}
}
