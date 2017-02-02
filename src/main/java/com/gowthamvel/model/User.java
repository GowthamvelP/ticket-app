package com.gowthamvel.model;

import lombok.Data;

@Data
public class User {

	private long id;
	private String name;
	private String emailid;
	private String password;
	private boolean active;

}
