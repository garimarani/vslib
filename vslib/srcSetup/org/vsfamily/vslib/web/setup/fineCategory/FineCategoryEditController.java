package org.vsfamily.vslib.web.setup.fineCategory;

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
import org.vsfamily.vslib.common.domain.FineCategory;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;
import org.vsfamily.vslib.web.validators.edit.FineCategoryEditValidator;

@Controller
@RequestMapping("/setup/fineCategory/edit")
public class FineCategoryEditController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	private FineCategoryEditValidator fineCategoryEditValidator;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editFineCategory(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		FineCategory fineCategory = (FineCategory) this.vslibService.getFineCategory(id);
		
		if (fineCategory==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/fineCategory/addNew";
		}
		
		model.addAttribute("fineCategory", fineCategory);
		return "setup/fineCategory/fineCategoryEdit";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.POST)
	public String editFineCategory(@ModelAttribute FineCategory fineCategory, BindingResult result, Model model,RedirectAttributes reat, Principal principal){
		FineCategory obj = (FineCategory) this.vslibService.getFineCategory(fineCategory.getId());
		
		if (obj==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/fineCategory/addNew";
		}
		
		this.fineCategoryEditValidator.validate(fineCategory, result);
		
		if (result.hasErrors()){
			return "setup/fineCategory/fineCategoryEdit";
		}
		
		obj.setCode(fineCategory.getCode());
		obj.setName(fineCategory.getName());
		obj.setRate(fineCategory.getRate());
		obj.setDays(fineCategory.getDays());
		
		obj.setUpdateDefaults(principal.getName());
		
		if (this.vslibService.updateFineCategory(obj)){
			reat.addFlashAttribute("message","Record updated successfully.");
			return "redirect:/setup/fineCategory/listAll";
		} else {
			reat.addFlashAttribute("message","Record not updated.");
			return "redirect:/setup/fineCategory/listAll/current";
		}
	}
}
