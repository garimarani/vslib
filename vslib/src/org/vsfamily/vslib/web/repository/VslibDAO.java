package org.vsfamily.vslib.web.repository;

import java.util.List;

import org.vsfamily.vslib.common.VslibBaseDAO;
import org.vsfamily.vslib.common.domain.Document;
import org.vsfamily.vslib.common.domain.Item;
import org.vsfamily.vslib.common.domain.ItemHold;
import org.vsfamily.vslib.common.domain.ItemReserve;
import org.vsfamily.vslib.common.domain.Patron;
import org.vsfamily.vslib.common.domain.VslibParams;
import org.vsfamily.vslib.forms.SimpleSearchForm;

public interface VslibDAO extends VslibBaseDAO {
	
	
	public boolean						addDocumentItem(Document doc, Item item);
	
	public VslibParams					getVslibParams();

	public List<Item>					listNewArrivals();
	public List<ItemHold>				listItemToReleaseHold();
	public List<ItemReserve>			listItemToReleaseReserve();
	public List<Document>				searchDocument(SimpleSearchForm ssf);
	public List<Document>				searchDocumentSimpleLucene(SimpleSearchForm ssf);
	public List<Patron>					searchPatron(SimpleSearchForm ssf);
}
