package org.vsfamily.vslib.web.manager.vslibRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.manager.domain.VslibRole;
import org.vsfamily.vslib.web.manager.ManagerBaseController;
import org.vsfamily.vslib.web.manager.service.ManagerService;

@Controller
@RequestMapping("/manager/role/delete")
public class VslibRoleDeleteController extends ManagerBaseController {

	@Autowired
	ManagerService managerService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String deleteRole(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		VslibRole vslibRole = (VslibRole) this.managerService.getVslibRole(id);
		
		if (vslibRole==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/manager/group/addNew";
		}
		
		if (this.managerService.deleteVslibRole(vslibRole)){
			reat.addFlashAttribute("message","Role deleted successfully.");
			return "redirect:/manager/group/addNew";
		} else {
			reat.addFlashAttribute("message","Role not deleted.");
			return "redirect:/manager/group/listAll/current";
		}
	}
}
