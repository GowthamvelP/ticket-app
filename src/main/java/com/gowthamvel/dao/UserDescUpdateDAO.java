package com.gowthamvel.dao;

import com.gowthamvel.model.Issue;
import com.gowthamvel.model.TicketTransaction;
import com.gowthamvel.model.User;

public class UserDescUpdateDAO {
	public void check(long uId, String desc, String state) {
		TicketTransactionDAO dao = new TicketTransactionDAO();
		TicketTransaction t = new TicketTransaction();
		User u = new User();
		u.setId(uId);
		t.setUId(u);
		t.setDescription(desc);
		t.setStatus(state);
		dao.updateDesc(t);
	}

	public void newDesc(long id, long iid, String text) {
		TicketTransactionDAO dao = new TicketTransactionDAO();
		TicketTransaction t = new TicketTransaction();
		User u = new User();
		u.setId(iid);
		t.setId(id);
		t.setUId(u);
		t.setStatus(text);
		dao.updateStatus(t);
	}

	public void cleared(long id, String soln) {
		Issue i = new Issue();
		TicketTransaction tid = new TicketTransaction();
		IssueDAO idao = new IssueDAO();
		tid.setId(id);
		i.setTid(tid);
		i.setSolution(soln);
		idao.save(i);

	}

	public void closure(long id, long idd, String text) {
		TicketTransaction ti = new TicketTransaction();
		TicketTransactionDAO dao = new TicketTransactionDAO();
		ti.setId(id);
		User u = new User();
		u.setId(idd);
		ti.setUId(u);
		ti.setStatus(text);
		dao.updateStatus(ti);

	}
}
