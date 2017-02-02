package com.gowthamvel.testdao;

import com.gowthamvel.dao.EmployeeDAO;
import com.gowthamvel.model.Department;
import com.gowthamvel.model.Employee;

public class TestEmployeeDAO {

	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		Department u = new Department();
		Employee eu = new Employee();
		u.setName("HoR");
		dao.save(eu);
		u.setId(1);
		dao.update(eu);
		dao.delete(1);
		System.out.println(dao.listById(2));
	}
}
