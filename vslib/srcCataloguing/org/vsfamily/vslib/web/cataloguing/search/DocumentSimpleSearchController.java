package org.vsfamily.vslib.web.cataloguing.search;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Document;
import org.vsfamily.vslib.forms.SimpleSearchForm;
import org.vsfamily.vslib.web.cataloguing.CataloguingBaseController;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.validators.SimpleSearchFormValidator;

@Controller
@RequestMapping("/cataloguing/search")
public class DocumentSimpleSearchController extends CataloguingBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	SimpleSearchFormValidator simpleSearchFormValidator;
	
	@RequestMapping(method=RequestMethod.GET)
	public String searchDocument(Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		SimpleSearchForm ssf = (SimpleSearchForm) request.getSession().getAttribute("document_simpleSearch");
		
		if (ssf == null) ssf = new SimpleSearchForm();
		
		model.addAttribute("simpleSearchForm", ssf);
		
		return "cataloguing/search/simpleSearch";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String searchDocument(@ModelAttribute SimpleSearchForm simpleSearchForm, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes reat, Principal principal){
		
		this.simpleSearchFormValidator.validate(simpleSearchForm, result);
		
		if (result.hasErrors()){
			return "cataloguing/search/simpleSearch";
		}
		
		request.getSession().setAttribute("document_simpleSearch", simpleSearchForm);
		
		List<Document> listDocument = this.vslibService.searchDocument(simpleSearchForm);
		
		if (listDocument.isEmpty()) {
			reat.addFlashAttribute("message", "No results found.");
			return "redirect:/cataloguing/search";
		} else {
			if (listDocument.size()==1){
				Document document = listDocument.get(0);
				return "redirect:/cataloguing/document/view/" + document.getId().toString();
			} else {
				PagedListHolder<Document> documentList = new PagedListHolder<Document>(
						(List<Document>) listDocument);
				documentList.setPageSize(25);
				request.getSession().setAttribute("listall_documentList", documentList);
				
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
				
				return "cataloguing/search/simpleSearchList";
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/{page}", method=RequestMethod.GET)
	public String listSearchDocument(@PathVariable String page, Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		PagedListHolder documentList = (PagedListHolder) request.getSession().getAttribute("listall_documentList");
	   
		if (documentList==null){
			return "redirect:/cataloguing/search";
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
		
		return "cataloguing/search/simpleSearchList";
	}
}
