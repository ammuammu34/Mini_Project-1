package com.ashokit.report;

import java.util.List;

import com.ashokit.entity.CitizenPlan;
import com.ashokit.search.SearchRequest;

public interface ReportService {
	public List<String> PlanNames();
	public List<String> Status();
	public List<CitizenPlan> Search(SearchRequest request);
	public boolean GenerateExportExcel();
	public boolean GenerateExportPdf();
	
	

}
