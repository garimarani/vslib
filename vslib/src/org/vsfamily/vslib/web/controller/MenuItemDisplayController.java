package org.vsfamily.vslib.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Article;
import org.vsfamily.vslib.common.domain.ArticleCategory;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/menuItem")
public class MenuItemDisplayController extends VslibBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(value="/displayArticle/{id}", method=RequestMethod.GET)
	public String displayArticle(@PathVariable Long id, Model model, RedirectAttributes reat){
		
		Article article = this.vslibService.getArticle(id);
		
		if (article == null){
			reat.addFlashAttribute("message", "No such an Article record.");
			return "redirect:/";
		}
		model.addAttribute("article", article);
		return "menuItem/article";
	}
	
	@RequestMapping(value="/displayCategoryBlog/{id}", method=RequestMethod.GET)
	public String displayCategoryBlog(@PathVariable Long id, Model model, RedirectAttributes reat){
		
		ArticleCategory articleCategory = this.vslibService.getArticleCategory(id);
		
		if (articleCategory == null){
			reat.addFlashAttribute("message", "No such an Article Category record.");
			return "redirect:/";
		}
		
		List<Article> listArticle = this.vslibService.listArticlePublished(articleCategory);
		
		model.addAttribute("listArticle", listArticle);
		return "menuItem/category";
	}
}
