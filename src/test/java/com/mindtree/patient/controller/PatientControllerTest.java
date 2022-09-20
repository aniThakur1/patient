package com.mindtree.patient.controller;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindtree.patient.entity.Patient;
import com.mindtree.patient.service.PatientService;




@RunWith(SpringRunner.class)
@WebMvcTest(value=PatientController.class)
public class PatientControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PatientService patientService;
	
	@Test
	public void testCreateVoter() throws Exception{
		
		Patient mockPatient = new Patient();
		mockPatient.setPatientId(1L);
		mockPatient.setPatientName("Akash");
		mockPatient.setVisitedDoctor("saxena");
		mockPatient.setDateOfVisit("01/01/01");
		mockPatient.setAge(23);
		mockPatient.setDoctorPrescription("paracetamol");
		mockPatient.setDoctorId(1L);
		
		String inputInJson = this.mapToJson(mockPatient);
		
		String URI = "/patient/get";
		
		Mockito.when(patientService.createPatient(Mockito.any(Patient.class))).thenReturn(mockPatient);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJson);
		
		assertEquals(HttpStatus.OK.value(),response.getStatus());
		
		
		
				
	}
	@Test
	public void testGetAllPatient() throws Exception {
		Patient mockPatient1 = new Patient();
		mockPatient1.setPatientId(2L);
		mockPatient1.setPatientName("Abhishek");
		mockPatient1.setVisitedDoctor("Saxena");
		mockPatient1.setDateOfVisit("02/02/02");
		mockPatient1.setAge(25);
		mockPatient1.setDoctorPrescription("Digene");
		mockPatient1.setDoctorId(3L);
		
		Patient mockPatient2 = new Patient();
		mockPatient2.setPatientId(3L);
		mockPatient2.setPatientName("Anant");
		mockPatient2.setVisitedDoctor("Dharamveer");
		mockPatient2.setDateOfVisit("03/03/03");
		mockPatient2.setAge(24);
		mockPatient2.setDoctorPrescription("Digene");
		mockPatient2.setDoctorId(4L);
		
		List<Patient> patientList = new ArrayList<>();
		patientList.add(mockPatient1);
		patientList.add(mockPatient2);
		
		Mockito.when(patientService.getAllPatient()).thenReturn(patientList);
		
		String URI = "/patient/get";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expectedJson = this.mapToJson(patientList);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);

		
		
	}
	
	
	private  String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}


}
