package com.gowthamvel.testdao;

import com.gowthamvel.dao.ERoleDAO;
import com.gowthamvel.model.ERole;

public class TestERoleDAO {
	public static void main(String[] args) {
		ERoleDAO erd = new ERoleDAO();
		ERole er = new ERole();
		er.setName("manager");
		erd.save(er);

	}
}
