package org.vsfamily.vslib.web.setup.salutation;

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
import org.vsfamily.common.domain.Salutation;
import org.vsfamily.vslib.web.common.service.VslibCommonService;
import org.vsfamily.vslib.web.common.validators.SalutationAddValidator;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/salutation/addNew")
public class SalutationAddController extends SetupBaseController {

	@Autowired
	VslibCommonService vslibCommonService;
	
	@Autowired
	private SalutationAddValidator salutationAddValidator;
	
	@ModelAttribute("listSalutation")
	public List<Salutation> getListSalutation(){
		return this.vslibCommonService.listSalutation();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String addNew(Model model){
		model.addAttribute("salutation", new Salutation());
		return "common/salutation/salutation";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addNew(@ModelAttribute Salutation salutation, 
			BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		
		this.salutationAddValidator.validate(salutation, result);
		if (result.hasErrors()){
			return "common/salutation/salutation";
		}
		
		salutation.setAddDefaults(principal.getName());
		
		if (this.vslibCommonService.addSalutation(salutation)){
			reat.addFlashAttribute("message","Record saved (" + salutation.getId() + ")");
			return "redirect:/setup/salutation/addNew";
		} else {
			reat.addFlashAttribute("message","Record not added! Try again later.");
			return "redirect:/setup/salutation/addNew";
		}
	}
}
