package org.vsfamily.vslib.web.content.menuItem;

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
import org.vsfamily.vslib.common.domain.MenuItem;
import org.vsfamily.vslib.web.content.ContentBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/content/menuItem/listAll")
public class MenuItemListController extends ContentBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listMenuItem(Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		//this.setDefaults(request, response, model, principal);
		
		PagedListHolder<MenuItem> menuItemList = new PagedListHolder<MenuItem>(
				(List<MenuItem>) this.vslibService.listMenuItem());
		menuItemList.setPageSize(25);
		request.getSession().setAttribute("listall_menuItemList", menuItemList);
		
		model.addAttribute("listMenuItem",(List<MenuItem>) menuItemList.getPageList());
		
		if (menuItemList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
		
		if (menuItemList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
		
		model.addAttribute("currentPage", menuItemList.getPage()+1);
		model.addAttribute("totalPages", menuItemList.getPageCount());
		
		return "content/menuItem/menuItemList";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/{page}", method=RequestMethod.GET)
	public String listMenuItem(@PathVariable String page, Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		PagedListHolder menuItemList = (PagedListHolder) request.getSession().getAttribute("listall_menuItemList");
	   
		if (menuItemList==null){
			return "redirect:/content/menuItem/listAll";
		}
		
	    if ("next".equals(page)) {
	        menuItemList.nextPage();
	    } else if ("previous".equals(page)) {
	        menuItemList.previousPage();
	    } else if ("last".equals(page)){
	    	menuItemList.setPage(menuItemList.getPageCount()-1);
	    }
	    
	    model.addAttribute("listMenuItem",(List<MenuItem>) menuItemList.getPageList());
	    
	    if (menuItemList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
	    
	    if (menuItemList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
	    
	    model.addAttribute("currentPage", menuItemList.getPage()+1);
		model.addAttribute("totalPages", menuItemList.getPageCount());
		
		return "content/menuItem/menuItemList";
	}
}