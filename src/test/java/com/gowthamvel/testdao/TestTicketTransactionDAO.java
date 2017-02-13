package com.gowthamvel.testdao;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.gowthamvel.dao.TicketTransactionDAO;
import com.gowthamvel.exception.PersistenceException;
import com.gowthamvel.model.TicketTransaction;
import com.gowthamvel.model.User;

public class TestTicketTransactionDAO {
	public static void main(String[] args) throws PersistenceException {

//		TicketTransactionDAO dao = new TicketTransactionDAO();
//		TicketTransaction u = new TicketTransaction();
//
//		User us = new User();
//		us.setId(1);
//		u.setUId(us);
//		u.setPriority("HIGH");
//		u.setSubject("sample");
//		u.setDescription("Sample test");
//		dao.update(u);
//		dao.delete(1);
//		System.out.println(dao.listById(2));
//		dao.save(u);

		
		System.out.println(LocalDateTime.now());
		

	}
}