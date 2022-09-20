package com.mindtree.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.patient.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long>{

	

}
