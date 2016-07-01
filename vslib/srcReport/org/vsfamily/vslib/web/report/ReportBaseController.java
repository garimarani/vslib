package org.vsfamily.vslib.web.report;

import org.springframework.web.bind.annotation.ModelAttribute;

public class ReportBaseController {

	@ModelAttribute("viewLeftMenu")
	public String viewLeftMenu(){
		return "report/leftMenu";
	}
}
