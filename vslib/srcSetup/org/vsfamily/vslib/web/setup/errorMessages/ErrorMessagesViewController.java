package org.vsfamily.vslib.web.setup.errorMessages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.ErrorMessages;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/errorMessages/view")
public class ErrorMessagesViewController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String viewErrorMessages(@PathVariable Long id, Model model, RedirectAttributes reat){
		
		ErrorMessages errorMessages = (ErrorMessages) this.vslibService.getErrorMessages(id);
		
		if (errorMessages == null){
			reat.addFlashAttribute("message", "No such Error Messages record.");
			return "redirect:/setup/errorMessages/list";
		}
		
		model.addAttribute("errorMessages", errorMessages);
		return "setup/errorMessages/errorMessagesView";
	}
}
