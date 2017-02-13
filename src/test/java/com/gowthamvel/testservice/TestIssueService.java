package com.gowthamvel.testservice;

import com.gowthamvel.exception.ServiceException;
import com.gowthamvel.model.Issue;
import com.gowthamvel.model.TicketTransaction;
import com.gowthamvel.service.IssueService;

public class TestIssueService {
	public static void main(String[] args) throws ServiceException {
		Issue u = new Issue();
		TicketTransaction tt = new TicketTransaction();
		tt.setId(1);
		u.setTid(tt);
		u.setSolution("RESOLVED");
		IssueService us = new IssueService();
		us.saveService(u);
	}
}
