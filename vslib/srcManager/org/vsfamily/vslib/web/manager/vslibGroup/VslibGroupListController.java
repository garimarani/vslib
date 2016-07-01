package org.vsfamily.vslib.web.manager.vslibGroup;

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
import org.vsfamily.vslib.manager.domain.VslibGroup;
import org.vsfamily.vslib.web.manager.ManagerBaseController;
import org.vsfamily.vslib.web.manager.service.ManagerService;

@Controller
@RequestMapping("/manager/group/listAll")
public class VslibGroupListController extends ManagerBaseController {
	
	@Autowired
	ManagerService managerService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listVslibGroup(Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		//this.setDefaults(request, response, model, principal);
		
		PagedListHolder<VslibGroup> vslibGroupList = new PagedListHolder<VslibGroup>(
				(List<VslibGroup>) this.managerService.listVslibGroup());
		vslibGroupList.setPageSize(25);
		request.getSession().setAttribute("listall_vslibGroupList", vslibGroupList);
		
		model.addAttribute("listVslibGroup",(List<VslibGroup>) vslibGroupList.getPageList());
		
		if (vslibGroupList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
		
		if (vslibGroupList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
		
		model.addAttribute("currentPage", vslibGroupList.getPage()+1);
		model.addAttribute("totalPages", vslibGroupList.getPageCount());
		
		return "manager/vslibGroup/vslibGroupList";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/{page}", method=RequestMethod.GET)
	public String listContentVslibGroup(@PathVariable String page, Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		PagedListHolder vslibGroupList = (PagedListHolder) request.getSession().getAttribute("listall_vslibGroupList");
	   
		if (vslibGroupList==null){
			return "redirect:/manager/group/listAll";
		}
		
	    if ("next".equals(page)) {
	        vslibGroupList.nextPage();
	    } else if ("previous".equals(page)) {
	        vslibGroupList.previousPage();
	    } else if ("last".equals(page)){
	    	vslibGroupList.setPage(vslibGroupList.getPageCount()-1);
	    }
	    
	    model.addAttribute("listVslibGroup",(List<VslibGroup>) vslibGroupList.getPageList());
	    
	    if (vslibGroupList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
	    
	    if (vslibGroupList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
	    
	    model.addAttribute("currentPage", vslibGroupList.getPage()+1);
		model.addAttribute("totalPages", vslibGroupList.getPageCount());
		
		return "manager/vslibGroup/vslibGroupList";
	}
}
