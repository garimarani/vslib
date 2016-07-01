package org.vsfamily.vslib.web.circulation.patron;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
import org.vsfamily.vslib.web.validators.edit.PatronEditValidator;

@Controller
@RequestMapping("/circulation/patron/edit")
public class PatronEditController extends CirculationBaseController {

	@Autowired
	VslibCommonService vslibCommonService;
	
	@Autowired
	VslibService vslibService;
	
	@Autowired
	PatronEditValidator patronEditValidator;
	
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
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editPatron(@PathVariable Long id, Model model, RedirectAttributes reat, Principal principal){
		
		Patron patron = this.vslibService.getPatron(id);
		
		if (patron == null){
			reat.addFlashAttribute("message", "No such record.");
			return "redirect:/circulation/patron/addNew";
		}
		
		model.addAttribute("patron", patron);
		
		return "circulation/patron/patronEdit";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.POST)
	public String editPatron(@ModelAttribute Patron patron, BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		Patron obj = this.vslibService.getPatron(patron.getId());
		
		if (obj == null){
			reat.addFlashAttribute("message", "No such record.");
			return "redirect:/circulation/patron/addNew";
		}
		
		this.patronEditValidator.validate(patron, result);
		
		if (result.hasErrors()){
			return "circulation/patron/patronEdit";
		}
		
		obj.setNumber(patron.getNumber());
		obj.setSalutation(patron.getSalutation());
		obj.setFirstName(patron.getFirstName());
		obj.setMiddleName(patron.getMiddleName());
		obj.setLastName(patron.getLastName());
		obj.setFatherName(patron.getFatherName());
		obj.setDateOfBirth(patron.getDateOfBirth());
		obj.setGender(patron.getGender());
		obj.setEducation(patron.getEducation());
		obj.getAddress().setAddressValues(patron.getAddress());
		obj.getAlternateAddress().setAddressValues(patron.getAlternateAddress());
		obj.setCategory(patron.getCategory());
		obj.setGroup(patron.getGroup());
		obj.setSubscriptionDate(patron.getSubscriptionDate());
		obj.setSubscriptionExpiryDate(patron.getSubscriptionExpiryDate());
		obj.setSubscriptionAmount(patron.getSubscriptionAmount());
		obj.setPaymentDetails(patron.getPaymentDetails());
		obj.setEmail(patron.getEmail());
		obj.setAlternateEmail(patron.getAlternateEmail());
		if (patron.getPassword()!=null) {
			//PasswordEncoder encoder = new Md5PasswordEncoder();
			//String hashedPass = encoder.encodePassword(patron.getPassword(), null);
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	        String hashedPass = encoder.encode(patron.getPassword());
			
			obj.setPassword(hashedPass);
		}
		
		obj.setUpdateDefaults(principal.getName());
		
		if (this.vslibService.updatePatron(obj)){
			reat.addFlashAttribute("message", "Record updated successfully.");
			return "redirect:/circulation/patron/view/" + patron.getId().toString();
		} else {
			reat.addFlashAttribute("message", "Record not updated.");
			return "redirect:/circulation/patron/view/" + patron.getId().toString();
		}
	}
}
