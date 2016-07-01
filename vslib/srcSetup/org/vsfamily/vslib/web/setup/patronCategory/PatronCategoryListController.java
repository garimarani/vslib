package org.vsfamily.vslib.web.setup.patronCategory;

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
import org.vsfamily.vslib.common.domain.PatronCategory;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/patronCategory/listAll")
public class PatronCategoryListController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listPatronCategory(Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		//this.setDefaults(request, response, model, principal);
		
		PagedListHolder<PatronCategory> patronCategoryList = new PagedListHolder<PatronCategory>(
				(List<PatronCategory>) this.vslibService.listPatronCategory());
		patronCategoryList.setPageSize(25);
		request.getSession().setAttribute("listall_patronCategoryList", patronCategoryList);
		
		model.addAttribute("listPatronCategory",(List<PatronCategory>) patronCategoryList.getPageList());
		
		if (patronCategoryList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
		
		if (patronCategoryList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
		
		model.addAttribute("currentPage", patronCategoryList.getPage()+1);
		model.addAttribute("totalPages", patronCategoryList.getPageCount());
		
		return "setup/patronCategory/patronCategoryList";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/{page}", method=RequestMethod.GET)
	public String listContentManager(@PathVariable String page, Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		PagedListHolder patronCategoryList = (PagedListHolder) request.getSession().getAttribute("listall_patronCategoryList");
	   
		if (patronCategoryList==null){
			return "redirect:/setup/patronCategory/listAll";
		}
		
	    if ("next".equals(page)) {
	        patronCategoryList.nextPage();
	    } else if ("previous".equals(page)) {
	        patronCategoryList.previousPage();
	    } else if ("last".equals(page)){
	    	patronCategoryList.setPage(patronCategoryList.getPageCount()-1);
	    }
	    
	    model.addAttribute("listPatronCategory",(List<PatronCategory>) patronCategoryList.getPageList());
	    
	    if (patronCategoryList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
	    
	    if (patronCategoryList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
	    
	    model.addAttribute("currentPage", patronCategoryList.getPage()+1);
		model.addAttribute("totalPages", patronCategoryList.getPageCount());
		
		return "setup/patronCategory/patronCategoryList";
	}
}
