package com.web.lms.scheduler;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Calendar;
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

	// How to change the Cron Schedule
	// @Scheduled(cron = "*/2 * * * * FRI,SAT,SUN,MON")

	// second, minute, hour, day of month, month, day(s) of week
	// * "0 0 * * * *" = the top of every hour of every day.
	// * "*/10 * * * * *" = every ten seconds.
	// * "0 0 8-10 * * *" = 8, 9 and 10 o'clock of every day.
	// * "0 0 8,10 * * *" = 8 and 10 o'clock of every day.
	// * "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30 and 10 o'clock every day.
	// * "0 0 9-17 * * MON-FRI" = on the hour nine-to-five weekdays
	// * "0 0 0 25 12 ?" = every Christmas Day at midnight

	// (*) means match any
	// */X means "every X"
	// ? ("no specific value") - useful when you need to specify something in one of
	// the two fields in which the character is allowed, but not the other. For
	// example, if I want my trigger to fire on a particular day of the month (say,
	// the 10th), but I don't care what day of the week that happens to be, I would
	// put "10" in the day-of-month field and "?" in the day-of-week field.

	@Scheduled(cron = "0 0 2 1 * ?")
	public void cronYearly() {

		int jobId = counter.incrementAndGet();
		System.out.println(new Date() + " Job @ cron Start, jobId: " + jobId);

		YearlyAllocated();

		System.out.println(new Date() + " Job @ cron End, jobId: " + jobId);
	}

	@Scheduled(cron = "0 0 1 * * *")
	public void cronJob() {

		int jobId = counter.incrementAndGet();
		System.out.println(new Date() + " Job @ cron Start, jobId: " + jobId);

		LeaveCalculation();

		System.out.println(new Date() + " Job @ cron End, jobId: " + jobId);
	}

	public static void main(String[] args) {
		System.out.println("Main @ Inside 1 " + new Date());

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				SpringScheduleCronExample.class);
		System.out.println("Main @ Inside 2 " + new Date());
		try {
			Thread.sleep(3600000);
			System.out.println("Main @ Inside 3 " + new Date());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			context.close();
		}
	}

	private void YearlyAllocated() {

		try {

			List<LmsUser> users = lmsUserHome.findAllUserConditional(USERSTATUS.ACTIVE.toString());
			List<LmsLeaveType> leaveTypes = lmsLeaveTypeHome.findAllLeaveType();
			LmsLeaveBalance leaveBalance = null;
			Integer finalLeaveCount = 0;
			
			// find the current year
			Date currentDate = new Date(); // current date
			Calendar cal = Calendar.getInstance();
			cal.setTime(currentDate);
			int year = cal.get(Calendar.YEAR);
			//String strCurrentYear = Integer.toString(year);
			// int month = cal.get(Calendar.MONTH);
			// int day = cal.get(Calendar.DAY_OF_MONTH);
			
			int startyearint;
			String startyear;
			String endyear = Integer.toString(year);

			for (LmsLeaveType leaveType : leaveTypes) {

				if (leaveType.getYearlyAllocated() != null && leaveType.getYearlyAllocated().contains(DECISION.YES.toString())) {

					if (leaveType.getYearInterval() != null && leaveType.getYearInterval() != 0) {
						
						// Yearly interval 1 means one year, so start year will be the same as current
						// If yearly interval is 3, so this year and past 2 years. + 1 to adjust to the Calendar
						
						startyearint = year - leaveType.getYearInterval() + 1;
						startyear = Integer.toString(startyearint);

						for (LmsUser user : users) {

							leaveBalance = lmsLeaveBalanceHome.findLeaveCountbyUserAndLeaveTypeAndYear(user.getId(), leaveType.getId(), startyear, endyear, ACSTATUS.CURRENT.toString());

							// Update Old Year Account
							if (leaveBalance != null) {

								System.out.println(new Date() + " Job @ YearlyAllowcated Current Year Data Available : "+ leaveBalance.getId());

								// Record found and No Need to do any thing.

							} else { // Record not found, so new row need to insert for this year + Yearly interval

								// AC Status set Past for Old Records
								leaveBalance = lmsLeaveBalanceHome.findLeaveCountbyUserAndLeaveType(user.getId(), leaveType.getId(), ACSTATUS.CURRENT.toString());

								if (leaveBalance != null) {
									System.out.println(new Date() + " Job @ YearlyAllowcated AC Status Set PAST for Old Records : " + leaveBalance.getId());
									leaveBalance.setAcstatus(ACSTATUS.PAST.toString());
									lmsLeaveBalanceHome.merge(leaveBalance);
								}

								// Inserting New Record Leave Type into Leave Balance for Current Year Interval
								leaveBalance = new LmsLeaveBalance();

								System.out.println(new Date() + " Job @ YearlyAllowcated (NEW) : " + leaveBalance.getId());

								leaveBalance.setAcstatus(ACSTATUS.CURRENT.toString());
								leaveBalance.setEligibility(DECISION.YES.toString());
								leaveBalance.setInsertBy(1);
								leaveBalance.setInsertDate(new Date());
								leaveBalance.setLeaveApplied(0);
								leaveBalance.setLeaveTaken(0);

								if (leaveType.getIncremental() != null && leaveType.getIncremental().contains(DECISION.YES.toString())) {

									System.out.println(new Date() + " Job @ YearlyAllowcated getIncremental = YES (NEW) : "+ leaveBalance.getId());

									finalLeaveCount = findMaximumDaysForEarnLeave(user, leaveType);
									leaveBalance.setLeaveTotal(finalLeaveCount);
									leaveBalance.setLeaveBalance(finalLeaveCount);

								} else {

									System.out.println(new Date() + " Job @ YearlyAllowcated getIncremental = NO (NEW) : "+ leaveBalance.getId());

									leaveBalance.setLeaveTotal(leaveType.getMaximumDays());
									leaveBalance.setLeaveBalance(leaveType.getMaximumDays());
								}
								leaveBalance.setLmsLeaveType(leaveType);
								leaveBalance.setLmsUser(user);
								leaveBalance.setYear(new Date());

								lmsLeaveBalanceHome.persist(leaveBalance);

								System.out.println(new Date() + " Job @ YearlyAllowcated lmsLeaveBalanceHome.persist (NEW) : "+ leaveBalance.getId());

							}

						}
					}
				}
			}
		} 
		catch (Exception ex) {
			System.out.println(new Date() + " Job @ ActiveUserAndLeaveBalanceManagement ex: " + ex.getMessage());
		}
	}

	private void LeaveCalculation() {
		// TODO Auto-generated method stub

		// 1.0 INACTIVE user and Leave Balance management
		InactiveUserAndLeaveBalanceManagement();

		System.out.println(new Date() + " Job @ cron Inactive User Complete ");

		// 2.0 RELEASED user and Leave Balance management
		ReleasedUserAndLeaveBalanceManagement();

		System.out.println(new Date() + " Job @ cron Released User Complete ");

		// 3.0 ACTIVE user and Leave Balance management
		ActiveUserAndLeaveBalanceManagement();

		System.out.println(new Date() + " Job @ cron Active User Complete ");

	}

	private void ActiveUserAndLeaveBalanceManagement() {

		try {
			List<LmsUser> users = lmsUserHome.findAllUserConditional(USERSTATUS.ACTIVE.toString());
			List<LmsLeaveType> leaveTypes = lmsLeaveTypeHome.findAllLeaveType();
			LmsLeaveBalance leaveBalance = null;
			Integer finalLeaveCount = 0;

			for (LmsUser user : users) {

				System.out.println(new Date() + " Job @ User : " + user.getId());

				for (LmsLeaveType leaveType : leaveTypes) {

					System.out.println(new Date() + " Job @ leaveType : " + leaveType.getId());

					if (leaveType.getStatus().contains("ACTIVE")
							&& (leaveType.getDependentLeaveAc() == null || leaveType.getDependentLeaveAc() == 0)) {

						leaveBalance = lmsLeaveBalanceHome.findLeaveCountbyUserAndLeaveType(user.getId(), leaveType.getId(), ACSTATUS.CURRENT.toString());

						// Inserting Missing Leave Type into Leave Balance for this user
						if (leaveBalance == null) {

							leaveBalance = new LmsLeaveBalance();

							System.out.println(new Date() + " Job @ leaveBalance (NEW) : " + leaveBalance.getId());

							leaveBalance.setAcstatus(ACSTATUS.CURRENT.toString());
							leaveBalance.setEligibility(DECISION.YES.toString());
							leaveBalance.setInsertBy(1);
							leaveBalance.setInsertDate(new Date());
							leaveBalance.setLeaveApplied(0);
							leaveBalance.setLeaveTaken(0);

							if (leaveType.getIncremental() != null
									&& leaveType.getIncremental().contains(DECISION.YES.toString())) {

								System.out.println(
										new Date() + " Job @ getIncremental = YES (NEW) : " + leaveBalance.getId());

								finalLeaveCount = findMaximumDaysForEarnLeave(user, leaveType);
								leaveBalance.setLeaveTotal(finalLeaveCount);
								leaveBalance.setLeaveBalance(finalLeaveCount);

							} else {

								System.out.println(
										new Date() + " Job @ getIncremental = NO (NEW) : " + leaveBalance.getId());

								leaveBalance.setLeaveTotal(leaveType.getMaximumDays());
								leaveBalance.setLeaveBalance(leaveType.getMaximumDays());
							}
							leaveBalance.setLmsLeaveType(leaveType);
							leaveBalance.setLmsUser(user);
							leaveBalance.setYear(new Date());

							lmsLeaveBalanceHome.persist(leaveBalance);

							System.out.println(
									new Date() + " Job @ lmsLeaveBalanceHome.persist (NEW) : " + leaveBalance.getId());
						} else if (leaveBalance.getAcstatus().contains(ACSTATUS.PAST.toString())
								|| leaveBalance.getAcstatus().contains(ACSTATUS.CLOSED.toString())) {

							System.out.println(
									new Date() + " Job @ leaveBalance (PAST/CLOSED) : " + leaveBalance.getId());
							// Skip for those two type of leave
						} else if (leaveBalance.getAcstatus().contains(ACSTATUS.INACTIVE.toString())) {

							System.out.println(new Date() + " Job @ leaveBalance (INACTIVE) : " + leaveBalance.getId());

							leaveBalance.setAcstatus(ACSTATUS.CURRENT.toString());
							leaveBalance.setEligibility(DECISION.YES.toString());
							leaveBalance.setUpdateBy(1);
							leaveBalance.setUpdateDate(new Date());

							if (leaveType.getIncremental() != null
									&& leaveType.getIncremental().contains(DECISION.YES.toString())) {

								// Incrementally set
								finalLeaveCount = findMaximumDaysForEarnLeave(user, leaveType);
								leaveBalance.setLeaveTotal(finalLeaveCount);
								leaveBalance
										.setLeaveBalance(leaveBalance.getLeaveTotal() - leaveBalance.getLeaveTaken());

							} else {

								leaveBalance.setLeaveTotal(leaveType.getMaximumDays());
								leaveBalance
										.setLeaveBalance(leaveBalance.getLeaveTotal() - leaveBalance.getLeaveTaken());
							}

							lmsLeaveBalanceHome.merge(leaveBalance);

							System.out.println(new Date() + " Job @ lmsLeaveBalanceHome.merge (INACTIVE) : "
									+ leaveBalance.getId());
						} else if (leaveBalance.getAcstatus().contains(ACSTATUS.CURRENT.toString())) {

							System.out.println(new Date() + " Job @ leaveBalance (CURRENT) : " + leaveBalance.getId());

							// leaveBalance.setAcstatus(ACSTATUS.CURRENT.toString());
							// leaveBalance.setEligibility(DECISION.YES.toString());
							leaveBalance.setUpdateBy(1);
							leaveBalance.setUpdateDate(new Date());

							if (leaveType.getIncremental() != null
									&& leaveType.getIncremental().contains(DECISION.YES.toString())) {

								// Incrementally set
								finalLeaveCount = findMaximumDaysForEarnLeave(user, leaveType);
								leaveBalance.setLeaveTotal(finalLeaveCount);
								leaveBalance
										.setLeaveBalance(leaveBalance.getLeaveTotal() - leaveBalance.getLeaveTaken());

							} else {

								leaveBalance.setLeaveTotal(leaveType.getMaximumDays());
								leaveBalance
										.setLeaveBalance(leaveBalance.getLeaveTotal() - leaveBalance.getLeaveTaken());
							}

							lmsLeaveBalanceHome.merge(leaveBalance);

							System.out.println(
									new Date() + " Job @ lmsLeaveBalanceHome.merge (ACTIVE) : " + leaveBalance.getId());
						}
					}

				}
			}
		} catch (Exception ex) {
			System.out.println(new Date() + " Job @ ActiveUserAndLeaveBalanceManagement ex: " + ex.getMessage());
		}
	}

	private void ReleasedUserAndLeaveBalanceManagement() {

		try {
			List<LmsUser> users = lmsUserHome.findAllUserConditional(USERSTATUS.RELEASED.toString());
			List<LmsLeaveBalance> leaveBalances;

			for (LmsUser user : users) {
				leaveBalances = lmsLeaveBalanceHome.findLeavebalacebyUserAndACStatus(user.getId(),
						ACSTATUS.CURRENT.toString());

				for (LmsLeaveBalance leaveBalance : leaveBalances) {

					leaveBalance.setAcstatus(ACSTATUS.CLOSED.toString());

					lmsLeaveBalanceHome.merge(leaveBalance);
				}
			}

		} catch (Exception ex) {
			System.out.println(new Date() + " Job @ ReleasedUserAndLeaveBalanceManagement ex: " + ex.getMessage());
		}

	}

	private void InactiveUserAndLeaveBalanceManagement() {

		try {
			List<LmsUser> users = lmsUserHome.findAllUserConditional(USERSTATUS.INACTIVE.toString());
			List<LmsLeaveBalance> leaveBalances;

			for (LmsUser user : users) {
				leaveBalances = lmsLeaveBalanceHome.findLeavebalacebyUserAndACStatus(user.getId(),
						ACSTATUS.CURRENT.toString());

				for (LmsLeaveBalance leaveBalance : leaveBalances) {

					leaveBalance.setAcstatus(ACSTATUS.INACTIVE.toString());

					lmsLeaveBalanceHome.merge(leaveBalance);
				}
			}

		} catch (Exception ex) {
			System.out.println(new Date() + " Job @ InactiveUserAndLeaveBalanceManagement ex: " + ex.getMessage());
		}
	}

	private Integer findMaximumDaysForEarnLeave(LmsUser user, LmsLeaveType leaveType) {

		Integer finalDayCount = 0;
		try {

			// 1 day added for start and end date are same
			Date today = new Date();
			long tantativeDayCountLong = calculateDateDifference(user.getJoiningDate(), today) + 1;
			Integer tantativeDayCount = (int) (long) tantativeDayCountLong;

			long sumleaveTakenLong = lmsLeaveBalanceHome.findSumOfLeaveTakenImpactOnEarnLeave(user.getId());

			Integer sumleaveTaken = (int) (long) sumleaveTakenLong;

			System.out.println(new Date() + " Job @ findSumOfLeaveTakenImpactOnEarnLeave, User : " + user.getId()
					+ " leaveType: " + leaveType.getId() + " tantativeDayCount: " + tantativeDayCount
					+ " sumleaveTaken: " + sumleaveTaken);

			if (leaveType.getType().contains("HALF")) {

				finalDayCount = (int) ((tantativeDayCount - sumleaveTaken) / 12);

				System.out.println(new Date() + " Job @ HALF AVERAGE SALARY, User : " + user.getId() + " leaveType: "
						+ leaveType.getId() + " finalDayCount: " + finalDayCount);
			} else if (leaveType.getType().contains("AVERAGE")) {

				finalDayCount = (int) ((tantativeDayCount - sumleaveTaken) / 11);

				System.out.println(new Date() + " Job @ AVERAGE SALARY, User : " + user.getId() + " leaveType: "
						+ leaveType.getId() + " finalDayCount: " + finalDayCount);

			} else {

				System.out.println(new Date() + " Job @ AVERAGE/HALF SALARY ELSE User : " + user.getId()
						+ " leaveType: " + leaveType.getId() + " tantativeDayCount: " + tantativeDayCount
						+ " sumleaveTaken: " + sumleaveTaken);

			}

		} catch (Exception ex) {
			System.out.println(new Date() + " Job @ findMaximumDaysForEarnLeave ex: " + ex.getMessage());
		}

		return finalDayCount;
	}

	private long calculateDateDifference(Date startdate, Date enddate) {

		long diff = 0;
		try {

			diff = enddate.getTime() - startdate.getTime();

			diff = diff / 1000 / 60 / 60 / 24;

			System.out.println(new Date() + " Job @ calculateDateDifference, Diff: " + diff);

		} catch (Exception ex) {
			System.out.println(new Date() + " Job @ findMaximumDaysForEarnLeave ex: " + ex.getMessage());
		}
		return diff;
	}
}
