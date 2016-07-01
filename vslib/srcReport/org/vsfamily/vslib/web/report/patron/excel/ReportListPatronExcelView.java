package org.vsfamily.vslib.web.report.patron.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractExcelView;
import org.vsfamily.vslib.common.domain.Patron;
import org.vsfamily.vslib.common.tools.DateAndTime;
import org.vsfamily.vslib.web.repository.VslibDAO;

@Component
public class ReportListPatronExcelView extends AbstractExcelView {
	
	@Autowired
	VslibDAO vslibDAO;

	DateAndTime dt = new DateAndTime();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void buildExcelDocument(Map model, HSSFWorkbook workbook,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {


		HSSFSheet sheet = workbook
				.createSheet("List of Patrons.");

		HSSFRow header = sheet.createRow(0);

		header.createCell(0).setCellValue("S. No.");
		header.createCell(1).setCellValue("Number");
		header.createCell(2).setCellValue("Salutation");
		header.createCell(3).setCellValue("First Name");
		header.createCell(4).setCellValue("Middle Name");
		header.createCell(5).setCellValue("Last Name");
		header.createCell(6).setCellValue("Father / Husband Name");
		header.createCell(7).setCellValue("Date Of Birth");
		header.createCell(8).setCellValue("Gender");
		header.createCell(9).setCellValue("Education");
		header.createCell(10).setCellValue("Address");
		header.createCell(11).setCellValue("Alternate Address");
		header.createCell(12).setCellValue("Category");
		header.createCell(13).setCellValue("Group");
		header.createCell(14).setCellValue("Subscription Date");
		header.createCell(15).setCellValue("Subscription Expiry Date");
		header.createCell(16).setCellValue("Subscription Amount");
		header.createCell(17).setCellValue("Payment Details");
		header.createCell(18).setCellValue("Email");
		header.createCell(19).setCellValue("Alternate Email");
		header.createCell(20).setCellValue("Login Id");

		int startRecordNumber = 0;
		int rowNum = 1;
		int count = 0;
		
		List<Patron> listPatron = (List<Patron>) this.vslibDAO.listObjectSorted(Patron.class, "number", "asc", startRecordNumber, 1000);
		
		while (!listPatron.isEmpty()){
			for (Patron obj : listPatron) {
	
				count++;
				
				HSSFRow row = sheet.createRow(rowNum++);
	
				row.createCell(0).setCellValue(count);
				row.createCell(1).setCellValue(obj.getNumber());
				row.createCell(2).setCellValue(obj.getSalutation().getLabel());
				row.createCell(3).setCellValue(obj.getFirstName());
				
				if (obj.getMiddleName()!=null) row.createCell(4).setCellValue(obj.getMiddleName());
				else row.createCell(4).setCellValue("");
				
				row.createCell(5).setCellValue(obj.getLastName());
				
				if (obj.getFatherName()!=null) row.createCell(6).setCellValue(obj.getFatherName());
				else row.createCell(6).setCellValue("");
				
				if (obj.getDateOfBirth()!=null) row.createCell(7).setCellValue(obj.getDateOfBirth().getTime().toString());
				else  row.createCell(7).setCellValue("");
				
				row.createCell(8).setCellValue(obj.getGender().getLabel());
				
				if (obj.getEducation()!=null) row.createCell(9).setCellValue(obj.getEducation());
				else  row.createCell(9).setCellValue("");
				
				if (obj.getAddress()!=null) row.createCell(10).setCellValue(obj.getAddress().getStringAddress());
				else  row.createCell(10).setCellValue("");
				
				if (obj.getAlternateAddress()!=null) row.createCell(11).setCellValue(obj.getAlternateAddress().getStringAddress());
				else  row.createCell(11).setCellValue("");
				
				row.createCell(12).setCellValue(obj.getCategory().getLabel());
				row.createCell(13).setCellValue(obj.getGroup().getLabel());
				
				if (obj.getSubscriptionDate()!=null) row.createCell(14).setCellValue(obj.getSubscriptionDate().getTime().toString());
				else  row.createCell(14).setCellValue("");
				
				if (obj.getSubscriptionExpiryDate()!=null) row.createCell(15).setCellValue(obj.getSubscriptionExpiryDate().getTime().toString());
				else  row.createCell(15).setCellValue("");
				
				if (obj.getSubscriptionAmount()!=null) row.createCell(16).setCellValue(obj.getSubscriptionAmount().toString());
				else row.createCell(16).setCellValue("");
				
				if (obj.getPaymentDetails()!=null) row.createCell(17).setCellValue(obj.getPaymentDetails());
				else  row.createCell(17).setCellValue("");
				
				if (obj.getEmail()!=null) row.createCell(18).setCellValue(obj.getEmail());
				else  row.createCell(18).setCellValue("");
				
				if (obj.getAlternateEmail()!=null) row.createCell(19).setCellValue(obj.getAlternateEmail());
				else  row.createCell(19).setCellValue("");
				
				row.createCell(20).setCellValue(obj.getLoginId());
			}
			
			startRecordNumber = startRecordNumber + 1000;
			
			listPatron = (List<Patron>) this.vslibDAO.listObjectSorted(Patron.class, "number", "asc", startRecordNumber, 1000);
		}
	}
}
