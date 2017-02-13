package com.gowthamvel.testservice;

import com.gowthamvel.exception.ServiceException;
import com.gowthamvel.model.Department;
import com.gowthamvel.service.DepartmentService;

public class TestDepartmentService {
	public static void main(String[] args) throws ServiceException {
		Department u = new Department();
		u.setName("HR");
		DepartmentService us = new DepartmentService();
		us.saveService(u);
	}
}
