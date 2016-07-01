package org.vsfamily.vslib.web.setup.itemType;

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
import org.vsfamily.vslib.common.domain.ItemType;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/itemType/listAll")
public class ItemTypeListController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listItemType(Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		//this.setDefaults(request, response, model, principal);
		
		PagedListHolder<ItemType> itemTypeList = new PagedListHolder<ItemType>(
				(List<ItemType>) this.vslibService.listItemType());
		itemTypeList.setPageSize(25);
		request.getSession().setAttribute("listall_itemTypeList", itemTypeList);
		
		model.addAttribute("listItemType",(List<ItemType>) itemTypeList.getPageList());
		
		if (itemTypeList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
		
		if (itemTypeList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
		
		model.addAttribute("currentPage", itemTypeList.getPage()+1);
		model.addAttribute("totalPages", itemTypeList.getPageCount());
		
		return "setup/itemType/itemTypeList";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/{page}", method=RequestMethod.GET)
	public String listContentManager(@PathVariable String page, Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		PagedListHolder itemTypeList = (PagedListHolder) request.getSession().getAttribute("listall_itemTypeList");
	   
		if (itemTypeList==null){
			return "redirect:/setup/itemType/listAll";
		}
		
	    if ("next".equals(page)) {
	        itemTypeList.nextPage();
	    } else if ("previous".equals(page)) {
	        itemTypeList.previousPage();
	    } else if ("last".equals(page)){
	    	itemTypeList.setPage(itemTypeList.getPageCount()-1);
	    }
	    
	    model.addAttribute("listItemType",(List<ItemType>) itemTypeList.getPageList());
	    
	    if (itemTypeList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
	    
	    if (itemTypeList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
	    
	    model.addAttribute("currentPage", itemTypeList.getPage()+1);
		model.addAttribute("totalPages", itemTypeList.getPageCount());
		
		return "setup/itemType/itemTypeList";
	}
}