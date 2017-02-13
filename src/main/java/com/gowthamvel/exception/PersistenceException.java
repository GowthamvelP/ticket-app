package com.gowthamvel.exception;

public class PersistenceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersistenceException(String name, Throwable msg) {
		super(name, msg);
	}

	public PersistenceException(String name) {
		super(name);
	}

}
