package com.ashokit.search;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SearchRequest {

	public String PlanNames;
	public String Status;
	public String gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public String startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public String endDate;
	
}
