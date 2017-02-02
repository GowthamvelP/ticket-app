package com.gowthamvel.model;

import java.sql.Date;

import com.gowthamvel.model.Department;
import com.gowthamvel.model.Employee;
import com.gowthamvel.model.User;

import lombok.Data;

@Data
public class TicketTransaction {
	private long id;
	private User uId;
	private Employee eId;
	private Department dId;
	private String subject;
	private String description;
	private Date createdDate;
	private Date updatedDate;
	private String status;

}
