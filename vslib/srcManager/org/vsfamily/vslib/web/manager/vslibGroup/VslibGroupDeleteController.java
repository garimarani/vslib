package org.vsfamily.vslib.web.manager.vslibGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.manager.domain.VslibGroup;
import org.vsfamily.vslib.web.manager.ManagerBaseController;
import org.vsfamily.vslib.web.manager.service.ManagerService;

@Controller
@RequestMapping("/manager/group/delete")
public class VslibGroupDeleteController extends ManagerBaseController {

	@Autowired
	ManagerService managerService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String deleteGroup(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		VslibGroup vslibGroup = (VslibGroup) this.managerService.getVslibGroup(id);
		
		if (vslibGroup==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/manager/group/addNew";
		}
		
		String groupId = vslibGroup.getId().toString();
		
		if (this.managerService.deleteVslibGroup(vslibGroup)){
			reat.addFlashAttribute("message","Group deleted successfully.");
			return "redirect:/manager/group/view/" + groupId;
		} else {
			reat.addFlashAttribute("message","Group not deleted.");
			return "redirect:/manager/group/view/" + groupId;
		}
	}
}
