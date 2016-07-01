package org.vsfamily.vslib.web.service;

import java.util.List;

import org.vsfamily.vslib.common.domain.Document;
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
import org.vsfamily.vslib.common.domain.Patron;
import org.vsfamily.vslib.common.domain.PatronCategory;
import org.vsfamily.vslib.common.domain.PatronGroup;
import org.vsfamily.vslib.common.domain.Subject;
import org.vsfamily.vslib.common.domain.Vendor;
import org.vsfamily.vslib.common.domain.VslibParams;
import org.vsfamily.vslib.forms.CheckOutForm;
import org.vsfamily.vslib.forms.HoldForm;
import org.vsfamily.vslib.forms.ReserveForm;
import org.vsfamily.vslib.forms.SimpleSearchForm;

public interface VslibService {

	public boolean							addDocument(Document obj);
	public boolean							addFineCategory(FineCategory obj);
	public boolean							addItem(Item obj);
	public boolean							addItemCheckIn(ItemCheckIn obj);
	public boolean							addItemCheckOut(ItemCheckOut obj);
	public boolean							addItemHold(ItemHold obj);
	public boolean							addItemReserve(ItemReserve obj);
	public boolean							addItemType(ItemType obj);
	public boolean							addLanguage(Language obj);
	public boolean							addLibrary(Library obj);
	public boolean							addLibraryBranch(LibraryBranch obj);
	public boolean							addLibraryType(LibraryType obj);
	public boolean							addPatron(Patron obj);
	public boolean							addPatronCategory(PatronCategory obj);
	public boolean							addPatronGroup(PatronGroup obj);
	public boolean							addSubject(Subject obj);
	public boolean							addVendor(Vendor obj);
	public boolean							addVslibParams(VslibParams vslibParams);
	
	public boolean							deleteDocument(Document obj);
	public boolean							deleteFineCategory(FineCategory obj);
	public boolean							deleteItem(Item obj);
	public boolean							deleteItemCheckIn(ItemCheckIn obj);
	public boolean							deleteItemCheckOut(ItemCheckOut obj);
	public boolean							deleteItemHold(ItemHold obj);
	public boolean							deleteItemReserve(ItemReserve obj);
	public boolean							deleteItemType(ItemType obj);
	public boolean							deleteLanguage(Language obj);
	public boolean							deleteLibrary(Library obj);
	public boolean							deleteLibraryBranch(LibraryBranch obj);
	public boolean							deleteLibraryType(LibraryType obj);
	public boolean							deletePatron(Patron obj);
	public boolean							deletePatronCategory(PatronCategory obj);
	public boolean							deletePatronGroup(PatronGroup obj);
	public boolean							deleteSubject(Subject obj);
	public boolean							deleteVendor(Vendor obj);
	
	public Document							getDocument(Long id);
	public FineCategory						getFineCategory(Long id);
	public FineCategory						getFineCategoryByCode(String code);
	public FineCategory						getFineCategoryByName(String name);
	public Item								getItem(Long id);
	public Item								getItemByNumber(String number);
	public ItemCheckIn						getItemCheckIn(Long id);
	public ItemCheckOut						getItemCheckOut(Long id);
	public ItemCheckOut						getItemCheckOutByItem(Item item);
	public ItemHold							getItemHold(Long id);
	public ItemHold							getItemHoldByItem(Item item);
	public ItemReserve						getItemReserve(Long id);
	public ItemReserve						getItemReserve(Item item, Patron patron);
	public ItemType							getItemType(Long id);
	public ItemType							getItemTypeByCode(String code);
	public ItemType							getItemTypeByName(String name);
	public Language							getLanguage(Long id);
	public Language							getLanguageByCode(String code);
	public Language							getLanguageByName(String name);
	public Library							getLibrary(Long id);
	public Library							getLibraryByCode(String code);
	public LibraryBranch					getLibraryBranch(Long id);
	public LibraryBranch					getLibraryBranchByCode(String code);
	public LibraryBranch					getLibraryBranchByName(String name);
	public LibraryType						getLibraryType(Long id);
	public LibraryType						getLibraryTypeByCode(String code);
	public LibraryType						getLibraryTypeByName(String name);
	public Patron							getPatron(Long id);
	public Patron							getPatronByNumber(String number);
	public Patron							getPatronByLoginId(String loginId);
	public PatronCategory					getPatronCategory(Long id);
	public PatronCategory					getPatronCategoryByCode(String code);
	public PatronCategory					getPatronCategoryByName(String name);
	public PatronGroup						getPatronGroup(Long id);
	public PatronGroup						getPatronGroupByCode(String code);
	public PatronGroup						getPatronGroupByName(String name);
	public Subject							getSubject(Long id);
	public Subject							getSubjectByCode(String code);
	public Subject							getSubjectByName(String name);
	public Vendor							getVendor(Long id);
	public Vendor							getVendorByCode(String code);
	public VslibParams						getVslibParams();
	
	public List<Item>						listNewArrivals();
	public List<Document>					listDocumentSortByPrimaryAuthor();
	public List<Document>					listDocumentSortByUniformTitle();
	public List<FineCategory>				listFineCategory();
	public List<Item>						listItem();
	public List<Item>						listItemByDocument(Document document);
	public List<ItemCheckIn>				listItemCheckIn(Patron patron);
	public List<ItemCheckOut>				listItemCheckOut();
	public List<ItemCheckOut>				listItemCheckOutByPatron(Patron patron);
	public List<ItemHold>					listItemHold();
	public List<ItemHold>					listItemHoldByPatron(Patron patron);
	public List<ItemReserve>				listItemReserve();
	public List<ItemReserve>				listItemReserveByPatron(Patron patron);
	public List<ItemReserve>				listItemReserveByItem(Item item);
	public List<ItemType>					listItemType();
	public List<Language>					listLanguage();
	public List<Library>					listLibrary();
	public List<LibraryBranch>				listLibraryBranch();
	public List<LibraryBranch>				listLibraryBranchByLibrary(Library library);
	public List<LibraryType>				listLibraryType();
	public List<Patron>						listPatronSortByName();
	public List<Patron>						listPatronSortByNumber();
	public List<Patron>						listPatronByCategory();
	public List<Patron>						listPatronByGroup();
	public List<PatronCategory>				listPatronCategory();
	public List<PatronGroup>				listPatronGroup();
	public List<Subject>					listSubject();
	public List<Vendor>						listVendor();
	public List<Vendor>						listVendorSortByName();
	
	public List<Document>					searchDocument(SimpleSearchForm ssf);
	public List<Document>					searchDocumentSimpleLucene(SimpleSearchForm ssf);
	public List<Patron>						searchPatron(SimpleSearchForm ssf);
	
	public boolean							updateDocument(Document obj);
	public boolean							updateFineCategory(FineCategory obj);
	public boolean							updateItem(Item obj);
	public boolean							updateItemCheckIn(ItemCheckIn obj);
	public boolean							updateItemCheckOut(ItemCheckOut obj);
	public boolean							updateItemHold(ItemHold obj);
	public boolean							updateItemReserve(ItemReserve obj);
	public boolean							updateItemType(ItemType obj);
	public boolean							updateLanguage(Language obj);
	public boolean							updateLibrary(Library obj);
	public boolean							updateLibraryBranch(LibraryBranch obj);
	public boolean							updateLibraryType(LibraryType obj);
	public boolean							updatePatron(Patron obj);
	public boolean							updatePatronCategory(PatronCategory obj);
	public boolean							updatePatronGroup(PatronGroup obj);
	public boolean							updateSubject(Subject obj);
	public boolean							updateVendor(Vendor obj);
	
	public CheckOutForm						doCheckOut(CheckOutForm checkOutForm);
	public HoldForm							doHold(HoldForm holdForm);
	public ReserveForm						doReserve(ReserveForm reserveForm);
	public boolean							doReleaseHold();
	public boolean							doReleaseReserve();
}
