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
import com.web.lms.utility.ProtectedConfigFile;


@RestController
public class Login {

	@Autowired
	private LmsUserHome lmsUserHome;
	@Autowired
	private HttpSession httpSession;

	
	@RequestMapping(value="/login/{userName}/{password}", method=RequestMethod.GET)
	
	public ResponseEntity<ResponseWrapper> getlogin(@PathVariable("userName") String uName, @PathVariable("password") String password){
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		LmsUser lmsUser = new LmsUser();
		try {
			password = ProtectedConfigFile.encrypt(password);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		try {
			lmsUser = lmsUserHome.findByUnameandPassword(uName, password);
			httpSession.setAttribute("user", lmsUser);
			httpSession.setAttribute("userName", lmsUser.getName());
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		if(lmsUser != null) {
			responseWrapper.setMessage("Success. UserName: "+uName+" Password: "+password);
			
			httpSession.setAttribute("userName", uName);
		}
		
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/{userName}/{password}", method=RequestMethod.GET)
	
	public ResponseEntity<LmsUser> getuser(@PathVariable("userName") String uName, @PathVariable("password") String password){
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		LmsUser lmsUser = lmsUserHome.findByUnameandPassword(uName, password);
		
		if(lmsUser != null) {
			responseWrapper.setMessage("Success. UserName: "+uName+" Password: "+password);
			
		}
		
		return new ResponseEntity<LmsUser>(lmsUser, HttpStatus.OK);
	}
}
