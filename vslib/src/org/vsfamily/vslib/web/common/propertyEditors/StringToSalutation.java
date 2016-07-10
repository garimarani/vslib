package org.vsfamily.vslib.web.common.propertyEditors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.common.domain.Salutation;
import org.vsfamily.vslib.web.common.service.VslibCommonService;

/**
 * Converts id (String form) to the object of type Salutation.
 */
public class StringToSalutation implements Converter<String, Salutation>{

	@Autowired
	VslibCommonService vslibCommonService;

	@Override
	public Salutation convert(String id) {
		try {
			return this.vslibCommonService.getSalutation(new Long(id));
		} catch (Exception e){
			return null;
		}
	}	
}
