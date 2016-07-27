package org.vsfamily.vslib.web.content.articleCategory;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.ArticleCategory;
import org.vsfamily.vslib.web.content.ContentBaseController;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.validators.add.ArticleCategoryAddValidator;

@Controller
@RequestMapping("/content/articleCategory/addNew")
public class ArticleCategoryAddController extends ContentBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	ArticleCategoryAddValidator articleCategoryAddValidator;
	
	@RequestMapping(method=RequestMethod.GET)
	public String addArticleCategory(Model model){
		
		ArticleCategory articleCategory = new ArticleCategory();
		
		model.addAttribute("articleCategory", articleCategory);
		
		return "content/articleCategory/articleCategory";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addArticleCategory(@ModelAttribute ArticleCategory articleCategory, BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		this.articleCategoryAddValidator.validate(articleCategory, result);
		
		if (result.hasErrors()){
			return "content/articleCategory/articleCategory";
		}
		
		articleCategory.setAddDefaults(principal.getName());
		
		if (this.vslibService.addArticleCategory(articleCategory)){
			reat.addFlashAttribute("message", "Article Category record added successfully.");
			return "redirect:/content/articleCategory/addNew";
		} else {
			reat.addFlashAttribute("message", "Article Category record not added.");
			return "redirect:/content/articleCategory/addNew";
		}
	}
	
}
