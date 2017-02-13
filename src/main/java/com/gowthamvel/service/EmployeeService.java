package com.gowthamvel.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.gowthamvel.dao.EmployeeDAO;
import com.gowthamvel.exception.ServiceException;
import com.gowthamvel.model.Employee;
import com.gowthamvel.validator.EmployeeValidator;

public class EmployeeService {
	private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

	public void saveService(Employee u) throws ServiceException {
		try {
			EmployeeValidator uv = new EmployeeValidator();
			uv.validateSave(u.getRoleId().getId());
			uv.validateSave(u.getDeptId().getId());
			uv.validateSave(u.getName());
			uv.validateSave(u.getEmailid());
			uv.validateSave(u.getPassword());
			EmployeeDAO ud = new EmployeeDAO();
			ud.save(u);
		} catch (Exception e) {

			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe("INVALID PARAMETER VALUES");
			throw new ServiceException("CANNOT INSERT INTO TABLE", e);
		}
	}
}
