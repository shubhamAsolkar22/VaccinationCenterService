package com.fkog.vcs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fkog.vcs.entity.VaccinationCenter;

@RestController
@RequestMapping(path = "/vaccinationCenters")
public class VaccinationCenterController {
	private static final List<VaccinationCenter> ALL_VACCINATION_CENTERS = new ArrayList<>();
	
	static {
		VaccinationCenter vc = new VaccinationCenter();
		
		vc.setId(10);
		vc.setAddress("NWM Hospital, Parel (East), Mumbai 400014.");
		
		ALL_VACCINATION_CENTERS.add(vc);
		
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getVaccinationCenterById(@PathVariable(name = "id") Long id){
		return ResponseEntity.ok(ALL_VACCINATION_CENTERS.stream().filter(e -> e.getId()==id).findFirst());
	}
	
}
