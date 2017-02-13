package com.gowthamvel.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gowthamvel.dao.CreateTicketDAO;
import com.gowthamvel.exception.ServiceException;
import com.gowthamvel.model.TicketTransaction;
import com.gowthamvel.validator.CreateTicketValidator;

public class CreateTicketService {
	private static final Logger LOGGER = Logger.getLogger(CreateTicketService.class.getName());

	public void saveService(String n, String e, String p)
			/*
			 * , long userId, String type, String subject, String description,
			 * String priority
			 */ throws ServiceException {
		try {
			CreateTicketValidator uv = new CreateTicketValidator();
			uv.validateSave(n);
			uv.validateSave(e);
			uv.validateSave(p);
			CreateTicketDAO ud = new CreateTicketDAO();
			ud.register(n, e, p);

			// ud.createTicket(e, p, userId, type, subject, description,
			// priority);
		} catch (Exception er) {
			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe("INVALID PARAMETER VALUES");
			throw new ServiceException("CANNOT INSERT INTO TABLE", er);
		}
	}

	public void saveService(long userId, String type, String subject, String description, String priority)
			throws ServiceException

	{
		try {
			CreateTicketValidator uv = new CreateTicketValidator();
			uv.validateSave(userId);
			uv.validateSave(type);
			uv.validateSave(subject);
			uv.validateSave(description);
			uv.validateSave(priority);
			CreateTicketDAO ud = new CreateTicketDAO();
			ud.createTicket(userId, type, subject, description, priority);

		} catch (Exception er) {
			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe("INVALID PARAMETER VALUES");
			throw new ServiceException("CANNOT INSERT INTO TABLE", er);
		}

	}

	public List<TicketTransaction>  saveService(long uid) throws ServiceException {
		try {
			CreateTicketValidator uv = new CreateTicketValidator();
			uv.validateSave(uid);
			CreateTicketDAO ud = new CreateTicketDAO();
			return ud.details(uid);

		} catch (Exception er) {
			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe("INVALID PARAMETER VALUES");
			throw new ServiceException("CANNOT INSERT INTO TABLE", er);
		}

	}
}