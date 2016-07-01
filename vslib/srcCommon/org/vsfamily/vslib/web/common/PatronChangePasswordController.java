package org.vsfamily.vslib.web.common;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Patron;
import org.vsfamily.vslib.forms.ChangePasswordForm;
import org.vsfamily.vslib.web.controller.VslibBaseController;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.validators.ChangePasswordValidator;

@Controller
@RequestMapping("/patronChangePassword")
public class PatronChangePasswordController extends VslibBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	ChangePasswordValidator changePasswordValidator;
	
	@RequestMapping(method=RequestMethod.GET)
	public String changePassword(Model model){
		
		ChangePasswordForm changePasswordForm = new ChangePasswordForm();
		
		model.addAttribute("changePasswordForm", changePasswordForm);
		
		return "patron/changePassword";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String changePassword(@ModelAttribute ChangePasswordForm changePasswordForm, BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		this.changePasswordValidator.validate(changePasswordForm, result);
		
		if (result.hasErrors()){
			return "patron/changePassword";
		}
		
		Patron patron = this.vslibService.getPatronByLoginId(principal.getName());
		
		if (patron == null){
			reat.addFlashAttribute("message", "No such a record.");
			return "redirect/patronChangePassword";
		}
		
		//PasswordEncoder encoder = new Md5PasswordEncoder();
		//String hashedPass = encoder.encodePassword(changePasswordForm.getPassword(), null);
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPass = encoder.encode(changePasswordForm.getPassword());
			
		patron.setPassword(hashedPass);
		
		if (this.vslibService.updatePatron(patron)){
			reat.addFlashAttribute("message", "Password updated successfully.");
		} else {
			reat.addFlashAttribute("message", "Password not updated.");
		}
		
		return "redirect:/patronChangePassword";
	}
}
