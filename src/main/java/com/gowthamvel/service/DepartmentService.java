package com.gowthamvel.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.gowthamvel.dao.DepartmentDAO;
import com.gowthamvel.exception.ServiceException;
import com.gowthamvel.model.Department;
import com.gowthamvel.validator.DepartmentValidator;

public class DepartmentService {
	private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

	public void saveService(Department u) throws ServiceException {
		try {
			DepartmentValidator uv = new DepartmentValidator();
			uv.validateSave(u.getName());
			DepartmentDAO ud = new DepartmentDAO();
			ud.save(u);
		} catch (Exception e) {

			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe("INVALID PARAMETER VALUES");
			throw new ServiceException("CANNOT INSERT INTO TABLE", e);
		}
	}
}
