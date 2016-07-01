package org.vsfamily.vslib.web.setup.libraryBranch;

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
import org.vsfamily.vslib.common.domain.LibraryBranch;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/libraryBranch/listAll")
public class LibraryBranchListController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listLibraryBranch(Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		//this.setDefaults(request, response, model, principal);
		
		PagedListHolder<LibraryBranch> libraryBranchList = new PagedListHolder<LibraryBranch>(
				(List<LibraryBranch>) this.vslibService.listLibraryBranch());
		libraryBranchList.setPageSize(10);
		request.getSession().setAttribute("listall_libraryBranchList", libraryBranchList);
		
		model.addAttribute("listLibraryBranch",(List<LibraryBranch>) libraryBranchList.getPageList());
		
		if (libraryBranchList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
		
		if (libraryBranchList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
		
		model.addAttribute("currentPage", libraryBranchList.getPage()+1);
		model.addAttribute("totalPages", libraryBranchList.getPageCount());
		
		return "setup/libraryBranch/libraryBranchList";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/{page}", method=RequestMethod.GET)
	public String listContentManager(@PathVariable String page, Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		PagedListHolder libraryBranchList = (PagedListHolder) request.getSession().getAttribute("listall_libraryBranchList");
	   
		if (libraryBranchList==null){
			return "redirect:/setup/libraryBranch/listAll";
		}
		
	    if ("next".equals(page)) {
	        libraryBranchList.nextPage();
	    } else if ("previous".equals(page)) {
	        libraryBranchList.previousPage();
	    } else if ("last".equals(page)){
	    	libraryBranchList.setPage(libraryBranchList.getPageCount()-1);
	    }
	    
	    model.addAttribute("listLibraryBranch",(List<LibraryBranch>) libraryBranchList.getPageList());
	    
	    if (libraryBranchList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
	    
	    if (libraryBranchList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
	    
	    model.addAttribute("currentPage", libraryBranchList.getPage()+1);
		model.addAttribute("totalPages", libraryBranchList.getPageCount());
		
		return "setup/libraryBranch/libraryBranchList";
	}
}