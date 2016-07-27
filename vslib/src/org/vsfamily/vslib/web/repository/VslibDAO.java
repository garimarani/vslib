package org.vsfamily.vslib.web.repository;

import java.util.List;

import org.vsfamily.vslib.common.VslibBaseDAO;
import org.vsfamily.vslib.common.domain.Article;
import org.vsfamily.vslib.common.domain.ArticleCategory;
import org.vsfamily.vslib.common.domain.Document;
import org.vsfamily.vslib.common.domain.Item;
import org.vsfamily.vslib.common.domain.ItemHold;
import org.vsfamily.vslib.common.domain.ItemReserve;
import org.vsfamily.vslib.common.domain.Patron;
import org.vsfamily.vslib.common.domain.VslibParams;
import org.vsfamily.vslib.common.tools.VslibPaginate;
import org.vsfamily.vslib.forms.SimpleSearchForm;

public interface VslibDAO extends VslibBaseDAO {
	
	
	public boolean						addDocumentItem(Document doc, Item item);
	
	public void							doDeleteErrorMessages();
	
	public VslibParams					getVslibParams();

	public VslibPaginate				listNewArrivals(int firstResult, int maxResults);
	
	public List<Article>				listArticleHomePagePublished();
	public List<Article>				listArticlePublished(ArticleCategory category);
	public List<ItemHold>				listItemToReleaseHold();
	public List<ItemReserve>			listItemToReleaseReserve();
	public List<Document>				searchDocument(SimpleSearchForm ssf);
	public List<Document>				searchDocumentSimpleLucene(SimpleSearchForm ssf);
	public List<Patron>					searchPatron(SimpleSearchForm ssf);
}
