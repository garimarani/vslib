package org.vsfamily.vslib.web.report.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.vsfamily.vslib.web.report.ReportBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/report/document")
public class ReportDocumentController extends ReportBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String reportDocument(Model model){
		
		return "report/document/default";
	}
}
