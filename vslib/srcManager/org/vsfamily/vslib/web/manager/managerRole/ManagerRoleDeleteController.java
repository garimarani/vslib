package org.vsfamily.vslib.web.manager.managerRole;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.manager.domain.Manager;
import org.vsfamily.vslib.manager.domain.ManagerRole;
import org.vsfamily.vslib.web.manager.ManagerBaseController;
import org.vsfamily.vslib.web.manager.service.ManagerService;

@Controller
@RequestMapping("/manager/managerRole/delete")
public class ManagerRoleDeleteController extends ManagerBaseController {

	@Autowired
	ManagerService managerService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editManager(@PathVariable Long id, Model model, RedirectAttributes reat, Principal principal){
		
		ManagerRole managerRole = (ManagerRole) this.managerService.getManagerRole(id);
		
		if (managerRole==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/manager/manager/addNew";
		}
		
		Manager manager = managerRole.getManager();
		
		if (this.managerService.deleteManagerRole(managerRole)){
			reat.addFlashAttribute("message","Role removed successfully.");
			return "redirect:/manager/manager/view/" + manager.getId().toString();
		} else {
			reat.addFlashAttribute("message","Role not removed.");
			return "redirect:/manager/manager/view/" + manager.getId().toString();
		}
	}
}
