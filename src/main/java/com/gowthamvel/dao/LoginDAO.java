package com.gowthamvel.dao;

import com.gowthamvel.exception.PersistenceException;

public class LoginDAO {
	public boolean check(String o, String password)

	{
		if (o.equals(password))
			return true;
		else {
			return false;
		}
	}

	public void check(long i, long j) throws PersistenceException {

		if (i == j){
		} else {
			throw new PersistenceException("INVALID ENTRY");
		}

	}
}
