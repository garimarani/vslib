package org.vsfamily.vslib.web.content.articleCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.ArticleCategory;
import org.vsfamily.vslib.web.content.ContentBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/content/articleCategory/delete")
public class ArticleCategoryDeleteController extends ContentBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String deleteArticleCategory(@PathVariable Long id, Model model, RedirectAttributes reat){
		
		ArticleCategory articleCategory = this.vslibService.getArticleCategory(id);
		
		if (articleCategory == null){
			reat.addFlashAttribute("message", "No such article category record.");
			return "redirect:/content/articleCategory/addNew";
		}
		
		if (this.vslibService.deleteArticleCategory(articleCategory)){
			reat.addFlashAttribute("message", "Article Category record deleted successfully.");
			return "redirect:/content/articleCategory/addNew";
		} else {
			reat.addFlashAttribute("message", "Article Category record not deleted.");
			return "redirect:/content/articleCategory/listAll/current";
		}
	}
	
}
