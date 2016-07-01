package org.vsfamily.vslib.web.common.propertyEditors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.common.domain.Gender;
import org.vsfamily.vslib.web.common.service.VslibCommonService;

public class StringToGender implements Converter<String, Gender>{

	@Autowired
	VslibCommonService vslibCommonService;

	@Override
	public Gender convert(String id) {
		try {
			return this.vslibCommonService.getGender(new Long(id));
		} catch (Exception e){
			return null;
		}
	}
}
