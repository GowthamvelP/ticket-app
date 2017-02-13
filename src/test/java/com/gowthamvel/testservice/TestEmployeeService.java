package com.gowthamvel.testservice;

import com.gowthamvel.exception.ServiceException;
import com.gowthamvel.model.Department;
import com.gowthamvel.model.ERole;
import com.gowthamvel.model.Employee;
import com.gowthamvel.service.EmployeeService;

public class TestEmployeeService {
	public static void main(String[] args) throws ServiceException {
		Employee u = new Employee();

		ERole ee = new ERole();
		ee.setId(1);
		u.setId(ee.getId());
		Department d = new Department();
		d.setId(1);
		u.setId(d.getId());
		u.setName("RAGAV");
		u.setEmailid("ragav@gmail.com");
		u.setPassword("ragav");
		EmployeeService us = new EmployeeService();
		us.saveService(u);
	}
}
