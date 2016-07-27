package org.vsfamily.vslib.web.cataloguing;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.vsfamily.vslib.web.controller.VslibBaseController;

public class CataloguingBaseController extends VslibBaseController {

	@ModelAttribute("viewLeftMenu")
	public String viewLeftMenu(){
		return "cataloguing/leftMenu";
	}

}
