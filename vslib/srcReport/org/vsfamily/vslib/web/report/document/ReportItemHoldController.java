package org.vsfamily.vslib.web.report.document;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.ItemHold;
import org.vsfamily.vslib.web.report.ReportBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/report/document/listItemHold")
public class ReportItemHoldController extends ReportBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String reportItemHold(Model model, RedirectAttributes reat){
		
		List<ItemHold> listItemHold = this.vslibService.listItemHold();
		
		if (listItemHold.isEmpty()){
			reat.addFlashAttribute("message", "No items on Hold.");
			return "redirect:/report/document";
		}
		
		model.addAttribute("listItemHold", listItemHold);
		
		return "report/document/itemHold";
	}
	
	@RequestMapping(value="/excel", method = RequestMethod.GET)
	public ModelAndView listItemHold(Model model, RedirectAttributes reat) {

		List<ItemHold> listItemHold = this.vslibService.listItemHold();
		
		if (listItemHold.isEmpty()){
			reat.addFlashAttribute("message", "No items on hold.");
			new ModelAndView("redirect:/report/document");
		}
		
		return new ModelAndView("reportItemHoldExcelView", "listItemHold", listItemHold);
	}
}
