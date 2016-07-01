package org.vsfamily.vslib.web.setup.fineCategory;

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
import org.vsfamily.vslib.common.domain.FineCategory;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/fineCategory/listAll")
public class FineCategoryListController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listFineCategory(Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		//this.setDefaults(request, response, model, principal);
		
		PagedListHolder<FineCategory> fineCategoryList = new PagedListHolder<FineCategory>(
				(List<FineCategory>) this.vslibService.listFineCategory());
		fineCategoryList.setPageSize(25);
		request.getSession().setAttribute("listall_fineCategoryList", fineCategoryList);
		
		model.addAttribute("listFineCategory",(List<FineCategory>) fineCategoryList.getPageList());
		
		if (fineCategoryList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
		
		if (fineCategoryList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
		
		model.addAttribute("currentPage", fineCategoryList.getPage()+1);
		model.addAttribute("totalPages", fineCategoryList.getPageCount());
		
		return "setup/fineCategory/fineCategoryList";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/{page}", method=RequestMethod.GET)
	public String listContentManager(@PathVariable String page, Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		PagedListHolder fineCategoryList = (PagedListHolder) request.getSession().getAttribute("listall_fineCategoryList");
	   
		if (fineCategoryList==null){
			return "redirect:/setup/fineCategory/listAll";
		}
		
	    if ("next".equals(page)) {
	        fineCategoryList.nextPage();
	    } else if ("previous".equals(page)) {
	        fineCategoryList.previousPage();
	    } else if ("last".equals(page)){
	    	fineCategoryList.setPage(fineCategoryList.getPageCount()-1);
	    }
	    
	    model.addAttribute("listFineCategory",(List<FineCategory>) fineCategoryList.getPageList());
	    
	    if (fineCategoryList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
	    
	    if (fineCategoryList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
	    
	    model.addAttribute("currentPage", fineCategoryList.getPage()+1);
		model.addAttribute("totalPages", fineCategoryList.getPageCount());
		
		return "setup/fineCategory/fineCategoryList";
	}
}
