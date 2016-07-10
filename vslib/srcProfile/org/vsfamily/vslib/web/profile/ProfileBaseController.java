package org.vsfamily.vslib.web.profile;

import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Base controller used by other controllers handling profile related services.
 */
public class ProfileBaseController {

	/**
	 * Gets the leftMenu file name.
	 * @return the leftMenu file name
	 */
	@ModelAttribute("viewLeftMenu")
	public String viewLeftMenu(){
		return "profile/leftMenu";
	}
	
}
