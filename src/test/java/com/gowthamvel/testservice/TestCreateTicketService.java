package com.gowthamvel.testservice;

import com.gowthamvel.exception.ServiceException;
import com.gowthamvel.model.TicketTransaction;
import com.gowthamvel.model.User;
import com.gowthamvel.service.CreateTicketService;

public class TestCreateTicketService {
	public static void main(String[] args) throws ServiceException {
		User u = new User();
		u.setName("Gowthamvel");
		u.setEmailid("gvel6989@gmail.com");
		u.setPassword("gvel1234");
		String n = u.getName();
		String e = u.getEmailid();
		String p = u.getPassword();
		TicketTransaction tt = new TicketTransaction();
		tt.setType("HR");
		u.setId(1);
		tt.setUId(u);
		tt.setSubject("Network error");
		tt.setDescription("Network failure has been  encountered in my device so that i get to come to you");
		tt.setPriority("HIGH");
		String ty = tt.getType();
		long uid = tt.getUId().getId();
		String sub = tt.getSubject();
		String desc = tt.getDescription();
		String pr = tt.getPriority();
		CreateTicketService us = new CreateTicketService();
		//us.saveService(n, e, p, uid, ty, sub, desc, pr);
	}
}
