package com.gowthamvel.dao;

public class LoginDAO {
	public boolean check(String o, String password)

	{
		if (o.equals(password))

			return true;
		System.out.println(o);

		return false;

	}
}
