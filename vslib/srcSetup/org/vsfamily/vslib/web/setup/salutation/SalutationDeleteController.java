package org.vsfamily.vslib.web.setup.salutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.common.domain.Salutation;
import org.vsfamily.vslib.web.common.service.VslibCommonService;
import org.vsfamily.vslib.web.common.validators.SalutationEditValidator;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/salutation/delete")
public class SalutationDeleteController extends SetupBaseController {

	@Autowired
	VslibCommonService vslibCommonService;
	
	@Autowired
	SalutationEditValidator salutationEditValidator;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String deleteSalutation(@PathVariable Long id, Model model, RedirectAttributes reat){
		
		Salutation salutation = (Salutation) this.vslibCommonService.getSalutation(id);
		
		if (salutation==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/salutation/addNew";
		}
		
		if (this.vslibCommonService.deleteSalutation(salutation)){
			reat.addFlashAttribute("message","Record deleted successfully.");
		} else {
			reat.addFlashAttribute("message","Record not deleted.");
		}
		model.addAttribute("salutation", salutation);
		return "redirect:/setup/salutation/addNew";
	}
}
