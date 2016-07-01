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
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		if (code!=null)
			this.code = code.toUpperCase(Locale.getDefault());
		else this.code = null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLabel(){
		if (this.code!=null) label = this.code;
		if (this.name!=null) label = label + " - " + this.name; 
		return label;
	}
	public String getRecordAddedBy() {
		return recordAddedBy;
	}
	public void setRecordAddedBy(String recordAddedBy) {
		this.recordAddedBy = recordAddedBy;
	}
	public String getRecordUpdatedBy() {
		return recordUpdatedBy;
	}
	public void setRecordUpdatedBy(String recordUpdatedBy) {
		this.recordUpdatedBy = recordUpdatedBy;
	}
	public Calendar getAddDate() {
		return addDate;
	}
	public void setAddDate(Calendar addDate) {
		this.addDate = addDate;
	}
	public Calendar getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Calendar updateDate) {
		this.updateDate = updateDate;
	}
	
	public void setAddDefaults(String user){
		this.recordAddedBy = user;
		this.recordUpdatedBy = user;
		this.addDate = Calendar.getInstance();
		this.updateDate = Calendar.getInstance();
	}
	
	public void setUpdateDefaults(String user){
		this.recordUpdatedBy = user;
		this.updateDate = Calendar.getInstance();
	}
}
