package org.vsfamily.vslib.common.domain;

import java.util.Set;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.vsfamily.vslib.common.VslibBaseClass;

@SuppressWarnings("serial")
public class Item extends VslibBaseClass {

	private Document			document;
	private String				barcodeNumber;
	private String				classNumber;
	private ItemType			itemType;
	private LibraryBranch		libraryBranch;
	private Subject				subject;
	private Language			language;
	private Set<ItemCheckOut>	checkOuts;
	private Set<ItemReserve>	reserves;
	private Set<ItemHold>		holds;
	
	@Override
	@DocumentId
	public Long getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	
	@Field
	public String getBarcodeNumber() {
		return barcodeNumber;
	}
	public void setBarcodeNumber(String barcodeNumber) {
		this.barcodeNumber = barcodeNumber;
	}
	
	@Field
	public String getClassNumber() {
		return classNumber;
	}
	
	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}
	public ItemType getItemType() {
		return itemType;
	}
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	public LibraryBranch getLibraryBranch() {
		return libraryBranch;
	}
	public void setLibraryBranch(LibraryBranch libraryBranch) {
		this.libraryBranch = libraryBranch;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public Set<ItemCheckOut> getCheckOuts() {
		return checkOuts;
	}
	public void setCheckOuts(Set<ItemCheckOut> checkOuts) {
		this.checkOuts = checkOuts;
	}
	public Set<ItemReserve> getReserves() {
		return reserves;
	}
	public void setReserves(Set<ItemReserve> reserves) {
		this.reserves = reserves;
	}
	public Set<ItemHold> getHolds() {
		return holds;
	}
	public void setHolds(Set<ItemHold> holds) {
		this.holds = holds;
	}
}
