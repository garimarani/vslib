package org.vsfamily.vslib.web.manager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/manager")
public class ManagerController extends ManagerBaseController {

	@RequestMapping(method=RequestMethod.GET)
	public String setupSefault(Model model){
		return "manager/default";
	}
}
