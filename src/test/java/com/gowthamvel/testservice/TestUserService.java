package com.gowthamvel.testservice;

import com.gowthamvel.exception.ServiceException;
import com.gowthamvel.model.User;
import com.gowthamvel.service.UserService;

public class TestUserService {
	public static void main(String[] args) throws ServiceException {
		User u = new User();
		u.setName("ghgh");
		u.setEmailid("hhj");
		u.setPassword("sfv");

		UserService us = new UserService();
		us.saveService(u);
	}
}
