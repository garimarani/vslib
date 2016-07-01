package org.vsfamily.vslib.web.setup.parameters;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/parameters")
public class VslibParamsController extends SetupBaseController {

	@RequestMapping(method=RequestMethod.GET)
	public String parameters(Model model){
		return "setup/parameters/default";
	}
}
