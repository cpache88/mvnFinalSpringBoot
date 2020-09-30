package com.promineotech.mvnFinalSpringBoot.controller;

import com.promineotech.mvnFinalSpringBoot.entity.Patient;
import com.promineotech.mvnFinalSpringBoot.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createPatient(@RequestBody Patient patient) {
		return new ResponseEntity<Object>(service.createPatient(patient), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getPatients() {
		return new ResponseEntity<Object>(service.getPatient(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getPatientById(@PathVariable Long id) {
		return new ResponseEntity<Object>(service.getPatient(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updatePatient(@RequestBody Patient patient, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updatePatient(patient, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to update patient.", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deletePatient(@PathVariable Long id) {
		try {
			service.deletePatient(id);
			return new ResponseEntity<Object>("Deleted patient with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to delete patient.", HttpStatus.BAD_REQUEST);
		}
	}
}
