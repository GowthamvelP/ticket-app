package com.gowthamvel.testdao;

import com.gowthamvel.dao.IssueDAO;
import com.gowthamvel.model.Issue;
import com.gowthamvel.model.TicketTransaction;

public class TestIssueDAO {
	public static void main(String[] args) {
		Issue i = new Issue();
		IssueDAO DAO = new IssueDAO();
		TicketTransaction tt = new TicketTransaction();
		tt.setId(1);
		i.setTid(tt);
		i.setSolution("U Have an error in the system");
		DAO.save(i);

	}
}
