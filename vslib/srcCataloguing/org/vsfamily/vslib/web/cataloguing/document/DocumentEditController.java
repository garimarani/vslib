package org.vsfamily.vslib.web.cataloguing.document;

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
import org.vsfamily.vslib.common.domain.Document;
import org.vsfamily.vslib.web.cataloguing.CataloguingBaseController;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.validators.add.DocumentAddValidator;

@Controller
@RequestMapping("/cataloguing/document/edit")
public class DocumentEditController extends CataloguingBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	DocumentAddValidator documentAddValidator;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editDocument(@PathVariable Long id, Model model, RedirectAttributes reat, Principal principal){
		
		Document document = this.vslibService.getDocument(id);
		
		if (document == null){
			reat.addFlashAttribute("message", "No such record.");
			return "redirect:/cataloguing/document/addNew";
		}
		
		model.addAttribute("document", document);
		return "cataloguing/document/documentEdit";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.POST)
	public String editDocument(@ModelAttribute Document document, BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		Document obj = this.vslibService.getDocument(document.getId());
		
		if (obj == null){
			reat.addFlashAttribute("message", "No such record.");
			return "redirect:/cataloguing/document/addNew";
		}
		
		this.documentAddValidator.validate(document, result);
		
		if (result.hasErrors()){
			return "cataloguing/document/documentEdit";
		}
		
		obj.setUniformTitle(document.getUniformTitle());
		obj.setPrimaryAuthor(document.getPrimaryAuthor());
		obj.setSecondaryAuthors(document.getSecondaryAuthors());
		obj.setIsbn(document.getIsbn());
		obj.setEdition(document.getEdition());
		obj.setPublicationYear(document.getPublicationYear());
		obj.setCoverPrice(document.getCoverPrice());
		obj.setPublisher(document.getPublisher());
		obj.setSeriesStatement(document.getSeriesStatement());
		obj.setCopyright(document.getCopyright());
		obj.setSummary(document.getSummary());
		obj.setKeywords(document.getKeywords());
		
		obj.setUpdateDefaults(principal.getName());
		
		if (this.vslibService.updateDocument(obj)){
			reat.addFlashAttribute("message", "Record updated successfully.");
		} else {
			reat.addFlashAttribute("message", "Record not updated.");
		}
		return "redirect:/cataloguing/document/view/" + obj.getId().toString();
	}
	
}
