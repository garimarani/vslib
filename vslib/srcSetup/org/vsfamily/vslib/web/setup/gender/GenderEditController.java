package org.vsfamily.vslib.web.setup.gender;

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
import org.vsfamily.common.domain.Gender;
import org.vsfamily.vslib.web.common.service.VslibCommonService;
import org.vsfamily.vslib.web.common.validators.GenderEditValidator;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/gender/edit")
public class GenderEditController extends SetupBaseController {

	@Autowired
	VslibCommonService vslibCommonService;
	
	@Autowired
	GenderEditValidator genderEditValidator;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editGender(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		Gender gender = (Gender) this.vslibCommonService.getGender(id);
		
		if (gender==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/gender/addNew";
		}
		
		model.addAttribute("gender", gender);
		return "common/gender/genderEdit";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.POST)
	public String editGender(@ModelAttribute Gender gender, BindingResult result, Model model,RedirectAttributes reat, Principal principal){
		Gender obj = (Gender) this.vslibCommonService.getGender(gender.getId());
		
		if (obj==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/gender/addNew";
		}
		
		this.genderEditValidator.validate(gender, result);
		
		if (result.hasErrors()){
			return "common/gender/genderEdit";
		}
		
		obj.setCode(gender.getCode());
		obj.setName(gender.getName());
		
		obj.setUpdateDefaults(principal.getName());
		
		if (this.vslibCommonService.updateGender(obj)){
			reat.addFlashAttribute("message","Record updated successfully.");
			return "redirect:/setup/gender/addNew";
		} else {
			reat.addFlashAttribute("message","Record not updated.");
			return "redirect:/setup/gender/addNew";
		}
	}
}
