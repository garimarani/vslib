package org.vsfamily.vslib.web.setup.patronGroup;

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
import org.vsfamily.vslib.common.domain.PatronGroup;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/patronGroup/listAll")
public class PatronGroupListController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listPatronGroup(Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		//this.setDefaults(request, response, model, principal);
		
		PagedListHolder<PatronGroup> patronGroupList = new PagedListHolder<PatronGroup>(
				(List<PatronGroup>) this.vslibService.listPatronGroup());
		patronGroupList.setPageSize(25);
		request.getSession().setAttribute("listall_patronGroupList", patronGroupList);
		
		model.addAttribute("listPatronGroup",(List<PatronGroup>) patronGroupList.getPageList());
		
		if (patronGroupList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
		
		if (patronGroupList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
		
		model.addAttribute("currentPage", patronGroupList.getPage()+1);
		model.addAttribute("totalPages", patronGroupList.getPageCount());
		
		return "setup/patronGroup/patronGroupList";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/{page}", method=RequestMethod.GET)
	public String listContentManager(@PathVariable String page, Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		PagedListHolder patronGroupList = (PagedListHolder) request.getSession().getAttribute("listall_patronGroupList");
	   
		if (patronGroupList==null){
			return "redirect:/setup/patronGroup/listAll";
		}
		
	    if ("next".equals(page)) {
	        patronGroupList.nextPage();
	    } else if ("previous".equals(page)) {
	        patronGroupList.previousPage();
	    } else if ("last".equals(page)){
	    	patronGroupList.setPage(patronGroupList.getPageCount()-1);
	    }
	    
	    model.addAttribute("listPatronGroup",(List<PatronGroup>) patronGroupList.getPageList());
	    
	    if (patronGroupList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
	    
	    if (patronGroupList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
	    
	    model.addAttribute("currentPage", patronGroupList.getPage()+1);
		model.addAttribute("totalPages", patronGroupList.getPageCount());
		
		return "setup/patronGroup/patronGroupList";
	}
}
