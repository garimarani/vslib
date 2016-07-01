package org.vsfamily.vslib.web.manager.manager;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.common.domain.Salutation;
import org.vsfamily.vslib.manager.domain.Manager;
import org.vsfamily.vslib.web.common.service.VslibCommonService;
import org.vsfamily.vslib.web.manager.ManagerBaseController;
import org.vsfamily.vslib.web.manager.service.ManagerService;
import org.vsfamily.vslib.web.manager.validators.ManagerEditValidator;

@Controller
@RequestMapping("/manager/manager/edit")
public class ManagerEditController extends ManagerBaseController {

	@Autowired
	ManagerService managerService;
	
	@Autowired
	VslibCommonService vslibCommonService;
	
	@ModelAttribute("listSalutation")
	public List<Salutation> getListSalutation(){
		return this.vslibCommonService.listSalutation();
	}
	
	private ManagerEditValidator managerEditValidator;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editManager(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		Manager manager = (Manager) this.managerService.getManager(id);
		
		if (manager==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/manager/manager/addNew";
		}
		
		model.addAttribute("manager", manager);
		return "manager/manager/managerEdit";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.POST)
	public String editManager(@ModelAttribute Manager manager, BindingResult result, Model model,RedirectAttributes reat, Principal principal){
		
		Manager obj = (Manager) this.managerService.getManager(manager.getId());
		
		if (obj==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/manager/manager/addNew";
		}
		
		this.managerEditValidator.validate(manager, result);
		
		if (result.hasErrors()){
			return "manager/manager/managerEdit";
		}
		
		obj.setUid(manager.getUid());
		obj.setSalutation(manager.getSalutation());
		obj.setFirstName(manager.getFirstName());
		obj.setMiddleName(manager.getMiddleName());
		obj.setLastName(manager.getLastName());
		obj.getAddress().setAddressValues(manager.getAddress());
		obj.setEmail(manager.getEmail());
		if (manager.getPassword()!=null) {
			//PasswordEncoder encoder = new Md5PasswordEncoder();
			//String hashedPass = encoder.encodePassword(manager.getPassword(), null);
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	        String hashedPass = encoder.encode(manager.getPassword());
			
			obj.setPassword(hashedPass);
		}
		obj.setAccountNonExpired(manager.isAccountNonExpired());
		obj.setAccountNonLocked(manager.isAccountNonLocked());
		obj.setEnabled(manager.isEnabled());
		
		obj.setUpdateDefaults(principal.getName());
		
		if (this.managerService.updateManager(obj)){
			reat.addFlashAttribute("message","Record updated successfully.");
			return "redirect:/manager/manager/listAll";
		} else {
			reat.addFlashAttribute("message","Record not updated.");
			return "redirect:/manager/manager/listAll/current";
		}
		
	}
}
