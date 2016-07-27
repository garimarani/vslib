package org.vsfamily.vslib.web.setup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/setup")
public class SetupController extends SetupBaseController {

	@RequestMapping(method=RequestMethod.GET)
	public String setupDefault(Model model){
		return "setup/default";
	}
}
