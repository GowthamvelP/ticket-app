package com.gowthamvel.model;

import lombok.Data;

@Data
public class EmployeeTicket {
	private long id;
	private TicketTransaction ticket;
	private Employee eId;
	private User uId;
	private String reply;
}
