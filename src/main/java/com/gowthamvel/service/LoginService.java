package com.gowthamvel.service;

import com.gowthamvel.dao.EmployeeDAO;
import com.gowthamvel.dao.LoginDAO;
import com.gowthamvel.dao.UserDAO;
import com.gowthamvel.exception.PersistenceException;
import com.gowthamvel.model.Employee;
import com.gowthamvel.model.User;

public class LoginService {
	public void test(long uid) throws PersistenceException {
		UserDAO dao = new UserDAO();
		User u = new User();
		u.setId(uid);
		LoginDAO ldao = new LoginDAO();
		if (ldao.check(dao.findPassword(u.getId()).toString(), "ragu"))
			;

	}

	public void testEmp(long uid) throws PersistenceException {
		EmployeeDAO dao = new EmployeeDAO();
		Employee u = new Employee();
		u.setId(1);
		LoginDAO ldao = new LoginDAO();
		ldao.check(dao.findEmailid(u.getId()).toString(), "ragav");

	}

	public void emPassMatch(long i, long j) throws PersistenceException {
		try {
			LoginDAO ldao = new LoginDAO();

			ldao.check(i, j);
		} catch (Exception e) {
			throw new PersistenceException("INVALID ENTRY", e);
		}
	}
}
