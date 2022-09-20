package com.mindtree.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.patient.entity.Patient;
import com.mindtree.patient.service.PatientService;


@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	
	
	@CrossOrigin("http://localhost:4200/")
	@PostMapping("/get")
	public Patient createPatient(@RequestBody Patient patient) {
		return patientService.createPatient(patient);
	}
	
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/get")
	public List<Patient> getAllPatient(){
		return patientService.getAllPatient();
	}
	
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/get/{patientId}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long patientId) {
		return patientService.getPatientById(patientId);
	}
}
