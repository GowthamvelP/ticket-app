package com.gowthamvel.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gowthamvel.dao.AssignEmployeeDAO;
import com.gowthamvel.dao.EmployeeTicketDAO;
import com.gowthamvel.exception.ServiceException;
import com.gowthamvel.model.EmployeeTicket;
import com.gowthamvel.validator.AssignEmployeeValidator;

public class AssignEmployeeService {
	private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

	public void saveService(long userId, long tid, long eid, String uReply, String state) throws ServiceException {
		try {
			AssignEmployeeValidator aev = new AssignEmployeeValidator();
			aev.validateSave(state);
			aev.validateSave(uReply);
			aev.validateSave(userId);
			aev.validateSave(tid);
			aev.validateSave(eid);
			AssignEmployeeDAO aed = new AssignEmployeeDAO();
			aed.assignEmTicket(userId, tid, eid, uReply, state);
			// aed.newStatus(tid, userId, state);
			// aed.reassign(eid, tid, userId);
			// aed.adminDelete(tid, userId);
		} catch (Exception e) {
			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe("INVALID PARAMETER VALUES");
			throw new ServiceException("CANNOT INSERT INTO TABLE", e);
		}
	}

	public void saveService(long uid, long tid, String soln, String status) throws ServiceException {
		try {
			AssignEmployeeValidator aev = new AssignEmployeeValidator();
			aev.validateSave(tid);
			aev.validateSave(soln);
			aev.validateSave(uid);
			AssignEmployeeDAO aed = new AssignEmployeeDAO();
			aed.cleared(tid, status);
			aed.newStatus(uid, tid, soln);
		} catch (Exception e) {
			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe("INVALID PARAMETER VALUES");
			throw new ServiceException("CANNOT INSERT INTO TABLE", e);
		}
	}

	public void saveService(long tid) throws ServiceException {
		try {
			AssignEmployeeValidator aev = new AssignEmployeeValidator();
			aev.validateSave(tid);
			AssignEmployeeDAO aed = new AssignEmployeeDAO();
			aed.adminDelete(tid);
		} catch (Exception e) {
			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe("INVALID PARAMETER VALUES");
			throw new ServiceException("CANNOT INSERT INTO TABLE", e);
		}

	}

	public List<EmployeeTicket> saveService(long eid, long uid) throws Exception {
		AssignEmployeeValidator aev = new AssignEmployeeValidator();
		aev.validateSave(eid);
		aev.validateSave(uid);
		EmployeeTicketDAO et = new EmployeeTicketDAO();
		return et.listById(eid, uid);

	}
}