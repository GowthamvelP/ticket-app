package com.gowthamvel.testservice;

import com.gowthamvel.exception.ServiceException;
import com.gowthamvel.model.User;
import com.gowthamvel.service.UserService;

public class TestUserService {
	public static void main(String[] args) throws ServiceException {
		User u = new User();
		u.setId(0);
		u.setName("Gowthamvel");
		u.setEmailid("gvel6989@gmail.com");
		u.setPassword("gvel1234");
		UserService us = new UserService();
		us.saveService(u);
	}
}
