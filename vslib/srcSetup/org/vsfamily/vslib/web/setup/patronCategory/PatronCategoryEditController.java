package org.vsfamily.vslib.web.setup.patronCategory;

import java.security.Principal;
import java.util.List;

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
import org.vsfamily.vslib.common.domain.PatronCategory;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;
import org.vsfamily.vslib.web.validators.edit.PatronCategoryEditValidator;

@Controller
@RequestMapping("/setup/patronCategory/edit")
public class PatronCategoryEditController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	private PatronCategoryEditValidator patronCategoryEditValidator;
	
	@ModelAttribute("listFineCategory")
	public List<FineCategory> getListFineCategory(){
		return this.vslibService.listFineCategory();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editPatronCategory(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		PatronCategory patronCategory = (PatronCategory) this.vslibService.getPatronCategory(id);
		
		if (patronCategory==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/patronCategory/addNew";
		}
		
		model.addAttribute("patronCategory", patronCategory);
		return "setup/patronCategory/patronCategoryEdit";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.POST)
	public String editPatronCategory(@ModelAttribute PatronCategory patronCategory, BindingResult result, Model model,RedirectAttributes reat, Principal principal){
		PatronCategory obj = (PatronCategory) this.vslibService.getPatronCategory(patronCategory.getId());
		
		if (obj==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/patronCategory/listAll";
		}
		
		this.patronCategoryEditValidator.validate(patronCategory, result);
		
		if (result.hasErrors()){
			return "setup/patronCategory/patronCategoryEdit";
		}
		
		obj.setCode(patronCategory.getCode());
		obj.setName(patronCategory.getName());
		obj.setMaximumCheckOutPeriod(patronCategory.getMaximumCheckOutPeriod());
		obj.setMaximumCheckOuts(patronCategory.getMaximumCheckOuts());
		obj.setMaximumHoldPeriod(patronCategory.getMaximumHoldPeriod());
		obj.setMaximumHolds(patronCategory.getMaximumHolds());
		obj.setMaximumReservePeriod(patronCategory.getMaximumReservePeriod());
		obj.setMaximumReserves(patronCategory.getMaximumReserves());
		obj.setFineCategory(patronCategory.getFineCategory());
		
		obj.setUpdateDefaults(principal.getName());
		
		if (this.vslibService.updatePatronCategory(obj)){
			reat.addFlashAttribute("message","Record updated successfully.");
			return "redirect:/setup/patronCategory/listAll";
		} else {
			reat.addFlashAttribute("message","Record not updated.");
			return "redirect:/setup/patronCategory/listAll/current";
		}
	}
}