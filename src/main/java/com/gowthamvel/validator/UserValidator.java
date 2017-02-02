package com.gowthamvel.validator;

public class UserValidator {
	public void validateSave(String name) throws Exception {
		isInValid(name, " ENTRY");
	}

	public void isInValid(String name, String msg) throws Exception {
		if (name == null || "".equals(name.trim())) {
			throw new Exception("INVALId" + msg);
		}

	}
}
