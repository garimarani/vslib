package org.vsfamily.vslib.web.content.menuItem;

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
import org.vsfamily.vslib.common.domain.MenuItem;
import org.vsfamily.vslib.web.content.ContentBaseController;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.validators.add.MenuItemAddValidator;

@Controller
@RequestMapping("/content/menuItem/addNew")
public class MenuItemAddController extends ContentBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	MenuItemAddValidator menuItemAddValidator;
	
	@ModelAttribute("listArticle")
	public List<Article> getListArticle(){
		return this.vslibService.listArticle();
	}
	
	@ModelAttribute("listArticleCategory")
	public List<ArticleCategory> getListArticleCategory(){
		return this.vslibService.listArticleCategory();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String addMenuItem(Model model){
		
		MenuItem menuItem = new MenuItem();
		
		model.addAttribute("menuItem", menuItem);
		
		return "content/menuItem/menuItem";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addMenuItem(@ModelAttribute MenuItem menuItem, BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		this.menuItemAddValidator.validate(menuItem, result);
		
		if (result.hasErrors()){
			return "content/menuItem/menuItem";
		}
		
		menuItem.setAddDefaults(principal.getName());
		
		if (this.vslibService.addMenuItem(menuItem)){
			reat.addFlashAttribute("message", "Menu Item record added successfully.");
			return "redirect:/content/menuItem/addNew";
		} else {
			reat.addFlashAttribute("message", "Menu Item record not added.");
			return "redirect:/content/menuItem/addNew";
		}
	}
}
