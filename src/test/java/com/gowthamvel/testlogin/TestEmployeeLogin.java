package com.gowthamvel.testlogin;

import com.gowthamvel.dao.EmployeeDAO;
import com.gowthamvel.dao.LoginDAO;
import com.gowthamvel.exception.PersistenceException;
import com.gowthamvel.model.Employee;

public class TestEmployeeLogin {
	public static void main(String[] args) throws PersistenceException {
		EmployeeDAO dao = new EmployeeDAO();
		Employee u = new Employee();
		u.setId(1);
		LoginDAO ldao = new LoginDAO();
		System.out.println(ldao.check(dao.findEmailid(u.getId()).toString(), "ragav"));

	}
}
