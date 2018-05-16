package com.web.lms.rest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.lms.dao.LmsLeaveBalanceHome;
import com.web.lms.dao.LmsLeaveTypeHome;
import com.web.lms.dao.LmsUserHome;
import com.web.lms.enumcollection.LEAVETYPE;
import com.web.lms.model.LmsLeaveBalance;
import com.web.lms.model.LmsLeaveType;
import com.web.lms.model.LmsUser;
import com.web.lms.wrapper.ResponseWrapper;
import com.web.lms.wrapper.ResponseWrapperLeaveRule;

@RestController
public class Leavebalance {

	@Autowired
	private LmsUserHome lmsUserHome;
	@Autowired
	private LmsLeaveTypeHome lmsLeaveTypeHome;
	@Autowired
	private LmsLeaveBalanceHome lmsLeaveBalanceHome;
	@Autowired
	private HttpSession httpSession;

	@RequestMapping(value = "/leavehistory/{userID}/", method = RequestMethod.GET)
	public ResponseEntity<ResponseWrapper> leavehistory(@PathVariable Integer userID) {

		ResponseWrapper responseWrapper = new ResponseWrapper();
		List<LmsLeaveBalance> lmsLeaveBalances = lmsLeaveBalanceHome.findLeaveBalanceByUserID(userID);

		if (lmsLeaveBalances.size() > 0) {

			responseWrapper.setListLmsLeaveBalance(lmsLeaveBalances);

			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		}

		responseWrapper.setMessage("Fail. User Name or Password not matched.");
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
	}
	
	@RequestMapping(value = "/leavebalanceforapply/{userid}/{leavetypeid}/{leavetaken}/", method = RequestMethod.PUT)
	public ResponseEntity<ResponseWrapperLeaveRule> leaveBalanceForApply(@PathVariable Integer userid, @PathVariable Integer leavetypeid, @PathVariable Integer leavetaken) {

		ResponseWrapperLeaveRule responseWrapper = new ResponseWrapperLeaveRule();
		LmsLeaveBalance lmsLeaveBalance = null;

		try {

			// Validate User
			LmsUser user = null;
			user = lmsUserHome.findById(userid);

			if (user == null) {
				responseWrapper.setMessage("This userid is not available in database.");
				return new ResponseEntity<ResponseWrapperLeaveRule>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}

			// Validate Leave Type
			LmsLeaveType leaveType = null;
			leaveType = lmsLeaveTypeHome.findById(leavetypeid);

			if (leaveType == null) {
				responseWrapper.setMessage("This Leave Type is not available in database.");
				return new ResponseEntity<ResponseWrapperLeaveRule>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}

			lmsLeaveBalance = findLeaveBalanceCurrent(user, leaveType);

			if (lmsLeaveBalance != null) {
				
				// update with Leave taken
				lmsLeaveBalance.setLeaveApplied(lmsLeaveBalance.getLeaveApplied()+leavetaken);				

				lmsLeaveBalanceHome.merge(lmsLeaveBalance);
				
				responseWrapper.setLmsLeaveBalance(lmsLeaveBalance);
				responseWrapper.setMessage("Success. Leave Balance record has updated.");
				return new ResponseEntity<ResponseWrapperLeaveRule>(responseWrapper, HttpStatus.OK);
			} else {
				responseWrapper.setMessage("Fail. Leave Balance record is not available.");
				return new ResponseEntity<ResponseWrapperLeaveRule>(responseWrapper, HttpStatus.EXPECTATION_FAILED);

			}

		} catch (Exception ex) {
			responseWrapper.setMessage("Fail." + ex.getMessage());
			return new ResponseEntity<ResponseWrapperLeaveRule>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@RequestMapping(value = "/leavebalanceforapprove/{userid}/{leavetypeid}/{leaveapprove}/", method = RequestMethod.PUT)
	public ResponseEntity<ResponseWrapperLeaveRule> leaveBalanceForApprove(@PathVariable Integer userid, @PathVariable Integer leavetypeid,@PathVariable Integer leaveapprove) {

		ResponseWrapperLeaveRule responseWrapper = new ResponseWrapperLeaveRule();
		LmsLeaveBalance lmsLeaveBalance = null;

		try {

			// Validate User
			LmsUser user = null;
			user = lmsUserHome.findById(userid);

			if (user == null) {
				responseWrapper.setMessage("This userid is not available in database.");
				return new ResponseEntity<ResponseWrapperLeaveRule>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}

			// Validate Leave Type
			LmsLeaveType leaveType = null;
			leaveType = lmsLeaveTypeHome.findById(leavetypeid);

			if (leaveType == null) {
				responseWrapper.setMessage("This Leave Type is not available in database.");
				return new ResponseEntity<ResponseWrapperLeaveRule>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}

			lmsLeaveBalance = findLeaveBalanceCurrent(user, leaveType);

			if (lmsLeaveBalance != null) {
				
				// subtract from Leave Applied
				lmsLeaveBalance.setLeaveApplied(lmsLeaveBalance.getLeaveApplied()-leaveapprove);
				// Add to Leave Taken
				lmsLeaveBalance.setLeaveTaken(lmsLeaveBalance.getLeaveTaken()+leaveapprove);
				// Update from Leave Balance
				lmsLeaveBalance.setLeaveBalance(lmsLeaveBalance.getLeaveTotal()-lmsLeaveBalance.getLeaveTaken());
				
				lmsLeaveBalanceHome.merge(lmsLeaveBalance);
				
				responseWrapper.setLmsLeaveBalance(lmsLeaveBalance);
				responseWrapper.setMessage("Success. Leave Balance record has updated.");
				return new ResponseEntity<ResponseWrapperLeaveRule>(responseWrapper, HttpStatus.OK);
			} else {
				responseWrapper.setMessage("Fail. Leave Balance record is not available.");
				return new ResponseEntity<ResponseWrapperLeaveRule>(responseWrapper, HttpStatus.EXPECTATION_FAILED);

			}

		} catch (Exception ex) {
			responseWrapper.setMessage("Fail." + ex.getMessage());
			return new ResponseEntity<ResponseWrapperLeaveRule>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@RequestMapping(value = "/leavebalanceforreject/{userid}/{leavetypeid}/{leaverejected}/", method = RequestMethod.PUT)
	public ResponseEntity<ResponseWrapperLeaveRule> leaveBalanceForReject(@PathVariable Integer userid, @PathVariable Integer leavetypeid, @PathVariable Integer leaverejected) {

		ResponseWrapperLeaveRule responseWrapper = new ResponseWrapperLeaveRule();
		LmsLeaveBalance lmsLeaveBalance = null;

		try {

			// Validate User
			LmsUser user = null;
			user = lmsUserHome.findById(userid);

			if (user == null) {
				responseWrapper.setMessage("This userid is not available in database.");
				return new ResponseEntity<ResponseWrapperLeaveRule>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}

			// Validate Leave Type
			LmsLeaveType leaveType = null;
			leaveType = lmsLeaveTypeHome.findById(leavetypeid);

			if (leaveType == null) {
				responseWrapper.setMessage("This Leave Type is not available in database.");
				return new ResponseEntity<ResponseWrapperLeaveRule>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}

			lmsLeaveBalance = findLeaveBalanceCurrent(user, leaveType);

			if (lmsLeaveBalance != null) {
				
				// subtract from Leave Applied
				lmsLeaveBalance.setLeaveApplied(lmsLeaveBalance.getLeaveApplied()-leaverejected);
				
				lmsLeaveBalanceHome.merge(lmsLeaveBalance);
				
				responseWrapper.setLmsLeaveBalance(lmsLeaveBalance);
				responseWrapper.setMessage("Success. Leave Balance record has updated.");
				return new ResponseEntity<ResponseWrapperLeaveRule>(responseWrapper, HttpStatus.OK);
			} else {
				responseWrapper.setMessage("Fail. Leave Balance record is not available.");
				return new ResponseEntity<ResponseWrapperLeaveRule>(responseWrapper, HttpStatus.EXPECTATION_FAILED);

			}

		} catch (Exception ex) {
			responseWrapper.setMessage("Fail." + ex.getMessage());
			return new ResponseEntity<ResponseWrapperLeaveRule>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	private LmsLeaveBalance findLeaveBalanceCurrent(LmsUser user, LmsLeaveType leaveType) {

		LmsLeaveBalance lmsLeaveBalance = null;

		try {
			if (leaveType.getDependentLeaveAc() != null	&& leaveType.getDependentLeaveAc() != 0) { 

				// Validate Leave Type
				LmsLeaveType leaveTypeDependentLeaveAc = lmsLeaveTypeHome.findById(leaveType.getDependentLeaveAc());

				if (leaveTypeDependentLeaveAc != null) {

					lmsLeaveBalance = lmsLeaveBalanceHome.findLeavebalacebyUserAndLeaveTypeAndACStatus(user.getId(), leaveTypeDependentLeaveAc.getId(), LEAVETYPE.CURRENT.toString());
				}

			} else {
				lmsLeaveBalance = lmsLeaveBalanceHome.findLeavebalacebyUserAndLeaveTypeAndACStatus(user.getId(),leaveType.getId(), LEAVETYPE.CURRENT.toString());
			}
			return lmsLeaveBalance;
		} catch (Exception ex) {
			ex.printStackTrace();
			return lmsLeaveBalance;
		}
	}

}
