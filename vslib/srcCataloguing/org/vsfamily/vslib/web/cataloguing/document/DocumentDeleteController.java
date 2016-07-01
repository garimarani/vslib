package org.vsfamily.vslib.web.cataloguing.document;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Document;
import org.vsfamily.vslib.web.cataloguing.CataloguingBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/cataloguing/document/delete")
public class DocumentDeleteController extends CataloguingBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String deleteDocument(@PathVariable Long id, Model model, RedirectAttributes reat, Principal principal){
		
		Document document = this.vslibService.getDocument(id);
		
		if (document == null){
			reat.addFlashAttribute("message", "No such record.");
			return "redirect:/cataloguing/document/addNew";
		}
		
		if (this.vslibService.deleteDocument(document)){
			reat.addFlashAttribute("messgae", "Document deleted successfully.");
			return "redirect:/cataloguing/document/addNew";
		} else {
			reat.addFlashAttribute("message", "Document not deleted.");
			return "redirect:/cataloguing/document/view/" + document.getId().toString();
		}
	}
}
