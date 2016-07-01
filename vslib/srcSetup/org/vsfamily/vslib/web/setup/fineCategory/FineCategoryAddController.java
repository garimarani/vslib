package org.vsfamily.vslib.web.setup.fineCategory;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.FineCategory;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;
import org.vsfamily.vslib.web.validators.add.FineCategoryAddValidator;

@Controller
@RequestMapping("/setup/fineCategory/addNew")
public class FineCategoryAddController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	private FineCategoryAddValidator fineCategoryAddValidator;
	
	@RequestMapping(method=RequestMethod.GET)
	public String addNew(Model model){
		model.addAttribute("fineCategory", new FineCategory());
		return "setup/fineCategory/fineCategory";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addNew(@ModelAttribute FineCategory fineCategory, 
			BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		
		this.fineCategoryAddValidator.validate(fineCategory, result);
		if (result.hasErrors()){
			return "setup/fineCategory/fineCategory";
		}
		
		fineCategory.setAddDefaults(principal.getName());
		
		if (this.vslibService.addFineCategory(fineCategory)){
			reat.addFlashAttribute("message","Record saved (" + fineCategory.getId() + ")");
			return "redirect:/setup/fineCategory/addNew";
		} else {
			reat.addFlashAttribute("message","Record not added! Try again later.");
			return "redirect:/setup/fineCategory/addNew";
		}
	}
}