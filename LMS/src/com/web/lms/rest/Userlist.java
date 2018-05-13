
package com.web.lms.rest;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.web.lms.dao.LmsUserHome;
import com.web.lms.model.LmsDivision;
import com.web.lms.model.LmsUser;

import com.web.lms.wrapper.ResponseWrapper;

@RestController
public class Userlist {
	
@Autowired
private LmsUserHome lmsUserHome;
@Autowired
private HttpSession httpSession;

@RequestMapping(value="/getUserlist", method=RequestMethod.GET)
public ResponseEntity<List<LmsUser>> getUserList() {
	
	List<LmsUser> listLmsUser = new ArrayList<>();
	
	try {
		listLmsUser = lmsUserHome.findAllUser();
		
		return new ResponseEntity<List<LmsUser>>(listLmsUser, HttpStatus.OK);
	}
	catch(Exception ex) {
		ex.printStackTrace();
		return new ResponseEntity<List<LmsUser>>(listLmsUser, HttpStatus.EXPECTATION_FAILED);
		
	}
	
	
}

}
