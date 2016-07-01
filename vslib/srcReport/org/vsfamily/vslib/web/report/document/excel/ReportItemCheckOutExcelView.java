package org.vsfamily.vslib.web.report.document.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractExcelView;
import org.vsfamily.vslib.common.domain.ItemCheckOut;
import org.vsfamily.vslib.common.tools.DateAndTime;

@Component(value="reportItemCheckOutExcelView")
public class ReportItemCheckOutExcelView  extends AbstractExcelView {

	DateAndTime dt = new DateAndTime();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void buildExcelDocument(Map model, HSSFWorkbook workbook,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		List<ItemCheckOut> listItemCheckOut = (List<ItemCheckOut>) model
				.get("listItemCheckOut");

		HSSFSheet sheet = workbook
				.createSheet("List of Items check out.");

		HSSFRow header = sheet.createRow(0);

		header.createCell(0).setCellValue("S. No.");
		header.createCell(1).setCellValue("Check Out Date");
		header.createCell(2).setCellValue("Due Date Date");
		header.createCell(3).setCellValue("Barcode Number");
		header.createCell(4).setCellValue("Uniform Title");
		header.createCell(5).setCellValue("Primary Author");
		header.createCell(6).setCellValue("Patron Number");
		header.createCell(7).setCellValue("Patron Name");

		int rowNum = 1;
		int count = 0;
		
		for (ItemCheckOut obj : listItemCheckOut) {

			HSSFRow row = sheet.createRow(rowNum++);
			
			count++;

			row.createCell(0).setCellValue(count);
			row.createCell(1).setCellValue(obj.getCheckOutDate().getTime().toString());
			row.createCell(2).setCellValue(obj.getDueDate().getTime().toString());
			row.createCell(3).setCellValue(obj.getItem().getBarcodeNumber());
			row.createCell(4).setCellValue(obj.getItem().getDocument().getUniformTitle());
			row.createCell(5).setCellValue(obj.getItem().getDocument().getPrimaryAuthor());
			row.createCell(6).setCellValue(obj.getPatron().getNumber());
			row.createCell(7).setCellValue(obj.getPatron().getName());

		}
	}
}
