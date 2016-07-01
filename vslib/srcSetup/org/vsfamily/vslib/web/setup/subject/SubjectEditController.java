package org.vsfamily.vslib.web.setup.subject;

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
import org.vsfamily.vslib.common.domain.Subject;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;
import org.vsfamily.vslib.web.validators.edit.SubjectEditValidator;

@Controller
@RequestMapping("/setup/subject/edit")
public class SubjectEditController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	private SubjectEditValidator subjectEditValidator;
	
	@ModelAttribute("listSubject")
	public List<Subject> getListSubject(){
		return this.vslibService.listSubject();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String editSubject(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		Subject subject = (Subject) this.vslibService.getSubject(id);
		
		if (subject==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/subject/addNew";
		}
		
		model.addAttribute("subject", subject);
		return "setup/subject/subjectEdit";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.POST)
	public String editSubject(@ModelAttribute Subject subject, BindingResult result, Model model,RedirectAttributes reat, Principal principal){
		Subject obj = (Subject) this.vslibService.getSubject(subject.getId());
		
		if (obj==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/subject/listAll";
		}
		
		this.subjectEditValidator.validate(subject, result);
		
		if (result.hasErrors()){
			return "setup/subject/subjectEdit";
		}
		
		obj.setCode(subject.getCode());
		obj.setName(subject.getName());
		obj.setParentSubject(subject.getParentSubject());
		
		obj.setUpdateDefaults(principal.getName());
		
		if (this.vslibService.updateSubject(obj)){
			reat.addFlashAttribute("message","Record updated successfully.");
			return "redirect:/setup/subject/listAll";
		} else {
			reat.addFlashAttribute("message","Record not updated.");
			return "redirect:/setup/subject/listAll/current";
		}
	}
}