package org.vsfamily.vslib.web.setup.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.Principal;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.vsfamily.vslib.common.domain.Document;
import org.vsfamily.vslib.common.domain.ErrorMessages;
import org.vsfamily.vslib.common.domain.Item;
import org.vsfamily.vslib.common.domain.ItemType;
import org.vsfamily.vslib.common.domain.Language;
import org.vsfamily.vslib.common.domain.LibraryBranch;
import org.vsfamily.vslib.common.domain.Subject;
import org.vsfamily.vslib.common.domain.VslibParams;
import org.vsfamily.vslib.common.tools.Tools;
import org.vsfamily.vslib.web.service.VslibService;
import org.vsfamily.vslib.web.setup.SetupBaseController;
import org.vsfamily.vslib.web.setup.forms.ItemDataUploadForm;
import org.vsfamily.vslib.web.validators.DocumentImportValidator;
import org.vsfamily.vslib.web.validators.add.DocumentAddValidator;
import org.vsfamily.vslib.web.validators.add.ItemAddValidator;

@Controller
@RequestMapping("/setup/data/importDocument")
public class DocumentImportController extends SetupBaseController {
	
	@Autowired
	DocumentImportValidator documentImportValidator;
	
	@Autowired
	DocumentAddValidator documentAddValidator;
	
	@Autowired
	ItemAddValidator itemAddValidator;
	
	@Autowired
	VslibService vslibService;
	
	@ModelAttribute("listItemType")
	public List<ItemType> getListItemType(){
		return this.vslibService.listItemType();
	}
	
	@ModelAttribute("listLibraryBranch")
	public List<LibraryBranch> getListLibraryBranch(){
		return this.vslibService.listLibraryBranch();
	}
	
	@ModelAttribute("listSubject")
	public List<Subject> getListSubject(){
		return this.vslibService.listSubject();
	}
	
	@ModelAttribute("listLanguage")
	public List<Language> getListLanguagee(){
		return this.vslibService.listLanguage();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String itemDataImport(Model model){
		
		ItemDataUploadForm iduf = new ItemDataUploadForm();
		
		model.addAttribute("itemDataUploadForm", iduf);
		
		return "setup/data/import/document";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String itemDataImport(@ModelAttribute ItemDataUploadForm itemDataUploadForm, 
			BindingResult result, Model model, RedirectAttributes reat, Principal principal){
		
		this.documentImportValidator.validate(itemDataUploadForm, result);
		
		if (result.hasErrors()){
			return "setup/data/import/document";
		}
		
		VslibParams vslibParams = this.vslibService.getVslibParams();
		Tools tools = new Tools();
		
		String fileName = tools.getFilename();
		
		try {
			this.saveFile(vslibParams.getWorksFolder() + "/" + fileName, itemDataUploadForm.getFile());
		} catch (Exception e){
			reat.addFlashAttribute("message", e.getMessage());
			return "redirect:/setup/data/importDocument";
		}
		
		// Calculating maximum index value
		
		int maxIndex = 0;
		
		if (itemDataUploadForm.getUniformTitle()!=null)
			if (maxIndex < itemDataUploadForm.getUniformTitle().intValue()) maxIndex = itemDataUploadForm.getUniformTitle().intValue();
		if (itemDataUploadForm.getPrimaryAuthor()!=null)
			if (maxIndex < itemDataUploadForm.getPrimaryAuthor().intValue()) maxIndex = itemDataUploadForm.getPrimaryAuthor().intValue();
		if (itemDataUploadForm.getSecondaryAuthors()!=null)
			if (maxIndex < itemDataUploadForm.getSecondaryAuthors().intValue()) maxIndex = itemDataUploadForm.getSecondaryAuthors().intValue();
		if (itemDataUploadForm.getIsbn()!=null)
			if (maxIndex < itemDataUploadForm.getIsbn().intValue()) maxIndex = itemDataUploadForm.getIsbn().intValue();
		if (itemDataUploadForm.getEdition()!=null)
			if (maxIndex < itemDataUploadForm.getEdition().intValue()) maxIndex = itemDataUploadForm.getEdition().intValue();
		if (itemDataUploadForm.getPublicationYear()!=null)
			if (maxIndex < itemDataUploadForm.getPublicationYear().intValue()) maxIndex = itemDataUploadForm.getPublicationYear().intValue();
		if (itemDataUploadForm.getCoverPrice()!=null)
			if (maxIndex < itemDataUploadForm.getCoverPrice().intValue()) maxIndex = itemDataUploadForm.getCoverPrice().intValue();
		if (itemDataUploadForm.getPublisher()!=null)
			if (maxIndex < itemDataUploadForm.getPublisher().intValue()) maxIndex = itemDataUploadForm.getPublisher().intValue();
		if (itemDataUploadForm.getSeriesStatement()!=null)
			if (maxIndex < itemDataUploadForm.getSeriesStatement().intValue()) maxIndex = itemDataUploadForm.getSeriesStatement().intValue();
		if (itemDataUploadForm.getCopyright()!=null)
			if (maxIndex < itemDataUploadForm.getCopyright().intValue()) maxIndex = itemDataUploadForm.getCopyright().intValue();
		if (itemDataUploadForm.getSummary()!=null)
			if (maxIndex < itemDataUploadForm.getSummary().intValue()) maxIndex = itemDataUploadForm.getSummary().intValue();
		if (itemDataUploadForm.getKeywords()!=null)
			if (maxIndex < itemDataUploadForm.getKeywords().intValue()) maxIndex = itemDataUploadForm.getKeywords().intValue();
		if (itemDataUploadForm.getBarcodeNumber()!=null)
			if (maxIndex < itemDataUploadForm.getBarcodeNumber().intValue()) maxIndex = itemDataUploadForm.getBarcodeNumber().intValue();
		if (itemDataUploadForm.getClassNumber()!=null)
			if (maxIndex < itemDataUploadForm.getClassNumber().intValue()) maxIndex = itemDataUploadForm.getClassNumber().intValue();
		if (itemDataUploadForm.getItemType()!=null)
			if (maxIndex < itemDataUploadForm.getItemType().intValue()) maxIndex = itemDataUploadForm.getItemType().intValue();
		if (itemDataUploadForm.getLibraryBranch()!=null)
			if (maxIndex < itemDataUploadForm.getLibraryBranch().intValue()) maxIndex = itemDataUploadForm.getLibraryBranch().intValue();
		if (itemDataUploadForm.getSubject()!=null)
			if (maxIndex < itemDataUploadForm.getSubject().intValue()) maxIndex = itemDataUploadForm.getSubject().intValue();
		if (itemDataUploadForm.getLanguage()!=null)
			if (maxIndex < itemDataUploadForm.getLanguage().intValue()) maxIndex = itemDataUploadForm.getLanguage().intValue();
		if (itemDataUploadForm.getAlternateId()!=null)
			if (maxIndex < itemDataUploadForm.getAlternateId().intValue()) maxIndex = itemDataUploadForm.getAlternateId().intValue();
		
		String str = "";
		int count = 0;
		try {
			str = str + " <br/> " + "Opening file: " + vslibParams.getWorksFolder() + "/" + fileName;
			BufferedReader br = new BufferedReader(new FileReader(vslibParams.getWorksFolder() + "/" + fileName));
			str = str + " <br/> " + "File opened successfully.";
			String line;
			while ((line = br.readLine())!=null){
				count++;
				str = str + " <br/> " + "Read line : " + count;
				String fields[] = line.split(itemDataUploadForm.getTextQualifier() 
						+ itemDataUploadForm.getFieldDelimiter()
						+ itemDataUploadForm.getTextQualifier());
				str = str + " <br/> " + "Line is split.";
				if (fields.length < maxIndex){
					str = str + " <br/> Line No.:" + count + " - " + "Record has less no. of fields.";
					continue;
				}
				
				fields[0] = fields[0].substring(itemDataUploadForm.getTextQualifier().length(), fields[0].length());
				
				fields[fields.length - 1] =  fields[fields.length - 1].substring(0, fields[fields.length - 1].length() - itemDataUploadForm.getTextQualifier().length()); 
				
				Document doc = new Document();
				
				doc.setUniformTitle(fields[itemDataUploadForm.getUniformTitle().intValue() - 1]);
				
				doc.setPrimaryAuthor(fields[itemDataUploadForm.getPrimaryAuthor().intValue() - 1]);
				
				if (itemDataUploadForm.getSecondaryAuthors()>0){
					doc.setSecondaryAuthors(fields[itemDataUploadForm.getSeriesStatement().intValue() - 1]);
				}
				
				if (itemDataUploadForm.getIsbn()>0){
					doc.setIsbn(fields[itemDataUploadForm.getIsbn().intValue() - 1]);
				}
				
				if (itemDataUploadForm.getEdition()>0){
					doc.setEdition(fields[itemDataUploadForm.getEdition().intValue() - 1]);
				}
				
				if (itemDataUploadForm.getPublicationYear()>0){
					doc.setPublicationYear(fields[itemDataUploadForm.getPublicationYear().intValue() - 1]);
				}
				
				if (itemDataUploadForm.getCoverPrice()>0){
					doc.setCoverPrice(fields[itemDataUploadForm.getCoverPrice().intValue() - 1]);
				}
				
				if (itemDataUploadForm.getPublisher()>0){
					doc.setPublisher(fields[itemDataUploadForm.getPublisher().intValue() - 1]);
				}
				
				if (itemDataUploadForm.getSeriesStatement()>0){
					doc.setSeriesStatement(fields[itemDataUploadForm.getSeriesStatement().intValue() - 1]);
				}
				
				if (itemDataUploadForm.getCopyright()>0){
					doc.setCopyright(fields[itemDataUploadForm.getCopyright().intValue() - 1]);
				}
				
				if (itemDataUploadForm.getSummary()>0){
					doc.setSummary(fields[itemDataUploadForm.getSummary().intValue() - 1]);
				}
				
				if (itemDataUploadForm.getKeywords()>0){
					doc.setKeywords(fields[itemDataUploadForm.getKeywords().intValue() - 1]);
				}
				
				if (result.hasErrors()) result.getAllErrors().clear();
				
				this.documentAddValidator.validate(doc, result);
				
				if (result.hasErrors()){
					str = str + " <br/> Line No.:" + count + " - " + result.getAllErrors().toString();
				} else {
					
					Item item = new Item();
					
					item.setBarcodeNumber(fields[itemDataUploadForm.getBarcodeNumber().intValue()-1]);
					
					if (itemDataUploadForm.getClassNumber()>0){
						item.setClassNumber(fields[itemDataUploadForm.getClassNumber().intValue()-1]);
					}
					
					if (itemDataUploadForm.getAlternateId()>0){
						item.setAlternateId(fields[itemDataUploadForm.getAlternateId().intValue()-1]);
					}
					
					if (itemDataUploadForm.getItemType()>0){
						
						ItemType itemType = this.vslibService.getItemTypeByCode(fields[itemDataUploadForm.getItemType().intValue()-1]);
						
						if (itemType==null){
							item.setItemType(itemDataUploadForm.getDefaultItemType());
						} else {
							item.setItemType(itemType);
						}
					} else {
						
						item.setItemType(itemDataUploadForm.getDefaultItemType());
					}
					
					if (itemDataUploadForm.getLibraryBranch()>0){
						LibraryBranch libraryBranch = this.vslibService.getLibraryBranchByCode(fields[itemDataUploadForm.getLibraryBranch().intValue()-1]);
						
						if (libraryBranch==null){
							item.setLibraryBranch(itemDataUploadForm.getDefaultLibraryBranch());
						} else {
							item.setLibraryBranch(libraryBranch);
						}
					} else {
						item.setLibraryBranch(itemDataUploadForm.getDefaultLibraryBranch());
					}
					
					if (itemDataUploadForm.getSubject()>0){
						Subject subject = this.vslibService.getSubjectByCode(fields[itemDataUploadForm.getSubject().intValue()-1]);
						
						if (subject==null){
							item.setSubject(itemDataUploadForm.getDefaultSubject());
						} else {
							item.setSubject(subject);
						}
					} else {
						item.setSubject(itemDataUploadForm.getDefaultSubject());
					}
					
					if (itemDataUploadForm.getLanguage()>0){
						Language language = this.vslibService.getLanguageByCode(fields[itemDataUploadForm.getLanguage().intValue()-1]);
						
						if (language==null){
							item.setLanguage(itemDataUploadForm.getDefaultLanguage());
						} else {
							item.setLanguage(language);
						}
					} else {
						item.setLanguage(itemDataUploadForm.getDefaultLanguage());
					}
					
					item.setDocument(doc);
					
					this.itemAddValidator.validate(item, result);
					
					if (result.hasErrors()){
						str = str + " <br/> " + result.getAllErrors().toString(); 
					} else {
						doc.setAddDefaults(principal.getName());
						item.setAddDefaults(principal.getName());
						
						if (this.vslibService.addDocument(doc)) {
							str = str + " <br/> Line No.:" + count + " - Document added successfully.";
							if (this.vslibService.addItem(item)){
								str = str + " <br/> Line No.:" + count + " - " + "Item record added to database.";
							} else {
								str = str + " <br/> Line No.:" + count + " - " + "Item record not added.";
							}							
						}						
					}
				}
				
			}
			br.close();
			ErrorMessages errorMessages = new ErrorMessages();
			errorMessages.setMessageDate(Calendar.getInstance());
			errorMessages.setMessageText(str);
			this.vslibService.addErrorMessages(errorMessages);
		} catch (Exception e){
			str = str + "<br/>" + e.getMessage();
			ErrorMessages errorMessages = new ErrorMessages();
			errorMessages.setMessageDate(Calendar.getInstance());
			errorMessages.setMessageText(str);
			this.vslibService.addErrorMessages(errorMessages);
		}
		
		reat.addFlashAttribute("message", "Data Import process completed.... Please see the error messages.");
		return "redirect:/setup/errorMessages/listAll";
	}
	

	private void saveFile(String filename, MultipartFile fileReceived) throws RuntimeException, IOException {
	
		try {
	
			File file = new File(filename);
	 
			FileUtils.writeByteArrayToFile(file, fileReceived.getBytes());
			
		} catch (IOException e) {
			throw e;
		}
	}
}
