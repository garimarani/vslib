package org.vsfamily.vslib.web.setup;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.vsfamily.vslib.web.controller.VslibBaseController;

public class SetupBaseController extends VslibBaseController {
	
	@Override
	@ModelAttribute("viewLeftMenu")
	public String viewLeftMenu(){
		return "setup/leftMenu";
	}
	
}
