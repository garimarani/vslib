package org.vsfamily.vslib.web.setup.libraryType;

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
import org.vsfamily.vslib.common.domain.LibraryType;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/libraryType/listAll")
public class LibraryTypeListController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listLibraryType(Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		//this.setDefaults(request, response, model, principal);
		
		PagedListHolder<LibraryType> libraryTypeList = new PagedListHolder<LibraryType>(
				(List<LibraryType>) this.vslibService.listLibraryType());
		libraryTypeList.setPageSize(25);
		request.getSession().setAttribute("listall_libraryTypeList", libraryTypeList);
		
		model.addAttribute("listLibraryType",(List<LibraryType>) libraryTypeList.getPageList());
		
		if (libraryTypeList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
		
		if (libraryTypeList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
		
		model.addAttribute("currentPage", libraryTypeList.getPage()+1);
		model.addAttribute("totalPages", libraryTypeList.getPageCount());
		
		return "setup/libraryType/libraryTypeList";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/{page}", method=RequestMethod.GET)
	public String listContentManager(@PathVariable String page, Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		PagedListHolder libraryTypeList = (PagedListHolder) request.getSession().getAttribute("listall_libraryTypeList");
	   
		if (libraryTypeList==null){
			return "redirect:/setup/libraryType/listAll";
		}
		
	    if ("next".equals(page)) {
	        libraryTypeList.nextPage();
	    } else if ("previous".equals(page)) {
	        libraryTypeList.previousPage();
	    } else if ("last".equals(page)){
	    	libraryTypeList.setPage(libraryTypeList.getPageCount()-1);
	    }
	    
	    model.addAttribute("listLibraryType",(List<LibraryType>) libraryTypeList.getPageList());
	    
	    if (libraryTypeList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
	    
	    if (libraryTypeList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
	    
	    model.addAttribute("currentPage", libraryTypeList.getPage()+1);
		model.addAttribute("totalPages", libraryTypeList.getPageCount());
		
		return "setup/libraryType/libraryTypeList";
	}
}
