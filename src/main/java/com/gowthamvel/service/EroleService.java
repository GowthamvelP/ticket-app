package com.gowthamvel.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.gowthamvel.dao.ERoleDAO;
import com.gowthamvel.exception.ServiceException;
import com.gowthamvel.model.ERole;
import com.gowthamvel.validator.EroleValidator;

public class EroleService {
	private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

	public void saveService(ERole u) throws ServiceException {
		try {
			EroleValidator uv = new EroleValidator();
			uv.validateSave(u.getName());
			ERoleDAO ud = new ERoleDAO();
			ud.save(u);
		} catch (Exception e) {

			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe("INVALID PARAMETER VALUES");
			throw new ServiceException("CANNOT INSERT INTO TABLE", e);
		}
	}
}
