package com.web.lms.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.lms.dao.LmsDivisionHome;
import com.web.lms.model.LmsDivision;
import com.web.lms.wrapper.ResponseWrapper;

@RestController
public class Division {

	@Autowired
	private LmsDivisionHome lmsDivisionHome;
	
	@RequestMapping(value="/getAllDivisionData", method=RequestMethod.GET)
	public ResponseEntity<List<LmsDivision>> getAllDivision() {
		
		List<LmsDivision> listLmsdivision = new ArrayList<>();
		
		try {
			listLmsdivision = lmsDivisionHome.getAlldivision();
			
			return new ResponseEntity<List<LmsDivision>>(listLmsdivision, HttpStatus.OK);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<List<LmsDivision>>(listLmsdivision, HttpStatus.EXPECTATION_FAILED);
			
		}
		
		
	}
}
