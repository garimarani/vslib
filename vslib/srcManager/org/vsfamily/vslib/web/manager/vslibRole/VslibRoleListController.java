package org.vsfamily.vslib.web.manager.vslibRole;

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
import org.vsfamily.vslib.manager.domain.VslibRole;
import org.vsfamily.vslib.web.manager.ManagerBaseController;
import org.vsfamily.vslib.web.manager.service.ManagerService;

@Controller
@RequestMapping("/manager/role/listAll")
public class VslibRoleListController extends ManagerBaseController {
	
	@Autowired
	ManagerService managerService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listVslibRole(Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		//this.setDefaults(request, response, model, principal);
		
		PagedListHolder<VslibRole> vslibRoleList = new PagedListHolder<VslibRole>(
				(List<VslibRole>) this.managerService.listVslibRole());
		vslibRoleList.setPageSize(25);
		request.getSession().setAttribute("listall_vslibRoleList", vslibRoleList);
		
		model.addAttribute("listVslibRole",(List<VslibRole>) vslibRoleList.getPageList());
		
		if (vslibRoleList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
		
		if (vslibRoleList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
		
		model.addAttribute("currentPage", vslibRoleList.getPage()+1);
		model.addAttribute("totalPages", vslibRoleList.getPageCount());
		
		return "manager/vslibRole/vslibRoleList";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/{page}", method=RequestMethod.GET)
	public String listContentVslibRole(@PathVariable String page, Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		PagedListHolder vslibRoleList = (PagedListHolder) request.getSession().getAttribute("listall_vslibRoleList");
	   
		if (vslibRoleList==null){
			return "redirect:/manager/role/listAll";
		}
		
	    if ("next".equals(page)) {
	        vslibRoleList.nextPage();
	    } else if ("previous".equals(page)) {
	        vslibRoleList.previousPage();
	    } else if ("last".equals(page)){
	    	vslibRoleList.setPage(vslibRoleList.getPageCount()-1);
	    }
	    
	    model.addAttribute("listVslibRole",(List<VslibRole>) vslibRoleList.getPageList());
	    
	    if (vslibRoleList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
	    
	    if (vslibRoleList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
	    
	    model.addAttribute("currentPage", vslibRoleList.getPage()+1);
		model.addAttribute("totalPages", vslibRoleList.getPageCount());
		
		return "manager/vslibRole/vslibRoleList";
	}
}
