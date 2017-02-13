package com.gowthamvel.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.gowthamvel.dao.IssueDAO;
import com.gowthamvel.exception.ServiceException;
import com.gowthamvel.model.Issue;
import com.gowthamvel.validator.IssueValidator;

public class IssueService {
	private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

	public void saveService(Issue u) throws ServiceException {
		try {
			IssueValidator uv = new IssueValidator();
			uv.validateSave(u.getSolution());
			IssueDAO ud = new IssueDAO();
			ud.save(u);
		} catch (Exception e) {

			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe("INVALID PARAMETER VALUES");
			throw new ServiceException("CANNOT INSERT INTO TABLE", e);
		}
	}
}
