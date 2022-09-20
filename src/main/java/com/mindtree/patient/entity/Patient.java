package com.mindtree.patient.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient {
	
	@Id
	private Long patientId;
	private String patientName;
	private String visitedDoctor;
	private String dateOfVisit;
	private int age;
	private String doctorPrescription;
	private Long doctorId;
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(Long patientId, String patientName, String visitedDoctor, String dateOfVisit, int age, String doctorPrescription, Long doctorId) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.visitedDoctor = visitedDoctor;
		this.dateOfVisit = dateOfVisit;
		this.age=age;
		this.doctorPrescription=doctorPrescription;
		this.doctorId = doctorId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getVisitedDoctor() {
		return visitedDoctor;
	}
	public void setVisitedDoctor(String visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}
	public String getDateOfVisit() {
		return dateOfVisit;
	}
	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorPrescription() {
		return doctorPrescription;
	}
	public void setDoctorPrescription(String doctorPrescription) {
		this.doctorPrescription = doctorPrescription;
	}
	
	

}
