package org.vsfamily.vslib.web.manager.groupRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.manager.domain.GroupRole;
import org.vsfamily.vslib.web.manager.ManagerBaseController;
import org.vsfamily.vslib.web.manager.service.ManagerService;

@Controller
@RequestMapping("/manager/groupRole/delete")
public class GroupRoleDeleteController extends ManagerBaseController {

	@Autowired
	ManagerService managerService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String deleteGroupRole(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		GroupRole groupRole = (GroupRole) this.managerService.getGroupRole(id);
		
		if (groupRole==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/manager/group/addNew";
		}
		
		String groupId = groupRole.getId().toString();
		
		if (this.managerService.deleteGroupRole(groupRole)){
			reat.addFlashAttribute("message","Role deleted from Group.");
			return "redirect:/manager/group/view/" + groupId;
		} else {
			reat.addFlashAttribute("message","Role not deleted from Group.");
			return "redirect:/manager/group/view/" + groupId;
		}
	}
}
