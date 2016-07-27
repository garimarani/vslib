package org.vsfamily.vslib.web.content.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Article;
import org.vsfamily.vslib.web.content.ContentBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/content/article/delete")
public class ArticleDeleteController extends ContentBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String deleteArticle(@PathVariable Long id, Model model, RedirectAttributes reat){
		
		Article article = this.vslibService.getArticle(id);
		
		if (article == null){
			reat.addFlashAttribute("message", "No such article record.");
			return "redirect:/content/article/addNew";
		}
		
		if (this.vslibService.deleteArticle(article)){
			reat.addFlashAttribute("message", "Article record deleted successfully.");
			return "redirect:/content/article/addNew";
		} else {
			reat.addFlashAttribute("message", "Article record not deleted.");
			return "redirect:/content/article/listAll/current";
		}
	}
	
}
