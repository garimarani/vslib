package org.vsfamily.vslib.web.report.document;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.ItemReserve;
import org.vsfamily.vslib.web.report.ReportBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/report/document/listItemReserve")
public class ReportItemReserveController extends ReportBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String reportItemReserve(Model model, RedirectAttributes reat){
		
		List<ItemReserve> listItemReserve = this.vslibService.listItemReserve();
		
		if (listItemReserve.isEmpty()){
			reat.addFlashAttribute("message", "No items on reservation.");
			return "redirect:/report/document";
		}
		
		model.addAttribute("listItemReserve", listItemReserve);
		
		return "report/document/itemReserve";
	}
	
	@RequestMapping(value="/excel", method = RequestMethod.GET)
	public ModelAndView listItemReserve(Model model, RedirectAttributes reat) {

		List<ItemReserve> listItemReserve = this.vslibService.listItemReserve();
		
		if (listItemReserve.isEmpty()){
			reat.addFlashAttribute("message", "No items on reservation.");
			new ModelAndView("redirect:/report/document");
		}
		
		return new ModelAndView("reportItemReserveExcelView", "listItemReserve", listItemReserve);
	}
}
