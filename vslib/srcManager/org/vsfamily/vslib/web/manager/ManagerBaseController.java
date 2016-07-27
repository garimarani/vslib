package org.vsfamily.vslib.web.manager;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.vsfamily.vslib.web.controller.VslibBaseController;

public class ManagerBaseController extends VslibBaseController {

	@Override
	@ModelAttribute("viewLeftMenu")
	public String viewLeftMenu(){
		return "manager/leftMenu";
	}
}
