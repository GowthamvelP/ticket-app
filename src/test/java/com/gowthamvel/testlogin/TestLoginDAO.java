package com.gowthamvel.testlogin;

import com.gowthamvel.dao.LoginDAO;
import com.gowthamvel.dao.UserDAO;
import com.gowthamvel.exception.PersistenceException;
import com.gowthamvel.model.User;

public class TestLoginDAO {
	public static void main(String[] args) throws PersistenceException {
		UserDAO dao = new UserDAO();
		User u = new User();
		u.setId(1);
		LoginDAO ldao = new LoginDAO();
		System.out.println(ldao.check(dao.findPassword(u.getId()).toString(), "gvel1234"));

		// System.out.println(ldao.check(dao.findEmailId(u.getEmailid()).getPassword(),
		// "gvel1234"));

	}
}
