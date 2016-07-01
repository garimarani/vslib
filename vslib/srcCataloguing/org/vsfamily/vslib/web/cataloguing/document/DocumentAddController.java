package org.vsfamily.vslib.web.cataloguing.document;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Document;
import org.vsfamily.vslib.web.cataloguing.CataloguingBaseController;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.validators.add.DocumentAddValidator;

@Controller
@RequestMapping("/cataloguing/document/addNew")
public class DocumentAddController extends CataloguingBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	DocumentAddValidator documentAddValidator;
	
	@RequestMapping(method=RequestMethod.GET)
	public String addDocument(Model model){
		
		Document document = new Document();
		
		model.addAttribute("document", document);
		return "cataloguing/document/document";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addDocument(@ModelAttribute Document document, BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		this.documentAddValidator.validate(document, result);
		
		if (result.hasErrors()){
			return "cataloguing/document/document";
		}
		
		document.setAddDefaults(principal.getName());
		
		if (this.vslibService.addDocument(document)){
			reat.addFlashAttribute("message", "Document added successfully.");
			return "redirect:/cataloguing/document/view/" + document.getId().toString();
		} else {
			reat.addFlashAttribute("message", "Document not added.");
			return "redirect:/cataloguing/document/addNew";
		}
	}
}
