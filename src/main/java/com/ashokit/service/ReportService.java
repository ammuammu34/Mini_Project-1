package com.ashokit.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ashokit.entity.CitizenPlan;
import com.ashokit.repo.CitizenPlanRepository;

@Component
public class ReportService implements CommandLineRunner {
	@Autowired
	private CitizenPlanRepository repo;
	

	@Override
	public void run(String... args) throws Exception {


		repo.deleteAll();
		
		CitizenPlan c1= new CitizenPlan();
       c1.setCitizenName("jonson");
       c1.setPlanNames("cash");
       c1.setGender("male");
       c1.setStatus("approved");
       c1.setStartDate(LocalDate.now());
       c1.setEndDate(LocalDate.now().plusMonths(6));
       c1.setBenifitAmount(5000.00);
       
       CitizenPlan c2= new CitizenPlan();
       c2.setCitizenName("kelvin");
       c2.setPlanNames("cash");
       c2.setGender("male");
       c2.setStatus("denied");
       c2.setStartDate(LocalDate.now());
       c2.setEndDate(LocalDate.now().plusMonths(6));
       c2.setBenifitAmount(5000.00);
       c2.setDenialReason("No income");
       
       CitizenPlan c3= new CitizenPlan();
       c3.setCitizenName("catherin");
       c3.setPlanNames("cash");
       c3.setGender("fe-male");
       c3.setStatus("Terminated");
       c3.setTerminalReason("employeed");
       c3.setStartDate(LocalDate.now());
       c3.setEndDate(LocalDate.now().plusMonths(6));
       c3.setBenifitAmount(5000.00);
       c3.setTerminatedDate(LocalDate.now().minusMonths(4));
       
       CitizenPlan c4= new CitizenPlan();
       c4.setCitizenName("jackson");
       c4.setPlanNames("employment");
       c4.setGender("male");
       c4.setStatus("approved");
       c4.setStartDate(LocalDate.now());
       c4.setEndDate(LocalDate.now().plusMonths(6));
       c4.setBenifitAmount(7000.00);
       
       CitizenPlan c5= new CitizenPlan();
       c5.setCitizenName("jansi");
       c5.setPlanNames("employment");
       c5.setGender("fe-male");
       c5.setStatus("denied");
       c5.setStartDate(LocalDate.now());
       c5.setEndDate(LocalDate.now().plusMonths(6));
       c5.setBenifitAmount(5000.00);
       c5.setDenialReason("No income");
       
       CitizenPlan c6= new CitizenPlan();
       c6.setCitizenName("sanvi");
       c6.setPlanNames("employement");
       c6.setGender("fe-male");
       c6.setStatus("Terminated");
       c6.setTerminalReason("govt employee");
       c6.setStartDate(LocalDate.now());
       c6.setEndDate(LocalDate.now().plusMonths(6));
       c6.setBenifitAmount(5000.00);
       c6.setTerminatedDate(LocalDate.now().minusMonths(4));
       
       CitizenPlan c7= new CitizenPlan();
       c7.setCitizenName("vishal");
       c7.setPlanNames("Food");
       c7.setGender("male");
       c7.setStatus("approved");
       c7.setStartDate(LocalDate.now());
       c7.setEndDate(LocalDate.now().plusMonths(6));
       c7.setBenifitAmount(5000.00);
       
       CitizenPlan c8= new CitizenPlan();
       c8.setCitizenName("abhi");
       c8.setPlanNames("food");
       c8.setGender("male");
       c8.setStatus("denied");
       c8.setStartDate(LocalDate.now());
       c8.setEndDate(LocalDate.now().plusMonths(6));
       c8.setBenifitAmount(5000.00);
       c8.setDenialReason("No income");
       
       CitizenPlan c9= new CitizenPlan();
       c9.setCitizenName("soni");
       c9.setPlanNames("food");
       c9.setGender("fe-male");
       c9.setStatus("Terminated");
       c9.setTerminalReason("employeed");
       c9.setStartDate(LocalDate.now());
       c9.setEndDate(LocalDate.now().plusMonths(6));
       c9.setBenifitAmount(5000.00);
       c9.setTerminatedDate(LocalDate.now().minusMonths(4));
       
       CitizenPlan c10= new CitizenPlan();
       c10.setCitizenName("saathwik");
       c10.setPlanNames("medical");
       c10.setGender("male");
       c10.setStatus("approved");
       c10.setStartDate(LocalDate.now());
       c10.setEndDate(LocalDate.now().plusMonths(6));
       c10.setBenifitAmount(7000.00);
       
       CitizenPlan c11= new CitizenPlan();
       c11.setCitizenName("jamuna");
       c11.setPlanNames("medical");
       c11.setGender("fe-male");
       c11.setStatus("denied");
       c11.setStartDate(LocalDate.now());
       c11.setEndDate(LocalDate.now().plusMonths(6));
       c11.setBenifitAmount(15000.00);
       c11.setDenialReason("No income");
       
       CitizenPlan c12= new CitizenPlan();
       c12.setCitizenName("sanjana");
       c12.setPlanNames("medical");
       c12.setGender("fe-male");
       c12.setStatus("Terminated");
       c12.setTerminalReason("govt employee");
       c12.setStartDate(LocalDate.now());
       c12.setEndDate(LocalDate.now().plusMonths(6));
       c12.setBenifitAmount(5000.00);
       c12.setTerminatedDate(LocalDate.now().minusMonths(4));
       List<CitizenPlan> list = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);

       repo.saveAll(list);
       System.out.println("data inserted...");
	}

}
