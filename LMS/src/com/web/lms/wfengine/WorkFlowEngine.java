package com.web.lms.wfengine;

import java.util.Date;
import java.util.List;

import com.web.lms.dao.LmsWfRequestHome;
import com.web.lms.dao.LmsWfRequestHopHome;
import com.web.lms.dao.LmsWftRequestHopRolePageMapHome;
import com.web.lms.enumcollection.WFSTATUS;
import com.web.lms.model.LmsUser;
import com.web.lms.model.LmsWfRequest;
import com.web.lms.model.LmsWfRequestHop;
import com.web.lms.model.LmsWftRequestHopRolePageMap;
import com.web.lms.model.LmsWftRequestSelector;

public class WorkFlowEngine {
	
	LmsWftRequestHopRolePageMapHome lmsWftRequestHopRolePageMapHome = new LmsWftRequestHopRolePageMapHome();
	LmsWfRequestHome lmsWfRequestHome = new  LmsWfRequestHome();
	LmsWfRequestHopHome lmsWfRequestHopHome = new LmsWfRequestHopHome();

	public void generateWorkRequest(LmsWftRequestSelector lmsWftRequestSelector, LmsUser user) {

		// Insert Request
		LmsWfRequest lmsWfRequest = saveRequest(lmsWftRequestSelector, user);

		// Insert Request Hop
		saveHops(lmsWfRequest, user);
		
		//Find First Hop of this WorkRequest
		LmsWfRequestHop lmsWfRequestHop = findFirstHopForRequest(lmsWfRequest);
		// UpdateHopStatus for First Hop
		updateHopDoneStatus(lmsWfRequestHop, WFSTATUS.DONE.toString(), user);
		
	}

	private LmsWfRequest saveRequest(LmsWftRequestSelector lmsWftRequestSelector, LmsUser user) {
		try {
			LmsWfRequest lmsWfRequest = new LmsWfRequest();
			Date currentDate = new Date();

			lmsWfRequest.setLmsWftRequestType(
					lmsWftRequestSelector.getLmsWftRequestHopRolePageMap().getLmsWftRequestType());
			lmsWfRequest.setStartDate(currentDate);
			lmsWfRequest.setEndDate(new Date());
			lmsWfRequest.setStatus("");
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
		
		
		
		List<LmsWftRequestHopRolePageMap> lmsWftRequestHopRolePageMaps = lmsWftRequestHopRolePageMapHome
				.findRequestHopMapByRequestType(lmsWfRequest.getLmsWftRequestType().getId());

		for (LmsWftRequestHopRolePageMap lmsWftRequestHopRolePageMap : lmsWftRequestHopRolePageMaps) {

			saveHop(lmsWftRequestHopRolePageMap, lmsWfRequest, user);
		}
	}

	private void saveHop(LmsWftRequestHopRolePageMap lmsWftRequestHopRolePageMap, LmsWfRequest lmsWfRequest,
			LmsUser user) {
		LmsWfRequestHop lmsWfRequestHop = new LmsWfRequestHop();

		lmsWfRequestHop.setLmsWfRequest(lmsWfRequest);

		lmsWfRequestHop.setLmsWftRequestHopRolePageMap(lmsWftRequestHopRolePageMap);
		lmsWfRequestHop.setWftRoleId(lmsWftRequestHopRolePageMap.getLmsWftRole().getId());
		lmsWfRequestHop.setStatus(WFSTATUS.UPCOMING.toString());
		lmsWfRequestHop.setUserId(user.getId());
		lmsWfRequestHop.setInsertDate(new Date());
		lmsWfRequestHop.setInsertBy(user.getId());
		lmsWfRequestHop.setPageId(lmsWftRequestHopRolePageMap.getLmsPages().getId());

		lmsWfRequestHopHome.persist(lmsWfRequestHop);

	}
	
	public void updateHopDoneStatus(LmsWfRequestHop lmsWfRequestHop, String hopStatus, LmsUser user) {
		
		if(hopStatus.contains(WFSTATUS.REJECTED.toString())) {
			lmsWfRequestHop.setStatus(WFSTATUS.REJECTED.toString());
		}else {
			lmsWfRequestHop.setStatus(WFSTATUS.DONE.toString());
		}
		lmsWfRequestHop.setUpdateDate(new Date());
		lmsWfRequestHop.setUpdateBy(user.getId());

		lmsWfRequestHopHome.merge(lmsWfRequestHop);

		updateHopCurrentStatus(lmsWfRequestHop.getLmsWfRequest());
	}

	protected void updateHopCurrentStatus(LmsWfRequest lmsWfRequest) {

		if (updateRequestStatus(lmsWfRequest)) {
			return;
		}

		/*for (LmsWfRequestHop lmsWfRequestHop : lmsWfRequest.getLmsWfRequestHops()) {
			
			if (lmsWfRequestHop.getStatus().contains(WFSTATUS.UPCOMING.toString())|| lmsWfRequestHop.getStatus() == null) {

				List<LmsWftFlowControl> flows = lmsWftFlowControlHome.findWftFlowControlByWftHopid(lmsWfRequestHop.getLmsWftRequestHopRolePageMap().getId());

				if (flows.size() < 1) {
					
					lmsWfRequestHop.setStartDate(new Date());
					lmsWfRequestHop.setStatus(WFSTATUS.CURRENT.toString());

					lmsWfRequestHopHome.persist(lmsWfRequestHop);
				} else {
					
					boolean parentDone = true;
					
					for (LmsWftFlowControl lmsWftFlowControl : flows) {

						for (LmsWfRequestHop parentHop : lmsWfRequestHopHome.findWfRequestHopByRequestIdAndRequestHopId(
								lmsWfRequest.getId(),
								lmsWftFlowControl.getLmsWftRequestHopRolePageMapByTrhmDependedHopsId().getId())) {
							
							if (!parentHop.getStatus().contains(WFSTATUS.DONE.toString())) {
								
								parentDone = false;
							}
						}
					}
					if (parentDone) {
						
						lmsWfRequestHop.setStartDate(new Date());
						lmsWfRequestHop.setStatus(WFSTATUS.CURRENT.toString());

						lmsWfRequestHopHome.persist(lmsWfRequestHop);
					}
				}
			}
		}*/
	}

	protected boolean updateRequestStatus(LmsWfRequest lmsWfRequest) {
		
		String requestStatus="";
		boolean requestComplete = false;

		/*for (LmsWfRequestHop lmsWfRequestHop : lmsWfRequest.getLmsWfRequestHops()) {
			if (lmsWfRequestHop.getStatus().contains(WFSTATUS.DONE.toString())) {
				requestStatus = WFSTATUS.APPROVED.toString();
				requestComplete = true;				
			}else if(lmsWfRequestHop.getStatus().contains(WFSTATUS.CURRENT.toString())){
				requestStatus = WFSTATUS.INPROGRESS.toString();
				requestComplete = false;
			}else if(lmsWfRequestHop.getStatus().contains(WFSTATUS.UPCOMING.toString())) {
				requestStatus = WFSTATUS.INPROGRESS.toString();
				requestComplete = false;
			}else if(lmsWfRequestHop.getStatus().contains(WFSTATUS.REJECTED.toString())) {
				requestStatus = WFSTATUS.REJECTED.toString();
				requestComplete = true;
			}
		}*/

		lmsWfRequest.setStatus(requestStatus);
		lmsWfRequest.setEndDate(new Date());

		lmsWfRequestHome.merge(lmsWfRequest);

		return requestComplete;
	}
	
	protected LmsWfRequestHop findFirstHopForRequest(LmsWfRequest lmsWfRequest) {
		
		LmsWfRequestHop wfRequestFirstHop = new LmsWfRequestHop();
		
		/*for (LmsWfRequestHop lmsWfRequestHop : lmsWfRequest.getLmsWfRequestHops()) {
			
			if (lmsWfRequestHop.getStatus().contains(WFSTATUS.UPCOMING.toString())|| lmsWfRequestHop.getStatus() == null) {

				List<LmsWftFlowControl> flows = lmsWftFlowControlHome.findWftFlowControlByWftHopid(lmsWfRequestHop.getLmsWftRequestHopRolePageMap().getId());

				if (flows.size() < 1) {
					
					wfRequestFirstHop = lmsWfRequestHop;
					break;
				}
			}
		}*/
		return wfRequestFirstHop;
		
	}
}
