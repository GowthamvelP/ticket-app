package com.gowthamvel.testdao;

import com.gowthamvel.exception.ServiceException;
import com.gowthamvel.service.CreateTicketService;

public class TestList {
	public static void main(String[] args) throws ServiceException {
		CreateTicketService cts = new CreateTicketService();
		System.out.println(cts.saveService(1));

	}
}
