package com.gowthamvel.testservice;

import com.gowthamvel.exception.ServiceException;
import com.gowthamvel.model.TicketTransaction;
import com.gowthamvel.model.User;
import com.gowthamvel.service.TicketTransactionService;

public class TestTicketTransactionService {
	public static void main(String[] args) throws ServiceException {
		TicketTransaction u = new TicketTransaction();
		User i = new User();
		i.setId(1);
		u.setUId(i);
		u.setPriority("HIGH");
	
		u.setSubject("");
		u.setDescription("Network Adapter is not working properly");
		TicketTransactionService us = new TicketTransactionService();
		us.saveService(u);
		// System.out.println(u);
	}
}