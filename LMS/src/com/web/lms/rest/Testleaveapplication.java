package com.web.lms.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.web.lms.dao.LmsAttachmentHome;
import com.web.lms.dao.LmsLeaveApplicationHome;
import com.web.lms.dao.LmsUserHome;
import com.web.lms.dao.LmsWfRequestHopHome;
import com.web.lms.dao.LmsWftRoleUserMapHome;
import com.web.lms.model.LmsAttachment;
import com.web.lms.model.LmsLeaveApplication;
import com.web.lms.model.LmsUser;
import com.web.lms.model.LmsWfRequestHop;
import com.web.lms.model.LmsWftRoleUserMap;
import com.web.lms.wrapper.ResponseWrapper;
import com.web.lms.wrapper.LeaveApplicationWrapper;
import com.web.lms.wrapper.ManageLeaveSearchWrapper;

@RestController
public class Testleaveapplication {
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private LmsLeaveApplicationHome lmsLeaveApplicationHome;
	@Autowired
	private LmsWftRoleUserMapHome lmsWftRoleUserMapHome;
	@Autowired
	private LmsWfRequestHopHome lmsWfRequestHopHome;
	@Autowired
	private LmsAttachmentHome lmsAttachmentHome;
	@Autowired
	private LmsUserHome lmsUserHome;
	
	//@Autowired
	//private LmsLeaveApplication lmsLeaveApplication;
	
	@RequestMapping(value = "/testleave", method = RequestMethod.POST)
	public ResponseEntity<ResponseWrapper> doLeaveSubmission(@RequestBody LmsLeaveApplication leaveApplication) {
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		Integer userID = (Integer) httpSession.getAttribute("userID");
		int lmsleaveapplicationid = 0;
			try {
				lmsleaveapplicationid = lmsLeaveApplicationHome.persist(leaveApplication);
				//lmsLeaveApplicationHome.persist(lmsLeaveApplication);
				
				/*final String tokenURI = "http://localhost:8080/LMS/generaterequest/";
				
				RestTemplate restTemplate = new RestTemplate();
				
			    restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
			    HttpHeaders headers = new HttpHeaders();
			    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			    headers.setContentType(new MediaType("application", "x-www-form-urlencoded"));*/
			    /*MultiValueMap<String, Integer> map= new LinkedMultiValueMap<String, Integer>();
			    map.add("userid", userID);
			    map.add("leavetypeid", leaveApplication.getLmsLeaveType().getId());
			    map.add("leaveapplicationid", lmsleaveapplicationid);*/
			    
			    /*Map<String, Integer> uriParams = new HashMap<String, Integer>();
			    uriParams.put("userid", userID);
			    uriParams.put("leavetypeid", leaveApplication.getLmsLeaveType().getId());
			    uriParams.put("leaveapplicationid", lmsleaveapplicationid);
			    
			    HttpEntity<Map<String, Integer>> entity = new HttpEntity<>(uriParams, headers);
			    ResponseEntity<ResponseWrapper> result;
			    try { 
			    	result = restTemplate.exchange(tokenURI, HttpMethod.POST, entity, ResponseWrapper.class);
			    }
			    catch(Exception ex) {
			    	ex.printStackTrace();
					responseWrapper.setMessage("Failed to create request.");
					return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			    }*/
			     
			}
			catch(Exception ex) {
				ex.printStackTrace();
				responseWrapper.setMessage("Failed to create request.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}
			
			httpSession.setAttribute("leaveApplicationID", lmsleaveapplicationid);
			responseWrapper.setMessage("Success. Leave request is submitted");
			responseWrapper.setUserid(userID);
			responseWrapper.setLeaveapplicationid(lmsleaveapplicationid);
			responseWrapper.setLeavetypeid(leaveApplication.getLmsLeaveType().getId());
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);	

	}
	
	@RequestMapping(value="/manageleave/", method=RequestMethod.POST)// showing leave requests searching by name & id.
	public ResponseEntity<ResponseWrapper> manageuser(@RequestBody ManageLeaveSearchWrapper manageLeaveSearchWrapper){
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("Test Message");
		
		System.out.println(manageLeaveSearchWrapper);
		List<LmsLeaveApplication> lmsLeaveApplication = new ArrayList<>();
		
		/*if(manageLeaveSearchWrapper.getUser_name() != null && manageLeaveSearchWrapper.getUser_id() != 0) {
			lmsLeaveApplication = lmsLeaveApplicationHome.findLeaveApplicationByUserID(manageLeaveSearchWrapper.getUser_name(),manageLeaveSearchWrapper.getUser_id());
		}*/
		if(manageLeaveSearchWrapper.getUser_id() != 0) {
		lmsLeaveApplication = lmsLeaveApplicationHome.findLeaveApplicationByUserID(manageLeaveSearchWrapper.getUser_id());
	   }
		
		
		if(lmsLeaveApplication.size()>0) {
			
	   responseWrapper.setListLmsLeaveApplication(lmsLeaveApplication);
			
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		}
		
		responseWrapper.setMessage("Fail. Data not matched.");
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value="/loadCurrentLeaveApplication/{userID}", method=RequestMethod.GET)// showing leave requests searching by name & id.
	public ResponseEntity<ResponseWrapper> loadCurrentLeaveApplication(@PathVariable("userID") Integer userID){
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("Test Message");
		List<LmsWfRequestHop> listlmsWfRequestHop = null; 
		List<LmsWfRequestHop> listlmsWfRequestHopFinal = new ArrayList<>();
		List<LmsWftRoleUserMap> listlmsWftRoleUserMap = null;
		List<LmsAttachment> listLmsAttachment = null;
		
		try {
			listlmsWftRoleUserMap = lmsWftRoleUserMapHome.findByUserID(userID);
		}catch(Exception ex) {
			ex.printStackTrace();
			responseWrapper.setMessage("Failed");
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}
		
		List<LmsLeaveApplication> lmsLeaveApplication = new ArrayList<>();
		
		/*if(manageLeaveSearchWrapper.getUser_name() != null && manageLeaveSearchWrapper.getUser_id() != 0) {
			lmsLeaveApplication = lmsLeaveApplicationHome.findLeaveApplicationByUserID(manageLeaveSearchWrapper.getUser_name(),manageLeaveSearchWrapper.getUser_id());
		}*/
		
		lmsLeaveApplication = lmsLeaveApplicationHome.findLeaveApplicationByUserID(userID);
		
		for(LmsWftRoleUserMap lmsWftRoleUserMap: listlmsWftRoleUserMap) {
			
			listlmsWfRequestHop = lmsWfRequestHopHome.findByRoleMapAndStatus("CURRENT", lmsWftRoleUserMap.getLmsWftRole().getId());
			
			for(LmsWfRequestHop lmsWfRequestHop: listlmsWfRequestHop) {
				listlmsWfRequestHopFinal.add(lmsWfRequestHop);
				listLmsAttachment = lmsAttachmentHome.findByApplicationID(lmsWfRequestHop.getLmsWfRequest().getLmsLeaveApplication().getId());
			}
			responseWrapper.setListLmsAttatchment(listLmsAttachment);
			listLmsAttachment = null;
		}
		
		
		responseWrapper.setListLmsWfRequestHops(listlmsWfRequestHopFinal);
		
		//if(lmsLeaveApplication.size()>0) {
			
	   responseWrapper.setListLmsLeaveApplication(lmsLeaveApplication);
			
			
		
		
		//responseWrapper.setMessage("Fail. Data not matched.");
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/homepagegridshow/", method = RequestMethod.GET)// showing all persons who are on leave.
	public ResponseEntity<ResponseWrapper> getlog() {

		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("Test Message");
		LmsUser lmsUser = new LmsUser();
		List<LmsLeaveApplication> lmsLeaveApplication = lmsLeaveApplicationHome.findAllLeaveApplicationsGeaterThanCurrentDate();// used for showing leave info in homepage
			//listLmsLeaveApplication = lmsLeaveApplicationHome.findAllLeaveApplications();
			
		if(lmsLeaveApplication.size()>0) {
			   responseWrapper.setListLmsLeaveApplication(lmsLeaveApplication);
					for(LmsLeaveApplication leaveApplication:lmsLeaveApplication) {
						lmsUser = leaveApplication.getLmsUserByUserId();
					}
					return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
				}
		
		responseWrapper.setMessage("Fail. Data not matched.");
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		
	}	
	
	@RequestMapping(value = "/updateuserleave", method = RequestMethod.PUT) // Update a leave request.
	public ResponseEntity<ResponseWrapper> updateuserleave(@RequestBody LmsLeaveApplication lmsLeaveApplication) {
		
		ResponseWrapper responseWrapper = new ResponseWrapper();

				try  {	
					
					lmsLeaveApplicationHome.merge(lmsLeaveApplication); // For Update
				
				}
				
				catch(Exception ex) {
					ex.printStackTrace();
					responseWrapper.setMessage("Failed to create User.");
					return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
				}
				
				responseWrapper.setMessage("Success. Request is updated");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);

		}
	
	@RequestMapping(value="/getAttachment/{applicationID}", method=RequestMethod.GET)
	public ResponseEntity<List<LmsAttachment>> getAttachment(@PathVariable("applicationID") Integer applicationID){
		
		List<LmsAttachment> attachmentsList = null;
		try {
			attachmentsList = lmsAttachmentHome.findByApplicationID(applicationID);
			httpSession.setAttribute("leaveApplicationID",applicationID);
			return new ResponseEntity<List<LmsAttachment>>(attachmentsList, HttpStatus.OK);
		}catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<List<LmsAttachment>>(attachmentsList, HttpStatus.EXPECTATION_FAILED);
		}
	}



}
