package org.vsfamily.vslib.web.circulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.vsfamily.vslib.web.common.email.CirculationEmailMessages;
import org.vsfamily.vslib.web.controller.VslibBaseController;

public class CirculationBaseController extends VslibBaseController {

	@Autowired
	CirculationEmailMessages circulationEmailMessages;
	
	public CirculationEmailMessages getCirculationEmailMessages(){
		return this.circulationEmailMessages;
	}
	
	@Override
	@ModelAttribute("viewLeftMenu")
	public String viewLeftMenu(){
		return "circulation/leftMenu";
	}
	
}
