package org.vsfamily.vslib.web.manager.propertEditors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.manager.domain.Manager;
import org.vsfamily.vslib.web.manager.service.ManagerService;

public class StringToManager implements Converter<String, Manager> {

	@Autowired
	ManagerService managerService;
	
	@Override
	public Manager convert(String id) {
		try {
			return this.managerService.getManager(new Long(id));
		} catch (Exception e){
			return null;
		}
	}

}
