package org.vsfamily.vslib.web.content.article;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Article;
import org.vsfamily.vslib.common.domain.ArticleCategory;
import org.vsfamily.vslib.web.content.ContentBaseController;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.validators.ArticleValidator;

@Controller
@RequestMapping("/content/article/addNew")
public class ArticleAddController extends ContentBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	ArticleValidator articleValidator;
	
	@ModelAttribute("listArticleCategory")
	public List<ArticleCategory> getListArticleCategory(){
		return this.vslibService.listArticleCategory();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String addArticle(Model model){
		
		Article article = new Article();
		
		model.addAttribute("article", article);
		
		return "content/article/article";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addArticle(@ModelAttribute Article article, BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		this.articleValidator.validate(article, result);
		
		if (result.hasErrors()){
			return "content/article/article";
		}
		
		article.setAddDefaults(principal.getName());
		
		if (this.vslibService.addArticle(article)){
			reat.addFlashAttribute("message", "Article record added successfully.");
			return "redirect:/content/article/addNew";
		} else {
			reat.addFlashAttribute("message", "Article record not added.");
			return "redirect:/content/article/addNew";
		}
	}
	
}
