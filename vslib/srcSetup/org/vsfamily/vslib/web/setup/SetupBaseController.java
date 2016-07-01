package org.vsfamily.vslib.web.setup;

import org.springframework.web.bind.annotation.ModelAttribute;

public class SetupBaseController {
	
	@ModelAttribute("viewLeftMenu")
	public String viewLeftMenu(){
		return "setup/leftMenu";
	}
	
}
