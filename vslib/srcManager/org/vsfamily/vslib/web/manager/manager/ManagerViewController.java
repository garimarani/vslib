package org.vsfamily.vslib.web.manager.manager;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.manager.domain.Manager;
import org.vsfamily.vslib.manager.domain.ManagerGroup;
import org.vsfamily.vslib.manager.domain.ManagerRole;
import org.vsfamily.vslib.manager.domain.VslibGroup;
import org.vsfamily.vslib.manager.domain.VslibRole;
import org.vsfamily.vslib.web.manager.ManagerBaseController;
import org.vsfamily.vslib.web.manager.service.ManagerService;

@Controller
@RequestMapping("/manager/manager/view")
public class ManagerViewController extends ManagerBaseController {

	@Autowired
	ManagerService managerService;
	
	@ModelAttribute("listVslibGroup")
	public List<VslibGroup> getListVslibGroup(){
		return this.managerService.listVslibGroup();
	}
	
	@ModelAttribute("listVslibRole")
	public List<VslibRole> getListVslibRole(){
		return this.managerService.listVslibRole();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editManager(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		Manager manager = (Manager) this.managerService.getManager(id);
		
		if (manager==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/manager/manager/addNew";
		}
		
		List<ManagerGroup> listManagerGroup = this.managerService.listManagerGroup(manager);
		List<ManagerRole> listManagerRole = this.managerService.listManagerRole(manager);
		
		ManagerRole managerRole = new ManagerRole();
		managerRole.setManager(manager);
		
		ManagerGroup managerGroup = new ManagerGroup();
		managerGroup.setManager(manager);;
		
		model.addAttribute("manager", manager);
		model.addAttribute("managerGroup", managerGroup);
		model.addAttribute("managerRole", managerRole);
		
		model.addAttribute("listManagerRole", listManagerRole);
		model.addAttribute("listManagerGroup", listManagerGroup);
		
		return "manager/manager/managerView";
	}
	
	@RequestMapping(value="/managerGroup", method=RequestMethod.POST)
	public String addManagerGroup(@ModelAttribute ManagerGroup managerGroup, Model model,RedirectAttributes reat, Principal principal){
		
		if (managerGroup.getManager()==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/manager/manager/addNew";
		}
		
		managerGroup.setAddDefaults(principal.getName());
		
		if (this.managerService.addManagerGroup(managerGroup)){
			reat.addFlashAttribute("message","Group added successfully.");
			return "redirect:/manager/manager/view/" + managerGroup.getManager().getId().toString();
		} else {
			reat.addFlashAttribute("message","Group not added.");
			return "redirect:/manager/manager/view/" + managerGroup.getManager().getId().toString();
		}
	}
	
	@RequestMapping(value="/managerRole", method=RequestMethod.POST)
	public String addManagerRole(@ModelAttribute ManagerRole managerRole, Model model,RedirectAttributes reat, Principal principal){
		
		if (managerRole.getManager()==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/manager/manager/addNew";
		}
		
		managerRole.setAddDefaults(principal.getName());
		
		if (this.managerService.addManagerRole(managerRole)){
			reat.addFlashAttribute("message","Role added successfully.");
			return "redirect:/manager/manager/view/" + managerRole.getManager().getId().toString();
		} else {
			reat.addFlashAttribute("message","Role not added.");
			return "redirect:/manager/manager/view/" + managerRole.getManager().getId().toString();
		}
	}
}
