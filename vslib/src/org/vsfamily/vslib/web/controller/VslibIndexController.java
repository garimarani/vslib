package org.vsfamily.vslib.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class VslibIndexController {


	@ModelAttribute("viewLeftMenu")
	public String viewLeftMenu() {
		return "leftMenu";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String indexView(Model model) {

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
