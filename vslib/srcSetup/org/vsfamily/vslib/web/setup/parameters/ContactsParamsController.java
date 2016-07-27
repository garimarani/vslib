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
import org.vsfamily.vslib.web.validators.ParametersStorageValidator;

@Controller
@RequestMapping("/setup/parameters/contacts")
public class ContactsParamsController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	ParametersStorageValidator parametersStorageValidator;
	
	@RequestMapping(method = RequestMethod.GET)
	public String storageParameters(Model model, RedirectAttributes reat, Principal principal){
		
		VslibParams vslibParams = this.vslibService.getVslibParams();
		
		if (vslibParams == null){
			vslibParams = new VslibParams();
		}
		
		model.addAttribute("vslibParams", vslibParams);
		return "setup/parameters/contacts";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String storageParameters(@ModelAttribute VslibParams vslibParams, BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		this.parametersStorageValidator.validate(vslibParams, result);
		
		if (result.hasErrors()){
			return "setup/parameters/contacts";
		}
		
		VslibParams obj = this.vslibService.getVslibParams();
		
		if (obj == null){
			obj = new VslibParams();
		}
		
		obj.setOrganizationName(vslibParams.getOrganizationName());
		obj.setOrganizationAddress(vslibParams.getOrganizationAddress());
		obj.setContactAddress(vslibParams.getContactAddress());
		obj.setContactEmail(vslibParams.getContactEmail());
		obj.setContactName(vslibParams.getContactName());
		obj.setSiteUrl(vslibParams.getSiteUrl());
		
		obj.setAddDefaults(principal.getName());
		
		if (this.vslibService.addVslibParams(obj)){
			reat.addFlashAttribute("message", "Contacts parameters updated successfully.");
			return "redirect:/setup/parameters";
		} else {
			reat.addFlashAttribute("message", "Contacts parameters not updated.");
			return "redirect:/setup/parameters/email";
		}
	}
}
