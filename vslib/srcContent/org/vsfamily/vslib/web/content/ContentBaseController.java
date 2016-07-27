package org.vsfamily.vslib.web.content;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.vsfamily.vslib.web.controller.VslibBaseController;

public class ContentBaseController extends VslibBaseController {

	/**
	 * Gets the leftMenu file name.
	 * @return the leftMenu file name
	 */
	@ModelAttribute("viewLeftMenu")
	public String viewLeftMenu(){
		return "content/leftMenu";
	}
}
