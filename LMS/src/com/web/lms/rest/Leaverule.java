package com.web.lms.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.lms.dao.LmsHolidayRecordHome;
import com.web.lms.dao.LmsLeaveApplicationHome;
import com.web.lms.dao.LmsLeaveBalanceHome;
import com.web.lms.dao.LmsLeaveTypeHome;
import com.web.lms.dao.LmsUserHome;
import com.web.lms.enumcollection.DAY;
import com.web.lms.enumcollection.DECISION;
import com.web.lms.enumcollection.LEAVETYPE;
import com.web.lms.model.LmsHolidayRecord;
import com.web.lms.model.LmsLeaveApplication;
import com.web.lms.model.LmsLeaveBalance;
import com.web.lms.model.LmsLeaveType;
import com.web.lms.model.LmsUser;
import com.web.lms.wrapper.ResponseWrapperLeaveRule;

@RestController
public class Leaverule {

	@Autowired
	private LmsUserHome lmsUserHome;
	@Autowired
	private LmsLeaveTypeHome lmsLeaveTypeHome;
	@Autowired
	private LmsLeaveBalanceHome lmsLeaveBalanceHome;
	@Autowired
	private LmsLeaveApplicationHome lmsLeaveApplicationHome;
	@Autowired
	private LmsHolidayRecordHome lmsHolidayRecordHome;

	@RequestMapping(value = "/leaverule/{userid}/{leavetypeid}/{startdate}/{enddate}/", method = RequestMethod.GET)
	public ResponseEntity<ResponseWrapperLeaveRule> generateRequest(@PathVariable("userid") Integer userid,
			@PathVariable("leavetypeid") Integer leavetypeid, @PathVariable("startdate") String strstartdate,
			@PathVariable("enddate") String strenddate) {

		ResponseWrapperLeaveRule resWrapper = new ResponseWrapperLeaveRule();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		try {

			Date startDate = format.parse(strstartdate);
			Date endDate = format.parse(strenddate);

			// Validate User
			LmsUser user = null;
			user = lmsUserHome.findById(userid);

			if (user == null) {
				resWrapper.setMessage("This userid is not available in database.");
				return new ResponseEntity<ResponseWrapperLeaveRule>(resWrapper, HttpStatus.EXPECTATION_FAILED);
			}

			// Validate Leave Type
			LmsLeaveType leaveType = null;
			leaveType = lmsLeaveTypeHome.findById(leavetypeid);

			if (leaveType == null) {
				resWrapper.setMessage("This Leave Type is not available in database.");
				return new ResponseEntity<ResponseWrapperLeaveRule>(resWrapper, HttpStatus.EXPECTATION_FAILED);
			}

			// Validate Date : Start date is Null
			if (startDate == null) {
				resWrapper.setMessage("Start date is Null.");
				return new ResponseEntity<ResponseWrapperLeaveRule>(resWrapper, HttpStatus.EXPECTATION_FAILED);
			}

			// Validate Date : End date is Null
			if (endDate == null) {
				resWrapper.setMessage("End date is Null.");
				return new ResponseEntity<ResponseWrapperLeaveRule>(resWrapper, HttpStatus.EXPECTATION_FAILED);
			}

			// Validate Date : End date is advanced than start date
			int dateValidator = startDate.compareTo(endDate);
			if (dateValidator > 0) {
				resWrapper.setMessage("Enddate is advanced than startdate.");
				return new ResponseEntity<ResponseWrapperLeaveRule>(resWrapper, HttpStatus.EXPECTATION_FAILED);
			}

			resWrapper = validateWithLeaveRule(user, leaveType, startDate, endDate);

			if (resWrapper.getMessage().contains("OK")) {

				resWrapper.setMessage("Success. Leave rule validation complete.");
				return new ResponseEntity<ResponseWrapperLeaveRule>(resWrapper, HttpStatus.OK);

			} else {

				return new ResponseEntity<ResponseWrapperLeaveRule>(resWrapper, HttpStatus.EXPECTATION_FAILED);
			}

		} catch (Exception ex) {
			resWrapper.setMessage("Fail." + ex.getMessage());
			return new ResponseEntity<ResponseWrapperLeaveRule>(resWrapper, HttpStatus.EXPECTATION_FAILED);
		}
	}

	private ResponseWrapperLeaveRule validateWithLeaveRule(LmsUser user, LmsLeaveType leaveType, Date startDate, Date endDate) {
		
		ResponseWrapperLeaveRule resWrapper = new ResponseWrapperLeaveRule();

		LmsLeaveBalance lmsLeaveBalance = null;

		try {

			// find the current year
			Date currentDate = new Date(); // current date
			Calendar cal = Calendar.getInstance();
			cal.setTime(currentDate);
			int year = cal.get(Calendar.YEAR);
			String strCurrentYear = Integer.toString(year);
			// int month = cal.get(Calendar.MONTH);
			// int day = cal.get(Calendar.DAY_OF_MONTH);

			// find first date of current year
			Calendar cal2 = Calendar.getInstance();
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.DAY_OF_YEAR, 1);
			Date firstDateOfCurrentYesr = cal.getTime();
			
			//boolean isHoliday = findHoliday(currentDate);
			
			// rest wrapper has initialize from this method
			resWrapper = findHolidayRange(startDate, endDate);
			resWrapper.setMessage("OK");
				
			// 1 day added for start and end date are same
			long numberOfDaysApplied = calculateDateDifference(startDate, endDate) + 1;

				
			// Validation 0.1 : Leave Balance is not found for this Leave Type. Leave Balance account may change for dependent leave account.
			lmsLeaveBalance = findLeaveBalanceCurrent(user, leaveType);
			
			if (lmsLeaveBalance == null) {
				resWrapper.setMessage("Validation 0.1 : Leave Balance is not found for this Leave Type.");
				return resWrapper;
			}
			
			// number of leave will be added based on ImpactOnEarnedLeave flag
			if(leaveType.getImpactOnHoliday()!=null && leaveType.getImpactOnHoliday().equals(DECISION.YES.toString())) {
				
				resWrapper.setNumberOfDaysApplied(numberOfDaysApplied);
				resWrapper.setNumberOfDayConsider( (int) numberOfDaysApplied + resWrapper.getMinimumHolidayConsider());
				
			}else {
				
				resWrapper.setNumberOfDaysApplied(numberOfDaysApplied);
				resWrapper.setNumberOfDayConsider((int) numberOfDaysApplied);				
			}

			// Validation 1: Maximum Leave limit exceed.
			if (leaveType.getMaximumDays() != null && leaveType.getMaximumDays() != 0) {

				if (leaveType.getMaximumDays() > (lmsLeaveBalance.getLeaveTaken() + lmsLeaveBalance.getLeaveApplied()
						+ numberOfDaysApplied)) {
					
					resWrapper.setMessage("Validation 1.0: Maximum Leave limit exceed.");
					return resWrapper;
				}
			}

			// Validation 2: Maximum times limit exceed.
			else if (leaveType.getMaximumTimes() != null && leaveType.getMaximumTimes() != 0) {

				List<LmsLeaveApplication> leaveApplications = lmsLeaveApplicationHome
						.findLeaveApplicationByUserandLeaveTypeandYear(user.getId(), leaveType.getId(), strCurrentYear);

				if (leaveType.getMaximumTimes() > leaveApplications.size()) {
					
					resWrapper.setMessage("Validation 2.0: Maximum times limit exceed.");
					return resWrapper;
				}
			}

			// Validation 3: Maximum leaves at a time limit exceed.
			else if (leaveType.getMaximumAtATime() != null && leaveType.getMaximumAtATime() != 0) {

				if (leaveType.getMaximumAtATime() < numberOfDaysApplied) {
				
					resWrapper.setMessage("Validation 3.0: Maximum leaves at a time limit exceed.");
					return resWrapper;
				}
			}

			// Validation 4: Eligibility requirement, number of days from Joining date does
			// not full filled.
			else if (leaveType.getEligibleAfter() != null && leaveType.getEligibleAfter() != 0) {

				if (user.getJoiningDate() == null) {
					
					resWrapper.setMessage("Validation 4.1: User joining date can not be empty.");
					return resWrapper;
				}

				long numberOfDaysFromJoining = calculateDateDifference(user.getJoiningDate(), startDate);

				if (leaveType.getEligibleAfter() > numberOfDaysFromJoining) {

					resWrapper.setMessage("Validation 4.0: Eligibility requirement, number of days from Joining date does not full filled.");
					return resWrapper;
				}
			}

			// Validation 5: Eligibility requirement, number of days to resign does not full
			// filled.
			else if (leaveType.getEligibleBefore() != null && leaveType.getEligibleBefore() != 0) {

				if (user.getResigndate() == null) {
					resWrapper.setMessage("Validation 5.1: User resign date can not be empty.");
					return resWrapper;
				}

				long numberOfDaysToResign = calculateDateDifference(startDate, user.getResigndate());

				if (numberOfDaysToResign < 0) {

					resWrapper.setMessage("Validation 5.2: Number of days to resign can not be negative.");
					return resWrapper;
				}

				if (leaveType.getEligibleBefore() < numberOfDaysToResign) {

					resWrapper.setMessage("Validation 5.0: Eligibility requirement, number of days to resign does not full filled.");
					return resWrapper;
				}
			}

			// Validation 6: Leave Type is not ACTIVE.
			else if (leaveType.getStatus() != null && !leaveType.getStatus().equals("")) {

				if (!leaveType.getStatus().equals(LEAVETYPE.ACTIVE)) {

					resWrapper.setMessage("Validation 6.0: Leave Type is not ACTIVE.");
					return resWrapper;
				}
			}

			// Validation 7: Insufficient Leave Balance.
			else if ((leaveType.getIncremental() != null && !leaveType.getIncremental().equals(""))
					&& leaveType.getIncremental().toUpperCase().equals(DECISION.YES)) {

				if (lmsLeaveBalance.getLeaveTotal() > (lmsLeaveBalance.getLeaveTaken()
						+ lmsLeaveBalance.getLeaveApplied() + numberOfDaysApplied)) {

					resWrapper.setMessage("Validation 7.0: Insufficient Leave Balance.");
					return resWrapper;
				}
			}

			// Validation 8: Minimum at a time limit is not fulfilled

			else if (leaveType.getMinimumAtATime() != null && leaveType.getMinimumAtATime() != 0) {

				if (leaveType.getMinimumAtATime() > numberOfDaysApplied) {

					resWrapper.setMessage("Validation 8.0: Minimum at a time limit is not fulfilled.");
					return resWrapper;
				}
			}

			// Validation 9: Application must be submitted be for 31st January each year.

			else if (leaveType.getApplyDaysEachYear() != null && leaveType.getApplyDaysEachYear() != 0) {

				long numberOfDaysToApply = calculateDateDifference(firstDateOfCurrentYesr, currentDate);

				if (numberOfDaysToApply < 0) {

					resWrapper.setMessage("Validation 9.1: Application must be submitted be for 31st January each year, but not advanced.");
					return resWrapper;
				}

				if (leaveType.getApplyDaysEachYear() < numberOfDaysToApply) {

					resWrapper.setMessage("Validation 9.0: Application must be submitted be for 31st January each year.");
					return resWrapper;
				}
			}
			


		} catch (Exception ex) {

			resWrapper.setMessage(ex.getMessage());
		}

		return resWrapper;
	}

	private long calculateDateDifference(Date startdate, Date enddate) {

		long diff = enddate.getTime() - startdate.getTime();

		diff = diff / 1000 / 60 / 60 / 24;
		return diff;
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

	@RequestMapping(value = "/leaverule/{userid}/{leavetypeid}/", method = RequestMethod.GET)
	public ResponseEntity<ResponseWrapperLeaveRule> generateRequest(@PathVariable("userid") Integer userid,
			@PathVariable("leavetypeid") Integer leavetypeid) {

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
				responseWrapper.setLmsLeaveBalance(lmsLeaveBalance);
				responseWrapper.setMessage("Success. Leave Balance record has found.");
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
	
	private ResponseWrapperLeaveRule findHolidayRange(Date startDate, Date endDate) {
			
		ResponseWrapperLeaveRule resWrapper = new ResponseWrapperLeaveRule();
		
		Integer noOfHolidays = 0;
		boolean forward = true;
		Integer forwardCount =0;
		boolean backward = true;
		Integer backwardCount =0;
				
		//String dt = "2008-01-01";  // Start date
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar c = Calendar.getInstance();
		//c.setTime(startDate);
		//c.add(Calendar.DATE, 1);  // number of days to add
		//strStartDate = sdf.format(c.getTime());  // dt is now the new date
		
		
		while(backward) {
			
			c.setTime(startDate);
			c.add(Calendar.DATE, -1);  // number of days to add
			startDate = c.getTime();
			
			backward = findHoliday(startDate);
			if(backward) {
				backwardCount++;
			}
		}
		resWrapper.setBackwardHolidayCount(backwardCount);

		while(forward) {
			
			c.setTime(endDate);
			c.add(Calendar.DATE, 1);  // number of days to add
			endDate = c.getTime();
			
			forward = findHoliday(endDate);
			if(forward) {
				forwardCount++;
			}
		}
		
		resWrapper.setForwardHolidayCount(forwardCount);
		
		// minimum holiday part will be consider with original applied leave
		if(forwardCount < backwardCount ) {			
			resWrapper.setMinimumHolidayConsider(forwardCount);			
		}else {			
			resWrapper.setMinimumHolidayConsider(backwardCount);			
		}		
		
		return resWrapper;
	}
		
	private boolean findHoliday(Date date) {
		
		boolean isHoliday = false;		
		
		try {
			
		  //String input_date="01/08/2012";
		  //SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
		  	  
		  //Date dt1=format1.parse(input_date);		  
		  
		  DateFormat format2 = new SimpleDateFormat("EEEE"); 
		  String finalDay = format2.format(date);
		  
		  if(DAY.Friday.toString().equals(finalDay) || DAY.Saturday.toString().equals(finalDay)) {			  
			  isHoliday = true;
			  return isHoliday;
		  }else {
			  List<LmsHolidayRecord> holidayRecords = lmsHolidayRecordHome.findHoliday(date);
			  if(holidayRecords.size()>0) {
				  isHoliday = true;
				  return isHoliday;				  
			  }			  
		  }
		  
		  return isHoliday; 
		  
		}
		catch(Exception ex) {
			
			return false;
		}	
	}
}
