package org.vsfamily.vslib.web.content.article;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Article;
import org.vsfamily.vslib.common.domain.ArticleCategory;
import org.vsfamily.vslib.web.content.ContentBaseController;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.validators.ArticleValidator;

@Controller
@RequestMapping("/content/article/edit")
public class ArticleEditController extends ContentBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	ArticleValidator articleValidator;
	
	@ModelAttribute("listArticleCategory")
	public List<ArticleCategory> getListArticleCategory(){
		return this.vslibService.listArticleCategory();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editArticle(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		Article article = (Article) this.vslibService.getArticle(id);
		
		if (article==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/content/article/addNew";
		}
		
		model.addAttribute("article", article);
		return "content/article/articleEdit";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.POST)
	public String editArticle(@ModelAttribute Article article, BindingResult result, Model model,RedirectAttributes reat, Principal principal){
		Article obj = (Article) this.vslibService.getArticle(article.getId());
		
		if (obj==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/content/article/listAll";
		}
		
		this.articleValidator.validate(article, result);
		
		if (result.hasErrors()){
			return "content/article/articleEdit";
		}
		
		obj.setTitle(article.getTitle());
		obj.setArticleContent(article.getArticleContent());
		obj.setCategory(article.getCategory());
		obj.setPublished(article.isPublished());
		obj.setHomePage(article.isHomePage());
		
		obj.setUpdateDefaults(principal.getName());
		
		if (this.vslibService.updateArticle(obj)){
			reat.addFlashAttribute("message","Record updated successfully.");
			return "redirect:/content/article/listAll";
		} else {
			reat.addFlashAttribute("message","Record not updated.");
			return "redirect:/content/article/listAll/current";
		}
	}
}