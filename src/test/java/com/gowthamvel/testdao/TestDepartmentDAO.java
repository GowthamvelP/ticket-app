package com.gowthamvel.testdao;

import com.gowthamvel.dao.DepartmentDAO;
import com.gowthamvel.exception.PersistenceException;
import com.gowthamvel.model.Department;

public class TestDepartmentDAO {
	public static void main(String[] args) throws PersistenceException {

		DepartmentDAO dao = new DepartmentDAO();
		Department u = new Department();
		u.setName("HoR");
		dao.save(u);
		u.setId(1);
		dao.update(u);
		dao.delete(1);
		System.out.println(dao.listById(2));
	}

}