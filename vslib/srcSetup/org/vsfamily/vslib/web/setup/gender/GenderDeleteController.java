package org.vsfamily.vslib.web.setup.gender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.common.domain.Gender;
import org.vsfamily.vslib.web.common.service.VslibCommonService;
import org.vsfamily.vslib.web.common.validators.GenderEditValidator;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/gender/delete")
public class GenderDeleteController extends SetupBaseController {

	@Autowired
	VslibCommonService vslibCommonService;
	
	@Autowired
	GenderEditValidator genderEditValidator;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String deleteGender(@PathVariable Long id, Model model, RedirectAttributes reat){
		
		Gender gender = (Gender) this.vslibCommonService.getGender(id);
		
		if (gender==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/gender/addNew";
		}
		
		if (this.vslibCommonService.deleteGender(gender)){
			reat.addFlashAttribute("message","Record deleted successfully.");
		} else {
			reat.addFlashAttribute("message","Record not deleted.");
		}
		model.addAttribute("gender", gender);
		return "redirect:/setup/gender/addNew";
	}
}
