package org.vsfamily.vslib.web.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Base controller for Home module.
 */
public class VslibBaseController {

	@ModelAttribute("viewLeftMenu")
	public String viewLeftMenu() {
		return "leftMenu";
	}
}
