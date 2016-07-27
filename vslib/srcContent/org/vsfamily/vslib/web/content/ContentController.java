package org.vsfamily.vslib.web.content;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/content")
public class ContentController extends ContentBaseController {

	@RequestMapping(method=RequestMethod.GET)
	public String contentDefault(Model model){
		return "content/default";
	}
}
