package org.vsfamily.vslib.web.setup.gender;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.common.domain.Gender;
import org.vsfamily.vslib.web.common.service.VslibCommonService;
import org.vsfamily.vslib.web.common.validators.GenderAddValidator;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/gender/addNew")
public class GenderAddController extends SetupBaseController {

	@Autowired
	VslibCommonService vslibCommonService;
	
	@Autowired
	private GenderAddValidator genderAddValidator;
	
	@ModelAttribute("listGender")
	public List<Gender> getListGender(){
		return this.vslibCommonService.listGender();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String addNew(Model model){
		model.addAttribute("gender", new Gender());
		return "common/gender/gender";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addNew(@ModelAttribute Gender gender, 
			BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		this.genderAddValidator.validate(gender, result);
		if (result.hasErrors()){
			return "common/gender/gender";
		}
		
		gender.setAddDefaults(principal.getName());
		
		
		if (this.vslibCommonService.addGender(gender)){
			reat.addFlashAttribute("message","Record saved (" + gender.getId().toString() + ")");
			return "redirect:/setup/gender/addNew";
		} else {
			reat.addFlashAttribute("message","Record not added! Try again later.");
			return "redirect:/setup/gender/addNew";
		}
	}
}
