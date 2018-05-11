package com.web.lms.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import com.web.lms.dao.LmsWfRequestHome;
import com.web.lms.dao.LmsWfRequestHopHome;
import com.web.lms.dao.LmsWftFlowControlHome;
import com.web.lms.dao.LmsWftRequestHopRolePageMapHome;
import com.web.lms.dao.LmsWftRequestSelectorHome;
import com.web.lms.dao.LmsWftRoleHome;
import com.web.lms.dao.LmsWftRoleUserMapHome;
import com.web.lms.enumcollection.WFSTATUS;
import com.web.lms.model.LmsHolidayRecord;
import com.web.lms.model.LmsLeaveApplication;
import com.web.lms.model.LmsLeaveType;
import com.web.lms.model.LmsUser;
import com.web.lms.model.LmsWfRequest;
import com.web.lms.model.LmsWfRequestHop;
import com.web.lms.model.LmsWftFlowControl;
import com.web.lms.model.LmsWftRequestHopRolePageMap;
import com.web.lms.model.LmsWftRequestSelector;
import com.web.lms.model.LmsWftRole;
import com.web.lms.model.LmsWftRoleUserMap;
import com.web.lms.wrapper.ResponseWrapper;
import com.web.lms.wrapper.ResponseWrapperWorkFlowManagement;

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
	private LmsWftRoleHome lmsWftRoleHome;

	@RequestMapping(value = "/generaterequest/{userid}/{leavetypeid}/{leaveapplicationid}", method = RequestMethod.POST)
	public ResponseEntity<ResponseWrapperWorkFlowManagement> generateRequest(@PathVariable("userid") Integer userid,
			@PathVariable("leavetypeid") Integer leavetypeid,@PathVariable("leaveapplicationid") Integer leaveapplicationid) {

		ResponseWrapperWorkFlowManagement responseWrapper = new ResponseWrapperWorkFlowManagement();
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

			generateWorkRequest(lmsWftRequestSelector, user, leaveApplication);

			responseWrapper.setMessage("Success. Your request is successfully generated.");
			return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper, HttpStatus.OK);
		} catch (Exception ex) {
			responseWrapper.setMessage("Fail." + ex.getMessage());
			return new ResponseEntity<ResponseWrapperWorkFlowManagement>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "/updaterequesthope/{userid}/{WfRequestHopid}/{hopStatus}", method = RequestMethod.PUT)
	public ResponseEntity<ResponseWrapperWorkFlowManagement> updateRequestHope(@PathVariable("userid") Integer userid,
			@PathVariable("WfRequestHopid") Integer WfRequestHopid, @PathVariable("hopStatus") String hopStatus, @RequestBody LmsWfRequestHop wfRequestHop) {

		ResponseWrapperWorkFlowManagement responseWrapper = new ResponseWrapperWorkFlowManagement();

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

			responseWrapper.setMessage("Success. Your request Hop is successfully submitted.");
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
	
	@RequestMapping(value = "/wftrolebydelegateuser/{userid}/{delegateuserid}/", method = RequestMethod.POST)
	public ResponseEntity<ResponseWrapperWorkFlowManagement> insertwftrolebydelegateuser(@PathVariable("userid") Integer userid, @PathVariable("delegateuserid") Integer delegateuserid,
			@RequestBody List<LmsWftRoleUserMap> listLmsWftRoleUserMap) 
	{

		ResponseWrapperWorkFlowManagement responseWrapper = new ResponseWrapperWorkFlowManagement();

		try {

			LmsWftRoleUserMap lmsWftRoleUserMap = null;
			LmsWftRole lmsWftRole = null;
			LmsUser lmsUser = null;

			for (LmsWftRoleUserMap role : listLmsWftRoleUserMap) {

				lmsWftRoleUserMap = new LmsWftRoleUserMap();
				lmsWftRole = lmsWftRoleHome.findById(role.getLmsWftRole().getId());
				lmsUser = lmsUserHome.findById(delegateuserid);

				lmsWftRoleUserMap.setLmsWftRole(lmsWftRole);
				lmsWftRoleUserMap.setLmsUser(lmsUser);
				lmsWftRoleUserMap.setDelegateBy(userid);
				lmsWftRoleUserMap.setInsertBy(userid);
				lmsWftRoleUserMap.setInsertDate(new Date());

				lmsWftRoleUserMapHome.persist(lmsWftRoleUserMap);
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
	
	
	public void generateWorkRequest(LmsWftRequestSelector lmsWftRequestSelector, LmsUser user, LmsLeaveApplication leaveApplication) {

		// Insert Request
		LmsWfRequest lmsWfRequest = saveRequest(lmsWftRequestSelector, user, leaveApplication);

		// Insert Request Hop
		saveHops(lmsWfRequest, user);

		// Find First Hop of this WorkRequest
		LmsWfRequestHop lmsWfRequestHop = findFirstHopForRequest(lmsWfRequest);
		// UpdateHopStatus for First Hop
		if (lmsWfRequestHop != null) {
			
			// Only for first Hop
			lmsWfRequestHop.setStartDate(new Date());
			
			updateHopDoneStatus(lmsWfRequestHop, WFSTATUS.DONE.toString(), user);
		}
		
	}

	private LmsWfRequest saveRequest(LmsWftRequestSelector lmsWftRequestSelector, LmsUser user, LmsLeaveApplication leaveApplication) {
		try {
			LmsWfRequest lmsWfRequest = new LmsWfRequest();
			Date currentDate = new Date();

			lmsWfRequest.setLmsWftRequestType(lmsWftRequestSelector.getLmsWftRequestHopRolePageMap().getLmsWftRequestType());
			lmsWfRequest.setStartDate(currentDate);
			lmsWfRequest.setStatus(WFSTATUS.APPLIED.toString());
			lmsWfRequest.setLmsUser(user);
			lmsWfRequest.setLmsLeaveApplication(leaveApplication);
			lmsWfRequest.setInsertDate(currentDate);
			lmsWfRequest.setInsertBy(user.getId());

			lmsWfRequestHome.persist(lmsWfRequest);
			//lmsWfRequestHome.persist(lmsWfRequest);

			lmsWfRequest = lmsWfRequestHome.findRequestByUserAndDate(user.getId(), currentDate);

			if (lmsWfRequest != null) {
				return lmsWfRequest;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
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
			lmsWfRequestHop.setUpdateBy(user.getId());

			lmsWfRequestHopHome.merge(lmsWfRequestHop);

			updateHopCurrentStatus(lmsWfRequestHop.getLmsWfRequest());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void updateHopCurrentStatus(LmsWfRequest lmsWfRequest) {

		try {

			if (updateRequestStatus(lmsWfRequest)) {
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
						}
					}
				}
			}
		} catch (Exception ex) {

			ex.printStackTrace();

		}
	}

	protected boolean updateRequestStatus(LmsWfRequest lmsWfRequest) {
		
		String requestStatus = "";
		boolean requestComplete = false;
		
		try {
			
			List<LmsWfRequestHop> lmsWfRequestHops = lmsWfRequestHopHome.findWfRequestHopByRequestId(lmsWfRequest.getId());

			for (LmsWfRequestHop lmsWfRequestHop : lmsWfRequestHops) {
				if (lmsWfRequestHop.getStatus().contains(WFSTATUS.DONE.toString())) {
					requestStatus = WFSTATUS.APPROVED.toString();
					requestComplete = true;
				} else if (lmsWfRequestHop.getStatus().contains(WFSTATUS.CURRENT.toString())) {
					requestStatus = WFSTATUS.INPROGRESS.toString();
					requestComplete = false;
				} else if (lmsWfRequestHop.getStatus().contains(WFSTATUS.UPCOMING.toString())) {
					requestStatus = WFSTATUS.INPROGRESS.toString();
					requestComplete = false;
				} else if (lmsWfRequestHop.getStatus().contains(WFSTATUS.REJECTED.toString())) {
					requestStatus = WFSTATUS.REJECTED.toString();
					requestComplete = true;
					break;
				}
			}
			lmsWfRequest.setStatus(requestStatus);
			
			if (requestStatus.equals(WFSTATUS.APPROVED.toString())
					|| requestStatus.equals(WFSTATUS.REJECTED.toString())) {

				lmsWfRequest.setEndDate(new Date());
			}

			lmsWfRequestHome.merge(lmsWfRequest);
			
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
	
	private void findHoliday() {
		
		try {
			
		  String input_date="01/08/2012";
		  SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
		  Date dt1=format1.parse(input_date);
		  DateFormat format2=new SimpleDateFormat("EEEE"); 
		  String finalDay=format2.format(dt1);
		  
		}catch(Exception ex) {		
			
			
		}
		
	}
}
