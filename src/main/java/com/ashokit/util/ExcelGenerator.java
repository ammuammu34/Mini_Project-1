package com.ashokit.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.ashokit.entity.CitizenPlan;
import com.ashokit.repo.CitizenPlanRepository;
@Component
public class ExcelGenerator {
	
	@Autowired
	private CitizenPlanRepository repo;
	public void generateExcel(FileOutputStream fos,List<CitizenPlan> lst) {
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("citizenPlan Info");
		HSSFRow row = sheet.createRow(0);

		try {
		row.createCell(0).setCellValue("Id");
		row.createCell(1).setCellValue("citizenName");          
		row.createCell(2).setCellValue("gender");
		row.createCell(3).setCellValue("planName");
		row.createCell(4).setCellValue("status");
		row.createCell(5).setCellValue("startDate");
		row.createCell(6).setCellValue("endDate");
		row.createCell(7).setCellValue("benefitAmount");
		row.createCell(8).setCellValue("denialReason");
		row.createCell(9).setCellValue("termiantedDate");
		row.createCell(10).setCellValue("terminationReason");

		List<CitizenPlan> records= repo.findAll();
		int dataRowIndex = 1;

		for(CitizenPlan c : records) {
			HSSFRow dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(c.getCitizenId());
			dataRow.createCell(1).setCellValue(c.getCitizenName());
			dataRow.createCell(2).setCellValue(c.getGender());
			dataRow.createCell(3).setCellValue(c.getPlanNames());
			dataRow.createCell(4).setCellValue(c.getStatus());

			if(c.getStartDate() != null) {
			LocalDate localDate = c.getStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String date = localDate.format(formatter);
			dataRow.createCell(5).setCellValue(date);
			}

			if(c.getEndDate() != null) {
			LocalDate localDate = c.getEndDate();
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String date1 = localDate.format(formatter1);
			dataRow.createCell(6).setCellValue(date1);
			}

			if(c.getBenifitAmount() != null) {
			dataRow.createCell(7).setCellValue(c.getBenifitAmount());
			}

			if(c.getDenialReason() != null) {
			dataRow.createCell(8).setCellValue(c.getDenialReason());
			}
			if(c.getTerminatedDate() != null) {
			LocalDate localDate2 = c.getTerminatedDate();
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd LLLL yyyy");
			String date2 = localDate2.format(formatter2);
			dataRow.createCell(9).setCellValue(date2);
			}

			if(c.getTerminalReason() != null) {
			dataRow.createCell(10).setCellValue(c.getTerminalReason());
			}

			dataRowIndex++;
		}

			workbook.write(fos);
			workbook.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
