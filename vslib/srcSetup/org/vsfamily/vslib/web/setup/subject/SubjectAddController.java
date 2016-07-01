package org.vsfamily.vslib.web.setup.subject;

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
import org.vsfamily.vslib.common.domain.Subject;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;
import org.vsfamily.vslib.web.validators.add.SubjectAddValidator;

@Controller
@RequestMapping("/setup/subject/addNew")
public class SubjectAddController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	private SubjectAddValidator subjectAddValidator;
	
	@ModelAttribute("listSubject")
	public List<Subject> getListSubject(){
		return this.vslibService.listSubject();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String addNew(Model model){
		model.addAttribute("subject", new Subject());
		return "setup/subject/subject";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addNew(@ModelAttribute Subject subject, 
			BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		
		this.subjectAddValidator.validate(subject, result);
		if (result.hasErrors()){
			return "setup/subject/subject";
		}
		
		subject.setAddDefaults(principal.getName());
		
		if (this.vslibService.addSubject(subject)){
			reat.addFlashAttribute("message","Record saved (" + subject.getId() + ")");
			return "redirect:/setup/subject/addNew";
		} else {
			reat.addFlashAttribute("message","Record not added! Try again later.");
			return "redirect:/setup/subject/addNew";
		}
	}
}
