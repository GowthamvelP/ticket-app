package com.gowthamvel.validator;

public class IssueValidator {

	public void validateSave(String name) throws Exception {
		isInValid(name, " ENTRY");
	}

	public void validateSave(long id) throws Exception {
		isInValid(id, " ENTRY");
	}

	public void isInValid(String name, String msg) throws Exception {
		if (name == null || "".equals(name.trim())) {
			throw new Exception("INVALId" + msg);
		}
	}

	public void isInValid(long id, String msg) throws Exception {
		if ("".equals(id) || id <= 0) {
			throw new Exception("INVALId" + msg);
		}

	}
}
