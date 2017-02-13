package com.gowthamvel.testdao;

import com.gowthamvel.dao.AssignEmployeeDAO;
import com.gowthamvel.exception.PersistenceException;
import com.gowthamvel.model.Employee;
import com.gowthamvel.model.TicketTransaction;
import com.gowthamvel.model.User;

public class TestAssignEmployeeDAO {

	public static void main(String[] args) throws PersistenceException {
		TicketTransaction tt = new TicketTransaction();
		Employee em = new Employee();
		User user = new User();
		user.setId(1);
		em.setId(1);
		tt.setId(1);
		em.setEmailid("ragav@gmail.com");
		em.setPassword("ragav");
//		String email = em.getEmailid();
//		String pwd = em.getPassword();
		long tiid = tt.getId();
		long emid = em.getId();
		long usid = user.getId();
		String uReply = "DON'T WORRY WE ARE THERE TO HELP YOU";
		String state = "IN PROGRESS";
		AssignEmployeeDAO aed = new AssignEmployeeDAO();
		aed.assignEmTicket(tiid, emid, usid, uReply, state);
//		aed.newStatus(tiid, usid, state);
//		aed.reassign(emid, tiid, usid);
//		aed.adminDelete(tiid, usid);
	}
}