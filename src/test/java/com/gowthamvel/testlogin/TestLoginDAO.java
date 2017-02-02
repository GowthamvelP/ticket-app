package com.gowthamvel.testlogin;

import com.gowthamvel.dao.LoginDAO;
import com.gowthamvel.dao.UserDAO;
import com.gowthamvel.model.User;

public class TestLoginDAO {
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		User u = new User();
		u.setEmailid("gvel6989@gmail.com");

		LoginDAO ldao = new LoginDAO();
//		 System.out.println(ldao.check(dao.listByEmailId(u.getEmailid()),
//		 "gvel1234"));

		System.out.println(dao.listByEmailId(u.getEmailid()));

	}
}
