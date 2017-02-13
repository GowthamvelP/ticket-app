package com.gowthamvel.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TicketTransaction {
	private long id;
	private User uId;
	private String priority;
	private String type;
	private String subject;
	private String description;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	private String status;

}
