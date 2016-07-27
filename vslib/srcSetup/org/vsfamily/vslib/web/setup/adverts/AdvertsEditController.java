package org.vsfamily.vslib.web.setup.adverts;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Adverts;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;
import org.vsfamily.vslib.web.validators.edit.AdvertsEditValidator;

@Controller
@RequestMapping("/setup/adverts/edit")
public class AdvertsEditController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	private AdvertsEditValidator advertsEditValidator;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editAdverts(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		Adverts adverts = (Adverts) this.vslibService.getAdverts(id);
		
		if (adverts==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/adverts/addNew";
		}
		
		model.addAttribute("adverts", adverts);
		return "setup/adverts/advertsEdit";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.POST)
	public String editAdverts(@ModelAttribute Adverts adverts, BindingResult result, Model model,RedirectAttributes reat, Principal principal){
		Adverts obj = (Adverts) this.vslibService.getAdverts(adverts.getId());
		
		if (obj==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/adverts/listAll";
		}
		
		this.advertsEditValidator.validate(adverts, result);
		
		if (result.hasErrors()){
			return "setup/adverts/advertsEdit";
		}
		
		obj.setName(adverts.getName());
		obj.setLocation(adverts.getLocation());
		obj.setValue(adverts.getValue());
		obj.setPublished(adverts.isPublished());
		
		obj.setUpdateDefaults(principal.getName());
		
		if (this.vslibService.updateAdverts(obj)){
			reat.addFlashAttribute("message","Record updated successfully.");
			return "redirect:/setup/adverts/listAll";
		} else {
			reat.addFlashAttribute("message","Record not updated.");
			return "redirect:/setup/adverts/listAll/current";
		}
	}
}