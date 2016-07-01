package org.vsfamily.vslib.web.manager.vslibGroup;

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
import org.vsfamily.vslib.manager.domain.GroupRole;
import org.vsfamily.vslib.manager.domain.VslibGroup;
import org.vsfamily.vslib.manager.domain.VslibRole;
import org.vsfamily.vslib.web.manager.ManagerBaseController;
import org.vsfamily.vslib.web.manager.service.ManagerService;

@Controller
@RequestMapping("/manager/group/view")
public class VslibGroupViewController extends ManagerBaseController {

	@Autowired
	ManagerService managerService;
	
	@ModelAttribute("listVslibRole")
	public List<VslibRole> getListVslibRole(){
		return this.managerService.listVslibRole();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String viewVslibGroup(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		VslibGroup vslibGroup = (VslibGroup) this.managerService.getVslibGroup(id);
		
		if (vslibGroup==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/manager/group/addNew";
		}
		
		List<GroupRole> listGroupRole = this.managerService.listGroupRole(vslibGroup);
		
		model.addAttribute("vslibGroup", vslibGroup);
		model.addAttribute("listGroupRole", listGroupRole);
		
		GroupRole groupRole = new GroupRole();
		groupRole.setGroup(vslibGroup);
		
		model.addAttribute("groupRole", groupRole);
		
		return "manager/vslibGroup/vslibGroupView";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.POST)
	public String addGroupRole(@ModelAttribute GroupRole groupRole, Model model, RedirectAttributes reat, Principal principal){
		
		groupRole.setAddDefaults(principal.getName());
		
		if (this.managerService.addGroupRole(groupRole)){
			reat.addFlashAttribute("message","Role added to Group.");
		} else {
			reat.addFlashAttribute("message","Role not added to Group.");
		}
		if (groupRole.getGroup()!=null){
			return "redirect:/manager/group/view/" + groupRole.getGroup().getId();
		} else {
			return "redirect:/manager/group/addNew";
		}
	}
}