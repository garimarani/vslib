package org.vsfamily.vslib.web.report.document.excel;

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
import org.vsfamily.vslib.common.domain.Item;
import org.vsfamily.vslib.common.tools.DateAndTime;
import org.vsfamily.vslib.web.repository.VslibDAO;

@Component(value="reportItemExcelView")
public class ReportItemExcelView extends AbstractExcelView {
	
	@Autowired
	VslibDAO vslibDAO;

	DateAndTime dt = new DateAndTime();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void buildExcelDocument(Map model, HSSFWorkbook workbook,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {


		HSSFSheet sheet = workbook
				.createSheet("List of Items.");

		HSSFRow header = sheet.createRow(0);

		header.createCell(0).setCellValue("S. No.");
		header.createCell(1).setCellValue("Barcode Number");
		header.createCell(2).setCellValue("Class Number");
		header.createCell(3).setCellValue("Item Type");
		header.createCell(4).setCellValue("Library Branch");
		header.createCell(5).setCellValue("Subject");
		header.createCell(6).setCellValue("Language");
		header.createCell(7).setCellValue("Document Id");
		header.createCell(8).setCellValue("Uniform Title");
		header.createCell(9).setCellValue("Primary Author");
		header.createCell(10).setCellValue("Secondary Authors");
		header.createCell(11).setCellValue("ISBN / ISSN");
		header.createCell(12).setCellValue("Edition");
		header.createCell(13).setCellValue("Publication Year");
		header.createCell(14).setCellValue("Cover Price");
		header.createCell(15).setCellValue("Publisher");
		header.createCell(16).setCellValue("Copyright");

		int startRecordNumber = 0;
		int rowNum = 1;
		int count = 0;
		
		List<Item> listItem = (List<Item>) this.vslibDAO.listObjectSorted(Item.class, "barcodeNumber", "asc", startRecordNumber, 1000);
		
		while (!listItem.isEmpty()){
			for (Item obj : listItem) {
	
				count++;
				
				HSSFRow row = sheet.createRow(rowNum++);
	
				row.createCell(0).setCellValue(count);
				row.createCell(1).setCellValue(obj.getBarcodeNumber());
				row.createCell(2).setCellValue(obj.getClassNumber());
				row.createCell(3).setCellValue(obj.getItemType().getLabel());
				row.createCell(4).setCellValue(obj.getLibraryBranch().getLabel());
				row.createCell(5).setCellValue(obj.getSubject().getLabel());
				row.createCell(6).setCellValue(obj.getLanguage().getLabel());
				row.createCell(7).setCellValue(obj.getDocument().getId());
				row.createCell(8).setCellValue(obj.getDocument().getUniformTitle());
				row.createCell(9).setCellValue(obj.getDocument().getPrimaryAuthor());
				row.createCell(10).setCellValue(obj.getDocument().getSecondaryAuthors());
				row.createCell(11).setCellValue(obj.getDocument().getIsbn());
				row.createCell(12).setCellValue(obj.getDocument().getEdition());
				row.createCell(13).setCellValue(obj.getDocument().getPublicationYear());
				row.createCell(14).setCellValue(obj.getDocument().getCoverPrice());
				row.createCell(15).setCellValue(obj.getDocument().getPublisher());
				row.createCell(16).setCellValue(obj.getDocument().getCopyright());
			}
			
			startRecordNumber = startRecordNumber + 1000;
			
			listItem = (List<Item>) this.vslibDAO.listObjectSorted(Item.class, "barcodeNumber", "asc", startRecordNumber, 1000);
		}
	}
}
