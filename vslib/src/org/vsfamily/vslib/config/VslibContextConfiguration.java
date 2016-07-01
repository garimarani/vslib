package org.vsfamily.vslib.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.vsfamily.vslib.web.common.CalendarFormatter;
import org.vsfamily.vslib.web.common.propertyEditors.AddressToString;
import org.vsfamily.vslib.web.common.propertyEditors.GenderToString;
import org.vsfamily.vslib.web.common.propertyEditors.SalutationToString;
import org.vsfamily.vslib.web.common.propertyEditors.StringToAddress;
import org.vsfamily.vslib.web.common.propertyEditors.StringToGender;
import org.vsfamily.vslib.web.common.propertyEditors.StringToSalutation;
import org.vsfamily.vslib.web.manager.propertEditors.ManagerToString;
import org.vsfamily.vslib.web.manager.propertEditors.StringToManager;
import org.vsfamily.vslib.web.manager.propertEditors.StringToVslibGroup;
import org.vsfamily.vslib.web.manager.propertEditors.StringToVslibRole;
import org.vsfamily.vslib.web.manager.propertEditors.VslibGroupToString;
import org.vsfamily.vslib.web.manager.propertEditors.VslibRoleToString;
import org.vsfamily.vslib.web.propertyEditors.objectToString.DocumentToString;
import org.vsfamily.vslib.web.propertyEditors.objectToString.FineCategoryToString;
import org.vsfamily.vslib.web.propertyEditors.objectToString.ItemCheckInToString;
import org.vsfamily.vslib.web.propertyEditors.objectToString.ItemCheckOutToString;
import org.vsfamily.vslib.web.propertyEditors.objectToString.ItemHoldToString;
import org.vsfamily.vslib.web.propertyEditors.objectToString.ItemReserveToString;
import org.vsfamily.vslib.web.propertyEditors.objectToString.ItemToString;
import org.vsfamily.vslib.web.propertyEditors.objectToString.ItemTypeToString;
import org.vsfamily.vslib.web.propertyEditors.objectToString.LanguageToString;
import org.vsfamily.vslib.web.propertyEditors.objectToString.LibraryBranchToString;
import org.vsfamily.vslib.web.propertyEditors.objectToString.LibraryToString;
import org.vsfamily.vslib.web.propertyEditors.objectToString.LibraryTypeToString;
import org.vsfamily.vslib.web.propertyEditors.objectToString.PatronCategoryToString;
import org.vsfamily.vslib.web.propertyEditors.objectToString.PatronGroupToString;
import org.vsfamily.vslib.web.propertyEditors.objectToString.PatronToString;
import org.vsfamily.vslib.web.propertyEditors.objectToString.SubjectToString;
import org.vsfamily.vslib.web.propertyEditors.objectToString.VendorToString;
import org.vsfamily.vslib.web.propertyEditors.stringToObject.StringToDocument;
import org.vsfamily.vslib.web.propertyEditors.stringToObject.StringToFineCategory;
import org.vsfamily.vslib.web.propertyEditors.stringToObject.StringToItem;
import org.vsfamily.vslib.web.propertyEditors.stringToObject.StringToItemCheckIn;
import org.vsfamily.vslib.web.propertyEditors.stringToObject.StringToItemCheckOut;
import org.vsfamily.vslib.web.propertyEditors.stringToObject.StringToItemHold;
import org.vsfamily.vslib.web.propertyEditors.stringToObject.StringToItemReserve;
import org.vsfamily.vslib.web.propertyEditors.stringToObject.StringToItemType;
import org.vsfamily.vslib.web.propertyEditors.stringToObject.StringToLanguage;
import org.vsfamily.vslib.web.propertyEditors.stringToObject.StringToLibrary;
import org.vsfamily.vslib.web.propertyEditors.stringToObject.StringToLibraryBranch;
import org.vsfamily.vslib.web.propertyEditors.stringToObject.StringToLibraryType;
import org.vsfamily.vslib.web.propertyEditors.stringToObject.StringToPatron;
import org.vsfamily.vslib.web.propertyEditors.stringToObject.StringToPatronCategory;
import org.vsfamily.vslib.web.propertyEditors.stringToObject.StringToPatronGroup;
import org.vsfamily.vslib.web.propertyEditors.stringToObject.StringToSubject;
import org.vsfamily.vslib.web.propertyEditors.stringToObject.StringToVendor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "org.vsfamily.vslib.web" })
public class VslibContextConfiguration  extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**/*").addResourceLocations(
				"/images/");
		registry.addResourceHandler("/css/**/*").addResourceLocations("/css/");
		registry.addResourceHandler("/js/**/*").addResourceLocations("/js/");
		registry.addResourceHandler("/templates/**/*").addResourceLocations(
				"/templates/");
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setSuffix(".jsp");
		vr.setPrefix("/WEB-INF/views/");
		vr.setOrder(2);
		return vr;
	}

	// -- Start Locale Support (I18N) --//

	/**
	 * The {@link LocaleChangeInterceptor} allows for the locale to be changed.
	 * It provides a <code>paramName</code> property which sets the request
	 * parameter to check for changing the language, the default is
	 * <code>locale</code>.
	 * 
	 * @return the {@link LocaleChangeInterceptor}
	 */
	@Bean
	public HandlerInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}

	/**
	 * The {@link LocaleResolver} implementation to use. Specifies where to
	 * store the current selected locale.
	 * 
	 * @return the {@link LocaleResolver}
	 */
	@Bean
	public LocaleResolver localeResolver() {
		return new CookieLocaleResolver();
	}

	/**
	 * To resolve message codes to actual messages we need a
	 * {@link MessageSource} implementation. The default implementations use a
	 * {@link java.util.ResourceBundle} to parse the property files with the
	 * messages in it.
	 * 
	 * @return the {@link MessageSource}
	 */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		String[] basenames = { "classpath:messages",
				"classpath:administration-messages",
				"classpath:accounts-messages",
				"classpath:indents-messages"};
		messageSource.setBasenames(basenames);
		messageSource.setUseCodeAsDefaultMessage(true);
		return messageSource;
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {

		super.addFormatters(registry);
		registry.addFormatter(new CalendarFormatter());
		
		registry.addConverter(this.getAddressToString());
		registry.addConverter(this.getGenderToString());
		registry.addConverter(this.getSalutationToString());
		
		registry.addConverter(this.getStringToAddress());
		registry.addConverter(this.getStringToGender());
		registry.addConverter(this.getStringToSalutation());
		
		registry.addConverter(this.getDocumentToString());
		registry.addConverter(this.getFineCategoryToString());
		registry.addConverter(this.getItemCheckInToString());
		registry.addConverter(this.getItemCheckOutToString());
		registry.addConverter(this.getItemHoldToString());
		registry.addConverter(this.getItemReserveToString());
		registry.addConverter(this.getItemToString());
		registry.addConverter(this.getItemTypeToString());
		registry.addConverter(this.getLanguageToString());
		registry.addConverter(this.getLibraryBranchToString());
		registry.addConverter(this.getLibraryToString());
		registry.addConverter(this.getLibraryTypeToString());
		registry.addConverter(this.getPatronCategoryToString());
		registry.addConverter(this.getPatronGroupToString());
		registry.addConverter(this.getPatronToString());
		registry.addConverter(this.getSubjectToString());
		registry.addConverter(this.getVendorToString());
		
		registry.addConverter(this.getStringToDocument());
		registry.addConverter(this.getStringToFineCategory());
		registry.addConverter(this.getStringToItem());
		registry.addConverter(this.getStringToItemCheckIn());
		registry.addConverter(this.getStringToItemCheckOut());
		registry.addConverter(this.getStringToItemHold());
		registry.addConverter(this.getStringToItemReserve());
		registry.addConverter(this.getStringToItemType());
		registry.addConverter(this.getStringToLanguage());
		registry.addConverter(this.getStringToLibrary());
		registry.addConverter(this.getStringToLibraryBranch());
		registry.addConverter(this.getStringToLibraryType());
		registry.addConverter(this.getStringToPatron());
		registry.addConverter(this.getStringToPatronCategory());
		registry.addConverter(this.getStringToPatronGroup());
		registry.addConverter(this.getStringToSubject());
		registry.addConverter(this.getStringToVendor());
		
		registry.addConverter(this.getManagerToString());
		registry.addConverter(this.getStringToManager());
		registry.addConverter(this.getStringToVslibGroup());
		registry.addConverter(this.getStringToVslibRole());
		registry.addConverter(this.getVslibGroupToString());
		registry.addConverter(this.getVslibRoleToString());
	}
	
	@Bean
	public AddressToString getAddressToString(){
		return new AddressToString();
	}
	
	@Bean
	public GenderToString getGenderToString(){
		return new GenderToString();
	}
	
	@Bean
	public SalutationToString getSalutationToString(){
		return new SalutationToString();
	}
	
	@Bean
	public ManagerToString getManagerToString(){
		return new ManagerToString();
	}
	
	@Bean
	public VslibGroupToString getVslibGroupToString(){
		return new VslibGroupToString();
	}
	
	@Bean
	public VslibRoleToString getVslibRoleToString(){
		return new VslibRoleToString();
	}
	
	@Bean
	public DocumentToString getDocumentToString(){
		return new DocumentToString();
	}
	
	@Bean
	public FineCategoryToString getFineCategoryToString(){
		return new FineCategoryToString();
	}
	
	@Bean
	public ItemCheckInToString getItemCheckInToString(){
		return new ItemCheckInToString();
	}
	
	@Bean
	public ItemCheckOutToString getItemCheckOutToString(){
		return new ItemCheckOutToString();
	}
	
	@Bean
	public ItemHoldToString getItemHoldToString(){
		return new ItemHoldToString();
	}
	
	@Bean
	public ItemReserveToString getItemReserveToString(){
		return new ItemReserveToString();
	}
	
	@Bean
	public ItemToString getItemToString(){
		return new ItemToString();
	}
	
	@Bean
	public ItemTypeToString getItemTypeToString(){
		return new ItemTypeToString();
	}
	
	@Bean
	public LanguageToString getLanguageToString(){
		return new LanguageToString();
	}
	
	@Bean
	public LibraryBranchToString getLibraryBranchToString(){
		return new LibraryBranchToString();
	}
	
	@Bean
	public LibraryToString getLibraryToString(){
		return new LibraryToString();
	}
	
	@Bean
	public LibraryTypeToString getLibraryTypeToString(){
		return new LibraryTypeToString();
	}
	
	@Bean
	public PatronToString getPatronToString(){
		return new PatronToString();
	}
	
	@Bean
	public PatronCategoryToString getPatronCategoryToString(){
		return new PatronCategoryToString();
	}
	
	@Bean
	public PatronGroupToString getPatronGroupToString(){
		return new PatronGroupToString();
	}
	
	@Bean
	public SubjectToString getSubjectToString(){
		return new SubjectToString();
	}
	
	@Bean
	public VendorToString getVendorToString(){
		return new VendorToString();
	}
	
	@Bean
	public StringToAddress getStringToAddress(){
		return new StringToAddress();
	}
	
	@Bean
	public StringToGender getStringToGender(){
		return new StringToGender();
	}
	
	@Bean
	public StringToSalutation getStringToSalutation(){
		return new StringToSalutation();
	}
	
	@Bean
	public StringToManager getStringToManager(){
		return new StringToManager();
	}
	
	@Bean
	public StringToVslibGroup getStringToVslibGroup(){
		return new StringToVslibGroup();
	}
	
	@Bean
	public StringToVslibRole getStringToVslibRole(){
		return new StringToVslibRole();
	}
	
	@Bean
	public StringToDocument getStringToDocument(){
		return new StringToDocument();
	}
	
	@Bean
	public StringToFineCategory getStringToFineCategory(){
		return new StringToFineCategory();
	}
	
	@Bean
	public StringToItem getStringToItem(){
		return new StringToItem();
	}
	
	@Bean
	public StringToItemCheckIn getStringToItemCheckIn(){
		return new StringToItemCheckIn();
	}
	
	@Bean
	public StringToItemCheckOut getStringToItemCheckOut(){
		return new StringToItemCheckOut();
	}
	
	@Bean
	public StringToItemHold getStringToItemHold(){
		return new StringToItemHold();
	}
	
	@Bean
	public StringToItemReserve getStringToItemReserve(){
		return new StringToItemReserve();
	}
	
	@Bean
	public StringToItemType getStringToItemType(){
		return new StringToItemType();
	}
	
	@Bean
	public StringToLanguage getStringToLanguage(){
		return new StringToLanguage();
	}
	
	@Bean
	public StringToLibrary getStringToLibrary(){
		return new StringToLibrary();
	}
	
	@Bean
	public StringToLibraryBranch getStringToLibraryBranch(){
		return new StringToLibraryBranch();
	}
	
	@Bean
	public StringToLibraryType getStringToLibraryType(){
		return new StringToLibraryType();
	}
	
	@Bean
	public StringToPatron getStringToPatron(){
		return new StringToPatron();
	}
	
	@Bean
	public StringToPatronCategory getStringToPatronCategory(){
		return new StringToPatronCategory();
	}
	
	@Bean
	public StringToPatronGroup getStringToPatronGroup(){
		return new StringToPatronGroup();
	}
	
	@Bean
	public StringToSubject getStringToSubject(){
		return new StringToSubject();
	}
	
	@Bean
	public StringToVendor getStringToVendor(){
		return new StringToVendor();
	}
}
