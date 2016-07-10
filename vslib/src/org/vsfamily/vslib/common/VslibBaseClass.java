package org.vsfamily.vslib.common;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;

@SuppressWarnings("serial")
public class VslibBaseClass implements Serializable {

	private Long		id;
	private String 		code;
	private String		name;
	private String		label;
	
	private String		recordAddedBy;
	private String		recordUpdatedBy;
	private Calendar	addDate;
	private Calendar	updateDate;
	
	
	/**
	 * Gets the object (record) identifier (system generated).
	 * @return the record identifier
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Sets the object (record) identifier 
	 * @param id - the identifier
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Gets the code.
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Sets the code. Convert the code to uppercase.
	 * @param code - the code
	 */
	public void setCode(String code) {
		if (code!=null)
			this.code = code.toUpperCase(Locale.getDefault());
		else this.code = null;
	}
	
	/**
	 * Gets the name.
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 * @param name - the name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the label to be used for display in the select lists.
	 * @return the label
	 */
	public String getLabel(){
		if (this.code!=null) label = this.code;
		if (this.name!=null) label = label + " - " + this.name; 
		return label;
	}
	
	/**
	 * Gets the login id of the person who added the record.
	 * @return the login id of the person
	 */
	public String getRecordAddedBy() {
		return recordAddedBy;
	}
	
	/**
	 * Sets the login id of the person who added the record.
	 * @param recordAddedBy - the login id of the person who added the record
	 */
	public void setRecordAddedBy(String recordAddedBy) {
		this.recordAddedBy = recordAddedBy;
	}
	
	/**
	 * Gets the login id of the person who last updated the record.
	 * @return the login id of the person who last updated the record
	 */
	public String getRecordUpdatedBy() {
		return recordUpdatedBy;
	}
	
	/**
	 * Sets the login id of the person who last updated the record.
	 * @param recordUpdatedBy - the login id of the person who last updated the record
	 */
	public void setRecordUpdatedBy(String recordUpdatedBy) {
		this.recordUpdatedBy = recordUpdatedBy;
	}
	
	/**
	 * Gets the date when record was added.
	 * @return the date when record was added
	 */
	public Calendar getAddDate() {
		return addDate;
	}
	
	/**
	 * Sets the date when record was added.
	 * @param addDate - the date when record was added
	 */
	public void setAddDate(Calendar addDate) {
		this.addDate = addDate;
	}
	
	/**
	 * Gets the date of last update.
	 * @return the date of last update
	 */
	public Calendar getUpdateDate() {
		return updateDate;
	}
	
	/** 
	 * Sets the date of last update
	 * @param updateDate - the date of last update
	 */
	public void setUpdateDate(Calendar updateDate) {
		this.updateDate = updateDate;
	}
	
	/**
	 * Sets the parameters for adding an object to the repository.
	 * @param user - the login id of the user/manager operating on the object
	 */
	public void setAddDefaults(String user){
		this.recordAddedBy = user;
		this.recordUpdatedBy = user;
		this.addDate = Calendar.getInstance();
		this.updateDate = Calendar.getInstance();
	}
	
	/**
	 * Sets the parameters for updating an object in the repository.
	 * @param user - the login id of the user / manager operating on the object
	 */
	public void setUpdateDefaults(String user){
		this.recordUpdatedBy = user;
		this.updateDate = Calendar.getInstance();
	}
}
