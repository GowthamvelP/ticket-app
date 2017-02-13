package com.gowthamvel.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.gowthamvel.dao.TicketTransactionDAO;
import com.gowthamvel.exception.ServiceException;
import com.gowthamvel.model.TicketTransaction;
import com.gowthamvel.validator.TicketTransactionValidator;

public class TicketTransactionService {
	private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

	public void saveService(TicketTransaction tt) throws ServiceException {
		try {
			TicketTransactionValidator uv = new TicketTransactionValidator();

			uv.validateSave(tt.getUId().getId());
			uv.validateSave(tt.getPriority());
			uv.validateSave(tt.getSubject());
			uv.validateSave(tt.getDescription());
			TicketTransactionDAO ud = new TicketTransactionDAO();
			ud.save(tt);
		} catch (Exception e) {

			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe("INVALID PARAMETER VALUES");
			throw new ServiceException("CANNOT INSERT INTO TABLE", e);
		}
	}
}
