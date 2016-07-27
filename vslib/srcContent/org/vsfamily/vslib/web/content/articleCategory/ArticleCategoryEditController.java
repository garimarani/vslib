package org.vsfamily.vslib.web.content.articleCategory;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.ArticleCategory;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.content.ContentBaseController;
import org.vsfamily.vslib.web.validators.edit.ArticleCategoryEditValidator;

@Controller
@RequestMapping("/content/articleCategory/edit")
public class ArticleCategoryEditController extends ContentBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	ArticleCategoryEditValidator articleCategoryEditValidator;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editArticleCategory(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		ArticleCategory articleCategory = (ArticleCategory) this.vslibService.getArticleCategory(id);
		
		if (articleCategory==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/content/articleCategory/addNew";
		}
		
		model.addAttribute("articleCategory", articleCategory);
		return "content/articleCategory/articleCategoryEdit";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.POST)
	public String editArticleCategory(@ModelAttribute ArticleCategory articleCategory, BindingResult result, Model model,RedirectAttributes reat, Principal principal){
		ArticleCategory obj = (ArticleCategory) this.vslibService.getArticleCategory(articleCategory.getId());
		
		if (obj==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/content/articleCategory/listAll";
		}
		
		this.articleCategoryEditValidator.validate(articleCategory, result);
		
		if (result.hasErrors()){
			return "content/articleCategory/articleCategoryEdit";
		}
		
		obj.setName(articleCategory.getName());
		obj.setDescription(articleCategory.getDescription());
		
		obj.setUpdateDefaults(principal.getName());
		
		if (this.vslibService.updateArticleCategory(obj)){
			reat.addFlashAttribute("message","Record updated successfully.");
			return "redirect:/content/articleCategory/listAll";
		} else {
			reat.addFlashAttribute("message","Record not updated.");
			return "redirect:/content/articleCategory/listAll/current";
		}
	}
}