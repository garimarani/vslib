package org.vsfamily.vslib.web.setup.parameters;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.VslibParams;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;
import org.vsfamily.vslib.web.validators.ParametersEmailValidator;

@Controller
@RequestMapping("/setup/parameters/email")
public class EmailParamsController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	ParametersEmailValidator parametersEmailValidator;
	
	@RequestMapping(method = RequestMethod.GET)
	public String emailParameters(Model model, RedirectAttributes reat, Principal principal){
		
		VslibParams vslibParams = this.vslibService.getVslibParams();
		
		if (vslibParams == null){
			vslibParams = new VslibParams();
		}
		
		model.addAttribute("vslibParams", vslibParams);
		return "setup/parameters/email";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String emailParameters(@ModelAttribute VslibParams vslibParams, BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		this.parametersEmailValidator.validate(vslibParams, result);
		
		if (result.hasErrors()){
			return "setup/parameters/email";
		}
		
		VslibParams obj = this.vslibService.getVslibParams();
		
		if (obj == null){
			obj = new VslibParams();
		}
		
		obj.setEnableEmail(vslibParams.isEnableEmail());
		obj.setHost(vslibParams.getHost());
		obj.setPort(vslibParams.getPort());
		obj.setUsername(vslibParams.getUsername());
		obj.setPassword(vslibParams.getPassword());
		obj.setSmtpAuthEnable(vslibParams.isSmtpAuthEnable());
		obj.setSslOrTls(vslibParams.getSslOrTls());
		obj.setFromEmail(vslibParams.getFromEmail());
		
		obj.setAddDefaults(principal.getName());
		
		if (this.vslibService.addVslibParams(obj)){
			reat.addFlashAttribute("message", "Email parameters updated successfully.");
			return "redirect:/setup/parameters";
		} else {
			reat.addFlashAttribute("message", "Email parameters not updated.");
			return "redirect:/setup/parameters/email";
		}
	}
}
