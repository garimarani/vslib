package org.vsfamily.vslib.web.setup.language;

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
import org.vsfamily.vslib.common.domain.Language;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/language/listAll")
public class LanguageListController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listLanguage(Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		//this.setDefaults(request, response, model, principal);
		
		PagedListHolder<Language> languageList = new PagedListHolder<Language>(
				(List<Language>) this.vslibService.listLanguage());
		languageList.setPageSize(25);
		request.getSession().setAttribute("listall_languageList", languageList);
		
		model.addAttribute("listLanguage",(List<Language>) languageList.getPageList());
		
		if (languageList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
		
		if (languageList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
		
		model.addAttribute("currentPage", languageList.getPage()+1);
		model.addAttribute("totalPages", languageList.getPageCount());
		
		return "setup/language/languageList";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/{page}", method=RequestMethod.GET)
	public String listContentManager(@PathVariable String page, Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		PagedListHolder languageList = (PagedListHolder) request.getSession().getAttribute("listall_languageList");
	   
		if (languageList==null){
			return "redirect:/setup/language/listAll";
		}
		
	    if ("next".equals(page)) {
	        languageList.nextPage();
	    } else if ("previous".equals(page)) {
	        languageList.previousPage();
	    } else if ("last".equals(page)){
	    	languageList.setPage(languageList.getPageCount()-1);
	    }
	    
	    model.addAttribute("listLanguage",(List<Language>) languageList.getPageList());
	    
	    if (languageList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
	    
	    if (languageList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
	    
	    model.addAttribute("currentPage", languageList.getPage()+1);
		model.addAttribute("totalPages", languageList.getPageCount());
		
		return "setup/language/languageList";
	}
}