package org.vsfamily.vslib.web.manager.vslibGroup;

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
import org.vsfamily.vslib.manager.domain.VslibGroup;
import org.vsfamily.vslib.web.manager.ManagerBaseController;
import org.vsfamily.vslib.web.manager.service.ManagerService;
import org.vsfamily.vslib.web.manager.validators.VslibGroupEditValidator;

@Controller
@RequestMapping("/manager/group/edit")
public class VslibGroupEditController extends ManagerBaseController {

	@Autowired
	ManagerService managerService;
	
	@Autowired
	private VslibGroupEditValidator vslibGroupEditValidator;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editVslibGroup(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		VslibGroup vslibGroup = (VslibGroup) this.managerService.getVslibGroup(id);
		
		if (vslibGroup==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/manager/group/addNew";
		}
		
		model.addAttribute("vslibGroup", vslibGroup);
		return "manager/vslibGroup/vslibGroupEdit";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.POST)
	public String editVslibGroup(@ModelAttribute VslibGroup vslibGroup, BindingResult result, Model model,RedirectAttributes reat, Principal principal){
		
		VslibGroup obj = (VslibGroup) this.managerService.getVslibGroup(vslibGroup.getId());
		
		if (obj==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/manager/group/addNew";
		}
		
		this.vslibGroupEditValidator.validate(vslibGroup, result);
		
		if (result.hasErrors()){
			return "manager/vslibGroup/vslibGroupEdit";
		}
		
		obj.setCode(vslibGroup.getCode());
		obj.setName(vslibGroup.getName());
		
		obj.setUpdateDefaults(principal.getName());
		
		if (this.managerService.updateVslibGroup(obj)){
			reat.addFlashAttribute("message","Record updated successfully.");
			return "redirect:/manager/group/listAll";
		} else {
			reat.addFlashAttribute("message","Record not updated.");
			return "redirect:/manager/group/listAll/current";
		}
		
	}
}
