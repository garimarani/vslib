package org.vsfamily.vslib.web.setup.adverts;

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
import org.vsfamily.vslib.common.domain.Adverts;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/adverts/listAll")
public class AdvertsListController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listAdverts(Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		//this.setDefaults(request, response, model, principal);
		
		PagedListHolder<Adverts> advertsList = new PagedListHolder<Adverts>(
				(List<Adverts>) this.vslibService.listAdverts());
		advertsList.setPageSize(25);
		request.getSession().setAttribute("listall_advertsList", advertsList);
		
		model.addAttribute("listAdverts",(List<Adverts>) advertsList.getPageList());
		
		if (advertsList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
		
		if (advertsList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
		
		model.addAttribute("currentPage", advertsList.getPage()+1);
		model.addAttribute("totalPages", advertsList.getPageCount());
		
		return "setup/adverts/advertsList";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/{page}", method=RequestMethod.GET)
	public String listContentManager(@PathVariable String page, Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		PagedListHolder advertsList = (PagedListHolder) request.getSession().getAttribute("listall_advertsList");
	   
		if (advertsList==null){
			return "redirect:/setup/adverts/listAll";
		}
		
	    if ("next".equals(page)) {
	        advertsList.nextPage();
	    } else if ("previous".equals(page)) {
	        advertsList.previousPage();
	    } else if ("last".equals(page)){
	    	advertsList.setPage(advertsList.getPageCount()-1);
	    }
	    
	    model.addAttribute("listAdverts",(List<Adverts>) advertsList.getPageList());
	    
	    if (advertsList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
	    
	    if (advertsList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
	    
	    model.addAttribute("currentPage", advertsList.getPage()+1);
		model.addAttribute("totalPages", advertsList.getPageCount());
		
		return "setup/adverts/advertsList";
	}
}