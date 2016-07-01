package org.vsfamily.vslib.web.manager.manager;

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
import org.vsfamily.vslib.manager.domain.Manager;
import org.vsfamily.vslib.web.manager.ManagerBaseController;
import org.vsfamily.vslib.web.manager.service.ManagerService;

@Controller
@RequestMapping("/manager/manager/listAll")
public class ManagerListController extends ManagerBaseController {
	
	@Autowired
	ManagerService managerService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listManager(Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		//this.setDefaults(request, response, model, principal);
		
		PagedListHolder<Manager> managerList = new PagedListHolder<Manager>(
				(List<Manager>) this.managerService.listManager());
		managerList.setPageSize(10);
		request.getSession().setAttribute("listall_managerList", managerList);
		
		model.addAttribute("listManager",(List<Manager>) managerList.getPageList());
		
		if (managerList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
		
		if (managerList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
		
		model.addAttribute("currentPage", managerList.getPage()+1);
		model.addAttribute("totalPages", managerList.getPageCount());
		
		return "manager/manager/managerList";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/{page}", method=RequestMethod.GET)
	public String listContentManager(@PathVariable String page, Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		PagedListHolder managerList = (PagedListHolder) request.getSession().getAttribute("listall_managerList");
	   
		if (managerList==null){
			return "redirect:/manager/manager/listAll";
		}
		
	    if ("next".equals(page)) {
	        managerList.nextPage();
	    } else if ("previous".equals(page)) {
	        managerList.previousPage();
	    } else if ("last".equals(page)){
	    	managerList.setPage(managerList.getPageCount()-1);
	    }
	    
	    model.addAttribute("listManager",(List<Manager>) managerList.getPageList());
	    
	    if (managerList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
	    
	    if (managerList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
	    
	    model.addAttribute("currentPage", managerList.getPage()+1);
		model.addAttribute("totalPages", managerList.getPageCount());
		
		return "manager/manager/managerList";
	}
}
