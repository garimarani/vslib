package org.vsfamily.vslib.web.setup.patronCategory;

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
import org.vsfamily.vslib.common.domain.FineCategory;
import org.vsfamily.vslib.common.domain.PatronCategory;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;
import org.vsfamily.vslib.web.validators.add.PatronCategoryAddValidator;

@Controller
@RequestMapping("/setup/patronCategory/addNew")
public class PatronCategoryAddController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	private PatronCategoryAddValidator patronCategoryAddValidator;
	
	@ModelAttribute("listFineCategory")
	public List<FineCategory> getListFineCategory(){
		return this.vslibService.listFineCategory();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String addNew(Model model){
		model.addAttribute("patronCategory", new PatronCategory());
		return "setup/patronCategory/patronCategory";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addNew(@ModelAttribute PatronCategory patronCategory, 
			BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		
		this.patronCategoryAddValidator.validate(patronCategory, result);
		if (result.hasErrors()){
			return "setup/patronCategory/patronCategory";
		}
		
		patronCategory.setAddDefaults(principal.getName());
		
		if (this.vslibService.addPatronCategory(patronCategory)){
			reat.addFlashAttribute("message","Record saved (" + patronCategory.getId() + ")");
			return "redirect:/setup/patronCategory/addNew";
		} else {
			reat.addFlashAttribute("message","Record not added! Try again later.");
			return "redirect:/setup/patronCategory/addNew";
		}
	}
}
