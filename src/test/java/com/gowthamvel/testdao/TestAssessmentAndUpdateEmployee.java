package com.gowthamvel.testdao;

import com.gowthamvel.dao.AssignAndUpdateEmployeeDAO;
import com.gowthamvel.exception.PersistenceException;
import com.gowthamvel.model.Employee;
import com.gowthamvel.model.TicketTransaction;
import com.gowthamvel.model.User;

public class TestAssessmentAndUpdateEmployee {
	public static void main(String[] args) throws PersistenceException {

		TicketTransaction tt = new TicketTransaction();
		tt.setId(1);
		User u = new User();
		u.setId(1);

		tt.setId(u.getId());
		Employee e = new Employee();
		e.setEmailid("ragav@gmail.com");
		e.setPassword("ragav");
		String email = e.getEmailid();
		String pwd = e.getPassword();
		long id = tt.getId();
		long uid = tt.getUId().getId();
		String msg = "RESOLVED";
		AssignAndUpdateEmployeeDAO un = new AssignAndUpdateEmployeeDAO();
		un.updateStatus(email, pwd, id, uid, msg);
	}
}
