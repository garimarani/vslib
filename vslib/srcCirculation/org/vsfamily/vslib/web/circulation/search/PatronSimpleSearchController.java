package org.vsfamily.vslib.web.circulation.search;

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
import org.vsfamily.vslib.common.domain.Patron;
import org.vsfamily.vslib.forms.SimpleSearchForm;
import org.vsfamily.vslib.web.circulation.CirculationBaseController;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.validators.SimpleSearchFormValidator;

@Controller
@RequestMapping("/circulation/search")
public class PatronSimpleSearchController extends CirculationBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	SimpleSearchFormValidator simpleSearchFormValidator;
	
	@RequestMapping(method=RequestMethod.GET)
	public String searchPatron(Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		SimpleSearchForm ssf = (SimpleSearchForm) request.getSession().getAttribute("patron_simpleSearch");
		
		if (ssf == null) ssf = new SimpleSearchForm();
		
		model.addAttribute("simpleSearchForm", ssf);
		
		return "circulation/search/simpleSearch";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String searchPatron(@ModelAttribute SimpleSearchForm simpleSearchForm, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes reat, Principal principal){
		
		this.simpleSearchFormValidator.validate(simpleSearchForm, result);
		
		if (result.hasErrors()){
			return "circulation/search/simpleSearch";
		}
		
		request.getSession().setAttribute("patron_simpleSearch", simpleSearchForm);
		
		List<Patron> listPatron = this.vslibService.searchPatron(simpleSearchForm);
		
		if (listPatron.isEmpty()) {
			reat.addFlashAttribute("message", "No results found.");
			return "redirect:/circulation/search";
		} else {
			if (listPatron.size()==1){
				Patron patron = listPatron.get(0);
				return "redirect:/circulation/patron/view/" + patron.getId().toString();
			} else {
				PagedListHolder<Patron> patronList = new PagedListHolder<Patron>(
						(List<Patron>) listPatron);
				patronList.setPageSize(25);
				request.getSession().setAttribute("listall_patronList", patronList);
				
				model.addAttribute("listPatron",(List<Patron>) patronList.getPageList());
				
				if (patronList.isFirstPage()){
					model.addAttribute("firstPage", true);
				} else {
					model.addAttribute("firstPage", false);
				}
				
				if (patronList.isLastPage()){
					model.addAttribute("lastPage", true);
				} else {
					model.addAttribute("lastPage", false);
				}
				
				model.addAttribute("currentPage", patronList.getPage()+1);
				model.addAttribute("totalPages", patronList.getPageCount());
				
				return "circulation/search/simpleSearchList";
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/{page}", method=RequestMethod.GET)
	public String listSearchPatron(@PathVariable String page, Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		PagedListHolder patronList = (PagedListHolder) request.getSession().getAttribute("listall_patronList");
	   
		if (patronList==null){
			return "redirect:/circulation/search";
		}
		
	    if ("next".equals(page)) {
	    	patronList.nextPage();
	    } else if ("previous".equals(page)) {
	    	patronList.previousPage();
	    } else if ("last".equals(page)){
	    	patronList.setPage(patronList.getPageCount()-1);
	    }
	    
	    model.addAttribute("listPatron",(List<Patron>) patronList.getPageList());
	    
	    if (patronList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
	    
	    if (patronList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
	    
	    model.addAttribute("currentPage", patronList.getPage()+1);
		model.addAttribute("totalPages", patronList.getPageCount());
		
		return "circulation/search/simpleSearchList";
	}
}
