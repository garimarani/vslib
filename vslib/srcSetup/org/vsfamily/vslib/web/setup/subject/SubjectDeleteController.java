package org.vsfamily.vslib.web.setup.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Subject;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;

@Controller
@RequestMapping("/setup/subject/delete")
public class SubjectDeleteController extends SetupBaseController {

	@Autowired
	VslibService vslibService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String deleteSubject(@PathVariable Long id, Model model,RedirectAttributes reat){
		
		Subject subject = (Subject) this.vslibService.getSubject(id);
		
		if (subject==null){
			reat.addFlashAttribute("message","No such record.");
			return "redirect:/setup/subject/addNew";
		}
		
		if (this.vslibService.deleteSubject(subject)){
			reat.addFlashAttribute("message","Recored deleted successfully.");
			return "redirect:/setup/subject/addNew";
		} else {
			reat.addFlashAttribute("message","Record not deleted.");
			return "redirect:/setup/subject/listAll/current";
		}
	}
}