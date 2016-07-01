package org.vsfamily.vslib.web.common.service;

import java.util.List;

import org.vsfamily.common.domain.Address;
import org.vsfamily.common.domain.Gender;
import org.vsfamily.common.domain.Salutation;

public interface VslibCommonService {

	public boolean							addAddress(Address address);
	public boolean							addGender(Gender gender);
	public boolean							addSalutation(Salutation salutation);
	
	public boolean							deleteAddress(Address address);
	public boolean							deleteGender(Gender gender);
	public boolean							deleteSalutation(Salutation salutation);
	
	public Address							getAddress(Long id);
	public Gender							getGender(Long id);
	public Gender							getGenderCode(String code);
	public Gender							getGenderName(String name);
	public Salutation						getSalutation(Long id);
	public Salutation						getSalutationCode(String code);
	
	public List<Gender>						listGender();
	public List<Salutation>					listSalutation();
	
	public boolean							updateAddress(Address address);
	public boolean							updateGender(Gender gender);
	public boolean							updateSalutation(Salutation salutation);
}
