package org.vsfamily.vslib.web.common.service;

import java.util.List;

import org.vsfamily.common.domain.Address;
import org.vsfamily.common.domain.Gender;
import org.vsfamily.common.domain.Salutation;

/**
 * DAO service interface for common objects. 
 */
public interface VslibCommonService {

	/**
	 * Adds the address object of the database.
	 * @param address - the address object
	 * @return true on success, false otherwise
	 */
	public boolean							addAddress(Address address);
	
	/**
	 * Adds the gender object to the database.
	 * @param gender - the gender object
	 * @return true on success, false otherwise
	 */
	public boolean							addGender(Gender gender);
	
	/**
	 * Adds the salutation object to the database.
	 * @param salutation the salutation object
	 * @return true on success, false otherwise
	 */
	public boolean							addSalutation(Salutation salutation);
	
	/**
	 * Deletes the address object from the database.
	 * @param address - the address object
	 * @return true on success, false otherwise
	 */
	public boolean							deleteAddress(Address address);
	
	/**
	 * Deletes the gender object from the database.
	 * @param gender - the gender object
	 * @return true on success, false otherwise
	 */
	public boolean							deleteGender(Gender gender);
	
	/**
	 * Deletes the salutation object from the database.
	 * @param salutation - the salutation object
	 * @return true on success, false otherwise
	 */
	public boolean							deleteSalutation(Salutation salutation);
	
	/**
	 * Gets the address object for the given id.
	 * @param id - the object id
	 * @return the object
	 */
	public Address							getAddress(Long id);
	
	/**
	 * Gets the gender object for the given id.
	 * @param id - the object id
	 * @return the object
	 */
	public Gender							getGender(Long id);
	
	/**
	 * Gets the gender object for the given code.
	 * @param code - the code
	 * @return the object
	 */
	public Gender							getGenderCode(String code);
	
	/**
	 * Gets the gender object for the given name.
	 * @param name - the name
	 * @return the object
	 */
	public Gender							getGenderName(String name);
	
	/**
	 * Gets the salutation object for the given id.
	 * @param id - the object id
	 * @return the object
	 */
	public Salutation						getSalutation(Long id);
	
	/**
	 * Gets the salutation object for the given code.
	 * @param code - the code
	 * @return the object
	 */
	public Salutation						getSalutationCode(String code);
	
	/**
	 * Gets the list of gender objects from the database.
	 * @return the list of gender objects
	 */
	public List<Gender>						listGender();
	
	/**
	 * Gets the list of salutation objects from the database.
	 * @return the list of salutation objects
	 */
	public List<Salutation>					listSalutation();
	
	/**
	 * Updates the address object.
	 * @param address - the address object
	 * @return true if successful, false otherwise
	 */
	public boolean							updateAddress(Address address);
	
	/**
	 * Updates the gender object.
	 * @param gender - the gender object
	 * @return true if successful, false otherwise
	 */
	public boolean							updateGender(Gender gender);
	
	/**
	 * Updates the salutation object.
	 * @param salutation - the salutation object
	 * @return true if successful, false otherwise
	 */
	public boolean							updateSalutation(Salutation salutation);
}
