package com.ashokit.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ashokit.entity.CitizenPlan;
import com.ashokit.repo.CitizenPlanRepository;
import com.ashokit.report.ReportService;
import com.ashokit.search.SearchRequest;
import com.ashokit.util.EmailUtils;
import com.ashokit.util.ExcelGenerator;
import com.ashokit.util.PdfGenerator;

@Service
public class ServiceImpl implements ReportService {
	
	@Autowired
	private CitizenPlanRepository repo;
	@Autowired
	private ExcelGenerator egenerator;

	@Autowired
	private EmailUtils utils;

	@Autowired
	private PdfGenerator pgenerator;


	@Override
	public List<String> PlanNames() {
      return repo.getPlanNames();
	}

	@Override
	public List<String> Status() {
		return repo.getStatus();
	}

	@Override
	public List<CitizenPlan> Search(SearchRequest request) {
		CitizenPlan entity = new CitizenPlan();
		if(null!=request.getPlanNames()&&!"".equals(request.getPlanNames())) {
			entity.setPlanNames(request.getPlanNames());
		}
		if(null!=request.getStatus()&&!"".equals(request.getStatus())) {
			entity.setStatus(request.getStatus());
		}
		if(null!=request.getGender()&&!"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		if(null!=request.getStartDate()&&!"".equals(request.getStartDate())) {
			String startdate = request.getStartDate();

			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			  LocalDate localDate = LocalDate.parse(startdate,formatter);
		    entity.setStartDate(localDate);
	}
		if(null!=request.getEndDate()&&!"".equals(request.getEndDate())) {
			String endDate = request.getEndDate();

			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			  LocalDate localDate = LocalDate.parse(endDate,formatter);
		    entity.setEndDate(localDate);
		}
		return repo.findAll(Example.of(entity));
		
	}

	@Override
	public boolean GenerateExportExcel() {
		String filePath = "C:\\JRTP\\MiniProject\\PlansData.xls";
		try {

			List<CitizenPlan> plans = repo.findAll();
			FileOutputStream fos = new FileOutputStream(filePath);
			egenerator.generateExcel(fos, plans);
			utils.sendEmailWithAttachment("k.ravali034@gmail.com",
					"Citizen Plans Report","Here is the excelsheet of plans.", filePath);

		} catch (FileNotFoundException | MessagingException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean GenerateExportPdf() {
		String filePath = "C:\\JRTP\\MiniProject\\PlansData.pdf";
		try {
			List<CitizenPlan> plans = repo.findAll();
			FileOutputStream fos = new FileOutputStream(filePath);
			pgenerator.generatePDF(plans, fos);
			utils.sendEmailWithAttachment("k.ravali034@gmail.com",
					"Citizen Plans Report","Here is the pdf of plans.", filePath);
		} catch (FileNotFoundException | MessagingException e) {

			e.printStackTrace();
		}
		return true;
	}


	}

