package org.vsfamily.vslib.web.common;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Document;
import org.vsfamily.vslib.common.domain.Item;
import org.vsfamily.vslib.web.controller.VslibBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/newArrivals")
public class NewArrivalsController extends VslibBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String newArrivals(Model model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes reat){
		
		List<Item> listItem = this.vslibService.listNewArrivals();
		
		if (listItem.isEmpty()){
			reat.addFlashAttribute("message", "No matching records were found.");
			return "redirect:/";
		}
		
		PagedListHolder<Item> itemList = new PagedListHolder<>(listItem);
		itemList.setPageSize(10);
		request.getSession().setAttribute("new_arrivals_itemList", itemList);
			
		model.addAttribute("listItem",(List<Item>) itemList.getPageList());
			
		if (itemList.isFirstPage()){
	            model.addAttribute("firstPage", true);
		} else {
	            model.addAttribute("firstPage", false);
		}
			
		if (itemList.isLastPage()){
	            model.addAttribute("lastPage", true);
		} else {
	            model.addAttribute("lastPage", false);
		}
			
		model.addAttribute("currentPage", itemList.getPage()+1);
		model.addAttribute("totalPages", itemList.getPageCount());
	        
	    return "common/newArrivalsList";
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value="/{page}", method=RequestMethod.GET)
    public String newArrivals(@PathVariable String page, Model model, HttpServletRequest request, RedirectAttributes reat, Principal principal){
	
		PagedListHolder itemList = (PagedListHolder) request.getSession().getAttribute("new_arrivals_itemList");
			
		if (itemList==null){
				reat.addFlashAttribute("message", "No records to display.");
	            return "redirect:/search";
	        }
		   
		if ("next".equals(page)) {
	            itemList.nextPage();
		} else if ("previous".equals(page)) {
	            itemList.previousPage();
		} else if ("last".equals(page)){
	            itemList.setPage(itemList.getPageCount()-1);
	        } else if ("first".equals(page)){
	            itemList.setPage(0);
	        }
		    
		model.addAttribute("listItem",(List<Document>) itemList.getPageList());
		    
		if (itemList.isFirstPage()){
	            model.addAttribute("firstPage", true);
	        } else {
	            model.addAttribute("firstPage", false);
		}
		    
		if (itemList.isLastPage()){
	            model.addAttribute("lastPage", true);
	        } else {
	            model.addAttribute("lastPage", false);
		}
		    
		model.addAttribute("currentPage", itemList.getPage()+1);
	    	model.addAttribute("totalPages", itemList.getPageCount());
		
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
