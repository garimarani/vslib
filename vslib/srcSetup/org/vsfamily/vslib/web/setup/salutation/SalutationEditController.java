package org.vsfamily.vslib.web.setup.salutation;

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
import org.vsfamily.common.domain.Salutation;
import org.vsfamily.vslib.web.common.service.VslibCommonService;
import org.vsfamily.vslib.web.common.validators.SalutationEditValidator;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/salutation/edit")
public class SalutationEditController extends SetupBaseController {

	@Autowired
	VslibCommonService vslibCommonService;
	
	@Autowired
	SalutationEditValidator salutationEditValidator;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editSalutation(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		Salutation salutation = (Salutation) this.vslibCommonService.getSalutation(id);
		
		if (salutation==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/salutation/addNew";
		}
		
		model.addAttribute("salutation", salutation);
		return "common/salutation/salutationEdit";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.POST)
	public String editSalutation(@ModelAttribute Salutation salutation, BindingResult result, Model model,RedirectAttributes reat, Principal principal){
		Salutation obj = (Salutation) this.vslibCommonService.getSalutation(salutation.getId());
		
		if (obj==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/salutation/addNew";
		}
		
		this.salutationEditValidator.validate(salutation, result);
		
		if (result.hasErrors()){
			return "common/salutation/salutationEdit";
		}
		
		obj.setCode(salutation.getCode());
		obj.setName(salutation.getName());
		
		obj.setUpdateDefaults(principal.getName());
		
		if (this.vslibCommonService.updateSalutation(obj)){
			reat.addFlashAttribute("message","Record updated successfully.");
			return "redirect:/setup/salutation/addNew";
		} else {
			reat.addFlashAttribute("message","Record not updated.");
			return "redirect:/setup/salutation/addNew";
		}
	}
}
