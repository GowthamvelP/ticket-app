package com.gowthamvel.testdao;

import com.gowthamvel.dao.CreateTicketDAO;
import com.gowthamvel.model.User;

public class TestCreateTicketDAO {
public static void main(String[] args) {
	
	
		CreateTicketDAO dao = new CreateTicketDAO();
	
		User u = new User();
		u.setId(1);
		long userId = u.getId();
		
		String type= "HR";
		String subject = "Network Error";
		String description = "Network Adapter is not working properly";
		String status = "INPROGRESS";
		dao.createTicket(userId,type,subject,description,status);

	}
}
