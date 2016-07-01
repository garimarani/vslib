package org.vsfamily.vslib.web.setup.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Language;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/language/delete")
public class LanguageDeleteController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String deleteLanguage(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		Language language = (Language) this.vslibService.getLanguage(id);
		
		if (language==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/language/addNew";
		}
		
		if (this.vslibService.deleteLanguage(language)){
			reat.addFlashAttribute("message","Recored deleted successfully.");
			return "redirect:/setup/language/addNew";
		} else {
			reat.addFlashAttribute("message","Record not deleted.");
			return "redirect:/setup/language/listAll/current";
		}
	}
}