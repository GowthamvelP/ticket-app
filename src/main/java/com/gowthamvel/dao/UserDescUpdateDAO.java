package com.gowthamvel.dao;

import com.gowthamvel.exception.PersistenceException;
import com.gowthamvel.model.TicketTransaction;
import com.gowthamvel.model.User;

public class UserDescUpdateDAO {
	public void check(long tid, long uId, String desc) throws PersistenceException {
		TicketTransactionDAO dao = new TicketTransactionDAO();
		TicketTransaction t = new TicketTransaction();
		User u = new User();
		t.setId(tid);
		u.setId(uId);
		t.setUId(u);
		t.setDescription(desc);
		dao.updateDesc(t);
	}

	public void closure(long id, long idd, String text) throws PersistenceException {
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
