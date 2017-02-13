package com.gowthamvel.testservice;

import com.gowthamvel.exception.ServiceException;
import com.gowthamvel.model.ERole;
import com.gowthamvel.service.EroleService;

public class TetsEroleService {
	public static void main(String[] args) throws ServiceException {
		ERole u = new ERole();

		u.setName("EXECUTIVE");
		EroleService us = new EroleService();
		us.saveService(u);
	}
}
