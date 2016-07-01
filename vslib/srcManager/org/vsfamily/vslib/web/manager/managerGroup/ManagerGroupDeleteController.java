package org.vsfamily.vslib.web.manager.managerGroup;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.manager.domain.Manager;
import org.vsfamily.vslib.manager.domain.ManagerGroup;
import org.vsfamily.vslib.web.manager.ManagerBaseController;
import org.vsfamily.vslib.web.manager.service.ManagerService;

@Controller
@RequestMapping("/manager/managerGroup/delete")
public class ManagerGroupDeleteController extends ManagerBaseController {

	@Autowired
	ManagerService managerService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editManager(@PathVariable Long id, Model model, RedirectAttributes reat, Principal principal){
		
		ManagerGroup managerGroup = (ManagerGroup) this.managerService.getManagerGroup(id);
		
		if (managerGroup==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/manager/manager/addNew";
		}
		
		Manager manager = managerGroup.getManager();
		
		if (this.managerService.deleteManagerGroup(managerGroup)){
			reat.addFlashAttribute("message","Group removed successfully.");
			return "redirect:/manager/manager/view/" + manager.getId().toString();
		} else {
			reat.addFlashAttribute("message","Group not removed.");
			return "redirect:/manager/manager/view/" + manager.getId().toString();
		}
	}
}