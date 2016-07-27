package org.vsfamily.vslib.web.content.menuItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.MenuItem;
import org.vsfamily.vslib.web.content.ContentBaseController;
import org.vsfamily.vslib.web.service.VslibService;

@Controller
@RequestMapping("/content/menuItem/delete")
public class MenuItemDeleteController extends ContentBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String deleteMenuItem(@PathVariable Long id, Model model, RedirectAttributes reat){
		
		MenuItem menuItem = this.vslibService.getMenuItem(id);
		
		if (menuItem == null){
			reat.addFlashAttribute("message", "No such menu item record.");
			return "redirect:/content/menuItem/addNew";
		}
		
		if (this.vslibService.deleteMenuItem(menuItem)){
			reat.addFlashAttribute("message", "Menu Item record deleted successfully.");
			return "redirect:/content/menuItem/addNew";
		} else {
			reat.addFlashAttribute("message", "Menu Item record not deleted.");
			return "redirect:/content/menuItem/listAll/current";
		}
	}
	
}
