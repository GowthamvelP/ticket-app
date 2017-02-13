package com.gowthamvel.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.gowthamvel.dao.UserDAO;
import com.gowthamvel.exception.ServiceException;
import com.gowthamvel.model.User;
import com.gowthamvel.validator.UserValidator;

public class UserService {
	private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

	public void saveService(User u) throws ServiceException {
		try {
			UserValidator uv = new UserValidator();
			uv.validateSave(u.getId());
			uv.validateSave(u.getName());
			uv.validateSave(u.getEmailid());
			uv.validateSave(u.getPassword());
			UserDAO ud = new UserDAO();
			ud.save(u);
		} catch (Exception e) {

			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe("INVALID PARAMETER VALUES");
			throw new ServiceException("CANNOT INSERT INTO TABLE", e);
		}
	}
}
