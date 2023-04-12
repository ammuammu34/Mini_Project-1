package com.ashokit.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="citizen_plan")
public class CitizenPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer citizenId;
	private String citizenName;
	private String planNames;
	private String gender;
	private String status;
	private LocalDate startDate;
	private LocalDate endDate;
	private Double benifitAmount;
	private String denialReason;
	private LocalDate terminatedDate;
	private String terminalReason;

}
