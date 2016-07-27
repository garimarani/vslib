package org.vsfamily.vslib.web.common;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Document;
import org.vsfamily.vslib.common.domain.Item;
import org.vsfamily.vslib.common.tools.VslibPaginate;
import org.vsfamily.vslib.web.controller.VslibBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/newArrivals")
public class NewArrivalsController extends VslibBaseController {

	@Autowired
	VslibService vslibService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method=RequestMethod.GET)
	public String newArrivals(Model model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes reat){
		
		VslibPaginate page = this.vslibService.listNewArrivals(0, 25);

		List<Item> listItem = (List<Item>) page.getListObject();
		
		if (listItem.isEmpty()){
			reat.addFlashAttribute("message", "No matching records were found.");
			return "redirect:/";
		}
		
		int pageNumber = 1;
		int totalPages = page.getNumPages();
		
		model.addAttribute("firstPage", true);
		
		if (page.isLastPage(pageNumber)){
	            model.addAttribute("lastPage", true);
		} else {
	            model.addAttribute("lastPage", false);
		}
			
		model.addAttribute("listItem", listItem);
		model.addAttribute("currentPage", pageNumber);
		model.addAttribute("totalPages", totalPages);
		
		request.getSession().setAttribute("new_arrivals_current_page_number", pageNumber);
		request.getSession().setAttribute("new_arrivals_total_pages", totalPages);
	        
	    return "common/newArrivalsList";
	}
	
	@SuppressWarnings({ "unchecked" })
    @RequestMapping(value="/{page}", method=RequestMethod.GET)
    public String newArrivals(@PathVariable String page, Model model, HttpServletRequest request, RedirectAttributes reat, Principal principal){
	
		VslibPaginate pageData;
		List<Item> listItem = new ArrayList<Item>();
		
		int currentPageNumber = (int) request.getSession().getAttribute("new_arrivals_current_page_number");
		int totalPages = (int) request.getSession().getAttribute("new_arrivals_total_pages");
		
		switch(page){
		case "previous":
			if (currentPageNumber == 1){
				
			} else {
				currentPageNumber--;
			}
			break;
		case "firstPage":
			currentPageNumber = 1;
			break;
		case "next":
			if (currentPageNumber == totalPages){
				
			} else {
				currentPageNumber++;
			}
			break;
		case "last":
			currentPageNumber = totalPages;
			break;
		case "current":
			break;
		default:
			reat.addFlashAttribute("message", "No such pagination option.");
			return "redirect:/";
		}
		
		pageData = this.vslibService.listNewArrivals((currentPageNumber-1)*25, 25);
		listItem = (List<Item>) pageData.getListObject();
		totalPages = pageData.getNumPages();
				    
		if (listItem.isEmpty()){
			reat.addFlashAttribute("message", "No records in New Arrivals.");
			return "redirect:/newArrivals";
		}
		
		model.addAttribute("listItem",listItem);
		
		if (pageData.isFirstPage()){
			model.addAttribute("lastPage", true);
		} else {
	        model.addAttribute("lastPage", false);
		}
		
		if (pageData.isLastPage(currentPageNumber)){
			model.addAttribute("lastPage", true);
		} else {
	        model.addAttribute("lastPage", false);
		}
		    
		model.addAttribute("currentPage", currentPageNumber);
	    model.addAttribute("totalPages", totalPages);
	    
	    request.getSession().setAttribute("new_arrivals_current_page_number", currentPageNumber);
		request.getSession().setAttribute("new_arrivals_total_pages", totalPages);
		
        return "common/newArrivalsList";
    }
	
	@RequestMapping(value="/document/view/{id}", method=RequestMethod.GET)
	public String viewDocument(@PathVariable Long id, Model model, RedirectAttributes reat, Principal principal){
		
		Document document = this.vslibService.getDocument(id);
		
		if (document == null){
			reat.addFlashAttribute("message", "No such a record.");
			return "redirect:/";
		}
		
		model.addAttribute("document", document);
		return "common/newArrivalsDocumentView";
	}
}
