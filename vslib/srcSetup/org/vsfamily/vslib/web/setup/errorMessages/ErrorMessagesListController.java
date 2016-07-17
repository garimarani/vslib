package org.vsfamily.vslib.web.setup.errorMessages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.vsfamily.vslib.common.domain.ErrorMessages;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/errorMessages/listAll")
public class ErrorMessagesListController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listAll(Model model){
		List<ErrorMessages> listErrorMessages = this.vslibService.listErrorMessages();
		
		model.addAttribute("listErrorMessages", listErrorMessages);
		
		return "setup/errorMessages/errorMessagesList";
	}
}
