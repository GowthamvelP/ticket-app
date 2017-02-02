package com.gowthamvel.testdao;

import com.gowthamvel.dao.TicketTransactionDAO;
import com.gowthamvel.model.TicketTransaction;

public class TestTicketTransactionDAO {
	public static void main(String[] args) {

		TicketTransactionDAO dao = new TicketTransactionDAO();
		TicketTransaction u = new TicketTransaction();
		dao.save(u);
		u.setId(1);
		dao.update(u);
		dao.delete(1);
		System.out.println(dao.listById(2));
	}
}