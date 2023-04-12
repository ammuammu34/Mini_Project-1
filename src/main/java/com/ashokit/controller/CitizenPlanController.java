package com.ashokit.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.entity.CitizenPlan;
import com.ashokit.report.ReportService;
import com.ashokit.search.SearchRequest;

@Controller
public class CitizenPlanController {
	@Autowired
	private ReportService service;
	
	
	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("search",new SearchRequest());
		init(model);
		return "index";
	}
	
	private void init(Model model) {
		model.addAttribute("names",service.PlanNames());
		model.addAttribute("status",service.Status());
	}
	

	@PostMapping("/save")
    public String handleSearch(@ModelAttribute("search") SearchRequest search, Model model) {
	List<CitizenPlan> plan = service.Search(search);
	model.addAttribute("plans",plan);
	init(model);
	return "index";
}	
	@GetMapping("/excel")
	/*
	public void GenerateExcelReport(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=plans.xls";

		response.setHeader(headerKey, headerValue);
	}
	*/
	public String exportExcel(@ModelAttribute("search")SearchRequest search ,Model model) {
		boolean status = service.GenerateExportExcel();
		init(model);
		if(status) {
			model.addAttribute("export","Excel Exported");
		}else {
			model.addAttribute("export","Excel not Exported");
		}
		
		return "index";

	}
	

	@GetMapping("/pdf")
	public String exportGenerate(@ModelAttribute("search")SearchRequest search ,Model model) {
		boolean status = service.GenerateExportPdf();
		init(model);
		if(status) {
			model.addAttribute("export","Pdf Exported");
		}else {
			model.addAttribute("export","Pdf not Exported");
		}
		return "index";

	}


}
