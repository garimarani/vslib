package org.vsfamily.vslib.web.report.patron;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.web.report.ReportBaseController;

@Controller
@RequestMapping("/report/patron/listPatron/excel")
public class ReportPatronListController extends ReportBaseController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listPatron(Model model, RedirectAttributes reat) {
		
		return new ModelAndView("reportListPatronExcelView");
	}
}
