package org.vsfamily.vslib.web.cataloguing;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cataloguing")
public class CataloguingController extends CataloguingBaseController {

	@RequestMapping(method=RequestMethod.GET)
	public String setupSefault(Model model){
		return "cataloguing/default";
	}
}
