package com.gowthamvel.model;

import lombok.Data;

@Data
public class Employee {
	private long id;
	private ERole roleId;
	private Department deptId;
	private String name;
	private String emailid;
	private String password;
	private boolean active;

}
