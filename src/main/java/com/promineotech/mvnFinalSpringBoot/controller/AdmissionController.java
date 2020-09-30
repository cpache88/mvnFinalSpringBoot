package com.promineotech.mvnFinalSpringBoot.controller;

import com.promineotech.mvnFinalSpringBoot.entity.Admission;
import com.promineotech.mvnFinalSpringBoot.service.AdmissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admission")
public class AdmissionController {

	@Autowired
	private AdmissionService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createAdmission(@RequestBody Admission admission) {
		return new ResponseEntity<Object>(service.createAdmission(admission), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getAdmissions() {
		return new ResponseEntity<Object>(service.getAdmissions(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getAdmissionById(@PathVariable Long id) {
		return new ResponseEntity<Object>(service.getAdmission(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateAdmission(@RequestBody Admission admission, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateAdmission(admission, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to update admission.", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteAdmission(@PathVariable Long id) {
		try {
			service.deleteAdmission(id);
			return new ResponseEntity<Object>("Deleted admission with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to delete admission.", HttpStatus.BAD_REQUEST);
		}
	}
}
