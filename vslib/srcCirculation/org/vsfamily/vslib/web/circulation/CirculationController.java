package org.vsfamily.vslib.web.circulation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/circulation")
public class CirculationController extends CirculationBaseController {

	@RequestMapping(method=RequestMethod.GET)
	public String setupSefault(Model model){
		return "circulation/default";
	}
}
