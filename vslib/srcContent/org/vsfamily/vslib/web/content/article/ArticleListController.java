package org.vsfamily.vslib.web.content.article;

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
import org.vsfamily.vslib.common.domain.Article;
import org.vsfamily.vslib.web.content.ContentBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/content/article/listAll")
public class ArticleListController extends ContentBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listArticle(Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		//this.setDefaults(request, response, model, principal);
		
		PagedListHolder<Article> articleList = new PagedListHolder<Article>(
				(List<Article>) this.vslibService.listArticle());
		articleList.setPageSize(25);
		request.getSession().setAttribute("listall_articleList", articleList);
		
		model.addAttribute("listArticle",(List<Article>) articleList.getPageList());
		
		if (articleList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
		
		if (articleList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
		
		model.addAttribute("currentPage", articleList.getPage()+1);
		model.addAttribute("totalPages", articleList.getPageCount());
		
		return "content/article/articleList";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/{page}", method=RequestMethod.GET)
	public String listArticle(@PathVariable String page, Model model, HttpServletRequest request, HttpServletResponse response, Principal principal){
		
		PagedListHolder articleList = (PagedListHolder) request.getSession().getAttribute("listall_articleList");
	   
		if (articleList==null){
			return "redirect:/content/article/listAll";
		}
		
	    if ("next".equals(page)) {
	        articleList.nextPage();
	    } else if ("previous".equals(page)) {
	        articleList.previousPage();
	    } else if ("last".equals(page)){
	    	articleList.setPage(articleList.getPageCount()-1);
	    }
	    
	    model.addAttribute("listArticle",(List<Article>) articleList.getPageList());
	    
	    if (articleList.isFirstPage()){
			model.addAttribute("firstPage", true);
		} else {
			model.addAttribute("firstPage", false);
		}
	    
	    if (articleList.isLastPage()){
			model.addAttribute("lastPage", true);
		} else {
			model.addAttribute("lastPage", false);
		}
	    
	    model.addAttribute("currentPage", articleList.getPage()+1);
		model.addAttribute("totalPages", articleList.getPageCount());
		
		return "content/article/articleList";
	}
}