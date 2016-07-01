package org.vsfamily.vslib.web.setup.subject;

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
import org.vsfamily.vslib.common.domain.Subject;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/subject/listAll")
public class SubjectListController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listSubject(Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		//this.setDefaults(request, response, model, principal);
		
		PagedListHolder<Subject> subjectList = new PagedListHolder<Subject>(
				(List<Subject>) this.vslibService.listSubject());
		subjectList.setPageSize(25);
		request.getSession().setAttribute("listall_subjectList", subjectList);
		
		model.addAttribute("listSubject",(List<Subject>) subjectList.getPageList());
		
		if (subjectList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
		
		if (subjectList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
		
		model.addAttribute("currentPage", subjectList.getPage()+1);
		model.addAttribute("totalPages", subjectList.getPageCount());
		
		return "setup/subject/subjectList";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/{page}", method=RequestMethod.GET)
	public String listContentManager(@PathVariable String page, Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		PagedListHolder subjectList = (PagedListHolder) request.getSession().getAttribute("listall_subjectList");
	   
		if (subjectList==null){
			return "redirect:/setup/subject/listAll";
		}
		
	    if ("next".equals(page)) {
	        subjectList.nextPage();
	    } else if ("previous".equals(page)) {
	        subjectList.previousPage();
	    } else if ("last".equals(page)){
	    	subjectList.setPage(subjectList.getPageCount()-1);
	    }
	    
	    model.addAttribute("listSubject",(List<Subject>) subjectList.getPageList());
	    
	    if (subjectList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
	    
	    if (subjectList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
	    
	    model.addAttribute("currentPage", subjectList.getPage()+1);
		model.addAttribute("totalPages", subjectList.getPageCount());
		
		return "setup/subject/subjectList";
	}
}
