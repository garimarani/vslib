package org.vsfamily.vslib.common.domain;

import java.util.Set;
import java.util.TreeSet;

import org.apache.solr.analysis.LowerCaseFilterFactory;
import org.apache.solr.analysis.SnowballPorterFilterFactory;
import org.apache.solr.analysis.StandardFilterFactory;
import org.apache.solr.analysis.StandardTokenizerFactory;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.AnalyzerDef;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.TokenFilterDef;
import org.hibernate.search.annotations.TokenizerDef;
import org.vsfamily.vslib.common.VslibBaseClass;

/**
 * Document class. Hibernate Lucene is also implements on this class.
 */
@SuppressWarnings("serial")
@Indexed
@AnalyzerDef(name = "vslibanalyzer",
	tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
	filters = {
			@TokenFilterDef (factory = StandardFilterFactory.class),
			@TokenFilterDef (factory = LowerCaseFilterFactory.class),
			@TokenFilterDef (factory = SnowballPorterFilterFactory.class)
	}
)
public class Document extends VslibBaseClass {

	private String 				uniformTitle;
	private String				primaryAuthor;
	private String				secondaryAuthors;
	private String				isbn;
	private String				edition;
	private String 				publicationYear;
	private String 				coverPrice;
	private String				publisher;
	private String				seriesStatement;
	private String				copyright;
	private String				summary;
	private String				keywords;
	private String				biblio;
	private String				biblioType;
	
	@IndexedEmbedded
	private Set<Item>			items = new TreeSet<Item>();
	
	@Override
	@DocumentId
	public Long getId() {
		return super.getId();
	}
	
	/**
	 * Gets the uniform title.
	 * @return the uniform title
	 */
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @Analyzer(definition = "vslibanalyzer")
	public String getUniformTitle() {
		return uniformTitle;
	}
    
    /**
     * Sets the uniform title.
     * @param uniformTitle - the uniform title
     */
	public void setUniformTitle(String uniformTitle) {
		this.uniformTitle = uniformTitle;
	}
	
	/**
	 * Gets the primary author.
	 * @return - the primary author
	 */
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @Analyzer(definition = "vslibanalyzer")
	public String getPrimaryAuthor() {
		return primaryAuthor;
	}
    
    /**
     * Sets the primary author.
     * @param primaryAuthor - the primary author
     */
	public void setPrimaryAuthor(String primaryAuthor) {
		this.primaryAuthor = primaryAuthor;
	}
	
	/**
	 * Gets the secondary authors.  
	 * @return the secondary authors
	 */
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @Analyzer(definition = "vslibanalyzer")
	public String getSecondaryAuthors() {
		return secondaryAuthors;
	}
    
    /**
     * Sets the secondary authors. Multiple authors may be entered here separated by semi-colon.
     * @param secondaryAuthors - the secondary authors
     */
	public void setSecondaryAuthors(String secondaryAuthors) {
		this.secondaryAuthors = secondaryAuthors;
	}
	
	/**
	 * Gets the International Standard Book Number / International Standard Serial Number.
	 * @return the isbn / issn
	 */
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @Analyzer(definition = "vslibanalyzer")
	public String getIsbn() {
		return isbn;
	}
    
    /**
     * Sets the International Standard Book Number / International Standard Serial Number.
     * @param isbn - the isbn / issn
     */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	/**
	 * Gets the edition.
	 * @return the edition
	 */
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @Analyzer(definition = "vslibanalyzer")
	public String getEdition() {
		return edition;
	}
    
    /**
     * Sets the edition.
     * @param edition - the edition
     */
	public void setEdition(String edition) {
		this.edition = edition;
	}
	
	/**
	 * Gets the publication year.
	 * @return the publication year
	 */
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @Analyzer(definition = "vslibanalyzer")
	public String getPublicationYear() {
		return publicationYear;
	}
    
    /**
     * Sets the publication year.
     * @param publicationYear - the publication year
     */
	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}

	/**
	 * Gets the cover price.
	 * @return - the cover price
	 */
	public String getCoverPrice() {
		return coverPrice;
	}
	
	/**
	 * Sets the cover price.
	 * @param coverPrice - the cover price
	 */
	public void setCoverPrice(String coverPrice) {
		this.coverPrice = coverPrice;
	}
	
	/**
	 * Gets the publisher.
	 * @return the publisher
	 */
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @Analyzer(definition = "vslibanalyzer")
	public String getPublisher() {
		return publisher;
	}
    
    /**
     * Sets the publisher.
     * @param publisher - the publisher
     */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	/**
	 * Gets the series statement.
	 * @return the series statement
	 */
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @Analyzer(definition = "vslibanalyzer")
	public String getSeriesStatement() {
		return seriesStatement;
	}
    
    /**
     * Sets the series statement.
     * @param seriesStatement - the series statement
     */
	public void setSeriesStatement(String seriesStatement) {
		this.seriesStatement = seriesStatement;
	}
	
	/**
	 * Gets the copyright information.
	 * @return the copyright information
	 */
    @Field
    @Analyzer(definition = "vslibanalyzer")
	public String getCopyright() {
		return copyright;
	}
    
    /**
     * Sets the copyright information.
     * @param copyright - the copyright information
     */
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	
	/**
	 * Gets the summary.
	 * @return the summary
	 */
    @Field
    @Analyzer(definition = "vslibanalyzer")
	public String getSummary() {
		return summary;
	}
    
    /**
     * Sets the summary.
     * @param summary - the summary
     */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	/**
	 * Gets the keywords.
	 * @return the keywords
	 */
    @Field
    @Analyzer(definition = "vslibanalyzer")
	public String getKeywords() {
		return keywords;
	}
    
    /**
     * Sets the keywords. Keywords are to be separated by semi-colon.
     * @param keywords - the keywords
     */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	/**
	 * Gets the bibliography information.
	 * @return the bibliography
	 */
	public String getBiblio() {
		return biblio;
	}
	
	/**
	 * Sets the bibliography information
	 * @param biblio - the bibliography
	 */
	public void setBiblio(String biblio) {
		this.biblio = biblio;
	}
	
	/**
	 * Gets the type of bibliography.
	 * @return the type
	 */
	public String getBiblioType() {
		return biblioType;
	}
	
	/**
	 * Sets the type of bibliography.
	 * @param biblioType - the type
	 */
	public void setBiblioType(String biblioType) {
		this.biblioType = biblioType;
	}
	
	/**
	 * Gets the list of items associated with this document.
	 * @return the list of items
	 */
	public Set<Item> getItems() {
		return items;
	}
	
	/**
	 * Sets the list of items associated with this document.
	 * @param items - the list of items
	 */
	public void setItems(Set<Item> items) {
		this.items = items;
	}
}
