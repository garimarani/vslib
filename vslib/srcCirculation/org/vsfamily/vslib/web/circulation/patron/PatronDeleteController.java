package org.vsfamily.vslib.web.circulation.patron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Patron;
import org.vsfamily.vslib.web.circulation.CirculationBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/circulation/patron/delete")
public class PatronDeleteController extends CirculationBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String deletePatron(@PathVariable Long id, Model model, RedirectAttributes reat){
		
		Patron patron = this.vslibService.getPatron(id);
		
		if (patron == null){
			reat.addFlashAttribute("message", "No such Patron record.");
			return "redirect:/circulation/patron/addNew";
		}
		
		if (!patron.getCheckOuts().isEmpty()){
			reat.addFlashAttribute("message", "Patron has items issued to him.");
			return "redirect:/circulation/patron/view" + patron.getId().toString();
		}
		
		if (this.vslibService.deletePatron(patron)){
			reat.addFlashAttribute("message", "Patron record deleted successfully.");
			return "redirect:/circulation/patron/addNew";
		} else {
			reat.addFlashAttribute("message", "Patron record not deleted.");
			return "redirect:/circulation/patron/view" + patron.getId().toString();
		}
	}
}
