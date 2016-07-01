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
		// TODO Auto-generated method stub
		return super.getId();
	}
	
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @Analyzer(definition = "vslibanalyzer")
	public String getUniformTitle() {
		return uniformTitle;
	}
	public void setUniformTitle(String uniformTitle) {
		this.uniformTitle = uniformTitle;
	}
	
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @Analyzer(definition = "vslibanalyzer")
	public String getPrimaryAuthor() {
		return primaryAuthor;
	}
	public void setPrimaryAuthor(String primaryAuthor) {
		this.primaryAuthor = primaryAuthor;
	}
	
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @Analyzer(definition = "vslibanalyzer")
	public String getSecondaryAuthors() {
		return secondaryAuthors;
	}
	public void setSecondaryAuthors(String secondaryAuthors) {
		this.secondaryAuthors = secondaryAuthors;
	}
	
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @Analyzer(definition = "vslibanalyzer")
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @Analyzer(definition = "vslibanalyzer")
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @Analyzer(definition = "vslibanalyzer")
	public String getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getCoverPrice() {
		return coverPrice;
	}
	public void setCoverPrice(String coverPrice) {
		this.coverPrice = coverPrice;
	}
	
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @Analyzer(definition = "vslibanalyzer")
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @Analyzer(definition = "vslibanalyzer")
	public String getSeriesStatement() {
		return seriesStatement;
	}
	public void setSeriesStatement(String seriesStatement) {
		this.seriesStatement = seriesStatement;
	}
	
    @Field
    @Analyzer(definition = "vslibanalyzer")
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	
    @Field
    @Analyzer(definition = "vslibanalyzer")
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
    @Field
    @Analyzer(definition = "vslibanalyzer")
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getBiblio() {
		return biblio;
	}
	public void setBiblio(String biblio) {
		this.biblio = biblio;
	}
	public String getBiblioType() {
		return biblioType;
	}
	public void setBiblioType(String biblioType) {
		this.biblioType = biblioType;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
}
