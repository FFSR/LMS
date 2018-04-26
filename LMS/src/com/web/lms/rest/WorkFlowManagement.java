package com.web.lms.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.lms.dao.LmsLeaveTypeHome;
import com.web.lms.dao.LmsUserHome;
import com.web.lms.dao.LmsWfRequestHome;
import com.web.lms.dao.LmsWfRequestHopHome;
import com.web.lms.dao.LmsWftFlowControlHome;
import com.web.lms.dao.LmsWftRequestHopRolePageMapHome;
import com.web.lms.dao.LmsWftRequestSelectorHome;
import com.web.lms.enumcollection.WFSTATUS;
import com.web.lms.model.LmsLeaveType;
import com.web.lms.model.LmsUser;
import com.web.lms.model.LmsWfRequest;
import com.web.lms.model.LmsWfRequestHop;
import com.web.lms.model.LmsWftFlowControl;
import com.web.lms.model.LmsWftRequestHopRolePageMap;
import com.web.lms.model.LmsWftRequestSelector;
import com.web.lms.wrapper.ResponseWrapper;

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

	
	@RequestMapping(value = "/generaterequest/{userid}/{leavetypeid}", method = RequestMethod.POST)
	public ResponseEntity<ResponseWrapper> generateRequest(@PathVariable("userid") Integer userid,
			@PathVariable("leavetypeid") Integer leavetypeid) {

		ResponseWrapper responseWrapper = new ResponseWrapper();

		try {

			// Validate User
			LmsUser user = lmsUserHome.findById(userid);
			if (user == null) {
				responseWrapper.setMessage("This userid is not available in database.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}

			// Validate Leave Type
			LmsLeaveType leaveType = lmsLeaveTypeHome.findById(leavetypeid);

			if (leaveType == null) {
				responseWrapper.setMessage("This Leave Type is not available in database.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}

			// Find request type
			LmsWftRequestSelector lmsWftRequestSelector = LmsWftRequestSelectorHome
					.findRequestTypeByClassSectorLeaveType(user.getLmsDesignation().getLmsClass().getId(),
							user.getLmsSection().getId(), leaveType.getId());

			if (lmsWftRequestSelector == null) {

				responseWrapper.setMessage("This is no Request Type matched from Request Selector table.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}

			generateWorkRequest(lmsWftRequestSelector, user);

			responseWrapper.setMessage("Success. Your request is successfully generated.");
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		} catch (Exception ex) {
			responseWrapper.setMessage("Fail." + ex.getMessage());
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "/updaterequesthope/{userid}/{WfRequestHopid}/{hopStatus}", method = RequestMethod.PUT)
	public ResponseEntity<ResponseWrapper> updateRequestHope(@PathVariable("userid") Integer userid,
			@PathVariable("WfRequestHopid") Integer WfRequestHopid, @PathVariable("hopStatus") String hopStatus) {

		ResponseWrapper responseWrapper = new ResponseWrapper();

		try {

			// Validate User
			LmsUser user = lmsUserHome.findById(userid);
			if (user == null) {
				responseWrapper.setMessage("This userid is not available in database.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}

			// Validate Leave Type
			LmsWfRequestHop lmsWfRequestHop = lmsWfRequestHopHome.findById(WfRequestHopid);

			if (lmsWfRequestHop == null) {
				responseWrapper.setMessage("This Request Hop id is not available in database.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}

			updateHopDoneStatus(lmsWfRequestHop, hopStatus, user);

			responseWrapper.setMessage("Success. Your request Hop is successfully submitted.");
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		} catch (Exception ex) {
			responseWrapper.setMessage("Fail." + ex.getMessage());
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	public void generateWorkRequest(LmsWftRequestSelector lmsWftRequestSelector, LmsUser user) {

		// Insert Request
		LmsWfRequest lmsWfRequest = saveRequest(lmsWftRequestSelector, user);

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

	private LmsWfRequest saveRequest(LmsWftRequestSelector lmsWftRequestSelector, LmsUser user) {
		try {
			LmsWfRequest lmsWfRequest = new LmsWfRequest();
			Date currentDate = new Date();

			lmsWfRequest.setLmsWftRequestType(lmsWftRequestSelector.getLmsWftRequestHopRolePageMap().getLmsWftRequestType());
			lmsWfRequest.setStartDate(currentDate);
			lmsWfRequest.setStatus(WFSTATUS.APPLIED.toString());
			lmsWfRequest.setLmsUser(user);
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
}
