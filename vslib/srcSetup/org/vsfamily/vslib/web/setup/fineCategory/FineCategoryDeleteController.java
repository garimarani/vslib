package org.vsfamily.vslib.web.setup.fineCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.FineCategory;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/fineCategory/delete")
public class FineCategoryDeleteController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String deleteFineCategory(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		FineCategory fineCategory = (FineCategory) this.vslibService.getFineCategory(id);
		
		if (fineCategory==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/fineCategory/addNew";
		}
		
		if (this.vslibService.deleteFineCategory(fineCategory)){
			reat.addFlashAttribute("message","Recored deleted successfully.");
			return "redirect:/setup/fineCategory/addNew";
		} else {
			reat.addFlashAttribute("message","Record not deleted.");
			return "redirect:/setup/fineCategory/listAll/current";
		}
	}
}