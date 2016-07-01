package org.vsfamily.vslib.web.setup.patronCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.PatronCategory;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/patronCategory/view")
public class PatronCategoryViewController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String viewPatronCategory(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		PatronCategory patronCategory = (PatronCategory) this.vslibService.getPatronCategory(id);
		
		if (patronCategory==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/patronCategory/addNew";
		}
		
		model.addAttribute("patronCategory", patronCategory);
		
		return "setup/patronCategory/patronCategoryView";
	}
}