package com.web.lms.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.lms.dao.LmsLeaveApplicationHome;
import com.web.lms.dao.LmsLeaveTypeHome;
import com.web.lms.dao.LmsUserHome;
import com.web.lms.dao.LmsUserRoleMapHome;
import com.web.lms.dao.LmsWfRequestHome;
import com.web.lms.dao.LmsWfRequestHopHome;
import com.web.lms.dao.LmsWftFlowControlHome;
import com.web.lms.dao.LmsWftRequestHopRolePageMapHome;
import com.web.lms.dao.LmsWftRequestSelectorHome;
import com.web.lms.dao.LmsWftRoleHome;
import com.web.lms.dao.LmsWftRoleUserMapHome;
import com.web.lms.dao.LmsWftRoleUserMapHistoryHome;
import com.web.lms.enumcollection.WFSTATUS;
import com.web.lms.model.LmsLeaveApplication;
import com.web.lms.model.LmsLeaveType;
import com.web.lms.model.LmsUser;
import com.web.lms.model.LmsUserRoleMap;
import com.web.lms.model.LmsWfRequest;
import com.web.lms.model.LmsWfRequestHop;
import com.web.lms.model.LmsWftFlowControl;
import com.web.lms.model.LmsWftRequestHopRolePageMap;

import com.web.lms.model.LmsWftRequestSelector;
import com.web.lms.model.LmsWftRole;
import com.web.lms.model.LmsWftRoleUserMap;
import com.web.lms.model.LmsWftRoleUserMapHistory;
import com.web.lms.wrapper.ResponseWrapperWorkFlowManagement;
import com.web.lms.wrapper.ResponseWrapper;
import com.web.lms.utility.SendMail;

@RestController
public class WorkFlowManagement {
	
	@Autowired
	private LmsWftRequestSelectorHome LmsWftRequestSelectorHome;	
	@Autowired
	private LmsWfRequestHopHome lmsWfRequestHopHome;	
	@Autowired
	private LmsUserHome lmsUserHome;	
	@Autowired
	private LmsLeaveTypeHome lmsLeaveTypeHome;	
	@Autowired
	private LmsWftRequestHopRolePageMapHome lmsWftRequestHopRolePageMapHome;
	@Autowired
	private LmsWfRequestHome lmsWfRequestHome ;
	@Autowired
	private LmsWftFlowControlHome lmsWftFlowControlHome;
	@Autowired
	private LmsLeaveApplicationHome lmsLeaveApplicationHome;
	@Autowired
	private LmsWftRoleUserMapHome lmsWftRoleUserMapHome;
	@Autowired
	private LmsWftRoleUserMapHistoryHome lmsWftRoleUserMapistoryHome;
	@Autowired
	private LmsWftRoleHome lmsWftRoleHome;
	@Autowired
	private LmsUserRoleMapHome lmsUserRoleMapHome;

	@RequestMapping(value = "/generaterequest/{userid}/{leavetypeid}/{leaveapplicationid}", method = RequestMethod.POST)
	public ResponseEntity<ResponseWrapperWorkFlowManagement> generateRequest(@PathVariable("userid") Integer userid,
			@PathVariable("leavetypeid") Integer leavetypeid,@PathVariable("leaveapplicationid") Integer leaveapplicationid) {

		ResponseWrapperWorkFlowManagement responseWrapper = new ResponseWrapperWorkFlowManagement();
		SendMail sendmail= new SendMail();
		LmsWftRequestSelector lmsWftRequestSelector = null;

		try {

			// Validate User
			LmsUser user = lmsUserHome.findById(userid);
			if (user == null) {
				responseWrapper.setMessage("This userid is not available in database.");
				return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}

			// Validate Leave Type
			LmsLeaveType leaveType = lmsLeaveTypeHome.findById(leavetypeid);

			if (leaveType == null) {
				responseWrapper.setMessage("This Leave Type is not available in database.");
				return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}
			
			// Validate Leave Application ID
			
			LmsLeaveApplication leaveApplication = lmsLeaveApplicationHome.findById(leaveapplicationid);
					
			if (leaveapplicationid == null) {
				responseWrapper.setMessage("This Leave Application is not available in database.");
				return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}		

			// Find request type by User class, section and leave type
			if(user.getLmsSection() !=null) {
				
			 lmsWftRequestSelector = LmsWftRequestSelectorHome
					.findRequestTypeByClassSectorLeaveType(user.getLmsDesignation().getLmsClass().getId(),
							user.getLmsSection().getId(), leaveType.getId());
			 
			}else {  // Find request type by User class and leave type, no section
				lmsWftRequestSelector = LmsWftRequestSelectorHome
						.findRequestTypeByClassSectorLeaveType(user.getLmsDesignation().getLmsClass().getId(), leaveType.getId());
			}

			if (lmsWftRequestSelector == null) {

				responseWrapper.setMessage("This is no Request Type matched from Request Selector table.");
				return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}

			if(generateWorkRequest(lmsWftRequestSelector, user, leaveApplication)) {
				//sendmail.SendMail();
				responseWrapper.setMessage("Success. Your request is successfully generated.");
			
				return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper, HttpStatus.OK);
				
			}else {
				responseWrapper.setMessage("Fail. Your request is not generated.");
				return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}


		} catch (Exception ex) {
			responseWrapper.setMessage("Fail." + ex.getMessage());
			return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "/updaterequesthope/{userid}/{WfRequestHopid}/{hopStatus}", method = RequestMethod.PUT)
	public ResponseEntity<ResponseWrapperWorkFlowManagement> updateRequestHope(@PathVariable("userid") Integer userid,
			@PathVariable("WfRequestHopid") Integer WfRequestHopid, @PathVariable("hopStatus") String hopStatus, @RequestBody LmsWfRequestHop wfRequestHop) {

		ResponseWrapperWorkFlowManagement responseWrapper = new ResponseWrapperWorkFlowManagement();
		//SendMail sendmail= new SendMail();

		try {

			// Validate User
			LmsUser user = lmsUserHome.findById(userid);
			if (user == null) {
				responseWrapper.setMessage("This userid is not available in database.");
				return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}

			// Validate Leave Type
			LmsWfRequestHop lmsWfRequestHop = lmsWfRequestHopHome.findById(WfRequestHopid);

			if (lmsWfRequestHop == null) {
				responseWrapper.setMessage("This Request Hop id is not available in database.");
				return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}

			updateHopDoneStatus(lmsWfRequestHop, hopStatus, user);

			responseWrapper.setLmsWfRequestHop(lmsWfRequestHop);
			responseWrapper.setLmsWfRequest(lmsWfRequestHop.getLmsWfRequest());
			responseWrapper.setLmsLeaveApplication(lmsWfRequestHop.getLmsWfRequest().getLmsLeaveApplication());
			responseWrapper.setMessage("Success. Your request Hop is successfully submitted.");
		//	sendmail.SendMail();
			return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper, HttpStatus.OK);
		} catch (Exception ex) {
			responseWrapper.setMessage("Fail." + ex.getMessage());
			return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@RequestMapping(value = "/wftrolebyuser/{userid}/", method = RequestMethod.GET)
	public ResponseEntity<ResponseWrapperWorkFlowManagement> findwftrolebyuser(@PathVariable("userid") Integer userid) {

		ResponseWrapperWorkFlowManagement responseWrapper = new ResponseWrapperWorkFlowManagement();

		try {

			// Validate User
			LmsUser user = lmsUserHome.findById(userid);
			if (user == null) {
				responseWrapper.setMessage("This userid is not available in database.");
				return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper,
						HttpStatus.EXPECTATION_FAILED);
			}

			List<LmsWftRoleUserMap> listLmsWftRoleUserMap = lmsWftRoleUserMapHome.findRoleByUser(user);

			if (listLmsWftRoleUserMap.size() > 0) {
				responseWrapper.setListLmsWftRoleUserMap(listLmsWftRoleUserMap);
				responseWrapper.setMessage("Success. User Work Flow Role Data Found.");
				return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper, HttpStatus.OK);
				
			} else {
				responseWrapper.setMessage("Fail. No record found");
				return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper,
						HttpStatus.EXPECTATION_FAILED);

			}

		} catch (Exception ex) {
			responseWrapper.setMessage("Fail." + ex.getMessage());
			return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper,
					HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	
	@RequestMapping(value = "/approlebyuser/{userid}/", method = RequestMethod.GET)
	public ResponseEntity<ResponseWrapperWorkFlowManagement> findapprolebyuser(@PathVariable("userid") Integer userid) {

		ResponseWrapperWorkFlowManagement responseWrapper = new ResponseWrapperWorkFlowManagement();

		try {

			// Validate User
			LmsUser user = lmsUserHome.findById(userid);
			if (user == null) {
				responseWrapper.setMessage("This userid is not available in database.");
				return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper,
						HttpStatus.EXPECTATION_FAILED);
			}

			List<LmsUserRoleMap> listLmsUserRoleMap = lmsUserRoleMapHome.findRoleByUser(user);

			if (listLmsUserRoleMap.size() > 0) {
				responseWrapper.setListLmsUserRoleMap(listLmsUserRoleMap);
				responseWrapper.setMessage("Success. User Application Role Data Found.");
				return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper, HttpStatus.OK);
				
			} else {
				responseWrapper.setMessage("Fail. No record found");
				return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper,
						HttpStatus.EXPECTATION_FAILED);

			}

		} catch (Exception ex) {
			responseWrapper.setMessage("Fail." + ex.getMessage());
			return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper,
					HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	
	@RequestMapping(value = "/wftdelegationbyuser/{userid}/", method = RequestMethod.GET)
	public ResponseEntity<ResponseWrapperWorkFlowManagement> findwftdelagationbyuser(@PathVariable("userid") Integer userid) {

		ResponseWrapperWorkFlowManagement responseWrapper = new ResponseWrapperWorkFlowManagement();

		try {

			// Validate User
			LmsUser user = lmsUserHome.findById(userid);
			if (user == null) {
				responseWrapper.setMessage("This userid is not available in database.");
				return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper,
						HttpStatus.EXPECTATION_FAILED);
			}

			List<LmsWftRoleUserMap> listLmsWftRoleUserMap = lmsWftRoleUserMapHome.findDelegationByUser(userid);

			if (listLmsWftRoleUserMap.size() > 0) {
				responseWrapper.setListLmsWftRoleUserMap(listLmsWftRoleUserMap);
				responseWrapper.setMessage("Success. Your request Hop is successfully submitted.");
				return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper, HttpStatus.OK);
				
			} else {
				responseWrapper.setMessage("Fail. No record found");
				return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper,
						HttpStatus.EXPECTATION_FAILED);

			}

		} catch (Exception ex) {
			responseWrapper.setMessage("Fail." + ex.getMessage());
			return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper,
					HttpStatus.EXPECTATION_FAILED);
		}
	}

	
	@RequestMapping(value = "/wftrolebydelegateuser/{userid}/", method = RequestMethod.GET)
	public ResponseEntity<ResponseWrapperWorkFlowManagement> findwftrolebydelegateuser(@PathVariable("userid") Integer userid) {

		ResponseWrapperWorkFlowManagement responseWrapper = new ResponseWrapperWorkFlowManagement();

		try {

			// Validate User
			LmsUser user = lmsUserHome.findById(userid);
			if (user == null) {
				responseWrapper.setMessage("This userid is not available in database.");
				return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper,
						HttpStatus.EXPECTATION_FAILED);
			}

			List<LmsWftRoleUserMap> listLmsWftRoleUserMap = lmsWftRoleUserMapHome.findRoleByDelegateUser(user.getId());

			if (listLmsWftRoleUserMap.size() > 0) {
				responseWrapper.setListLmsWftRoleUserMap(listLmsWftRoleUserMap);
				responseWrapper.setMessage("Success. Your request Hop is successfully submitted.");
				return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper, HttpStatus.OK);
				
			} else {
				responseWrapper.setMessage("Fail. No record found");
				return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper,
						HttpStatus.EXPECTATION_FAILED);

			}

		} catch (Exception ex) {
			responseWrapper.setMessage("Fail." + ex.getMessage());
			return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper,
					HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@RequestMapping(value = "/wftrolebydelegateuser/{userid}/{delegateuserid}/{fromDate}/{toDate}", method = RequestMethod.POST)
	public ResponseEntity<ResponseWrapperWorkFlowManagement> insertwftrolebydelegateuser(@PathVariable("userid") Integer userid, @PathVariable("delegateuserid") Integer delegateuserid,
	 @PathVariable("fromDate") Date fromDate, @PathVariable("toDate") Date toDate, @RequestBody List<LmsWftRoleUserMap> listLmsWftRoleUserMap) 
	{

		ResponseWrapperWorkFlowManagement responseWrapper = new ResponseWrapperWorkFlowManagement();

		try {

			LmsWftRoleUserMap lmsWftRoleUserMap = null;
			LmsWftRoleUserMapHistory lmsWftRoleUserMapHistory = null;
			LmsWftRole lmsWftRole = null;
			LmsUser lmsUser = null;
			LmsUser lmsUserDelegatedBy = null;

			for (LmsWftRoleUserMap role : listLmsWftRoleUserMap) {

				lmsWftRoleUserMap = new LmsWftRoleUserMap();
				lmsWftRole = lmsWftRoleHome.findById(role.getLmsWftRole().getId());
				lmsUser = lmsUserHome.findById(delegateuserid);
				lmsUserDelegatedBy=lmsUserHome.findById(userid);
				
				lmsWftRoleUserMap.setLmsWftRole(lmsWftRole);
				lmsWftRoleUserMap.setLmsUserByUserId(lmsUser);
				lmsWftRoleUserMap.setLmsUserByDelegateBy(lmsUserDelegatedBy);
				lmsWftRoleUserMap.setInsertBy(userid);
				lmsWftRoleUserMap.setInsertDate(new Date());
				lmsWftRoleUserMap.setDelegationFrom(fromDate);
				lmsWftRoleUserMap.setDelegationTo(toDate);
				// for insertion in history table
				lmsWftRoleUserMapHistory = new LmsWftRoleUserMapHistory();
				
				lmsWftRoleUserMapHistory.setLmsWftRole(lmsWftRole);
				lmsWftRoleUserMapHistory.setLmsUserByUserId(lmsUser);
				lmsWftRoleUserMapHistory.setLmsUserByDelegateBy(lmsUserDelegatedBy);
				lmsWftRoleUserMapHistory.setInsertBy(userid);
				lmsWftRoleUserMapHistory.setInsertDate(new Date());
				lmsWftRoleUserMapHistory.setDelegationFrom(fromDate);
				lmsWftRoleUserMapHistory.setDelegationTo(toDate);
				

				lmsWftRoleUserMapHome.persist(lmsWftRoleUserMap);
				
				lmsWftRoleUserMapistoryHome.persist(lmsWftRoleUserMapHistory);// insertion in history table
				
			}

			responseWrapper.setMessage("Success. Work Flow Role User Map has inserted successfully.");
			return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper, HttpStatus.OK);

		} catch (Exception ex) {
			responseWrapper.setMessage("Fail." + ex.getMessage());
			return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper,
					HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@RequestMapping(value = "/wftrolebydelegateuser/{userid}/{delegateBy}/", method = RequestMethod.DELETE)
	public ResponseEntity<ResponseWrapperWorkFlowManagement> deletewftrolebydelegateuser(@PathVariable("userid") Integer userid, @PathVariable("delegateBy") Integer delegateBy) {

		ResponseWrapperWorkFlowManagement responseWrapper = new ResponseWrapperWorkFlowManagement();

		try {

			List<LmsWftRoleUserMap> listLmsWftRoleUserMap = lmsWftRoleUserMapHome.findByUserIDAndDelegateID(userid, delegateBy);

			for (LmsWftRoleUserMap lmsWftRoleUserMap : listLmsWftRoleUserMap) {

				lmsWftRoleUserMapHome.remove(lmsWftRoleUserMap);
			}

			responseWrapper.setMessage("Success. Work Flow Role User Map has deleted successfully.");
			return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper, HttpStatus.OK);

		} catch (Exception ex) {
			responseWrapper.setMessage("Fail." + ex.getMessage());
			return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper,
					HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	
	public boolean generateWorkRequest(LmsWftRequestSelector lmsWftRequestSelector, LmsUser user, LmsLeaveApplication leaveApplication) {

		// Insert Request
		LmsWfRequest lmsWfRequest = saveRequest(lmsWftRequestSelector, user, leaveApplication);

		// Insert Request Hop
		if (lmsWfRequest != null) {
			saveHops(lmsWfRequest, user);

			// Find First Hop of this WorkRequest
			LmsWfRequestHop lmsWfRequestHop = findFirstHopForRequest(lmsWfRequest);
			// UpdateHopStatus for First Hop
			if (lmsWfRequestHop != null) {

				// Only for first Hop
				lmsWfRequestHop.setStartDate(new Date());

				updateHopDoneStatus(lmsWfRequestHop, WFSTATUS.DONE.toString(), user);
			}
			return true;
		}else {
			return false;
		}
		
	}

	private LmsWfRequest saveRequest(LmsWftRequestSelector lmsWftRequestSelector, LmsUser user, LmsLeaveApplication leaveApplication) {
		try {
			LmsWfRequest lmsWfRequest = new LmsWfRequest();
			Date currentDate = new Date();

			lmsWfRequest.setLmsWftRequestType(lmsWftRequestSelector.getLmsWftRequestType());
			lmsWfRequest.setStartDate(currentDate);
			lmsWfRequest.setStatus(WFSTATUS.APPLIED.toString());
			lmsWfRequest.setLmsUserByUserId(user);
			lmsWfRequest.setLmsLeaveApplication(leaveApplication);
			lmsWfRequest.setInsertDate(currentDate);
			lmsWfRequest.setInsertBy(user.getId());

			int requestid = lmsWfRequestHome.persist(lmsWfRequest);
			//lmsWfRequestHome.persist(lmsWfRequest);

			lmsWfRequest = lmsWfRequestHome.findById(requestid);
			//lmsWfRequest = lmsWfRequestHome.findRequestByUserAndDate(user.getId(), currentDate);

			if (lmsWfRequest != null) {
				return lmsWfRequest;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	// This is useed to show detail hop information for leave request in rptstatusreport
	// Feroj: 03.06.18
	//service: wfrequesthopService controller: rptleavestatusController
	@RequestMapping(value = "getHopsinfo/{wfrequestid}", method = RequestMethod.GET)
	public ResponseEntity<ResponseWrapper> generateRequest(@PathVariable("wfrequestid") Integer wfrequestid) {

		ResponseWrapper responseWrapper = new ResponseWrapper();

		try {

			List<LmsWfRequestHop> listLmsWfRequestHops = lmsWfRequestHopHome.findWfRequestHopByRequestId(wfrequestid);
		//	List<LmsWfRequestHop> listLmsWfRequestHops;
			if (listLmsWfRequestHops.size() > 0) {
				
				responseWrapper.setMessage("Success. Leave request found.");
				responseWrapper.setListLmsWfRequestHops(listLmsWfRequestHops);
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
				
			} else {
				
				responseWrapper.setMessage("Fail. No record found.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}

		} catch (Exception ex) {
			responseWrapper.setMessage("Fail." + ex.getMessage());
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}
	}

	private void saveHops(LmsWfRequest lmsWfRequest, LmsUser user) {
		try {
			List<LmsWftRequestHopRolePageMap> lmsWftRequestHopRolePageMaps = lmsWftRequestHopRolePageMapHome
					.findRequestHopMapByRequestType(lmsWfRequest.getLmsWftRequestType().getId());

			for (LmsWftRequestHopRolePageMap lmsWftRequestHopRolePageMap : lmsWftRequestHopRolePageMaps) {

				saveHop(lmsWftRequestHopRolePageMap, lmsWfRequest, user);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void saveHop(LmsWftRequestHopRolePageMap lmsWftRequestHopRolePageMap, LmsWfRequest lmsWfRequest,
			LmsUser user) {

		try {
			LmsWfRequestHop lmsWfRequestHop = new LmsWfRequestHop();

			lmsWfRequestHop.setLmsWfRequest(lmsWfRequest);

			lmsWfRequestHop.setLmsWftRequestHopRolePageMap(lmsWftRequestHopRolePageMap);
			lmsWfRequestHop.setWftRoleId(lmsWftRequestHopRolePageMap.getLmsWftRole().getId());
			lmsWfRequestHop.setStatus(WFSTATUS.UPCOMING.toString());
			lmsWfRequestHop.setUserId(user.getId());
			lmsWfRequestHop.setInsertDate(new Date());
			lmsWfRequestHop.setInsertBy(user.getId());
			//lmsWfRequestHop.setPageId(lmsWftRequestHopRolePageMap.getLmsPages().getId());

			lmsWfRequestHopHome.persist(lmsWfRequestHop);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public void updateHopDoneStatus(LmsWfRequestHop lmsWfRequestHop, String hopStatus, LmsUser user) {

		try {

			if (hopStatus.contains(WFSTATUS.REJECTED.toString())) {
				lmsWfRequestHop.setStatus(WFSTATUS.REJECTED.toString());
			} else {
				lmsWfRequestHop.setStatus(WFSTATUS.DONE.toString());
			}
			
			lmsWfRequestHop.setEndDate(new Date());			
			lmsWfRequestHop.setUpdateDate(new Date());
			lmsWfRequestHop.setLmsUser(user);

			lmsWfRequestHopHome.merge(lmsWfRequestHop);

			updateHopCurrentStatus(lmsWfRequestHop.getLmsWfRequest(), user);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	// Update lms_wf_request_hop table
	protected void updateHopCurrentStatus(LmsWfRequest lmsWfRequest, LmsUser user) {

		
		try {

			if (updateRequestStatus(lmsWfRequest, user)) {
				return;
			}
			
			List<LmsWfRequestHop> lmsWfRequestHops = lmsWfRequestHopHome.findWfRequestHopByRequestId(lmsWfRequest.getId());

			for (LmsWfRequestHop lmsWfRequestHop : lmsWfRequestHops) {

				if (lmsWfRequestHop.getStatus().contains(WFSTATUS.UPCOMING.toString())
						|| lmsWfRequestHop.getStatus() == null) {

					List<LmsWftFlowControl> flows = lmsWftFlowControlHome
							.findWftFlowControlByWftHopid(lmsWfRequestHop.getLmsWftRequestHopRolePageMap().getId());

					if (flows.size() < 1) {

						lmsWfRequestHop.setStartDate(new Date());
						lmsWfRequestHop.setStatus(WFSTATUS.CURRENT.toString());

						lmsWfRequestHopHome.merge(lmsWfRequestHop);
					} else {

						boolean parentDone = true;

						for (LmsWftFlowControl lmsWftFlowControl : flows) {

							for (LmsWfRequestHop parentHop : lmsWfRequestHopHome
									.findWfRequestHopByRequestIdAndRequestHopId(lmsWfRequest.getId(), lmsWftFlowControl
											.getLmsWftRequestHopRolePageMapByTrhmDependedHopsId().getId())) {

								if (!parentHop.getStatus().contains(WFSTATUS.DONE.toString())) {

									parentDone = false;
								}
							}
						}
						if (parentDone) {

							lmsWfRequestHop.setStartDate(new Date());
							lmsWfRequestHop.setStatus(WFSTATUS.CURRENT.toString());

							lmsWfRequestHopHome.merge(lmsWfRequestHop);
							List<LmsWftRoleUserMap> listLmsWftRoleUserMap = lmsWftRoleUserMapHome.findByRoleId(lmsWfRequestHop.getWftRoleId());
							//String  Finalemail = lmsWftRoleUserMap.getLmsUserByUserId().getEmail();
							
							/*if (listLmsWftRoleUserMap.size()> 1) {*/
								String email="";
								String Finalemail="";
								String Oldemail="";
							for (LmsWftRoleUserMap lmsWftRoleUserMap : listLmsWftRoleUserMap) {
								
								email = lmsWftRoleUserMap.getLmsUserByUserId().getEmail();
								Oldemail =email;
								Finalemail =   Oldemail.concat(",").concat(Finalemail);
										
						}	
							Finalemail=replaceLast(",", "", Finalemail);	
							String flag="request";	
							// sending mail to current approver
							SendMail sendmail= new SendMail();
							sendmail.SendMailForApproval(Finalemail,flag);
						}
					}
				}
			}
		} catch (Exception ex) {

			ex.printStackTrace();

		}
	}
	// Replace last occurance of a string with required value
	public static String replaceLast(String find, String replace, String string) {
        int lastIndex = string.lastIndexOf(find);
        
        if (lastIndex == -1) {
            return string;
        }
        
        String beginString = string.substring(0, lastIndex);
        String endString = string.substring(lastIndex + find.length());
        
        return beginString + replace + endString;
    }

	// Update lms_wf_request table
	protected boolean updateRequestStatus(LmsWfRequest lmsWfRequest, LmsUser user) {
		
		String requestStatus = "";
		boolean requestComplete = false;
		
		try {
			
			List<LmsWfRequestHop> lmsWfRequestHops = lmsWfRequestHopHome.findWfRequestHopByRequestId(lmsWfRequest.getId());

			for (LmsWfRequestHop lmsWfRequestHop : lmsWfRequestHops) {
				if (lmsWfRequestHop.getStatus().contains(WFSTATUS.DONE.toString())) {
					requestStatus = WFSTATUS.APPROVED.toString();
					requestComplete = true;
					
					//sendMail()
				} else if (lmsWfRequestHop.getStatus().contains(WFSTATUS.CURRENT.toString())) {
					requestStatus = WFSTATUS.INPROGRESS.toString();
					requestComplete = false;
				} else if (lmsWfRequestHop.getStatus().contains(WFSTATUS.UPCOMING.toString())) {
					requestStatus = WFSTATUS.INPROGRESS.toString();
					requestComplete = false;
				} else if (lmsWfRequestHop.getStatus().contains(WFSTATUS.REJECTED.toString())) {
					requestStatus = WFSTATUS.REJECTED.toString();
					requestComplete = true;
					
					//sendMail();
					break;
				}
			}
			lmsWfRequest.setStatus(requestStatus);
			lmsWfRequest.setUpdateDate(new Date());
			lmsWfRequest.setLmsUserByUpdateBy(user);
			
		if (requestStatus.equals(WFSTATUS.APPROVED.toString())
					|| requestStatus.equals(WFSTATUS.REJECTED.toString())) {

				lmsWfRequest.setEndDate(new Date());
				
			}
		lmsWfRequestHome.merge(lmsWfRequest);
		
		// Sending mail to user to notify whether leave is approved or rejected
		SendMail sendmail= new SendMail();
		
		if (requestStatus.equals(WFSTATUS.APPROVED.toString())) {
				String email = lmsWfRequest.getLmsUserByUserId().getEmail();
				String flag="approve";
				SendMail.SendMailForApproval(email, flag);
				//lmsWfRequest.setEndDate(new Date());
			}
			else if(requestStatus.equals(WFSTATUS.REJECTED.toString())) {
				String email = lmsWfRequest.getLmsUserByUserId().getEmail();
				String flag="reject";
				// sending mail to user to inform rejection
				SendMail.SendMailForApproval(email, flag);
				//lmsWfRequest.setEndDate(new Date());
			}
			
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
		return requestComplete;
	}
	
	protected LmsWfRequestHop findFirstHopForRequest(LmsWfRequest lmsWfRequest) {

		LmsWfRequestHop wfRequestFirstHop = new LmsWfRequestHop();
		
		try {
			List<LmsWfRequestHop> lmsWfRequestHops = lmsWfRequestHopHome.findWfRequestHopByRequestId(lmsWfRequest.getId());

			for (LmsWfRequestHop lmsWfRequestHop : lmsWfRequestHops) {

				if (lmsWfRequestHop.getStatus().contains(WFSTATUS.UPCOMING.toString())|| lmsWfRequestHop.getStatus() == null) {

					List<LmsWftFlowControl> flows = lmsWftFlowControlHome.findWftFlowControlByWftHopid(lmsWfRequestHop.getLmsWftRequestHopRolePageMap().getId());

					if (flows.size() < 1) {

						wfRequestFirstHop = lmsWfRequestHop;
						break;
					}
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return wfRequestFirstHop;
	}
}
