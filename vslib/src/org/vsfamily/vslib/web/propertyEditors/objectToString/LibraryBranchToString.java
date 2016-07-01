package org.vsfamily.vslib.web.propertyEditors.objectToString;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.LibraryBranch;

public class LibraryBranchToString implements Converter<LibraryBranch, String>{

	@Override
	public String convert(LibraryBranch obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
	}

}
