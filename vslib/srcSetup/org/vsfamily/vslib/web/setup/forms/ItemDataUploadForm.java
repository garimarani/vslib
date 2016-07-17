package org.vsfamily.vslib.web.setup.forms;

import org.springframework.web.multipart.MultipartFile;
import org.vsfamily.vslib.common.domain.ItemType;
import org.vsfamily.vslib.common.domain.Language;
import org.vsfamily.vslib.common.domain.LibraryBranch;
import org.vsfamily.vslib.common.domain.Subject;

public class ItemDataUploadForm {

	private MultipartFile		file;
	
	private Long				uniformTitle = new Long(0);
	private Long				primaryAuthor = new Long(0);
	private Long 				secondaryAuthors = new Long(0);
	private Long				isbn = new Long(0);
	private Long				edition = new Long(0);
	private Long				publicationYear = new Long(0);
	private Long				coverPrice = new Long(0);
	private Long				publisher = new Long(0);
	private Long				seriesStatement = new Long(0);
	private Long				copyright = new Long(0);
	private Long				summary = new Long(0);
	private Long				keywords = new Long(0);
	private Long				barcodeNumber = new Long(0);
	private Long				classNumber = new Long(0);
	private Long				itemType = new Long(0);
	private Long				libraryBranch = new Long(0);
	private Long				subject = new Long(0);
	private Long				language = new Long(0);
	private Long				alternateId = new Long(0);
	
	private ItemType			defaultItemType;
	private LibraryBranch		defaultLibraryBranch;
	private Subject				defaultSubject;
	private Language			defaultLanguage;
	
	private String				fieldDelimiter;
	private String				textQualifier;
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public Long getUniformTitle() {
		return uniformTitle;
	}
	public void setUniformTitle(Long uniformTitle) {
		this.uniformTitle = uniformTitle;
	}
	public Long getPrimaryAuthor() {
		return primaryAuthor;
	}
	public void setPrimaryAuthor(Long primaryAuthor) {
		this.primaryAuthor = primaryAuthor;
	}
	public Long getSecondaryAuthors() {
		return secondaryAuthors;
	}
	public void setSecondaryAuthors(Long secondaryAuthors) {
		this.secondaryAuthors = secondaryAuthors;
	}
	public Long getIsbn() {
		return isbn;
	}
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}
	public Long getEdition() {
		return edition;
	}
	public void setEdition(Long edition) {
		this.edition = edition;
	}
	public Long getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(Long publicationYear) {
		this.publicationYear = publicationYear;
	}
	public Long getCoverPrice() {
		return coverPrice;
	}
	public void setCoverPrice(Long coverPrice) {
		this.coverPrice = coverPrice;
	}
	public Long getPublisher() {
		return publisher;
	}
	public void setPublisher(Long publisher) {
		this.publisher = publisher;
	}
	public Long getSeriesStatement() {
		return seriesStatement;
	}
	public void setSeriesStatement(Long seriesStatement) {
		this.seriesStatement = seriesStatement;
	}
	public Long getCopyright() {
		return copyright;
	}
	public void setCopyright(Long copyright) {
		this.copyright = copyright;
	}
	public Long getSummary() {
		return summary;
	}
	public void setSummary(Long summary) {
		this.summary = summary;
	}
	public Long getKeywords() {
		return keywords;
	}
	public void setKeywords(Long keywords) {
		this.keywords = keywords;
	}
	public Long getBarcodeNumber() {
		return barcodeNumber;
	}
	public void setBarcodeNumber(Long barcodeNumber) {
		this.barcodeNumber = barcodeNumber;
	}
	public Long getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(Long classNumber) {
		this.classNumber = classNumber;
	}
	public Long getItemType() {
		return itemType;
	}
	public void setItemType(Long itemType) {
		this.itemType = itemType;
	}
	public Long getLibraryBranch() {
		return libraryBranch;
	}
	public void setLibraryBranch(Long libraryBranch) {
		this.libraryBranch = libraryBranch;
	}
	public Long getSubject() {
		return subject;
	}
	public void setSubject(Long subject) {
		this.subject = subject;
	}
	public Long getLanguage() {
		return language;
	}
	public void setLanguage(Long language) {
		this.language = language;
	}
	public Long getAlternateId() {
		return alternateId;
	}
	public void setAlternateId(Long alternateId) {
		this.alternateId = alternateId;
	}
	public ItemType getDefaultItemType() {
		return defaultItemType;
	}
	public void setDefaultItemType(ItemType defaultItemType) {
		this.defaultItemType = defaultItemType;
	}
	public LibraryBranch getDefaultLibraryBranch() {
		return defaultLibraryBranch;
	}
	public void setDefaultLibraryBranch(LibraryBranch defaultLibraryBranch) {
		this.defaultLibraryBranch = defaultLibraryBranch;
	}
	public Subject getDefaultSubject() {
		return defaultSubject;
	}
	public void setDefaultSubject(Subject defaultSubject) {
		this.defaultSubject = defaultSubject;
	}
	public Language getDefaultLanguage() {
		return defaultLanguage;
	}
	public void setDefaultLanguage(Language defaultLanguage) {
		this.defaultLanguage = defaultLanguage;
	}
	public String getFieldDelimiter() {
		return fieldDelimiter;
	}
	public void setFieldDelimiter(String fieldDelimiter) {
		this.fieldDelimiter = fieldDelimiter;
	}
	public String getTextQualifier() {
		return textQualifier;
	}
	public void setTextQualifier(String textQualifier) {
		this.textQualifier = textQualifier;
	}
	
}
