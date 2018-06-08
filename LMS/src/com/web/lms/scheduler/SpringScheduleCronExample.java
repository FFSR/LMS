package com.web.lms.scheduler;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.web.lms.dao.LmsLeaveBalanceHome;
import com.web.lms.dao.LmsLeaveTypeHome;
import com.web.lms.dao.LmsUserHome;
import com.web.lms.enumcollection.ACSTATUS;
import com.web.lms.enumcollection.DECISION;
import com.web.lms.enumcollection.USERSTATUS;
import com.web.lms.model.LmsLeaveBalance;
import com.web.lms.model.LmsLeaveType;
import com.web.lms.model.LmsUser;

@Configuration
@EnableScheduling
public class SpringScheduleCronExample {
	
	@Autowired
	private LmsUserHome lmsUserHome;
	@Autowired
	private LmsLeaveTypeHome lmsLeaveTypeHome;
	@Autowired
	private LmsLeaveBalanceHome lmsLeaveBalanceHome;
	
	
    private AtomicInteger counter = new AtomicInteger(0);

    // https://crontab.guru/every-night-at-midnight
    // How to change the Cron Schedule
    // @Scheduled(cron = "*/2 * * * * FRI,SAT,SUN,MON")
    
    
//    		* "0 0 * * * *" = the top of every hour of every day.
//    		* "*/10 * * * * *" = every ten seconds.
//    		* "0 0 8-10 * * *" = 8, 9 and 10 o'clock of every day.
//    		* "0 0 8,10 * * *" = 8 and 10 o'clock of every day.
//    		* "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30 and 10 o'clock every day.
//    		* "0 0 9-17 * * MON-FRI" = on the hour nine-to-five weekdays
//    		* "0 0 0 25 12 ?" = every Christmas Day at midnight
    
    
    @Scheduled(cron = "0 0 9 * * *")
    public void cronJob() {
        int jobId = counter.incrementAndGet();
        System.out.println("Job @ cron Start" + new Date() + ", jobId: " + jobId);
        
        LeaveCalculation();
        
        System.out.println("Job @ cron End" + new Date() + ", jobId: " + jobId);
    }

	public static void main(String[] args) {
    	System.out.println("Main @ Inside 1 "+ new Date());
    	
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringScheduleCronExample.class);
        System.out.println("Main @ Inside 2 "+ new Date());
        try {
            Thread.sleep(12000);
            System.out.println("Main @ Inside 3 "+ new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            context.close();
        }
    }
	
    private void LeaveCalculation() {
		// TODO Auto-generated method stub
    	
    	//1.0 INACTIVE user and Leave Balance management
    	InactiveUserAndLeaveBalanceManagement();
    	
    	//2.0 RELEASED user and Leave Balance management
    	ReleasedUserAndLeaveBalanceManagement();
    	
    	//3.0 ACTIVE user and Leave Balance management
    	ActiveUserAndLeaveBalanceManagement();
    		
	}
    
    private void ActiveUserAndLeaveBalanceManagement() {
    	
    	List<LmsUser> users = lmsUserHome.findAllUserConditional(USERSTATUS.ACTIVE.toString());
    	List<LmsLeaveType> leaveTypes = lmsLeaveTypeHome.findAllLeaveType();
    	LmsLeaveBalance leaveBalance = null;
    	Integer finalLeaveCount=0;
    	
    	for (LmsUser user: users) {
    				
    		for(LmsLeaveType leaveType:leaveTypes) {
    			
    			if(leaveType.getDependentLeaveAc() == null || leaveType.getDependentLeaveAc()==0) {
    			
    				leaveBalance = lmsLeaveBalanceHome.findLeaveCountbyUserAndLeaveType(user.getId(), leaveType.getId());
    				
    				// Inserting Missing Leave Type into Leave Balance for this user
    				if(leaveBalance == null) {   
    					
    					leaveBalance = new LmsLeaveBalance();
    					
    					leaveBalance.setAcstatus(ACSTATUS.CURRENT.toString());
    					leaveBalance.setEligibility(DECISION.YES.toString());
    					leaveBalance.setInsertBy(1);
    					leaveBalance.setInsertDate(new Date());
    					leaveBalance.setLeaveApplied(0);    					
    					leaveBalance.setLeaveTaken(0);
    					
    					if(leaveType.getIncremental().contains(DECISION.YES.toString())) {
    						
    						finalLeaveCount = findMaximumDaysForEarnLeave(user,leaveType);
    						leaveBalance.setLeaveTotal(finalLeaveCount);
        					leaveBalance.setLeaveBalance(finalLeaveCount);
        					
    					}else {
    						
    						leaveBalance.setLeaveTotal(leaveType.getMaximumDays()); 
    						leaveBalance.setLeaveBalance(leaveType.getMaximumDays());
    					}
    					leaveBalance.setLmsLeaveType(leaveType);
    					leaveBalance.setLmsUser(user);
    					leaveBalance.setYear(new Date());
    					
    					lmsLeaveBalanceHome.persist(leaveBalance);
    				}
    				else if(leaveBalance.getAcstatus().contains(ACSTATUS.PAST.toString()) || 
    						leaveBalance.getAcstatus().contains(ACSTATUS.CLOSED.toString())) {
    					// Skip for those two type of leave
    				}
    				else if (leaveBalance.getAcstatus().contains(ACSTATUS.INACTIVE.toString())){
    					
    					leaveBalance.setAcstatus(ACSTATUS.CURRENT.toString());
    					leaveBalance.setEligibility(DECISION.YES.toString());
    					leaveBalance.setUpdateBy(1);
    					leaveBalance.setUpdateDate(new Date());  
    					
    					if(leaveType.getIncremental().contains(DECISION.YES.toString())) {
    						
    						// Incrementally set 
    						finalLeaveCount = findMaximumDaysForEarnLeave(user,leaveType);
    						leaveBalance.setLeaveTotal(finalLeaveCount);
        					leaveBalance.setLeaveBalance(leaveBalance.getLeaveTotal()-leaveBalance.getLeaveTaken());
        					
    					}else {
    						
        					leaveBalance.setLeaveTotal(leaveType.getMaximumDays());
        					leaveBalance.setLeaveBalance(leaveBalance.getLeaveTotal()-leaveBalance.getLeaveTaken());
    					}    					
	
    					lmsLeaveBalanceHome.merge(leaveBalance);
    				}
    			} 
    			
    			
    		}  		    		
    	}	
	}

	private void ReleasedUserAndLeaveBalanceManagement() {
    	
    	List<LmsUser> users = lmsUserHome.findAllUserConditional(USERSTATUS.RELEASED.toString());
    	List<LmsLeaveBalance> leaveBalances;
    	
    	for (LmsUser user: users) {
    		leaveBalances = lmsLeaveBalanceHome.findLeavebalacebyUserAndACStatus(user.getId(), ACSTATUS.CURRENT.toString());
    		
    		for(LmsLeaveBalance leaveBalance: leaveBalances) {
    			
    			leaveBalance.setAcstatus(ACSTATUS.CLOSED.toString());
    			
    			lmsLeaveBalanceHome.merge(leaveBalance);		
    		}    		    		
    	}
		
	}

	private void InactiveUserAndLeaveBalanceManagement() {
    	
    	List<LmsUser> users = lmsUserHome.findAllUserConditional(USERSTATUS.INACTIVE.toString());
    	List<LmsLeaveBalance> leaveBalances;
    	
    	for (LmsUser user: users) {
    		leaveBalances = lmsLeaveBalanceHome.findLeavebalacebyUserAndACStatus(user.getId(), ACSTATUS.CURRENT.toString());
    		
    		for(LmsLeaveBalance leaveBalance: leaveBalances) {
    			
    			leaveBalance.setAcstatus(ACSTATUS.INACTIVE.toString());
    			
    			lmsLeaveBalanceHome.merge(leaveBalance);		
    		}    		    		
    	}
    }
	
	private Integer findMaximumDaysForEarnLeave(LmsUser user, LmsLeaveType leaveType) {
		
		Integer finalDayCount=0;
		
		// 1 day added for start and end date are same
		Date today = new Date();
		long tantativeDayCountLong = calculateDateDifference(user.getJoiningDate(), today) + 1;
		Integer tantativeDayCount = (int) (long) tantativeDayCountLong;
		
		Integer sumleaveTaken =  lmsLeaveBalanceHome.findSumOfLeaveTakenImpactOnEarnLeave(user.getId());
		
		if(leaveType.getType().contains("AVERAGE SALARY")) {
			
			finalDayCount = (tantativeDayCount-sumleaveTaken)/11;
			
		}else if(leaveType.getType().contains("HALF AVERAGE SALARY")) {
			
			finalDayCount = (tantativeDayCount-sumleaveTaken)/12;			
		}
		
		return finalDayCount;		
	}
	
	private long calculateDateDifference(Date startdate, Date enddate) {

		long diff = enddate.getTime() - startdate.getTime();

		diff = diff / 1000 / 60 / 60 / 24;
		return diff;
	}
}
