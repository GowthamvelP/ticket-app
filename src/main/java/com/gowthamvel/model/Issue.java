package com.gowthamvel.model;

import lombok.Data;

@Data
public class Issue {
	private long id;
	private TicketTransaction tid;
	private String solution;

}
