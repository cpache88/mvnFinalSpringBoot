package com.promineotech.mvnFinalSpringBoot.controller;

import com.promineotech.mvnFinalSpringBoot.entity.Test;
import com.promineotech.mvnFinalSpringBoot.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createTest(@RequestBody Test test) {
		return new ResponseEntity<Object>(service.createTest(test), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getTest() {
		return new ResponseEntity<Object>(service.getTest(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getTestById(@PathVariable Long id) {
		return new ResponseEntity<Object>(service.getTest(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateTest(@RequestBody Test test, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateTest(test, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to update test.", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteTest(@PathVariable Long id) {
		try {
			service.deleteTest(id);
			return new ResponseEntity<Object>("Deleted test with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to delete test.", HttpStatus.BAD_REQUEST);
		}
	}
}
