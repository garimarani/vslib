package org.vsfamily.vslib.web.setup.adverts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Adverts;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/adverts/delete")
public class AdvertsDeleteController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String deleteAdverts(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		Adverts adverts = (Adverts) this.vslibService.getAdverts(id);
		
		if (adverts==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/adverts/addNew";
		}
		
		if (this.vslibService.deleteAdverts(adverts)){
			reat.addFlashAttribute("message","Recored deleted successfully.");
			return "redirect:/setup/adverts/addNew";
		} else {
			reat.addFlashAttribute("message","Record not deleted.");
			return "redirect:/setup/adverts/listAll/current";
		}
	}
}