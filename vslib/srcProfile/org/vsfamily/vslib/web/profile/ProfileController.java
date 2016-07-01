package org.vsfamily.vslib.web.profile;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Patron;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/profile")
public class ProfileController extends ProfileBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String profileDefault(Model model){
		
		return "profile/default";
	}
	
	@RequestMapping(value="/myprofile", method=RequestMethod.GET)
	public String myProfile(Model model, RedirectAttributes reat, Principal principal){
		
		Patron patron = this.vslibService.getPatronByLoginId(principal.getName());
		
		if (patron == null){
			reat.addFlashAttribute("message", "No such Patron record.");
			return "redirect:/profile";
		}
		
		model.addAttribute("patron", patron);
		return "profile/patron/patronView";
	}
}
