package com.gowthamvel.testdao;

import com.gowthamvel.dao.UserDescUpdateDAO;
import com.gowthamvel.model.Issue;
import com.gowthamvel.model.TicketTransaction;
import com.gowthamvel.model.User;

public class TestUpdateDescDAO {
	public static void main(String[] args) {
		User u = new User();
		u.setId(1);
		long i = u.getId();
		// String msg = "i have a serious problem on my machine";
		// String s = "IN PROGRESS";
		// UserDescUpdateDAO us = new UserDescUpdateDAO();
		// us.check(i, msg, s);
		TicketTransaction t = new TicketTransaction();
		t.setId(1);
		UserDescUpdateDAO us = new UserDescUpdateDAO();
		long id = t.getId();
		// String text = "CLOSED";
		String text = "CLOSED";

		// Issue is = new Issue();
		// is.setSolution("THE REQD FAILURE HAS BEEN INSTALLED");
		// String state = is.getSolution();
		// us.cleared(id, state);
		// us.newDesc(id, i, text);
//		us.closure(id, i, text);
	}

}
