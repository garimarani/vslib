package org.vsfamily.vslib.web.report.document;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.vsfamily.vslib.web.report.ReportBaseController;

@Controller
@RequestMapping("/report/document/listItem/excel")
public class ReportListItemController extends ReportBaseController {

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView repListItem(){
		
		return new ModelAndView("reportItemExcelView");
	}
}
