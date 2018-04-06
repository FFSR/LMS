package com.web.lms.wfengine;

public class WorkFlowEngine {
	
	public void GenerateWorkRequest() {
		
/*        string logonuser = Session["LogonUser"].ToString();
        string siteName = "";
        if(Session["NewSiteName"]!=null){
            siteName = Session["NewSiteName"].ToString();
        }
        NIMS_USER user = nimsDB.NIMS_USER.Where(a => a.USER_NAME == logonuser).FirstOrDefault();
        string date = System.DateTime.Now.Date.ToString("yyyyMMdd");
        //string date = "";
        string requestNumber = user.DEPARTMENT + "-" + pRequestTemplate.REQUEST_TYPE + "-" + Session["NewSiteName"].ToString() + "-" + date + "-"
            + (pRequestTemplate.NIMS_REQUEST.Count + 1);
        try
        {
            // insert new site into request_site_client table
            IPAPM_SITE_CLIENT iPAPM_SITE_CLIENT = nimsDB.IPAPM_SITE_CLIENT.Where(a=>a.NAME==siteName).FirstOrDefault();
            if (ddlRequestType.SelectedItem.Text == "New BTS" && iPAPM_SITE_CLIENT==null)
            {
                iPAPM_SITE_CLIENT = new IPAPM_SITE_CLIENT();
                iPAPM_SITE_CLIENT.NAME = siteName;
                iPAPM_SITE_CLIENT.TYPE = "Site";
               
                // iPAPM_SITE_CLIENT.ID = 1;

                nimsDB.IPAPM_SITE_CLIENT.Add(iPAPM_SITE_CLIENT);
                
                    nimsDB.SaveChanges();
                                    
                iPAPM_SITE_CLIENT = nimsDB.IPAPM_SITE_CLIENT.Where(a => a.NAME == siteName).FirstOrDefault();
            }

            saveRequest(pRequestTemplate, requestNumber);
            NIMS_REQUEST request = nimsDB.NIMS_REQUEST.Where(a => a.REQUEST_NUMBER == requestNumber).FirstOrDefault();
            saveHops(request, pRequestTemplate);
            nimsDB = new NIMSDB();
            request = nimsDB.NIMS_REQUEST.Where(a => a.REQUEST_NUMBER == requestNumber).FirstOrDefault();
            foreach (NIMS_REQUEST_HOPS iHop in request.NIMS_REQUEST_HOPS)
            {
                List<NIMS_WFT_FLOW> flows = ((IQueryable<NIMS_WFT_FLOW>)nimsDB.NIMS_WFT_FLOW).Where(a => a.HOP == iHop.NIMS_WFT_HOPS.ID && a.ISACTIVE =="1").ToList<NIMS_WFT_FLOW>();
                if (flows.Count < 1)
                {
                    iHop.START_DATE = System.DateTime.Now;
                    iHop.HOP_STATUS = Constants.HOP_STATUS_CURRENT;
                    nimsDB.SaveChanges();
                }
            }

            // insert into request_site_map table
            NIMS_REQUEST_SITE_MAP nIMS_REQUEST_SITE_MAP = new NIMS_REQUEST_SITE_MAP();

            nIMS_REQUEST_SITE_MAP.REQUEST_ID = request.ID;
            nIMS_REQUEST_SITE_MAP.SITE_ID = iPAPM_SITE_CLIENT.ID;

            nimsDB.NIMS_REQUEST_SITE_MAP.Add(nIMS_REQUEST_SITE_MAP);
            nimsDB.SaveChanges();

            lblMessage.Text = "Work Request # " + requestNumber + " has been generated successfully";
        }
        catch (Exception ex)
        {
            lblMessage.Text = ex.ToString()+"\nError during generate Work Request # " + requestNumber;
        }*/
        	
	}
	
	private void FindRequestType() {
		
		
		
	}
	
    private void saveRequest()
    {
    	// NIMS_WFT_REQUEST pRequestTemplate, string pRequestNumber
    	
/*        NIMS_REQUEST nRequest = new NIMS_REQUEST();
        nRequest.REQUEST_NUMBER = pRequestNumber;
        nRequest.REQUEST_STATUS = Constants.REQUEST_STATUS_INPROGRESS;
        nRequest.REQUEST_TYPE = pRequestTemplate.ID;
        nRequest.START_DATE = System.DateTime.Now;
        nRequest.CREATED_BY = eUser.ID;
        nimsDB.NIMS_REQUEST.Add(nRequest);
        nimsDB.SaveChanges();*/
    	
    }
    
    private void saveHops()
    {
    	// NIMS_REQUEST pRequest, NIMS_WFT_REQUEST pRequestTemplate
    	
/*        foreach (NIMS_WFT_HOPS tHop in pRequestTemplate.NIMS_WFT_HOPS)
        {
            saveHop(pRequest, tHop);

        }*/
    	
    }
    
    private void saveHop()
    {
    	
    	// NIMS_REQUEST request, NIMS_WFT_HOPS pTHop

/*        nimsDB = new NIMSDB();
        NIMS_REQUEST_HOPS nHop = new NIMS_REQUEST_HOPS();
        nHop.HOP_ID = pTHop.ID;
        nHop.HOP_STATUS = Constants.HOP_STATUS_UPCOMING;
        nHop.REQUEST_ID = request.ID;
        nimsDB.NIMS_REQUEST_HOPS.Add(nHop);

        nimsDB.SaveChanges();*/
    	
    }
	
	
	public void SubmitWorkRequest() {
		
		
	}
	
	public void RejectWorkRequest() {
		
		
	}
	
	public void RollBackWorkRequest() {
		
		
	}
	
	public static boolean enableSubmit(Integer hopID)
    {
        /*NIMSDB nimsdb = new NIMSDB();

        NIMS_REQUEST_HOPS nIMS_REQUEST_HOPS = (from a in nimsdb.NIMS_REQUEST_HOPS
                                               where a.ID == hopID
                                               select a).FirstOrDefault();
        if (nIMS_REQUEST_HOPS != null)
        {
            nIMS_REQUEST_HOPS.ENABLESUBMIT = "Yes";
            nimsdb.SaveChanges();
            return true;
        }*/
        return false;
    }
	
    public static boolean disableSubmit(Integer hopID)
    {
/*        NIMSDB nimsdb = new NIMSDB();

        NIMS_REQUEST_HOPS nIMS_REQUEST_HOPS = (from a in nimsdb.NIMS_REQUEST_HOPS
                                               where a.ID == hopID
                                               select a).FirstOrDefault();
        if (nIMS_REQUEST_HOPS != null)
        {
            nIMS_REQUEST_HOPS.ENABLESUBMIT = string.Empty;
            nimsdb.SaveChanges();
            return true;
        }*/
        return false;
    }
    
	
	public static boolean isEnableSubmit(Integer hopID)
    {
/*        NIMSDB nimsdb = new NIMSDB();

        NIMS_REQUEST_HOPS nIMS_REQUEST_HOPS = (from a in nimsdb.NIMS_REQUEST_HOPS
                                               where a.ID == hopID
                                               where a.ENABLESUBMIT == "Yes"
                                               select a).FirstOrDefault();
        if (nIMS_REQUEST_HOPS != null)
        {
            return true;
        }*/
        return false;
    }
	
    public static void addDynamicHop(Integer wrno, Integer wftemplateRequestHopID)
    {
/*        NIMSDB nimsdb = new NIMSDB();

        NIMS_REQUEST_HOPS nIMS_REQUEST_HOPS = (from a in nimsdb.NIMS_REQUEST_HOPS
                                               where a.REQUEST_ID == wrno
                                               where a.HOP_ID == wftemplateRequestHopID
                                               select a).FirstOrDefault();
        if (nIMS_REQUEST_HOPS == null)
        {
            nIMS_REQUEST_HOPS = new NIMS_REQUEST_HOPS();
            nIMS_REQUEST_HOPS.REQUEST_ID = wrno;
            nIMS_REQUEST_HOPS.HOP_ID = wftemplateRequestHopID;
            nIMS_REQUEST_HOPS.START_DATE = DateTime.Now;
            nIMS_REQUEST_HOPS.HOP_STATUS = Constants.HOP_STATUS_UPCOMING;
            nimsdb.NIMS_REQUEST_HOPS.Add(nIMS_REQUEST_HOPS);
            nimsdb.SaveChanges();
        }*/
    	
    }
    
    protected boolean updateRequestDoneStatus()
    {
    	// NIMS_REQUEST pRequest
    	
/*        foreach (NIMS_REQUEST_HOPS iHop in pRequest.NIMS_REQUEST_HOPS)
        {
            if (iHop.HOP_STATUS != Constants.HOP_STATUS_DONE)
            {
                return false;
            }
        }
        pRequest.REQUEST_STATUS = Constants.REQUEST_STATUS_DONE;
        pRequest.END_DATE = System.DateTime.Now;

        nimsDB.SaveChanges();*/
        return true;
    }

    protected void updateHopDoneStatus()
    {
    	// NIMS_REQUEST_HOPS pHOP
    	
/*        pHOP.HOP_STATUS = Constants.HOP_STATUS_DONE;
        pHOP.END_DATE = System.DateTime.Now;
        pHOP.SUBMIT_BY = eUser.ID;
        nimsDB.SaveChanges();
        updateHopCurrentStatus(pHOP.NIMS_REQUEST);*/
    	
    }
    
    protected void updateHopCurrentStatus()
    {
    	// NIMS_REQUEST pRequest
    	
/*        if (updateRequestDoneStatus(pRequest)) { return; }

        foreach (NIMS_REQUEST_HOPS iHop in pRequest.NIMS_REQUEST_HOPS)
        {
            if (iHop.HOP_STATUS == Constants.HOP_STATUS_UPCOMING || iHop.HOP_STATUS == null)
            {

                List<NIMS_REQUEST_HOPS> parentHops = new List<NIMS_REQUEST_HOPS>();
                List<NIMS_WFT_FLOW> flows = ((IQueryable<NIMS_WFT_FLOW>)nimsDB.NIMS_WFT_FLOW).Where(a => a.HOP == iHop.NIMS_WFT_HOPS.ID && a.ISACTIVE=="1").ToList<NIMS_WFT_FLOW>();
                if (flows.Count < 1)
                {
                    iHop.START_DATE = System.DateTime.Now;
                    iHop.HOP_STATUS = Constants.HOP_STATUS_CURRENT;
                    nimsDB.SaveChanges();
                }
                else
                {
                    bool parentDone = true;
                    foreach (NIMS_WFT_FLOW flow in flows)
                    {
                        //if(flow.ISACTIVE=="1"){}
                        foreach (NIMS_REQUEST_HOPS parentHop in ((IQueryable<NIMS_REQUEST_HOPS>)nimsDB.NIMS_REQUEST_HOPS).Where(a => a.HOP_ID == flow.DEPENDENT_HOP && a.REQUEST_ID == pRequest.ID && flow.ISACTIVE=="1").ToList<NIMS_REQUEST_HOPS>())
                        {
                            if (parentHop.HOP_STATUS != Constants.HOP_STATUS_DONE)
                            {
                                parentDone = false;
                            }
                        }
                    }
                    if (parentDone)
                    {
                        iHop.START_DATE = System.DateTime.Now;
                        iHop.HOP_STATUS = Constants.HOP_STATUS_CURRENT;
                        nimsDB.SaveChanges();
                    }
                }
            }

        }*/
    	
    }
    
    protected void insertHopHistory()
    {
    	
    	// NIMS_REQUEST_HOPS pHop
    	
/*        NIMS_REQUEST_HOPS_HISTORY eHopHistory = new NIMS_REQUEST_HOPS_HISTORY();
        eHopHistory.COMMENTS = pHop.COMMENTS;
        eHopHistory.END_DATE = pHop.END_DATE;
        eHopHistory.HOP_ID = pHop.HOP_ID;
        eHopHistory.HOP_STATUS = pHop.HOP_STATUS;
        eHopHistory.ID = uniqID;
        eHopHistory.MAIN_ID = pHop.ID;
        eHopHistory.REQUEST_ID = pHop.REQUEST_ID;
        eHopHistory.START_DATE = pHop.START_DATE;
        eHopHistory.SUBMIT_BY = pHop.SUBMIT_BY;
        nimsDB.NIMS_REQUEST_HOPS_HISTORY.Add(eHopHistory);
        nimsDB.SaveChanges();
        uniqID = uniqID + 1;*/
        
    }

    protected void rollBackToHop()
    {
    	
    	//  NIMS_REQUEST_HOPS pHop

    /*    insertHopHistory(pHop);
        pHop.HOP_STATUS = Constants.HOP_STATUS_CURRENT;
        pHop.START_DATE = System.DateTime.Now;
        nimsDB.SaveChanges();
        rollBackChildHops(pHop);
        inserEventLog(nimsDB.NIMS_REQUEST_HOPS.Find(Convert.ToDecimal(ddlHopList.SelectedValue)), pHop, Constants.REQUEST_EVENT_NAME_ROLLBACK);
    */
    	
    }
    
    
    protected void rollBackChildHops()
    {
    	//NIMS_REQUEST_HOPS pHop
    	
/*        foreach (NIMS_WFT_FLOW flow in pHop.NIMS_WFT_HOPS.NIMS_WFT_FLOW1)
        {
            //if (flow.ISACTIVE == "1") { }

            foreach (NIMS_REQUEST_HOPS childHop in ((IQueryable<NIMS_REQUEST_HOPS>)nimsDB.NIMS_REQUEST_HOPS).Where(a => a.HOP_ID == flow.HOP && a.REQUEST_ID == pHop.REQUEST_ID && flow.ISACTIVE == "1").ToList<NIMS_REQUEST_HOPS>())
            {
                if (childHop.HOP_STATUS != Constants.HOP_STATUS_UPCOMING)
                {
                    insertHopHistory(childHop);
                    childHop.START_DATE = null;
                    childHop.HOP_STATUS = Constants.HOP_STATUS_UPCOMING;
                    childHop.ENABLESUBMIT = null;
                    nimsDB.SaveChanges();
                }
                rollBackChildHops(childHop);
            }
        }*/

    }

}
