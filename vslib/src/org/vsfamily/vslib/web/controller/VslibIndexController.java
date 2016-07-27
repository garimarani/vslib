package org.vsfamily.vslib.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Article;
import org.vsfamily.vslib.web.service.VslibService;

/**
 * Controller for Home module.
 */
@Controller
@RequestMapping("/")
public class VslibIndexController extends VslibBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String indexView(Model model) {
		
		List<Article> listArticle = this.vslibService.listArticleHomePagePublished();
		
		model.addAttribute("listArticle", listArticle);

		return "index";
	}

	@RequestMapping(value = "/accessDenied")
	public String accessDenied(Model model, RedirectAttributes reat) {
		reat.addFlashAttribute("message", "Access is denied.");
		return "vslib/accessDenied";
	}

	@RequestMapping(value = "/invalidSession")
	public String invalidSession(Model model, RedirectAttributes reat) {
		reat.addFlashAttribute("message", "Invalid Session.");
		return "vslib/invalidSession";
	}

	@RequestMapping(value = "/loginAuthenticationError")
	public String loginAuthenticationError(Model model, RedirectAttributes reat) {
		reat.addFlashAttribute("message", "Login authentication error.");
		return "vslib/loginAuthenticationError";
	}
	
	@RequestMapping(value = "/badCredentials")
	public String badCredentials(Model model, RedirectAttributes reat) {
		reat.addFlashAttribute("message", "Login authentication error.");
		return "vslib/loginAuthenticationError";
	}

	@RequestMapping(value = "/loginSuccess")
	public String loginSuccess(Model model, RedirectAttributes reat) {
		reat.addFlashAttribute("message", "Login succes");
		return "vslib/loginSuccess";
	}

	@RequestMapping(value = "/logoutSuccess")
	public String logoutSuccess(Model model, RedirectAttributes reat) {
		reat.addFlashAttribute("message", "Logged out successfully.");
		return "vslib/logoutSuccess";
	}

	@RequestMapping(value = "/login")
	public String login(Model model) {
		return "vslib/login";
	}
}
