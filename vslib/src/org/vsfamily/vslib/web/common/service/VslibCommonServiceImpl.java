package org.vsfamily.vslib.web.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vsfamily.common.domain.Address;
import org.vsfamily.common.domain.Gender;
import org.vsfamily.common.domain.Salutation;
import org.vsfamily.vslib.web.common.repository.VslibCommonDAO;

@Component(value="vslibCommonService")
public class VslibCommonServiceImpl implements VslibCommonService {

	@Autowired
	VslibCommonDAO vslibCommonDAO;

	@Override
	public boolean addAddress(Address address) {
		return this.vslibCommonDAO.save(address);
	}

	@Override
	public boolean addGender(Gender gender) {
		return this.vslibCommonDAO.save(gender);
	}

	@Override
	public boolean addSalutation(Salutation salutation) {
		return this.vslibCommonDAO.save(salutation);
	}

	@Override
	public boolean deleteAddress(Address address) {
		return this.vslibCommonDAO.delete(address);
	}

	@Override
	public boolean deleteGender(Gender gender) {
		return this.vslibCommonDAO.delete(gender);
	}

	@Override
	public boolean deleteSalutation(Salutation salutation) {
		return this.vslibCommonDAO.delete(salutation);
	}

	@Override
	public Address getAddress(Long id) {
		return (Address) this.vslibCommonDAO.getObjectById(Address.class, id);
	}

	@Override
	public Gender getGender(Long id) {
		return (Gender) this.vslibCommonDAO.getObjectById(Gender.class, id);
	}

	@Override
	public Gender getGenderCode(String code) {
		return (Gender) this.vslibCommonDAO.getObjectByArg(Gender.class, "code", code);
	}

	@Override
	public Gender getGenderName(String name) {
		return (Gender) this.vslibCommonDAO.getObjectByArg(Gender.class, "name", name);
	}

	@Override
	public Salutation getSalutation(Long id) {
		return (Salutation) this.vslibCommonDAO.getObjectById(Salutation.class, id);
	}

	@Override
	public Salutation getSalutationCode(String code) {
		return (Salutation) this.vslibCommonDAO.getObjectByArg(Salutation.class, "code", code);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Gender> listGender() {
		return (List<Gender>) this.vslibCommonDAO.listObjectSorted(Gender.class, "code", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Salutation> listSalutation() {
		return (List<Salutation>) this.vslibCommonDAO.listObjectSorted(Salutation.class, "code", "asc");
	}

	@Override
	public boolean updateAddress(Address address) {
		return this.vslibCommonDAO.update(address);
	}

	@Override
	public boolean updateGender(Gender gender) {
		return this.vslibCommonDAO.update(gender);
	}

	@Override
	public boolean updateSalutation(Salutation salutation) {
		return this.vslibCommonDAO.update(salutation);
	}
	
	
}
