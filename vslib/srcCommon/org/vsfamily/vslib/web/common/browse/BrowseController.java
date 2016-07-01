package org.vsfamily.vslib.web.common.browse;

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
import org.vsfamily.vslib.web.controller.VslibBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/browse/title")
public class BrowseController extends VslibBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String browseDocument(Model model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes reat){
		
		return "";
	}
	
	@RequestMapping(value="/alpha/{alpha}", method=RequestMethod.GET)
	public String browseDocument(@PathVariable String alpha, Model model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes reat){
		
		return "";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/{page}", method=RequestMethod.GET)
	public String browseDocumentList(@PathVariable String page, Model model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes reat){
		
		PagedListHolder documentList = (PagedListHolder) request.getSession().getAttribute("browse_title_documentList");
		   
		if (documentList==null){
			return "redirect:/browse/title";
		}
		
	    if ("next".equals(page)) {
	        documentList.nextPage();
	    } else if ("previous".equals(page)) {
	        documentList.previousPage();
	    } else if ("last".equals(page)){
	    	documentList.setPage(documentList.getPageCount()-1);
	    }
	    
	    model.addAttribute("listDocument",(List<Document>) documentList.getPageList());
	    
	    if (documentList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
	    
	    if (documentList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
	    
	    model.addAttribute("currentPage", documentList.getPage()+1);
		model.addAttribute("totalPages", documentList.getPageCount());
		
		return "common/browse/titleList";
	}
}
