package com.web.lms.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.lms.dao.LmsRoleHome;
import com.web.lms.model.LmsRole;
import com.web.lms.wrapper.ResponseWrapper;

@RestController
public class Role {

	@Autowired
	private LmsRoleHome LmsRoleHome;
	
	@RequestMapping(value="/getAllRoleData", method=RequestMethod.GET)
	public ResponseEntity<List<LmsRole>> getAllRole() {
		
		List<LmsRole> listLmsrole = new ArrayList<>();
		
		try {
			listLmsrole = LmsRoleHome.getAllrole();
			
			return new ResponseEntity<List<LmsRole>>(listLmsrole, HttpStatus.OK);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<List<LmsRole>>(listLmsrole, HttpStatus.EXPECTATION_FAILED);
			
		}
		
		
	}
}
