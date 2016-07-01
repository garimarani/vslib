package org.vsfamily.vslib.web.profile;

import org.springframework.web.bind.annotation.ModelAttribute;

public class ProfileBaseController {

	@ModelAttribute("viewLeftMenu")
	public String viewLeftMenu(){
		return "profile/leftMenu";
	}
	
}
