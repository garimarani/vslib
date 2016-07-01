package org.vsfamily.vslib.web.circulation.patron;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.common.domain.Gender;
import org.vsfamily.common.domain.Salutation;
import org.vsfamily.vslib.common.domain.Patron;
import org.vsfamily.vslib.common.domain.PatronCategory;
import org.vsfamily.vslib.common.domain.PatronGroup;
import org.vsfamily.vslib.web.circulation.CirculationBaseController;
import org.vsfamily.vslib.web.common.service.VslibCommonService;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.validators.add.PatronAddValidator;

@Controller
@RequestMapping("/circulation/patron/addNew")
public class PatronAddController extends CirculationBaseController {

	@Autowired
	VslibCommonService vslibCommonService;
	
	@Autowired
	VslibService vslibService;
	
	@Autowired
	PatronAddValidator patronAddValidator;
	
	@ModelAttribute("listGender")
	public List<Gender> getListGender(){
		return this.vslibCommonService.listGender();
	}
	
	@ModelAttribute("listSalutation")
	public List<Salutation> getListSalutation(){
		return this.vslibCommonService.listSalutation();
	}
	
	@ModelAttribute("listPatronCategory")
	public List<PatronCategory> getListPatronCategory(){
		return this.vslibService.listPatronCategory();
	}
	
	@ModelAttribute("listPatronGroup")
	public List<PatronGroup> getListPatronGroup(){
		return this.vslibService.listPatronGroup();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String addPatron(Model model){
		
		Patron patron = new Patron();
		
		model.addAttribute("patron", patron);
		return "circulation/patron/patron";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addPatron(@ModelAttribute Patron patron, BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		this.patronAddValidator.validate(patron, result);
		
		if (result.hasErrors()){
			return "circulation/patron/patron";
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPass = encoder.encode(patron.getPassword());
		
		patron.setPassword(hashedPass);
		
		patron.setAddDefaults(principal.getName());
		
		if (this.vslibService.addPatron(patron)){
			reat.addFlashAttribute("message", "Patron record added successfully.");
			return "redirect:/circulation/patron/view/" + patron.getId().toString();
		} else {
			reat.addFlashAttribute("message", "Patron record not added.");
			return "redirect:/circulation/patron/addNew";
		}
	}
}
