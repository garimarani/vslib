package org.vsfamily.vslib.web.setup.language;

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
import org.vsfamily.vslib.common.domain.Language;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;
import org.vsfamily.vslib.web.validators.edit.LanguageEditValidator;

@Controller
@RequestMapping("/setup/language/edit")
public class LanguageEditController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	private LanguageEditValidator languageEditValidator;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editLanguage(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		Language language = (Language) this.vslibService.getLanguage(id);
		
		if (language==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/language/addNew";
		}
		
		model.addAttribute("language", language);
		return "setup/language/languageEdit";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.POST)
	public String editLanguage(@ModelAttribute Language language, BindingResult result, Model model,RedirectAttributes reat, Principal principal){
		Language obj = (Language) this.vslibService.getLanguage(language.getId());
		
		if (obj==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/language/listAll";
		}
		
		this.languageEditValidator.validate(language, result);
		
		if (result.hasErrors()){
			return "setup/language/languageEdit";
		}
		
		obj.setCode(language.getCode());
		obj.setName(language.getName());
		
		obj.setUpdateDefaults(principal.getName());
		
		if (this.vslibService.updateLanguage(obj)){
			reat.addFlashAttribute("message","Record updated successfully.");
			return "redirect:/setup/language/listAll";
		} else {
			reat.addFlashAttribute("message","Record not updated.");
			return "redirect:/setup/language/listAll/current";
		}
	}
}