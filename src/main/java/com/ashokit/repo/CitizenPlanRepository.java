package com.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashokit.entity.CitizenPlan;

public interface CitizenPlanRepository extends JpaRepository<CitizenPlan,Integer>{

	@Query(value ="select distinct(planNames) from CitizenPlan")
	public List<String> getPlanNames();
	@Query(value = "select distinct (status) from CitizenPlan")
	public List<String> getStatus();
	

}