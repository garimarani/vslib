package org.vsfamily.vslib.web.manager.manager;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.common.domain.Salutation;
import org.vsfamily.vslib.manager.domain.Manager;
import org.vsfamily.vslib.web.common.service.VslibCommonService;
import org.vsfamily.vslib.web.manager.ManagerBaseController;
import org.vsfamily.vslib.web.manager.service.ManagerService;
import org.vsfamily.vslib.web.manager.validators.ManagerAddValidator;

@Controller
@RequestMapping("/manager/manager/addNew")
public class ManagerAddController extends ManagerBaseController {

	@Autowired
	VslibCommonService vslibCommonService;
	
	@Autowired
	ManagerService managerService;
	
	@Autowired
	private ManagerAddValidator managerAddValidator;
	
	@ModelAttribute("listSalutation")
	public List<Salutation> getListSalutation(){
		return this.vslibCommonService.listSalutation();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String addNew(Model model){
		model.addAttribute("manager", new Manager());
		return "manager/manager/manager";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addNew(@ModelAttribute Manager manager, 
			BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		
		this.managerAddValidator.validate(manager, result);
		if (result.hasErrors()){
			return "manager/manager/manager";
		}
		
		//PasswordEncoder encoder = new Md5PasswordEncoder();
		//String hashedPass = encoder.encodePassword(manager.getPassword(), null);
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPass = encoder.encode(manager.getPassword());
			
		manager.setPassword(hashedPass);
		manager.setAddDefaults(principal.getName());
		
		if (this.managerService.addManager(manager)){
			reat.addFlashAttribute("message","Record saved (" + manager.getId() + ")");
			return "redirect:/manager/manager/view/" + manager.getId().toString();
		} else {
			reat.addFlashAttribute("message","Record not added! Try again later.");
			return "redirect:/manager/manager/addNew";
		}
	}
}