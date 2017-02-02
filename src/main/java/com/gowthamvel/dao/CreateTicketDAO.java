package com.gowthamvel.dao;

import com.gowthamvel.model.Employee;
import com.gowthamvel.model.TicketTransaction;
import com.gowthamvel.model.User;

public class CreateTicketDAO {

	public void createTicket(long userId, String type, String subject, String description, String status) {
		TicketTransactionDAO tdao = new TicketTransactionDAO();
		TicketTransaction t = new TicketTransaction();
		User u = new User();
		u.setId(userId);
		t.setUId(u);
		Employee e = new Employee();
		e.setId(1);
		t.setEId(e);
		DepartmentDAO d = new DepartmentDAO();
		t.setDId(d.listByName(type));
		t.setSubject(subject);
		t.setDescription(description);
		tdao.save(t);
	}
}
