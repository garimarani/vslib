package org.vsfamily.vslib.web.profile;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.vsfamily.vslib.web.controller.VslibBaseController;

/**
 * Base controller used by other controllers handling profile related services.
 */
public class ProfileBaseController extends VslibBaseController {

	/**
	 * Gets the leftMenu file name.
	 * @return the leftMenu file name
	 */
	@ModelAttribute("viewLeftMenu")
	public String viewLeftMenu(){
		return "profile/leftMenu";
	}
	
}
