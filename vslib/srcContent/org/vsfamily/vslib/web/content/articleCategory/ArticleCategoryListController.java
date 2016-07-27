package org.vsfamily.vslib.web.content.articleCategory;

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
import org.vsfamily.vslib.common.domain.ArticleCategory;
import org.vsfamily.vslib.web.content.ContentBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/content/articleCategory/listAll")
public class ArticleCategoryListController extends ContentBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listArticleCategory(Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		//this.setDefaults(request, response, model, principal);
		
		PagedListHolder<ArticleCategory> articleCategoryList = new PagedListHolder<ArticleCategory>(
				(List<ArticleCategory>) this.vslibService.listArticleCategory());
		articleCategoryList.setPageSize(25);
		request.getSession().setAttribute("listall_articleCategoryList", articleCategoryList);
		
		model.addAttribute("listArticleCategory",(List<ArticleCategory>) articleCategoryList.getPageList());
		
		if (articleCategoryList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
		
		if (articleCategoryList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
		
		model.addAttribute("currentPage", articleCategoryList.getPage()+1);
		model.addAttribute("totalPages", articleCategoryList.getPageCount());
		
		return "content/articleCategory/articleCategoryList";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/{page}", method=RequestMethod.GET)
	public String listArticleCategory(@PathVariable String page, Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		PagedListHolder articleCategoryList = (PagedListHolder) request.getSession().getAttribute("listall_articleCategoryList");
	   
		if (articleCategoryList==null){
			return "redirect:/content/articleCategory/listAll";
		}
		
	    if ("next".equals(page)) {
	        articleCategoryList.nextPage();
	    } else if ("previous".equals(page)) {
	        articleCategoryList.previousPage();
	    } else if ("last".equals(page)){
	    	articleCategoryList.setPage(articleCategoryList.getPageCount()-1);
	    }
	    
	    model.addAttribute("listArticleCategory",(List<ArticleCategory>) articleCategoryList.getPageList());
	    
	    if (articleCategoryList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
	    
	    if (articleCategoryList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
	    
	    model.addAttribute("currentPage", articleCategoryList.getPage()+1);
		model.addAttribute("totalPages", articleCategoryList.getPageCount());
		
		return "content/articleCategory/articleCategoryList";
	}
}