package com.mindtree.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mindtree.patient.entity.Patient;
import com.mindtree.patient.repository.PatientRepository;


@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;

	public Patient createPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	public List<Patient> getAllPatient() {
		return patientRepository.findAll();
	}

	public ResponseEntity<Patient> getPatientById(Long patientId) {
		Patient patient = patientRepository.findById(patientId).orElseThrow(()-> new com.mindtree.patient.exception.ResourceNotFoundException("Employee not exist with id"+patientId));
		return ResponseEntity.ok(patient);
	}

	

}
