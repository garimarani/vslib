package org.vsfamily.vslib.common.domain;

import java.util.Set;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.vsfamily.vslib.common.VslibBaseClass;

/**
 * Item class.
 */
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
	
	/**
	 * Gets the document.
	 * @return the document
	 */
	public Document getDocument() {
		return document;
	}
	
	/**
	 * Sets the document.
	 * @param document - the document
	 */
	public void setDocument(Document document) {
		this.document = document;
	}
	
	/**
	 * Gets the bar code number.
	 * @return the bar code number
	 */
	@Field
	public String getBarcodeNumber() {
		return barcodeNumber;
	}
	
	/**
	 * Sets the bar code number
	 * @param barcodeNumber - the bar code number
	 */
	public void setBarcodeNumber(String barcodeNumber) {
		this.barcodeNumber = barcodeNumber;
	}
	
	/**
	 * Gets the classification number.
	 * @return the class number
	 */
	@Field
	public String getClassNumber() {
		return classNumber;
	}
	
	/**
	 * Sets the classification number.
	 * @param classNumber - the class number
	 */
	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}
	
	/**
	 * Gets the item type.
	 * @return the item type
	 */
	public ItemType getItemType() {
		return itemType;
	}
	
	/**
	 * Sets the item type.
	 * @param itemType - the item type
	 */
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	
	/** 
	 * Gets the branch of library.
	 * @return the branch of library
	 */
	public LibraryBranch getLibraryBranch() {
		return libraryBranch;
	}
	
	/**
	 * Sets the branch of library.
	 * @param libraryBranch - the branch of library
	 */
	public void setLibraryBranch(LibraryBranch libraryBranch) {
		this.libraryBranch = libraryBranch;
	}
	
	/**
	 * Gets the subject.
	 * @return the subject
	 */
	public Subject getSubject() {
		return subject;
	}
	
	/**
	 * Sets the subject.
	 * @param subject - the subject
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	/**
	 * Gets the language.
	 * @return the language
	 */
	public Language getLanguage() {
		return language;
	}
	
	/**
	 * Sets the language.
	 * @param language - the language
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}
	
	/**
	 * Gets the list of check-outs
	 * @return the list of check-outs
	 */
	public Set<ItemCheckOut> getCheckOuts() {
		return checkOuts;
	}
	
	/**
	 * Sets the list of check-outs.
	 * @param checkOuts - the list of check-outs
	 */
	public void setCheckOuts(Set<ItemCheckOut> checkOuts) {
		this.checkOuts = checkOuts;
	}
	
	/** 
	 * Gets the list of reservations.
	 * @return the list of reservations
	 */
	public Set<ItemReserve> getReserves() {
		return reserves;
	}
	
	/**
	 * Sets the list of reservations.
	 * @param reserves - the list of reservations
	 */
	public void setReserves(Set<ItemReserve> reserves) {
		this.reserves = reserves;
	}
	
	/**
	 * Gets the list of holds.
	 * @return the list of holds
	 */
	public Set<ItemHold> getHolds() {
		return holds;
	}
	
	/**
	 * Sets the list of holds.
	 * @param holds - the list of holds.
	 */
	public void setHolds(Set<ItemHold> holds) {
		this.holds = holds;
	}
}
