package org.vsfamily.vslib.web.setup.library;

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
import org.vsfamily.vslib.common.domain.Library;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/library/listAll")
public class LibraryListController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listLibrary(Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		//this.setDefaults(request, response, model, principal);
		
		PagedListHolder<Library> libraryList = new PagedListHolder<Library>(
				(List<Library>) this.vslibService.listLibrary());
		libraryList.setPageSize(25);
		request.getSession().setAttribute("listall_libraryList", libraryList);
		
		model.addAttribute("listLibrary",(List<Library>) libraryList.getPageList());
		
		if (libraryList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
		
		if (libraryList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
		
		model.addAttribute("currentPage", libraryList.getPage()+1);
		model.addAttribute("totalPages", libraryList.getPageCount());
		
		return "setup/library/libraryList";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/{page}", method=RequestMethod.GET)
	public String listContentManager(@PathVariable String page, Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		PagedListHolder libraryList = (PagedListHolder) request.getSession().getAttribute("listall_libraryList");
	   
		if (libraryList==null){
			return "redirect:/setup/library/listAll";
		}
		
	    if ("next".equals(page)) {
	        libraryList.nextPage();
	    } else if ("previous".equals(page)) {
	        libraryList.previousPage();
	    } else if ("last".equals(page)){
	    	libraryList.setPage(libraryList.getPageCount()-1);
	    }
	    
	    model.addAttribute("listLibrary",(List<Library>) libraryList.getPageList());
	    
	    if (libraryList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
	    
	    if (libraryList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
	    
	    model.addAttribute("currentPage", libraryList.getPage()+1);
		model.addAttribute("totalPages", libraryList.getPageCount());
		
		return "setup/library/libraryList";
	}
}