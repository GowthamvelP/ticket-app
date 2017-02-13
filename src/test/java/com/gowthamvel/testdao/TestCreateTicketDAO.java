package com.gowthamvel.testdao;

import com.gowthamvel.dao.CreateTicketDAO;
import com.gowthamvel.exception.PersistenceException;
import com.gowthamvel.model.User;

public class TestCreateTicketDAO {
	public static void main(String[] args) throws PersistenceException {

		CreateTicketDAO dao = new CreateTicketDAO();

		User u = new User();
		u.setId(1);
		long userId = u.getId();
		String type = "HR";
		String subject = "Network Error";
		String description = "Network Adapter is not working properly";
		String priority = "HIGH";
		u.setEmailid("gvel6989@gmail.com");
		u.setPassword("gvel1234");
		String email = u.getEmailid();
		String pwd = u.getPassword();
		// dao.createTicket(email, pwd, userId, type, subject, description,
		// priority);

	}
}
