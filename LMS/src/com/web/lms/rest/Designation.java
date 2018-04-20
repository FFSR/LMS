package com.web.lms.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.lms.dao.LmsDesignationHome;
import com.web.lms.model.LmsDesignation;
import com.web.lms.wrapper.ResponseWrapper;

@RestController
public class Designation {

	@Autowired
	private LmsDesignationHome LmsDesignationHome;
	
	@RequestMapping(value="/getAllDesignationData", method=RequestMethod.GET)
	public ResponseEntity<List<LmsDesignation>> getAllDesignation() {
		
		List<LmsDesignation> listLmsdesignation = new ArrayList<>();
		
		try {
			listLmsdesignation = LmsDesignationHome.getAlldesignation();
			
			return new ResponseEntity<List<LmsDesignation>>(listLmsdesignation, HttpStatus.OK);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<List<LmsDesignation>>(listLmsdesignation, HttpStatus.EXPECTATION_FAILED);
			
		}
		
		
	}
}
