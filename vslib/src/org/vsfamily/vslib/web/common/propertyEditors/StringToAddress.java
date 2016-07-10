package org.vsfamily.vslib.web.common.propertyEditors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.common.domain.Address;
import org.vsfamily.vslib.web.common.service.VslibCommonService;

/**
 * Converts id (String form) to the object of type Address.
 */
public class StringToAddress implements Converter<String, Address> {

	@Autowired
	VslibCommonService vslibCommonService;
	
	@Override
	public Address convert(String id) {
		try {
			return this.vslibCommonService.getAddress(new Long(id));
		} catch (Exception e){
			return null;
		}
	}

}
