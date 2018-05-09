package com.web.lms.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.lms.dao.LmsWftRoleHome;
import com.web.lms.model.LmsWftRole;
import com.web.lms.wrapper.ResponseWrapper;

@RestController
public class Wftrole {

	@Autowired
	private LmsWftRoleHome LmsWftRoleHome;
	
	@RequestMapping(value="/getAllWftroleData", method=RequestMethod.GET)
	public ResponseEntity<List<LmsWftRole>> getAllWftrole() {
		
		List<LmsWftRole> listLmsWftrole = new ArrayList<>();
		
		try {
			listLmsWftrole = LmsWftRoleHome.getAllWftrole();
			
			return new ResponseEntity<List<LmsWftRole>>(listLmsWftrole, HttpStatus.OK);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<List<LmsWftRole>>(listLmsWftrole, HttpStatus.EXPECTATION_FAILED);
			
		}
		
		
	}
}
