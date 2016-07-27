package org.vsfamily.vslib.web.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vsfamily.vslib.common.domain.Adverts;
import org.vsfamily.vslib.common.domain.Article;
import org.vsfamily.vslib.common.domain.ArticleCategory;
import org.vsfamily.vslib.common.domain.Document;
import org.vsfamily.vslib.common.domain.ErrorMessages;
import org.vsfamily.vslib.common.domain.FineCategory;
import org.vsfamily.vslib.common.domain.Item;
import org.vsfamily.vslib.common.domain.ItemCheckIn;
import org.vsfamily.vslib.common.domain.ItemCheckOut;
import org.vsfamily.vslib.common.domain.ItemHold;
import org.vsfamily.vslib.common.domain.ItemReserve;
import org.vsfamily.vslib.common.domain.ItemType;
import org.vsfamily.vslib.common.domain.Language;
import org.vsfamily.vslib.common.domain.Library;
import org.vsfamily.vslib.common.domain.LibraryBranch;
import org.vsfamily.vslib.common.domain.LibraryType;
import org.vsfamily.vslib.common.domain.MenuItem;
import org.vsfamily.vslib.common.domain.Patron;
import org.vsfamily.vslib.common.domain.PatronCategory;
import org.vsfamily.vslib.common.domain.PatronGroup;
import org.vsfamily.vslib.common.domain.Subject;
import org.vsfamily.vslib.common.domain.Vendor;
import org.vsfamily.vslib.common.domain.VslibParams;
import org.vsfamily.vslib.common.tools.VslibPaginate;
import org.vsfamily.vslib.forms.CheckOutForm;
import org.vsfamily.vslib.forms.HoldForm;
import org.vsfamily.vslib.forms.ReserveForm;
import org.vsfamily.vslib.forms.SimpleSearchForm;
import org.vsfamily.vslib.web.repository.VslibDAO;

@Component(value="vslibService")
public class VslibServiceImpl implements VslibService {

	@Autowired
	VslibDAO vslibDAO;

	@Override
	public boolean addAdverts(Adverts adverts) {
		return this.vslibDAO.save(adverts);
	}

	@Override
	public boolean addArticle(Article obj) {
		return this.vslibDAO.save(obj);
	}

	@Override
	public boolean addArticleCategory(ArticleCategory obj) {
		return this.vslibDAO.save(obj);
	}

	@Override
	public boolean addDocument(Document obj) {
		return this.vslibDAO.save(obj);
	}

	@Override
	public boolean addDocumentItem(Document document, Item item) {
		return this.vslibDAO.addDocumentItem(document, item);
	}

	@Override
	public boolean addErrorMessages(ErrorMessages obj) {
		return this.vslibDAO.save(obj);
	}

	@Override
	public boolean addFineCategory(FineCategory obj) {
		return this.vslibDAO.save(obj);
	}

	@Override
	public boolean addItem(Item obj) {
		return this.vslibDAO.save(obj);
	}

	@Override
	public boolean addItemCheckIn(ItemCheckIn obj) {
		return this.vslibDAO.save(obj);
	}

	@Override
	public boolean addItemCheckOut(ItemCheckOut obj) {
		return this.vslibDAO.save(obj);
	}

	@Override
	public boolean addItemHold(ItemHold obj) {
		return this.vslibDAO.save(obj);
	}

	@Override
	public boolean addItemReserve(ItemReserve obj) {
		return this.vslibDAO.save(obj);
	}

	@Override
	public boolean addItemType(ItemType obj) {
		return this.vslibDAO.save(obj);
	}

	@Override
	public boolean addLanguage(Language obj) {
		return this.vslibDAO.save(obj);
	}

	@Override
	public boolean addLibrary(Library obj) {
		return this.vslibDAO.save(obj);
	}

	@Override
	public boolean addLibraryBranch(LibraryBranch obj) {
		return this.vslibDAO.save(obj);
	}

	@Override
	public boolean addLibraryType(LibraryType obj) {
		return this.vslibDAO.save(obj);
	}

	@Override
	public boolean addMenuItem(MenuItem obj) {
		return this.vslibDAO.save(obj);
	}

	@Override
	public boolean addPatron(Patron obj) {
		return this.vslibDAO.save(obj);
	}

	@Override
	public boolean addPatronCategory(PatronCategory obj) {
		return this.vslibDAO.save(obj);
	}

	@Override
	public boolean addPatronGroup(PatronGroup obj) {
		return this.vslibDAO.save(obj);
	}

	@Override
	public boolean addSubject(Subject obj) {
		return this.vslibDAO.save(obj);
	}

	@Override
	public boolean addVendor(Vendor obj) {
		return this.vslibDAO.save(obj);
	}

	@Override
	public boolean addVslibParams(VslibParams vslibParams) {
		return this.vslibDAO.saveOrUpdate(vslibParams);
	}

	@Override
	public boolean deleteAdverts(Adverts adverts) {
		return this.vslibDAO.delete(adverts);
	}

	@Override
	public boolean deleteArticle(Article obj) {
		return this.vslibDAO.delete(obj);
	}

	@Override
	public boolean deleteArticleCategory(ArticleCategory obj) {
		return this.vslibDAO.delete(obj);
	}

	@Override
	public boolean deleteDocument(Document obj) {
		return this.vslibDAO.delete(obj);
	}

	@Override
	public boolean deleteErrorMessages(ErrorMessages obj) {
		return this.vslibDAO.delete(obj);
	}

	@Override
	public boolean deleteFineCategory(FineCategory obj) {
		return this.vslibDAO.delete(obj);
	}

	@Override
	public boolean deleteItem(Item obj) {
		return this.vslibDAO.delete(obj);
	}

	@Override
	public boolean deleteItemCheckIn(ItemCheckIn obj) {
		return this.vslibDAO.delete(obj);
	}

	@Override
	public boolean deleteItemCheckOut(ItemCheckOut obj) {
		return this.vslibDAO.delete(obj);
	}

	@Override
	public boolean deleteItemHold(ItemHold obj) {
		return this.vslibDAO.delete(obj);
	}

	@Override
	public boolean deleteItemReserve(ItemReserve obj) {
		return this.vslibDAO.delete(obj);
	}

	@Override
	public boolean deleteItemType(ItemType obj) {
		return this.vslibDAO.delete(obj);
	}

	@Override
	public boolean deleteLanguage(Language obj) {
		return this.vslibDAO.delete(obj);
	}

	@Override
	public boolean deleteLibrary(Library obj) {
		return this.vslibDAO.delete(obj);
	}

	@Override
	public boolean deleteLibraryBranch(LibraryBranch obj) {
		return this.vslibDAO.delete(obj);
	}

	@Override
	public boolean deleteLibraryType(LibraryType obj) {
		return this.vslibDAO.delete(obj);
	}

	@Override
	public boolean deleteMenuItem(MenuItem obj) {
		return this.vslibDAO.delete(obj);
	}

	@Override
	public boolean deletePatron(Patron obj) {
		return this.vslibDAO.delete(obj);
	}

	@Override
	public boolean deletePatronCategory(PatronCategory obj) {
		return this.vslibDAO.delete(obj);
	}

	@Override
	public boolean deletePatronGroup(PatronGroup obj) {
		return this.vslibDAO.delete(obj);
	}

	@Override
	public boolean deleteSubject(Subject obj) {
		return this.vslibDAO.delete(obj);
	}

	@Override
	public boolean deleteVendor(Vendor obj) {
		return this.vslibDAO.delete(obj);
	}

	@Override
	public Adverts getAdverts(Long id) {
		return (Adverts) this.vslibDAO.getObjectById(Adverts.class, id);
	}

	@Override
	public Adverts getAdvertsByName(String name) {
		return (Adverts) this.vslibDAO.getObjectByArg(Adverts.class, "name", name);
	}

	@Override
	public Article getArticle(Long id) {
		return (Article) this.vslibDAO.getObjectById(Article.class, id);
	}

	@Override
	public ArticleCategory getArticleCategory(Long id) {
		return (ArticleCategory) this.vslibDAO.getObjectById(ArticleCategory.class, id);
	}

	@Override
	public ArticleCategory getArticleCategoryByName(String name) {
		return (ArticleCategory) this.vslibDAO.getObjectByArg(ArticleCategory.class, "name", name);
	}

	@Override
	public Document getDocument(Long id) {
		return (Document) this.vslibDAO.getObjectById(Document.class, id);
	}

	@Override
	public ErrorMessages getErrorMessages(Long id) {
		return (ErrorMessages) this.vslibDAO.getObjectById(ErrorMessages.class, id);
	}

	@Override
	public FineCategory getFineCategory(Long id) {
		return (FineCategory) this.vslibDAO.getObjectById(FineCategory.class, id);
	}

	@Override
	public FineCategory getFineCategoryByCode(String code) {
		return (FineCategory) this.vslibDAO.getObjectByArg(FineCategory.class, "code", code);
	}

	@Override
	public FineCategory getFineCategoryByName(String name) {
		return (FineCategory) this.vslibDAO.getObjectByArg(FineCategory.class, "name", name);
	}

	@Override
	public Item getItem(Long id) {
		return (Item) this.vslibDAO.getObjectById(Item.class, id);
	}

	@Override
	public Item getItemByNumber(String number) {
		return (Item) this.vslibDAO.getObjectByArg(Item.class, "barcodeNumber", number);
	}

	@Override
	public ItemCheckIn getItemCheckIn(Long id) {
		return (ItemCheckIn) this.vslibDAO.getObjectById(ItemCheckIn.class, id);
	}

	@Override
	public ItemCheckOut getItemCheckOut(Long id) {
		return (ItemCheckOut) this.vslibDAO.getObjectById(ItemCheckOut.class, id);
	}

	@Override
	public ItemCheckOut getItemCheckOutByItem(Item item) {
		return (ItemCheckOut) this.vslibDAO.getObjectByArg(ItemCheckOut.class, "item", item);
	}

	@Override
	public ItemHold getItemHold(Long id) {
		return (ItemHold) this.vslibDAO.getObjectById(ItemHold.class, id);
	}

	@Override
	public ItemHold getItemHoldByItem(Item item) {
		return (ItemHold) this.vslibDAO.getObjectByArg(ItemHold.class, "item", item);
	}

	@Override
	public ItemReserve getItemReserve(Long id) {
		return (ItemReserve) this.vslibDAO.getObjectById(ItemReserve.class, id);
	}

	@Override
	public ItemReserve getItemReserve(Item item, Patron patron) {
		return (ItemReserve) this.vslibDAO.getObjectByArgTwo(ItemReserve.class, "item", item, "patron", patron); 
	}

	@Override
	public ItemType getItemType(Long id) {
		return (ItemType) this.vslibDAO.getObjectById(ItemType.class, id);
	}

	@Override
	public ItemType getItemTypeByCode(String code) {
		return (ItemType) this.vslibDAO.getObjectByArg(ItemType.class, "code", code);
	}

	@Override
	public ItemType getItemTypeByName(String name) {
		return (ItemType) this.vslibDAO.getObjectByArg(ItemType.class, "name", name);
	}

	@Override
	public Language getLanguage(Long id) {
		return (Language) this.vslibDAO.getObjectById(Language.class, id);
	}

	@Override
	public Language getLanguageByCode(String code) {
		return (Language) this.vslibDAO.getObjectByArg(Language.class, "code", code);
	}

	@Override
	public Language getLanguageByName(String name) {
		return (Language) this.vslibDAO.getObjectByArg(Language.class, "name", name);
	}

	@Override
	public Library getLibrary(Long id) {
		return (Library) this.vslibDAO.getObjectById(Library.class, id);
	}

	@Override
	public Library getLibraryByCode(String code) {
		return (Library) this.vslibDAO.getObjectByArg(Library.class, "code", code);
	}

	@Override
	public LibraryBranch getLibraryBranch(Long id) {
		return (LibraryBranch) this.vslibDAO.getObjectById(LibraryBranch.class, id);
	}

	@Override
	public LibraryBranch getLibraryBranchByCode(String code) {
		return (LibraryBranch) this.vslibDAO.getObjectByArg(LibraryBranch.class, "code", code);
	}

	@Override
	public LibraryBranch getLibraryBranchByName(String name) {
		return (LibraryBranch) this.vslibDAO.getObjectByArg(LibraryBranch.class, "name", name);
	}

	@Override
	public LibraryType getLibraryType(Long id) {
		return (LibraryType) this.vslibDAO.getObjectById(LibraryType.class, id);
	}

	@Override
	public LibraryType getLibraryTypeByCode(String code) {
		return (LibraryType) this.vslibDAO.getObjectByArg(LibraryType.class, "code", code);
	}

	@Override
	public LibraryType getLibraryTypeByName(String name) {
		return (LibraryType) this.vslibDAO.getObjectByArg(LibraryType.class, "name", name);
	}

	@Override
	public MenuItem getMenuItem(Long id) {
		return (MenuItem) this.vslibDAO.getObjectById(MenuItem.class, id);
	}

	@Override
	public MenuItem getMenuItemByName(String name) {
		return (MenuItem) this.vslibDAO.getObjectByArg(MenuItem.class, "name", name);
	}

	@Override
	public Patron getPatron(Long id) {
		return (Patron) this.vslibDAO.getObjectById(Patron.class, id);
	}

	@Override
	public Patron getPatronByLoginId(String loginId) {
		return (Patron) this.vslibDAO.getObjectByArg(Patron.class, "loginId", loginId);
	}

	@Override
	public Patron getPatronByNumber(String number) {
		return (Patron) this.vslibDAO.getObjectByArg(Patron.class, "number", number);
	}

	@Override
	public PatronCategory getPatronCategory(Long id) {
		return (PatronCategory) this.vslibDAO.getObjectById(PatronCategory.class, id);
	}

	@Override
	public PatronCategory getPatronCategoryByCode(String code) {
		return (PatronCategory) this.vslibDAO.getObjectByArg(PatronCategory.class, "code", code);
	}

	@Override
	public PatronCategory getPatronCategoryByName(String name) {
		return (PatronCategory) this.vslibDAO.getObjectByArg(PatronCategory.class, "name", name);
	}

	@Override
	public PatronGroup getPatronGroup(Long id) {
		return (PatronGroup) this.vslibDAO.getObjectById(PatronGroup.class, id);
	}

	@Override
	public PatronGroup getPatronGroupByCode(String code) {
		return (PatronGroup) this.vslibDAO.getObjectByArg(PatronGroup.class, "code", code);
	}

	@Override
	public PatronGroup getPatronGroupByName(String name) {
		return (PatronGroup) this.vslibDAO.getObjectByArg(PatronGroup.class, "name", name);
	}

	@Override
	public Subject getSubject(Long id) {
		return (Subject) this.vslibDAO.getObjectById(Subject.class, id);
	}

	@Override
	public Subject getSubjectByCode(String code) {
		return (Subject) this.vslibDAO.getObjectByArg(Subject.class, "code", code);
	}

	@Override
	public Subject getSubjectByName(String name) {
		return (Subject) this.vslibDAO.getObjectByArg(Subject.class, "name", name);
	}

	@Override
	public Vendor getVendor(Long id) {
		return (Vendor) this.vslibDAO.getObjectById(Vendor.class, id);
	}

	@Override
	public Vendor getVendorByCode(String code) {
		return (Vendor) this.vslibDAO.getObjectByArg(Vendor.class, "code", code);
	}

	@Override
	public VslibParams getVslibParams() {
		return this.vslibDAO.getVslibParams();
	}

	@Override
	public VslibPaginate listNewArrivals(int firstResult, int maxResults) {
		return this.vslibDAO.listNewArrivals(firstResult, maxResults);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Adverts> listAdverts() {
		return (List<Adverts>) this.vslibDAO.listObjectSorted(Adverts.class, "name", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Adverts> listAdverts(String location) {
		return (List<Adverts>) this.vslibDAO.listObjectArgSorted(Adverts.class, "location", location, "name", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> listArticle() {
		return (List<Article>) this.vslibDAO.listObjectSorted(Article.class, "addDate", "desc");
	}

	@Override
	public List<Article> listArticleHomePagePublished() {
		return this.vslibDAO.listArticleHomePagePublished();
	}

	@Override
	public List<Article> listArticlePublished(ArticleCategory category) {
		return this.vslibDAO.listArticlePublished(category);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleCategory> listArticleCategory() {
		return (List<ArticleCategory>) this.vslibDAO.listObjectSorted(ArticleCategory.class, "name", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Document> listDocumentSortByPrimaryAuthor() {
		return (List<Document>) this.vslibDAO.listObjectSortedTwo(Document.class, "primaryAuthor", "asc", "uniformTitle", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Document> listDocumentSortByUniformTitle() {
		return (List<Document>) this.vslibDAO.listObjectSortedTwo(Document.class, "uniformTitle", "asc", "primaryAuthor", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ErrorMessages> listErrorMessages() {
		return (List<ErrorMessages>) this.vslibDAO.listObjectSorted(ErrorMessages.class, "messageDate", "desc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FineCategory> listFineCategory() {
		return (List<FineCategory>) this.vslibDAO.listObjectSorted(FineCategory.class, "code", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> listItem() {
		return (List<Item>) this.vslibDAO.listObjectSorted(Item.class, "barcodeNumber", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> listItemByDocument(Document document) {
		return (List<Item>) this.vslibDAO.listObjectArgSorted(Item.class, "document", document, "barcodeNumber", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemCheckIn> listItemCheckIn(Patron patron) {
		return (List<ItemCheckIn>) this.vslibDAO.listObjectArgSorted(ItemCheckIn.class, "patron", patron, "checkOutDate", "desc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemCheckOut> listItemCheckOut() {
		return (List<ItemCheckOut>) this.vslibDAO.listObjectSorted(ItemCheckOut.class, "checkOutDate", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemCheckOut> listItemCheckOutByPatron(Patron patron) {
		return (List<ItemCheckOut>) this.vslibDAO.listObjectArgSorted(ItemCheckOut.class, "patron", patron, "checkOutDate", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemHold> listItemHold() {
		return (List<ItemHold>) this.vslibDAO.listObjectSorted(ItemCheckOut.class, "holdDate", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemHold> listItemHoldByPatron(Patron patron) {
		return (List<ItemHold>) this.vslibDAO.listObjectArgSorted(ItemHold.class, "patron", patron, "holdDate", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemReserve> listItemReserve() {
		return (List<ItemReserve>) this.vslibDAO.listObjectSorted(ItemReserve.class, "reserveDate", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemReserve> listItemReserveByPatron(Patron patron) {
		return (List<ItemReserve>) this.vslibDAO.listObjectArgSorted(ItemReserve.class, "patron", patron, "reserveDate", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemReserve> listItemReserveByItem(Item item) {
		return (List<ItemReserve>) this.vslibDAO.listObjectArgSorted(ItemReserve.class, "item", item, "reserveDate", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemType> listItemType() {
		return (List<ItemType>) this.vslibDAO.listObjectSorted(ItemType.class, "name", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Language> listLanguage() {
		return (List<Language>) this.vslibDAO.listObjectSorted(Language.class, "name", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Library> listLibrary() {
		return (List<Library>) this.vslibDAO.listObjectSorted(Library.class, "name", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LibraryBranch> listLibraryBranch() {
		return (List<LibraryBranch>) this.vslibDAO.listObjectSorted(LibraryBranch.class, "name", "asc");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<LibraryBranch> listLibraryBranchByLibrary(Library library) {
		return (List<LibraryBranch>) this.vslibDAO.listObjectArgSorted(LibraryBranch.class, "library", library, "name", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LibraryType> listLibraryType() {
		return (List<LibraryType>) this.vslibDAO.listObjectSorted(LibraryType.class, "code", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuItem> listMenuItem() {
		return (List<MenuItem>) this.vslibDAO.listObjectSorted(MenuItem.class, "name", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuItem> listMenuItemPublished() {
		return (List<MenuItem>) this.vslibDAO.listObjectArgSorted(MenuItem.class, "published", true, "name", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patron> listPatronSortByName() {
		return (List<Patron>) this.vslibDAO.listObjectSorted(Patron.class, "name", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patron> listPatronSortByNumber() {
		return (List<Patron>) this.vslibDAO.listObjectSorted(Patron.class, "number", "asc");
	}

	@Override
	public List<Patron> listPatronByCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patron> listPatronByGroup() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PatronCategory> listPatronCategory() {
		return (List<PatronCategory>) this.vslibDAO.listObjectSorted(PatronCategory.class, "name", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PatronGroup> listPatronGroup() {
		return (List<PatronGroup>) this.vslibDAO.listObjectSorted(PatronGroup.class, "name", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> listSubject() {
		return (List<Subject>) this.vslibDAO.listObjectSorted(Subject.class, "name", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vendor> listVendor() {
		return (List<Vendor>) this.vslibDAO.listObjectSorted(Vendor.class, "code", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vendor> listVendorSortByName() {
		return (List<Vendor>) this.vslibDAO.listObjectSorted(Vendor.class, "name", "asc");
	}

	@Override
	public List<Document> searchDocument(SimpleSearchForm ssf) {
		return this.vslibDAO.searchDocument(ssf);
	}

	@Override
	public List<Document> searchDocumentSimpleLucene(SimpleSearchForm ssf) {
		return this.vslibDAO.searchDocumentSimpleLucene(ssf);
	}

	@Override
	public List<Patron> searchPatron(SimpleSearchForm ssf) {
		return this.vslibDAO.searchPatron(ssf);
	}

	@Override
	public boolean updateAdverts(Adverts obj) {
		return this.vslibDAO.update(obj);
	}

	@Override
	public boolean updateArticle(Article obj) {
		return this.vslibDAO.update(obj);
	}

	@Override
	public boolean updateArticleCategory(ArticleCategory obj) {
		return this.vslibDAO.update(obj);
	}

	@Override
	public boolean updateDocument(Document obj) {
		return this.vslibDAO.update(obj);
	}

	@Override
	public boolean updateErrorMessages(ErrorMessages obj) {
		return this.vslibDAO.update(obj);
	}

	@Override
	public boolean updateFineCategory(FineCategory obj) {
		return this.vslibDAO.update(obj);
	}

	@Override
	public boolean updateItem(Item obj) {
		return this.vslibDAO.update(obj);
	}

	@Override
	public boolean updateItemCheckIn(ItemCheckIn obj) {
		return this.vslibDAO.update(obj);
	}

	@Override
	public boolean updateItemCheckOut(ItemCheckOut obj) {
		return this.vslibDAO.update(obj);
	}

	@Override
	public boolean updateItemHold(ItemHold obj) {
		return this.vslibDAO.update(obj);
	}

	@Override
	public boolean updateItemReserve(ItemReserve obj) {
		return this.vslibDAO.update(obj);
	}

	@Override
	public boolean updateItemType(ItemType obj) {
		return this.vslibDAO.update(obj);
	}

	@Override
	public boolean updateLanguage(Language obj) {
		return this.vslibDAO.update(obj);
	}

	@Override
	public boolean updateLibrary(Library obj) {
		return this.vslibDAO.update(obj);
	}

	@Override
	public boolean updateLibraryBranch(LibraryBranch obj) {
		return this.vslibDAO.update(obj);
	}

	@Override
	public boolean updateLibraryType(LibraryType obj) {
		return this.vslibDAO.update(obj);
	}

	@Override
	public boolean updateMenuItem(MenuItem obj) {
		return this.vslibDAO.update(obj);
	}

	@Override
	public boolean updatePatron(Patron obj) {
		return this.vslibDAO.update(obj);
	}

	@Override
	public boolean updatePatronCategory(PatronCategory obj) {
		return this.vslibDAO.update(obj);
	}

	@Override
	public boolean updatePatronGroup(PatronGroup obj) {
		return this.vslibDAO.update(obj);
	}

	@Override
	public boolean updateSubject(Subject obj) {
		return this.vslibDAO.update(obj);
	}

	@Override
	public boolean updateVendor(Vendor obj) {
		return this.vslibDAO.update(obj);
	}

	@Override
	public CheckOutForm doCheckOut(CheckOutForm checkOutForm) {
		
		if (checkOutForm.getPatron().isSubscriptionExpired()){
			checkOutForm.setMessage("Patron subscription is expired. Cannot check-out item.");
			checkOutForm.setResult(false);
			return checkOutForm;
		}
		
		int itemsIssued = checkOutForm.getPatron().getCheckOuts().size();
		
		if (itemsIssued >= checkOutForm.getPatron().getCategory().getMaximumCheckOuts().intValue()){
			checkOutForm.setMessage("Maximum items already checked out.");
			checkOutForm.setResult(false);
			return checkOutForm;
		}
		
		Item item = this.getItemByNumber(checkOutForm.getBarcodeNumber());
		
		if (item == null){
			checkOutForm.setMessage("Not a valid Item Number.");
			checkOutForm.setResult(false);
			return checkOutForm;
		}
		
		ItemCheckOut itemCheckOut = this.getItemCheckOutByItem(item);
		
		if (itemCheckOut != null){
			checkOutForm.setMessage("Items is already checked out.");
			checkOutForm.setResult(false);
			return checkOutForm;
		}
		
		ItemHold itemHold = this.getItemHoldByItem(item);
		
		if (itemHold!=null){
			if (!itemHold.getPatron().getId().equals(checkOutForm.getPatron().getId())){
				checkOutForm.setResult(false);
				checkOutForm.setMessage("Item is on hold by other Patron. Cannot check-out");
				return checkOutForm;
			}
		}
		
		List<ItemReserve> listItemReserve = this.listItemReserveByItem(item);
		
		ItemReserve itemReserve = null;
		
		if (!listItemReserve.isEmpty()){
			itemReserve = listItemReserve.get(0);
			
			if (!itemReserve.getPatron().getId().equals(checkOutForm.getPatron().getId())){
				checkOutForm.setResult(false);
				checkOutForm.setMessage("Item is reserved by other Patron. Cannot check-out");
				return checkOutForm;
			}
		}
		
		int period = 1;
		
		if (item.getItemType().getMaximumCheckOutPeriod().intValue() < checkOutForm.getPatron().getCategory().getMaximumCheckOutPeriod().intValue()){
			period = item.getItemType().getMaximumCheckOutPeriod().intValue();
		} else {
			period = checkOutForm.getPatron().getCategory().getMaximumCheckOutPeriod().intValue();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, period);
		
		ItemCheckOut ico = new ItemCheckOut();
		ico.setPatron(checkOutForm.getPatron());
		ico.setItem(item);
		ico.setCheckOutDate(Calendar.getInstance());
		ico.setDueDate(cal);
		ico.setAddDefaults(checkOutForm.getUser());
		
		if (this.addItemCheckOut(ico)){
			checkOutForm.setResult(true);
			checkOutForm.setMessage("Item checked out successfully.");
			checkOutForm.setItemCheckOut(ico);
			
			if (itemHold!=null) this.deleteItemHold(itemHold);
			if (itemReserve!=null) this.deleteItemReserve(itemReserve);
		} else {
			checkOutForm.setResult(false);
			checkOutForm.setMessage("Item could not be checked out.");
		}
		return checkOutForm;
	}

	@Override
	public void doDeleteErrorMessages() {
		this.vslibDAO.doDeleteErrorMessages();
	}

	@Override
	public HoldForm doHold(HoldForm holdForm) {
		

		if (holdForm.getPatron().isSubscriptionExpired()){
			holdForm.setMessage("Patron subscription is expired. Cannot hold item.");
			holdForm.setResult(false);
			return holdForm;
		}
		
		Item item = this.getItemByNumber(holdForm.getBarcodeNumber());
		
		if (item == null){
			holdForm.setResult(false);
			holdForm.setMessage("Not a valid Item number.");
			return holdForm;
		}
		
		ItemHold ih = this.getItemHoldByItem(item);
		
		if (ih != null){
			if (!ih.getPatron().getId().equals(holdForm.getPatron().getId())){
				holdForm.setResult(false);
				holdForm.setMessage("Item is already on hold.");
				return holdForm;
			}
		}
		
		List<ItemReserve> listItemReserve = this.listItemReserveByItem(item);
		
		if (!listItemReserve.isEmpty()){
			holdForm.setResult(false);
			holdForm.setMessage("Item is reserved by other patron. Cannot put on hold.");
			return holdForm;
		}
		
		ItemCheckOut itemCheckOut = this.getItemCheckOutByItem(item);
		
		if (itemCheckOut!=null){
			holdForm.setResult(false);
			holdForm.setMessage("Item is already checked out. Cannot put on hold.");
			return holdForm;
		}
		
		List<ItemHold> listItemHold = this.listItemHoldByPatron(holdForm.getPatron());
		
		if (listItemHold.size() >= holdForm.getPatron().getCategory().getMaximumHolds().intValue()){
			holdForm.setResult(false);
			holdForm.setMessage("Maximum holds reached for the patron.");
			return holdForm;
		}
		
		int period = 0;
		
		if (item.getItemType().getMaximumHoldPeriod().intValue() < holdForm.getPatron().getCategory().getMaximumHoldPeriod().intValue()){
			period = item.getItemType().getMaximumHoldPeriod().intValue();
		} else {
			period = holdForm.getPatron().getCategory().getMaximumHoldPeriod().intValue();
		}
		
		ItemHold itemHold = new ItemHold();
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, period);
		
		itemHold.setItem(item);
		itemHold.setPatron(holdForm.getPatron());
		itemHold.setHoldDate(Calendar.getInstance());
		itemHold.setHoldReleaseDate(cal);
		itemHold.setAddDefaults(holdForm.getUser());
		
		if (this.addItemHold(itemHold)){
			holdForm.setResult(true);
			holdForm.setMessage("Item is placed on hold.");
			holdForm.setItemHold(itemHold);
		} else {
			holdForm.setResult(false);
			holdForm.setMessage("Item is not placed on hold.");
		}
		return holdForm;
	}

	@Override
	public ReserveForm doReserve(ReserveForm reserveForm) {
		

		if (reserveForm.getPatron().isSubscriptionExpired()){
			reserveForm.setMessage("Patron subscription is expired. Cannot reserve item.");
			reserveForm.setResult(false);
			return reserveForm;
		}
		
		Item item = this.getItemByNumber(reserveForm.getBarcodeNumber());
		
		if (item == null){
			reserveForm.setResult(false);
			reserveForm.setMessage("No such Item record.");
			return reserveForm;
		}
		
		ItemCheckOut itemCheckOut = this.getItemCheckOutByItem(item);
		
		if (itemCheckOut != null){
			reserveForm.setResult(false);
			reserveForm.setMessage("Item is available on shelf.");
			return reserveForm;
		}
		
		List<ItemReserve> listItemReserve = this.listItemReserveByPatron(reserveForm.getPatron());
		
		if (listItemReserve.size() >= reserveForm.getPatron().getCategory().getMaximumReserves()){
			reserveForm.setResult(false);
			reserveForm.setMessage("Patron has maximum reservations already.");
			return reserveForm;
		}
		
		ItemReserve itemReserve = new ItemReserve();
		
		itemReserve.setItem(item);
		itemReserve.setPatron(reserveForm.getPatron());
		
		int period = 1;
		
		if (item.getItemType().getMaximumReservePeriod().intValue() < reserveForm.getPatron().getCategory().getMaximumReservePeriod().intValue()){
			period = item.getItemType().getMaximumReservePeriod().intValue(); 
		} else {
			period = reserveForm.getPatron().getCategory().getMaximumReservePeriod().intValue();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, period);
		
		itemReserve.setReserveDate(Calendar.getInstance());
		itemReserve.setReserveReleaseDate(cal);
		itemReserve.setAddDefaults(reserveForm.getUser());
		
		if (this.addItemReserve(itemReserve)){
			reserveForm.setResult(true);
			reserveForm.setMessage("Item reservation done successfully.");
			reserveForm.setItemReserve(itemReserve);
		} else {
			reserveForm.setResult(false);
			reserveForm.setMessage("Item reservation failed.");
		}
		return reserveForm;
	}

	@Override
	public boolean doReleaseHold() {
		boolean result = true;
		
		List<ItemHold> listItemHold = this.vslibDAO.listItemToReleaseHold();
		
		if (!listItemHold.isEmpty()){
			for(ItemHold itemHold : listItemHold){
				this.vslibDAO.delete(itemHold);
			}
		}
		
		return result;
	}

	@Override
	public boolean doReleaseReserve() {
		boolean result = true;
		
		List<ItemReserve> listItemReserve = this.vslibDAO.listItemToReleaseReserve();
		
		if (!listItemReserve.isEmpty()){
			for(ItemReserve itemReserve : listItemReserve){
				this.vslibDAO.delete(itemReserve);
			}
		}
		
		return result;
	}
}
