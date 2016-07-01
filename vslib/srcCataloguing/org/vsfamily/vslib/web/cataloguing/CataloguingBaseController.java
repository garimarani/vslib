package org.vsfamily.vslib.web.cataloguing;

import org.springframework.web.bind.annotation.ModelAttribute;

public class CataloguingBaseController {

	@ModelAttribute("viewLeftMenu")
	public String viewLeftMenu(){
		return "cataloguing/leftMenu";
	}

}
