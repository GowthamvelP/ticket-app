package com.gowthamvel.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TicketTransaction {
	private long id;
	private User uId;
	private Employee eId;
	private Department dId;
	private String subject;
	private String description;
	private LocalDate createdDate;
	private LocalDate updatedDate;
	private String status;

}
