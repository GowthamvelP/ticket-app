package com.gowthamvel.testservice;

import com.gowthamvel.exception.ServiceException;
import com.gowthamvel.model.Employee;
import com.gowthamvel.model.TicketTransaction;
import com.gowthamvel.model.User;
import com.gowthamvel.service.AssignEmployeeService;

public class TestAssignEmployeeService {
	public static void main(String[] args) throws Exception {
		// TicketTransaction tt = new TicketTransaction();
		// Employee em = new Employee();
		// User user = new User();
		// user.setId(1);
		// em.setId(1);
		// tt.setId(1);
		// em.setEmailid("ragav@gmail.com");
		// em.setPassword("ragav");
		// long tiid = tt.getId();
		// long emid = em.getId();
		// long usid = user.getId();
		// String uReply = "DON'T WORRY WE ARE THERE TO HELP YOU";
		// String state = "IN PROGRESS";
		AssignEmployeeService aes = new AssignEmployeeService();
		// aes.saveService(usid, tiid, emid, uReply, state);
		System.out.println(aes.saveService(1, 1));
	}
}
