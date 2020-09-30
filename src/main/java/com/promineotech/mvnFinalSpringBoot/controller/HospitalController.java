package com.promineotech.mvnFinalSpringBoot.controller;

import com.promineotech.mvnFinalSpringBoot.entity.Hospital;
import com.promineotech.mvnFinalSpringBoot.service.HospitalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private HospitalService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createHospital(@RequestBody Hospital hospital) {
		return new ResponseEntity<Object>(service.createHospital(hospital), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getHospital() {
		return new ResponseEntity<Object>(service.getHospital(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getHospitalById(@PathVariable Long id) {
		return new ResponseEntity<Object>(service.getHospital(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateHospital(@RequestBody Hospital hospital, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateHospital(hospital, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to update hospital.", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteHospital(@PathVariable Long id) {
		try {
			service.deleteHospital(id);
			return new ResponseEntity<Object>("Deleted hospital with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to delete hospital.", HttpStatus.BAD_REQUEST);
		}
	}
}
