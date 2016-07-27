package org.vsfamily.vslib.web.setup.adverts;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Adverts;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;
import org.vsfamily.vslib.web.validators.add.AdvertsAddValidator;

@Controller
@RequestMapping("/setup/adverts/addNew")
public class AdvertsAddController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	private AdvertsAddValidator advertsAddValidator;
	
	@RequestMapping(method=RequestMethod.GET)
	public String addNew(Model model){
		model.addAttribute("adverts", new Adverts());
		return "setup/adverts/adverts";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addNew(@ModelAttribute Adverts adverts, 
			BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		
		this.advertsAddValidator.validate(adverts, result);
		if (result.hasErrors()){
			return "setup/adverts/adverts";
		}
		
		adverts.setAddDefaults(principal.getName());
		
		if (this.vslibService.addAdverts(adverts)){
			reat.addFlashAttribute("message","Record saved (" + adverts.getId() + ")");
			return "redirect:/setup/adverts/addNew";
		} else {
			reat.addFlashAttribute("message","Record not added! Try again later.");
			return "redirect:/setup/adverts/addNew";
		}
	}
}