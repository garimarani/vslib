package org.vsfamily.vslib.web.manager.propertEditors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.manager.domain.VslibRole;
import org.vsfamily.vslib.web.manager.service.ManagerService;

public class StringToVslibRole implements Converter<String, VslibRole>{

	@Autowired
	ManagerService managerService;
	
	@Override
	public VslibRole convert(String id) {
		try {
			return this.managerService.getVslibRole(new Long(id));
		} catch (Exception e){
			return null;
		}
	}

}
