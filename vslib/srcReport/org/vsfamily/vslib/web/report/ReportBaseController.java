package org.vsfamily.vslib.web.report;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.vsfamily.vslib.web.controller.VslibBaseController;

public class ReportBaseController extends VslibBaseController {

	@Override
	@ModelAttribute("viewLeftMenu")
	public String viewLeftMenu(){
		return "report/leftMenu";
	}
}
