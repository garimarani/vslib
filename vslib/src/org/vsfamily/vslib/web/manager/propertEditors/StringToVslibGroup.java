package org.vsfamily.vslib.web.manager.propertEditors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.manager.domain.VslibGroup;
import org.vsfamily.vslib.web.manager.service.ManagerService;

public class StringToVslibGroup implements Converter<String, VslibGroup> {

	@Autowired
	ManagerService managerService;
	
	@Override
	public VslibGroup convert(String id) {
		try {
			return this.managerService.getVslibGroup(new Long(id));
		} catch (Exception e){
			return null;
		}
	}

}
