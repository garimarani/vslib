package org.vsfamily.vslib.web.common.search;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Document;
import org.vsfamily.vslib.forms.SimpleSearchForm;
import org.vsfamily.vslib.web.controller.VslibBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/search")
public class SearchController extends VslibBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String search(Model model, HttpServletRequest request, HttpServletResponse response){
		
		SimpleSearchForm simpleSearchForm = (SimpleSearchForm) request.getSession().getAttribute("search_ssf");
		
		if (simpleSearchForm == null)
			simpleSearchForm = new SimpleSearchForm();
		
		model.addAttribute("simpleSearchForm", simpleSearchForm);
		
		return "common/search/simpleSearch";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String search(@ModelAttribute SimpleSearchForm simpleSearchForm, Model model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes reat){
		
		request.getSession().setAttribute("search_ssf", simpleSearchForm);
		
		List<Document> listDocument = this.vslibService.searchDocumentSimpleLucene(simpleSearchForm);
		
		if (listDocument.isEmpty()){
			reat.addFlashAttribute("message", "No matching records were found.");
			return "redirect:/search";
		}
		
		PagedListHolder<Document> documentList = new PagedListHolder<>(listDocument);
		documentList.setPageSize(10);
		request.getSession().setAttribute("search_documentList", documentList);
			
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
	        
	    return "common/search/simpleSearchList";
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value="/{page}", method=RequestMethod.GET)
    public String searchDocument(@PathVariable String page, Model model, HttpServletRequest request, RedirectAttributes reat, Principal principal){
	
		PagedListHolder documentList = (PagedListHolder) request.getSession().getAttribute("search_documentList");
			
		if (documentList==null){
				reat.addFlashAttribute("message", "No records to display.");
	            return "redirect:/search";
	        }
		   
		if ("next".equals(page)) {
	            documentList.nextPage();
		} else if ("previous".equals(page)) {
	            documentList.previousPage();
		} else if ("last".equals(page)){
	            documentList.setPage(documentList.getPageCount()-1);
	        } else if ("first".equals(page)){
	            documentList.setPage(0);
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
		
        return "common/search/simpleSearchList";
    }
	
	@RequestMapping(value="/document/view/{id}", method=RequestMethod.GET)
	public String viewDocument(@PathVariable Long id, Model model, RedirectAttributes reat, Principal principal){
		
		Document document = this.vslibService.getDocument(id);
		
		if (document == null){
			reat.addFlashAttribute("message", "No such a record.");
			return "redirect:/search";
		}
		
		model.addAttribute("document", document);
		return "common/search/documentView";
	}
}
