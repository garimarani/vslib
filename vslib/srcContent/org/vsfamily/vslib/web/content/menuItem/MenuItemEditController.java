package org.vsfamily.vslib.web.content.menuItem;

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
import org.vsfamily.vslib.common.domain.MenuItem;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.content.ContentBaseController;
import org.vsfamily.vslib.web.validators.edit.MenuItemEditValidator;

@Controller
@RequestMapping("/content/menuItem/edit")
public class MenuItemEditController extends ContentBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	private MenuItemEditValidator menuItemEditValidator;

	@ModelAttribute("listArticle")
	public List<Article> getListArticle(){
		return this.vslibService.listArticle();
	}
	
	@ModelAttribute("listArticleCategory")
	public List<ArticleCategory> getListArticleCategory(){
		return this.vslibService.listArticleCategory();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editMenuItem(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		MenuItem menuItem = (MenuItem) this.vslibService.getMenuItem(id);
		
		if (menuItem==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/content/menuItem/addNew";
		}
		
		model.addAttribute("menuItem", menuItem);
		return "content/menuItem/menuItemEdit";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.POST)
	public String editMenuItem(@ModelAttribute MenuItem menuItem, BindingResult result, Model model,RedirectAttributes reat, Principal principal){
		MenuItem obj = (MenuItem) this.vslibService.getMenuItem(menuItem.getId());
		
		if (obj==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/content/menuItem/listAll";
		}
		
		this.menuItemEditValidator.validate(menuItem, result);
		
		if (result.hasErrors()){
			return "content/menuItem/menuItemEdit";
		}
		
		obj.setName(menuItem.getName());
		obj.setMenuType(menuItem.getMenuType());
		obj.setExternalUrl(menuItem.getExternalUrl());
		obj.setTargetWindow(menuItem.getTargetWindow());
		obj.setArticle(menuItem.getArticle());
		obj.setArticleCategory(menuItem.getArticleCategory());
		obj.setPublished(menuItem.isPublished());
		
		obj.setUpdateDefaults(principal.getName());
		
		if (this.vslibService.updateMenuItem(obj)){
			reat.addFlashAttribute("message","Record updated successfully.");
			return "redirect:/content/menuItem/listAll";
		} else {
			reat.addFlashAttribute("message","Record not updated.");
			return "redirect:/content/menuItem/listAll/current";
		}
	}
}