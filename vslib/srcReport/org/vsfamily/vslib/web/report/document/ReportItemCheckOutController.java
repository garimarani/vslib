package org.vsfamily.vslib.web.report.document;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.ItemCheckOut;
import org.vsfamily.vslib.web.report.ReportBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/report/document/listItemCheckOut")
public class ReportItemCheckOutController extends ReportBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String reportCheckOut(Model model, RedirectAttributes reat){
		
		List<ItemCheckOut> listItemCheckOut = this.vslibService.listItemCheckOut();
		
		if (listItemCheckOut.isEmpty()){
			reat.addFlashAttribute("message", "No items are checked out.");
			return "redirect:/report/document";
		}
		
		model.addAttribute("listItemCheckOut", listItemCheckOut);
		return "report/document/itemCheckOut";
	}
	
	@RequestMapping(value="/excel", method = RequestMethod.GET)
	public ModelAndView listItemCheckOut(Model model, RedirectAttributes reat) {

		List<ItemCheckOut> listItemCheckOut = this.vslibService.listItemCheckOut();
		
		if (listItemCheckOut.isEmpty()){
			reat.addFlashAttribute("message", "No items are checked out.");
			new ModelAndView("redirect:/report/document");
		}
		
		return new ModelAndView("reportItemCheckOutExcelView", "listItemCheckOut", listItemCheckOut);
	}
}
