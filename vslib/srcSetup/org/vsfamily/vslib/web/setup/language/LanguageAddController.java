package org.vsfamily.vslib.web.setup.language;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Language;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;
import org.vsfamily.vslib.web.validators.add.LanguageAddValidator;

@Controller
@RequestMapping("/setup/language/addNew")
public class LanguageAddController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	private LanguageAddValidator languageAddValidator;
	
	@RequestMapping(method=RequestMethod.GET)
	public String addNew(Model model){
		model.addAttribute("language", new Language());
		return "setup/language/language";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addNew(@ModelAttribute Language language, 
			BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		
		this.languageAddValidator.validate(language, result);
		if (result.hasErrors()){
			return "setup/language/language";
		}
		
		language.setAddDefaults(principal.getName());
		
		if (this.vslibService.addLanguage(language)){
			reat.addFlashAttribute("message","Record saved (" + language.getId() + ")");
			return "redirect:/setup/language/addNew";
		} else {
			reat.addFlashAttribute("message","Record not added! Try again later.");
			return "redirect:/setup/language/addNew";
		}
	}
}