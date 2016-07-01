package org.vsfamily.vslib.web.report;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/report")
public class ReportController extends ReportBaseController {

	@RequestMapping(method=RequestMethod.GET)
	public String setupDefault(Model model){
		return "report/default";
	}
}
