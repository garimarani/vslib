package org.vsfamily.vslib.web.manager;

import org.springframework.web.bind.annotation.ModelAttribute;

public class ManagerBaseController {

	@ModelAttribute("viewLeftMenu")
	public String viewLeftMenu(){
		return "manager/leftMenu";
	}
}
