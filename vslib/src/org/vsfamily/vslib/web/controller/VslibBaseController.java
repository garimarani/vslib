package org.vsfamily.vslib.web.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

public class VslibBaseController {

	@ModelAttribute("viewLeftMenu")
	public String viewLeftMenu() {
		return "leftMenu";
	}
}
