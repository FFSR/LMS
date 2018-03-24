package com.web.lms.rest;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.web.lms.wrapper.ResponseWrapper;

import com.web.lms.dao.LmsUserHome;
import com.web.lms.model.LmsUser;


@RestController
public class User {

	@Autowired
	private LmsUserHome lmsUserHome;
	@Autowired
	private HttpSession httpSession;

	
	@RequestMapping(value="/log/{userName}/{password}", method=RequestMethod.GET)
	public ResponseEntity<ResponseWrapper> getlog(@PathVariable("userName") String uName, @PathVariable("password") String password){
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		LmsUser lmsUser = lmsUserHome.findByUnameandPassword(uName, password);
		
		if(lmsUser != null) {
			responseWrapper.setMessage("Success. UserName: "+uName+" Password: "+password);
			
			httpSession.setAttribute("userName", uName);
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		}
		
		responseWrapper.setMessage("Fail. User Name or Password not matched.");
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
	}
	
	
	
	
	/*@RequestMapping(value="/registration/{userName}/{password}", method=RequestMethod.GET)
	public ResponseEntity<ResponseWrapper> doRegistration(@PathVariable("userName") String uName, @PathVariable("password") String password){
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		LmsUser lmsUser = lmsUserHome.findByUnameandPassword(uName, password);
		
		if(lmsUser != null) {
			responseWrapper.setMessage("Success. UserName: "+uName+" Password: "+password);
			
			httpSession.setAttribute("userName", uName);
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		}
		
		responseWrapper.setMessage("Fail. User Name or Password not matched.");
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
	}*/
}
