package org.vsfamily.vslib.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.vsfamily.vslib.common.domain.Adverts;
import org.vsfamily.vslib.common.domain.MenuItem;
import org.vsfamily.vslib.common.domain.VslibParams;
import org.vsfamily.vslib.web.service.VslibService;

/**
 * Base controller for Home module.
 */
public class VslibBaseController {
	
	@Autowired
	VslibService vslibService;
	
	@ModelAttribute("listLeftAdverts")
	public List<Adverts> getListLeftAdverts(){
		return this.vslibService.listAdverts("left");
	}
	
	@ModelAttribute("listBottomAdverts")
	public List<Adverts> getListBottomAdverts(){
		return this.vslibService.listAdverts("bottom");
	}

	@ModelAttribute("vslibParams")
	public VslibParams getVslibParams(){
		return this.vslibService.getVslibParams();
	}
	
	@ModelAttribute("listMenuItemDisplay")
	public List<MenuItem> getListMenuItemDisplay(){
		return this.vslibService.listMenuItemPublished();
	}
	
	@ModelAttribute("viewLeftMenu")
	public String viewLeftMenu() {
		return "leftMenu";
	}
}
