package com.gowthamvel.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.gowthamvel.dao.UserDescUpdateDAO;
import com.gowthamvel.exception.ServiceException;
import com.gowthamvel.validator.UserValidator;

public class UserDescUpdateDAOService {
	private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

	UserDescUpdateDAO us = new UserDescUpdateDAO();

	public void descService(long tid, long uid, String desc) throws ServiceException {
		try {
			UserValidator uv = new UserValidator();

			uv.validateSave(tid);
			uv.validateSave(uid);
			uv.validateSave(desc);
			us.check(tid, uid, desc);
		} catch (Exception e) {

			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe("INVALID PARAMETER VALUES");
			throw new ServiceException("CANNOT INSERT INTO TABLE", e);
		}
	}

	public void updateService(long tid, long uid, String desc) throws ServiceException {
		try {
			UserValidator uv = new UserValidator();

			uv.validateSave(tid);
			uv.validateSave(uid);
			uv.validateSave(desc);
			us.closure(tid, uid, desc);
		} catch (Exception e) {

			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe("INVALID PARAMETER VALUES");
			throw new ServiceException("CANNOT INSERT INTO TABLE", e);
		}
	}
}